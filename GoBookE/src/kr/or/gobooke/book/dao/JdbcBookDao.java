package kr.or.gobooke.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.gobooke.book.domain.Book;
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
			System.out.println("Book Update Complated");
			
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
			 
			 book = new Book();
			 
			 book.setNo(no);
			 book.setTitle(title);
			 book.setAuthor(author);
			 book.setPublisher(publisher);
			 book.setDetail(detail);
			 book.setPrice(price);
			 book.setImage(image);
			 book.setRegdate(regdate);
			 book.setQty(qty);
			 book.setCategoryNo(categoryNo);
			 book.setCategoryBigNo(categoryBigNo);
			 book.setGrade(grade);
			 
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

	@Override
	public Book getBookDetail(int book_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book=null;
		String sqlSelect="select book_no,\r\n" + 
				"      book_title,\r\n" + 
				"      book_author,\r\n" + 
				"      book_publisher,\r\n" + 
				"      book_detail,\r\n" + 
				"      book_price,\r\n" + 
				"      book_image,\r\n" + 
				"      book_regdate,\r\n" + 
				"      book_qty,\r\n" + 
				"      book_grade,\r\n" + 
				"      category_big_no,\r\n" + 
				"      category_no\r\n" + 
				"      from book where book_no=?";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sqlSelect);
			pstmt.setInt(1, book_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				book=new Book();
				book.setNo(rs.getInt("book_no"));
				book.setTitle(rs.getString("book_title"));
				book.setAuthor(rs.getString("book_author"));
				book.setPublisher(rs.getString("book_publisher"));
				book.setDetail(rs.getString("book_detail"));
				book.setPrice(rs.getInt("book_price"));
				book.setImage(rs.getString("book_image"));
				book.setRegdate(rs.getString("book_regdate"));
				book.setQty(rs.getInt("book_qty"));
				book.setGrade(rs.getFloat("book_grade"));
				book.setCategoryNo(rs.getInt("category_no"));
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
			}
			throw new MallException("JdbcArticleDao.readArticle(int article_id) 실행 중 예외발생", e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return book;
	}

	@Override
	public Book getBookByTitle(String title) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book=null;
		String sqlSelect="select book_no,\r\n" + 
				"      book_title,\r\n" + 
				"      book_author,\r\n" + 
				"      book_publisher,\r\n" + 
				"      book_detail,\r\n" + 
				"      book_price,\r\n" + 
				"      book_image,\r\n" + 
				"      book_regdate,\r\n" + 
				"      book_qty,\r\n" + 
				"      book_grade,\r\n" + 
				"      category_big_no,\r\n" + 
				"      category_no\r\n" + 
				"      from book where book_title=?";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sqlSelect);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				book=new Book();
				book.setNo(rs.getInt("book_no"));
				book.setTitle(rs.getString("book_title"));
				book.setAuthor(rs.getString("book_author"));
				book.setPublisher(rs.getString("book_publisher"));
				book.setDetail(rs.getString("book_detail"));
				book.setPrice(rs.getInt("book_price"));
				book.setImage(rs.getString("book_image"));
				book.setRegdate(rs.getString("book_regdate"));
				book.setQty(rs.getInt("book_qty"));
				book.setGrade(rs.getFloat("book_grade"));
				book.setCategoryNo(rs.getInt("category_no"));
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
			}
			throw new MallException("JdbcArticleDao.readArticle(int article_id) 실행 중 예외발생", e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return book;
	}
	
	@Override
	/** 도서 가격 반환 */
	public int getBookPrice(int bookNo) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int bookPrice = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT	book_price " );
		sb.append("FROM book  ");
		sb.append("WHERE book_no = ? ");
		
		try {	
			connection = dataSource.getConnection();		
			pstmt = connection.prepareStatement(sb.toString());
			
			pstmt.setInt(1, bookNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bookPrice = rs.getInt("book_price");
			}
				
		}	catch(Exception e) {
			throw new RuntimeException("JdbcBookDAO.getBookPrice Error!");
			
		}	finally {
			if(rs != null)
				try { rs.close(); } catch (SQLException e) {}
			if(pstmt != null) 	
				try { pstmt.close(); } catch (SQLException e) {}
			if(connection != null) 	
				try { connection.close(); } catch (SQLException e) {}
		}
		
		return bookPrice;
	}

	@Override
	public List<Book> getInBookList() {
		List<Book> inList = null;		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="select * from book where category_big_no=1 order by book_regdate";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			inList = new ArrayList<Book>();
			while(rs.next()){
				Book book = createBook(rs);
				inList.add(book);
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
		
		
		return inList;
	}

	@Override
	public List<Book> getExBookList() {
		List<Book> exList = null;		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="select * from book where category_big_no=2 order by book_regdate";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			exList = new ArrayList<Book>();
			while(rs.next()){
				Book book = createBook(rs);
				exList.add(book);
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
		
		
		return exList;
	}
	

}

