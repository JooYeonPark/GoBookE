package kr.or.gobooke.users.service;

import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.users.dao.JdbcUsersDao;
import kr.or.gobooke.users.dao.UsersDao;
import kr.or.gobooke.users.domain.OrderUser;
import kr.or.gobooke.users.domain.Users;

/**
 * Users 비즈니스 메소드 선언
 * 
 * @author 박주연
 *
 */

public class UserServiceImpl implements UsersService {
	
	UsersDao userDao = (UsersDao) DaoFactory.getInstance().getDao(JdbcUsersDao.class);

	
	@Override
	public void create(Users user) {
		userDao.create(user);
	}

	@Override
	public Users search(String userId) {
		return userDao.search(userId);
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
	/** 회원 정보 수정 */
	public void userUpdate(String passwd, String address, String addressDetail, String userId) {
		userDao.userUpdate(passwd, address, addressDetail, userId);
	}

	@Override
	/** 관리자 판별 */
	public Boolean isAdmin(String id) {
		return userDao.isAdmin(id);
	}

}
