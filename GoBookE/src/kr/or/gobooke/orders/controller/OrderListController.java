package kr.or.gobooke.orders.controller;

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
import kr.or.gobooke.users.domain.OrderUser;
import kr.or.gobooke.users.service.UserServiceImpl;
import kr.or.gobooke.users.service.UsersService;

public class OrderListController implements Controller {
	private CartService cartService = new CartServiceImpl();
	private UsersService userService = new UserServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		ModelAndView mav = new ModelAndView();
		String userId = new UserId().getUserId(request);
		// 장바구니에서 클릭된 리스트의 cartNo을 받아옴
		String clickedCartNo = request.getParameter("cartNoList");
		List<CartList> cartList;

		//전체 상품 구매
		if(clickedCartNo == null) {
			cartList = cartService.listAll(userId);
		}
		//선택 상품 구매
		else {
			// "2,3,4" -> 형식의 문자열을 콤마단위로 한 개씩 잘라 형 변환 한 뒤, cartNoList에 저장
			String[] list = clickedCartNo.split(",");
			int[] cartNoList = new int[list.length];
	
			for (int i = 0; i < list.length; i++) {
				cartNoList[i] = Integer.parseInt(list[i]);
			}
			cartList = cartService.listSome(userId, cartNoList);
		}

		// cart의 총 주문금액 반환
		int total = 0;
		for (CartList cart : cartList) {
			total += cart.getBookTotalPrice();
		}
		

		// 배송비 추가
		total += 2500;
		
		//회원 이름, 핸드폰, 주소 값 반환
		OrderUser orderUser = userService.getOrderUser(userId);
		String name = orderUser.getName();
		String telephone = orderUser.getTelephone();
		String address = orderUser.getaddress();
		String addressDetail = orderUser.getaddressDetail();
		
		String[] tel = telephone.split("-");

		mav.addObject("list", cartList);
		mav.addObject("total", total);
		mav.addObject("rowCount", cartList.size());
		mav.addObject("name", name);
		mav.addObject("tel1", tel[0]);
		mav.addObject("tel2", tel[1]);
		mav.addObject("tel3", tel[2]);
		mav.addObject("address", address);
		mav.addObject("addressDetail", addressDetail);
		mav.addObject("cartNoList", clickedCartNo);
		mav.setView("/view/orders/order.jsp");

		return mav;
	}
}
