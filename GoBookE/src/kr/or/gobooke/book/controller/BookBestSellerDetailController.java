package kr.or.gobooke.book.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.book.domain.Book;
import kr.or.gobooke.book.service.BookService2;
import kr.or.gobooke.book.service.BookServiceImpl2;
import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;

public class BookBestSellerDetailController implements Controller {
	BookServiceImpl2 bookService=new BookService2();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav=new ModelAndView();
		String title=request.getParameter("title");
		Book book=null;
		System.out.println(title);
		book=bookService.getBookByTitle(title);
		
		if(book==null) {
			mav.addObject("title", title);
			mav.setView("/view/books/book_detail_bestSeller.jsp");
		}else {
			mav.addObject("book", book);
			mav.setView("/view/books/book_detail.jsp");
		}
				
		
		return mav;
	}

}
