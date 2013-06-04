<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns:html="http://www.w3.org/1999/xhtml">
<head>
    <title>保存博客链接信息</title>
    <%@include file="/WEB-INF/pages/public/commons.jspf" %>
</head>
<body>

<%--显示错误--%>
<div class="errorMessages"><html:errors suffix="html.br"/></div>

<%--显示表单--%>
<html:form action="/manage/blogLink" styleClass="validate" focus="title">
    <html:hidden property="method" value="${BlogLinkActionForm.id eq null ?  'add':  'edit'}"/>
    <html:hidden property="id"/>
    <table class="form">
    	<tr><td class="label">标题</td>
			<td class="field"><html:text property="title" styleClass="input1 required"/></td>
    	</tr>
    	<tr><td class="label">作者</td>
			<td class="field"><html:text property="author" styleClass="input1 required"/></td>
    	</tr>
    	<tr><td class="label">URL</td>
    		<td class="field"><html:text property="url" styleClass="input1 required"/></td>
    	</tr>
    	<tr><td class="label">说明</td>
			<td class="field"><html:textarea property="description"/></td>
    	</tr>
    	<tr class="func_list"><td colspan="2"><html:submit value="提交"/></td></tr>
    </table>
</html:form>

</body>
</html>