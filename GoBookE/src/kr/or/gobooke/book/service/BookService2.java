package kr.or.gobooke.book.service;

import java.util.List;

import kr.or.gobooke.book.dao.BookDao;
import kr.or.gobooke.book.dao.JdbcBookDao;
import kr.or.gobooke.book.domain.Book;
import kr.or.gobooke.common.db.DaoFactory;
import kr.or.gobooke.common.web.BookParams;

public class BookService2 implements BookServiceImpl2 {
	
	BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(JdbcBookDao.class);

	@Override
	public void create(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Book> search(String filter, String publisher) {
		return bookDao.search(filter, publisher);
	}

	@Override
	public List<Book> listByParams(BookParams params) {
		List<Book> bookList=bookDao.getBookListByParams(params);
		return bookList;
	}

	@Override
	public int pageCount(BookParams params) {
		return bookDao.pageCount(params);
	}

	@Override
	public Book getBookDetail(int book_no) {
		return bookDao.getBookDetail(book_no);
	}

	@Override
	public Book getBookByTitle(String title) {
		return bookDao.getBookByTitle(title);
	}

	@Override
	public List<Book> getInBookList() {
		return bookDao.getInBookList();
	}

	@Override
	public List<Book> getExBookList() {
		return bookDao.getExBookList();
	}

	@Override
	public String getCategoryTitle(int category_big_no, int category_no) {
		return bookDao.getCategoryTitle(category_big_no, category_no);
	}

}
