package kr.or.gobooke.common.web;

/**
 *
 * 책목록에 대한 페이지와 카테고리 객체지정 클래스
 * @author 박성준
 *
 */
public class BookParams {
	
	private int page;         /** 사용자 요청 페이지 */
	private String type;      /** 사용자 검색 유형 */
	private String value;     /** 사용자 검색 값 */
	private int pageSize;     /** 페이지에 출력할 행의 수 */
	private int pageNum;      /** 페이지에 출력할 페이지 수 */
	private int category_big_no;
	private int category_no;
	
	public BookParams() {
		this(1, null, null, 10, 10, 0, 0);
	}
	
	public BookParams(int page, String type, String value, int pageSize, int pageNum, int category_big_no, int category_no) {
		this.page = page;
		this.type = type;
		this.value = value;
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.category_big_no=category_big_no;
		this.category_no=category_no;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		if(pageSize < 0 || pageSize > 50){
			this.pageSize = 10;
			return;
		}
		this.pageSize = pageSize;
	}
	

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		if(pageNum < 0 || pageNum > 20){
			this.pageNum = 10;
			return;
		}
		this.pageNum = pageNum;
	}
	
	

	public int getCategory_big_no() {
		return category_big_no;
	}

	public void setCategory_big_no(int category_big_no) {
		this.category_big_no = category_big_no;
	}

	public int getCategory_no() {
		return category_no;
	}

	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}

	@Override
	public String toString() {
		return "BookParams [page=" + page + ", type=" + type + ", value=" + value + ", pageSize=" + pageSize
				+ ", pageNum=" + pageNum + ", category_big_no=" + category_big_no + ", category_no=" + category_no
				+ "]";
	}
}
