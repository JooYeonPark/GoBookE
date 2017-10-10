package kr.or.gobooke.ownerorder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.gobooke.common.exception.MallException;
import kr.or.gobooke.common.web.OwnerOrderParams;
import kr.or.gobooke.common.web.Params;
import kr.or.gobooke.ownerorder.domain.OwnerOrder;

/**
 * JDBC API를 이용한 OwnerOrder 테이블 관련 영속성 처리 DAO 클래스 DAO 패턴 적용
 * 
 * @author 김수진
 */
public class JdbcOwnerOrderDao implements OwnerOrderDao {

	private DataSource dataSource;

	public JdbcOwnerOrderDao() {
	}

	public JdbcOwnerOrderDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(OwnerOrder ownerOrder) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = " INSERT INTO owner_order " + "            (owner_order_no, "
				+ "             owner_order_publisher, " + "             owner_order_bookname,  "
				+ "             owner_order_qty,  " + "             owner_order_totalprice,  "
				+ "             user_id)  " + " VALUES     (owner_order_no_seq.nextval,  " + 
				"            ?,  " + // 출판사
				"            ?, " + // 책제목
				"            ?,  " + // 수량
				"            ?,  " + // 총가격
				"            'bangry11' ) "; // 관리자 아이디 - 나중에 로그인 아이디 받아오기.
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ownerOrder.getPublisher());
			pstmt.setString(2, ownerOrder.getBookName());
			pstmt.setInt(3, ownerOrder.getQty());
			pstmt.setInt(4, ownerOrder.getTotalPrice());
			pstmt.executeUpdate();

			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
			}

			throw new MallException("JdbcUserDao.create(User) 실행중 예외 발생", e);

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public List<OwnerOrder> listByParams(OwnerOrderParams params) {
		List<OwnerOrder> list = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT OWNER_ORDER_NO, ");
		sb.append("       OWNER_ORDER_PUBLISHER, ");
		sb.append("       OWNER_ORDER_BOOKNAME ,");
		sb.append("       OWNER_ORDER_QTY, ");
		sb.append("       OWNER_ORDER_TOTALPRICE, ");
		sb.append("       USER_ID, ");
		sb.append("       OWNER_ORDER_DATE ");
		sb.append("FROM   (SELECT Ceil(rownum / ?) request_page, ");
		sb.append("               OWNER_ORDER_NO, ");
		sb.append("               OWNER_ORDER_PUBLISHER, ");
		sb.append("               OWNER_ORDER_BOOKNAME, ");
		sb.append("               OWNER_ORDER_QTY, ");
		sb.append("               OWNER_ORDER_TOTALPRICE, ");
		sb.append("               USER_ID, ");
		sb.append("               OWNER_ORDER_DATE ");
		sb.append("        FROM   (SELECT OWNER_ORDER_NO, ");
		sb.append("                       OWNER_ORDER_PUBLISHER, ");
		sb.append("                       OWNER_ORDER_BOOKNAME, ");
		sb.append("                       OWNER_ORDER_QTY, ");
		sb.append("                       OWNER_ORDER_TOTALPRICE, ");
		sb.append("                       USER_ID, ");
		sb.append("                       To_char(OWNER_ORDER_DATE, 'YYYY/MM/DD') OWNER_ORDER_DATE ");
		sb.append("                FROM   OWNER_ORDER  ");

		// 검색 유형별 WHERE 절 동적 추가
		String type = params.getType();
		String value = params.getValue();
		if (type != null) {
			switch (params.getType()) {
			case "date":
				sb.append(" WHERE OWNER_ORDER_DATE BETWEEN ? AND ? ");
				break;
			}
		}
		sb.append("                ORDER  BY OWNER_ORDER_DATE DESC))");
		sb.append("WHERE  request_page = ?");

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, params.getPageSize());

			// 전체검색이 아닌경우 경우
			if (type != null) {
				pstmt.setString(2, params.getDateStart());
				pstmt.setString(3, params.getDateEnd());
				pstmt.setInt(4, params.getPage());
			} else {// 전체검색인 경우
				pstmt.setInt(2, params.getPage());
			}

			rs = pstmt.executeQuery();
			list = new ArrayList<OwnerOrder>();

			while (rs.next()) {
				OwnerOrder order = createOwnerOrder(rs);
				list.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcOwnerOrder.listByParams(OwnerOrderParams params) 실행 중 예외발생", e);
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

	@Override
	public OwnerOrder createOwnerOrder(ResultSet rs) throws SQLException {
		OwnerOrder order = null;
		int no = rs.getInt("OWNER_ORDER_NO");
		String bookName = rs.getString("OWNER_ORDER_BOOKNAME");
		String publisher = rs.getString("OWNER_ORDER_PUBLISHER");
		int totalPrice = rs.getInt("OWNER_ORDER_TOTALPRICE");
		int qty = rs.getInt("OWNER_ORDER_QTY");
		String user_id = rs.getString("USER_ID");
		String date = rs.getString("OWNER_ORDER_DATE");

		order = new OwnerOrder(no, publisher, qty, bookName, totalPrice, date, user_id);

		return order;
	}

	@Override
	public int pageCount(OwnerOrderParams params) {
		int count = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT COUNT(OWNER_ORDER_NO) count");
		sb.append(" FROM   OWNER_ORDER");

		// 검색 유형별 WHERE 절 동적 추가
		String type = params.getType();
		String value = params.getValue();
		if (type != null) {
			switch (params.getType()) {
			case "date":
				sb.append(" WHERE OWNER_ORDER_DATE BETWEEN ? AND ? ");
				break;
			}
		}
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			// 전체검색이 아닌경우 경우
			if (type != null) {
				if(type.equals("date")) {
					pstmt.setString(1, params.getDateStart());
					pstmt.setString(2, params.getDateEnd());
				}else {
					pstmt.setString(1, value);
				}
			}

			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcOwnerOrder.pageCount(OwnerOrderParams params) 실행 중 예외발생", e);
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

}
