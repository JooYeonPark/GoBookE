package kr.or.gobooke.cart.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.cart.service.CartService;
import kr.or.gobooke.cart.service.CartServiceImpl;
import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;

public class CartDeleteController implements Controller {
	private CartService cartService = new CartServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		System.out.println("CartDeleteController 실행 ");
		
		String userId = request.getParameter("userId");
		String title = request.getParameter("bookTitle");
		
		cartService.delete(userId,title);
		
		mav.addObject("type", "user_id");
		mav.addObject("value", userId);
	//	mav.setView("/cartList.do");
		
		return mav;
	}

}
