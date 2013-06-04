<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>设置主题类型</title>
    <%@ include file="/WEB-INF/pages/public/commons.jspf" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/style/forum_right.css"/>
</head>
<body>

<%--显示表单--%>
<html:form action="/manage/topic">
    <html:hidden property="method" value="changeType"/>
    <html:hidden property="id"/>
    <table cellpadding="0" cellspacing="0" border="0" class="form">
    	<tr><td>主题</td>
    		<td>${request_topic.title }</td>
    	</tr>
    	<tr><td class="label">类型</td>
    		<td class="field">
    			<c:forEach items="${APPLICATION_TOPIC_TYPE_LIST}" var="type">
			        <html:radio property="type" value="${type}"/>${type}
			    </c:forEach>
			</td>
    	</tr>
    	<tr><td>说明</td>
    		<td>如果要修改为“头条”类型，请使用“修改主题”功能。因为还要输入摘要。</td>
    	</tr>
    	<tr class="func_list"><td colspan="2"><html:submit value="提 交"/></td></tr>
    </table>
</html:form>

</body>
</html>