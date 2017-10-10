package kr.or.gobooke.common.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class UserId {
	public UserId() { }
	public String getUserId(HttpServletRequest request) {
		String userId = null;
		  Cookie[] cookies = request.getCookies();
		  if(cookies != null){
		    for(Cookie cookie : cookies){
		     String cookieName = cookie.getName();
		     if(cookieName.equals("user")){
		      userId = cookie.getValue();
		     }
		    }
		  }
		  
		  return userId;
	}
}
