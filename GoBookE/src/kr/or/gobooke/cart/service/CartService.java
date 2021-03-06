package kr.or.gobooke.cart.service;

import java.util.List;

import kr.or.gobooke.cart.domain.Cart;
import kr.or.gobooke.cart.domain.CartList;

/**
 * 장바구니에 관한 고객의 요구사항을 반영하는 비즈니스 메소드 선언
 *
 * @author Park Joo-Yeon
 *
 */
public interface CartService {
	
	/** 카트 신규 등록 */
	public void create(Cart cart);
	
	/** 사용자아이디를 이용한 카트리스트 전체 조회 */
	public List<CartList> listAll(String userId);
	
	/** 카트 수정 및 total 반환 */
	public int update(String userId, String bookTitle, int qty);
	
	/** 카트 삭제 및 total 반환 */
	public int deleteCart(String userId,String bookTitle);
	
	/** 카트리스트 부분 조회 */
	public List<CartList> listSome(String userId, int[] cartNoList);
}
