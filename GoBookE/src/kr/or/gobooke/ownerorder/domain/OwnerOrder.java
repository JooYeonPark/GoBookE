package kr.or.gobooke.ownerorder.domain;

/**
 * 관리자 주문 저장을 위한 JavaBean
 * 변수명은 db에서 테이블명을 제외한 것.
 * 
 * 
 * @author 김수진
 *
 */

public class OwnerOrder {
	
	/** OwnerOrder의 인스턴스 변수는 총 7개 */
	private int no;
	private String publisher;
	private int qty;
	private String bookName;
	private int totalPrice;
	private String date;
	private String user_id;
	
	public OwnerOrder() {}
	
	/**
	 * date를 제외한 나머지 인스턴스 변수로 OwnerOrder생성
	 * @param publisher
	 * @param qty
	 * @param bookName
	 * @param totalPrice
	 * @param user_id
	 */
	public OwnerOrder(String publisher, int qty, String bookName, int totalPrice, String user_id) {
		this(0, publisher, qty, bookName, totalPrice, user_id, null);
	}

	/**
	 * OwnerOrder 생성
	 * @param no
	 * @param publisher
	 * @param qty
	 * @param bookName
	 * @param totalPrice
	 * @param date
	 * @param user_id
	 */
	public OwnerOrder(int no, String publisher, int qty, String bookName, int totalPrice, String date, String user_id) {
		this.no = no;
		this.publisher = publisher;
		this.qty = qty;
		this.bookName = bookName;
		this.totalPrice = totalPrice;
		this.date = date;
		this.user_id = user_id;
	}
	
	/** getter & setter */
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "OwnerOrder [no=" + no + ", publisher=" + publisher + ", qty=" + qty + ", bookName=" + bookName
				+ ", totalPrice=" + totalPrice + ", date=" + date + ", user_id=" + user_id + "]";
	}
	
}
