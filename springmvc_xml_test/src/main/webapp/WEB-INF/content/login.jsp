<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>

	<body>
		login page
		<form action="" method="post">
		编号：<input name="no" />
			日期：<input name="date" />
			类型：<select name="type">
			<c:forEach items="${types}" var="type">
			<option value="${type}">${type}</option>
			</c:forEach>
			</select>
			用户名：<input name="username" />
			密码：<input name="password" />
			<input type="submit" value="login" />
		</form>
	</body>
</html>
