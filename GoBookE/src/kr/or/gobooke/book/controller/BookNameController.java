package kr.or.gobooke.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.gobooke.book.domain.Book;
import kr.or.gobooke.book.service.BookService2;
import kr.or.gobooke.book.service.BookServiceImpl2;
import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;

/**
 * 출판사명으로 책이름 가져오는 처리
 * 
 * /searchBookname 요청에 대한 세부 컨트롤러
 * @author 김기정
 *
 */
public class BookNameController implements Controller {
	
	private BookServiceImpl2 bookService = new BookService2();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		
		String publisher = request.getParameter("publisher");
		List<Book> books = bookService.search("publisher", publisher);
		
		JSONObject bookOb;
		JSONArray booksArray = new JSONArray();
		for (Book book : books) {
			bookOb = new JSONObject();
			
			bookOb.put("no", book.getNo());
			bookOb.put("title", book.getTitle());
			bookOb.put("price", book.getPrice());
			bookOb.put("publisher", book.getPublisher());
			
			booksArray.add(bookOb);
		}
		
		String str = booksArray.toJSONString();
		
		response.setContentType("text/plain; charset=utf-8");
		
		try {
			PrintWriter out = response.getWriter();
			out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}




