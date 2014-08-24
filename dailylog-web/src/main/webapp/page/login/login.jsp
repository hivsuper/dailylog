<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
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
<script type="text/javascript" src="<s:url value="/js/ext-all.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<s:url value='/css/login.css' />" /> 
<link rel="stylesheet" type="text/css" href="<s:url value='/css/ext-theme-neptune/ext-theme-neptune-all-debug.css' />" />
<script type="text/javascript">
	var loginUrl='<s:url value="/login/ajaxLogin" />';
	var nextUrl='<s:url value="/home" />';
</script> 
<script type="text/javascript" src="<s:url value='/js/verifycode.js' />"></script>
<script type="text/javascript" src="<s:url value='/js/md5.js' />"></script>
<script type="text/javascript" src="<s:url value='/js/login.js' />"></script>
</head>
	<body></body>
</html>