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
import kr.or.gobooke.common.web.PageBuilder;
import kr.or.gobooke.common.web.Params;

/**
 * 장바구니 리스트를 보여주기 위한 컨트롤러
 * 
 * @author Park Joo-Yeon
 *
 */
public class CartListController implements Controller {

	private CartService cartService = new CartServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		/************ useBean역할, 페이징처리 정보 셋팅 ************/
		int pageSize = 5;
		int pageNum = 5;
		
		String page = request.getParameter("page");
		if(page == null) { page= "1"; }
		int pageCount = Integer.parseInt(page);
//		String type = request.getParameter("type");
//		String value = request.getParameter("value");
		String type = "user_id";
		String value = "joo";
		
		Params params = new Params();
		params.setPage(pageCount);
		params.setType(type);
		params.setValue(value);
		/************************************/
		
		List<CartList> cartList = cartService.listAll(params);
		
		//cart의 총 주문금액 반환
		int total = 0;
		for (CartList cart : cartList) {
			total += cart.getBookTotalPrice(); 
		}
		
		//배송비 추가
		total += 2500;
		
		//페이징 계산을 위한 cart안의 책 갯수 반환
		int rowCount = cartService.pageCount(params);
		
		//페이징 계산 유틸리티 생성
		PageBuilder pageBuilder = new PageBuilder(params, rowCount);
		
		//페이징 계산		
		pageBuilder.build();
		
		mav.addObject("list", cartList);
		mav.addObject("total", total);
		mav.addObject("rowCount", rowCount);
		mav.addObject("pageBuilder", pageBuilder);
		mav.addObject("params", params);
		mav.setView("/view/orders/cart.jsp");
		
		return mav;
	}

}
