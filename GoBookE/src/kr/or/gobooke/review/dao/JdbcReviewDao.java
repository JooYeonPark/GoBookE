package kr.or.gobooke.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.gobooke.common.exception.MallException;
import kr.or.gobooke.common.web.Params;
import kr.or.gobooke.review.domain.Review;
import kr.or.gobooke.users.domain.Users;


/**
 * JDBC API를 이용한 사용자(users) 테이블 관련 영속성 처리 DAO 클래스
 * DAO 패턴 적용
 * @author 김수진
 */
public class JdbcReviewDao implements ReviewDao{
	
private DataSource dataSource;
	
	public JdbcReviewDao() {}
	
	public JdbcReviewDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/** 신규 등록 */
	public void create(Review review) {
		
	}
	
	/** 리뷰 수정 */
	public void update(Review review) {
		
	}

	@Override
	public List<Review> getReviewList(Params params) {
		List<Review> list = null;		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		/*StringBuilder sb = new StringBuilder();
		sb.append("SELECT review_no,");
		sb.append("       review_regdate,"); 
		sb.append("       review_message,");
		sb.append("       review_grade,");
		sb.append("       book_no,"); 
		sb.append("       user_id "); 
		sb.append("FROM  (SELECT Ceil(rownum / ?) request_page,"); 
		sb.append("              review_no,"); 
		sb.append("              review_regdate,");  
		sb.append("              review_message,");  
		sb.append("              review_grade,");  
		sb.append("              book_no,"); 
		sb.append("              user_id ");  
		sb.append("       FROM  (SELECT review_no,"); 
		sb.append("                     To_char(review_regdate, 'YYYY/MM/DD HH24:MI:SS') review_regdate,");  
		sb.append("                     review_message,");  
		sb.append("                     review_grade,");  
		sb.append("                     book_no,");  
		sb.append("                     user_id ");  
		sb.append("              FROM   review");  
		sb.append("              WHERE  book_no = ?");  
		sb.append("              ORDER  BY review_no))");  
		sb.append(" WHERE  request_page = ?"); */
		
		String sql="SELECT review_no, \r\n" + 
				"       review_regdate, \r\n" + 
				"       review_message, \r\n" + 
				"       review_grade, \r\n" + 
				"       book_no, \r\n" + 
				"       user_id \r\n" + 
				"FROM  (SELECT Ceil(rownum / ?) request_page, \r\n" + 
				"              review_no, \r\n" + 
				"              review_regdate, \r\n" + 
				"              review_message, \r\n" + 
				"              review_grade, \r\n" + 
				"              book_no, \r\n" + 
				"              user_id \r\n" + 
				"       FROM  (SELECT review_no, \r\n" + 
				"                     review_regdate, \r\n" + 
				"                     review_message, \r\n" + 
				"                     review_grade, \r\n" + 
				"                     book_no, \r\n" + 
				"                     user_id \r\n" + 
				"              FROM   review \r\n" + 
				"              WHERE  book_no = ? \r\n" + 
				"              ORDER  BY review_no)) \r\n" + 
				"WHERE  request_page = ?";
		
		
		// 검색 유형별 WHERE 절 동적 추가
		String type = params.getType();
		int value = Integer.parseInt(params.getValue());
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, params.getPageSize());
			pstmt.setInt(2, value);
			
			// 전체검색이 아닌경우 경우
			pstmt.setInt(3, params.getPage());
		
			
			rs = pstmt.executeQuery();
			list = new ArrayList<Review>();
			
			while(rs.next()){
				Review review=createReview(rs);
				list.add(review);
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
	
	public Review createReview(ResultSet rs) throws SQLException {
		int no=rs.getInt("review_no");
		String regdate=rs.getString("review_regdate");
		String message=rs.getString("review_message");
		double grade=rs.getDouble("review_grade");
		int book_no=rs.getInt("book_no");
		String user=rs.getString("user_id");
		
		Review review=new Review();
		review.setNo(no);
		review.setRegdate(regdate);
		review.setMessage(message);
		review.setGrade(grade);
		review.setBookNo(book_no);
		review.setUserId(user);
		return review;
	}

	@Override
	public int getReviewPageCount(Params params) {
		int count = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		/*StringBuilder sb = new StringBuilder();
		sb.append("SELECT Count(review_no) count"); 
		sb.append("FROM   review"); 
		sb.append("WHERE  book_no = ?");*/
		
		String sql="select count(review_no) count from review where book_no=?";
		
		int value = Integer.parseInt(params.getValue());
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, value);
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
	public int reviewWrite(Review review) {
		int checkWrite=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		
		String updateGrade="UPDATE book \r\n" + 
				"SET    book_grade = (SELECT Round(( ( Sum(review_grade) + ? ) / ( \r\n" + 
				"                                           Count(review_no) + 1 ) ), 1) \r\n" + 
				"                     FROM   review \r\n" + 
				"                     WHERE  book_no = ?) \r\n" + 
				"WHERE  book_no = ?";
		
		con = dataSource.getConnection();
		con.setAutoCommit(false);
		pstmt = con.prepareStatement(updateGrade);
		pstmt.setDouble(1,review.getGrade());
		pstmt.setInt(2, review.getBookNo());
		pstmt.setInt(3, review.getBookNo());
		int up = pstmt.executeUpdate();
		if (pstmt != null)
			pstmt.close();
		
		if(up>0) {
			String insertSql="INSERT INTO review \r\n" + 
					"            (review_no, \r\n" + 
					"             review_message, \r\n" + 
					"             review_grade, \r\n" + 
					"             book_no, \r\n" + 
					"             user_id) \r\n" + 
					"VALUES     (review_no_seq.nextval, \r\n" + 
					"            ?, \r\n" + 
					"            ?, \r\n" + 
					"            ?, \r\n" + 
					"            ?)";
			
			pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, review.getMessage().replace("\r\n", "<br/>"));
			pstmt.setDouble(2, review.getGrade());
			pstmt.setInt(3, review.getBookNo());
			pstmt.setString(4, review.getUserId());
			checkWrite=pstmt.executeUpdate();
			
		}		
		con.commit();
		System.out.println("Review 등록 성공");
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
		
		return checkWrite;
	}

	@Override
	public int reviewDelete(int review_no) {
		int checkDelte=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		
		String deleteGrade="UPDATE book \r\n" + 
				"SET    book_grade = (SELECT Round(( (SELECT Sum(review_grade) \r\n" + 
				"                                     FROM   review \r\n" + 
				"                                     WHERE  book_no = (SELECT book_no \r\n" + 
				"                                                       FROM   review \r\n" + 
				"                                                       WHERE  review_no = ?)) \r\n" + 
				"                                    - (SELECT \r\n" + 
				"                                           review_grade \r\n" + 
				"                                      FROM \r\n" + 
				"                                           review \r\n" + 
				"                                      WHERE \r\n" + 
				"                                                        review_no = ?) ) / ( \r\n" + 
				"                                                              SELECT \r\n" + 
				"                                         Count(review_no) - 1 \r\n" + 
				"                                                              FROM \r\n" + 
				"                                                                    review \r\n" + 
				"                                                              WHERE \r\n" + 
				"                                         book_no = (SELECT book_no \r\n" + 
				"                                                    FROM   review \r\n" + 
				"                                                    WHERE  review_no = ?) \r\n" + 
				"                                                ), 1) \r\n" + 
				"                     FROM   review \r\n" + 
				"                     WHERE  review_no = ?) \r\n" + 
				"WHERE  book_no = (SELECT book_no \r\n" + 
				"                  FROM   review \r\n" + 
				"                  WHERE  review_no = ?)";
		
		con = dataSource.getConnection();
		con.setAutoCommit(false);
		pstmt = con.prepareStatement(deleteGrade);
		pstmt.setInt(1, review_no);
		pstmt.setInt(2, review_no);
		pstmt.setInt(3, review_no);
		pstmt.setInt(4, review_no);
		pstmt.setInt(5, review_no);
		int down = pstmt.executeUpdate();
		if (pstmt != null)
			pstmt.close();
		
		if(down>0) {
			String insertSql="delete review where review_no=?";
			
			pstmt = con.prepareStatement(insertSql);
			pstmt.setInt(1, review_no);
			checkDelte=pstmt.executeUpdate();
			
		}		
		con.commit();
		System.out.println("Review 삭제 성공");
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
		
		return checkDelte;
	}
}












