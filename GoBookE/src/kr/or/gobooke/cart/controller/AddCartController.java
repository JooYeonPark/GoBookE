package kr.or.gobooke.cart.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.cart.domain.Cart;
import kr.or.gobooke.cart.service.CartService;
import kr.or.gobooke.cart.service.CartServiceImpl;
import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;

public class AddCartController implements Controller{
	private CartService cartService = new CartServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		String bookNo = request.getParameter("bookNo");
		String cartBookQty = request.getParameter("cartBookQty");
		String userId = "joo";
		
		cartService.create(new Cart(Integer.parseInt(bookNo), Integer.parseInt(cartBookQty), userId));

		mav.setView("/cart/list.do");
		
		return mav;
	}
}
