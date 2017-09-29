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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CartList> listAll(Params params) {
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
		sb.append("FROM   (SELECT CEIL(rownum / ?) 	request_page,  ");
		sb.append("									book_image,  ");
		sb.append("									book_title,  ");
		sb.append("									cart_book_qty,  ");
		sb.append("									book_price,  ");
		sb.append("									cart_no ");
		sb.append("			FROM   (SELECT 	book_image,  ");
		sb.append("							book_title,  ");
		sb.append("							cart_book_qty,  ");
		sb.append("							book_price,  ");
		sb.append("							cart_no ");
		sb.append("					FROM book, cart ");
		sb.append("					WHERE book.book_no = cart.book_no ");
		sb.append("						  AND user_id = ?) ");
		sb.append("					)	");
		sb.append("WHERE  request_page = ?  ");
		sb.append("ORDER BY cart_no DESC ");
		
		
		try {	
			connection = dataSource.getConnection();		
			pstmt = connection.prepareStatement(sb.toString());
			
			String type = params.getType();
			String value = params.getValue();
			
			if(type!=null) {
				pstmt.setInt(1, params.getPageSize());
				pstmt.setString(2, value);
				pstmt.setInt(3, params.getPage());
			}
			
			rs = pstmt.executeQuery();
			cartList = new ArrayList<CartList>();
			
			while(rs.next()) {
				int totalPrice = rs.getInt("cart_book_qty") * rs.getInt("book_price");
			
				cartList.add(new CartList(rs.getString("book_image"),rs.getString("book_title"),
						rs.getInt("cart_book_qty"), rs.getInt("book_price"), totalPrice));
			}
				
		}	catch(Exception e) {
			throw new RuntimeException("JDBCUserDAO ListAll Error!");
			
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
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	/** 출력페이지 계산을 위한 {검색유형, 검색값}에 대한 행의 수 반환 */
	public int pageCount(Params params) {
		int count = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT COUNT(cart_no) count  ");
		sb.append(" FROM   cart  ");
		
		String type = params.getType();
		String value = params.getValue();
		
		if(type != null) {
			sb.append("WHERE  user_id  = ? ");
		}
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());

			if(type != null){
				pstmt.setString(1, value);
			}

			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcCartDao.pageCount(Params params) 실행 중 예외발생", e);
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return count;
	}
	
	/* 단위테스트 */
	public static void main(String[] args) {
		CartDao cartDao = (CartDao) DaoFactory.getInstance().getDao(JdbcCartDao.class);

		int pageSize = 5;
		int pageNum = 5;
		
		Params params = new Params();
		params.setPage(1);
		params.setType("user_id");
		params.setValue("joo");
		
//		List<CartList> books = cartDao.listAll(params);
//		for (CartList list : books) {
//			System.out.println(list);
//		}
		
		int count = cartDao.pageCount(params);
		System.out.println(count);
	}
	
	
	
	
}












