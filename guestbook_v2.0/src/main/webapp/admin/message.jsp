
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>查看留言</title>
    </head>
    <body>
    <link href="${ctx}/css/screen.css"  rel="stylesheet" type="text/css" />
    <style type="text/css" >
        *{font-size: 13px}
    </style>
    <center>${sessionScope.username}你好！<a href="${ctx}/admin/logout.html">退出登录</a></center>
    <br/>
    <center>
        <form action="${ctx}/admin/msgdelete.html" method="post" >
            <display:table export="true" size="${pageDao.maxElements}" partialList="true" name="${pageDao.list}" class="its"  id="msg"
                           pagesize="${pageDao.pageSize}" requestURI="${applicationScope.ctx}/admin/index.html">
                <display:column>
                    <input type="checkbox" name="id" value="${msg.id}" />
                </display:column>
                <display:column property="id" sortable="true" title="编号"/>
                <display:column property="regtime" title="留言时间"/>
                <display:column property="content" title="内容" maxLength="30"/>
                <display:column title="操作">
                <a href="${ctx}/admin/msgdetail.html?id=${msg.id}">详细</a>
            </display:column>
                <display:footer >
                    <input type="submit" value="删除" />
                </display:footer>
            </display:table>
        </form>
    </center>
</body>
</html>
