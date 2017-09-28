<%@ page contentType="text/html; charset=utf-8" %>

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
        
        <!-- *** ORDER RESULT *** -->
       <div id="heading-breadcrumbs">
                  <div class="container">
                      <div class="row">
                          <div class="col-md-7">
                              <h1>Order # 1735</h1>
                          </div>
                          <div class="col-md-5">
                              <ul class="breadcrumb">
      
                                  <li><a href="index.html">Home</a>
                                  </li>
                                  <li><a href="customer-orders.html">My orders</a>
                                  </li>
                                  <li>Order # 1735</li>
                              </ul>
                          </div>
                      </div>
                  </div>
              </div>
      
      
              <div id="content">
                  <div class="container">
      
                      <div class="row">
      
                          <div id="customer-order">
      
                              <p class="lead">Order #1735 was placed on <strong>22/06/2013</strong> and is currently <strong>Being prepared</strong>.</p>
                              <p class="lead text-muted">If you have any questions, please feel free to <a href="contact.html">contact us</a>, our customer service center is working for you 24/7.</p>
      
                              <div class="box">
                                  <div class="table-responsive">
                                      <table class="table">
                                          <thead>
                                              <tr>
                                                  <th colspan="2">Product</th>
                                                  <th>Quantity</th>
                                                  <th>Unit price</th>
                                                  <th>Discount</th>
                                                  <th>Total</th>
                                              </tr>
                                          </thead>
                                          <tbody>
                                              <tr>
                                                  <td>
                                                      <a href="#">
                                                          <img src="img/detailsquare.jpg" alt="White Blouse Armani">
                                                      </a>
                                                  </td>
                                                  <td><a href="#">White Blouse Armani</a>
                                                  </td>
                                                  <td>2</td>
                                                  <td>$123.00</td>
                                                  <td>$0.00</td>
                                                  <td>$246.00</td>
                                              </tr>
                                              <tr>
                                                  <td>
                                                      <a href="#">
                                                          <img src="img/basketsquare.jpg" alt="Black Blouse Armani">
                                                      </a>
                                                  </td>
                                                  <td><a href="#">Black Blouse Armani</a>
                                                  </td>
                                                  <td>1</td>
                                                  <td>$200.00</td>
                                                  <td>$0.00</td>
                                                  <td>$200.00</td>
                                              </tr>
                                          </tbody>
                                          <tfoot>
                                              <tr>
                                                  <th colspan="5" class="text-right">Order subtotal</th>
                                                  <th>$446.00</th>
                                              </tr>
                                              <tr>
                                                  <th colspan="5" class="text-right">Shipping and handling</th>
                                                  <th>$10.00</th>
                                              </tr>
                                              <tr>
                                                  <th colspan="5" class="text-right">Tax</th>
                                                  <th>$0.00</th>
                                              </tr>
                                              <tr>
                                                  <th colspan="5" class="text-right">Total</th>
                                                  <th>$456.00</th>
                                              </tr>
                                          </tfoot>
                                      </table>
      
                                  </div>
                                  <!-- /.table-responsive -->
      
                                  <div class="row addresses">
                                      <div class="col-sm-6">
                                          <h3 class="text-uppercase">Invoice address</h3>
                                          <p>John Brown
                                              <br>13/25 New Avenue
                                              <br>New Heaven
                                              <br>45Y 73J
                                              <br>England
                                              <br>Great Britain</p>
                                      </div>
                                      <div class="col-sm-6">
                                          <h3 class="text-uppercase">Shipping address</h3>
                                          <p>John Brown
                                              <br>13/25 New Avenue
                                              <br>New Heaven
                                              <br>45Y 73J
                                              <br>England
                                              <br>Great Britain</p>
                                      </div>
                                  </div>
                                  <!-- /.addresses -->
      
                              </div>
                              <!-- /.box -->
                      </div>
                      <!-- /.row -->
      
                  </div>
                  <!-- /.container -->
              </div>
              <!-- /#content -->
              
          <!-- *** ORDER RESULT END *** -->
          
          
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