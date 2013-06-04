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
    
    <title>My JSP 'updateStaff.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="<%=path %>/common/css/table.css" type="text/css" rel="stylesheet" />
<link href="<%=path %>/common/css/pm.css" type="text/css" rel="stylesheet" />
<script language="javascript" src="<%=path %>/common/js/calendar.js"></script>
<script type="text/javascript" src="/train/common/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="/train/common/js/util/checkForm.js"></script>
<script type="text/javascript">
   		$(function(){
   			initTextCheck("userChinaname",{def:"请输入信息……",foc:"员工名必须为中文",suc:"输入合法",err:"输入不合法"},text_name);
   			initTextCheck("password",{def:"密码默认2010",foc:"默认2010，长度3-12位",suc:"输入合法",err:"输入不合法"},text_password);
   		});
   		
   </script>
</head>
  
  <body>
  <form name="form1" method="post" action="<%=path %>/system/manager/staff/updateStaff.action">
  <input type="hidden"  name="staff.userId" value="<s:property value="staff.userId"/>">
  <input type="hidden"  name="staff.toEmployee" value="<s:property value="staff.toEmployee"/>">
  <input type="hidden"  name="staff.password" value="<s:property value="staff.password"/>">
  <input type="hidden"  name="staff.insertDate" value="<s:property value="staff.insertDate"/>">
  <input type="hidden"  name="staff.updateDate" value="<s:property value="staff.updateDate"/>">
  
<table width="100%" border="1">
  <tr>
    <td class="TD02">员工姓名：</td>
    <td><input type="text" name="staff.userChinaname" id="userChinaname" value="<s:property value="staff.userChinaname"/>"/></td>
    <td><label id="userChinanameTip" class="show"></label></td>
    <td class="TD02">出生年月：</td>
    <td><input type="text" name="staff.birthday" id="dateInput1" value="<s:property value="staff.birthdayFormatYYYYMMDD" />" readonly="readonly"/></td>
    <td><input name="image2" type="image" title="显示日历" onClick="fPopCalendar(dateInput1,dateInput1);return false" src="<%=path %>/common/images/calendar.gif" width="18" height="17" /></td>
  </tr>
  <tr>
    <td class="TD02">性别:</td>
    <td><select name="staff.sex" id="select">
        <option value="">未知</option>       
        <option <s:property value='%{"男".equals(staff.sex)?"selected":"" }' />  >男</option>  
        <option <s:property value='%{"女".equals(staff.sex)?"selected":"" }' /> >女</option>
    </select>    </td>
    <td>&nbsp;</td>
    <td class="TD02">入职日期:</td>
    <td><input type="text" name="staff.ComeDate" id="dateInput2" value="<s:property value="staff.ComeDateFormatYYYYMMDD" />" readonly="readonly"/></td>
    <td><input name="image" type="image" title="显示日历" onClick="fPopCalendar(dateInput2,dateInput2);return false" src="<%=path %>/common/images/calendar.gif" width="18" height="17" /></td>
  </tr>
  <tr>
    <td class="TD02">邮箱:</td>
    <td><input type="text" name="staff.email2" id="staffName" value="<s:property value="staff.email2" />"/></td>
    <td>&nbsp;</td>
    <td class="TD02">移动电话:</td>
    <td><input type="text" name="staff.mobile" id="staffName" value="<s:property value="staff.mobile" />"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td class="TD02">居住地址:</td>
    <td><input type="text" name="staff.address" id="staffName" value="<s:property value="staff.address" />"/></td>
    <td>&nbsp;</td>
    <td class="TD02">居住地邮政编码:</td>
    <td><input type="text" name="staff.postCode" id="staffName" value="<s:property value="staff.postCode" />"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td class="TD02">居住地电话:</td>
    <td><input type="text" name="staff.phone" id="staffName" value="<s:property value="staff.phone" />"/></td>
    <td>&nbsp;</td>
    <td class="TD02">家庭地址:</td>
    <td><input type="text" name="staff.homeAdress" id="staffName2" value="<s:property value="staff.homeAdress" />"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td class="TD02">家庭邮政编码:</td>
    <td><input type="text" name="staff.homepostCode" id="staffName3" value="<s:property value="staff.homepostCode" />"/></td>
    <td>&nbsp;</td>
    <td class="TD02">家庭电话:</td>
    <td><input type="text" name="staff.homePhone" id="staffName4"  value="<s:property value="staff.homePhone" />"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td class="TD02">毕业学校</td>
    <td><input type="text" name="staff.school" id="staffName5" value="<s:property value="staff.school" />"/></td>
    <td>&nbsp;</td>
    <td class="TD02">所学专业</td>
    <td><input type="text" name="staff.major" id="staffName6" value="<s:property value="staff.major" />"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td class="TD02">毕业时间</td>
    <td><input type="text" name="staff.graduationDate" id="dateInput3" value="<s:property value="staff.graduationDateFormatYYYYMMDD" />" readonly="readonly"/></td>
    <td><input name="image" type="image" title="显示日历" onClick="fPopCalendar(dateInput3,dateInput3);return false" src="<%=path %>/common/images/calendar.gif" width="18" height="17" /></td>
    <td class="TD02">学位</td>
    <td><select name="staff.degree" id="select2">
        <option value="">未知</option>
        <option <s:property value='%{"博士".equals(staff.degree)?"selected":""}' /> >博士</option>      
        <option <s:property value='%{"硕士研究生".equals(staff.degree)?"selected":""}' /> >硕士研究生</option>
        <option <s:property value='%{"本科生".equals(staff.degree)?"selected":""}' /> >本科生</option>
        <option <s:property value='%{"大专".equals(staff.degree)?"selected":""}' /> >大专</option>
        <option <s:property value='%{"高中".equals(staff.degree)?"selected":""}' /> >高中</option>
        <option <s:property value='%{"初中".equals(staff.degree)?"selected":""}' /> >初中</option>
    </select>    </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td class="TD02">身份证号码</td>
    <td><input type="text" name="staff.identitycardID" id="staffName7" value="<s:property value="staff.identitycardID" />"/></td>
    <td>&nbsp;</td>
    <td class="TD02">员工档案编号</td>
    <td><input type="text" name="staff.stafffileID" id="staffName8" value="<s:property value="staff.stafffileID" />"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td class="TD02">员工档案存放地址</td>
    <td><input type="text" name="staff.stafffilePath" id="staffName10" value="<s:property value="staff.stafffilePath" />"/></td>
    <td>&nbsp;</td>
    <td class="TD02">户口所在地</td>
    <td><input type="text" name="staff.householdAdress" id="staffName9" value="<s:property value="staff.householdAdress" />"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td class="TD02">婚姻状况</td>
    <td><select name="staff.marrystatus" id="select3">
        <option value="">未知</option>       
        <option <s:property value='%{"已婚".equals(staff.marrystatus)?"selected":"" }' />  >已婚</option>  
        <option <s:property value='%{"未婚".equals(staff.marrystatus)?"selected":"" }' /> >未婚</option>
    </select>    </td>
    <td>&nbsp;</td>
    <td class="TD02">技术等级</td>
    <td><select name="staff.technicalClass" id="select4">
        <option value="">未知</option>       
        <option <s:property value='%{"中".equals(staff.technicalClass)?"selected":"" }' /> >中</option>       
        <option <s:property value='%{"高".equals(staff.technicalClass)?"selected":"" }' /> >高</option>
        <option <s:property value='%{"低".equals(staff.technicalClass)?"selected":"" }' /> >低</option>
    </select></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td class="TD02">政治面貌</td>
    <td><select name="staff.politics" id="select5">
        <option value="">未知</option>       
        <option <s:property value='%{"党员".equals(staff.politics)?"selected":"" }' /> >党员</option>       
        <option <s:property value='%{"团员".equals(staff.politics)?"selected":"" }' /> >团员</option>
        <option <s:property value='%{"群众".equals(staff.politics)?"selected":"" }' /> >群众</option>
        <option <s:property value='%{"无党人士".equals(staff.politics)?"selected":"" }' /> >无党人士</option>
        </select></td>
    <td>&nbsp;</td>
    <td class="TD02">提出离职日期</td>
    <td><input type="text" name="staff.leaveDate" id="dateInput4" value="<s:property value="staff.leaveDateFormatYYYYMMDD" />" readonly="readonly" /></td>
    <td><input name="image" type="image" title="显示日历" onClick="fPopCalendar(dateInput4,dateInput4);return false" src="<%=path %>/common/images/calendar.gif" width="18" height="17" /></td>
  </tr>
  <tr>
    <td class="TD02">离职原因</td>
    <td><input type="text" name="staff.leaveReason"  value="<s:property value="staff.leaveReason"/>"/></td>
    <td>&nbsp;</td>

  </tr>
  <tr>
    <td class="TD02">用户类别</td>
    <td><select name="staff.userType" id="select6">
        <option value="">未知</option>       
        <option <s:property value='%{"管理员".equals(staff.userType)?"selected":"" }' /> >管理员</option>       
        <option <s:property value='%{"教师".equals(staff.userType)?"selected":"" }' /> >教师</option>
        <option <s:property value='%{"员工".equals(staff.userType)?"selected":"" }' /> >员工</option>
        <option <s:property value='%{"超级管理员".equals(staff.userType)?"selected":"" }' /> >超级管理员</option>
        </select></td>
    <td>&nbsp;</td>
    <td class="TD02">登录者</td>
    <td><input type="text" name="staff.insertUser" id="staffName12" value="<s:property value="staff.insertUser" />"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td class="TD02">更新者</td>
    <td><input type="text" name="staff.updateUser" id="staffName13" value="<s:property value="staff.updateUser" />"/></td>
    <td>&nbsp;</td>
    <td class="TD02">删除标记</td>
    <td><select name="staff.deleteFlag" id="select7">
        <option value="">未知</option>       
        <option <s:property value='%{"已删除".equals(staff.deleteFlag)?"selected":"" }' />  >已删除</option>  
        <option <s:property value='%{"未删除".equals(staff.deleteFlag)?"selected":"" }' /> >未删除</option>
        </select></td>
    <td>&nbsp;</td>
  </tr>
   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table0">
      <tr> 
        <td> <div align="center"> 
          <input name="button5" type="submit" class=btn_mouseout onMouseDown="this.className='btn_mousedown'" onMouseUp="this.className='btn_mouseup'" onMouseOver="this.className='btn_mouseover'" onMouseOut="this.className='btn_mouseout'" value=" 保  存 " >           　 
          <input name="button32" type="button" class=btn_mouseout onMouseDown="this.className='btn_mousedown'" onMouseUp="this.className='btn_mouseup'" onMouseOver="this.className='btn_mouseover'" onMouseOut="this.className='btn_mouseout'" onClick="" value="取消 " >
            　 </div></td>
      </tr>
    </table>
</table>

  </form>
</body>
</html>
