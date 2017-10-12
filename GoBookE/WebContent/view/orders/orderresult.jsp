<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>GoBook-E 주문결과</title>

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
    
</head>
<body>
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
        
        <%-- *** ORDER RESULT *** --%>
       <div id="heading-breadcrumbs">
                  <div class="container">
                      <div class="row">
                          <div class="col-md-7">
                              <h1>Order # ${orderNo}</h1>
                          </div>
                          <div class="col-md-5">
                              <ul class="breadcrumb">
      
                                  <li><a href="/index.jsp">Home</a>
                                  </li>
                                  <li>Order </li>
                              </ul>
                          </div>
                      </div>
                  </div>
              </div>
      
      
              <div id="content">
                  <div class="container">
      
                      <div class="row">
      
                          <div id="customer-order">
      
                              <p class="lead"> <strong>${cookie.user.value},</strong> 님 항상 저희 쇼핑몰을 이용해주셔서 감사합니다.</p>
                              <p class="lead text-muted">[주문번호  ${orderNo}] 결제가 안전하게 처리되었습니다.</p>
      
                              <div class="box">
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
                                                       <input type="number" value="${list[status.index].cartBookQty}" class="form-control" id="qty" readonly>
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
      
                                  <div class="row addresses">
                                      <div class="col-sm-6  pull-right">
                                          <h3 class="text-uppercase">Invoice</h3>
                                          <p>${name}
                                              <br>${postcode}
                                              <br>${address}
                                              <br>${addressDetail}
                                              <br>${telephone}
                                              <br>${deliveryMsg}
                                              <br>${total}
                                      </div>
                                      
                                  </div> 
                                  <%-- /.addresses --%>
      
                              </div>
                              <%-- /.box --%>
                              
                            </div>
                            <%-- /.customer-order --%>
                      </div>
                      <%-- /.row --%>
      
                  </div>
                  <%-- /.container --%>
              </div>
              <%-- /#content --%>
              
          <%-- *** ORDER RESULT END *** --%>
          
          
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