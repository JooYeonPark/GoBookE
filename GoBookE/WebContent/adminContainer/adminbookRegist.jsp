<%@ page contentType="text/html; charset=utf-8"%>

<div class="col-sm-9">

  <!-- 사진 추가 및 사진 보여주기 -->
  <div class="col-sm-6">
    <table class="table">
      <tr>
        <td style="height: 385px" class="text-center"><img
          src="" alt="사진을 등록해주세요."
          class="img-responsive"></td>
      </tr>

      <tr>
        <td class="center-block"><input class="form-control "
          id="img" type="button" value="사진등록"></td>
      </tr>
    </table>
  </div>

  <!-- 도서 등록 내용 -->
  <div class="col-sm-6">
    <div class="row">
      <div class="col-sm-10">
        <div class="form-group">
          <label for="publisher">책제목</label> <input type="text"
            class="form-control" id="bookname">
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-sm-10">
        <div class="form-group">
          <label for="lastname">출판사</label> <input type="text"
            class="form-control" id="publisher">
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-sm-10">
        <div class="form-group">
          <label for="publisher">대분류</label> <select
            class="form-control" id="bigCategory">
            <option value="volvo">국내도서</option>
            <option value="saab">외국도서</option>
          </select>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-sm-10">
        <div class="form-group">
          <label for="lastname">소분류</label> <select class="form-control"
            id="category">
            <option value="volvo">소설</option>
            <option value="saab">참고서</option>
            <option value="saab">만화</option>
            <option value="saab">잡지</option>
          </select>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-sm-10">
        <div class="form-group">
          <label for="lastname">가격</label> <input type="number"
            class="form-control" id="price">
        </div>
      </div>
    </div>
    
    <div class="row">
      <div class="col-sm-10">
        <div class="form-group">
          <label for="lastname">도서설명</label>
          <textarea rows="3" cols="100" class="form-control" id="detail"></textarea>
        </div>
      </div>
    </div>

  </div>


  <div class="col-sm-3 col-sm-offset-9">
    <div class="form-group">
      <input class=" btn btn-template-main form-control " type="submit"
        value="등록">
    </div>
  </div>


</div>
<!-- /.col-md-9 -->