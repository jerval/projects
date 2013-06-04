<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>注册用户</title>
    <%@ include file="/WEB-INF/pages/public/commons.jspf" %>
    <link href="${basePath}/style/member_regUserUI.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
    	$(function(){
    		$("input[name=loginName]").attr("minlength", "2");
    		$("input[name=loginName]").attr("maxlength", "64");
    		$("input[name=nickname]").attr("minlength", "2");
    		$("input[name=nickname]").attr("maxlength", "64");
    		$("input[name=password]").attr("minlength", "2");
    		$("input[name=password]").attr("maxlength", "64");
    		$("input[name=password2]").attr("equalTo", "input[name=password]");
    	});
    </script>
</head>
<body>

<%--上面--%>
<div class="topt">
    <div style="padding-top: 28px;" class="sm">传智播客论坛</div>
    <div class="clearit"></div>
</div>

<%--显示表单--%>
<html:form action="/user?method=regUser" styleClass="validate" focus="loginName">
    <div style="border-bottom: 0pt none;" class="topt">
        <h2 style="padding: 20px 0pt 6px;" class="f14">请完善你的个人信息，加入ItcastBBS</h2>
        <div class="blank16"></div>
        
		<%--显示错误--%>
		<div class="errorMessages"><html:errors suffix="html.br"/></div>

        <table cellspacing="0" cellpadding="0" border="0" width="100%" class="table">
            <tbody>
            <tr>
                <td>登 录 名：</td>
                <td><html:text tabindex="1" styleClass="inputk required min max" property="loginName"/></td>
                <td id="passport2" colspan="2">
                    <div style="width: 450px; overflow: hidden; height: 30px;" class="infor"><span></span>2-64 个字符（包括大小写字母、中文、数字、特殊字符等），注册后不可修改。</div>
                </td>
            </tr>
            <tr>
                <td width="60">昵　　称：</td>
                <td width="197"><html:text tabindex="2" styleClass="inputk required min max" property="nickname"/></td>
                <td id="passport1" colspan="2">
                    <div style="width: 450px; overflow: hidden; height: 30px;" class="infor"><span></span>2-64 个字符（包括大小写字母、中文、数字、特殊字符等）。注册后不可修改。 </div>
                </td>
            </tr>
            <tr>
                <td>输入密码：</td>
                <td><html:password tabindex="3" redisplay="false" styleClass="inputk required min max" property="password"/></td>
                <td id="passport3" colspan="2"><div style="width: 95px;" class="infor"><span></span>2-64 个字符。</div></td>
            </tr>
            <tr>
                <td>重复密码：</td>
                <td><html:password tabindex="4" redisplay="false" styleClass="inputk required equalTo" property="password2"/></td>
                <td id="passport4" colspan="2">
                    <div style="width: 170px;" class="infor"><span></span>重复输入一次上面的密码。</div>
                </td>
            </tr>
            <tr>
                <td>电子邮件：</td>
                <td><html:text tabindex="5" styleClass="inputk required email" property="email" /></td>
                <td id="passport5" colspan="2">
                    <div style="width:190px;" class="infor"><span></span>请正确填写您的常用电子邮件</div>
                </td>
            </tr>
            <tr>
                <td>性    别：</td>
                <td>
                    <html:radio value="MALE" tabindex="7" property="gender"/> 男 
                    <html:radio value="FEMALE" property="gender"/> 女
                </td>
                <td colspan="2"> </td>
            </tr>
            <tr>
                <td> </td>
                <td>
                    <button class="buttonys" value="提交" id="button" name="button" type="submit">马上加入</button>
                </td>
                <td align="right" colspan="2"> </td>
            </tr>
            <tr>
                <td> </td>
                <td> </td>
                <td colspan="2"> </td>
            </tr>
            </tbody>
        </table>
    </div>
</html:form>


<!-- =====================底部=================== -->
<%@ include file="/WEB-INF/pages/public/footer.jspf"%>

</body>
</html>
