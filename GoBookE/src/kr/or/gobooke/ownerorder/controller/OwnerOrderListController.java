package kr.or.gobooke.ownerorder.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;
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
		
		Params params = new Params();
		
		int page;
		String type;
		String value;
		String str = "<table class='table table-hover'> " + 
					 "        <thead> " + 
					 "          <tr> " + 
					 "            <th>Order</th> " + 
					 "            <th>BookName</th> " + 
					 "            <th>Publisher</th> " + 
					 "            <th>QTY</th> " + 
					 "            <th>Price</th> " + 
					 "            <th>Order Date</th> " + 
					 "          </tr> " + 
					 "        </thead> " + 
					 "        <tbody> "; 
		
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			params.setPage(page);
		}
		
		if(request.getParameter("type") != null) {
			type = request.getParameter("type");
			params.setType(type);
		}
		
		if(request.getParameter("value") != null) {
			value = request.getParameter("value");
			params.setValue(value);
		}
		
		List<OwnerOrder> list = orderService.listByParams(params);
		int rowCount = orderService.pageCount(params);
		
		PageBuilder pageBuilder = new PageBuilder(params, rowCount);
		pageBuilder.build();
		
		if(list.size() == 0) {
			str += "<tr><td colspan='6'>검색된 결과가 없습니다.</td></tr>";
		}else {
			for (OwnerOrder order : list) {
				String s = "<tr>"+
						   "<td>"+order.getNo()+"</td>" +
						   "<td>"+order.getBookName()+"</td>" +
						   "<td>"+order.getPublisher()+"</td>" +
						   "<td>"+order.getQty()+"</td>" +
						   "<td>"+order.getTotalPrice()+"</td>" +
						   "<td>"+order.getDate()+"</td> </tr>";
				str += s;
			}
		}
		
		str += "        </tbody> " + 
			   "      </table> ";
		
		System.out.println(str);
		
		mav.addObject("str", str);
		mav.addObject("list", list);
		mav.addObject("params", params);
		mav.addObject("pageBuilder", pageBuilder);
		
		mav.setView("/view/admin/orderslist.jsp");
		
		return mav;
	}

}




