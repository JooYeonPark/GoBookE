<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" uri="/WEB-INF/util-functions.tld" %>
<%@page import="java.net.URLDecoder"%>

<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<title></title>
<meta charset="utf-8">
<meta name="robots" content="all,follow">
<meta name="googlebot" content="index,follow,snippet,archive">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>GoBook-E 도서</title>

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
</head>
<body>
  <div id="all">
    <header>
      <!-- *** TOP *** -->
      <jsp:include page="../../layout/header.jsp" />
      <!-- *** TOP END *** -->
      <!-- *** NAVBAR ***  -->
      <jsp:include page="../../layout/nav.jsp" />
      <!-- *** NAVBAR END *** -->
    </header>

    <!-- *** LOGIN MODAL *** -->
    <jsp:include page="../../layout/loginMo.jsp" />
    <!-- *** LOGIN MODAL END *** -->

    <div id="heading-breadcrumbs">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <h1>${title }</h1>
          </div>
          <div class="col-md-6">
            <ul class="breadcrumb">
              <li><a href="index.html">Home</a></li>
              <li>${title }</li>
            </ul>

          </div>
        </div>
      </div>
    </div>

    <div id="content">
      <div class="container">
        <div class="row">
          <!-- *** LEFT COLUMN ***
       _________________________________________________________ -->

          <div class="col-md-9" id="blog-listing-medium">
            <c:choose>
              <c:when test="${empty list }">

              </c:when>
              <c:otherwise>
                <c:forEach items="${list}" var="book" varStatus="status">
                  <section class="post">
                    <div class="row">
                      <div class="col-md-4">
                        <div class="image">
                          <a href="${pageContext.servletContext.contextPath}/book/bookDetail.do?book_no=${book.no}"> 
                          <img src="/img/books/${u:decode(book.image)}" class="img-responsive" alt="${book.image} 사진 준비중">
                          </a>
                        </div>
                      </div>
                      <div class="col-md-8">
                        <h2>
                          <a href="${pageContext.servletContext.contextPath}/book/bookDetail.do?book_no=${book.no}">${book.title}</a>
                        </h2>
                        <div class="clearfix">
                          <p class="author-category">
                            By <a href="#">${book.author}</a>
                          </p>
                          <p class="date-comments">
                            <a href="blog-post.html"><i class="fa fa-calendar-o"></i>${book.regdate}</a>
                          </p>
                        </div>
                        <p class="intro">${book.detail}</p>

                        <p class="read-more">
                          <a href="../../view/orders/orderBackup.html" class="btn btn-template-main"><i class="fa fa-won"></i>바로구매하기</a> <a href="${pageContext.servletContext.contextPath}/cart/add.do?bookNo=${book.no}&cartBookQty=1" class="btn btn-template-main"><i class="fa fa-shopping-cart"></i>장바구니에담기</a>
                        </p>

                      </div>
                    </div>
                  </section>

                </c:forEach>

              </c:otherwise>
            </c:choose>

            <div style="text-align: center;">
              <form name="search" role="form" method="get">
                <div class="row">
                  <p>
                    <select name="type">
                      <option value="title">책제목</option>
                      <option value="author">저자</option>
                    </select> <input type="text" name="value" required>
                    <button type="submit" class="btn btn-default">검색</button>
                  </p>
                  <input type="hidden" name="category_big_no" value="${category_big_no}" /> <input type="hidden" name="category_no" value="${category_no}" />
                </div>
              </form>
            </div>
            <div class="pages">
              <ul class="pagination">
                <c:if test="${pageBuilder.showFirst }">
                  <li><a href="${pageBuilder.getQueryString(1)}">처음으로</a></li>
                </c:if>

                <c:if test="${pageBuilder.showPrevious }">
                  <li class="prev"><a href="${pageBuilder.getQueryString(pageBuilder.previousStartPage)}">이전목록</a></li>
                </c:if>

                <c:forEach var="i" begin="${pageBuilder.currentStartPage}" end="${pageBuilder.currentEndPage }">
                  <c:choose>
                    <c:when test="${i == params.page }">
                      <li class="active"><a>${i }</a></li>
                    </c:when>
                    <c:otherwise>
                      <li><a href="${pageBuilder.getQueryString(i)}">${i }</a></li>
                    </c:otherwise>
                  </c:choose>
                </c:forEach>

                <c:if test="${pageBuilder.showNext }">
                  <li class="next"><a href="${pageBuilder.getQueryString(pageBuilder.nextStartPage)}">다음목록</a></li>
                </c:if>

                <c:if test="${pageBuilder.showLast }">
                  <li><a href="${pageBuilder.getQueryString(pageBuilder.totalPageCount)}">끝으로</a></li>
                </c:if>
              </ul>
            </div>


          </div>
          <!-- /.col-md-9 -->

          <!-- *** LEFT COLUMN END *** -->

          <!-- *** RIGHT COLUMN ***
       _________________________________________________________ -->

          <div class="col-md-3">

            <!-- *** MENUS AND WIDGETS ***
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
    <jsp:include page="../../layout/footer.jsp" />
    <!-- /#footer -->

    <!-- *** FOOTER END *** -->
  </div>
  <!-- /#all -->


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
</body>
</html>