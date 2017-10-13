package kr.or.gobooke.ordersList.service;

import java.util.List;

import kr.or.gobooke.book.dao.BookDao;
import kr.or.gobooke.book.dao.JdbcBookDao;
import kr.or.gobooke.cart.dao.CartDao;
import kr.or.gobooke.cart.dao.JdbcCartDao;
import kr.or.gobooke.cart.domain.Cart;
import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.ordersList.dao.JdbcOrderListDao;
import kr.or.gobooke.ordersList.dao.OrderListDao;
import kr.or.gobooke.ordersList.domain.OrderList;

/**
 * 주문항목처리 비즈니스 메소드 
 * 
 * @author Park Joo-Yeon
 *
 */
public class OrderListServiceImpl implements OrderListService {
	OrderListDao ordersDao = (OrderListDao) DaoFactory.getInstance().getDao(JdbcOrderListDao.class);
	CartDao cartDao = (CartDao) DaoFactory.getInstance().getDao(JdbcCartDao.class);
	BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(JdbcBookDao.class);
	
	@Override
	public void create(int orderNo, int cartNo) {
		Cart cart = cartDao.getCart(cartNo);
		int bookPrice = bookDao.getBookPrice(cart.getBookNo());
		ordersDao.create(orderNo, cart, bookPrice);
	}

	@Override
	public List<OrderList> search(int orderNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
