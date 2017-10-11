<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<meta name="robots" content="all,follow">
<meta name="googlebot" content="index,follow,snippet,archive">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>GoBook-E 마이페이지</title>

<meta name="keywords" content="">

<link
  href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800'
  rel='stylesheet' type='text/css'>

<%-- Bootstrap and Font Awesome css --%>
<link rel="stylesheet"
  href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet"
  href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<%-- Css animations  --%>
<link href="/css/animate.css" rel="stylesheet">

<%-- Theme stylesheet, if possible do not edit this stylesheet --%>
<link href="/css/style.default.css" rel="stylesheet"
  id="theme-stylesheet">

<%-- Custom stylesheet - for your changes --%>
<link href="/css/custom.css" rel="stylesheet">

<%-- Responsivity for older IE --%>
<%--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]--%>

<%-- Favicon and apple touch icons--%>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<link rel="apple-touch-icon" href="/img/apple-touch-icon.png" />
<link rel="apple-touch-icon" sizes="57x57"
  href="/img/apple-touch-icon-57x57.png" />
<link rel="apple-touch-icon" sizes="72x72"
  href="/img/apple-touch-icon-72x72.png" />
<link rel="apple-touch-icon" sizes="76x76"
  href="/img/apple-touch-icon-76x76.png" />
<link rel="apple-touch-icon" sizes="114x114"
  href="/img/apple-touch-icon-114x114.png" />
<link rel="apple-touch-icon" sizes="120x120"
  href="/img/apple-touch-icon-120x120.png" />
<link rel="apple-touch-icon" sizes="144x144"
  href="/img/apple-touch-icon-144x144.png" />
<link rel="apple-touch-icon" sizes="152x152"
  href="/img/apple-touch-icon-152x152.png" />
  
  <script>
  window.onload = function(){
	  getOrderUser();
	  changeAction();
  }
  
  function getOrderUser(){
	 //user 값 읽어오기
	$("#id").val("${user.id}");
	$("#name").val("${user.name}");
	$("#tel1").val("${tel1}");
	$("#tel2").val("${tel2}");
	$("#tel3").val("${tel3}");
	$("#email").val("${user.email}");
	
	//변경은 오로지 password, address, addressDetail
	$("#id").attr("disabled", true);
	$("#name").attr("disabled", true);
	$("#tel1").attr("disabled", true);
	$("#tel2").attr("disabled", true);
	$("#tel3").attr("disabled", true);
	$("#email").attr("disabled", true);
  }
  
  function changeAction(){
  	$("#userform").attr("action", "/user/update.do");
  }
  </script>
    
</head>

<body>

  <div id="all">

    <header>
      <%-- *** TOP *** --%>
      <jsp:include page="/layout/header.jsp" />
      <%-- *** TOP END *** --%>
      <%-- *** NAVBAR ***  --%>
      <jsp:include page="/layout/nav.jsp" />
      <%-- *** NAVBAR END *** --%>
    </header>

    <%-- *** LOGIN MODAL *** --%>
    <jsp:include page="/layout/loginMo.jsp" />
    <%-- *** LOGIN MODAL END *** --%>


    <%-- Container Section START  --%>
    <div id="heading-breadcrumbs">
      <div class="container">
        <div class="row">
          <div class="col-md-7">
            <h1>MyPage - 정보수정</h1>
          </div>
          <div class="col-md-5">
            <ul class="breadcrumb">
              <li><a href="/index.jsp">Home</a></li>
              <li>MyPage - 정보수정</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <%-- Container Section END   --%>

    <div id="content">
      <div class="container">
        <div class="row">
        
          <%-- *** LEFT COLUMN *** --%>
            <jsp:include page="/view/users/userform.jsp"/>
          <%-- /.col-md-7 --%>
          
          <%-- *** RIGHT COLUMN *** --%>
          <div class="col-sm-3">
              <%-- *** MENUS AND FILTERS ***  --%>
              <jsp:include page="/userContainer/mypageSideMenu.jsp" />
          </div>
          <%-- /.col-md-3 --%>
          <%-- *** RIGHT COLUMN END *** --%>
          
        </div>
        <%-- /.row --%>
      </div>
      <%-- /.container --%>
    </div>
    <%-- /#content --%>

    <%-- *** FOOTER *** --%>
    <jsp:include page="/layout/footer.jsp" />
    <%-- /#footer --%>

    <%-- *** FOOTER END *** --%>

  </div>
  <%-- /#all --%>

  <%-- #### JAVASCRIPT FILES ### --%>

  <script
    src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  <script>
			window.jQuery
					|| document
							.write('<script src="js/jquery-1.11.0.min.js"><\/script>')
		</script>
  <script
    src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

  <script src="/js/jquery.cookie.js"></script>
  <script src="/js/waypoints.min.js"></script>
  <script src="/js/jquery.counterup.min.js"></script>
  <script src="/js/jquery.parallax-1.1.3.js"></script>
  <script src="/js/front.js"></script>

</body>

</html>