package kr.or.gobooke.ownerorder.service;

import java.util.List;

import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.common.web.OwnerOrderParams;
import kr.or.gobooke.ownerorder.dao.JdbcOwnerOrderDao;
import kr.or.gobooke.ownerorder.dao.OwnerOrderDao;
import kr.or.gobooke.ownerorder.domain.OwnerOrder;

/**
 * OwnerOrder 비즈니스 메소드 선언
 * 
 * @author 김수진
 *
 */

public class OwnerOrderServiceImpl implements OwnerOrderService {
	
	OwnerOrderDao dao = (OwnerOrderDao) DaoFactory.getInstance().getDao(JdbcOwnerOrderDao.class);

	@Override
	public void create(OwnerOrder ownerOrder) {
		dao.create(ownerOrder);
	}

	@Override
	public OwnerOrder search(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OwnerOrder> listByParams(OwnerOrderParams params) {
		return dao.listByParams(params);
	}

	@Override
	public int pageCount(OwnerOrderParams params) {
		return dao.pageCount(params);
	}


}
