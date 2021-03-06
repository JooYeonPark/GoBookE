package kr.or.gobooke.ownerorder.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.book.domain.Book;
import kr.or.gobooke.book.service.BookService;
import kr.or.gobooke.book.service.BookServiceImpl;
import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;
import kr.or.gobooke.common.web.UserId;
import kr.or.gobooke.ownerorder.domain.OwnerOrder;
import kr.or.gobooke.ownerorder.service.OwnerOrderService;
import kr.or.gobooke.ownerorder.service.OwnerOrderServiceImpl;

/**
 * 출판사명으로 책이름 가져오는 처리
 * 
 * /adminBookOrder 요청에 대한 세부 컨트롤러
 * @author 김수진
 *
 */
public class BookOrderController implements Controller {
	
	private OwnerOrderService orderService = new OwnerOrderServiceImpl();
	private BookService bookService=new BookServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		String bookNo = request.getParameter("bookNo");
		
		String str = request.getParameter("qty");
		int qty = Integer.parseInt(str);
		
		str = request.getParameter("totalprice");
		int totalprice = Integer.parseInt(str);
		
		List<Book> books = bookService.search("no", bookNo);
		Book book = books.get(0);
		int bookQty = book.getQty();
		bookQty += qty;
		book.setQty(bookQty);
		
		//발주 리스트에 추가.
		//나중에 user_id 로그인에서 받아오기.
		String userid = new UserId().getUserId(request);
		/*OwnerOrder ownerOrder = new OwnerOrder(book.getPublisher(), qty, book.getTitle(), totalprice, userid);*/
		OwnerOrder ownerOrder=new OwnerOrder();
		ownerOrder.setPublisher(book.getPublisher());
		ownerOrder.setQty(qty);
		ownerOrder.setBookName(book.getTitle());
		ownerOrder.setTotalPrice(totalprice);
		ownerOrder.setUser_id(userid);
		orderService.create(ownerOrder);
		
		//book update - book_qty에 수량 추가
		bookService.update(book);
		
		mav.setView("/admin/adminbookorderlist.do");
		
		return mav;
	}

}




