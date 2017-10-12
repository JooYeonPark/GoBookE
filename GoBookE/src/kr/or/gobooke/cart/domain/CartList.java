package kr.or.gobooke.cart.domain;

public class CartList {
	
	private int cartNo;
	private String bookImage;
	private String bookTitle;
	private int cartBookQty;
	private int bookPrice;
	private int bookTotalPrice;
	
	
	/** 생성자 */
	public CartList() { 
		this(0, null, null, 0, 0, 0);
	}

	public CartList(int cartNo, String bookImage, String bookTitle, int cartBookQty, int bookPrice, int bookTotalPrice) {
		this.cartNo = cartNo;
		this.bookImage = bookImage;
		this.bookTitle = bookTitle;
		this.cartBookQty = cartBookQty;
		this.bookPrice = bookPrice;
		this.bookTotalPrice = bookTotalPrice;
	}

	/** Getter, Setter */
	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getCartBookQty() {
		return cartBookQty;
	}

	public void setCartBookQty(int cartBookQty) {
		this.cartBookQty = cartBookQty;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getBookTotalPrice() {
		return bookTotalPrice;
	}

	public void setBookTotalPrice(int bookTotalPrice) {
		this.bookTotalPrice = bookTotalPrice;
	}
	
	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	@Override
	public String toString() {
		return "CartList [bookImage=" + bookImage + ", bookTitle=" + bookTitle + ", cartBookQty=" + cartBookQty
				+ ", bookPrice=" + bookPrice + ", bookTotalPrice=" + bookTotalPrice + "]";
	}
	
}
