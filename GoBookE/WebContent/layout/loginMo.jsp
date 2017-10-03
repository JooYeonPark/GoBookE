<%@ page contentType="text/html; charset=utf-8"%>
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
  aria-labelledby="Login" aria-hidden="true">
  <div class="modal-dialog modal-sm">

    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"
          aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="Login">고객 로그인</h4>
      </div>
      <div class="modal-body">
        <form action="${pageContext.servletContext.contextPath}/user/certify.do" method="post">
          <div class="form-group">
            <input type="text" class="form-control" name="id" id="email_modal"
              placeholder="ID">
          </div>
          <div class="form-group">
            <input type="password" class="form-control" name="passwd"
              id="password_modal" placeholder="password">
          </div>

          <p class="text-center">
            <button type="submit" class="btn btn-template-main">
              <i class="fa fa-sign-in"></i> Log in
            </button>
          </p>

        </form>

        <p class="text-center text-muted">로그인 해주세요.</p>
        <p class="text-center text-muted">
          <a href="/view/users/UserRegist.jsp"><strong>회원가입</strong></a>
        </p>

      </div>
    </div>
  </div>
</div>