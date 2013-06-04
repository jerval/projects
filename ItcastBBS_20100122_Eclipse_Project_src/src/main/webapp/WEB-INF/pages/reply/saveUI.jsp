<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>发表回复</title>
    <%@ include file="/WEB-INF/pages/public/commons.jspf" %>
    <link href="${basePath}/style/forum_right.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${basePath }/widgets/fckeditor/fckeditor.js"></script>
    <script type="text/javascript">
        $(function(){
        	var editor = new FCKeditor('content');
			editor.BasePath="${basePath }/widgets/fckeditor/";
			editor.ToolbarSet= "ItcastBBS";
			editor.Height=300;
			editor.Width=600;
			editor.Config['EnableAdvanceTable'] = true;
			editor.Config['SkinPath'] = "${basePath }/widgets/fckeditor/editor/skins/office2003/";
			editor.ReplaceTextarea();
        });
    </script>
    <style type="text/css">
    	td{
    		padding-top: 5px;
    	}
    </style>
</head>
<body>

<%--显示错误--%>
<div class="errorMessages"><html:errors suffix="html.br"/></div>

<%--显示表单--%>
<html:form action="/reply" styleClass="validate">
    <html:hidden property="method" value="${ReplyActionForm.id eq null ? 'add' : 'edit' }"/>
    <html:hidden property="pageNum"/>
    <html:hidden property="pageSize"/>
    <html:hidden property="topicId"/>
    <html:hidden property="id"/>
    <table cellpadding="0" cellspacing="0" border="0" style="width: 630px;">
    	<tr><td class="lable">标题</td>
    		<td class="field"><html:text property="title" style="width: 595px;"/></td>
    	</tr>
    	<tr><td class="lable" style="vertical-align: top;">内容</td>
    		<td class="field">
    			<html:textarea property="content" styleClass="required min"/>
    			<script type="text/javascript">
    				$("textarea[name=content]").attr("minlength", "10");
    			</script>
    		</td>
    	</tr>
    	<tr><td colspan="2" align="center"><html:submit value="提 交"/></td></tr>
    </table>
</html:form>

</body>
</html>