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
	@Override
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

}
