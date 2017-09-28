package kr.or.gobooke.users.dao;

import javax.sql.DataSource;

import kr.or.gobooke.users.domain.Users;


/**
 * JDBC API를 이용한 사용자(users) 테이블 관련 영속성 처리 DAO 클래스
 * DAO 패턴 적용
 * @author 김수진
 */
public class JdbcUsersDao implements UsersDao{
	
private DataSource dataSource;
	
	public JdbcUsersDao() {}
	
	public JdbcUsersDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/** 신규 회원 등록 */
	public void create(Users user){

	}
	
	
	/** 사용자아이디를 이용한 사용자 상세 정보 조회 */
	public Users search(String id){
		return null;
	
	}
	
	/** 회원정보 수정 */
	public void update(Users user) {
		
	}
	
	/** 회원 여부 반환 */
	public Users isMember(String id, String passwd){
		
		return null;
	}

}












