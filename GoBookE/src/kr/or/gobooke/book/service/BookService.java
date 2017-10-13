package kr.or.gobooke.book.service;

import java.util.List;

import kr.or.gobooke.book.domain.Book;
import kr.or.gobooke.common.web.BookParams;

public interface BookService {
	/** 도서 등록 */
	public void create(Book book);

	/** 도서 수정 */
	public void update(Book book); 
	
	public List<Book> search(String filter, String publisher);
	
	public List<Book> listByParams(BookParams params);
	
	/** 도서 재고 리스트 반환 */
	public List<Book> listStock(BookParams params);
	public int stockpageCount(BookParams params);
	
	public int pageCount(BookParams params);

	public Book getBookDetail(int book_no);

	public Book getBookByTitle(String title);

	public List<Book> getInBookList();

	public List<Book> getExBookList();

	public String getCategoryTitle(int category_big_no, int category_no);
	
	/** 출판사 종류 가져오기 */
	public List<String> getPublisher();
}
