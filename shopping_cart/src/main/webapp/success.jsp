<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>购物成功</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <style type="text/css">
<!--
body {
	background-color: #CCC;
}
.main{
	margin-top:100;
	margin-left:100;
	margin-right:100;
	text-align:center;
}
body,td,th {
	font-family: 宋体;
	font-size: 13px;
	color: #06C;
}
-->
</style></head>
  
  <body>
  <div class="main">
    <p><strong>购物成功！祝您购物愉快。</strong></p>
    <p><a href="<%=path%>/shopping_mall.jsp">继续购物</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="show_goods.jsp">查看购物情况</a></p> 
  </div>
</body>
</html>
