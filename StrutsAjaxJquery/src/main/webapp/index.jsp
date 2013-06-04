<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
        <script type="text/javascript" src="js/myjs4text.js"></script>
        <script type="text/javascript" src="js/myjs4jsp.js"></script>
        <script type="text/javascript" src="js/partofjsp.js"></script>
        <script type="text/javascript" src="js/myjs4json.js"></script>
        <script type="text/javascript" src="js/myjs4html.js"></script>
        <script type="text/javascript" src="js/open.js"></script>
    </head>
    <body>
        <div id="areaId"></div>
        <form id="textForm" action="">
            <input id="username" type="text" name="username" />
            <input id="password" name="password" type="password">
            <a href="#" onclick="textTest()">测试传输文本</a>
            <br />
            <div id="textresult"></div>
        </form>

        <a href="#" onclick="html()">测试传输html网页</a>
        <br />
        <div id="htmlresult"></div>

        <a href="#" onclick="jsp1()">测试传输jsp网页</a>
        <br />
        <div id="jspresult"></div>

        <a href="#" onclick="jsp2()">测试传输部分jsp网页</a>
        <br />
        <div id="jsppartresult"></div>
        <form id="jsonForm" action="">
            <input id="username" type="text" name="username" />
            <input id="password" name="password" type="password">
            <a href="#" onclick="json()">测试传输json数据</a>
            <br />
            <div id="jsonresult"></div>
        </form><br/>
        <a href="textResult!json">测试传输json</a>
        <a onclick="openWin()">open</a>

    </body>
</html>
