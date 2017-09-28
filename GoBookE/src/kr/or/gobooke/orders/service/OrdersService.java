package kr.or.gobooke.orders.service;

import java.util.List;
import java.util.Map;

import kr.or.gobooke.orders.domain.Orders;

public interface OrdersService {
	/** 주문등록 */
	public void create(Orders order);
	
	/** 주문 기간별 조회 */
	public List<Orders> search(String startDate, String endDate, String userId);
}
