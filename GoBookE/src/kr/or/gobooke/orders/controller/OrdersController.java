package kr.or.gobooke.orders.controller;

import java.util.ArrayList;
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
import kr.or.gobooke.orders.domain.Orders;
import kr.or.gobooke.orders.service.OrdersService;
import kr.or.gobooke.orders.service.OrdersServiceImpl;
import kr.or.gobooke.ordersList.service.OrderListService;
import kr.or.gobooke.ordersList.service.OrderListServiceImpl;

public class OrdersController implements Controller {
	private OrdersService ordersService = new OrdersServiceImpl();
	private OrderListService ordersListService = new OrderListServiceImpl();
	private CartService cartService = new CartServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();

		String userId = new UserId().getUserId(request);
		String name = request.getParameter("order-name");
		String postcode = request.getParameter("postcode");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String deliveryMsg = request.getParameter("deliveryMsg");
		String totalPrice = request.getParameter("totalPrice");
		String cartNoList = request.getParameter("cartNoList");
		System.out.println("OrdersController 40 : "+ cartNoList);

		String telephone = request.getParameter("order-tel1");
		telephone += "-" + request.getParameter("order-tel2");
		telephone += "-" + request.getParameter("order-tel3");

		String cardNum = request.getParameter("card1");
		cardNum += "-" + request.getParameter("card2");
		cardNum += "-" + request.getParameter("card3");
		cardNum += "-" + request.getParameter("card4");

		String cvc = request.getParameter("cvc1");
		cvc += request.getParameter("cvc2");
		cvc += request.getParameter("cvc3");

		List<CartList> cartList = new ArrayList<CartList>();

		// orders insert
		int orderNo = ordersService.create(
				new Orders(Integer.parseInt(totalPrice), name, address, addressDetail, deliveryMsg, telephone, userId));

		// 전체주문
		if (cartNoList.equals("")) {
			// 주문될 카트리스트 반환
			cartList = cartService.listAll(userId);

			// orderList insert
			for (CartList cart : cartList) {
				ordersListService.create(orderNo, cart.getCartNo());
			}
		}

		// 선택주문
		else {
			/*
			 * String형태의 cartNo("2,3,4")을 콤마단위로 한 개씩 잘라 형 변환 한 뒤 cartNoArr int 배열에 저장
			 */
			String[] list = cartNoList.split(",");
			int[] cartNoArr = new int[list.length];
			for (int i = 0; i < list.length; i++) {
				cartNoArr[i] = Integer.parseInt(list[i]);
			}

			// 주문될 카트리스트 반환
			cartList = cartService.listSome(userId, cartNoArr);

			// orderList insert
			for (int i = 0; i < cartNoArr.length; i++) {
				ordersListService.create(orderNo, cartNoArr[i]);
			}
		}

		// cart의 총 주문금액 반환
		int total = 0;
		for (CartList cart : cartList) {
			total += cart.getBookTotalPrice();
		}

		// 배송비 추가
		total += 2500;

		mav.addObject("name", name);
		mav.addObject("postcode", postcode);
		mav.addObject("address", address);
		mav.addObject("addressDetail", addressDetail);
		mav.addObject("telephone", telephone);
		mav.addObject("deliveryMsg", deliveryMsg);
		mav.addObject("orderNo", orderNo);
		mav.addObject("list", cartList);
		mav.addObject("total", total);
		mav.setView("/view/orders/orderresult.jsp");

		return mav;
	}

}
