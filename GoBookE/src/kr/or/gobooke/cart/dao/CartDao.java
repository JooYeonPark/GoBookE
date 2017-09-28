package kr.or.gobooke.cart.dao;

import java.util.List;

import kr.or.gobooke.cart.domain.Cart;
import kr.or.gobooke.users.domain.Users;

/**
 * Cart 관련 Dao 주요 기능
 * 
 * @author 김수진
 */

public interface CartDao {
	/** 기능은 따로 구현하시구 이 변수명들은 변경하지 말아주세요.*/
	
	/** 카트 신규 등록 */
	public void create(Cart cart);
	
	/** 사용자아이디를 이용한 카트리스트 조회 */
	public List<Cart> search(String userId);
	
	/** 카트 수정 */
	public void update(Cart cart);
	
	/** 카트 삭제 */
	public void delete(Cart cart);
	
}
