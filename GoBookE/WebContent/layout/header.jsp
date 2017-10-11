
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" uri="/WEB-INF/util-functions.tld" %>
<%@page import="java.net.URLDecoder"%>
<div id="top">
  <div class="container">
    <div class="row">
      
      <div class="col-xs-5 contact">
        <p class="hidden-md hidden-lg">
          <a href="#" data-animate-hover="pulse"><i
            class="fa fa-phone"></i></a> <a href="#"
            data-animate-hover="pulse"><i class="fa fa-envelope"></i></a>
        </p>
      </div>
      
      
      <div class="col-xs-7">
        <div class="login">
          <c:choose>
          <c:when test="${empty cookie.user}">
             <a href="#" data-toggle="modal" data-target="#login-modal"><i class="fa fa-sign-in"></i> <span class="hidden-xs text-uppercase">Sign in</span></a> 
           <!--   <a href="${pageContext.servletContext.contextPath}/view/users/loginAndRegist.do"><i class="fa fa-user"></i><span class="hidden-xs text-uppercase">Sign up</span></a> -->  
              <a href="/view/users/regist.jsp"><i class="fa fa-user"></i><span class="hidden-xs text-uppercase">Sign up</span></a> 
          </c:when>
          <c:otherwise>
          <a href="#" data-toggle="modal" data-target="#login-modal"><i class="fa fa-sign-in"></i> <span class="hidden-xs text-uppercase"><strong>${u:decode(cookie.user.value) }</strong>님 환영합니다.</span></a> 
          <a class="glyphicon glyphicon-log-out" href="${pageContext.servletContext.contextPath}/user/certify.do">LOGOUT</a> 
          <a href="/user/info.do"><i class="glyphicon glyphicon-user"></i><span class="hidden-xs text-uppercase">MyPage</span></a>
          <a href="/order/list.do"><i class="fa fa-shopping-cart"></i><span class="hidden-xs text-uppercase">Cart</span></a>
          </c:otherwise>
        </c:choose>
          
        </div>

      </div>
    </div>
  </div>
</div>