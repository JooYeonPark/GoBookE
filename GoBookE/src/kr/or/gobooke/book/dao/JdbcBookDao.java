package kr.or.gobooke.book.dao;

import java.util.List;

import javax.sql.DataSource;

import kr.or.gobooke.book.domain.Book;

/**
 * 책 데이터 베이스 처리 클래스
 * 
 * @author Park Joo-Yeon
 *
 */
public class JdbcBookDao implements BookDao {

	private DataSource dataSource;
	
	/** 생성자 */
	public JdbcBookDao() {}
	
	public JdbcBookDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/** Setter */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	/** 도서 등록 */
	public void create(Book book) {

	}

	@Override
	/** 도서 수정 */
	public void update(Book book) {

	}
	
	@Override
	/** 도서 검색 */
	public List<Book> search(String filter, String content){
		return null;
	}

}
