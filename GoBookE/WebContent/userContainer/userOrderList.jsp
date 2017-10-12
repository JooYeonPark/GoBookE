<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/css/bootstrap-datetimepicker.min.css" rel="stylesheet" /> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.2/moment-with-locales.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/js/bootstrap-datetimepicker.min.js"></script>


<script>
$(function(){
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	if(day <10){
		day = "0"+day;
	}
	if(month < 10){
		month ="0"+month;
	}
	var dateStr = year+"-"+month+"-"+day;
	
	$("fieldset a").click(function() {
		var daysAttr = $(this).attr("days");
		dateCal(daysAttr);
	});
	
	$("form").submit(function(){
		var dateStart = $("#fromDate1").val();
		var dateEnd = $("#fromDate2").val();
		var userId =  $.cookie('user');
		
		var data = {
			dateStart : dateStart,
			dateEnd : dateEnd
		}
		
		var params = $.param(data);
		
		var url = "/order/userorderlist.do?"+params;
		window.location.replace(url);
		
		return false;
		
	});
	
	function dateCal(daysAttr){
		date = new Date();
		year = date.getFullYear();
		month = date.getMonth()+1;
		day = date.getDate();
		if(day <10){
			day = "0"+day;
		}
		if(month < 10){
			month ="0"+month;
		}
		dateStr = year +"-"+month+"-"+day;
		$("#fromDate2").val(dateStr);
		
		if (daysAttr <30) {
			date.setDate(date.getDate()-daysAttr);
		}else{
			date.setMonth(date.getMonth()-(daysAttr/30));
		}
		
		year = date.getFullYear();
		month = date.getMonth()+1;
		day = date.getDate();
		if(day <10){
			day = "0"+day;
		}
		if(month < 10){
			month ="0"+month;
		}
		dateStr = year +"-"+month+"-"+day;
		
		$("#fromDate1").val(dateStr);
	}
});

</script>

<div class="col-sm-9">
  <div class="col-md-10" id="customer-orders">

    <h3>주문 내역 조회</h3>

    <div class="xans-element- xans-myshop xans-myshop-orderhistoryhead ">
    <form>
      <fieldset>
        <div
          class="xans-element- xans-myshop xans-myshop-orderhistoryhead ">
          <fieldset>
            <span> <a href="#none" class="btnNormal" days="0"><img
                src="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1.gif"
                offimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1.gif"
                onimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1_on.gif"
                alt="오늘"> </a> 
                <a href="#none" class="btnNormal" days="7"> <img
                src="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2.gif"
                offimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2.gif"
                onimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2_on.gif"
                alt="1주일"></a> 
                <a href="#none" class="btnNormal" days="30"> <img
                src="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3.gif"
                offimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3.gif"
                onimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3_on.gif"
                alt="1개월"></a> 
                <a href="#none" class="btnNormal" days="90"> <img
                src="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4.gif"
                offimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4.gif"
                onimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4_on.gif"
                alt="3개월"></a> 
                <a href="#none" class="btnNormal" days="180"> <img
                src="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5.gif"
                offimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5.gif"
                onimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5_on.gif"
                alt="6개월"></a>
                
            </span>
            <input id="fromDate1" type="date" class="input-date" value="${params.dateStart }">~<input id="fromDate2" type="date" class="input-date" value="${params.dateEnd }">
            <input type="submit" value="검색">
          </fieldset>
        </div>
        
      </fieldset>
      </form>
    </div>

    <br>

    <fieldset>
      <div class="box">
        <div class="table-responsive" id="userOrder">
        <table class='table table-hover'> 
          <thead> 
            <tr> 
            <th style="width: 20%; text-align: center;">Order No</th> 
            <th style="width: 60%; text-align: center;">ITEM</th>
            <th style="width: 10%; text-align: center;">QTY</th> 
            <th style="width: 10%; text-align: center;">totalPrice</th> 
            </tr>
          </thead>
          <tbody>
          <c:choose>
            <c:when test="${empty list }">
              <tr><td colspan='6' style="text-align: center;">검색된 결과가 없습니다.</td></tr>
            </c:when>
            <c:otherwise>
              <c:forEach items="${list}" var="order" varStatus="status">
               <tr>
               <td style="text-align: center;">${order.no}<br> &#91;${order.date}&#93;</td>
               <td>Grammar In Use Intermediate with Answers(Cambridge)</td>
               <td style="text-align: center;">10</td>
               <td style="text-align: center;">${order.totalprice}won</td>
               </tr>
              </c:forEach>
            </c:otherwise>
          </c:choose>
          </tbody>
          </table>
        </div>
        <!-- /.table-responsive -->
        
       
        
        <!-- 페이징 -->
        <div style="text-align: center;">
          <ul class="pagination" style="margin: auto;">
            <c:if test="${pageBuilder.showFirst }">
              <li><a href="${pageBuilder.getQueryString(1)}">«</a></li>
            </c:if>
            <c:if test="${pageBuilder.showPrevious }">
              <li class="prev"><a href="${pageBuilder.getQueryString(pageBuilder.previousStartPage)}">＜</a></li>
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
              <li class="next"><a
                href="${pageBuilder.getQueryString(pageBuilder.nextStartPage)}">＞</a></li>
            </c:if>

            <c:if test="${pageBuilder.showLast }">
              <li><a
                href="${pageBuilder.getQueryString(pageBuilder.totalPageCount)}">»</a></li>
            </c:if>
          </ul>
        </div>

      </div>
    </fieldset>
    <!-- /.box -->

  </div>
</div>
<!-- /.col-md-9 -->