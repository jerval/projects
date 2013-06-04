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
        <title>详细信息</title>
    </head>
    <body>
        <p align="center"><a href="${applicationScope.ctx}/admin/index.html">返回管理首页</a></p><br/>
        <c:forEach var="msg" items="${list}">
        <table width="700" border="0" align="center">
            <tr>
                <td align="left">留言编号：<c:out value="${msg.id}"/></td>
                <td align="right">网友IP：<c:out value="${msg.ip}"/></td>
            </tr>
            <tr>
                <td colspan="2"><hr/></td>
            </tr>
            <tr>
                <td colspan="2"><c:out value="${msg.content}"/></td>
            </tr>
            <tr>
                <td colspan="2"><hr/></td>
            </tr>
            <tr>
                <td></td>
                <td align="right">留言时间：<c:out value="${msg.regtime}"/></td>
            </tr>
        </table> <br/>
        <p align="center"><a href="${ctx}/admin/msgdelete.html?id=${msg.id}">删除</a></p>
        </c:forEach>
       
    </body>
</html>
