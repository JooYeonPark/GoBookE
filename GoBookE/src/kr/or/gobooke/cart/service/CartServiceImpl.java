package kr.or.gobooke.cart.service;

import java.util.List;

import kr.or.gobooke.cart.dao.CartDao;
import kr.or.gobooke.cart.dao.JdbcCartDao;
import kr.or.gobooke.cart.domain.Cart;
import kr.or.gobooke.cart.domain.CartList;
import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.common.web.Params;

/**
 * Users 비즈니스 메소드 선언
 * 
 * @author 김수진
 *
 */

public class CartServiceImpl implements CartService {
	
	CartDao cartDao = (CartDao) DaoFactory.getInstance().getDao(JdbcCartDao.class);

	@Override
	public void create(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CartList> listAll(Params params) {
		return cartDao.listAll(params);
	}

	@Override
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	/** 출력페이지 계산을 위한 {검색유형, 검색값}에 대한 행의 수 반환 */
	public int pageCount(Params params) {
		return cartDao.pageCount(params);
	}


}
