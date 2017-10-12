package kr.or.gobooke.ordersList.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import kr.or.gobooke.cart.domain.Cart;
import kr.or.gobooke.common.exception.MallException;
import kr.or.gobooke.ordersList.domain.OrderList;

public class JdbcOrderListDao implements OrderListDao {
	
	private DataSource dataSource;
	
	/** 생성자 */
	public JdbcOrderListDao() {}
	
	public JdbcOrderListDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/** Setter */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	/** 주문항목 추가 */
	public void create(int orderNo, Cart cart, int bookPrice) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO OrderList (orderlist_no,  ");
		sb.append("						orderlist_qty,   ");
		sb.append("						orderlist_price,  ");
		sb.append("						order_no,  ");
		sb.append("						book_no)  ");
		sb.append("VALUES (orderlist_no_seq.nextval,  ");
		sb.append("			?, ?, ?, ?) ");
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sb.toString());

			pstmt.setInt(1, cart.getCartBookQty());
			pstmt.setInt(2, bookPrice);
			pstmt.setInt(3, orderNo);
			pstmt.setInt(4, cart.getBookNo());
			
			pstmt.executeUpdate();
			System.out.println("OrderList Create Complated");
			
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
			}finally {
				try {
					if (pstmt != null) pstmt.close();
					if (con != null) con.close();
				} catch (SQLException e1) {
				}
			}

			throw new MallException("JdbcOrdersDao.create 실행중 예외 발생", e);
		}
	}

	@Override
	/** 주문항목 조회 */
	public List<OrderList> search(int orderNo){
		return null;
	}
	
	

}
