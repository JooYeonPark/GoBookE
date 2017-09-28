<%@page import="kr.or.gobooke.users.dao.UsersDao"%>
<%@page import="kr.or.gobooke.common.db.DaoFactory"%>
<%@page contentType="text/html; charset=utf-8"%>
<%@page import="sun.rmi.server.Dispatcher"%>
<%@page import="java.sql.Connection" %>

<%
// 브라우저로부터 입력데이터 수신
request.setCharacterEncoding("utf-8"); // UTF-8로 인코딩
/*String id = request.getParameter("id");
String name = request.getParameter("name");
String passwd = request.getParameter("passwd");
String email = request.getParameter("email");
String telephone = request.getParameter("telephone");
String job = request.getParameter("job");
String message = request.getParameter("message");
String regDate = request.getParameter("regDate");*/

// 도메인 객체 생성
//User user = new User(id, name, passwd, email);
String telephone1 = request.getParameter("telephone1");
String telephone2 = request.getParameter("telephone2");
String telephone3 = request.getParameter("telephone3");
String telephone = telephone1+telephone2+telephone3;
%>

<jsp:useBean id="user" class="kr.or.gobooke.users.domain.Users" scope="request"/>
<jsp:setProperty property="*" name="user"/>
<jsp:setProperty property="telephone" name="user" value="<%=telephone %>"/>

<% 
// 수신한 데이터를 UserDao를 이용하여 DB에 Insert
DaoFactory factory = DaoFactory.getInstance();
UsersDao dao = (UsersDao)factory.getDao(JdbcUsersDao.class);
dao.create(user);

//정상적으로 처리될 경우 가입결과 JSP로 포워드
//예외발생 시 웹컨테이너에 의해 error_500.jsp로 자동 포워드
/*request.setAttribute("user", user);
application.getRequestDispatcher("/user/SignUp_result.jsp").forward(request, response);*/

%>

<jsp:forward page="SignUp_result.jsp"></jsp:forward>
