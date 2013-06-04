<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>查看版面</title>
    <%@ include file="/WEB-INF/pages/public/commons.jspf" %>
</head>
<frameset rows="51px,*" framespacing="0" id="fs1">
    <frame name="top" src="${basePath}/forum.do?method=showTop" frameborder="0" noresize="noresize" scrolling="no"/>
    <frameset cols="485px,*" id="fs2">
        <frame name="left" src="${basePath}/forum.do?method=showLeft&id=${param.id }" scrolling="yes"/>
        <frame name="right" src="${basePath}/forum.do?method=showRight&topicId=${param.topicId }"/>
    </frameset>
</frameset>
<noframes></noframes>
</html>
