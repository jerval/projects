<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>系统初始化</title>
		<%@ include file="/WEB-INF/pages/public/commons.jspf" %>
	</head>
	<body>
		<ol>
			<li><a href="install_database.jsp">重新创建数据库/(重新创建)</a></li>
			<li><a href="install_DD.jsp">初始化数据字典</a></li>
			<li><a href="install_initPrivilegeAndRoleAndUser.jsp">初始化权限角色与超级用户</a></li>
		</ol>
	</body>
</html>
