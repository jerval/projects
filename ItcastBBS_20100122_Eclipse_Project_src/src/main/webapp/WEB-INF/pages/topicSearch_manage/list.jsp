<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns:html="http://www.w3.org/1999/xhtml">
<head>
    <title>信息列表</title>
    <%@include file="/WEB-INF/pages/public/commons.jspf" %>
</head>
<body>

<%--显示错误--%>
<div class="errorMessages"><html:errors suffix="html.br"/></div>

<%--显示数据--%>
<table class="list">
	<caption>主题索引信息</caption>
	
    <%--显示数据列表开始--%>
    <tr class="item">
        <td width="200px">数据库中的主题的数量</td>
        <td>${topicCount }</td>
    </tr>
    <tr class="item">
        <td width="200px">索引库中的主题索引的数量</td>
        <td>${searchableTopicCount }</td>
    </tr>
    <%--显示数据列表结束--%>
    
	<tr class="func_list"><td align="right" colspan="2"><html:link action="/manage/topicSearch?method=reCreateAll">重新创建所有主题的索引</html:link></td></tr>
</table>
</body>
</html>