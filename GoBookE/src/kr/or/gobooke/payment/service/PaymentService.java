package kr.or.gobooke.payment.service;

import java.util.List;

import kr.or.gobooke.cart.domain.Cart;
import kr.or.gobooke.ownerorder.domain.OwnerOrder;
import kr.or.gobooke.payment.domain.Payment;
import kr.or.gobooke.users.domain.Users;

/**
 * Domain(업무영역)별 고객의 요구사항을 반영하는 비즈니스 메소드 선언
 *
 * @author 김수진
 *
 */
public interface PaymentService {
/** 기능은 따로 구현하시구 이변수명들은 변경하지 말아주세요.*/
	
	/** 카드 신규 등록 */
	public void create(Payment payment);
	
	/** 사용자아이디로 카드번호 조회 */
	public Payment search(String userId);
}
