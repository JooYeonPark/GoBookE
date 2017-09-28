package kr.or.gobooke.ordersList.dao;

import java.util.List;

import javax.sql.DataSource;

import kr.or.gobooke.ordersList.domain.OrderList;

public class JdbcOrderListDao implements OrderListDao {
	
	private DataSource dataSource;
	
	/** 생성자 */
	public JdbcOrderListDao() {}
	
	public JdbcOrderListDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/** Setter */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	/** 주문항목 추가 */
	public void create(OrderList orderList) {

	}

	@Override
	/** 주문항목 조회 */
	public List<OrderList> search(int orderNo){
		return null;
	}

}
