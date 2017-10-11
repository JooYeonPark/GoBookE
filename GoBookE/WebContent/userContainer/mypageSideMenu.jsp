<%@ page contentType="text/html; charset=utf-8"%>

<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
<script>
	$(function(){
		$("#sideNav li").click(function() {
			$("#sideNav li").removeClass("active");
			$(this).addClass("active");
		});
	});
</script>

<div class="panel panel-default sidebar-menu">
  <div class="panel-heading">
    <h3 class="panel-title">Admin</h3>
  </div>
  <div class="panel-body" id="sideNav">
    <ul class="nav nav-pills nav-stacked category-menu">
      <li class="active"><a href="/view/admin/bookregist.jsp"> 도서 등록 </a></li>
      <li class=""><a href="/book/bookstock.do"> 도서재고 현황</a></li>
      <li class=""><a href="/book/getpublisher.do"> 도서 발주</a></li>
      <li class=""><a href="/admin/adminbookorderlist.do"> 발주 현황</a></li>
    </ul>
  </div>

</div>

<!-- banner -->
<div class="banner">
  <a href="shop-category.html"> <img src="img/banner.jpg"
    alt="welcome admin" class="img-responsive">
  </a>
</div>


<!-- /.banner -->