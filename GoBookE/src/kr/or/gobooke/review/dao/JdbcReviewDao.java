package kr.or.gobooke.review.dao;

import javax.sql.DataSource;

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
}












