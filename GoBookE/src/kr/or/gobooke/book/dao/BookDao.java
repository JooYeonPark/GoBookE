package kr.or.gobooke.book.dao;

import java.sql.ResultSet;
import java.util.List;

import kr.or.gobooke.book.domain.Book;
import kr.or.gobooke.common.web.BookParams;

/**
 * 책 데이터 베이스 처리 인터페이스
 * 
 * @author Park Joo-Yeon
 *
 */
public interface BookDao {
	/** 도서 등록 */
	public void create(Book book);
	
	/** 도서 수정 - 수량변경 기능(update추가 가능) */
	public void update(Book book);
	
	/** 도서 검색 - 관리자 */
	public List<Book> search(String filter, String content);
	
	/** BOOK 객체 생성*/
	public Book createBook(ResultSet set);

	/** BookParams로 책정보 요청*/	
	public List<Book> getBookListByParams(BookParams params);
	public List<Book> getlistStock(BookParams params);
	
	/**한 페이지에 표기될 갯수 지정*/
	public int pageCount(BookParams params);
	
	public int stockpageCount(BookParams params);
	
	/**책 상세보기 요청*/
	public Book getBookDetail(int book_no);
	
	public Book getBookByTitle(String title);
	
	/** 도서 가격 반환 */
	public int getBookPrice(int bookNo);
	
	/**국내 신간도서 리스트*/
	public List<Book> getInBookList();
	/**외국 신간도서 리스트*/
	public List<Book> getExBookList();
	
	/**해당 카테고리 명 가져오기*/
	public String getCategoryTitle(int category_big_no, int category_no);
	
	/** 출판사 종류 가져오기 */
	public List<String> getPublisher();
	
}
