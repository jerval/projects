<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>显示主题</title>
    <%@ include file="/WEB-INF/pages/public/commons.jspf" %>
    <link href="${basePath}/style/forum_right.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        var paginationOptions = {
        	type: "url",
			url : "?method=show&id=${request_topic.id}"
        };
        $(function(){ 
        	//1, 内容中出现的超链接都在新窗口中打开
        	$("div.content>a").attr("target", "_blank");
        });
        
        /** 拷贝内容到剪切板 */
      	function copyToClipBoard(){
			// var title = "${request_topic.title}";
	        var url = "${basePath}/forum.do?method=showMain&id=${request_topic.forum.id}&topicId=${request_topic.id}&pageNum=1";
			var clipBoardContent = url;	

			if (window.clipboardData) {   
				window.clipboardData.setData("Text",clipBoardContent);
				alert("地址已经复制到粘贴板!");
		    }else{
		    	// 不能拷贝
		    	alert("不能拷贝");
		    }
		}
		
		//2, 双击右侧，可以关闭或打开左侧
		function toggleLeft(){
        	var fs = parent.document.getElementById("fs2");
			if(fs != null){ 
				if( fs.cols == "0px,*" ){
					fs.cols = "485px,*";
				}else{
					fs.cols = "0px,*";
				}
			}
		}
    </script>
    <style type="text/css">
    	.article .content p{
    		text-indent: 2em;
    	}
    </style>
</head>
<body ondblclick="toggleLeft()">
<div class="title">
    <h3>【${request_topic.type}】<c:out value="${request_topic.title}"/></h3>
    <input style="width: 230px;" type="button" value="复制本帖地址，传给QQ/MSN上的好友" 
    	onclick="copyToClipBoard()" title="点击复制标题和地址到剪贴版,直接在MSN/QQ上粘贴即可."/>
    <!-- <input type="button" value=" 回复 " title="点击进入高级回复页面"/>  -->
    <span style="color: #666666">(回复表单在最下方, 双击网页可以隐藏或打开左侧的主题列表)</span>
    <%--管理文章--%>
	<bbs:permission resource="System" action="Manage">
    <fieldset class="manage">
    	<legend>管理</legend>
    	<html:link action="/manage/topic?method=changeTypeUI&id=${request_topic.id}">更改主题类型</html:link>
    	<html:link action="/topic?method=editUI&id=${request_topic.id}">修改主题</html:link>
    	<html:link action="/manage/topic?method=moveUI&id=${request_topic.id}">移动到其他版面</html:link>
    	<html:link action="/manage/topic?method=del&id=${request_topic.id}"
    		onclick="return confirmDel('确定要删除此主题吗？')">删除此主题</html:link>
    </fieldset>
    </bbs:permission>
    <%--管理文章结束--%>
</div>
<hr/>

<%--显示分页信息--%>
<%@ include file="/WEB-INF/pages/public/pagination.jspf" %>

<!--=======================显示主题========================-->
<div class="articlelist">
	<%--显示主贴（没有回复时，pageView为Empty，currentPage为0）--%>
	<c:if test="${request_pageView.currentPage lt 2}">
    <div class="article" style="font-family:'宋体'">
        <div class="info">
            <h3 class="floor">【楼主】</h3>
            <span class="author">作者:${request_topic.author.nickname}</span>
            <span class="posttime">发表时间:<fmt:formatDate
                    value="${request_topic.postTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
            <%--IP只显示前3段--%>    
            <span class="ipaddr">IP:${request_topic.ipAddr}</span>
        </div>
        <%--显示文章内容--%>
        <div class="content">
       		${request_topic.content}
        </div>
    </div>
    </c:if>
    <%--显示回复列表--%>
    <c:forEach items="${request_pageView.recordList}" var="reply">
        <div class="article" style="font-family:'宋体'">
            <div class="info">
                <h3 class="floor">【${reply.floor}楼】 </h3>
                <span class="author">作者:${reply.author.nickname}</span>
                <span class="posttime">发表时间:<fmt:formatDate
                        value="${reply.postTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                    <%--IP只显示前3段--%>
                <span class="ipaddr">IP:${reply.ipAddr}</span>
            </div>
            <%--显示文章内容--%>
            <div class="content">
                ${reply.content}
            </div>
            
            <%--管理文章--%>
			<bbs:permission resource="System" action="Manage">
			<div style="margin-top: 15px;">
		    <fieldset class="manage">
		    	<legend>管理</legend>
		    	<html:link action="/reply?method=editUI&id=${reply.id}&pageNum=${param.pageNum}&pageSize=${param.pageSize}"
		    		>修改回复</html:link>
		    	<html:link action="/manage/reply?method=del&id=${reply.id}&topicId=${reply.topic.id }&pageNum=${param.pageNum}&pageSize=${param.pageSize}"
		    		onclick="return confirmDel('确定要删除此回复吗？')">删除此回复</html:link>
		    </fieldset>
		    </div>
		    </bbs:permission>
		    <%--管理文章结束--%>
        </div>
    </c:forEach>
</div>
<!--=======================显示主题结束========================-->

<!--=======================快速回复========================-->
<c:if test="${SESSION_LOGGED_ON_USER eq null}">
    <h4 style="margin-top: 20px; font-size:12px; text-align: left; font-weight: normal;">（登录后显示快速回复表单）</h4>
</c:if>
<%--显示回复表单--%>
<c:if test="${SESSION_LOGGED_ON_USER ne null}">
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
			
			$("textarea[name=content]").attr("minlength", "10");
        });
    </script>
    <div style="margin: 20px; text-align: center; width: 500px">
        <html:form action="/reply?method=add" styleClass="validate">
            <html:hidden property="topicId" value="${request_topic.id}"/>
            <h4 style="font-size:12px; text-align: left;">快速回复<span style="font-weight: normal;">(请勿发表与主题无关的言论)</span>
            </h4>
            <html:textarea property="content" styleClass="required min"/><br/>
            <input type="submit" value="发 表" style="margin-top: 10px;"/>
        </html:form>
    </div>
</c:if>
</body>
</html>
