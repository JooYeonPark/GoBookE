package kr.or.gobooke.ownerorder.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;
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
public class OwnerOrderListController implements Controller {
	
	private OwnerOrderService orderService = new OwnerOrderServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		OwnerOrderParams params = new OwnerOrderParams();
		
		int page;
		String type;
		String value;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			params.setPage(page);
		}
		
		if(request.getParameter("type") != null) {
			type = request.getParameter("type");
			System.out.println("type  :" + type);
			params.setType(type);
		}
		
		if(request.getParameter("value") != null) {
			value = request.getParameter("value");
			params.setValue(value);
		}
		
		if(request.getParameter("dateStart") != null) {
			value = request.getParameter("dateStart");
			params.setDateStart(value);
		}
		
		if(request.getParameter("dateEnd") != null) {
			value = request.getParameter("dateEnd");
			params.setDateEnd(value);
		}
		
		//관리자 id받아오기 - 로그인시
		String userID = "bangry";
		params.setType("userID");
		params.setValue(userID);
		
		List<OwnerOrder> list = orderService.listByParams(params);
		int rowCount = orderService.pageCount(params);
		
		OwnerOrderPageBuilder pageBuilder = new OwnerOrderPageBuilder(params, rowCount);
		pageBuilder.build();
		
		mav.addObject("rowCount", rowCount);
		mav.addObject("list", list);
		mav.addObject("params", params);
		mav.addObject("pageBuilder", pageBuilder);
		
		mav.setView("/view/admin/orderslist.jsp");
		
		return mav;
	}

}



