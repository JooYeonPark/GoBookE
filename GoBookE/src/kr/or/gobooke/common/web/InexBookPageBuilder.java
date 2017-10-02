package kr.or.gobooke.common.web;

public class InexBookPageBuilder {
	
private BookParams bookParams;            /** 요청 파라메터 */
	
	private int totalRowCount;        /** 테이블로부터 검색된 행의 수 */
	private int totalPageCount;       /** 연산에 따른 전체페이지 수 */
	private int listNo;               /** 목록 번호 */
	private int currentStartPage;     /** 현재 목록의 시작페이지 번호 */
	private int currentEndPage;       /** 현재 목록의 마지막페이지 번호 */
	private int previousStartPage;    /** 이전 목록의 시작페이지 번호 */
	private int nextStartPage;        /** 다음 목록의 시작페이지 번호 */
	
	
	public InexBookPageBuilder() {
		this(null, 0);
	}
	
	/**
	 * @param params           요청 파라메터
	 * @param totalRowCount    검색타입별 검색된 행의 수
	 */
	public InexBookPageBuilder(BookParams bookParams, int totalRowCount ) {
		this.bookParams = bookParams;
		this.totalRowCount = totalRowCount;
	}

	public BookParams getParams() {
		return bookParams;
	}

	public void setParams(BookParams bookParams) {
		this.bookParams = bookParams;
	}

	public int getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getListNo() {
		return listNo;
	}

	public void setListNo(int listNo) {
		this.listNo = listNo;
	}
	
	public int getCurrentStartPage() {
		return currentStartPage;
	}

	public void setCurrentStartPage(int currentStartPage) {
		this.currentStartPage = currentStartPage;
	}

	public int getCurrentEndPage() {
		return currentEndPage;
	}

	public void setCurrentEndPage(int currentEndPage) {
		this.currentEndPage = currentEndPage;
	}

	public int getPreviousStartPage() {
		return previousStartPage;
	}

	public void setPreviousStartPage(int previousStartPage) {
		this.previousStartPage = previousStartPage;
	}

	public int getNextStartPage() {
		return nextStartPage;
	}

	public void setNextStartPage(int nextStartPage) {
		this.nextStartPage = nextStartPage;
	}

	

	@Override
	public String toString() {
		return "InexBookPageBuilder [bookParams=" + bookParams + ", totalRowCount=" + totalRowCount
				+ ", totalPageCount=" + totalPageCount + ", listNo=" + listNo + ", currentStartPage=" + currentStartPage
				+ ", currentEndPage=" + currentEndPage + ", previousStartPage=" + previousStartPage + ", nextStartPage="
				+ nextStartPage + "]";
	}

	/** 페이징 계산 */
	public void build(){
		// DB로부터 검색된 행의 수에 따른 전체페이지수 계산
		totalPageCount = (int)Math.ceil((double)totalRowCount / bookParams.getPageSize());
		
		// 목록별 번호
		listNo = (bookParams.getPage() - 1) / bookParams.getPageNum();
		//(1~5): 0, (6~10): 1, (11~15): 2, .....
		
		// 현재 목록의 시작페이지번호와 마지막페이지번호 계산
		currentStartPage = (listNo * bookParams.getPageNum()) + 1;
		currentEndPage = (listNo * bookParams.getPageNum()) + bookParams.getPageNum();
		
		/*
		if (currentStartPage > totalPageCount){
			currentStartPage = currentStartPage - params.getPageNum() + 1;
		}
		*/
		if (currentEndPage > totalPageCount){
			currentEndPage = totalPageCount;
		}
		
		// 이전 목록의 시작페이지 번호 계산
		previousStartPage = currentStartPage - bookParams.getPageNum();
		// 첫번째 목록인 경우 1페이지로 설정
		if (previousStartPage < 0)  previousStartPage = 1;
		
		// 다음 목록의 시작페이지 번호 계산
		nextStartPage = currentStartPage + bookParams.getPageNum();
	}
	
	/** 현재 목록에서 [처음으로] 출력 여부 반환 */
	public boolean isShowFirst() {
		return listNo > 0;
	}
	
	/** 현재 목록에서 [끝으로] 출력 여부 반환 */
	public boolean isShowLast() {
		return currentEndPage < totalPageCount;
	}
	
	/** 현재 목록에서 [이전목록] 출력 여부 반환 */
	public boolean isShowPrevious() {
		return listNo > 0;
	}
	
	/** 현재 목록에서 [다음목록] 출력 여부 반환 */
	public boolean isShowNext() {
		return currentEndPage < totalPageCount;
	}
	
	/** 동적 쿼리스트링 반환 */
	public String getQueryString(int page) {
		String queryString = "?page=" + page;
		// 조건검색이 있는 경우
		queryString += bookParams.getType() != null ? "&type=" + bookParams.getType() + "&value=" + bookParams.getValue()  :  "";
		return queryString;
	}

}
