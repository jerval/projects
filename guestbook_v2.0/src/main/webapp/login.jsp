<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <center>
            <form action="${ctx}/deallogin.html" method="post" >
                <table>
                    <tr>
                        <td>用户名：</td><td><input type="text" name="username"></td>
                    </tr>
                    <tr>
                        <td>密码：</td><td><input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td></td><td><input type="submit" value="登录"></td>
                    </tr>

                </table>
            </form>
        </center>
    </body>
</html>
