package kr.or.gobooke.review.dao;

import java.util.List;

import kr.or.gobooke.common.web.Params;
import kr.or.gobooke.review.domain.Review;

/**
 * Review 관련 Dao 주요 기능
 * 
 * @author 김수진
 */

public interface ReviewDao {
	/** 추가 기능은 따로 구현하시구 이 변수명들은 변경하지 말아주세요.*/
	
	/** 신규 등록 */
	public void create(Review review);
	
	/** 리뷰 수정 */
	public void update(Review review);
	
	public List<Review> getReviewList(Params params);

	public int getReviewPageCount(Params params);

	public int reviewWrite(Review review);

	public int reviewDelete(int review_no);
	
}
