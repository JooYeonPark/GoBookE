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
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
  
<script>
<%-- 주소 API --%>
function daumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 도로명 조합형 주소 변수

            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            if(fullRoadAddr !== ''){
                fullRoadAddr += extraRoadAddr;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('address').value = fullRoadAddr;
        
            document.getElementById('guide').innerHTML = '(상세주소 예 : 101동 101호)';
            
        }
    }).open();
}
</script>
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

                            <form action="${pageContext.servletContext.contextPath}/user/regist.do" method="post">
                                <div class="form-group">
                                    <label for="id-login">ID</label>
                                    <input type="text" class="form-control" id="id-login" name="id">
                                </div>
                                <div class="form-group">
                                    <label for="name-login">이름</label>
                                    <input type="text" class="form-control" id="name-login" name="name">
                                </div>
                                <div class="form-group">
                                    <label for="password-login">비밀번호</label>
                                    <input type="password" class="form-control" id="password-login"  name="password">
                                </div>
                                <div class="form-group">
                                    <label for="password-login">비밀번호 확인</label>
                                    <input type="password" class="form-control" id="password-login" name="ckPassword">
                                </div>
                                <div class="form-group">
                                    <label for="email-login">이메일</label>
                                    <input type="text" class="form-control" id="email-login" name="email">
                                </div>
                                <div class="form-group">
                                    <label for="telephone-login">전화번호</label>
                                    <div class="row">
                  <div class="form-group">
                    <div class="col-sm-3 form-group">
                        <select class="form-control" style="width:100%;" id="tel1" name="tel1">
                           <option value="010">010</option>
                           <option value="02">02</option>
                           <option value="031">031</option>
                           <option value="032">032</option>
                           <option value="033">033</option>
                           <option value="041">041</option>
                           <option value="042">042</option>
                           <option value="043">043</option>
                           <option value="051">051</option>
                           <option value="052">052</option>
                           <option value="053">053</option>
                           <option value="054">054</option>
                           <option value="055">055</option>
                           <option value="061">061</option>
                           <option value="062">062</option>
                           <option value="063">063</option>
                           <option value="064">064</option>
                         </select>
                  </div><%-- ./col-sm-2 --%>
                  <div class="col-sm-3 form-group">
                      <input type="text" class="form-control" id="tel2" name="tel2" required>
                  </div>
                      <div class="col-sm-3 form-group">
                          <input type="text" class="form-control" id="tel3" name="tel3"  required>
                      </div>
                </div><%-- /.form-group --%>
              </div><%-- /.row --%>
                                </div>
                                <div class="form-group">
                                    <label for="address-login">주소</label>
                                    <div style="width: 50%; margin-bottom: 10px;">
                                    <input type="text" class="form-control" id="postcode" name="postcode">
                                    </div>
                                    <div style="display: flex;">
                                    <input type="text" class="form-control" id="address" name="address">
                                    <button class="btn btn-template-main" onclick="daumPostcode()">주소찾기</button>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="address-login">상세주소</label>
                                    <input type="text" class="form-control" id="addressDetail" name="addressDetail">
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