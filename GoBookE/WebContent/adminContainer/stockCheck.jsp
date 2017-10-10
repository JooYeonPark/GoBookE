<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>

<script>

$(function(){
	$("#bookStock button").click(function() {
		var no = $(this).attr("id");
		
		var data = {
			no : no,
		}
		var params = $.param(data);
			
		var url = "/book/getpublisher.do?"+params;
		window.location.replace(url);
		
		return false;
	});
});

</script>

<div class="col-sm-9">
<div class="col-md-12">

  <h3>도서 재고</h3>
  
  <!-- 검색..?조건들 나열 -->
  <fieldset>
    
  </fieldset>

  <fieldset>
  <div class="box">
    <div class="table-responsive" id="bookStock">
      <table class="table table-hover">
        <thead> 
          <tr>
            <th style="width: 30%;">BookTitle</th>
            <th style="width: 20%;">Author</th>
            <th style="width: 20%;">Publisher</th>
            <th style="width: 10%;">QTY</th>
            <th style="width: 10%;">Grade</th>
            <th style="width: 10%;">Order</th>
          </tr>
        </thead>
        <tbody>
          <c:choose>
            <c:when test="${empty list }">
              <tr><td colspan='6' style="text-align: center;">검색된 결과가 없습니다.</td></tr>
            </c:when>
            <c:otherwise>
              <c:forEach items="${list}" var="book" varStatus="status">
               <tr>
               <td>${book.title}</td>
               <td>${book.author}</td>
               <td>${book.publisher}</td>
               <td>${book.qty}</td>
               <td>${book.grade}</td>
               <td>
                  <c:set var="qty" value="${book.qty}" />
                  <c:choose>
                      <c:when test="${qty < 10}">
                        <button class="btn btn-template-main" id="${book.no}">발주</button>
                      </c:when>
                  </c:choose>
               </td>
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
