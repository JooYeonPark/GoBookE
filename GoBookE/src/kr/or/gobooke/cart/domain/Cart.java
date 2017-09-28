package kr.or.gobooke.cart.domain;

/**
 * 장바구니 데이터 을 위한 JavaBean
 * 변수명은 db에서 테이블명을 제외한 것.
 * 
 * @author 김수진
 *
 */

public class Cart {
	
	/** Cart의 인스턴스 변수 : 총 3개 */
	private int no;
	private int bookNo;
	private String userId;
	
	public Cart() {}
	
	public Cart(int bookNo, String userId) {
		this(0, bookNo, userId);
	}

	public Cart(int no, int bookNo, String userId) {
		this.no = no;
		this.bookNo = bookNo;
		this.userId = userId;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Cart [no=" + no + ", bookNo=" + bookNo + ", userId=" + userId + "]";
	}
	
	
}
