package kr.or.gobooke.book.controller;

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
 * 책상세보기 요청 컨트롤러
 * @author 박성준
 *
 */
public class BookDetailController implements Controller {

	BookServiceImpl2 bookService = new BookService2();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		int book_no = Integer.parseInt(request.getParameter("book_no"));

		Book book = bookService.getBookDetail(book_no);

		mav.addObject("book", book);
		mav.setView("/view/books/book_detail.jsp");
		return mav;
	}

}
