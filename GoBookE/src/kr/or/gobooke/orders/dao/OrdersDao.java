package kr.or.gobooke.orders.dao;

import java.util.List;

import kr.or.gobooke.orders.domain.Orders;

/**
 * 주문 데이터베이스 처리 클래스
 * 
 * @author Park Joo-Yeon
 *
 */
public interface OrdersDao {
	/** 주문 등록 후 orderNo 반환 */
	public int create(Orders order);
	
	/** 주문조회 */
	public Orders search(Orders no);
	
	/** 주문번호 조회 */
	public int searchOrderNo(Orders order);
	
	/** 주문 기간별 조회 */
	public List<Orders> search(String userId, String startDate, String endDate);

}
