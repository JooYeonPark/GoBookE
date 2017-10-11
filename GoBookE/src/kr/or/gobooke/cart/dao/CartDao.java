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
	public List<CartList> listAll(String userId);
	
	/** 카트리스트 부분 조회 */
	public List<CartList> listSome(String userId, int[] cartNoList);
	
	/** 카트 수정 */
	public int update(String userId, String bookTitle, int qty);
	
	/** 카트 삭제 */
	public void deleteCart(String userId, String bookTitle);

	/** 카트 반환 */
	public Cart getCart(int cartNo);

	
}
