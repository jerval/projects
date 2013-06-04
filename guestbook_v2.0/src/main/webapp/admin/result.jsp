<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            body{font-size:13px}
        </style>
        <title>admin信息反馈</title>
    </head>
    <body>

        <p align="center"><c:out value="${msg}"/></p>
        <p align="center">
        <a href="${applicationScope.ctx}/admin/index.html">返回管理首页</a></p>
    </body>
</html>
