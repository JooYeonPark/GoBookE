package kr.or.gobooke.book.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.book.domain.Book;
import kr.or.gobooke.book.service.BookService2;
import kr.or.gobooke.book.service.BookServiceImpl2;
import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;

/**
 *
 * 신간도서 요청 컨트롤러
 * @author 박성준
 *
 */
public class NewBookController implements Controller {
	private BookServiceImpl2 bookService = new BookService2();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav=new ModelAndView();
		List<Book> inBook=bookService.getInBookList();
		List<Book> exBook=bookService.getExBookList();
		
		mav.addObject("inBookList", inBook);
		mav.addObject("exBookList", exBook);
		mav.setView("/view/books/book_new.jsp");
		return mav;

	}

}
