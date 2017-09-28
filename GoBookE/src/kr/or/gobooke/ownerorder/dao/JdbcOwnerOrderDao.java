package kr.or.gobooke.ownerorder.dao;

import javax.sql.DataSource;

import kr.or.gobooke.ownerorder.domain.OwnerOrder;

/**
 * JDBC API를 이용한 OwnerOrder 테이블 관련 영속성 처리 DAO 클래스
 * DAO 패턴 적용
 * @author 김수진
 */
public class JdbcOwnerOrderDao implements OwnerOrderDao{
	
private DataSource dataSource;
	
	public JdbcOwnerOrderDao() {}
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public OwnerOrder search(int no) {
		// TODO Auto-generated method stub
		return null;
	}
	
}












