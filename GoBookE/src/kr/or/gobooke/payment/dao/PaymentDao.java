package kr.or.gobooke.payment.dao;

import kr.or.gobooke.payment.domain.Payment;

/**
 * Payment 관련 Dao 주요 기능
 * 
 * 
import kr.or.gobooke.payment.domain.Payment;@author 김수진
 */

public interface PaymentDao {
	/** 기능은 따로 구현하시구 이 변수명들은 변경하지 말아주세요.*/
	
	/** 카드 신규 등록 */
	public void create(Payment payment);
	
	/** 사용자아이디로 카드번호 조회 */
	public Payment search(String userId);
	
}