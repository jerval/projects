<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>传智播客BBS首页</title>
    <%@ include file="/WEB-INF/pages/public/commons.jspf" %>
    <link rel="stylesheet" type="text/css" href="${basePath }/style/portal_index.css" />
</head>
<body>
<%--顶部与菜单--%>
<div id="bbstitle" class="gary1">
    <span style="color:#DE0000; font-family:'宋体'; font-weight:bold; font-size: 24px; margin-right: 30px">传智播客论坛</span>
    <a href="#">新手上路</a>
</div>
<div id="bbsnav">
    <ul>
   	<%--未登录用户--%>
    <c:if test="${SESSION_LOGGED_ON_USER eq null}">
        <li><html:link action="/user?method=regUserUI" target="_blank">注册</html:link></li>
        <li class="line"/>
        <li><html:link action="/user?method=loginUI">登录</html:link></li>
        <li class="line"/>
    </c:if>
    <%--登录用户--%>
    <c:if test="${SESSION_LOGGED_ON_USER ne null}">
        <li><html:link action="/user?method=logout">注销</html:link></li>
        <li class="line"/>
    </c:if>
        <li><html:link action="/topicSearch?method=searchTopicUI" target="_blank">站内主题搜索</html:link></li>
        <bbs:permission resource="System" action="Manage" >
        	<li class="line"/>
        	<li><html:link action="/manage/portal?method=index">系统管理</html:link></li>
        </bbs:permission>
    </ul>
</div>
<!--第一行内容-->
<div class="area">
<div class="area_left">
    <div class="area_left_left">
        <!--================登录表单=================-->
        <div class="top_loginform" style="height: 123px;">
            <%--标题--%>
            <h2 class="title_t">
                <%--未登录用户，显示登录表单--%>
                <c:if test="${SESSION_LOGGED_ON_USER eq null}">
                    <p><html:link action="/user?method=regUserUI">注册新用户</html:link></p>
                    <span class="title">用户登录</span>
                </c:if>
                <%--登录用户，显示用户信息--%>
                <c:if test="${SESSION_LOGGED_ON_USER ne null}">
                    <p style="color: #3766AC;">
                    	<html:link action="/user?method=changePasswordUI">修改密码</html:link> | 
                    	<html:link action="/user?method=logout">注销</html:link>
                    </p>
                    <span class="title">用户信息</span>
                </c:if>
            </h2>
            <div class="blank8"></div>

            <%--未登录用户，显示登录表单--%>
            <c:if test="${SESSION_LOGGED_ON_USER eq null}">
                <html:form action="/user?method=login" focus="loginName">
                    <table width="100%" cellspacing="0" cellpadding="0" border="0">
                        <tr>
                            <td width="60" align="right">用户名：</td>
                            <td align="left"><html:text property="loginName" styleClass="login_input"/></td>
                        </tr>
                        <tr>
                            <td width="60" align="right">密　码：</td>
                            <td align="left"><html:password property="password" styleClass="login_input"/></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>   
                            <td align="left">
                                <html:checkbox property="autoLogin" styleClass="middle"/>自动登录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <html:image styleClass="middle" page="/style/images/blogpic004.gif"/>
                            </td>
                        </tr>
                    </table>
                </html:form>
            </c:if>
            <%--登录用户，显示用户信息--%>
            <c:if test="${SESSION_LOGGED_ON_USER ne null}">
                <div style="padding-left: 10px; font-size: 12px; line-height: 20px;">
                	用户名：${SESSION_LOGGED_ON_USER.loginName}<br/>
                   	昵　称：${SESSION_LOGGED_ON_USER.nickname}<br/>
	                  发表主题总数：${SESSION_LOGGED_ON_USER.topicCount}<br/>
	                  发表文章总数：${SESSION_LOGGED_ON_USER.articleCount}<br/>
                </div>
            </c:if>
        </div>
        <!--================登录表单结束=================-->
        
        <%--显示公告列表（最多11条，只有这么大）--%>
        <div class="bottom_groupreg" style="height: 288px;">
            <h2 class="title_t">
            	<!-- <p><a href="#" target="_blank">更多</a></p> -->
                <span class="title">论坛公告</span>
            </h2>
            <div class="blank4"></div>
            <div>
                <ul class="link_listp3" style="padding-left: 9px;">
                    <%--显示公告列表--%>
		            <c:forEach items="${request_announceTopicList}" var="topic">
		                <li><span><fmt:formatDate value="${topic.postTime}" pattern="yy-MM-dd"/></span><html:link
		                        action="/forum?method=showMain&id=${topic.forum.id}&topicId=${topic.id}"
		                        target="_blank"><c:out value="${topic.title}"/></html:link>
		                </li>
		            </c:forEach>
                </ul>
            </div>
            <div class="clearit"></div>
            <div class="blank8"></div>
        </div>
        <!--================显示公告列表结束=================-->
    </div>
    
    <!--================论坛头条列表=================-->
    <div class="area_left_right topnews_list" style="height: 423px;">
        <h2 class="title_t">
            <!-- <p><a href="#" target="_blank">更多</a></p> -->
            <span class="title">论坛头条</span>
        </h2>
        <div class="blank4"></div>
        <%--显示论坛头条--%>
        <c:forEach items="${request_topNewsList}" var="topNews" varStatus="varStatus">
            <h3 class="title_y top_news_title">
            	<html:link action="/forum?method=showMain&id=${topNews.forum.id}&topicId=${topNews.id}"
            		target="_blank"><c:out value="${topNews.title}"/></html:link>
            </h3>
            <p class="top_news_summary">
                    ${topNews.summary}……<span class="orange1">[<html:link target="_blank"
                    action="/forum?method=showMain&id=${topNews.forum.id}&topicId=${topNews.id}">详细</html:link>]</span>
            </p>
            <c:if test="${not varStatus.last}">
                <div class="clearit"></div>
                <div class="line2"></div>
            </c:if>
        </c:forEach>
        <div class="blank8"></div>
    </div>
    <!--================论坛头条列表结束=================-->
    
    <!--================版面列表=================-->
    <div class="area_left_bottom forum_list">
        <h2 class="title_t"><span class="title">版面列表</span></h2>
        <div class="line2"></div>

        <%--显示分类列表--%>
        <c:forEach items="${request_categoryList}" var="category" varStatus="varStatus">
            <table style="width: 100%;" border="0" cellpadding="0" cellspacing="0">
                <thead>
                <tr>
                    <td class="col1">&nbsp;</td>
                    <td colspan="4" class="category_name">${category.name}</td>
                </tr>
                <tr>
                    <th class="col1">&nbsp;</th>
                    <th class="col2">版块</th>
                    <th class="col3">主题数</th>
                    <th class="col4">文章数</th>
                    <th class="col5">最后更新</th>
                </tr>
                </thead>
                <c:forEach items="${category.forums}" var="forum">
                    <tr>
                        <td class="col1">&nbsp;</td>
                        <td class="col2 forum_name">
                            <html:link action="/forum?method=showMain&id=${forum.id}">${forum.name}</html:link>
                        </td>
                        <td class="col3">${forum.topicCount}</td>
                        <td class="col4">${forum.articleCount}</td>
                        <td class="col5">
                            <fmt:formatDate value="${forum.lastArticlePostTime}" pattern="yyyy年MM月dd日 HH:mm"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <c:if test="${not varStatus.last}">
                <div class="clearit"></div>
                <div class="line2"></div>
            </c:if>
        </c:forEach>
        <!--最下面的一点空白-->
        <div class="blank12"></div>
    </div>
    <!--================版面列表结束=================-->
</div>

<!--================Blog链接列表=================-->
<div class="area_right">
    <div class="area_right_inner announce_list">
        <h2 class="title_r"><img src="${basePath}/style/images/icon_12.gif"/><span>Blog链接</span></h2>

        <div class="blank8"></div>
        <ul class="link_listp4">
            <%--显示Blog链接列表--%>
            <c:forEach items="${request_blogLinkList}" var="blogLink">
                <li><a href="${blogLink.url }" target="_blank">${blogLink.title }</a></li>
            </c:forEach>
            
        </ul>
        <div style="height: 8px;" class="blank8"></div>
    </div>
</div>
<!--================Blog链接列表结束=================-->
<!--================精华列表=================-->
<div class="area_right">
    <div class="area_right_inner essence_list">
        <h2 class="title_r"><img src="${basePath }/style/images/icon_12.gif"/><span>最新精华贴</span></h2>

        <div class="blank8"></div>
        <ul class="link_listp4">
             <%--显示精华列表--%>
            <c:forEach items="${request_essenceTopicList}" var="topic">
                <li><span><fmt:formatDate value="${topic.postTime}" pattern="yy-MM-dd"/></span><html:link
                        action="/forum?method=showMain&id=${topic.forum.id}&topicId=${topic.id}"
                        target="_blank"><c:out value="${topic.title}"/></html:link>
                </li>
            </c:forEach>
        </ul>
        <div style="height: 8px;" class="blank8"></div>
    </div>
</div>
<!--================精华列表结束=================-->
</div>

<!-- =====================底部=================== -->
<%@ include file="/WEB-INF/pages/public/footer.jspf"%>

</body>
</html>
