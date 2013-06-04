<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>主题列表</title>
    <%@ include file="/WEB-INF/pages/public/commons.jspf" %>
    <script type="text/javascript">
        $(function() {
            $(".area_stickylist>ul>li:odd").css("background-color", "#F7F7FF");
            $(".area_articlelist>ul>li:even").css("background-color", "#FFFFFF");
        });
        function toggleStickyList() {
            $("ul.stickylist").toggle();
            $(".stickylist_hidden_flag").toggle();
        }
        function getPageViewUrl(pageNum) {
            return "?method=showLeft&id=${request_forum.id}&pageNum=" + pageNum;
        }
        function toTopicAddUI(){
            parent.right.document.location.href = "${basePath}/topic.do?method=addUI&forumId=${request_forum.id}";
        }
        function jumpToForum(forumId){
        	$.blockUI({ 
				message: '<p style="font-size: 16px;font-weight: bold;">正在跳转，请稍候...</p>' 
			});
        	document.location.href = "${basePath}/forum.do?method=showLeft&id=" + forumId;
        }
    </script>
    <link href="${basePath}/style/forum_left.css" rel="stylesheet" type="text/css" charset="utf-8"/>
    <style type="text/css">
    /*FIXME class属性值使用了中文，好像不能放到css文件中?*/
.普通 a:link,.普通 a:visited { 
	color: #3766AC;
}

.置顶 a:link,.置顶 a:visited {
	color: blue;
}

.公告 a:link,.公告 a:visited {
	color: #228B22;
}

.头条 a:link,.头条 a:visited {
	color: #8A2BE2;
}

.精华 a:link,.精华 a:visited {
	color: #DC143C;
}
</style>
</head>
<body>

<%--快速跳转--%>
<div align="right" style="margin-bottom: 7px;">
	跳转到其他版面：
	<select id="forumId" onchange="jumpToForum(this.value)" style="font-size: 12px;">
	<c:forEach items="${request_categoryList}" var="category">
		<optgroup label="${category.name }" style="font-style: normal; font-family: '宋体'; color: blue;"></optgroup>
		<c:forEach items="${category.forums}" var="forum">
			<%--缩进一个全角空格--%>
			<option ${param.id eq forum.id ? 'selected=\\"selected\\"' :''}
				 value="${forum.id}">　${forum.name}</option>
		</c:forEach>
	</c:forEach>
	</select>
</div>

<%--置顶贴列表--%>
<div class="area_stickylist">
    <h2><span style="float: left;"><img src="${basePath}/style/images/icon_12.gif"/>置顶贴列表</span><span
            class="stickylist_hidden_flag">(已隐藏)</span><span class="switch"><a
            href="javascript: toggleStickyList()" title="点击隐藏或显示置顶贴列表">隐藏/显示</a></span>
    </h2>
    <ul class="stickylist">
        <%--置顶贴列表--%>
        <c:forEach items="${request_stickyTopicList}" var="topic">
            <li><span class="posttime">最后更新:<fmt:formatDate value="${topic.lastArticlePostTime}" pattern="yy-MM-dd HH:mm"/></span>
            	<span style="font-family: '宋体'">·</span>
            	<html:link target="right" action="/topic?method=show&id=${topic.id}">
            		<c:out value="${topic.title}"/></html:link> 
                (${topic.replyCount}回复)
            </li>
        </c:forEach>
    </ul>
</div>
<div class="area_buttonlist">
    <input type="button" class="btn" value="刷新主题列表" onclick="document.location.reload(true)"/>
    <input type="button" class="btn" value="发表新主题" onclick="toTopicAddUI()"/>
    <%--<form style="display: inline; margin-left: 20px;">--%>
    <%--搜索：--%>
    <%--<input type="text" name="queryString" class="input"/>--%>
    <%--<input type="submit" class="btn" value="搜索"/>--%>
    <%--</form>--%>
</div>
<!--===================主题列表==================-->
<div class="area_articlelist">
    <%--主题列表分页信息--%>
    <%@ include file="/WEB-INF/pages/public/pageview.jspf" %>
    <ul>
        <%--本页主题列表--%>
        <c:forEach items="${request_pageView.recordList}" var="topic">
            <li class="${topic.type }">◆ <span style="color:#8a2be2"><html:link
                    action="/topic?method=show&id=${topic.id}&pageNum=1"
                    target="right">【${topic.type}】<c:out value="${topic.title}"/></html:link></span>
                (${topic.replyCount}回复)
            </li>
        </c:forEach>
    </ul>
    <%--主题列表分页信息--%>
    <%@ include file="/WEB-INF/pages/public/pageview.jspf" %>
</div>
<!--===================主题列表结束==================-->
</body>
</html>
