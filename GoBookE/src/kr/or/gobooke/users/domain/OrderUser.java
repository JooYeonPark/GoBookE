package kr.or.gobooke.users.domain;

public class OrderUser {
	private String name;
	private String telephone;
	private String address;
	private String addressDetail;
	
	/** 생성자 */
	public OrderUser() {}
	
	public OrderUser(String name, String telephone, String address, String addressDetail) {
		this.name = name;
		this.telephone = telephone;
		this.addressDetail = addressDetail;
		this.address = address;
	}

	
	/** Setter, Getter */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String getaddressDetail() {
		return addressDetail;
	}

	public void setaddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	
	
}
