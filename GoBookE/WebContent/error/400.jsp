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
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" href="img/apple-touch-icon.png" />
    <link rel="apple-touch-icon" sizes="57x57" href="/img/apple-touch-icon-57x57.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/img/apple-touch-icon-72x72.png" />
    <link rel="apple-touch-icon" sizes="76x76" href="/img/apple-touch-icon-76x76.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/img/apple-touch-icon-114x114.png" />
    <link rel="apple-touch-icon" sizes="120x120" href="/img/apple-touch-icon-120x120.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/img/apple-touch-icon-144x144.png" />
    <link rel="apple-touch-icon" sizes="152x152" href="/img/apple-touch-icon-152x152.png" />
    <!-- owl carousel css -->

    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">
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


        <!-- *** CONTENT *** -->
        <div id="content">
            <div class="container">

                <div class="col-sm-6 col-sm-offset-3" id="error-page">

                    <div class="box">

                        <p class="text-center">
                            <a href="index.html">
                                <img src="img/logo.png" alt="Obaju template">
                            </a>
                        </p>

                        <h3>We are sorry - this page is not here anymore</h3>
                        <h4 class="text-muted">Error 400 - Page not found</h4>

                        <p class="buttons"><a href="/index.jsp" class="btn btn-template-main"><i class="fa fa-home"></i> Go to Homepage</a>
                        </p>
                    </div>


                </div>
                <!-- /.col-sm-6 -->
            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->
        <!-- *** CONTENT END *** -->
         
        <!-- *** FOOTER *** -->
        <jsp:include page="/layout/footer.jsp"/>
        <!-- /#footer -->

        <!-- *** FOOTER END *** -->

    </div>
    <!-- /#all -->

</body>

</html>