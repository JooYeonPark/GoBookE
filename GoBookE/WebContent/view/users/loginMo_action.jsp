<%-- <%@page import="kr.or.gobooke.users.domain.Users"%>
<%@page import="kr.or.gobooke.users.dao.JdbcUsersDao"%>
<%@page import="kr.or.gobooke.common.db.DaoFactory"%>
<%@page import="kr.or.gobooke.users.dao.UsersDao"%>
<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
    // login.jsp
  String id = request.getParameter("id");
  String passwd = request.getParameter("password");

  if (id == null || passwd == null) {
    return;
  }

  // 도메인 객체 생성
  UsersDao dao = (UsersDao)DaoFactory.getInstance().getDao(JdbcUsersDao.class);
  
  // 수신한 데이터를 UserDao를 이용하여 DB에 Insert
  Users user = dao.isMember(id, passwd);

  String url = null;
    
    // 로그인 시도
  if (user != null) { // 로그인 성공
    Cookie userCookie = new Cookie("user", user.getId());
    userCookie.setPath("/"); // 경로설정
    System.out.println("로그인 성공");
    response.addCookie(userCookie);
    
      url = "../index.jsp";
  } else {
    url = "../index.jsp";
  }
  
    response.sendRedirect(url);
  
%> --%>