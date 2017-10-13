package kr.or.gobooke.book.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.book.domain.Book;
import kr.or.gobooke.book.service.BookService;

import kr.or.gobooke.book.service.BookServiceImpl;

import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;

/**
 *
 * 베스트 셀러 상세보기
 * @author 박성준
 *
 */
public class BookBestSellerDetailController implements Controller {
	private BookService bookService=new BookServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav=new ModelAndView();
		String title=request.getParameter("title");
		String categoryId=request.getParameter("categoryId");
		Book book=null;
		book=bookService.getBookByTitle(title);
		
		if(book==null) {//베스트 셀러 상세보기시 책이 없으면 api에서 자료요청
			mav.addObject("title", title);
			mav.addObject("categoryId", categoryId);
			mav.setView("/view/books/book_detail_bestSeller.jsp");
		}else {//베스트셀러 상세보기 책이 존재하면 책정보 
			mav.addObject("book", book);
			mav.setView("/view/books/book_detail.jsp");
		}
				
		
		return mav;
	}

}
