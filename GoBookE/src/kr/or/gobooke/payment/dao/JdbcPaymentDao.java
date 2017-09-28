package kr.or.gobooke.payment.dao;

import javax.sql.DataSource;

import kr.or.gobooke.payment.domain.Payment;

/**
 * JDBC API를 이용한 payment 테이블 관련 영속성 처리 DAO 클래스
 * DAO 패턴 적용
 * @author 김수진
 */
public class JdbcPaymentDao implements PaymentDao{
	
private DataSource dataSource;
	
	public JdbcPaymentDao() {}
	
	public JdbcPaymentDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Payment payment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Payment search(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}












