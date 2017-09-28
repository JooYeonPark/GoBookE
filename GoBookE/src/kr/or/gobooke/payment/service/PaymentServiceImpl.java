package kr.or.gobooke.payment.service;

import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.payment.domain.Payment;
import kr.or.gobooke.users.dao.JdbcUsersDao;
import kr.or.gobooke.users.dao.UsersDao;

/**
 * Users 비즈니스 메소드 선언
 * 
 * @author 김수진
 *
 */

public class PaymentServiceImpl implements PaymentService {
	
	UsersDao userDao = (UsersDao) DaoFactory.getInstance().getDao(JdbcUsersDao.class);

	@Override
	public void create(Payment payment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Payment search(String userId) {
		// TODO Auto-generated method stub
		return null;
	}




}
