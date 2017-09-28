package kr.or.gobooke.cart.service;

import java.util.List;

import kr.or.gobooke.cart.domain.Cart;
import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.users.dao.JdbcUsersDao;
import kr.or.gobooke.users.dao.UsersDao;

/**
 * Users 비즈니스 메소드 선언
 * 
 * @author 김수진
 *
 */

public class CartServiceImpl implements CartService {
	
	UsersDao userDao = (UsersDao) DaoFactory.getInstance().getDao(JdbcUsersDao.class);

	@Override
	public void create(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cart> search(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		
	}


}
