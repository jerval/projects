<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>

  </head>
  
  <body>
  发生错误了：<s:property value="exception.message"/>
  <s:debug></s:debug>
    <a href="<%=path %>/system/login.jsp">login</a>
    
  </body>
</html>
