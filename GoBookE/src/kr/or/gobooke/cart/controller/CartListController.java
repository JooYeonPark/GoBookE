package kr.or.gobooke.cart.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.cart.domain.CartList;
import kr.or.gobooke.cart.service.CartService;
import kr.or.gobooke.cart.service.CartServiceImpl;
import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;
import kr.or.gobooke.common.web.UserId;

/**
 * 장바구니 리스트를 보여주기 위한 컨트롤러
 * 
 * @author Park Joo-Yeon
 *
 */
public class CartListController implements Controller {

	private CartService cartService = new CartServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		ModelAndView mav = new ModelAndView();
		String userId = new UserId().getUserId(request);
		List<CartList> cartList;

		cartList = cartService.listAll(userId);

		// cart의 총 주문금액 반환
		int total = 0;
		for (CartList cart : cartList) {
			total += cart.getBookTotalPrice();
		}

		// 배송비 추가
		total += 2500;

		mav.addObject("list", cartList);
		mav.addObject("total", total);
		mav.addObject("rowCount", cartList.size());

		mav.setView("/view/orders/cart.jsp");

		return mav;
	}

}
