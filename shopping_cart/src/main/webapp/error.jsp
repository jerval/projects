<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>错误信息</title>

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
<!--
body {
	background-color: #CCC;
}

.main {
	margin-top: 100;
	margin-left: 100;
	margin-right: 100;
}

body,td,th {
	font-family: 宋体;
	font-size: 13px;
	color: #C00;
}
-->
</style>
  </head>
  
  <body>
   <div class="main">  <center><p><a href="<%=path%>/shopping_mall.jsp">继续购物</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="show_goods.jsp">查看购物情况</a></p> 
  
     <p><strong>出错了！！！</strong></p>
     <p>&nbsp;</p>
     
   </center><br>
   出错信息： <%=request.getAttribute("msg")%> %></div>
  </body>
</html>
