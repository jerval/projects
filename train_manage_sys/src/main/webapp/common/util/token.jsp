<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />    
    <title>操作提示</title>
  </head>
  <body topmargin="50">
	  <table width="400" height="316" border="0" align="center" background="<%=path %>/common/images/errorbg.gif">
	    <tr>
	      <td height="35" colspan="3" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系统提示</td>
	    </tr>
        <tr height="50"><td colspan="3">&nbsp;</td></tr>
	    <tr>
	      <td width="30">&nbsp;</td>
	      <td align="left" valign="top" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;表单已经成功提交或者已过期。</td>
	      <td width="30">&nbsp;</td>
	    </tr>
	    <tr height="150">
	    	<td width="30">&nbsp;</td>
	    	<td align="center"><a href="<%=path %>/"><img src="<%=path %>/common/images/backToIndex.gif" border="0" /></a></td>
	    	<td width="30">&nbsp;</td>
	    </tr>
	  </table>
</body>
</html>
