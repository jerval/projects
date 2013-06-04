<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>error .jsp
  <h1 style="color:red;">出错了！！！！</h1>
  s:actionmessage:<s:actionmessage/><hr/>
  s:actionerror:<s:actionerror/><hr/>
  s:fielderror:<s:fielderror></s:fielderror><hr/>
  <br/><a href="javascript:window.history.back(-1);">点此返回</a>
  <s:debug></s:debug>
  </body>
</html>
