package kr.or.gobooke.book.service;

import kr.or.gobooke.book.domain.Book;

public interface BookServiceImpl {
	/** 도서 등록 */
	public void create(Book book);

	/** 도서 수정 */
	public void update(Book book); 
}
