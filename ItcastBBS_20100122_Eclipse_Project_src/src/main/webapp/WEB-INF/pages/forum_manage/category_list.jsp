<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns:html="http://www.w3.org/1999/xhtml">
<head>
    <title>分类与版面列表</title>
    <%@include file="/WEB-INF/pages/public/commons.jspf" %>
</head>
<body>

<%--显示错误--%>
<div class="errorMessages"><html:errors suffix="html.br"/></div>

<%--显示数据--%>
<table class="list">
    <%--表头--%>
    <tr class="head">
        <th>名称</th>
        <th width="80px">主题数</th>
        <th width="80px">文章数</th>
        <th width="200px">相关操作</th>
    </tr>

    <%--显示数据列表开始--%>
    <c:forEach items="${request_categoryList }" var="category" varStatus="status">
    <tr class="item">
        <td colspan="3" style="color: blue; font-weight: bold;">${category.name }</td>
        <td><html:link action="/manage/category?method=editUI&id=${category.id}">修改</html:link>
            <html:link action="/manage/category?method=del&id=${category.id}"
                       onclick="return confirmDel()">删除</html:link>
            <html:link action="/manage/category?method=move&id=${category.id}&isUp=true">上移</html:link>
            <html:link action="/manage/category?method=move&id=${category.id}&isUp=false">下移</html:link>
            <html:link action="/manage/forum?method=addUI&categoryId=${category.id}">添加子版面</html:link>
        </td>
    </tr>
    <%--显示分类下的版面开始--%>
    <c:forEach items="${category.forums }" var="forum">
        <tr>
            <td style="padding-left: 30px;">
            	<span style="color: blue;">${forum.name }</span><br>
              	描述: ${forum.description }
            </td>
            <td>${forum.topicCount}</td>
            <td>${forum.articleCount}</td>
            <td><html:link action="/manage/forum?method=editUI&id=${forum.id}">修改</html:link>
                <html:link action="/manage/forum?method=del&id=${forum.id}"
                           onclick="return confirmDel()">删除</html:link>
                <html:link action="/manage/forum?method=move&id=${forum.id }&isUp=true">上移</html:link>
                <html:link action="/manage/forum?method=move&id=${forum.id }&isUp=false">下移</html:link>
            </td>
        </tr>
    </c:forEach>
    <%--显示分类下的版面结束--%>
    </c:forEach>
    <%--显示数据列表结束--%>

    <tr class="func_list"><td align="right" colspan="4"><html:link action="/manage/category?method=addUI">添加分类</html:link></td></tr>
</table>

</body>
</html>