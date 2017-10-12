package kr.or.gobooke.orders.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.common.exception.MallException;
import kr.or.gobooke.common.web.OrdersParams;
import kr.or.gobooke.orders.domain.Orders;

/**
 * 주문 데이터베이스 처리 인터페이스
 * 
 * @author Park Joo-Yeon
 *
 */
public class JdbcOrdersDao implements OrdersDao {

	private DataSource dataSource;

	/** 생성자 */
	public JdbcOrdersDao() {
	}

	public JdbcOrdersDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/** Setter */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	/** 주문등록 */
	public int create(Orders order) {
		Connection con = null;
		PreparedStatement pstmt = null;

		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO orders (order_no,  ");
		sb.append("						order_totalprice,  ");
		sb.append("						order_user_name,  ");
		sb.append("						order_address,  ");
		sb.append("						order_address_detail,  ");
		sb.append("						order_message,  ");
		sb.append("						order_telephone,  ");
		sb.append("						user_id)  ");
		sb.append("VALUES (order_no_seq.nextval,  ");
		sb.append("			?, ?, ?, ?, ?, ?, ?) ");

		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sb.toString());

			pstmt.setInt(1, order.getTotalprice());
			pstmt.setString(2, order.getUserName());
			pstmt.setString(3, order.getAddress());
			pstmt.setString(4, order.getAddressDetail());
			pstmt.setString(5, order.getMessage());
			pstmt.setString(6, order.getTelephone());
			pstmt.setString(7, order.getUserId());

			pstmt.executeUpdate();
			System.out.println("Order Create Complated");

			con.commit();

			return searchOrderNo(order);

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (SQLException e1) {
				}
			}

			throw new MallException("JdbcOrdersDao.create 실행중 예외 발생", e);
		}
	}

	@Override
	/** 주문번호 조회 */
	public int searchOrderNo(Orders order) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int orderNo = 0;
		
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT 	order_no_seq.nextval AS val ");
		sb.append("FROM  dual ");

		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				orderNo = rs.getInt("val") - 1;
			}

		} catch (Exception e) {
			throw new RuntimeException("JdbcOrderDao.searchOrderNo Error!");

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}

		return orderNo;
	}
	
	
	@Override
	public List<Orders> listByParams(OrdersParams params) {
		List<Orders> list = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ORDER_NO, ");
		sb.append("       ORDER_TOTALPRICE ,");
		sb.append("       ORDER_USER_NAME, ");
		sb.append("       ORDER_ADDRESS, ");
		sb.append("       ORDER_ADDRESS_DETAIL, ");
		sb.append("       ORDER_MESSAGE, ");
		sb.append("       ORDER_TELEPHONE, ");
		sb.append("       USER_ID, ");
		sb.append("       ORDER_DATE ");
		sb.append("FROM   (SELECT Ceil(rownum / ?) request_page, ");
		sb.append("               ORDER_NO, ");
		sb.append("               ORDER_TOTALPRICE, ");
		sb.append("               ORDER_USER_NAME, ");
		sb.append("               ORDER_ADDRESS, ");
		sb.append("               ORDER_ADDRESS_DETAIL, ");
		sb.append("               ORDER_MESSAGE, ");
		sb.append("               ORDER_TELEPHONE, ");
		sb.append("               USER_ID, ");
		sb.append("               To_char(ORDER_DATE, 'YYYY-MM-DD') ORDER_DATE ");
		sb.append("        FROM   (SELECT ORDER_NO, ");
		sb.append("                       ORDER_TOTALPRICE, ");
		sb.append("                       ORDER_USER_NAME, ");
		sb.append("                       ORDER_ADDRESS, ");
		sb.append("                       ORDER_ADDRESS_DETAIL, ");
		sb.append("                       ORDER_MESSAGE, ");
		sb.append("                       ORDER_TELEPHONE, ");
		sb.append("                       USER_ID, ");
		sb.append("                       ORDER_DATE ");
		sb.append("                FROM   ORDERS  ");

		// 검색 유형별 WHERE 절 동적 추가
		String type = params.getType();
		String value = params.getValue();
		String startDate = params.getDateStart();
		String endDate = params.getDateEnd();
		
		if (type != null) {
			switch (type) {
			case "userID":
				sb.append(" WHERE USER_ID = ? ");
				break;
			}
			
			if(startDate != null && endDate != null) {
				sb.append(" AND ORDER_DATE  >= to_date( ? , 'YY/MM/DD') and ORDER_DATE  <= to_date( ? , 'YY/MM/DD HH24:MI:SS')");
				
			}
			
		}else {
			if(startDate != null && endDate != null) {
				sb.append(" where ORDER_DATE  >= to_date( ? , 'YY/MM/DD') and ORDER_DATE  <= to_date( ? , 'YY/MM/DD HH24:MI:SS')");
				
			}
		}
		
		
		sb.append("                ORDER  BY ORDER_DATE DESC))");
		sb.append("WHERE  request_page = ?");

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, params.getPageSize());

			if (type != null) {
				pstmt.setString(2, value);
				
				if(startDate != null && endDate != null) {
					pstmt.setString(3, params.getDateStart());
					String end = params.getDateEnd() + " 23:59:59";
					pstmt.setString(4, end);
					pstmt.setInt(5, params.getPage());
				}else {
					pstmt.setInt(3, params.getPage());
				}
			}else {
				if(startDate != null && endDate != null) {
					pstmt.setString(2, params.getDateStart());
					String end = params.getDateEnd() + " 23:59:59";
					pstmt.setString(3, end);
					pstmt.setInt(4, params.getPage());
				}else {
					pstmt.setInt(2, params.getPage());
				}
			}
			
			rs = pstmt.executeQuery();
			list = new ArrayList<Orders>();

			while (rs.next()) {
				Orders order = createOrder(rs);
				list.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcOrder.listByParams(OrderParams params) 실행 중 예외발생", e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return list;
	}
	
	public Orders createOrder(ResultSet rs) throws SQLException{
		Orders order = null;
		
		int no = rs.getInt("ORDER_NO");
		int totalprice = rs.getInt("ORDER_TOTALPRICE");
		String userName = rs.getString("ORDER_USER_NAME");
		String address = rs.getString("ORDER_ADDRESS");
		String addressDetail = rs.getString("ORDER_ADDRESS_DETAIL");
		String message = rs.getString("ORDER_MESSAGE");
		String telephone = rs.getString("ORDER_TELEPHONE");
		String userId = rs.getString("USER_ID");
		String date = rs.getString("ORDER_DATE");

		order = new Orders(no, totalprice, userName, date, address, addressDetail, message, telephone, userId);

		return order;
	}
	
	@Override
	public int pageCount(OrdersParams params) {
		int count = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT COUNT(ORDER_NO) count");
		sb.append(" FROM   ORDERS");

		// 검색 유형별 WHERE 절 동적 추가
		String type = params.getType();
		String value = params.getValue();
		String startDate = params.getDateStart();
		String endDate = params.getDateEnd();
		
		if (type != null) {
			switch (type) {
			case "userID":
				sb.append(" WHERE USER_ID = ? ");
				break;
			}
			
			if(startDate != null && endDate != null) {
				sb.append(" AND ORDER_DATE BETWEEN ? AND ? ");
			}
			
		}else {
			if(startDate != null && endDate != null) {
				sb.append(" WHERE ORDER_DATE BETWEEN ? AND ? ");
			}
		}
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			
			// 전체검색이 아닌경우 경우
			if (type != null) {
				pstmt.setString(1, value);
				
				if(startDate != null && endDate != null) {
					pstmt.setString(2, startDate);
					pstmt.setString(3, endDate);
				}
			}else {
				if(startDate != null && endDate != null) {
					pstmt.setString(1, startDate);
					pstmt.setString(2, endDate);
				}
			}

			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcOrder.pageCount(OrderParams params) 실행 중 예외발생", e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		
		return count;
	}

	// 단위테스트
	public static void main(String[] args) {
		OrdersDao ordersDao = (OrdersDao) DaoFactory.getInstance().getDao(JdbcOrdersDao.class);

		Orders order = new Orders(20000, "박주연", "서울특별시", "신대방1동", "집앞에 놔주세요", "010-1234-5678", "joo");
		int no = ordersDao.create(order);
		System.out.println("no:"+no);
	}

	
}
