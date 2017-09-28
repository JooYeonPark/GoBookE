<%@ page contentType="text/html; charset=utf-8"%>

<div class="col-sm-9">
<h2>출판사 도서주문</h2>
<br>
  <div class="content">
    <div class="row">
      <div class="col-sm-6">
        <div class="form-group">
          <label for="publisher" >출판사</label> 
          <select class="form-control" id="publisher">
            <option value="volvo">말글터</option>
            <option value="saab">아울북</option>
            <option value="mercedes">민음사</option>
            <option value="audi">덴스토리</option>
            <option value="audi">문학동네</option>
          </select>
        </div>
      </div>
      <div class="col-sm-6">
        <div class="form-group">
          <label for="lastname">책제목</label> 
          <select class="form-control" id="bookname">
            <option value="volvo">말글터</option>
            <option value="saab">아울북</option>
            <option value="mercedes">민음사</option>
            <option value="audi">덴스토리</option>
            <option value="audi">문학동네</option>
          </select>
        </div>
      </div>
    </div>
    <!-- /.row -->

    <div class="row">
      <div class="col-sm-6">
        <div class="form-group">
          <label for="company">수량</label> 
          <input type="number" class="form-control" id="orderqty">
        </div>
      </div>
    </div>
    <!-- /.row -->

    <div class="row">
    <div class="col-sm-6">
        <div class="form-group">
          <input type="text" class="form-control text-right" style="border: none;" id="totalPrice" value="100000원">
        </div>
      </div>
      <div class="col-sm-3 ">
        <div class="form-group">
         	<input type="button" class="form-control" id="submit" value="발주">
        </div>
      </div>
      <div class="col-sm-3 ">
        <div class="form-group">
          <input type="reset" class="form-control" id="cancle" value="취소">
        </div>
      </div>
    </div>
    <!-- /.row -->
  </div>
</div>
<!-- /.col-md-9 -->