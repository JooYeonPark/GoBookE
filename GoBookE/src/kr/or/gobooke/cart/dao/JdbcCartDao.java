package kr.or.gobooke.cart.dao;

import java.util.List;

import javax.sql.DataSource;

import kr.or.gobooke.cart.domain.Cart;
import kr.or.gobooke.ownerorder.domain.OwnerOrder;

/**
 * JDBC API를 이용한 Cart 테이블 관련 영속성 처리 DAO 클래스
 * DAO 패턴 적용
 * @author 김수진
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
	public List<Cart> search(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	
}












