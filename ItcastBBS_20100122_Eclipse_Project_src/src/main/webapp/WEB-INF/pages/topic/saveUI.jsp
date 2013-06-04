<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>发表新主题</title>
    <%@ include file="/WEB-INF/pages/public/commons.jspf" %>
    <link href="${basePath}/style/forum_right.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${basePath }/widgets/fckeditor/fckeditor.js"></script>
    <script type="text/javascript">
        function toggleSummary() {
        	if( "头条" == $("input[name=type]:checked").val() ){
	        	$("tr.topicsummary").show();
        	}else{
        		$("tr.topicsummary").hide();
        	}
        }
        $(function(){
        	// 1, 
        	toggleSummary();
        	// 2,
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
<html:form action="/topic" styleClass="validate" focus="title">
    <html:hidden property="method" value="${TopicActionForm.id eq null ? 'add' : 'edit' }"/>
    <html:hidden property="forumId"/>
    <html:hidden property="id"/>
    <table cellpadding="0" cellspacing="0" border="0" style="width: 635px;">
    	<tr><td width="40px;">标题</td>
    		<td><html:text property="title" style="width: 595px;" styleClass="required max" maxlength="255"/></td>
    	</tr>
    	<tr><td style="vertical-align: top;">内容</td>
    		<td><html:textarea property="content" styleClass="required min"/>
    			<script type="text/javascript">
    				$("textarea[name=content]").attr("minlength", "10");
    			</script>
    		</td>
    	</tr>
    	<bbs:permission resource="System" action="Manage">
    	<tr><td>类型</td>
    		<td><c:forEach items="${APPLICATION_TOPIC_TYPE_LIST}" var="type">
			        <html:radio property="type" value="${type}" onclick="toggleSummary()"/>${type}
			    </c:forEach>
			</td>
    	</tr>
    	</bbs:permission>
    	<tr class="topicsummary"><td>摘要</td>
    		<td><html:textarea property="summary" style="width: 600px; height: 100px;"/>
    			（提示：1，最长500字。2，首页只能显示3条头条贴。）
    		</td>
    	</tr>
    	<tr><td colspan="2" align="center" style="padding-top: 10px;"><html:submit value="提 交"/></td></tr>
    </table>
</html:form>

<div style="margin-top: 20px;">
	提示：书写内容时，使用Enter换行，使用Shift+Enter开始新的一段。
</div>

</body>
</html>