<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>TOP</title>
    <%@ include file="/WEB-INF/pages/public/commons.jspf" %>
    <link href="${basePath}/style/forum_top.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<table style="height: 51px;" width="100%" cellspacing="0" cellpadding="0" class="main">
    <tr class="row1">
        <td>
            <div class="logo"><span>传智播客论坛</span></div>
            <div style=" float:left;">
                <%--未登录用户，显示登录表单--%>
                <c:if test="${SESSION_LOGGED_ON_USER eq null}">
                    <html:form action="/user?method=login" styleClass="login_form" focus="loginName">
                    	<html:hidden property="PARAMETER_RETURN_PATH" value="${request_returnPath}"/>
                    	<html:hidden property="src" value="forum_show_top"/>
                       	用户名：
                        <html:text property="loginName" styleClass="input"/>
                       	密码：
                        <html:password property="password" styleClass="input"/>
                        <input type="checkbox" name="autoLogin"/>
                       	自动登录
                        <html:image src="${basePath}/style/images/loginnew.gif" styleClass="img"/>
                    </html:form>
                </c:if>
                <%--登录用户，显示用户信息--%>
                <c:if test="${SESSION_LOGGED_ON_USER ne null}">
	                  用户名：${SESSION_LOGGED_ON_USER.loginName}
	                  昵称：${SESSION_LOGGED_ON_USER.nickname}
	               <%--退出--%>
	               <html:link action="/user?method=logout">
	               		<img style="img_reg : img" src="${basePath}/style/images/icon_18.gif"/></html:link>
                </c:if>
            </div>
            <div style="width: 80px; float:left"><html:link target="_blank"
            	action="/portal?method=index" styleClass="returnHome">返回首页</html:link>
            </div>
        </td>
    </tr>
    <tr class="row2">
        <td>
            <div id="bbsnav">
                <ul>
                	<c:if test="${SESSION_LOGGED_ON_USER eq null}">
	                    <li><html:link action="/user?method=regUserUI" target="_blank">注册</html:link></li>
	                    <li class="line"/>
	                    <li><html:link action="/user?method=loginUI" target="_blank">登录</html:link></li>
                    </c:if>
                    <c:if test="${SESSION_LOGGED_ON_USER ne null}">
                    	<li><html:link action="/user?method=logout">注销[${SESSION_LOGGED_ON_USER.loginName}]</html:link></li>
                    </c:if>
                    <li class="line"/>
					<li><html:link action="/portal?method=index" target="_parent">返回首页</html:link></li>
                    <li class="line"/>
        			<li><html:link action="/topicSearch?method=searchTopicUI" target="_blank">站内主题搜索</html:link></li>
                    <bbs:permission resource="System" action="Manage" >
                    	<li class="line"/>
			        	<li><html:link action="/manage/portal?method=index" target="_blank">系统管理</html:link></li>
			        </bbs:permission>
                </ul>
            </div>
        </td>
    </tr>
</table>
</body>
</html>
