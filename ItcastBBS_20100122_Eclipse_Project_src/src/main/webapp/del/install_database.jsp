<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="org.hibernate.tool.hbm2ddl.SchemaExport"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%
	Configuration cfg = new Configuration().configure();
	SchemaExport schemaExport = new SchemaExport(cfg);
	schemaExport.create(true, true);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<body>
		success.
	</body>
</html>
