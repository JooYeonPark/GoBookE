package kr.or.gobooke.orders.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;
import kr.or.gobooke.common.web.OrdersPageBuilder;
import kr.or.gobooke.common.web.OrdersParams;
import kr.or.gobooke.common.web.UserId;
import kr.or.gobooke.orders.domain.Orders;
import kr.or.gobooke.orders.service.OrdersService;
import kr.or.gobooke.orders.service.OrdersServiceImpl;

/**
 * 사용자 마이페이지 orderList가져오는 컨트롤러
 * 
 * /userorderlist 요청에 대한 세부 컨트롤러
 * @author 김수진
 *
 */
public class UserOrderListController implements Controller {
	
	private OrdersService orderService = new OrdersServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		OrdersParams params = new OrdersParams();
		
		int page;
		String type = "userID";
		String value = new UserId().getUserId(request);

		params.setType(type);
		params.setValue(value);
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			params.setPage(page);
		}
		
		if(request.getParameter("dateStart") != null) {
			value = request.getParameter("dateStart");
			params.setDateStart(value);
		}
		
		if(request.getParameter("dateEnd") != null) {
			value = request.getParameter("dateEnd");
			params.setDateEnd(value);
		}
		
		List<Orders> list = orderService.listByParams(params);
		int rowCount = orderService.pageCount(params);
		
		OrdersPageBuilder pageBuilder = new OrdersPageBuilder(params, rowCount);
		pageBuilder.build();
		
		mav.addObject("rowCount", rowCount);
		mav.addObject("list", list);
		mav.addObject("params", params);
		mav.addObject("pageBuilder", pageBuilder);
		
		mav.setView("/view/users/userorderlist.jsp");
		
		return mav;
	}

}




