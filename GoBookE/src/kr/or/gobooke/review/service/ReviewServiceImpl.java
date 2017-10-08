package kr.or.gobooke.review.service;

import java.util.List;

import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.common.web.Params;
import kr.or.gobooke.review.dao.JdbcReviewDao;
import kr.or.gobooke.review.dao.ReviewDao;
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
	
	ReviewDao reviewDao=(ReviewDao)DaoFactory.getInstance().getDao(JdbcReviewDao.class);

	@Override
	public void create(Review review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Review review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Review> getReviewList(Params params) {
		// TODO Auto-generated method stub
		return reviewDao.getReviewList(params);
	}

	@Override
	public int pageCount(Params params) {
		// TODO Auto-generated method stub
		return reviewDao.getReviewPageCount(params);
	}

	@Override
	public int reviewWrite(Review review) {
		return reviewDao.reviewWrite(review);
		
	}

	@Override
	public int deleteReview(int review_no) {
		return reviewDao.reviewDelete(review_no);
	}


}
