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
		String passwd=request.getParameter("passwd");
		String address=request.getParameter("address");
		String addressDetail=request.getParameter("addressDetail");
		String userId=request.getParameter("userId");
		
		
		userService.userUpdate(passwd, address, addressDetail, userId);
		mav.setView("");//회원 수정 후 회원정보수정 페이지로 이동(redirect로)
		return mav;
	}

}
