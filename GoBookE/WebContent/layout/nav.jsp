<%@ page contentType="text/html; charset=utf-8"%>

<div class="navbar-affixed-top" data-spy="affix" data-offset-top="200">

  <div class="navbar navbar-default yamm" role="navigation" id="navbar">

    <div class="container">
      <div class="navbar-header">

        <a class="navbar-brand home" href="index.html"> <img
          src="../img/logo.png" alt="Universal logo"
          class="hidden-xs hidden-sm"> <img
          src="../img/logo-small.png" alt="Universal logo"
          class="visible-xs visible-sm"><span class="sr-only">Universal
            - go to homepage</span>
        </a>
        <div class="navbar-buttons">
          <button type="button" class="navbar-toggle btn-template-main"
            data-toggle="collapse" data-target="#navigation">
            <span class="sr-only">Toggle navigation</span> <i
              class="fa fa-align-justify"></i>
          </button>
        </div>
      </div>
      <!--/.navbar-header -->

      <div class="navbar-collapse collapse" id="navigation">

        <ul class="nav navbar-nav navbar-right">
          <li class="dropdown active"><a href="javascript: void(0)"
            class="dropdown-toggle" data-toggle="dropdown">HOME</a>
          </li>
           <li><a href="${pageContext.servletContext.contextPath}/book/bestSellerList.do">베스트셀러</a>
          </li>
          <li><a href="${pageContext.servletContext.contextPath}/book/newBookList.do">신간도서</a>
          <li class="dropdown"><a href="javascript: void(0)"
            class="dropdown-toggle" data-toggle="dropdown">국내도서 <b
              class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="${pageContext.servletContext.contextPath}/book/inexBookList.do?category_big_no=1&category_no=1">소설</a></li>
              <li><a href="${pageContext.servletContext.contextPath}/book/inexBookList.do?category_big_no=1&category_no=2">참고서</a></li>
              <li><a href="${pageContext.servletContext.contextPath}/book/inexBookList.do?category_big_no=1&category_no=3">만화</a></li>
              <li><a href="${pageContext.servletContext.contextPath}/book/inexBookList.do?category_big_no=1&category_no=4">잡지</a></li>
            </ul></li>
          <li class="dropdown"><a href="javascript: void(0)"
            class="dropdown-toggle" data-toggle="dropdown">외국도서 <b
              class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="${pageContext.servletContext.contextPath}/book/inexBookList.do?category_big_no=2&category_no=1">영미도서</a></li>
              <li><a href="${pageContext.servletContext.contextPath}/book/inexBookList.do?category_big_no=2&category_no=2">일본도서</a></li>
              <li><a href="${pageContext.servletContext.contextPath}/book/inexBookList.do?category_big_no=2&category_no=3">프랑스도서</a></li>
              <li><a href="${pageContext.servletContext.contextPath}/book/inexBookList.do?category_big_no=2&category_no=4">중국도서</a></li>
            </ul></li>
            <li class="dropdown use-yamm yamm-fw"><a href="/view/admin/adminorder.jsp">관리자</a>
          </li>
        </ul>

      </div>
      <!--/.nav-collapse -->

      <div class="collapse clearfix" id="search">

        <form class="navbar-form" role="search">
          <div class="input-group">
            <input type="text" class="form-control" placeholder="Search">
            <span class="input-group-btn">

              <button type="submit" class="btn btn-template-main">
                <i class="fa fa-search"></i>
              </button>

            </span>
          </div>
        </form>

      </div>
      <!--/.nav-collapse -->

    </div>


  </div>
  <!-- /#navbar -->

</div>