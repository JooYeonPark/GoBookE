package kr.or.gobooke.orders.service;

import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

import kr.or.gobooke.orders.domain.Orders;

/**
 * orders에 관한 고객의 요구사항을 반영하는 비즈니스 메소드 선언
 * 
 * @author Park Joo-Yeon
 *
 */
public interface OrdersService {
	/** 주문등록 */
	public void create(Orders order);
	
	/** 주문조회 */
	public Orders search(Orders no);
	
	/** 주문 전체 조회 */
	public List<Map<String,String>> listAll();
}
