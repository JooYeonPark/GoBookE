package kr.or.gobooke.cart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.gobooke.cart.domain.Cart;
import kr.or.gobooke.cart.domain.CartList;
import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.common.exception.MallException;
import kr.or.gobooke.common.web.Params;


/**
 * JDBC API를 이용한 사용자(users) 테이블 관련 영속성 처리 DAO 클래스
 * DAO 패턴 적용
 * 
 * @author 박주연
 */
public class JdbcCartDao implements CartDao{
	
private DataSource dataSource;
	
	public JdbcCartDao() {}
	
	public JdbcCartDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	@Override
	public void create(Cart cart) {
		Connection con = null;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		
		sb.append(" INSERT INTO cart(cart_no,    ");
		sb.append(" 				 cart_book_qty,  ");
		sb.append(" 				 user_id,  ");
		sb.append(" 				 book_no)  ");
		sb.append(" VALUES(cart_no_seq.nextval, ?, ?, ?)");
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setInt(1, cart.getCartBookQty());
			pstmt.setString(2, cart.getUserId());
			pstmt.setInt(3, cart.getBookNo());
			
			pstmt.executeUpdate();
			System.out.println("Cart Create Complated");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcCartDao.create 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
	}

	@Override
	public List<CartList> listAll(String userId) {
		List<CartList> cartList;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT 	book_image, ");
		sb.append("			book_title, " );
		sb.append("			cart_book_qty, ");
		sb.append("			book_price, ");
		sb.append("			cart_no ");
		sb.append("FROM book, cart ");
		sb.append("WHERE book.book_no = cart.book_no ");
		sb.append("		AND user_id = ?");
		sb.append("ORDER BY cart_no DESC ");
		
		
		try {	
			connection = dataSource.getConnection();		
			pstmt = connection.prepareStatement(sb.toString());
			
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			cartList = new ArrayList<CartList>();
			
			while(rs.next()) {
				int totalPrice = rs.getInt("cart_book_qty") * rs.getInt("book_price");
			
				cartList.add(new CartList(rs.getInt("cart_no"), rs.getString("book_image"),rs.getString("book_title"),
						rs.getInt("cart_book_qty"), rs.getInt("book_price"), totalPrice));
			}
				
		}	catch(Exception e) {
			throw new RuntimeException("JdbcCartDao.ListAll Error!");
			
		}	finally {
			if(rs != null)
				try { rs.close(); } catch (SQLException e) {}
			if(pstmt != null) 	
				try { pstmt.close(); } catch (SQLException e) {}
			if(connection != null) 	
				try { connection.close(); } catch (SQLException e) {}
		}
		
		return cartList;
	}
	
	
	
	
	@Override
	/** 카트리스트 부분 조회 */
	public List<CartList> listSome(String userId, int[] cartNoList){
		List<CartList> cartList;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT 	book_image, ");
		sb.append("			book_title, " );
		sb.append("			cart_book_qty, ");
		sb.append("			book_price, ");
		sb.append("			cart_no ");
		sb.append("FROM book, cart ");
		sb.append("WHERE book.book_no = cart.book_no  ");
		sb.append("		 AND cart_no = ?");
		
		try {	
			connection = dataSource.getConnection();		
			pstmt = connection.prepareStatement(sb.toString());
			cartList = new ArrayList<CartList>();
			
			for (int no : cartNoList) {
				pstmt.setInt(1, no);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
					int totalPrice = rs.getInt("cart_book_qty") * rs.getInt("book_price");
				
					cartList.add(new CartList(rs.getInt("cart_no"), rs.getString("book_image"),rs.getString("book_title"),
							rs.getInt("cart_book_qty"), rs.getInt("book_price"), totalPrice));
				}
			}
			
				
		}	catch(Exception e) {
			throw new RuntimeException("JdbcCartDao.ListSome Error!");
			
		}	finally {
			if(rs != null)
				try { rs.close(); } catch (SQLException e) {}
			if(pstmt != null) 	
				try { pstmt.close(); } catch (SQLException e) {}
			if(connection != null) 	
				try { connection.close(); } catch (SQLException e) {}
		}
		
		return cartList;
	}
	
	
	@Override
	public void update(String userId, String bookTitle, int qty) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		StringBuilder sb = new StringBuilder();
		
		sb.append(" UPDATE cart   ");
		sb.append(" SET cart_book_qty = ?  ");
		sb.append(" WHERE user_id = ?   ");
		sb.append(" 	  AND book_no =   ");
		sb.append(" 				(SELECT book_no FROM book  ");
		sb.append(" 				 WHERE book_title = ?)  ");
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setInt(1, qty);
			pstmt.setString(2, userId);
			pstmt.setString(3, bookTitle);
			
			System.out.println("qty:"+qty+",userId:"+userId+",title:"+bookTitle);
			
			pstmt.executeUpdate();
			System.out.println("Cart Update Complated");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcCartDao.update 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
	}

	@Override
	public void deleteCart(String userId, String bookTitle) {
		Connection con = null;
		PreparedStatement pstmt = null;

		StringBuilder sb = new StringBuilder();
		  
		sb.append(" DELETE from cart  ");
		sb.append(" WHERE user_id = ?  ");
		sb.append(" AND book_no =   ");
		sb.append(" 				(SELECT book_no FROM book  ");
		sb.append(" 				 WHERE book_title = ?)  ");
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, userId);
			pstmt.setString(2, bookTitle);
			
			System.out.println("userId:"+userId+",title:"+bookTitle);
			
			pstmt.executeUpdate();
			System.out.println("Cart Delete Complated");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcCartDao.delete 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
	}
	
	@Override
	/** 수량 반환 */
	public Cart getCart(int cartNo) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Cart cart = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT	cart_book_qty, " );
		sb.append("			book_no,  ");
		sb.append("			user_id  ");
		sb.append("FROM cart  ");
		sb.append("WHERE cart_no = ? ");
		
		try {	
			connection = dataSource.getConnection();		
			pstmt = connection.prepareStatement(sb.toString());
			
			pstmt.setInt(1, cartNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cart = new Cart(cartNo, rs.getInt("cart_book_qty"),rs.getInt("book_no"), rs.getString("user_id"));
			}
				
		}	catch(Exception e) {
			throw new RuntimeException("JdbcCartDAO.getCart Error!");
			
		}	finally {
			if(rs != null)
				try { rs.close(); } catch (SQLException e) {}
			if(pstmt != null) 	
				try { pstmt.close(); } catch (SQLException e) {}
			if(connection != null) 	
				try { connection.close(); } catch (SQLException e) {}
		}
		
		return cart;
	}
	
	/* 단위테스트 */
	public static void main(String[] args) {
		CartDao cartDao = (CartDao) DaoFactory.getInstance().getDao(JdbcCartDao.class);

//		int pageSize = 5;
//		int pageNum = 5;
		
//		Params params = new Params();
//		params.setPage(1);
//		params.setType("user_id");
//		params.setValue("joo");
		
//		List<CartList> books = cartDao.listAll(params);
//		for (CartList list : books) {
//			System.out.println(list);
//		}
		
//		int count = cartDao.pageCount(params);
//		System.out.println(count);
		
		//삭제 기능 테스트
	//	cartDao.deleteCart("joo","1st Look(퍼스트 룩)(Vol. 142)");
		
		//수정 기능 테스트
	//	cartDao.update("joo", "1st Look(퍼스트 룩)(Vol. 142)", 1);
		
		//장바구니 조회
	//	int[] arr = {2};
	//	System.out.println(cartDao.listSome("joo", arr));
		
		//카트반환
		//System.out.println(cartDao.getCart(1));
		
		//카트생성
		cartDao.create(new Cart(4, 1, "joo"));
	}
	
}




