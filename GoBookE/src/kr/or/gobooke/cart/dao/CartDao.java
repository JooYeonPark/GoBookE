package kr.or.gobooke.cart.dao;

import java.util.List;

import kr.or.gobooke.cart.domain.Cart;
import kr.or.gobooke.cart.domain.CartList;
import kr.or.gobooke.common.web.Params;

/**
 * Cart 관련 Dao 주요 기능
 * 
 * @author 박주연
 */

public interface CartDao {
	
	/** 카트 신규 등록 */
	public void create(Cart cart);
	
	/** 카트리스트 전체 조회 */
	public List<CartList> listAll(Params params);
	
	/** 카트 수정 */
	public void update(Cart cart);
	
	/** 카트 삭제 */
	public void delete(Cart cart);
	
	/** 출력페이지 계산을 위한 {검색유형, 검색값}에 대한 행의 수 반환 */
	public int pageCount(Params params);
	
}
