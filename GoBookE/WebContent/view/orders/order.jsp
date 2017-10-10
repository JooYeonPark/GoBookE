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

    <title>GoBook-E 주문화면</title>

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
    

    <%-- SideBanner --%>
    <script src="/js/sidebanner.js"></script>
    <style type="text/css">
    #STATICMENU { margin: 0pt; padding: 0pt;  position: absolute; right: 0px; top: 0px;}
    </style>
    
   <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
  
  <script>
  
  window.onload = function(){
	  getOrderUser();
	
	$(same).click(function(){
		getOrderUser();
	});
	
	$(different).click(function(){
		orderUserRemove();
	});
  }
  
  function getOrderUser(){
	  $("#order-name").val("${name}");
		$("#receiver-name").val("${name}");
		
		$("#tel1 option:selected").text("${tel1}");
		$("#tel2").val("${tel2}");
		$("#tel3").val("${tel3}");
		$("#order-tel1 option:selected").text("${tel1}");
		$("#order-tel2").val("${tel2}");
		$("#order-tel3").val("${tel3}");
		
		$("#address").val("${address}");
		$("#addressDetail").val("${addressDetail}");
  }
  
  function orderUserRemove(){
	  $("#order-name").val("");
		$("#receiver-name").val("");
		
		$("#tel1 option:selected").text("");
		$("#tel2").val("");
		$("#tel3").val("");
		$("#order-tel1 option:selected").text("");
		$("#order-tel2").val("");
		$("#order-tel3").val("");
		
		$("#address").val("");
		$("#addressDetail").val("");
  }
  
  <%-- 주소 API --%>
      function daumPostcode() {
          new daum.Postcode({
              oncomplete: function(data) {
                  // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
  
                  // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                  // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                  var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                  var extraRoadAddr = ''; // 도로명 조합형 주소 변수
  
                  // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                  // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                  if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                      extraRoadAddr += data.bname;
                  }
                  // 건물명이 있고, 공동주택일 경우 추가한다.
                  if(data.buildingName !== '' && data.apartment === 'Y'){
                     extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                  }
                  // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                  if(extraRoadAddr !== ''){
                      extraRoadAddr = ' (' + extraRoadAddr + ')';
                  }
                  // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                  if(fullRoadAddr !== ''){
                      fullRoadAddr += extraRoadAddr;
                  }
  
                  // 우편번호와 주소 정보를 해당 필드에 넣는다.
                  document.getElementById('postcode').value = data.zonecode; //5자리 새우편번호 사용
                  document.getElementById('address').value = fullRoadAddr;
  					
                  document.getElementById('guide').innerHTML = '(상세주소 예 : 101동 101호)';
                  
              }
          }).open();
      }
	</script>
</head>

<body>

    <div id="all">

        <header>
            <%-- *** TOP *** --%>
            <jsp:include page="/layout/header.jsp"/>
            <%-- *** TOP END *** --%>
            <%-- *** NAVBAR ***  --%>
            <jsp:include page="/layout/nav.jsp"/>
            <%-- *** NAVBAR END *** --%>
        </header>

        <%-- *** LOGIN MODAL *** --%>
        <jsp:include page="/layout/loginMo.jsp"/>        
        <%-- *** LOGIN MODAL END *** --%>

        
        <%-- *** ORDER *** --%>
        <div id="heading-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-7">
                        <h1>Checkout</h1>
                    </div>
                    <div class="col-md-5">
                        <ul class="breadcrumb">
                            <li><a href="/index.jsp">Home</a>
                            </li>
                            <li>Checkout</li>
                        </ul>

                    </div>
                </div>
            </div>
        </div>

        <div id="content">
            <div class="container">

                <div class="row">

                    <div class="col-md-9 clearfix" id="checkout">

                        <div class="box">
                            <form action="/order.do" method="post" >
                                 <div class="content">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                  <tr>
                                                     <th></th>
                                                      <th colspan="2">Product</th>
                                                      <th>Quantity</th>
                                                      <th>Unit price</th>
                                                      <th colspan="2">Total</th>
                                                  </tr>
                                            </thead>
                                            <tbody>
                                               <c:forEach items="${list}" varStatus="status">
                                                 <tr>
                                                    <td>
                                                      <input type="hidden" value="${list[status.index].cartNo}" id="cartNo">
                                                    </td>
                                                    <td>
                                                       <a href="#">
                                                          <img src="/img/books/${list[status.index].bookImage}">
                                                       </a>
                                                     </td>
                                                     <td><p id="bookTitle">${list[status.index].bookTitle}</p></td>
                                                     <td>
                                                       <input type="number" value="${list[status.index].cartBookQty}" class="form-control" id="qty">
                                                     </td>
                                                     <td>${list[status.index].bookPrice}</td>
                                                     <td>${list[status.index].bookTotalPrice}</td>
                                                 </tr>
                                               </c:forEach>
                                            </tbody>
                                            <tfoot>
                                                <tr>
                                                   <th colspan="5">Total</th>
                                                   <th colspan="2">${total-2500} </th>
                                                </tr>
                                            </tfoot>
                                        </table>

                                    </div>
                                    <%-- /.table-responsive --%>
                                </div> <%-- /.content --%>
                                
                                
                              <%-- 주문자 정보는 기존의 user정보를 디비에서 불러와 찍어줌 --%>
                              <fieldset>
                                <legend>주문정보</legend>
                                     <div class="content">
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <div class="form-group">
                                                    <label for="order-name">주문자</label>
                                                    <input type="text" class="form-control" id="order-name" value="">
                                                </div>
                                            </div>
                                      </div>  <%-- /.row --%>
                                      
                                      
                                      
                                       <label for="telephone">휴대폰번호</label>
                                       <div class="row">
                                              <div class="col-sm-2 form-group">
                                                      <select class="form-control" style="width:100%; text-align: center;">
                                                        <option value="010">010</option>
                                                        <option value="02">02</option>
                                                        <option value="031">031</option>
                                                        <option value="032">032</option>
                                                        <option value="033">033</option>
                                                        <option value="041">041</option>
                                                        <option value="042">042</option>
                                                        <option value="043">043</option>
                                                        <option value="051">051</option>
                                                        <option value="052">052</option>
                                                        <option value="053">053</option>
                                                        <option value="054">054</option>
                                                        <option value="055">055</option>
                                                        <option value="061">061</option>
                                                        <option value="062">062</option>
                                                        <option value="063">063</option>
                                                        <option value="064">064</option>
                                                      </select>
                                                </div><%-- ./col-sm-2 --%>
                                                
                                                <div class="col-sm-2 form-group">
                                                   <input type="text" class="form-control" id="tel2" value="">
                                                </div>
                                                <div class="col-sm-2 form-group">
                                                    <input type="text" class="form-control" id="tel3" value="">
                                                </div>
                                      </div><%-- /.row --%>
                                     
                                      
                                   </div><%-- /.content --%>
                                </fieldset>
                                
                                <fieldset>
                                
                             
                                 
                               
                                
                                  <legend>배송지 정보</legend>
                                  <div class="content">
                                      <div class="row">
                                          <div class="col-sm-6 form-group">
                                            <label><input type="radio" name="radio" id="same" value="same" checked>기존 배송지 정보와 동일</label>
                                            <label><input type="radio" name="radio" id="different" value="different">새로운 배송지 정보</label>
                                          </div>
                                      </div>
                                      <div class="row">
                                          <div class="col-sm-3 form-group">
                                              <div class="form-group">
                                                  <label for="order-name">수취인</label>
                                                  <input type="text" class="form-control" id="order-name" name="receiver-name" value="" required >
                                              </div>
                                          </div>
                                      </div>
                                      <%-- /.row --%>
                                      
                                       <label for="street">주소</label>
                                       <div class="row">
                                         
                                              <div class="col-sm-4 form-group">
                                                     <input type="text" class="form-control" id="postcode" name="postcode" required>
                                              </div>
                                              <div class="col-sm-2 form-group">
                                                     <input type="button" onclick="daumPostcode()" value="우편번호 찾기" class="btn btn-template-main"><br>
                                                 <%-- <input type="button" value="우편번호찾기" id="findCodeBtn" class="btn"> --%>
                                              </div>
                                          
                                       </div><%-- /.row --%>
                                       
                                        
                                       <div class="row">
                                          <div class="col-sm-6 form-group">
                                                 <input type="text" class="form-control" id="address" name="address" value="" required>
                                          </div>
                                          <div class="col-sm-6 form-group">
                                                 <input type="text" class="form-control" id="addressDetail" name="addressDetail" value="" required>
                                                 <span id="guide" style="color:#999"></span>
                                          </div>
                                        </div><%-- /.row --%>
                                      
                                       <label for="telephone">휴대폰번호</label>
                                       <div class="row">
                                         <div class="form-group">
                                              <div class="col-sm-2 form-group">
                                                      <select class="form-control" style="width:100%;" id="order-tel1" name="order-tel1">
                                                        <option value="010">010</option>
                                                        <option value="02">02</option>
                                                        <option value="031">031</option>
                                                        <option value="032">032</option>
                                                        <option value="033">033</option>
                                                        <option value="041">041</option>
                                                        <option value="042">042</option>
                                                        <option value="043">043</option>
                                                        <option value="051">051</option>
                                                        <option value="052">052</option>
                                                        <option value="053">053</option>
                                                        <option value="054">054</option>
                                                        <option value="055">055</option>
                                                        <option value="061">061</option>
                                                        <option value="062">062</option>
                                                        <option value="063">063</option>
                                                        <option value="064">064</option>
                                                      </select>
                                                </div><%-- ./col-sm-2 --%>
                                                
                                                <div class="col-sm-2 form-group">
                                                   <input type="text" class="form-control" id="order-tel2" name="order-tel2" value="" required>
                                                </div>
                                                <div class="col-sm-2 form-group">
                                                    <input type="text" class="form-control" id="order-tel3" name="order-tel3" value="" required>
                                                </div>
                                        </div><%-- /.form-group --%>
                                      </div><%-- /.row --%>
                                      
                                      <label for="order-name">배송메세지</label>
                                      <div class="row">
                                          <div class="col-sm-12 form-group">
                                               <textarea rows="2" cols="100%" id="deliveryMsg" name="deliveryMsg" required></textarea>
                                          </div>
                                      </div> <%-- /.row --%>
                                        
                                  </div><%-- /.content --%>
                                </fieldset>
                                
                                <fieldset>
                                  <legend>카드 정보</legend>
                                  <label for="cardNum">카드번호</label>
                                       <div class="row">
                                              <div class="col-sm-3 form-group">
                                                   <input type="text" class="form-control" id="card1" name="card1" required>
                                                </div>
                                                <div class="col-sm-3 form-group">
                                                   <input type="text" class="form-control" id="card2" name="card2" required>
                                                </div>
                                                <div class="col-sm-3 form-group">
                                                    <input type="text" class="form-control" id="card3" name="card3" required>
                                                </div>
                                                <div class="col-sm-3 form-group">
                                                    <input type="text" class="form-control" id="card4" name="card4" required>
                                                </div>
                                      </div><%-- /.row --%>
                                      
                                   <label for="cvc">CVC</label>
                                       <div class="row">
                                                <div class="col-sm-1">
                                                   <input type="text" class="form-control" id="cvc1" name="cvc1" required>
                                                </div>
                                                <div class="col-sm-1">
                                                   <input type="text" class="form-control" id="cvc2" name="cvc2" required>
                                                </div>
                                                <div class="col-sm-1">
                                                    <input type="text" class="form-control" id="cvc3" name="cvc3" required>
                                                </div>
                                      
                                        <input type="hidden" value="${total}" name="totalPrice">
                                        <input type="hidden" value="${cartNoList}" name="cartNoList">
                                      
                                      </div><%-- /.row --%>
                                </fieldset>
                                
                                
                                <div class="box-footer">
                                    <div class="pull-left">
                                      <a href="/cart/list.do" class="btn btn-default"><i class="fa fa-chevron-left"></i>Back to basket</a> 
                                    </div>
                                    <div class="pull-right">
                                        <button type="submit" class="btn btn-template-main">Submit<i class="fa fa-chevron-right"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
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
                              
                          </div><%-- /.BOX --%>
  
                      </div>
                      <%-- /.col-md-3 --%>
                    </c:forEach>
                    <%-- /SIDE BANNER --%>

                </div>
                <%-- /.row --%>

            </div>
            <%-- /.container --%>
        </div>
        <%-- /#content --%>
        

        <%-- *** COPYRIGHT ***--%>

    </div>
    <%-- /#all --%>
    <%-- *** ORDER END *** --%>


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