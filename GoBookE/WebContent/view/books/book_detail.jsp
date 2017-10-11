<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" uri="/WEB-INF/util-functions.tld" %>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<title></title>
<meta charset="utf-8">
<meta name="robots" content="all,follow">
<meta name="googlebot" content="index,follow,snippet,archive">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>GoBook-E 도서 상세보기</title>

<meta name="keywords" content="">

<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800' rel='stylesheet' type='text/css'>

<!-- Bootstrap and Font Awesome css -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Css animations  -->
<link href="../../css/animate.css" rel="stylesheet">

<!-- Theme stylesheet, if possible do not edit this stylesheet -->
<link href="../../css/style.default.css" rel="stylesheet" id="theme-stylesheet">

<!-- Custom stylesheet - for your changes -->
<link href="../../css/custom.css" rel="stylesheet">

<!-- Responsivity for older IE -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- Favicon and apple touch icons-->
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<link rel="apple-touch-icon" href="img/apple-touch-icon.png" />
<link rel="apple-touch-icon" sizes="57x57" href="img/apple-touch-icon-57x57.png" />
<link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-72x72.png" />
<link rel="apple-touch-icon" sizes="76x76" href="img/apple-touch-icon-76x76.png" />
<link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png" />
<link rel="apple-touch-icon" sizes="120x120" href="img/apple-touch-icon-120x120.png" />
<link rel="apple-touch-icon" sizes="144x144" href="img/apple-touch-icon-144x144.png" />
<link rel="apple-touch-icon" sizes="152x152" href="img/apple-touch-icon-152x152.png" />
<!-- #### JAVASCRIPT FILES ### -->

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script>
	window.jQuery
			|| document
					.write('<script src="js/jquery-1.11.0.min.js"><\/script>')
</script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script src="../../js/jquery.cookie.js"></script>
<script src="../../js/waypoints.min.js"></script>
<script src="../../js/jquery.counterup.min.js"></script>
<script src="../../js/jquery.parallax-1.1.3.js"></script>
<script src="../../js/front.js"></script>
<script type="text/javascript" src="../../js/jquery.raty.js"></script>
<script type="text/javascript">
	$(function() {
		$('div.star').raty({
			path : "../../img/star",
			width : 200,
			half : true,
			click : function(score, evt) {
				$("#starRating").val(score);
				$("#displayStarRating").html(score);
			}
		});
		
		var defaultCount=1;
		$("#inCart").attr("href","/cart/add.do?bookNo="+${book.no}+"&cartBookQty="+defaultCount);
		
		$('#count').change(function(){
			var count=$("#count option:selected").text();
			$("#inCart").attr("href","/cart/add.do?bookNo="+${book.no}+"&cartBookQty="+count);
		});
		
		function getContextPath() {
			var hostIndex = location.href.indexOf( location.host ) + location.host.length;
			return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
		};
	});
</script>
</head>
<body>
  <div id="all">
    <header>
      <!-- *** TOP *** -->
      <jsp:include page="../..//layout/header.jsp" />
      <!-- *** TOP END *** -->
      <!-- *** NAVBAR ***  -->
      <jsp:include page="../..//layout/nav.jsp" />
      <!-- *** NAVBAR END *** -->
    </header>

    <!-- *** LOGIN MODAL *** -->
    <jsp:include page="../..//layout/loginMo.jsp" />
    <!-- *** LOGIN MODAL END *** -->

    <div id="heading-breadcrumbs">
      <div class="container">
        <div class="row">
          <div class="col-md-7">
            <h1>책 상세정보</h1>
          </div>
        </div>
      </div>
    </div>

    <div id="content">
      <div class="container">

        <div class="row">

          <!-- *** LEFT COLUMN ***
        _________________________________________________________ -->

          <div class="col-md-9">

            <div class="row" id="productMain">
              <div class="col-sm-6">
                <div id="mainImage">
                  <img src="/img/books/${u:decode(book.image)}" alt="${book.image} 사진 준비중" class="img-responsive">
                </div>
              </div>
              
              <div class="col-sm-6">
                <div class="box">

                  <form>
                    <div class="sizes">
                      <h3>${book.title}</h3>
                      <h5>저자:${book.author}</h5>
                      <h5>출판사:${book.publisher}</h5>
                      <h5>출판일:${book.regdate}</h5>
                      <h5>재고량:${book.qty }</h5>
                      <h5>평점 : <fmt:formatNumber value="${book.grade}" pattern=".0"/></h5>
                    </div>

                    <p class="price">가격 : ${book.price} 원</p>
                    <div style="text-align: center; margin-bottom: 50px;">
                    <c:if test="${book.qty<=0}">
                    
                    재고 준비중입니다.
                    </c:if>
                    주문부수 :
                    <select id="count">
                      <c:if test="${book.qty < 10}">
                       <c:forEach var="i" begin="1" end="${book.qty-1}" step="1">
                        <option>${i}</option>
                      </c:forEach>
                      </c:if>
                      <c:if test="${book.qty >= 10}">
                       <c:forEach var="i" begin="1" end="10" step="1">
                        <option>${i}</option>
                      </c:forEach>
                      </c:if>
                      
                    </select>
                    </div>
                    <p class="text-center">
                      <a class="btn btn-template-main" id="directBuy">
                        <i class="fa fa-won"></i>바로 구매하기
                      </a>
                      <a class="btn btn-template-main" id="inCart">
                        <i class="fa fa-shopping-cart"></i>장바구니에 담기
                      </a>

                    </p>

                  </form>
                </div>
              </div>

            </div>


            <div class="box" id="details">
              <p>

                <!-- <p>White lace top, woven, has a round neck, short sleeves, has knitted lining attached</p>
                                <h4>Material & care</h4>
                                <ul>
                                    <li>Polyester</li>
                                    <li>Machine wash</li>
                                </ul>
                                <h4>Size & Fit</h4>
                                <ul>
                                    <li>Regular fit</li>
                                    <li>The model (height 5'8" and chest 33") is wearing a size S</li>
                                </ul> -->
              <blockquote>
                <h4>책 소개</h4>
                <p>
                  <em>${book.detail}</em>
                </p>
              </blockquote>
            </div>


           <iframe src="${pageContext.servletContext.contextPath}/review/bookreview.do?book_no=${book.no}" width=100%; frameborder="0" style="min-height: 500px; height: 1968px;" scrolling="no">
           
           </iframe>

          </div>


          <!-- /.col-md-9 -->


          <!-- *** LEFT COLUMN END *** -->

          <!-- *** RIGHT COLUMN ***
      _________________________________________________________ -->

          <div class="col-sm-3">

            <!-- *** MENUS AND FILTERS ***
 _________________________________________________________ -->
            <div class="panel panel-default sidebar-menu">

              <div class="panel-heading">
                <h3 class="panel-title">Categories</h3>
              </div>

              <div class="panel-body">
                <ul class="nav nav-pills nav-stacked category-menu">
                  <li>국내도서
                    <ul>
                      <li><a href="${pageContext.servletContext.contextPath}/book/inexBookList.do?category_big_no=1&category_no=1">소설</a></li>
                      <li><a href="${pageContext.servletContext.contextPath}/book/inexBookList.do?category_big_no=1&category_no=2">참고서</a></li>
                      <li><a href="${pageContext.servletContext.contextPath}/book/inexBookList.do?category_big_no=1&category_no=3">만화</a></li>
                      <li><a href="${pageContext.servletContext.contextPath}/book/inexBookList.do?category_big_no=1&category_no=4">잡지</a></li>
                    </ul></li>
                  <li>외국도서
                    <ul>
                      <li><a href="${pageContext.servletContext.contextPath}/book/inexBookList.do?category_big_no=2&category_no=1">영미도서</a></li>
                      <li><a href="${pageContext.servletContext.contextPath}/book/inexBookList.do?category_big_no=2&category_no=2">일본도서</a></li>
                      <li><a href="${pageContext.servletContext.contextPath}/book/inexBookList.do?category_big_no=2&category_no=3">프랑스도서</a></li>
                      <li><a href="${pageContext.servletContext.contextPath}/book/inexBookList.do?category_big_no=2&category_no=4">중국도서</a></li>
                    </ul></li>
                </ul>

              </div>
            </div>





            <!-- *** MENUS AND FILTERS END *** -->


            <!-- /.banner -->
          </div>
          <!-- /.col-md-3 -->

          <!-- *** RIGHT COLUMN END *** -->

        </div>
        <!-- /.row -->

      </div>
      <!-- /.container -->
    </div>
    <!-- /#content -->

    <!-- *** FOOTER *** -->
    <jsp:include page="../..//layout/footer.jsp" />
    <!-- /#footer -->

    <!-- *** FOOTER END *** -->

  </div>
  <!-- /#all -->

</body>
</html>