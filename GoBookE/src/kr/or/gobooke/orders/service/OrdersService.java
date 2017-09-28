package kr.or.gobooke.orders.service;

import java.util.List;
import java.util.Map;

import kr.or.gobooke.orders.domain.Orders;

public interface OrdersService {
	/** 주문등록 */
	public void create(Orders order);
	
	/** 주문조회 */
	public Orders search(Orders no);
	
	/** 주문 전체 조회 */
	public List<Orders> listAll();
}
