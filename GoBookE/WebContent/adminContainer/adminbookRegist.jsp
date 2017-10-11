<%@ page contentType="text/html; charset=utf-8"%>
<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
	$(function() {
		var imgTag = $("#imgspace");
		var upload = document.getElementById("image");
		var holder = document.getElementById('holder');

		var file;
		var filePath;
		var fileName;
		var reader;
		
		var categoryBigNo = 1;
		var categoryNo = 1;

		if (typeof window.FileReader === 'undefined') {
			imgTag.attr("alt", "사진을 등록할 수 없습니다.");
		} else {
			imgTag.attr("alt", "사진을 등록해주세요.");
		}

		upload.onchange = function() {
			imgReader();
		}

		$("#categoryBigNo").change(
				function() {
					var htmlString = "<option value='1'>소설</option>"
							+ "<option value='2'>참고서</option>"
							+ "<option value='3'>만화</option>"
							+ "<option value='4'>잡지</option>";
					categoryBigNo = this.value;

					if (categoryBigNo == 1) {
						htmlString = "<option value='1'>소설</option>"
								+ "<option value='2'>참고서</option>"
								+ "<option value='3'>만화</option>"
								+ "<option value='4'>잡지</option>";
						$("#categoryNo").html(htmlString);
					} else {
						htmlString = "<option value='1'>영미도서</option>"
								+ "<option value='2'>일본도서</option>"
								+ "<option value='3'>프랑스도서</option>"
								+ "<option value='4'>중국도서</option>";
						$("#categoryNo").html(htmlString);
					}
				});

		$("#categoryNo").change(function() {
			categoryNo = this.value;
		});

		/** 사진띄우기 */
		function imgReader() {
			file = upload.files[0];
			reader = new FileReader();

			reader.onload = function(event) {
				var img = new Image();
				img.width = 380;
				img.src = event.target.result;

				holder.innerHTML = '';
				holder.appendChild(img);
			};
			reader.readAsDataURL(file);

			fileName = $('input[type=file]')[0].files[0].name;

		}

	});
</script>

<div class="col-sm-9">
  <form action="${pagecontext}/book/bookregist.do" enctype="multipart/form-data" method="post">

    <!-- 사진 추가 및 사진 보여주기 -->
    <div class="col-sm-6">
      <table class="table">
        <tr>
          <td style="width: 380; height: 385px" class="text-center"
            id="holder"><img alt="사진사진" src="" id="imgspace"></td>
        </tr>

        <tr>
          <td class="center-block"><input type="file"
            class="btn btn-template-main form-control" id="image"
            name="image" value="사진추가"></td>
        </tr>
      </table>

      <div class="row">
        <div class="col-sm-12">
          <div class="form-group">
            <label for="lastname" id="bookdetail">도서설명</label>
            <textarea rows="3" cols="100" class="form-control"
              id="detail" name="detail"></textarea>
          </div>
        </div>
      </div>
    </div>

    <!-- 도서 등록 내용 -->
    <div class="col-sm-6">
      <div class="row">
        <div class="col-sm-10">
          <div class="form-group">
            <label for="title">책제목</label> <input type="text"
              class="form-control" id="title" name="title">
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-sm-10">
          <div class="form-group">
            <label for="author">저자</label> <input type="text"
              class="form-control" id="author" name="author">
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-sm-10">
          <div class="form-group">
            <label for="publisher">출판사</label> <input type="text"
              class="form-control" id="publisher" name="publisher">
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-sm-10">
          <div class="form-group">
            <label for="bigCategoryLa">대분류</label> <select
              class="form-control" id="categoryBigNo"
              name="categoryBigNo">
              <option value="1">국내도서</option>
              <option value="2">외국도서</option>
            </select>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-sm-10">
          <div class="form-group">
            <label for="lastname">소분류</label> <select
              class="form-control" id="categoryNo" name="categoryNo">
              <option value="1">소설</option>
              <option value="2">참고서</option>
              <option value="3">만화</option>
              <option value="4">잡지</option>
            </select>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-sm-10">
          <div class="form-group">
            <label for="lastname">가격</label> <input type="number"
              class="form-control" id="price" name="price">
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-sm-10">
          <div class="form-group">
            <label for="lastname">수량</label> <input type="number"
              class="form-control" id="qty" name="qty">
          </div>
        </div>
      </div>

    </div>


    <div class="col-sm-3 col-sm-offset-9">
      <div class="form-group">
        <input class=" btn btn-template-main form-control" type="submit"
          id="regist" value="등록">
      </div>
    </div>
  </form>
</div>
<!-- /.col-md-9 -->