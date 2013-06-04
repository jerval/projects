<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.naming.InitialContext,com.jerval.ejb.demo1.HelloWorldLocal" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	InitialContext initialContext = new InitialContext();
	HelloWorldLocal helloWord = (HelloWorldLocal) initialContext
			.lookup("HelloWorldBean/local");
	out.println(helloWord.sayHello("local java3"));
	out.println(helloWord.getClass().getName());
%>
</body>
</html>