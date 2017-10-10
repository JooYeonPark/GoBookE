<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <link href="../../../css/animate.css" rel="stylesheet">

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
    $('.remaining').each(function() {
        // count 정보 및 count 정보와 관련된 textarea/input 요소를 찾아내서 변수에 저장한다.
        var $count = $('.count', this);
        var $input = $(this).prev();
        // .text()가 문자열을 반환하기에 이 문자를 숫자로 만들기 위해 1을 곱한다.
        var maximumCount = $count.text() * 1;
        // update 함수는 keyup, paste, input 이벤트에서 호출한다.
        var update = function() {
            var before = $count.text() * 1;
            var now = maximumCount - $input.val().length;
            // 사용자가 입력한 값이 제한 값을 초과하는지를 검사한다.
            if (now < 0) {
                var str = $input.val();
                alert('글자 입력수가 초과하였습니다.');
                $input.val(str.substr(0, maximumCount));
                now = 0;
            }
            // 필요한 경우 DOM을 수정한다.
            if (before != now) {
                $count.text(now);
            }
        };
        // input, keyup, paste 이벤트와 update 함수를 바인드한다
        $input.bind('input keyup paste', function() {
            setTimeout(update, 0)
        });
        update();
    });
    
    var userId=$.cookie('user');
    if(userId==null){
    	$('#comment').attr("disabled","disabled");
    }
  
  
  });
</script>
</head>
<body>
    <div id="all">


        <div id="content">
            <div class="container">
                <div class="row">
                    <!-- *** LEFT COLUMN ***
       _________________________________________________________ -->
                <div id="comment-form">
              <form action="${pageContext.servletContext.contextPath}/review/reviewWrite.do" method="post">
                <div class="row">
                  <div class="col-sm-12">
                    <div class="form-group">
                    <c:choose>
                      <c:when test="${empty cookie.user}">
                        <label for="comment">로그인하시면 평가하실수 있습니다. <span class="required">*</span>
                      </label>
                      </c:when>
                      <c:otherwise>
                      <label for="comment">${cookie.user.value}님의 평가 <span class="required">*</span>
                      </label>
                      <input type="hidden" name="userId" value="${cookie.user.value}"> 
                      </c:otherwise>
                    </c:choose>
                      <textarea class="form-control" id="comment" rows="4" name="message" style="resize: none;"></textarea>
                      <div class=remaining style="text-align: right;">남은 글자수: <span class="count">2000</span></div>
                      평가해주세요~!
                      <div class="star"></div>
                      <input type="text" id="starRating" readonly="readonly" name="grade"/>점
                      <input type="hidden" name="book_no" value="${bookNo}"/>
                      <div class="text-right">
                      <c:choose>
                      <c:when test="${empty cookie.user}">
                      </c:when>
                      <c:otherwise>
                      <button type="submit" class="btn btn-template-main">
                      <i class="fa fa-comment-o"></i> 등록
                    </button>
                      </c:otherwise>
                    </c:choose>
                  </div>
                    </div>
                  </div>
                  
                </div>
                </form>
              <div style="margin-top: 5em;">
                <table class="table">
                  <tr>
                    <th>글쓴이</th>
                    <th>내용</th>
                    <th>등록일자</th>
                    <th>평점</th>
                    <th></th>
                  </tr>
                  <c:choose>
                    <c:when test="${empty list}">
                        <tr>
                          <td colspan="5">등록된 리뷰가 없습니다.</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${list}" var="review">
                        <tr>
                    <td>${review.userId}</td>
                    <td>${review.message}</td>
                    <td>${review.regdate }</td>
                    <td><div class="star">${review.grade }</div></td>
                    <c:if test="${cookie.user.value==review.userId}">
                    <td><a href="${pageContext.servletContext.contextPath}/review/reviewDelete.do?no=${review.no}&book_no=${review.bookNo}">삭제</a></td>
                    </c:if>
                    <td></td>
                    </tr>
                        </c:forEach>                    
                    </c:otherwise>
                  </c:choose>
                </table>
               <div class="pages">
                        <ul class="pagination">
                                <c:if test="${pageBuilder.showFirst }">
            <li><a href="${pageBuilder.getQueryString(1)}">처음으로</a></li>
          </c:if>

          <c:if test="${pageBuilder.showPrevious }">
            <li class="prev"><a
              href="${pageBuilder.getQueryString(pageBuilder.previousStartPage)}">이전목록</a></li>
          </c:if>

          <c:forEach var="i" begin="${pageBuilder.currentStartPage}"
            end="${pageBuilder.currentEndPage }">
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
            <li><a
              href="${pageBuilder.getQueryString(pageBuilder.totalPageCount)}">끝으로</a></li>
          </c:if>
                            </ul>
                       </div>
              </div>
            </div>
                  
                    <!-- /.col-md-9 -->

                    <!-- *** LEFT COLUMN END *** -->

                    <!-- *** RIGHT COLUMN ***
       _________________________________________________________ -->

                    <div class="col-md-3">

                        <!-- *** MENUS AND WIDGETS ***
 _________________________________________________________ -->
                       
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
        
        <!-- /#footer -->

        <!-- *** FOOTER END *** -->
    </div>
    <!-- /#all -->


    
</body>
</html>