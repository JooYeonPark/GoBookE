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
        window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')
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
                    <div class="col-md-5">
                        <ul class="breadcrumb">
                            <li><a href="index.html">Home</a>
                            </li>
                            <li><a href="shop-category.html">Ladies</a>
                            </li>
                            <li><a href="shop-category.html">Tops</a>
                            </li>
                            <li>상세정보</li>
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

                    <div class="col-md-9">

                        <div class="row" id="productMain">
                            <div class="col-sm-6">
                                <div id="mainImage">
                                    <img src="../../img/books/${book.image }" alt="" class="img-responsive">
                                </div>

                                <div class="ribbon sale">
                                    <div class="theribbon">SALE</div>
                                    <div class="ribbon-background"></div>
                                </div>
                                <!-- /.ribbon -->

                                <div class="ribbon new">
                                    <div class="theribbon">NEW</div>
                                    <div class="ribbon-background"></div>
                                </div>
                                <!-- /.ribbon -->

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
                                            <h5>평점 : ${book.grade}</h5>

                                        </div>

                                        <p class="price">가격 : ${book.price} 원</p>

                                        <p class="text-center">
                                            <button type="submit" class="btn btn-template-main"><i class="fa fa-won"></i>바로 구매하기</button>
                                            <button type="submit" class="btn btn-template-main"><i class="fa fa-shopping-cart"></i>장바구니에 담기</button>
                                            
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
                                    <p><em>${book.detail}</em>
                                    </p>
                                </blockquote>
                        </div>
                        <div id="comment-form">
                        <form>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <label for="comment">Comment <span class="required">*</span>
                                            </label>
                                            <textarea class="form-control" id="comment" rows="4"></textarea>
                                            평가해주세요~!<div class="star"></div>
                                 <input type="text" id="starRating" disabled/>점
                                        </div>
                                    </div>
                                </div>
                                
                                 
                                 
                                
                                

                                <div class="row">
                                    <div class="col-sm-12 text-right">
                                        <button class="btn btn-template-main"><i class="fa fa-comment-o"></i> Post comment</button>
                                    </div>
                                </div>
                        </form> 
                        </div>
                        <div style="margin-top: 5em;">
                        <table class="table">
                          <tr>
                            <th>글쓴이</th>
                            <th>내용</th>
                            <th>등록일자</th>
                            <th>평점</th>
                          </tr>
                          <tr>
                            <td>bangry</td>
                            <td>정말재미있습니다.</td>
                            <td>2017.09.28</td>
                            <td><div class="star"></div></td>
                          </tr>
                          <tr>
                            <td>sugnjoon</td>
                            <td>정말재미있습니다.</td>
                            <td>2017.09.28</td>
                            <td><div class="star"></div></td>
                          </tr>
                          <tr>
                            <td>bangry</td>
                            <td>정말재미있습니다.</td>
                            <td>2017.09.28</td>
                            <td><div class="star"></div></td>
                          </tr>
                          <tr>
                            <td>bangry</td>
                            <td>정말재미있습니다.</td>
                            <td>2017.09.28</td>
                            <td><div class="star"></div></td>
                          </tr>
                        </table>
                         <div class="pages">
                        <ul class="pagination">
                                <li><a href="#">&laquo;</a>
                                </li>
                                <li class="active"><a href="#">1</a>
                                </li>
                                <li><a href="#">2</a>
                                </li>
                                <li><a href="#">3</a>
                                </li>
                                <li><a href="#">4</a>
                                </li>
                                <li><a href="#">5</a>
                                </li>
                                <li><a href="#">&raquo;</a>
                                </li>
                            </ul>
                       </div>
                        </div>
                        <div class="pages">
                        
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
                                    <li>
                                        <a href="shop-category.html">국내도서</a>
                                        <ul>
                                            <li><a href="shop-category.html">소설</a>
                                            </li>
                                            <li><a href="shop-category.html">참고서</a>
                                            </li>
                                            <li><a href="shop-category.html">만화</a>
                                            </li>
                                            <li><a href="shop-category.html">잡지</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="active">
                                        <a href="shop-category.html">외국도서</a>
                                        <ul>
                                            <li><a href="shop-category.html">영미도서</a>
                                            </li>
                                            <li><a href="shop-category.html">일본도서</a>
                                            </li>
                                            <li><a href="shop-category.html">프랑스도서</a>
                                            </li>
                                            <li><a href="shop-category.html">중국도서</a>
                                            </li>
                                        </ul>
                                    </li>
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
        <jsp:include page="../..//layout/footer.jsp"/>
        <!-- /#footer -->

        <!-- *** FOOTER END *** -->
       
    </div>
    <!-- /#all -->
  
</body>
</html>