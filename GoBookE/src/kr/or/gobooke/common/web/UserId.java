package kr.or.gobooke.common.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * 쿠키에서 userID를 가져오는 클래스
 * @author 박성준
 *
 */
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
