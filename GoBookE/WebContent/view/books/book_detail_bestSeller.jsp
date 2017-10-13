<%@ page contentType="text/html; charset=utf-8"%>
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

    <title>GoBook-E 베스트셀러</title>

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

    <!-- #### JAVASCRIPT FILES ### -->

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script>
        window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')
    </script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    <script src="../../js/jquery.cookie.js"></script>
    <script src="../../js/waypoints.min.js"></script>
    <script src="../../js/jquery.counterup.min.js"></script>
    <script src="../../js/jquery.parallax-1.1.3.js"></script>
    <script src="../../js/front.js"></script>
    <script type="text/javascript" src="../../js/jquery.raty.js"></script>
    <script type="text/javascript" src="../../js/xml2json.js"></script>
    <script type="text/javascript" src="../../js/jquery.xdomainajax.js"></script>
    <script type="text/javascript" src="../../js/book_detail_bestseller.js"></script>
    <script type="text/javascript">
        $(function() {
            $('div.star').raty({
                path : "../../img/star"
                ,width : 200
                ,half : true
                ,click: function(score, evt) {
                    $("#starRating").val(score);
                    $("#displayStarRating").html(score);
                }
            });
        });
    </script>
    <script type="text/javascript">
    $(function(){
    	var categoryId=${categoryId};
    	var title=$("#title").val();
    	if(categoryId==100){
    	 $.ajax({
    		    url : "http://book.interpark.com/api/bestSeller.api?key=AD05009D9D975D46B742B91DF4D0F5663FEC24E72F5BFCA7A16ED288A972F90C&categoryId=100",
    		    dataType : "xml",
    		    type: 'GET',
    		    success : function(res) {
    		      var myXML = res.responseText;
    		      xmlDoc=$.parseXML(myXML);
    		      var output = "";
    		      $(xmlDoc).find("item").each(function(index){
    		        if(title==$(this).find("title").text()){
    		        	$("#bookTitle").text($(this).find("title").text());
    		        	$("#bookAuthor").text("저자 : "+$(this).find("author").text());
    		        	$("#publisher").text("출판사 : "+$(this).find("publisher").text());
    		        	$("#regdate").text("출판일 : "+$(this).find("pubDate").text());
    		        	$("#bookPrice").text("가격 : "+$(this).find("priceStandard").text());
    		        	$("#bookDetail").text($(this).find("description").text());
    		        	$("#bookImg").attr("src",$(this).find("coverLargeUrl").text());
    		        }
    		      });
    		    }
    		  });
    	}else if(categoryId==200){
    	 $.ajax({
 		    url : "http://book.interpark.com/api/bestSeller.api?key=AD05009D9D975D46B742B91DF4D0F5663FEC24E72F5BFCA7A16ED288A972F90C&categoryId=200",
 		    dataType : "xml",
 		    type: 'GET',
 		    success : function(res) {
 		      var myXML = res.responseText;
 		      xmlDoc=$.parseXML(myXML);
 		      var output = "";
 		      $(xmlDoc).find("item").each(function(index){
 		        if(title==$(this).find("title").text()){
 		        	$("#bookTitle").text($(this).find("title").text());
 		        	$("#bookAuthor").text("저자 : "+$(this).find("author").text());
 		        	$("#publisher").text("출판사 : "+$(this).find("publisher").text());
 		        	$("#regdate").text("출판일 : "+$(this).find("pubDate").text());
 		        	$("#bookPrice").text("가격 : "+$(this).find("priceStandard").text());
 		        	$("#bookDetail").text($(this).find("description").text());
 		        	$("#bookImg").attr("src",$(this).find("coverLargeUrl").text());
 		        }
 		      });
 		    }
 		  });
    	}
    	
    });
    </script>
</head>
<body>
  <div id="all">
        <header>
            <!-- *** TOP *** -->
            <jsp:include page="../..//layout/header.jsp"/>
            <!-- *** TOP END *** -->
            <!-- *** NAVBAR ***  -->
            <jsp:include page="../..//layout/nav.jsp"/>
            <!-- *** NAVBAR END *** -->
        </header>

        <!-- *** LOGIN MODAL *** -->
        <jsp:include page="../..//layout/loginMo.jsp"/>        
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
                        <input type="hidden" id="title" value="${title}"/>
                            <div class="col-sm-6">
                                <div id="mainImage">
                                    <img id="bookImg" style="width: 450px; height: 678px;"alt="" class="img-responsive">
                                </div>

                            </div>
                            <div class="col-sm-6">
                                <div class="box">

                                    <form>
                                        <div class="sizes">

                                            <h3 id="bookTitle"></h3>
                                            <h5 id="bookAuthor"></h5>
                                            <h5 id="publisher"></h5>
                                            <h5 id="regdate"></h5>

                                        </div>

                                        <p class="price" id="bookPrice"></p>

                                        <p class="text-center">
                                            제고 준비중입니다.
                                            
                                        </p>

                                    </form>
                                </div>
                            </div>

                        </div>


                        <div class="box" id="details">
                            <p>
                                <blockquote>
                                <h4>책 소개</h4>
                                    <p><em id="bookDetail">${book.detail}</em>
                                    </p>
                                </blockquote>
                        </div>
                      
                        
               
                       
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

                    </div>
                </div>

            </div>
        </div>

      <!-- *** FOOTER *** -->
        <jsp:include page="../..//layout/footer.jsp"/>
        <!-- /#footer -->

        <!-- *** FOOTER END *** -->
       
    </div>
    <!-- /#all -->
  
</body>
</html>