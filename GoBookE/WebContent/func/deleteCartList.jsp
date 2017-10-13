<%-- 카트삭제 ajax통신을 통해 처리 --%>

<%@page import="kr.or.gobooke.cart.service.CartServiceImpl"%>
<%@page import="kr.or.gobooke.cart.service.CartService"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
CartService cartService = new CartServiceImpl();
String userId = request.getParameter("userId");
String title = request.getParameter("bookTitle");

int total = cartService.deleteCart(userId,title);

//배송비 추가
total += 2500;
%>

<%=total%>