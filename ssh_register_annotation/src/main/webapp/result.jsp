<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>信息反馈</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
<!--
body, td, th {
	font-size: 13px;
	color: #000;
}
body {
	background-color: #CCC;
}
a:link {
	color: #999;
}
a:visited {
	color: #999;
}
-->
</style>
</head>
<body>
<center>
msg:<%=request.getAttribute("msg") %>
</center>
</body>
</html>
