<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>消息提示</title>
    
  </head>
  
  <body>
    <s:property value="messageContent"/><br/>
    <a href="<%=path %>/">返回首页</a>
  </body>
</html>
