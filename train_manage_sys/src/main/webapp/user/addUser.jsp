<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>添加用户</title>
   <script type="text/javascript" src="<%=path %>/common/js/jquery-1.4.2.js"></script>
   <script type="text/javascript" src="<%=path %>/common/js/util/checkForm.js"></script>
   <link href="<%=path %>/common/css/formCheck.css" type="text/css" rel="stylesheet"/>
   <link href="<%=path %>/common/css/css.css" type="text/css" rel="stylesheet"/>
   <script type="text/javascript">
   		$(function(){
   			initTextCheck("user_loginName",{def:"请输入信息……",foc:"用户名只能由字母和数字组成",suc:"输入合法",err:"输入不合法"},text_password);
   			initTextCheck("user_loginPassword",{def:"密码默认2010",foc:"默认2010，长度3-12位",suc:"输入合法",err:"输入不合法"},text_password);
   		});
   		
   </script>
  </head>
  <body topmargin="10">
  <div class="font12"><table width="100%" background="<%=path %>/common/images/logobg.gif">
	  <tr> 
	    <td >您当前的位置：用户管理&nbsp;&gt;&gt;&nbsp;添加用户</td>
	    <td align="right" ><%@include file="/common/util/date.jsp" %></td>
	  </tr>
  </table></div>
  <center><h3>添加用户</h3></center>
  <form id="MyForm" name="MyForm" method="post" action="<%=path %>/user/addUser.action">
  <s:token></s:token>
  <table width="60%" border="0" align="center" bgcolor="#0066FF"  cellpadding="5">
    <tr>
      <td width="20%" align="right" bgcolor="#C7ECFC">用&nbsp;&nbsp;户&nbsp;&nbsp;名：</td>
      <td width="30%" bgcolor="#C7ECFC"><label>
        <input type="text" name="examUser.userLoginName" id="user_loginName" value='<s:property value="examUser.userLoginName" />' size="18" />
      </label></td>
      <td width="50%" bgcolor="#C7ECFC" valign="middle" align="left">&nbsp;<label id="user_loginNameTip" class="show"></label></td>
    </tr>
    <tr>
      <td width="20%" align="right" bgcolor="#C7ECFC">登录密码：</td>
      <td width="30%" bgcolor="#C7ECFC"><label>
        <input type="password" name="examUser.userLoginPassword" id="user_loginPassword" value="" size="20" maxlength="12" />
      </label></td>
      <td width="50%" bgcolor="#C7ECFC" valign="middle" align="left">&nbsp;<label id="user_loginPasswordTip" class="show"></label></td>
    </tr>
    <tr>
      <td width="20%" align="right" bgcolor="#C7ECFC">权&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;限：</td>
      <td width="30%" bgcolor="#C7ECFC" colspan="2"><label>
        <select id="user_level" name="examUser.userLevel">
			<option value="0">部门主管&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
			<option value="1" <s:property value='%{(examUser.userLevel!=null && "1".equals(examUser.userLevel))?"selected":"" }' /> >超级管理员&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
	   </select>
      </label></td>
    </tr>
    <tr>
      <td colspan="3" align="center" bgcolor="#C7ECFC"><label>
        <input type="submit" name="button" value=" 提 交 " />&nbsp;&nbsp;&nbsp;&nbsp;  
      	<input type="button" name="button2" value=" 返 回 " onClick="history.back();" />
  </label></td>
    </tr>
  </table>
  </form>
  </body>
</html>
