<%@ page contentType="text/html; charset=utf-8"%>

<div class="col-sm-9">
  <h3>도서 재고</h3>

  <div class="tabs">

    <ul class="nav nav-pills nav-justified">
      <li class="active"><a href="#tab2-1" data-toggle="tab">전체</a></li>
      <li class=""><a href="#tab2-2" data-toggle="tab">국내도서</a></li>
      <li class=""><a href="#tab2-3" data-toggle="tab">외국도서</a></li>
    </ul>

    <div class=" tab-content nav-justified" style="border: none;">

      <div class="tab-pane active" id="tab2-1">
        <table class="table table-hover">
          <thead>
            <tr>
              <th>No</th>
              <th>BookName</th>
              <th>Publisher</th>
              <th>Price</th>
              <th>QTY</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th>0001</th>
              <td>우아아아아</td>
              <td>꼬부기</td>
              <td>8,000원</td>
              <td>2</td>
              <td><input type="button" value="주문"></td>
            </tr>
            <tr>
              <th>0001</th>
              <td>우아아아아</td>
              <td>꼬부기</td>
              <td>8,000원</td>
              <td>24</td>
              <td></td>
            </tr>
            <tr>
              <th>0001</th>
              <td>우아아아아</td>
              <td>꼬부기</td>
              <td>8,000원</td>
              <td>24</td>
              <td></td>
            </tr>
            <tr>
              <th>0001</th>
              <td>우아아아아</td>
              <td>꼬부기</td>
              <td>8,000원</td>
              <td>24</td>
              <td></td>
            </tr>
            <tr>
              <th>0001</th>
              <td>우아아아아</td>
              <td>꼬부기</td>
              <td>8,000원</td>
              <td>24</td>
              <td></td>
            </tr>
          </tbody>
        </table>
      </div>
      <!-- /.tab -->

      <div class="tab-pane" id="tab2-2">
        <table class="table table-hover">
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
            <tr>
              <th>0001</th>
              <td>우아아아아</td>
              <td>꼬부기</td>
              <td>200</td>
              <td>1,600,000원</td>
              <td>2017/09/21</td>
            </tr>
            <tr>
              <th>0001</th>
              <td>우아아아아</td>
              <td>꼬부기</td>
              <td>200</td>
              <td>1,600,000원</td>
              <td>2017/09/21</td>
            </tr>
            <tr>
              <th>0001</th>
              <td>우아아아아</td>
              <td>꼬부기</td>
              <td>200</td>
              <td>1,600,000원</td>
              <td>2017/09/21</td>
            </tr>
            <tr>
              <th>0001</th>
              <td>우아아아아</td>
              <td>꼬부기</td>
              <td>200</td>
              <td>1,600,000원</td>
              <td>2017/09/21</td>
            </tr>
            <tr>
              <th>0001</th>
              <td>우아아아아</td>
              <td>꼬부기</td>
              <td>200</td>
              <td>1,600,000원</td>
              <td>2017/09/21</td>
            </tr>
          </tbody>
        </table>
      </div>
      <!-- /.tab -->


      <div class="tab-pane" id="tab2-3">
        <table class="table table-hover">
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
            <tr>
              <th>0001</th>
              <td>우아아아아</td>
              <td>꼬부기</td>
              <td>200</td>
              <td>1,600,000원</td>
              <td>2017/09/21</td>
            </tr>
            <tr>
              <th>0001</th>
              <td>우아아아아</td>
              <td>꼬부기</td>
              <td>200</td>
              <td>1,600,000원</td>
              <td>2017/09/21</td>
            </tr>
            <tr>
              <th>0001</th>
              <td>우아아아아</td>
              <td>꼬부기</td>
              <td>200</td>
              <td>1,600,000원</td>
              <td>2017/09/21</td>
            </tr>
            <tr>
              <th>0001</th>
              <td>우아아아아</td>
              <td>꼬부기</td>
              <td>200</td>
              <td>1,600,000원</td>
              <td>2017/09/21</td>
            </tr>
            <tr>
              <th>0001</th>
              <td>우아아아아</td>
              <td>꼬부기</td>
              <td>200</td>
              <td>1,600,000원</td>
              <td>2017/09/21</td>
            </tr>
          </tbody>
        </table>
      </div>
      <!-- /.tab -->
    </div>

    <!-- pagination START -->
    <div style="text-align: center;" >
    <ul class="pagination" style="margin: auto;">
      <li><a href="#">«</a></li>
      <li><a href="#">1</a></li>
      <li><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">4</a></li>
      <li><a href="#">5</a></li>
      <li><a href="#">»</a></li>
    </ul>
    </div>
    <!-- pagination END -->
    
    
  </div>
  <!-- /.tabs -->
  
  <br>
</div>
