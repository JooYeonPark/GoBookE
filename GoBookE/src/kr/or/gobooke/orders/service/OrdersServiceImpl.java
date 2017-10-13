package kr.or.gobooke.orders.service;

import java.util.List;

import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.common.web.OrdersParams;
import kr.or.gobooke.orders.dao.JdbcOrdersDao;
import kr.or.gobooke.orders.dao.OrdersDao;
import kr.or.gobooke.orders.domain.Orders;

/**
 * 주문에 관한 고객의 요구사항을 반영하는 비즈니스 메소드 
 * 
 * @author Park Joo-Yeon
 *
 */

public class OrdersServiceImpl implements OrdersService {
	OrdersDao ordersDao = (OrdersDao) DaoFactory.getInstance().getDao(JdbcOrdersDao.class);
	
	@Override
	/** 주문 등록 후 orderNo 반환 */
	public int create(Orders order) {
		return ordersDao.create(order);
	}

	@Override
	/** 주문리스트 조회 */
	public List<Orders> listByParams(OrdersParams params) {
		return ordersDao.listByParams(params);
	}

	@Override
	/** 주문리스트 전체 수 가져오기 */
	public int pageCount(OrdersParams params) {
		return ordersDao.pageCount(params);
	}


}
