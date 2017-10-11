<%@page import="kr.or.gobooke.cart.service.CartServiceImpl"%>
<%@page import="kr.or.gobooke.cart.service.CartService"%>
<%@page import="kr.or.gobooke.cart.domain.Cart"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>GoBook-E 장바구니</title>

    <meta name="keywords" content="">

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800' rel='stylesheet' type='text/css'>

    <%-- Bootstrap and Font Awesome css --%>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <%-- Css animations  --%>
    <link href="/css/animate.css" rel="stylesheet">

    <%-- Theme stylesheet, if possible do not edit this stylesheet --%>
    <link href="/css/style.default.css" rel="stylesheet" id="theme-stylesheet">

    <%-- Custom stylesheet - for your changes --%>
    <link href="/css/custom.css" rel="stylesheet">

    <%-- Responsivity for older IE --%>
    <%--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]--%>

    <%-- Favicon and apple touch icons--%>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" href="/img/apple-touch-icon.png" />
    <link rel="apple-touch-icon" sizes="57x57" href="/img/apple-touch-icon-57x57.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/img/apple-touch-icon-72x72.png" />
    <link rel="apple-touch-icon" sizes="76x76" href="/img/apple-touch-icon-76x76.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/img/apple-touch-icon-114x114.png" />
    <link rel="apple-touch-icon" sizes="120x120" href="/img/apple-touch-icon-120x120.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/img/apple-touch-icon-144x144.png" />
    <link rel="apple-touch-icon" sizes="152x152" href="/img/apple-touch-icon-152x152.png" />
    
    <%-- Side Banner --%>
    <script src="/js/sidebanner.js"></script>
    <style type="text/css">
      #STATICMENU { margin: 0pt; padding: 0pt;  position: absolute; right: 0px; top: 0px;}
      td, th {
    display: table-cell;
    vertical-align: inherit;
}
    </style>
    
<script>
window.onload = function(){
	<%-- 선택상품 주문을 위해 cartNo들을 저장하는 변수 --%>
	var clickedCartNo = new String;
	
	//항목 삭제
	$(btnDelete).click(function(){
		var sibling = $(this).parent().siblings();
		var bookTitle = sibling.eq(2).text();
		var tr = $(this).parent().parent();
		
		$.ajax({
			url : "/func/deleteCartList.jsp",
			data : "userId=${cookie.user.value}"+"&bookTitle="+bookTitle,
			success : function(data){
				alert("삭제 완료");
				
				tr.remove();
			},
			error : function(xhr, statusText){
				console.log("("+xhr.status+", "+statusText+")");
			}
		})
		
	});
	
	//수량 수정
	$(btnEdit).click(function(){
		var sibling = $(this).parent().siblings();
		var bookTitle = sibling.eq(2).text();
		
		sibling = $(this).siblings();
		var qty = sibling.eq(0).val();
		
		var price = $(this).parent().siblings().eq(3).text();
		var Booktotal = price * qty;
		
		$.ajax({
			url : "/func/updateCart.jsp",
			data : "userId=${cookie.user.value}"+"&qty="+qty+"&bookTitle="+bookTitle,
			success : function(data){
				alert("수정완료");
				sibling.eq(0).val(qty);
				$("#total").text(${total});
				$("#bookTotalPrice").text(Booktotal);
			},
			error : function(xhr, statusText){
				console.log("("+xhr.status+", "+statusText+")");
			}
		
		})
		
	});

	$(checkBox).click(function(){
		var cartNo = $(this).siblings().eq(0).val();
		clickedCartNo += cartNo + ",";
	});
	
	//전체상품구매
	$(btnAllCheckout).click(function(){
		$(location).attr('href','/order/list.do');
	});
	
	//선택상품구매
	$(btnSomeCheckout).click(function(){
		if(clickedCartNo == ""){ 
			alert("선택 상품이 없습니다."); 
		}
		else{
			$(location).attr('href','/order/list.do?cartNoList='+clickedCartNo);
		}
	});

}


</script>
</head>
<body>
  <div id="all">
  
        <header>
           <!-- *** TOP *** -->
           <jsp:include page="/layout/header.jsp"/>
           <!-- *** TOP END *** -->
           
           <!-- *** NAVBAR ***  -->
           <jsp:include page="/layout/nav.jsp"/>
           <!-- *** NAVBAR END *** -->
        </header>

        <!-- *** LOGIN MODAL *** -->
        <jsp:include page="/layout/loginMo.jsp"/>        
        <!-- *** LOGIN MODAL END *** -->
        
        
        <div id="heading-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h1>Shopping cart</h1>
                    </div>
                    <div class="col-md-6">
                        <ul class="breadcrumb">
                            <li><a href="index.jsp">Home</a>
                            </li>
                            <li>Shopping cart</li>
                        </ul>

                    </div>
                </div>
            </div>
        </div>

        <div id="content">
            <div class="container">
                <div class="row">
                    <div class="col-md-9 clearfix" id="basket">
                    	<div class="box"> 
                            
                                <div class="table-responsive">
                                    <table class="table">
                                       
                                       <%-- 리스트가 존재 할 경우 --%>
                                          <c:if test = "${not empty list}">
                                              <div class="col-md-12">
                                                <p class="text-muted lead">You currently have ${rowCount} item(s) in your cart.</p>
                                              </div>
                                                <thead>
                                                  <tr>
                                                     <th></th>
                                                      <th colspan="2">Product</th>
                                                      <th>Quantity</th>
                                                      <th>Unit price</th>
                                                      <th colspan="2">Total</th>
                                                  </tr>
                                                </thead>
                                                <c:forEach items="${list}" varStatus="status">
                                                  <tbody>
                                                    <tr>
                                                        <td> <input type="checkbox" id="checkBox">
                                                        <input type="hidden" value="${list[status.index].cartNo}" id="cartNo">
                                                        <input type="hidden" value="${list[status.index].cartNo}" id="cartNoList">
                                                        </td>
                                                        <td>
                                                            <a href="#">
                                                                <img src="/img/books/${list[status.index].bookImage}">
                                                            </a>
                                                        </td>
                                                        <td><p id="bookTitle">${list[status.index].bookTitle}</p>
                                                        </td>
                                                        <td>
                                                            <input type="number" value="${list[status.index].cartBookQty}" class="form-control" id="qty">
                                                            <button class="btn btn-default btn-sm" id="btnEdit">EDIT</button>
                                                        </td>
                                                        <td>${list[status.index].bookPrice}</td>
                                                        <td id="bookTotalPrice">${list[status.index].bookTotalPrice}</td>
                                                        <td><i class="fa fa-trash-o" id="btnDelete"></i></td>
                                                    </tr>
                                                    </tbody>
                                                  </c:forEach>
                                                 
                                                 
                                                 <tfoot>
                                                    <tr>
                                                       <th colspan="5">Total</th>
                                                       <th colspan="2" id="total">${total-2500}</th>
                                                    </tr>
                                                 </tfoot>
                                               </c:if> 
                                          
                                          <%-- 리스트가 존재 하지 않을 경우 --%>
                                          <c:if test="${empty list}">
                                            <h2>장바구니에 담긴 리스트가 없습니다</h2>
                                          </c:if>
                                          
                                    </table>

                                </div>
                                <%-- /.table-responsive --%>


                                <div class="box-footer">
                                    <div class="pull-left">
                                     <!--    <a href="#" class="btn btn-default"><i class="fa fa-chevron-left"></i> Continue shopping</a> --> 
                                    </div>
                                    <div class="pull-right">
                                         <button class="btn btn-template-main" id="btnAllCheckout"> 전체상품구매 <i class="fa fa-chevron-right"></i> </button>  
                                         <button class="btn btn-template-main" id="btnSomeCheckout"> 선택상품구매 <i class="fa fa-chevron-right"></i> </button>  
                                    </div>
                                </div>

                            
                        </div>
                        <%-- /.box --%>

                    </div>
                    <%-- /.col-md-9 --%>


                    <%-- SIDE BANNER --%>
                    <c:forEach items="${list}" varStatus="status">
                      <div class="col-md-3">
                      <%--  <div class="box" id="order-summary STATICMENU"> --%>
                          <div class="box" id="STATICMENU">
                              <div class="box-header">
                                  <h3>Order summary</h3>
                              </div>
                              <p class="text-muted">Shipping and additional costs are calculated based on the values you have entered.</p>
  
                              <div class="table-responsive">
                                  <table class="table">
                                      <tbody>
                                          <tr>
                                              <td>Order subtotal</td>
                                              <th>${total-2500}</th> 
                                          </tr>
                                          <tr>
                                              <td>Shipping and handling</td>
                                              <th>2500</th>
                                          </tr>
                                          
                                          <tr class="total">
                                              <td>Total</td>
                                              <th>${total}</th>  
                                          </tr>
                                      </tbody>
                                  </table>
                              </div>
                              
                             <!--  <button class="btn btn-template-main" id="btnCheckout"> CheckOut <i class="fa fa-chevron-right"></i> </button> --> 
                          </div><%-- /.BOX --%>
  
                      </div>
                      <%-- /.col-md-3 --%>
                    </c:forEach>
                    <%-- /SIDE BANNER --%>
                </div>

            </div>
            <%-- /.container --%>
        </div>
        <%-- /#content --%>
        
      <!-- *** FOOTER *** -->
      <jsp:include page="/layout/footer.jsp"/>
      <!-- /#footer -->

        <!-- *** FOOTER END *** -->
    </div>
    <!-- /#all -->
        
    <%-- #### JAVASCRIPT FILES ### --%>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script>
        window.jQuery || document.write('<script src="/js/jquery-1.11.0.min.js"><\/script>')
    </script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    <script src="/js/jquery.cookie.js"></script>
    <script src="/js/waypoints.min.js"></script>
    <script src="/js/jquery.counterup.min.js"></script>
    <script src="/js/jquery.parallax-1.1.3.js"></script>
    <script src="/js/front.js"></script>
  
</body>
</html>