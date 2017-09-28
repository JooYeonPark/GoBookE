package kr.or.gobooke.ownerorder.service;

import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.ownerorder.domain.OwnerOrder;
import kr.or.gobooke.users.dao.JdbcUsersDao;
import kr.or.gobooke.users.dao.UsersDao;

/**
 * Users 비즈니스 메소드 선언
 * 
 * @author 김수진
 *
 */

public class OwnerOrderServiceImpl implements OwnerOrderService {
	
	UsersDao userDao = (UsersDao) DaoFactory.getInstance().getDao(JdbcUsersDao.class);

	@Override
	public void create(OwnerOrder ownerOrder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OwnerOrder search(int no) {
		// TODO Auto-generated method stub
		return null;
	}


}
