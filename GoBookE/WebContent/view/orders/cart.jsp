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

    <!-- Bootstrap and Font Awesome css -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Css animations  -->
    <link href="/css/animate.css" rel="stylesheet">

    <!-- Theme stylesheet, if possible do not edit this stylesheet -->
    <link href="/css/style.default.css" rel="stylesheet" id="theme-stylesheet">

    <!-- Custom stylesheet - for your changes -->
    <link href="/css/custom.css" rel="stylesheet">

    <!-- Responsivity for older IE -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

    <!-- Favicon and apple touch icons-->
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" href="/img/apple-touch-icon.png" />
    <link rel="apple-touch-icon" sizes="57x57" href="/img/apple-touch-icon-57x57.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/img/apple-touch-icon-72x72.png" />
    <link rel="apple-touch-icon" sizes="76x76" href="/img/apple-touch-icon-76x76.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/img/apple-touch-icon-114x114.png" />
    <link rel="apple-touch-icon" sizes="120x120" href="/img/apple-touch-icon-120x120.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/img/apple-touch-icon-144x144.png" />
    <link rel="apple-touch-icon" sizes="152x152" href="/img/apple-touch-icon-152x152.png" />
    
    <!-- Side Banner -->
    <script src="/js/sidebanner.js"></script>
    <style type="text/css">
      #STATICMENU { margin: 0pt; padding: 0pt;  position: absolute; right: 0px; top: 0px;}
    </style>
</head>
<body>

        <div id="heading-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h1>Shopping cart</h1>
                    </div>
                    <div class="col-md-6">
                        <ul class="breadcrumb">
                            <li><a href="index.html">Home</a>
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
                    <div class="col-md-12">
                        <p class="text-muted lead">You currently have ${pageBuilder.totalRowCount} item(s) in your cart.</p>
                    </div>
                    

                    <div class="col-md-9 clearfix" id="basket">

                    	<div class="box"> 

                            <form method="post" action="#">

                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th colspan="2">Product</th>
                                                <th>Quantity</th>
                                                <th>Unit price</th>
                                                <th colspan="2">Total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                          <c:if test = "${not empty list}">
                                            <c:forEach items="${list}" varStatus="status">
                                                  <tr>
                                                      <td>
                                                          <a href="#">
                                                              <img src="/img/books/${list[status.index].bookImage}">
                                                          </a>
                                                      </td>
                                                      <td><a href="#">${list[status.index].bookTitle}</a>
                                                      </td>
                                                      <td>
                                                          <input type="number" value="${list[status.index].cartBookQty}" class="form-control">
                                                      </td>
                                                      <td>${list[status.index].bookPrice}</td>
                                                      <td>${list[status.index].bookTotalPrice}</td>
                                                      <td><a href="#"><i class="fa fa-trash-o"></i></a>
                                                      </td>
                                                  </tr>
                                              </c:forEach>
                                          </c:if>
                                        </tbody>
                                        
                                        <tfoot>
                                            <tr>
                                            
                                                <th colspan="5">Total</th>
                                                <th colspan="2">${total-2500} </th>
                                            </tr>
                                        </tfoot>
                                    </table>

                                </div>
                                <!-- /.table-responsive -->

                                <div class="box-footer">
                                    <div class="pull-left">
                                        <a href="shop-category.html" class="btn btn-default"><i class="fa fa-chevron-left"></i> Continue shopping</a>
                                    </div>
                                    <div class="pull-right">
                                        <button class="btn btn-default"><i class="fa fa-refresh"></i> Update cart</button>
                                        <button type="submit" class="btn btn-template-main">Proceed to checkout <i class="fa fa-chevron-right"></i>
                                        </button>
                                    </div>
                                </div>

                            </form>

                        </div>
                        <!-- /.box -->

                    </div>
                    <!-- /.col-md-9 -->

                    <div class="col-md-3">
                    <!--  <div class="box" id="order-summary STATICMENU"> -->
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
                            
                            <button type="submit" class="btn btn-template-main">ORDER<i class="fa fa-chevron-right"></i></button>
                           
                        </div><!-- /.BOX -->



                    </div>
                    <!-- /.col-md-3 -->

                </div>

            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->
        
        <!-- #### JAVASCRIPT FILES ### -->
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