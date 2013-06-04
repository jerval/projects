<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />    
    <title>操作提示</title>
    
	<meta http-equiv="refresh" content="<s:property value="message.timeOut"/>;url=<%=path %><s:property value="message.toURL"/>"/>
  </head>
  <body topmargin="50">
	  <table width="400" height="316" border="0" align="center" background="<%=path %>/common/images/<s:if test="message.messageType == true">okbg.gif</s:if><s:else>errorbg.gif</s:else>">
	    <tr>
	      <td height="35" colspan="3" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系统提示</td>
	    </tr>
        <tr height="50"><td colspan="3">&nbsp;</td></tr>
	    <tr>
	      <td width="30">&nbsp;</td><td align="left" valign="top" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="message.messageContent" /></td><td width="30">&nbsp;</td>
	    </tr>
	  </table>
   </body>
</html>
