package kr.or.gobooke.orders.service;

import java.util.List;

import kr.or.gobooke.common.web.OrdersParams;
import kr.or.gobooke.orders.domain.Orders;

/**
 * 주문에 관한 고객의 요구사항을 반영하는 비즈니스 메소드 선언
 *
 * @author Park Joo-Yeon
 *
 */

public interface OrdersService {
	
	/** 주문 등록 후 orderNo 반환 */
	public int create(Orders order);
	
	/** 주문리스트 조회 */
	public List<Orders> listByParams(OrdersParams params);
	
	/** 주문리스트 전체 수 가져오기 */
	public int pageCount(OrdersParams params);

}
