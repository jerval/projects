<%@ page language="java" pageEncoding="utf-8" %>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns:html="http://www.w3.org/1999/xhtml">
<head>
    <title>主题搜索结果</title>
    <%@include file="/WEB-INF/pages/public/commons.jspf" %>
    <style type="text/css">
    	body, td{
    		font-family: "宋体";
    	}
    	table.list{
    		border: none;
    		margin: 12px 5px;
    	}
    	table.list td{
    		border: none;
    		padding: 5px;
    	}
    	table.list td.title a{
			color:#3333CC;
			font-size:14px;
			text-decoration:underline;
    	}
    	table.list td.content{
    		color: #000000;
    	}
    	span.keyword{
    		color: red;
    	}
    	#searchform{
    		margin-bottom: 5px; 
    	}
    </style>
</head>
<body>

<%--显示表单--%>
<html:form action="/topicSearch" styleClass="validate" method="get" focus="queryString" styleId="searchform">
    <html:hidden property="method" value="searchTopic"/>
    <html:hidden property="pageNum" value="1"/>
    <html:hidden property="pageSize" value="20"/>
    <img src="${basePath }/style/images/search.gif"/>
	<span style="color:#0079C5; font-size:14px; font-weight:bold;">站内主题搜索</span>
	<html:text property="queryString" style="width: 450px" styleClass="required"/>
	<html:submit value="搜索"/>
</html:form>

<hr width="100%" style="color: rgb(221, 221, 221);"/>


<%
	Calendar c = Calendar.getInstance();
	Date today = c.getTime();

	c.add(Calendar.DAY_OF_MONTH, -1);
	Date yesterday = c.getTime();
	
	c.add(Calendar.DAY_OF_MONTH, -6);
	Date lastWeek = c.getTime();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	pageContext.setAttribute("today", sdf.format(today));
	pageContext.setAttribute("yesterday", sdf.format(yesterday));
	pageContext.setAttribute("lastWeek", sdf.format(lastWeek));
%>

<%--快速查询--%>
<div style="padding-left: 20px;">
	<html:link action="/topicSearch?method=searchTopic&pageSize=20">
		公告贴<html:param name="queryString">type:"公告"</html:param>
	</html:link>

	<span style="margin: auto 10px;">|</span>
	<html:link action="/topicSearch?method=searchTopic&pageSize=20">
		头条贴<html:param name="queryString">type:"头条"</html:param>
	</html:link>
	
	<span style="margin: auto 10px;">|</span>
	<html:link action="/topicSearch?method=searchTopic&pageSize=20">
		精华贴<html:param name="queryString">type:"精华"</html:param>
	</html:link>

	<span style="margin: auto 10px;">|</span>
	<html:link action="/topicSearch?method=searchTopic&pageSize=20">
		零回复<html:param name="queryString">replyCount:0</html:param>
	</html:link>
	
	<span style="margin: auto 10px;">|</span>
	<html:link action="/topicSearch?method=searchTopic&pageSize=20">
		最近一周<html:param name="queryString">postTime:[${lastWeek} TO ${today}]</html:param>
	</html:link>

	<span style="margin: auto 10px;">|</span>
	<html:link action="/topicSearch?method=searchTopic&pageSize=20">
		最近一天<html:param name="queryString">postTime:[${yesterday} TO ${today}]</html:param>
	</html:link>
	
</div>



<%--显示数据--%>
<table class="list">
    <%--表头--%>
    <tr class="head">
        <th width="150px" style="border-right: none" align="left">
        	共有<font color="red">${request_pageView.recordCount }</font>个结果</th>
        <th style="border-left: none; padding-right: 10px" align="right">
        	<html:link action="/portal?method=index">返回ItcastBBS主页</html:link></th>
    </tr>
</table>

<%--显示数据列表开始--%>
<c:forEach items="${request_pageView.recordList }" var="item" varStatus="status">
<table class="list">
    <tr>
        <td class="title">
        	<html:link action="/forum?method=showMain&id=${item.forumId }&topicId=${item.id}" target="_blank">
        		<%--FIXME 这里不能使用c:out，否则标题中就不能关键字高亮了--%>
        		【${item.type}】${item.title }</html:link>
        	<span>发表时间:<fmt:formatDate value="${item.postTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
       	</td>
    </tr>
    <tr><td class="content">${item.content }</td></tr>
    <tr><td class="info">
    		作者:<font color="blue">${item.authorNickname }</font> &nbsp;&nbsp;&nbsp;&nbsp;
	    	IP:${item.ipAddr}&nbsp;&nbsp;&nbsp;&nbsp;
	         最后回复时间:<fmt:formatDate value="${item.postTime}" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp;&nbsp;&nbsp;
	      	回复数:${item.replyCount }
        </td>
    </tr>
</table>
</c:forEach>
<%--显示数据列表结束--%>

<%--显示分页信息--%>
<table class="list">
    <%--表头--%>
    <tr class="head">
        <th>
			<%@ include file="/WEB-INF/pages/public/pagination.jspf" %>
			<script type="text/javascript">
				var paginationOptions = {
					type: "form",
					form: document.getElementById('searchform')
				};
			</script>
        </th>
    </tr>
</table>

</body>
</html>