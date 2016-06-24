<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  response.setHeader("Pragma", "no-cache");
  response.setHeader("Cache-Control", "no-store");
  response.setDateHeader("Expires", -1);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录页</title>
<!-- Bootstrap core CSS -->
<link href="<c:url value='/bootstrap/css/bootstrap.min.css' />" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="<c:url value='/bootstrap/css/signin.css' />" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="<c:url value='/bootstrap/js/html5shiv.min.js' />"></script>
  <script src="<c:url value='/bootstrap/js/respond.min.js' />"></script>
<![endif]-->
<script type="text/javascript" src="<c:url value='/js/jquery-1.11.3.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/md5.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/tools.js?t=${initParam.buildTimeStamp}' />"></script>
<script type="text/javascript">
  $(function() {
    $(document).off('.btn.data-api');
    $('#submit-btn').on(
        'click',
        function() {
          var param = 'account=' + $.trim($('#inputEmail').val()) + '&password='
              + $.md5($.trim($('#inputPassword').val()));
          $.ajax({
            type : 'POST',
            url : basePath + '/login.json',
            data : param,
            success : function(data) {
              if (data.code == 0) {
                alert('登录成功');
              } else {
                alert('登录失败');
                window.location.href = basePath + '/';
              }
            }
          });
          return false;
        });
  });
</script>
</head>
<body>
  <div class="container">
    <form class="form-signin">
      <h2 class="form-signin-heading">请登录</h2>
      <label for="inputEmail" class="sr-only">用户名</label> <input type="email" id="inputEmail" class="form-control"
        placeholder="Email address" required autofocus /> <label for="inputPassword" class="sr-only">密码</label> <input
        type="password" id="inputPassword" class="form-control" placeholder="Password" required />
      <div class="checkbox">
        <label> <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit" id="submit-btn">确定</button>
    </form>
  </div>
</body>
</html>