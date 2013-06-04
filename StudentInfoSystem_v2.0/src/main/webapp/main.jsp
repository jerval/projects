<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Pragma", "No-cache");//HTTP     1.1      
	response.setHeader("Cache-Control", "no-cache");//HTTP     1.0      
	response.setHeader("Expires", "0");//防止被proxy
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/main.css" />
	</head>
	<frameset rows="110,*,60" cols="*" framespacing="0" frameborder="no"
		border="0">
		<frame src="header.jsp" name="topFrame" scrolling="No"
			noresize="noresize" id="topFrame" />
		<frameset cols="240,*" frameSpacing=8 borderColor=#7eaadb
			frameborder="yes">
			<frame src="left.jsp" name="mainLeftFrame" id="mainLeftFrame"
				scrolling="auto" />
			<frame src="center.jsp" name="mainFrame" id="mainFrame"
				scrolling="auto" />
		</frameset>
		<frame src="footer.jsp" name="bottomFrame" scrolling="No"
			noresize="noresize" id="bottomFrame" />
	</frameset>
	<noframes>
		<body>
		</body>
	</noframes>
</html>