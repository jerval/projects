<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>系统提示信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="refresh" content=";url=%>"/>
    <link href="<%=path %>/style/styles.css" rel="stylesheet" type="text/css">
    <style type="text/css">
		#message{width:400px;
		height:316px;
		margin-left:auto;
		margin-right:auto;
		background-repeat:no-repeat;}
	</style>
<base target="mainFrame">
</head>

<BODY leftMargin=0 topMargin=0>
<table border="0"  width="100%" id="table1" height="100%" cellspacing="0" cellpadding="0">
	<tr>
		<td  align="center" >
			<div style="background-image:url(<%=path %>/images/"okbg":"errorbg" %>.gif)" id="message">
            <table  width="400">
            	<tr height="33">
                	<th  width="42">&nbsp;</th>
                  <th width="346" style="color:#006699;" align="left">系统提示</th>
              </tr>
                <tr height="33">
                	<td  colspan="2">&nbsp;</td>
                </tr>
                <tr height="334">
                	<td  colspan="2" style=" font-size:14px;color:#333333;" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
                </tr>
            </table>
      		
            </div>
		</td>
	</tr>
</table>
</body>
</html>