<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>GoBook-E</title>

    <meta name="keywords" content="">

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800' rel='stylesheet' type='text/css'>

    <!-- Bootstrap and Font Awesome css -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Css animations  -->
    <link href="css/animate.css" rel="stylesheet">

    <!-- Theme stylesheet, if possible do not edit this stylesheet -->
    <link href="css/style.default.css" rel="stylesheet" id="theme-stylesheet">

    <!-- Custom stylesheet - for your changes -->
    <link href="css/custom.css" rel="stylesheet">

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
    <!-- owl carousel css -->

    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">
    
    <!-- #### JAVASCRIPT FILES ### -->

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script>
        window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')
    </script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    <script src="js/jquery.cookie.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/jquery.parallax-1.1.3.js"></script>
    <script src="js/front.js"></script>

    <!-- owl carousel -->
    <script src="js/owl.carousel.min.js"></script>
    
    <script type="text/javascript" src="js/jquery.xdomainajax.js"></script>
    <script>
  $(function(){
    $.ajax({
        url : "http://book.interpark.com/api/bestSeller.api?key=AD05009D9D975D46B742B91DF4D0F5663FEC24E72F5BFCA7A16ED288A972F90C&categoryId=100",
        dataType : "xml",
        type: 'GET',
        success : function(res) {
          var myXML = res.responseText;
          xmlDoc=$.parseXML(myXML);
          var output = "";
          $(xmlDoc).find("item").each(function(index){
            output += "<div class=\"col-md-3 col-sm-6\">";
            output += "<div class=\"box-image-text blog\">";
              output += "<div class=\"top\">";
              output += "<div class=\"image\">";
              output += " <img  style=\"height: 280px; display: unset;\" class=\"img-responsive image1\" align=\"center\" src="+$(this).find("coverLargeUrl").text()+">";
              output += "</div>";
              output += "<div class=\"bg\"></div>";
              output += "<div class=\"text\">";
              output += "<p class=\"buttons\">";
              output += "<a href=\"book/bestSellerDetail.do?categoryId=100&title="+$(this).find("title").text()+"\" class=\"btn btn-template-transparent-primary\"><i class=\"fa fa-link\"></i>자세히 보기</a>";
              output += "</p>";
              output += "</div></div>";
              output += "<div class=\"content\">";
              output += "<h4>";
              output += "<a href=\"/book/bestSellerDetail.do?categoryId=100&title="+$(this).find("title").text()+"\">"+$(this).find("title").text()+"</a>";
              output += "</h4>";
              output += "<p class=\"author-category\">";
              output += "By <a href=\"#\">"+$(this).find("author").text()+"</a>";
              output += "</p>";
              output += "<p class=\"intro\"></p>";
              output += "<p class=\"read-more\">";
              output += "<a href=\"book/bestSellerDetail.do?categoryId=100&title="+$(this).find("title").text()+"\" class=\"btn btn-template-main\">상세보기</a>";
              output += "</p>";
              output += "</div>";
              output += "</div>";
              output += "</div>";
              if(index==3){
                return false;
              }
          });
          $("#internal").html(output);
          $(".image").css("height",280);
        }
      });
    
    $.ajax({
        url : "http://book.interpark.com/api/bestSeller.api?key=AD05009D9D975D46B742B91DF4D0F5663FEC24E72F5BFCA7A16ED288A972F90C&categoryId=200",
        dataType : "xml",
        type: 'GET',
        success : function(res) {
          var myXML = res.responseText;
          xmlDoc=$.parseXML(myXML);
          var output = "";
          $(xmlDoc).find("item").each(function(index){
            output += "<div class=\"col-md-3 col-sm-6\">";
            output += "<div class=\"box-image-text blog\">";
              output += "<div class=\"top\">";
              output += "<div class=\"image\">";
              output += " <img  style=\"height: 280px; display: unset;\" class=\"img-responsive image1\" align=\"center\" src="+$(this).find("coverLargeUrl").text()+">";
              output += "</div>";
              output += "<div class=\"bg\"></div>";
              output += "<div class=\"text\">";
              output += "<p class=\"buttons\">";
              output += "<a href=\"book/bestSellerDetail.do?categoryId=100&title="+$(this).find("title").text()+"\" class=\"btn btn-template-transparent-primary\"><i class=\"fa fa-link\"></i>자세히 보기</a>";
              output += "</p>";
              output += "</div></div>";
              output += "<div class=\"content\">";
              output += "<h4>";
              output += "<a href=\"/book/bestSellerDetail.do?categoryId=100&title="+$(this).find("title").text()+"\">"+$(this).find("title").text()+"</a>";
              output += "</h4>";
              output += "<p class=\"author-category\">";
              output += "By <a href=\"#\">"+$(this).find("author").text()+"</a>";
              output += "</p>";
              output += "<p class=\"intro\"></p>";
              output += "<p class=\"read-more\">";
              output += "<a href=\"book/bestSellerDetail.do?categoryId=100&title="+$(this).find("title").text()+"\" class=\"btn btn-template-main\">상세보기</a>";
              output += "</p>";
              output += "</div>";
              output += "</div>";
              output += "</div>";
              if(index==3){
                return false;
              }
          });
          $("#external").html(output);
          $(".image").css("height",280);
        }
      });
    
  });
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

        <section>
            <!-- *** HOMEPAGE CAROUSEL *** -->
            <jsp:include page="/mainContainer/carouselMain.jsp"/>
            <!-- *** HOMEPAGE CAROUSEL END *** -->
        </section>
        
        <!-- *** Main Top Container *** -->
        <jsp:include page="/mainContainer/topCon.jsp"/>
        <!-- /#Main Top Container -->
        
        <!-- *** Main Botton Container *** -->
        <jsp:include page="/mainContainer/bottomCon.jsp"/>
        <!-- /#Main Botton Container -->
        
        <!-- *** FOOTER *** -->
        <jsp:include page="/layout/footer.jsp"/>
        <!-- /#footer -->

        <!-- *** FOOTER END *** -->

        <!-- *** COPYRIGHT *** -->

    </div>
    <!-- /#all -->


</body>

</html>