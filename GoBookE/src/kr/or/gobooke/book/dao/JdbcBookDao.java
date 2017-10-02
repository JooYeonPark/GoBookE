package kr.or.gobooke.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.gobooke.book.domain.Book;
import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.common.exception.MallException;
import kr.or.gobooke.common.web.BookParams;

/**
 * 책 데이터 베이스 처리 클래스
 * 
 * @author Park Joo-Yeon
 *
 */
public class JdbcBookDao implements BookDao {

	private DataSource dataSource;
	
	/** 생성자 */
	public JdbcBookDao() {}
	
	public JdbcBookDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/** Setter */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	/** 도서 등록 */
	public void create(Book book) {

	}

	@Override
	/** 도서 수정 */
	public void update(Book book) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE book  " + 
					 "SET    book_qty = ? " + 
					 "WHERE  book_no = ? "; 
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, book.getQty());
			pstmt.setInt(2, book.getNo());
			
			pstmt.executeUpdate();
			
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

			throw new MallException("JDBCBookDao.update(Book book) 실행중 예외 발생", e);
		}
		
	}
	
	@Override
	/** 도서 검색 */
	public List<Book> search(String filter, String content){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Book> books = new ArrayList<Book>();
		Book book = null;

		String sql = "SELECT book_no, " + 
					 "       book_title,  " + 
					 "       book_author,  " + 
					 "       book_publisher,  " + 
					 "       book_detail,  " + 
					 "       book_price,  " + 
					 "       book_image,  " + 
					 "       book_regdate,  " + 
					 "       book_qty,  " + 
					 "       book_grade,  " + 
					 "       category_big_no,  " + 
					 "       category_no  " + 
					 " FROM   book   "; 
		
		switch (filter) {
		case "no":
			sql += " WHERE book_no = ? ";
			break;
		case "publisher":
			sql += " WHERE  book_publisher = ?  ";
			break;
		}
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, content);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				book = createBook(rs);
				System.out.println("search 안 : "+book.toString());
				books.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
			}finally {
				try {
					if(rs != null)    rs.close();
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (SQLException e1) {
				}
			}

			throw new MallException("JDBCBookDao.listAll() 실행중 예외 발생", e);
		}

		return books;
	}

	/** Book 객제 생성 */
	public Book createBook(ResultSet rs) {
		Book book = null;
		try {
			 int no = rs.getInt("book_no");
			 String title = rs.getString("book_title");
			 String author = rs.getString("book_author");
			 String publisher = rs.getString("book_publisher");
			 String detail = rs.getString("book_detail");
			 int price = rs.getInt("book_price");
			 String image = rs.getString("book_image");
			 String regdate = rs.getString("book_regdate");
			 int qty = rs.getInt("book_qty");
			 int categoryNo = rs.getInt("category_no");
			 int categoryBigNo = rs.getInt("category_big_no");
			 double grade = rs.getDouble("book_grade");
			 
			 book = new Book(no, title, author, publisher, detail, price, image, regdate, qty, categoryBigNo, categoryNo, grade);
			 
		}catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JDBCBookDao.createBook(ResultSet)실행중 예외 발생", e);
		}
		return book;
	}

	@Override
	public List<Book> getBookListByParams(BookParams params) {
List<Book> list = null;		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT book_no,"); 
		sb.append("       book_title,"); 
		sb.append("       book_author,"); 
		sb.append("       book_publisher,"); 
		sb.append("       book_detail,"); 
		sb.append("       book_price,"); 
		sb.append("       book_image,"); 
		sb.append("       book_regdate,"); 
		sb.append("       book_qty,"); 
		sb.append("       book_grade,"); 
		sb.append("       category_big_no,"); 
		sb.append("       category_no "); 
		sb.append("FROM   (SELECT Ceil(rownum / ?) request_page,"); 
		sb.append("               book_no,"); 
		sb.append("               book_title,"); 
		sb.append("               book_author,"); 
		sb.append("               book_publisher,"); 
		sb.append("               book_detail,"); 
		sb.append("               book_price,"); 
		sb.append("               book_image,"); 
		sb.append("               book_regdate,"); 
		sb.append("               book_qty,"); 
		sb.append("               book_grade,"); 
		sb.append("               category_big_no,"); 
		sb.append("               category_no"); 
		sb.append("        FROM   (SELECT book_no,"); 
		sb.append("                       book_title,"); 
		sb.append("                       book_author,"); 
		sb.append("                       book_publisher,"); 
		sb.append("                       book_detail,"); 
		sb.append("                       book_price,"); 
		sb.append("                       book_image,"); 
		sb.append("                       To_char(book_regdate, 'YYYY/MM/DD HH24:MI:SS')"); 
		sb.append("                       book_regdate,"); 
		sb.append("                       book_qty,"); 
		sb.append("                       book_grade,"); 
		sb.append("                       category_big_no,"); 
		sb.append("                       category_no "); 
		sb.append("                FROM   book  "); 
		sb.append("                WHERE  category_big_no = ?"); 
		sb.append("                       AND category_no = ?"); 
		
		
		// 검색 유형별 WHERE 절 동적 추가
		String type = params.getType();
		String value = params.getValue();
		if(type != null){
			switch (params.getType()) {
				case "title":    
					sb.append(" AND  book_title  = ?");
					break;
				case "author":  
					sb.append(" AND  book_author LIKE ?");
					value = "%" + value + "%";
					break;
			}
		}
		sb.append("                ORDER  BY book_regdate DESC))"); 
		sb.append("WHERE  request_page = ?"); 
		
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, params.getPageSize());
			pstmt.setInt(2, params.getCategory_big_no());
			pstmt.setInt(3, params.getCategory_no());
			
			// 전체검색이 아닌경우 경우
			if(type != null){
				pstmt.setString(4, value);
				pstmt.setInt(5, params.getPage());
			}else{// 전체검색인 경우
				pstmt.setInt(4, params.getPage());
			}
			
			rs = pstmt.executeQuery();
			list = new ArrayList<Book>();
			
			while(rs.next()){
				Book book = createBook(rs);
				list.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcUserDao.listByParams(Params params) 실행 중 예외발생", e);
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return list;
	}

	@Override
	public int pageCount(BookParams params) {
		int count = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT COUNT(book_no) count");
		sb.append(" FROM   book");
		sb.append(" WHERE category_big_no=? AND category_no=?");
		
		// 검색 유형별 WHERE 절 동적 추가
		String type = params.getType();
		String value = params.getValue();
		if(type != null){
			switch (params.getType()) {
				case "title":
					sb.append(" AND  book_title  = ?");
					break;
				case "author":
					sb.append(" AND  book_author LIKE ?");
					value = "%" +value + "%";
					break;
			}
		}
		
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, params.getCategory_big_no());
			pstmt.setInt(2, params.getCategory_no());
			// 전체검색이 아닌경우 경우
			if(type != null){
				pstmt.setString(3, value);
			}

			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcUserDao.pageCount(Params params) 실행 중 예외발생", e);
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return count;
	}

}
