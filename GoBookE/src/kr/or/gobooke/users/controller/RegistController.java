package kr.or.gobooke.users.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;
import kr.or.gobooke.users.domain.Users;
import kr.or.gobooke.users.service.UserServiceImpl;
import kr.or.gobooke.users.service.UsersService;

public class RegistController implements Controller {

	private UsersService userService = new UserServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		ModelAndView mav = new ModelAndView();
		Users user = null;
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String telephone = request.getParameter("tel1");
		telephone += "-" + request.getParameter("tel2");
		telephone += "-" + request.getParameter("tel3");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String password = request.getParameter("password");
		
		user = new Users(id, name, password, email, telephone, address, addressDetail);
		
		userService.create(user);
		
		// !!추후 회원가입 결과 화면으로 변경할 것!!
		mav.setView("redirect:/index.jsp");
		
		return mav;
	}

}
