<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>添加员工</title>
<link href="<%=path %>/common/css/table.css" type="text/css" rel="stylesheet" />
<link href="<%=path %>/common/css/pm.css" type="text/css" rel="stylesheet" />
<script language="javascript" src="<%=path %>/common/js/calendar.js"></script>
<script language="javascript" src="<%=path %>/common/js/validation-framework.js"></script>
<script type="text/javascript">
     function back()
     {
         location.assign("<%=path%>/system/manager/staff/listStaffAction");
     }
</script>
</head>
<body topmargin="10">
  <div class="font12"><table width="100%" background="<%=path %>/common/images/logobg.gif">
	  <tr> 
	    <td >您当前的位置：员工管理&nbsp;&gt;&gt;&nbsp;添加员工</td>
	    <td align="right" ><%@include file="/common/util/date.jsp" %></td>
	  </tr>
  </table></div>
  <br>
  <div id="errorDiv" style="color:red;font-weight:bold"></div>
  <table width="100%">
  <tr>
  <td  align="right"><img  src="<%=path %>/common/images/icon06.gif" align="right" onClick="return back()"></td>
  </tr>
</table>
<form id="addStaffForm" method="post" action="<%=path %>/system/manager/staff/addSaveAction" onSubmit="return doValidate(this)">
 <s:token></s:token>
 <table width="100%" border="1">
  <tr>
    <td class="TD02">员工姓名：</td>
    <td><input type="text" name="staff.userChinaname" value="<s:property value="staff.userChinaname"/>"/></td>
    <td class="TD02">出生年月：</td>
    <td><input type="text" name="staff.birthday" id="dateInput1" value="<s:property value="staff.birthdayFormatYYYYMMDD" />" readonly="readonly"/><input name="image2" type="image" title="显示日历" onClick="fPopCalendar(dateInput1,dateInput1);return false" src="<%=path %>/common/images/calendar.gif" width="18" height="17" /></td>
  </tr>
  <tr>
    <td class="TD02">性别:</td>
    <td><select name="staff.sex" id="select">     
        <option <s:property value='%{"男".equals(staff.sex)?"selected":"" }' />  value="男" >男</option>  
        <option <s:property value='%{"女".equals(staff.sex)?"selected":"" }' /> value="女" >女</option>
    </select>    </td>
    <td class="TD02">入职日期:</td>
    <td><input type="text" name="staff.ComeDate" id="dateInput2" value="<s:property value="staff.ComeDateFormatYYYYMMDD" />" readonly="readonly"/><input name="image" type="image" title="显示日历" onClick="fPopCalendar(dateInput1,dateInput2);return false" src="<%=path %>/common/images/calendar.gif" width="18" height="17" /></td>
  </tr>
  <tr>
    <td class="TD02">邮箱:</td>
    <td><input type="text" name="staff.email2" id="email2" value="<s:property value="staff.email2" />"/></td>
    <td class="TD02">移动电话:</td>
    <td><input type="text" name="staff.mobile" id="mobile" value="<s:property value="staff.mobile" />"/></td>
  </tr>
  <tr>
    <td class="TD02">居住地址:</td>
    <td><input type="text" name="staff.address" id="staffName" value="<s:property value="staff.address" />"/></td>
    <td class="TD02">居住地邮政编码:</td>
    <td><input type="text" name="staff.postCode" id="staffName" value="<s:property value="staff.postCode" />"/></td>
  </tr>
  <tr>
    <td class="TD02">居住地电话:</td>
    <td><input type="text" name="staff.Phone" id="staffName" value="<s:property value="staff.Phone" />"/></td>
    <td class="TD02">家庭地址:</td>
    <td><input type="text" name="staff.homeAdress" id="staffName2" value="<s:property value="staff.homeAdress" />"/></td>
  </tr>
  <tr>
    <td class="TD02">家庭邮政编码:</td>
    <td><input type="text" name="staff.homepostCode" id="staffName3" value="<s:property value="staff.homepostCode" />"/></td>
    <td class="TD02">家庭电话:</td>
    <td><input type="text" name="staff.homePhone" id="staffName4"  value="<s:property value="staff.homePhone" />"/></td>
  </tr>
  <tr>
    <td class="TD02">毕业学校</td>
    <td><input type="text" name="staff.school" id="staffName5" value="<s:property value="staff.school" />"/></td>
    <td class="TD02">所学专业</td>
    <td><input type="text" name="staff.major" id="staffName6" value="<s:property value="staff.major" />"/></td>
  </tr>
  <tr>
      <td class="TD02">学位</td>
    <td><select name="staff.degree" id="select2">
        <option <s:property value='%{"博士".equals(staff.degree)?"selected":""}' /> value="博士">博士</option>      
        <option <s:property value='%{"硕士研究生".equals(staff.degree)?"selected":""}'/> value="硕士研究生" >硕士研究生</option>
        <option <s:property value='%{"本科生".equals(staff.degree)?"selected":""}' /> value="本科生" >本科生</option>
        <option <s:property value='%{"大专".equals(staff.degree)?"selected":""}' /> value="大专" >大专</option>
        <option <s:property value='%{"高中".equals(staff.degree)?"selected":""}' /> value="高中" >高中</option>
        <option <s:property value='%{"初中".equals(staff.degree)?"selected":""}' /> value="初中" >初中</option>
    </select>    </td>
    <td class="TD02">毕业时间</td>
    <td><input type="text" name="staff.graduationDate" id="dateInput3" value="<s:property value="staff.graduationDateFormatYYYYMMDD" />" readonly="readonly"/><input name="image" type="image" title="显示日历" onClick="fPopCalendar(dateInput3,dateInput3);return false" src="<%=path %>/common/images/calendar.gif" width="18" height="17" /></td>

  </tr>
  <tr>
    <td class="TD02">身份证号码</td>
    <td><input type="text" name="staff.identitycardID" id="staff.staffCardId" value="<s:property value="staff.identitycardID" />"/></td>
    <td class="TD02">员工档案编号</td>
    <td><input type="text" name="staff.stafffileID" id="staffName8" value="<s:property value="staff.stafffileID" />"/></td>
  </tr>
  <tr>
    <td class="TD02">员工档案存放地址</td>
    <td><input type="text" name="staff.stafffilePath" id="staffName10" value="<s:property value="staff.stafffilePath" />"/></td>
    <td class="TD02">户口所在地</td>
    <td><input type="text" name="staff.householdAdress" id="staffName9" value="<s:property value="staff.householdAdress" />"/></td>
  </tr>
  <tr>
    <td class="TD02">婚姻状况</td>
    <td><select name="staff.marrystatus" id="select3">    
        <option <s:property value='%{"否".equals(staff.marrystatus)?"selected":"" }' />  value="否" >未婚</option>  
        <option <s:property value='%{"是".equals(staff.marrystatus)?"selected":"" }' /> value="是" >已婚</option>
    </select>    </td>
    <td class="TD02">技术等级</td>
    <td><select name="staff.technicalClass" id="select4">       
        <option <s:property value='%{"中".equals(staff.technicalClass)?"selected":"" }' />  value="中">中</option>       
        <option <s:property value='%{"高".equals(staff.technicalClass)?"selected":"" }' />  value="高">高</option>
        <option <s:property value='%{"低".equals(staff.technicalClass)?"selected":"" }' /> value="低" >低</option>
    </select></td>
  </tr>
  <tr>
    <td class="TD02">政治面貌</td>
    <td><select name="staff.politics" id="select5">       
        <option <s:property value='%{"党员".equals(staff.politics)?"selected":"" }' /> value="党员" >党员</option>       
        <option <s:property value='%{"团员".equals(staff.politics)?"selected":"" }' /> value="团员" >团员</option>
        <option <s:property value='%{"群众".equals(staff.politics)?"selected":"" }' />  value="群众">群众</option>
        <option <s:property value='%{"无党人士".equals(staff.politics)?"selected":"" }' /> value="无党人士" >无党人士</option>
        </select></td>
    <td class="TD02">提出离职日期</td>
    <td><input type="text" name="staff. leaveDate" id="dateInput4" value="<s:property value="staff. leaveDateFormatYYYYMMDD" />" readonly="readonly" /><input name="image" type="image" title="显示日历" onClick="fPopCalendar(dateInput4,dateInput4);return false" src="<%=path %>/common/images/calendar.gif" width="18" height="17" /></td>
  </tr>
  <tr>
    <td class="TD02">离职原因</td>
    <td><input type="text" name="staff.leaveReason"  value="<s:property value="staff.leaveReason"/>"/></td>
    
  </tr>
  <tr>
    <td class="TD02">用户类别</td>
    <td><select name="staff.userType" id="select6">      
        <option <s:property value='%{"管理员".equals(staff.userType)?"selected":"" }' />  value="管理员">管理员</option>       
        <option <s:property value='%{"教师".equals(staff.userType)?"selected":"" }' />  value="教师">教师</option>
        <option <s:property value='%{"员工".equals(staff.userType)?"selected":"" }' />  value="员工">员工</option>
        <option <s:property value='%{"超级管理员".equals(staff.userType)?"selected":"" }' />  value="超级管理员">超级管理员</option>
        </select></td>
    <td class="TD02">登录者</td>
    <td><input type="text" name="staff.insertUser" id="staffName12" value="<s:property value="staff.insertUser" />"/></td>
  </tr>
  <tr>
    <td class="TD02">更新者</td>
    <td><input type="text" name="staff.updateUser" id="staffName13" value="<s:property value="staff.updateUser" />"/></td>
    <td class="TD02">删除标记</td>
    <td><select name="staff.deleteFlag" id="select7">      
        <option <s:property value='%{"否".equals(staff.deleteFlag)?"selected":"" }' /> value="否">未删除</option>  
        <option <s:property value='%{"是".equals(staff.deleteFlag)?"selected":"" }' /> value="是">已删除</option>
        </select></td>
  </tr>  
   <tr>
    
    <td class="TD02">员工密码：</td>
    <td><input type="password" name="staff.password" id="password"></td>
  </tr>
   <tr>
   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table0">
      <tr> 
        <td> <div align="center"> 
          <input type="submit" value="保 存" >           　 
          <input name="button32" type="button" class=btn_mouseout onMouseDown="this.className='btn_mousedown'" onMouseUp="this.className='btn_mouseup'" onMouseOver="this.className='btn_mouseover'" onMouseOut="this.className='btn_mouseout'" onClick="" value="取消 " >
            　 </div></td>
      </tr>
    </table>
  </tr>
   
</table>

</form>
</body>
</html>
