<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detailStaff.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<LINK href="<%=path %>/common/css/table.css" type=text/css rel=stylesheet />
  </head>
  
  <body>
   <table width="800"   border="1" align="center" cellspacing="0">
  <tr class="TD02">
    <td class="TD03">编号</td>
    <td class="TD03">姓名</td>
    <td class="TD03">出生年月</td>
    <td class="TD03">性别</td>
    <td class="TD03">入职日期</td>
    <td class="TD03">居住地邮政编码</td>
    <td class="TD03">移动电话</td>
    <td class="TD03">邮箱</td>
    <td class="TD03">居住地址</td>
    <td class="TD03">毕业学校</td>
    <td class="TD03">所学专业</td>
    <td class="TD03">毕业时间</td>
    <td class="TD03">学位</td>
  </tr>
  <tr>
    <td><s:property value="staff.userId"/></td>
    <td><s:property value="staff.userChinaname"/></td>
    <td><s:property value="staff.birthdayFormatYYYYMMDD"/></td>
    <td><s:property value="staff.sex"/></td>
    <td><s:property value="staff.ComeDateFormatYYYYMMDD"/></td>
    <td><s:property value="staff.postCode"/></td>
    <td><s:property value="staff.mobile"/></td>
    <td><s:property value="staff.email2"/></td>
    <td><s:property value="staff.address"/></td>
    <td><s:property value="staff.school"/></td>
    <td><s:property value="staff.major"/></td>
    <td><s:property value="staff.graduationDateFormatYYYYMMDD"/></td> 
    <td><s:property value="staff.degree"/></td>
  </tr>
</table>
<table width="800"   border="1" align="center" cellspacing="0">
  <tr class="TD02">
    <td class="TD03">家庭地址</td>
    <td class="TD03">家庭邮政编码</td>
    <td class="TD03">家庭电话</td>
    <td class="TD03">身份证号码</td>
    <td class="TD03">员工档案编号</td>
    <td class="TD03">员工档案存放地址</td>
    <td class="TD03">户口所在地</td>
    <td class="TD03">婚姻状况</td>
    <td class="TD03">技术等级</td>
    <td class="TD03">政治面貌</td>
    <td class="TD03">提出离职日期</td>
    <td class="TD03">离职原因</td>
    <td class="TD03">用户类别</td>
    <td class="TD03">登录者</td>
    <td class="TD03">登录日期</td>
    <td class="TD03">更新者</td>
    <td class="TD03">更新日期</td>
    <td class="TD03">删除标记</td>
  </tr>
  <tr>
    <td><s:property value="staff.homeAdress"/></td>
    <td><s:property value="staff.homepostCode"/></td>
    <td><s:property value="staff.homePhone"/></td>
    <td><s:property value="staff.identitycardID"/></td>
    <td><s:property value="staff.stafffileID"/></td>
    <td><s:property value="staff.stafffilePath"/></td>
    <td><s:property value="staff.householdAdress"/></td>
    <td><s:property value="staff.marrystatus"/></td>
    <td><s:property value="staff.technicalClass"/></td>
    <td><s:property value="staff.politics"/></td>
    <td><s:property value="staff.leaveDateFormatYYYYMMDD"/></td>
    <td><s:property value="staff.leaveReason"/></td> 
    <td><s:property value="staff.userType"/></td>
    <td><s:property value="staff.insertUser"/></td>
    <td><s:property value="staff.insertDateFormatYYYYMMDD"/></td>
    <td><s:property value="staff.updateUser"/></td>
    <td><s:property value="staff.updateDateFormatYYYYMMDD"/></td>
    <td><s:property value="staff.deleteFlag"/></td>
  </tr>
</table>
  </body>
</html>
