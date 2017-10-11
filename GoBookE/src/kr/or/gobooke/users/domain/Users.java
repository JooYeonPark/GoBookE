package kr.or.gobooke.users.domain;

/**
 * 사용자 정보 저장을 위한 JavaBean
 * 변수명은 db에서 테이블명을 제외한 것.
 * 
 * @author 박주연
 *
 */

public class Users {
	
	/** 사용자 관련 인스턴스 변수 : 9개 */
	private String id;
	private String name;
	private String password;
	private String email;
	private String telephone;
	private String address;
	private String addressDetail;
	private char adminFlag;
	private String regdate;
	
	public Users() {}
	
	/**
	 * regdate를 뺀 Users생성자
	 * @param id
	 * @param name
	 * @param password
	 * @param email
	 * @param telephone
	 * @param adress
	 * @param adressDetail
	 * @param adminFlag
	 */
	
	
	public Users(String id, String name, String password, String email, String telephone, String address,
			String addressDetail) {
		this(id, name, password, email, telephone, address, addressDetail, 'N', null);
	}

	/**
	 * 모든 속성을 포함한 Users생성자
	 * @param id
	 * @param name
	 * @param password
	 * @param email
	 * @param telephone
	 * @param address
	 * @param addressDetail
	 * @param adminFlag
	 * @param regdate
	 */
	public Users(String id, String name, String password, String email, String telephone, String address,
			String addressDetail, char adminFlag, String regdate) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
		this.addressDetail = addressDetail;
		this.adminFlag = adminFlag;
		this.regdate = regdate;
	}

	/** getter & setter */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String adressDetail) {
		this.addressDetail = adressDetail;
	}

	public char getAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(char adminFlag) {
		this.adminFlag = adminFlag;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	
	/** toString */
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", telephone="
				+ telephone + ", address=" + address + ", adressDetail=" + addressDetail + ", adminFlag=" + adminFlag
				+ ", regdate=" + regdate + "]";
	}
	
	
}
