<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<title></title>
<meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Universal - All In 1 Template</title>

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
    <link rel="apple-touch-icon" sizes="57x57" href="../../img/apple-touch-icon-57x57.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="../../img/apple-touch-icon-72x72.png" />
    <link rel="apple-touch-icon" sizes="76x76" href="../../img/apple-touch-icon-76x76.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="../../img/apple-touch-icon-114x114.png" />
    <link rel="apple-touch-icon" sizes="120x120" href="../../img/apple-touch-icon-120x120.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="../../img/apple-touch-icon-144x144.png" />
    <link rel="apple-touch-icon" sizes="152x152" href="../../img/apple-touch-icon-152x152.png" />
    <style type="text/css">
    .form-control{
      width : 87%;
    }
    </style>
</head>
<body>
<div class="all">
    <header>
            <!-- *** TOP *** -->
            <jsp:include page="../../layout/header.jsp"/>
            <!-- *** TOP END *** -->
            <!-- *** NAVBAR ***  -->
            <jsp:include page="../../layout/nav.jsp"/>
            <!-- *** NAVBAR END *** -->
    </header>
    
    <!-- *** LOGIN MODAL *** -->
        <jsp:include page="../../layout/loginMo.jsp"/>        
        <!-- *** LOGIN MODAL END *** -->
        <div id="heading-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-7">
                        <h1>New account / Sign in</h1>
                    </div>
                    <div class="col-md-5">
                        <ul class="breadcrumb">
                            <li><a href="index.html">Home</a>
                            </li>
                            <li>New account / Sign in</li>
                        </ul>

                    </div>
                </div>
            </div>
        </div>
    <div id="content">
            <div class="container">

                <div class="row">
                    <div class="col-md-6">
                        <div class="box">
                            <h2 class="text-uppercase">회원가입</h2>

                            <p class="lead">아직 저희 회원이 아니신가요?</p>
                            <p>가입하시면 다양한 정보와 혜택을 받으실 수 있습니다.</p>
                            

                            <hr>

                            <form action="customer-orders.html" method="post">
                                <div class="form-group">
                                    <label for="id-login">ID</label>
                                    <input type="text" class="form-control" id="id-login">
                                </div>
                                <div class="form-group">
                                    <label for="name-login">이름</label>
                                    <input type="text" class="form-control" id="name-login">
                                </div>
                                <div class="form-group">
                                    <label for="password-login">비밀번호</label>
                                    <input type="password" class="form-control" id="password-login">
                                </div>
                                <div class="form-group">
                                    <label for="password-login">비밀번호 확인</label>
                                    <input type="password" class="form-control" id="password-login">
                                </div>
                                <div class="form-group">
                                    <label for="email-login">이메일</label>
                                    <input type="text" class="form-control" id="email-login">
                                </div>
                                <div class="form-group">
                                    <label for="telephone-login">전화번호</label>
                                    <input type="text" class="form-control" id="telephone-login">
                                </div>
                                <div class="form-group">
                                    <label for="address-login">주소</label>
                                    <div style="width: 50%; margin-bottom: 10px;">
                                    <input type="text" class="form-control" id="address-login">
                                    </div>
                                    <div style="display: flex;">
                                    <input type="text" class="form-control" id="address-login">
                                    <button class="btn btn-template-main">주소찾기</button>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="address-login">상세주소</label>
                                    <input type="text" class="form-control" id="address-login">
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-template-main"><i class="fa fa-user-md"></i> Register</button>
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="box">
                            <h2 class="text-uppercase">로그인</h2>

                            <p class="lead">저희 회원이신가요?</p>
                            <p class="text-muted">로그인 부탁드립니다.</p>

                            <hr>

                            <form action="${pageContext.servletContext.contextPath}/user/certify.do" method="post">
                                <div class="form-group">
                                    <label for="email">ID</label>
                                    <input type="text" class="form-control" name="id" id="userId">
                                </div>
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" name="passwd" id="password">
                                    <input type="hidden" name="referer" value="${referer }">
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-template-main"><i class="fa fa-sign-in"></i> Log in</button>
                                </div>
                            </form>
                        </div>
                    </div>

                </div>
                <!-- /.row -->

            </div>
            <!-- /.container -->
        </div>
        
        <!-- *** FOOTER *** -->
        <jsp:include page="../../layout/footer.jsp"/>
        <!-- /#footer -->
</div>
</body>
</html>