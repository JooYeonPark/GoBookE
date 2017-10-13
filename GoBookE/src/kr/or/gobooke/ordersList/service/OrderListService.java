package kr.or.gobooke.ordersList.service;

import java.util.List;

import kr.or.gobooke.ordersList.domain.OrderList;

/**
 * 주문항목처리 비즈니스 메소드 선언
 * 
 * @author Park Joo-Yeon
 *
 */
public interface OrderListService {
	/** 주문항목 추가 */
	public void create(int orderNo, int cartNo);

	/** 주문항목 조회 */
	public List<OrderList> search(int orderNo);
	
}
