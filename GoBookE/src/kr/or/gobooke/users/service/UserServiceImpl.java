package kr.or.gobooke.users.service;

import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.users.dao.JdbcUsersDao;
import kr.or.gobooke.users.dao.UsersDao;
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}


}
