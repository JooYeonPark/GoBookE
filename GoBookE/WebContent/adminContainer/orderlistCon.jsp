<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>

<div class="col-sm-9">
  <div class="col-md-10" id="customer-orders">

    <h3>발주현황</h3>

    <div
      class="xans-element- xans-myshop xans-myshop-orderhistoryhead col-md-offset-4">
      <fieldset>
        <div
          class="xans-element- xans-myshop xans-myshop-orderhistoryhead ">
          <fieldset>
            <span> <a href="#none" class="btnNormal" days="00"><img
                src="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1.gif"
                offimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1.gif"
                onimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1_on.gif"
                alt="오늘"> </a> <a href="#none" class="btnNormal"
              days="07"> <img
                src="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2.gif"
                offimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2.gif"
                onimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2_on.gif"
                alt="1주일"></a> <a href="#none" class="btnNormal"
              days="30"> <img
                src="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3.gif"
                offimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3.gif"
                onimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3_on.gif"
                alt="1개월"></a> <a href="#none" class="btnNormal"
              days="90"> <img
                src="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4.gif"
                offimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4.gif"
                onimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4_on.gif"
                alt="3개월"></a> <a href="#none" class="btnNormal"
              days="180"> <img
                src="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5.gif"
                offimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5.gif"
                onimage="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5_on.gif"
                alt="6개월"></a>
            </span>
          </fieldset>
        </div>
        <input id="mode" name="mode" value="" type="hidden"> <input
          id="term" name="term" value="" type="hidden">
      </fieldset>
    </div>

    <br>

    <fieldset>
      <div class="box">
        <div class="table-responsive" id="adminOrder">
        <table class='table table-hover'> 
          <thead> 
            <tr> 
            <th>Order</th> 
            <th>BookName</th>
            <th>Publisher</th> 
            <th>QTY</th> 
            <th>Price</th> 
            <th>Order Date</th>
            </tr>
          </thead>
          <tbody>
          <c:choose>
            <c:when test="${empty list }">
              <tr><td colspan='6'>검색된 결과가 없습니다.</td></tr>
            </c:when>
            <c:otherwise>
              <c:forEach items="${list}" var="ownerOrder" varStatus="status">
               <tr>
               <td>${status.count}</td>
               <td>${ownerOrder.bookName}</td>
               <td>${ownerOrder.publisher}</td>
               <td>${ownerOrder.qty}</td>
               <td>${ownerOrder.totalPrice}</td>
               <td>${ownerOrder.date}</td>
               </tr>
              </c:forEach>
            </c:otherwise>
          </c:choose>
          </tbody>
          </table>
        </div>
        <!-- /.table-responsive -->

        <div style="text-align: center;">
          <ul class="pagination" style="margin: auto;">
            <c:if test="${pageBuilder.showFirst }">
              <li><a href="${pageBuilder.getQueryString(1)}">«</a></li>
            </c:if>
            <c:if test="${pageBuilder.showPrevious }">
              <li class="prev"><a
                href="${pageBuilder.getQueryString(pageBuilder.previousStartPage)}">＜</a></li>
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