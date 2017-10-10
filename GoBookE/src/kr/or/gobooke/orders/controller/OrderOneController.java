package kr.or.gobooke.orders.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.book.domain.Book;
import kr.or.gobooke.book.service.BookService2;
import kr.or.gobooke.book.service.BookServiceImpl2;
import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;
import kr.or.gobooke.common.web.UserId;
import kr.or.gobooke.users.domain.OrderUser;
import kr.or.gobooke.users.service.UserServiceImpl;
import kr.or.gobooke.users.service.UsersService;

public class OrderOneController implements Controller {

	private BookServiceImpl2 bookService = new BookService2();
	private UsersService userService = new UserServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		ModelAndView mav = new ModelAndView();
		String userId = new UserId().getUserId(request);
		String bookNo = request.getParameter("bookNo");
		String cartBookQty = request.getParameter("cartBookQty");

		//도서 정보 반환 후 저장
		Book book = bookService.getBookDetail(Integer.parseInt(cartBookQty));

		// 회원 이름, 핸드폰, 주소 값 반환
		OrderUser orderUser = userService.getOrderUser(userId);
		String name = orderUser.getName();
		String telephone = orderUser.getTelephone();
		String address = orderUser.getaddress();
		String addressDetail = orderUser.getaddressDetail();

		String[] sTel = telephone.split("-");
		int[] tel = new int[sTel.length];

		for (int i = 0; i < tel.length; i++) {
			tel[i] = Integer.parseInt(sTel[i]);
		}

		mav.addObject("list", book);
		mav.addObject("total", book.getPrice());
		mav.addObject("rowCount", 1);
		mav.addObject("name", name);
		mav.addObject("tel1", tel[0]);
		mav.addObject("tel2", tel[1]);
		mav.addObject("tel3", tel[2]);
		mav.addObject("address", address);
		mav.addObject("addressDetail", addressDetail);
		mav.setView("/view/orders/order.jsp");

		return mav;
	}

}
