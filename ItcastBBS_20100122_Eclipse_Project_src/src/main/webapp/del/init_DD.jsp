<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="cn.itcast.bbs.dd.DataDict"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%
	ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(application);
	SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
	DataDict.initialize(sessionFactory);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<body>
		success.
	</body>
</html>
