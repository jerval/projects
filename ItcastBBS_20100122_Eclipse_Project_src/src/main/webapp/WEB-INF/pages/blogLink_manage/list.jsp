<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns:html="http://www.w3.org/1999/xhtml">
<head>
    <title>博客链接列表</title>
    <%@include file="/WEB-INF/pages/public/commons.jspf" %>
</head>
<body>

<%--显示错误--%>
<div class="errorMessages"><html:errors suffix="html.br"/></div>

<%--显示数据--%>
<table class="list">
    <%--表头--%>
    <tr class="head">
        <th>标题</th>
        <th>作者</th>
        <th>URL</th>
        <th>相关操作</th>
    </tr>

    <%--显示数据列表开始--%>
    <c:forEach items="${request_list }" var="item" varStatus="status">
    <tr class="item">
        <td title="${item.description }">${item.title }</td>
        <td>${item.author }</td>
       	<td>${item.url }</td>
        <td><html:link action="/manage/blogLink?method=editUI&id=${item.id}">修改</html:link>
            <html:link action="/manage/blogLink?method=del&id=${item.id}" onclick="return confirmDel()">删除</html:link>
        </td>
    </tr>
    </c:forEach>
    <%--显示数据列表结束--%>

    <tr class="func_list"><td align="right" colspan="4"><html:link action="/manage/blogLink?method=addUI">添加</html:link></td></tr>
</table>

</body>
</html>