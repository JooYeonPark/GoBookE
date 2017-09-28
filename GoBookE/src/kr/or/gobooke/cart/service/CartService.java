package kr.or.gobooke.cart.service;

import java.util.List;

import kr.or.gobooke.cart.domain.Cart;
import kr.or.gobooke.ownerorder.domain.OwnerOrder;
import kr.or.gobooke.users.domain.Users;

/**
 * Domain(업무영역)별 고객의 요구사항을 반영하는 비즈니스 메소드 선언
 *
 * @author 김수진
 *
 */
public interface CartService {
/** 기능은 따로 구현하시구 이변수명들은 변경하지 말아주세요.*/
	
	/** 카트 신규 등록 */
	public void create(Cart cart);
	
	/** 사용자아이디를 이용한 카트리스트 조회 */
	public List<Cart> search(String userId);
	
	/** 카트 수정 */
	public void update(Cart cart);
	
	/** 카트 삭제 */
	public void delete(Cart cart);
}
