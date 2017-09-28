package kr.or.gobooke.orders.domain;

/**
 * 주문 도메인
 * 
 * @author Park Joo-Yeon
 *
 */
public class Orders {
	
	/** 인스턴스 변수 총 9개 */
	private int no;
	private int totalprice;
	private String userName;
	private String date;
	private String address;
	private String addressDetail;
	private String message;
	private String telephone;
	private String userId;
	
	
	/** 생성자 */
	
	public Orders() {
		this(0,0,null,null,null,null,null,null,null);
	}
	
	public Orders(int totalprice, String userName, String address, String addressDetail,
			String message, String telephone, String userId) {
		this(0,totalprice,userName,null,address,addressDetail,message,telephone,userId);
	}
	
	public Orders(int no, int totalprice, String userName, String date, String address, String addressDetail,
			String message, String telephone, String userId) {
		this.no = no;
		this.totalprice = totalprice;
		this.userName = userName;
		this.date = date;
		this.address = address;
		this.addressDetail = addressDetail;
		this.message = message;
		this.telephone = telephone;
		this.userId = userId;
	}
	
	

	/** Getter, Setter */

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "orders [no=" + no + ", totalprice=" + totalprice + ", userName=" + userName + ", date=" + date
				+ ", address=" + address + ", addressDetail=" + addressDetail + ", message=" + message + ", telephone="
				+ telephone + ", userId=" + userId + "]";
	}
	
}
