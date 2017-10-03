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

	public List<Book> getBookListByParams(BookParams params);

	public int pageCount(BookParams params);

	public Book getBookDetail(int book_no);
	
}
