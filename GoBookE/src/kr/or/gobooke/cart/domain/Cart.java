package kr.or.gobooke.cart.domain;

/**
 * 장바구니 데이터 을 위한 JavaBean
 * 
 * @author 박주연
 *
 */

public class Cart {
	
	/** Cart의 인스턴스 변수 : 총 4개 */
	private int no;
	private int cartBookQty;
	private int bookNo;
	private String userId;
	
	/** 생성자 */
	public Cart() {}
	
	public Cart(int bookNo, int cartBookQty, String userId) {
		this(0, cartBookQty, bookNo, userId);
	}

	public Cart(int no, int cartBookQty, int bookNo, String userId) {
		this.no = no;
		this.cartBookQty = cartBookQty;
		this.bookNo = bookNo;
		this.userId = userId;
	}


	/** Getter, Setter */
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCartBookQty() {
		return cartBookQty;
	}

	public void setCartBookQty(int cartBookQty) {
		this.cartBookQty = cartBookQty;
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
		return "Cart [no=" + no + ", cartBookQty=" + cartBookQty + ", bookNo=" + bookNo + ", userId=" + userId + "]";
	}
	
	
}
