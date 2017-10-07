package kr.or.gobooke.orders.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.gobooke.cart.dao.CartDao;
import kr.or.gobooke.cart.dao.JdbcCartDao;
import kr.or.gobooke.cart.domain.CartList;
import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.common.exception.MallException;
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
	/** 주문조회 */
	public Orders search(Orders no) {
		return null;
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
	/** 주문 기간별 조회 */
	public List<Orders> search(String userId, String startDate, String endDate) {
		return null;
	}

	// 단위테스트
	public static void main(String[] args) {
		OrdersDao ordersDao = (OrdersDao) DaoFactory.getInstance().getDao(JdbcOrdersDao.class);

		Orders order = new Orders(20000, "박주연", "서울특별시", "신대방1동", "집앞에 놔주세요", "010-1234-5678", "joo");
		int no = ordersDao.create(order);
		System.out.println("no:"+no);
	}
}
