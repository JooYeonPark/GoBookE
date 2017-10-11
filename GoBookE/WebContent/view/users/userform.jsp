<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
  <form action = "/user/regist.do" class="regist">
         <fieldset>
           <div class="container">
              <div class="row">
                 <div class="col-sm-3 form-group">
                    <div class="form-group">
                         <label for="name">아이디</label>
                         <input type="text" class="form-control" id="id" name="id"  required >
                   </div>
                 </div>
             </div>
             <%-- /.row --%>
             <div class="row">
                 <div class="col-sm-3 form-group">
                    <div class="form-group">
                         <label for="password">비밀번호</label>
                         <input type="password" class="form-control" id="password" name="password"  required >
                   </div>
                 </div>
             </div>
             <%-- /.row --%>
             
             <label for="ckPassword">비밀번호 확인</label>
             <div class="row">
               <div class="col-sm-4 form-group">
                  <input type="password" class="form-control" id="ckPassword" name="ckPassword" required>
               </div>
               <div class="col-sm-2 form-group">
                   <input type="button" onclick="" value="비밀번호 확인" class="btn btn-template-main"><br>
               </div>
             </div><%-- /.row --%>
             
             <label for="name">이름</label>
             <div class="row">
               <div class="col-sm-3 form-group">
                  <input type="text" class="form-control" id="name" name="name" required>
               </div>
             </div><%-- /.row --%>
             
             <label for="telephone">휴대폰번호</label>
                <div class="row">
                  <div class="form-group">
                    <div class="col-sm-2 form-group">
                        <select class="form-control" style="width:100%;" id="tel1" name="tel1">
                           <option value="010">010</option>
                           <option value="02">02</option>
                           <option value="031">031</option>
                           <option value="032">032</option>
                           <option value="033">033</option>
                           <option value="041">041</option>
                           <option value="042">042</option>
                           <option value="043">043</option>
                           <option value="051">051</option>
                           <option value="052">052</option>
                           <option value="053">053</option>
                           <option value="054">054</option>
                           <option value="055">055</option>
                           <option value="061">061</option>
                           <option value="062">062</option>
                           <option value="063">063</option>
                           <option value="064">064</option>
                         </select>
                  </div><%-- ./col-sm-2 --%>
                  <div class="col-sm-2 form-group">
                      <input type="text" class="form-control" id="tel2" name="tel2" required>
                  </div>
                      <div class="col-sm-2 form-group">
                          <input type="text" class="form-control" id="tel3" name="tel3"  required>
                      </div>
                </div><%-- /.form-group --%>
              </div><%-- /.row --%>
              
              <label for="email">이메일</label>
              <div class="row">
                 <div class="col-sm-3 form-group">
                    <input type="email" class="form-control" id="email" name="email" required>
                 </div>
              </div><%-- /.row --%>
             
             <label for="street">주소</label>
             <div class="row">
               <div class="col-sm-4 form-group">
                  <input type="text" class="form-control" id="postcode" name="postcode" required>
               </div>
               <div class="col-sm-2 form-group">
                   <input type="button" onclick="daumPostcode()" value="우편번호 찾기" class="btn btn-template-main"><br>
               </div>
             </div><%-- /.row --%>
             <div class="row">
                 <div class="col-sm-6 form-group">
                      <input type="text" class="form-control" id="address" name="address"  required>
                 </div>
                 <div class="col-sm-6 form-group">
                     <input type="text" class="form-control" id="addressDetail" name="addressDetail"  required>
                     <span id="guide" style="color:#999"></span>
                 </div>
             </div><%-- /.row --%>
             <div class="box-footer">
                <div class="pull-right">
                    <button type="submit" class="btn btn-template-main">완료<i class="fa fa-chevron-right"></i>
                    </button>
                </div>
             </div><%-- /.box-footer --%>
           </div><%-- /.container --%>
         </fieldset>
       </form>
</body>
</html>