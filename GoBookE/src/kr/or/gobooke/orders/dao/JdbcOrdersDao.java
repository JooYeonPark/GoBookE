package kr.or.gobooke.orders.dao;

import java.util.List;

import javax.sql.DataSource;

import kr.or.gobooke.orders.domain.Orders;

/**
 * 주문 데이터베이스 처리 인터페이스
 * 
 * @author Park Joo-Yeon
 *
 */
public class JdbcOrdersDao implements OrdersDao{

	private DataSource dataSource;
	
	/** 생성자 */
	public JdbcOrdersDao() {}
	
	public JdbcOrdersDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/** Setter */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	@Override
	/** 주문등록 */
	public void create(Orders order) {
		
	}
	
	@Override
	/** 주문조회 */
	public Orders search(Orders no) {
		return null;
	}
	
	@Override
	/** 주문 기간별 조회 */
	public List<Orders> search(String userId, String startDate, String endDate){
		return null;
	}
	
}
