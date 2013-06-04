<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>

	<body>
		add student view
		<br>
		
<table>
<tr>
<th>学生编号</th>
<th>学生姓名</th>
</tr>
<c:forEach items="${students}" var="student">
<%  
int n=0;

%>
<tr>
<td>${student.stu_no}</td>
<td>${student.stu_name}</td>
</tr>
</c:forEach>
</table>
	</body>
</html>
