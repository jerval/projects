<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns:html="http://www.w3.org/1999/xhtml">
<head>
    <title>保存角色信息</title>
    <%@include file="/WEB-INF/pages/public/commons.jspf" %>
    <script type="text/javascript">
        function selectAll(){
        	$("input[name=roleIdList]").attr("checked", "checked");
        }
        function unselectAll(){
        	$("input[name=roleIdList]").removeAttr("checked");
        }
        function inverseSelect(){
        	var $checkedBoxes = $("input[name=roleIdList][checked]");
        	$("input[name=roleIdList]").attr("checked", "checked");
        	$checkedBoxes.removeAttr("checked")
        }
    </script>
</head>
<body>

<%--显示错误--%>
<div class="errorMessages"><html:errors suffix="html.br"/></div>

<%--显示表单--%>
<html:form action="/manage/user">
    <html:hidden property="method" value="selectRoles"/>
    <html:hidden property="id"/>
    <html:hidden property="pageNum"/>
    <html:hidden property="pageSize"/>
    <table class="form">
    	<tr><td class="label">登录名</td>
			<td class="field"><input type="text" readonly="readonly" value="${request_user.loginName }" class="input2"/></td>
    	</tr>
    	<tr><td class="label">昵称</td>
			<td class="field"><input type="text" readonly="readonly" value="${request_user.nickname }" class="input2"/></td>
    	</tr>
    	<tr><td class="label">选择角色</td>
			<td class="field">
				<c:forEach items="${request_roleList}" var="role"><span style="width: 80px;">
					<html:multibox property="roleIdList" value="${role.id}"/>${role.name}</span>
				</c:forEach>
				<div style="blue">
					<a href="javascript: selectAll()">全选</a>
					<a href="javascript: unselectAll()">取消全选</a>
					<a href="javascript: inverseSelect()">反选</a>
				</div>
			</td>
    	</tr>
    	<tr class="func_list"><td colspan="2"><html:submit value="提交"/></td></tr>
    </table>
</html:form>

</body>
</html>