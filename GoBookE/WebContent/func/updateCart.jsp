<%-- 카트 수량 수정 ajax통신을 통해 처리 --%>

<%@page import="kr.or.gobooke.cart.service.CartServiceImpl"%>
<%@page import="kr.or.gobooke.cart.service.CartService"%>
<%@page import="kr.or.gobooke.common.web.UserId"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
CartService cartService = new CartServiceImpl();
String userId = request.getParameter("userId");
String title = request.getParameter("bookTitle");
int qty = Integer.parseInt(request.getParameter("qty"));

int total = cartService.update(userId,title,qty);

//배송비추가
total += 2500;
%>

<%=total%>

