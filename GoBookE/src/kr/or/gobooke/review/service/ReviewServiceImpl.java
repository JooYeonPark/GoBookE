package kr.or.gobooke.review.service;

import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.review.domain.Review;
import kr.or.gobooke.users.dao.JdbcUsersDao;
import kr.or.gobooke.users.dao.UsersDao;

/**
 * Users 비즈니스 메소드 선언
 * 
 * @author 김수진
 *
 */

public class ReviewServiceImpl implements ReviewService {
	
	UsersDao userDao = (UsersDao) DaoFactory.getInstance().getDao(JdbcUsersDao.class);

	@Override
	public void create(Review review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Review review) {
		// TODO Auto-generated method stub
		
	}


}
