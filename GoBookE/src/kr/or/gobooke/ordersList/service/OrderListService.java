package kr.or.gobooke.ordersList.service;

import java.util.List;

import kr.or.gobooke.ordersList.domain.OrderList;

public interface OrderListService {
	/** 주문항목 추가 */
	public void create(int orderNo, int cartNo);

	/** 주문항목 조회 */
	public List<OrderList> search(int orderNo);
	
}
