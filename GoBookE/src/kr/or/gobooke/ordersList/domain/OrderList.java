package kr.or.gobooke.ordersList.domain;

/**
 * 주문항목 도메인 (주문항목의 bookNo은 book테이블의 기본키를 참조)
 * 
 * @author Park Joo-Yeon
 *
 */
public class OrderList {
	
	/** 인스턴스 변수 총 5개 */
	private int no;
	private int orderNo;
	private int qty;
	private int price;
	private int bookNo;
	
	/** 생성자 */
	public OrderList() {
		this(0,0,0,0,0);
	}
	
	public OrderList(int orderNo, int qty, int price, int bookNo) {
		this(0, orderNo, qty, price, bookNo);
	}
	
	public OrderList(int no, int orderNo, int qty, int price, int bookNo) {
		this.no = no;
		this.orderNo = orderNo;
		this.qty = qty;
		this.price = price;
		this.bookNo = bookNo;
	}

	
	/** Getter, Setter */
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	@Override
	public String toString() {
		return "OrderList [no=" + no + ", orderNo=" + orderNo + ", qty=" + qty + ", price=" + price + ", bookNo="
				+ bookNo + "]";
	}
	
}
