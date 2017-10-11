package kr.or.gobooke.users.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;
import kr.or.gobooke.users.service.UserServiceImpl;
import kr.or.gobooke.users.service.UsersService;

public class UserUpdateController implements Controller {
	UsersService userService=new UserServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		ModelAndView mav=new ModelAndView();
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String addressDetail=request.getParameter("addressDetail");
		String userId=request.getParameter("id");
		
		System.out.println("비번:"+password+"주소:"+address);
		userService.userUpdate(password, address, addressDetail, userId);

		mav.setView("redirect:/user/info.do");
		return mav;
	}

}
