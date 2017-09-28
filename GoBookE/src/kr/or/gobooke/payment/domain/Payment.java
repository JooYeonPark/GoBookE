package kr.or.gobooke.payment.domain;

/**
 * 결제 정보 저장을 위한 JavaBean
 * 변수명은 db에서 테이블명을 제외한 것.
 * 
 * @author 김수진
 *
 */

public class Payment {
	
	/** payment 인스턴스 변수 : 3개 */
	private String cardNo;
	private int orderNo;
	private String cardCVC;
	
	
	/** 생성자 */
	public Payment() {}

	public Payment(String cardNo, int orderNo, String cardCVC) {
		this.cardNo = cardNo;
		this.orderNo = orderNo;
		this.cardCVC = cardCVC;
	}
	
	/** getter & setter */
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getCardCVC() {
		return cardCVC;
	}

	public void setCardCVC(String cardCVC) {
		this.cardCVC = cardCVC;
	}

	@Override
	public String toString() {
		return "Payment [cardNo=" + cardNo + ", orderNo=" + orderNo + ", cardCVC=" + cardCVC + "]";
	}

}
