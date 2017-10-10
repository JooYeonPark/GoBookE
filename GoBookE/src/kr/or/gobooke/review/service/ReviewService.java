package kr.or.gobooke.review.service;

import java.util.List;

import kr.or.gobooke.common.web.Params;
import kr.or.gobooke.review.domain.Review;
import kr.or.gobooke.users.domain.Users;

/**
 * Domain(업무영역)별 고객의 요구사항을 반영하는 비즈니스 메소드 선언
 *
 * @author 김수진
 *
 */
public interface ReviewService {
	/** 등록은 create 수정은 update 삭제는 delete 조회는 read */
	
	/** 기능은 따로 구현하시구 이변수명들은 변경하지 말아주세요.
	 *  필요 기능은 추가해주시면 됩니다.
	 */
	
	/** 신규 등록 */
	public void create(Review review);
	
	/** 리뷰 수정 */
	public void update(Review review);
	
	public List<Review> getReviewList(Params params);

	public int pageCount(Params params);

	public int reviewWrite(Review review);

	public int deleteReview(int review_no);


}
