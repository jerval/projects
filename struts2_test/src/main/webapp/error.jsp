<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>
  <h1 style="color:red;">出错了！！！！</h1>
  <s:actionmessage/>
  <s:actionerror/>
  <s:fielderror></s:fielderror>
  <br/><a href="javascript:window.history.back(-1);">点此返回</a>
  <s:debug></s:debug>
  </body>
</html>
