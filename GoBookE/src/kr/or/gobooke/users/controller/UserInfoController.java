package kr.or.gobooke.users.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;
import kr.or.gobooke.common.web.UserId;
import kr.or.gobooke.users.domain.Users;
import kr.or.gobooke.users.service.UserServiceImpl;
import kr.or.gobooke.users.service.UsersService;

public class UserInfoController implements Controller {
	
	private UsersService userService = new UserServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();

		String userId = new UserId().getUserId(request);
		Users user = userService.search(userId);
		
		String[] telArr = user.getTelephone().split("-");
		
		mav.addObject("user", user);
		mav.addObject("tel1", telArr[0]);
		mav.addObject("tel2", telArr[1]);
		mav.addObject("tel3", telArr[2]);
		mav.setView("/view/users/updateuser.jsp");
		
		return mav;
	}

}
