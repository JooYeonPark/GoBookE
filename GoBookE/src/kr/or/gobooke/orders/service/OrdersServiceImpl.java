package kr.or.gobooke.orders.service;

import java.util.List;

import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.common.web.OrdersParams;
import kr.or.gobooke.orders.dao.JdbcOrdersDao;
import kr.or.gobooke.orders.dao.OrdersDao;
import kr.or.gobooke.orders.domain.Orders;

/**
 * 주문 비즈니스 메소드 선언
 * 
 * @author 김수진
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
	public List<Orders> listByParams(OrdersParams params) {
		return ordersDao.listByParams(params);
	}

	@Override
	public int pageCount(OrdersParams params) {
		return ordersDao.pageCount(params);
	}


}
