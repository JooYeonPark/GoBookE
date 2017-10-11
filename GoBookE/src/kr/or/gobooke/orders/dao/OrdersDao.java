package kr.or.gobooke.orders.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import kr.or.gobooke.common.web.OrdersParams;
import kr.or.gobooke.orders.domain.Orders;
import kr.or.gobooke.ownerorder.domain.OwnerOrder;

/**
 * 주문 데이터베이스 처리 클래스
 * 
 * @author Park Joo-Yeon
 *
 */
public interface OrdersDao {
	/** 주문 등록 후 orderNo 반환 */
	public int create(Orders order);
	
	/** 주문번호 조회 */
	public int searchOrderNo(Orders order);
	
	/** 주문 리스트 조회 */
	public List<Orders> listByParams(OrdersParams params);
	
	/** 주문 전체 리스트 조회 */
	public int pageCount(OrdersParams params);
	
	public Orders createOrder(ResultSet rs) throws SQLException;

}
