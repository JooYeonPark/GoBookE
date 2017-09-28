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
	
}
