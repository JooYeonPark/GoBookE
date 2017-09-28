package kr.or.gobooke.review.domain;

/**
 * 리뷰 정보 저장을 위한 JavaBean
 * 변수명은 db에서 테이블명을 제외한 것.
 * 
 * @author 김수진
 *
 */

public class Review {
	
	/** Review의 인스턴스 변수 : 총 6개 */
	private int no;
	private int bookNo;
	private String userId;
	private String regdate;
	private String message;
	private double grade;
	
	public Review() {}

	public Review(int bookNo, String userId, String message, double grade) {
		this(0, bookNo, userId, null, message, grade);
	}

	public Review(int no, int bookNo, String userId, String regdate, String message, double grade) {
		this.no = no;
		this.bookNo = bookNo;
		this.userId = userId;
		this.regdate = regdate;
		this.message = message;
		this.grade = grade;
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Review [no=" + no + ", bookNo=" + bookNo + ", userId=" + userId + ", regdate=" + regdate + ", message="
				+ message + ", grade=" + grade + "]";
	}
	
}
