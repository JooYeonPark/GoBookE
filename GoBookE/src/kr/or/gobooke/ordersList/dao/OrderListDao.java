package kr.or.gobooke.ordersList.dao;

import java.util.List;

import kr.or.gobooke.ordersList.domain.OrderList;

/**
 * 주문항목 데이터베이스 처리 인터페이스
 * 
 * @author Park Joo-Yeon
 *
 */
public interface OrderListDao {
	
	/** 주문항목 추가 */
	public void create(OrderList orderList);
	
	/** 주문항목 조회 */
	public List<OrderList> search(int orderNo);
}
