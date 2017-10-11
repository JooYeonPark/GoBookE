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
import kr.or.gobooke.common.web.BookParams;
import kr.or.gobooke.common.web.InexBookPageBuilder;

public class InexBookListController implements Controller {
	private BookServiceImpl2 bookService = new BookService2();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		int category_no = Integer.parseInt(request.getParameter("category_no"));
		int category_big_no = Integer.parseInt(request.getParameter("category_big_no"));
		String title=null;

		int pageSize = 10;
		int pageNum = 10;

		String page = request.getParameter("page");
		if (page == null)
			page = "1";
		int pageCount = Integer.parseInt(page);
		String type = request.getParameter("type");
		String value = request.getParameter("value");

		BookParams params = new BookParams();
		params.setPage(pageCount);
		params.setPageSize(pageSize);
		params.setPageNum(pageNum);
		params.setType(type);
		params.setValue(value);
		params.setCategory_big_no(category_big_no);
		params.setCategory_no(category_no);
		
		// 페이징 및 검색처리
		List<Book> list = bookService.listByParams(params);
		int rowCount = bookService.pageCount(params);

		// 페이징 계산 유틸리티 생성 및 실행
		InexBookPageBuilder pageBuilder = new InexBookPageBuilder(params, rowCount);
		pageBuilder.build();
		
		title=bookService.getCategoryTitle(category_big_no, category_no);
		
		mav.addObject("title", title);
		mav.addObject("category_no", category_no);
		mav.addObject("category_big_no", category_big_no);
		mav.addObject("list", list);
		mav.addObject("params", params);
		mav.addObject("pageBuilder", pageBuilder);

		mav.setView("/view/books/booklist-inex.jsp");

		return mav;
	}

}
