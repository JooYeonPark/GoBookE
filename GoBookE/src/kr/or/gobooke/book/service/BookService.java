package kr.or.gobooke.book.service;

import java.util.List;

import kr.or.gobooke.book.dao.BookDao;
import kr.or.gobooke.book.dao.JdbcBookDao;
import kr.or.gobooke.book.domain.Book;
import kr.or.gobooke.common.db.DaoFactory;

public class BookService implements BookServiceImpl {
	
	BookDao dao = (BookDao) DaoFactory.getInstance().getDao(JdbcBookDao.class);

	@Override
	public void create(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Book book) {
		dao.update(book);
	}

	@Override
	public List<Book> search(String filter, String publisher) {
		return dao.search(filter, publisher);
	}

}
