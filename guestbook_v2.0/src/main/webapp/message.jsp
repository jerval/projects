<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>留言首页</title>
        <style type="text/css">
            <!--
            body,td,th {
                font-size: 14px;
                color: #333;
            }
            body {
                background-color: #CCC;
            }
            -->
        </style></head>
</head>
<body>
    <center><a href="${applicationScope.ctx}/login.html">管理员登录</a></center><br>
    <center>
        <pg:pager url="${applicationScope.ctx}/index.html" items="${pageDao.maxElements}" maxPageItems="${pageDao.pageSize}"
                  export="currentPageNumber=pageNumber" maxIndexPages="10">
            <pg:index>
                <pg:first unless="current">
                    <a href="${pageUrl}&pageNum=${pageNumber}">首页</a>
                </pg:first>
                <pg:prev>
                    <a href="${pageUrl}&pageNum=${pageNumber}">上一页</a>
                </pg:prev>
                <pg:pages>
                    <c:choose >
                        <c:when test="${pageNumber == currentPageNumber}">
                            ${pageNumber}
                        </c:when>
                        <c:otherwise>
                            <a href="${pageUrl}&pageNum=${pageNumber}">${pageNumber}</a>
                        </c:otherwise>
                    </c:choose>
                </pg:pages>
                <pg:next>
                    <a href="${pageUrl}&pageNum=${pageNumber}">下一页</a>
                </pg:next>
                <pg:last unless="current">
                    <a href="${pageUrl}&pageNum=${pageNumber}">尾页</a>
                </pg:last>
            </pg:index>
        </pg:pager></center>
    <br>
        <c:forEach var="msg" items="${pageDao.list}" >
            <table width="700px" border="0" align="center" bgcolor="#E1F0FF">
            <tr>
                <td align="left">留言编号:<c:out value="${msg.id}"/></td>
                <td align="right">网友IP：<c:out value="${msg.ip}"/></td>
            </tr>
            <tr>
                <td valign="top" colspan="2"><hr></td>
            </tr>
            <tr>
                <td valign="top" colspan="2"><c:out value="${msg.content}"/></td>
            </tr>
            <tr>
                <td valign="top" colspan="2"><hr></td>
            </tr>
            <tr>
                <td></td>
                <td align="right"><c:out value="${msg.regtime}"/></td>
            </tr>
        </table>
        <br/><br/>
    </c:forEach>
    <center>
        <pg:pager url="${applicationScope.ctx}/index.html" items="${pageDao.maxElements}" maxPageItems="${pageDao.pageSize}"
                  export="currentPageNumber=pageNumber" maxIndexPages="10">
            <pg:index>
                <pg:first unless="current">
                    <a href="${pageUrl}&pageNum=${pageNumber}">首页</a>
                </pg:first>
                <pg:prev>
                    <a href="${pageUrl}&pageNum=${pageNumber}">上一页</a>
                </pg:prev>
                <pg:pages>
                    <c:choose >
                        <c:when test="${pageNumber == currentPageNumber}">
                            ${pageNumber}
                        </c:when>
                        <c:otherwise>
                            <a href="${pageUrl}&pageNum=${pageNumber}">${pageNumber}</a>
                        </c:otherwise>
                    </c:choose>
                </pg:pages>
                <pg:next>
                    <a href="${pageUrl}&pageNum=${pageNumber}">下一页</a>
                </pg:next>
                <pg:last unless="current">
                    <a href="${pageUrl}&pageNum=${pageNumber}">尾页</a>
                </pg:last>
            </pg:index>
        </pg:pager></center>
<br/>
    <center>
        <form name="form1" method="post" action="${applicationScope.ctx}/addmsg.html">
            <table width="700px" border="0" align="center">
                <tr>
                    <td align="left">留言内容</td>
                </tr>
                <tr>
                    <td align="left"><textarea name="message" id="message" cols="80" rows="8" ></textarea></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td><input type="submit" name="button2" id="submit" value="提交"></td>
                </tr>
            </table>
        </form>
    </center>
             
    <div align="right"><a href="${applicationScope.ctx}/admin/login.html">管理员登录</a></div>
</body>
</html>
