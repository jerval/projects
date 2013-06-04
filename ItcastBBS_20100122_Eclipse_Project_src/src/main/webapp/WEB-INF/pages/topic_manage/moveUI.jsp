<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>移支主题到其他版面</title>
    <%@ include file="/WEB-INF/pages/public/commons.jspf" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/style/forum_right.css"/>
    <script type="text/javascript">
    	function checkForm(form){
    		return true;
    	}
    </script>
</head>
<body>

<%--显示表单--%>
<html:form action="/manage/topic" onsubmit="return checkForm(this)">
    <html:hidden property="method" value="move"/>
    <html:hidden property="id"/>
    <table cellpadding="0" cellspacing="0" border="0" class="form">
    	<tr><td>主题</td>
    		<td>${request_topic.title }</td>
    	</tr>
    	<tr><td>现在所属版面</td>
    		<td>${request_topic.forum.name }</td>
    	</tr>
    	<tr><td class="label">移动到</td>
			<td class="field">
				<html:select property="forumId">
					<c:forEach items="${request_categoryList}" var="category">
						<optgroup label="${category.name }" style="font-style: normal; font-family: '宋体'; color: blue;"></optgroup>
						<c:forEach items="${category.forums}" var="forum">
							<%--缩进一个全角空格--%>
							<html:option value="${forum.id}">　${forum.name}</html:option>
						</c:forEach>
					</c:forEach> 
				</html:select>
			</td>
    	</tr>
    	<tr class="func_list"><td colspan="2"><html:submit value="提 交"/></td></tr>
    </table>
</html:form>

</body>
</html>