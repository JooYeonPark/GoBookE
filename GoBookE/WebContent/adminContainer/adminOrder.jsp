<%@page import="kr.or.gobooke.book.dao.JdbcBookDao"%>
<%@page import="kr.or.gobooke.common.db.DaoFactory"%>
<%@page import="kr.or.gobooke.book.dao.BookDao"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>

<script>
	var selectVal;
	var bookno;
	var bookName;
	var price;
	var qty;
	var total;
	$(function() {
		$("#publisher").change(function() {
			selectVal = this.value;
			getBookName(selectVal);
		});

		$("#orderqty").change(function() {
			$("#bookname option:selected").each(function() {
				bookno = $(this).val();
				price = $(this).attr("class");
			});
			qty = this.value;

			total = qty * price;

			$("#totalPrice").val(total + "원");
		});

		$("form").submit(function(event) {
			var data = {
					bookNo : bookno, //no로 title, publisher 검색
					qty : qty,
					totalprice : total
				};
			var params = $.param(data);
			
			var url = "/admin/adminbookorder.do?"+params;
			window.location.replace(url);
			
			return false;
			
		});
	});

	function getBookName(selectVal) {
		var data = {
			publisher : selectVal
		};
		var param = $.param(data);
		//ajax요청...!
		$.ajax({
			url : "/book/searchbookname.do",
			data : param,
			dataType : "json",
			success : function(data) {
				var bookList = data;
				var str = "";
				$.each(bookList,function(index, book) {
					str += "<option value='"+book.no+"' class='"+book.price+"'>"+ book.title + "</option>";
				});

				$("#bookname").html(str);
			}
		});
	}
</script>

<%-- --%>
<div class="col-sm-9">
  <h2>출판사 도서주문</h2>
  <br>
  <form>
    <div class="content">
      <div class="row">
        <div class="col-sm-6">
          <div class="form-group">
            <label>출판사</label> 
            <select id="publisher" class="form-control">
            <c:choose>
            <c:when test="${publisherList != null}">
              <c:forEach items="${publisherList}" var="string" varStatus="status">
                <option value="${string}">${string}</option>
              </c:forEach>
            </c:when>
            </c:choose>
            </select>
          </div>
        </div>

        <div class="col-sm-6">
          <div class="form-group">
            <label for="lastname">책제목</label> 
            <select class="form-control" id="bookname">
            <c:if test="${book != null }">
              <option value="${book.no}" class="${book.price}">${book.title}</option>
            </c:if>
            </select>
          </div>
        </div>
      </div>
      <%-- /.row --%>

      <div class="row">
        <div class="col-sm-6">
          <div class="form-group">
            <label for="company">수량</label> <input type="number"
              class="form-control" id="orderqty">
          </div>
        </div>
      </div>
      <%-- /.row --%>

      <div class="row">
        <div class="col-sm-6">
          <div class="form-group">
            <input type="text" class="form-control text-right"
              style="border: none; background-color: #ffffff;"
              id="totalPrice" value="0원" disabled>
          </div>
        </div>
        <div class="col-sm-3 ">
          <div class="form-group">
            <input type="submit" class="form-control" id="submit"
              value="발주">
          </div>
        </div>
        <div class="col-sm-3 ">
          <div class="form-group">
            <input type="reset" class="form-control" id="cancle"
              value="취소">
          </div>
        </div>
      </div>
      <%-- /.row --%>
    </div>
  </form>
</div>
<%-- /.col-md-9 --%>