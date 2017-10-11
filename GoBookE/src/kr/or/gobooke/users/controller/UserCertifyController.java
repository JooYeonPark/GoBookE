package kr.or.gobooke.users.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.gobooke.common.controller.Controller;
import kr.or.gobooke.common.controller.ModelAndView;
import kr.or.gobooke.users.domain.Users;
import kr.or.gobooke.users.service.UserServiceImpl;
import kr.or.gobooke.users.service.UsersService;

public class UserCertifyController implements Controller {
	
	UsersService userService=new UserServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		String location = "/index.do";
		
		// 로그인
		if(request.getMethod().equalsIgnoreCase("post")) {
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			String referer = request.getParameter("referer");
			Users user = userService.isMember(id, passwd);
			if(user != null){
			    String userInfo = null;
				try {
					userInfo = URLEncoder.encode(user.getId(), "utf-8");
				} catch (UnsupportedEncodingException e) {
					throw new ServletException("UserCertifyController.handleRequest() 실행중 예외 발생", e);
				}
				Cookie loginCookie = new Cookie("user", userInfo);
				loginCookie.setPath("/");
				response.addCookie(loginCookie);
			    if(referer != null && referer!="")  { location = referer; }
			    else { location = "/index.do"; }
			}else{
			  location = "/view/users/loginAndRegist.do";
			}
		}else {// 로그아웃
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equalsIgnoreCase("user")) {
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
						break;
					}
				}
			}
		}
		mav.setView("redirect:"+request.getContextPath() + location);
		return mav;
	}

}
