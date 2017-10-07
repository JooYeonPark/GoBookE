package kr.or.gobooke.orders.service;

import java.util.List;
import java.util.Map;

import kr.or.gobooke.orders.domain.Orders;

/**
 * 주문에 관한 고객의 요구사항을 반영하는 비즈니스 메소드 선언
 *
 * @author 박주연
 *
 */

public interface OrdersService {
	
	/** 주문 등록 후 orderNo 반환 */
	public int create(Orders order);
	
	/** 주문 기간별 조회 */
	public List<Orders> search(String startDate, String endDate, String userId);

}
