package kr.or.gobooke.users.service;

import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.users.dao.JdbcUsersDao;
import kr.or.gobooke.users.dao.UsersDao;
import kr.or.gobooke.users.domain.OrderUser;
import kr.or.gobooke.users.domain.Users;

/**
 * Users 비즈니스 메소드 선언
 * 
 * @author 김수진
 *
 */

public class UserServiceImpl implements UsersService {
	
	UsersDao userDao = (UsersDao) DaoFactory.getInstance().getDao(JdbcUsersDao.class);

	
	@Override
	public void create(Users user) {
		userDao.create(user);
	}

	@Override
	public Users search(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Users user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Users isMember(String id, String passwd) {
		return userDao.isMember(id, passwd);
	}
	
	@Override
	/** 회원 정보 반환 */
	public OrderUser getOrderUser(String userId) {
		return userDao.getOrderUser(userId);
	}

	@Override
	public void userUpdate(String passwd, String address, String addressDetail, String userId) {
		userDao.userUpdate(passwd, address, addressDetail, userId);
	}


}
