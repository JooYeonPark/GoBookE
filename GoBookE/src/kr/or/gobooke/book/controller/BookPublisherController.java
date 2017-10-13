package kr.or.gobooke.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.gobooke.book.domain.Book;
import kr.or.gobooke.book.service.BookService;

import kr.or.gobooke.book.service.BookServiceImpl;

import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;

/**
 * 출판사가져오는 처리
 * 
 * /book/getpublisher 요청에 대한 세부 컨트롤러
 * @author 김수진
 *
 */
public class BookPublisherController implements Controller {
	
	private BookService bookService=new BookServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		
		ModelAndView mav = new ModelAndView();
		
		String no = request.getParameter("no");
		Book book = null;
		List<String> publisherList = null;
		
		if(no != null) {
			List<Book> bookList = bookService.search("no", no);
			book = bookList.get(0);
			
			publisherList = new ArrayList<String>();
			publisherList.add(book.getPublisher());
		}else {
			publisherList = bookService.getPublisher();
		}
		
		mav.addObject("publisherList", publisherList);
		mav.addObject("book", book);
		
		mav.setView("/view/admin/adminorder.jsp");
		
		return mav;
	}

}




