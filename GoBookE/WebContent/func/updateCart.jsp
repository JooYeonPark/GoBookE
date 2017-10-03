<%@page import="kr.or.gobooke.cart.service.CartServiceImpl"%>
<%@page import="kr.or.gobooke.cart.service.CartService"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
CartService cartService = new CartServiceImpl();
String userId = request.getParameter("userId");
String title = request.getParameter("bookTitle");
int qty = Integer.parseInt(request.getParameter("qty"));

cartService.update(userId,title,qty);
%>