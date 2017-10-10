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
import kr.or.gobooke.common.web.OwnerOrderPageBuilder;
import kr.or.gobooke.common.web.OwnerOrderParams;
import kr.or.gobooke.common.web.PageBuilder;
import kr.or.gobooke.common.web.Params;
import kr.or.gobooke.ownerorder.domain.OwnerOrder;
import kr.or.gobooke.ownerorder.service.OwnerOrderService;
import kr.or.gobooke.ownerorder.service.OwnerOrderServiceImpl;

/**
 * 출판사명으로 책이름 가져오는 처리
 * 
 * /adminBookOrder 요청에 대한 세부 컨트롤러
 * @author 김기정
 *
 */
public class BookStockListController implements Controller {
	
	private BookServiceImpl2 bookService = new BookService2();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		// 조건 : 국내도서/국외도서. 페이지 값, 
		BookParams params = new BookParams();
		
		int page;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			params.setPage(page);
		}
		
		List<Book> list = bookService.listStock(params);
		int rowCount = bookService.stockpageCount(params);
		
		InexBookPageBuilder pageBuilder = new InexBookPageBuilder(params, rowCount);
		pageBuilder.build();
		
		mav.addObject("rowCount", rowCount);
		mav.addObject("list", list);
		mav.addObject("params", params);
		mav.addObject("pageBuilder", pageBuilder);
		
		mav.setView("/view/admin/adminstock.jsp");
		
		return mav;
	}

}




