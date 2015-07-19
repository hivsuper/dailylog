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
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login.css' />" />
<script type="text/javascript" src="<c:url value='/js/jquery-1.11.3.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/md5.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/tools.js' />"></script>
<script type="text/javascript">
  $(function() {
    var loginUrl = basePath + '/login/ajaxLogin';
    alert(loginUrl);
  });
</script>
</head>
<body></body>
</html>