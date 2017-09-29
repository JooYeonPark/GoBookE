package kr.or.gobooke.cart.domain;

public class CartList {

	private String bookImage;
	private String bookTitle;
	private int cartBookQty;
	private int bookPrice;
	private int bookTotalPrice;
	
	/** 생성자 */
	public CartList() { 
		this(null, null, 0, 0, 0);
	}

	public CartList(String bookImage, String bookTitle, int cartBookQty, int bookPrice, int bookTotalPrice) {
		super();
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

	@Override
	public String toString() {
		return "CartList [bookImage=" + bookImage + ", bookTitle=" + bookTitle + ", cartBookQty=" + cartBookQty
				+ ", bookPrice=" + bookPrice + ", bookTotalPrice=" + bookTotalPrice + "]";
	}
	
}
