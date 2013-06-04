<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
%>
<html>
  <head>
  <title>员工列表</title>
  <link href="<%=path %>/common/css/table.css" type="text/css" rel="stylesheet" />
  <script language="javascript" src="<%=path %>/common/js/calendar.js"></script>
	<script type="text/javascript" src="<%=path %>/common/js/jquery-1.4.2.js"></script>
	<script type="text/javascript">
	function deleteStaff(no)
	{	if(confirm("你确定要删除该数据吗？"))
		{
			location.assign("<%=path %>/system/manager/staff/deleteStaffAction?id="+no);
		}	
	}	
	function updateStaff(no)
	{	
		
			location.assign("<%=path %>/system/manager/staff/toUpdateStaffAction?staff.id="+no);
		
	}
	function submit()
	{
		var form=document.getElementById("queryForm");
		form.submit();
	}
		
</script>
  </head>
  
  <%
    request.setCharacterEncoding("UTF-8");
  
   %>

<body topmargin="10">
  <div class="font12"><table width="100%" background="<%=path %>/common/images/logobg.gif">
	  <tr> 
	    <td >您当前的位置：员工管理&nbsp;&gt;&gt;&nbsp;员工列表</td>
	    <td align="right" ><%@include file="/common/util/date.jsp" %></td>
	  </tr>
  </table></div>
  <br>
<table width="800"   border="0" align="left" cellspacing="0">
  <tr>
  <td>
  <form id="queryForm" name="queryForm" method="post" action="<%=path %>/system/manager/staff/listStaffAction">
	<input type="hidden" id="pageIndex" name="pageBean.pageIndex" value="<s:property value="pageBean.pageIndex"/>">
	<input type="hidden" id="pageCount" name="pageBean.pageCount" value="<s:property value="pageBean.pageCount"/>">
	<table width="800"   border="1" align="center" cellspacing="0">
	<tr>
			<td colspan="4">
			<table width="100%" border="0" cellspacing="0" >
			<tr>
				 <th width="55%" class="TH02">员工信息查询</th>
	   			 <th width="45%" class="TH02" colspan="4">
	   			 <img src="<%=path %>/common/images/icon07.gif" align="middle" border="0" onClick="return submit()">
	   			  <img src="<%=path %>/common/images/icon05.gif" align="middle" border="0" onClick="userId.value='';userChinaname.value='';sex.value='';major.value='';degree.value='';technicalClass.value='';graduationDate.value='';homeAdress.value='';" >
	   			 </th>
			</tr>
		</table>
	</td>	   
  </tr>
    <tr>
     <td width="150" class="TD02" >  <div align="left" class="txt">员工编号</div></td>	
      <td width="259"  class="TD01">
        <input type="text" name="staff.Id" id="Id" value="<s:property value="staff. Id" />">
       </td>
    <td width="55" class="TD02" >所学专业:</td>
    <td>
         <input type="text" name="staff.major" id="major" value="<s:property value="staff.major" />">   
    </td>
    </tr>
    <tr>  
      <td class="TD02" >学位:</td>
      <td><select name="staff.degree" id="degree" >
        <option value="">不限</option>
        <option <s:property value='%{"博士".equals(staff.degree)?"selected":""}' /> >博士</option>      
        <option <s:property value='%{"硕士研究生".equals(staff.degree)?"selected":""}' /> >硕士研究生</option>
        <option <s:property value='%{"本科生".equals(staff.degree)?"selected":""}' /> >本科生</option>
        <option <s:property value='%{"大专".equals(staff.degree)?"selected":""}' /> >大专</option>
        <option <s:property value='%{"高中".equals(staff.degree)?"selected":""}' /> >高中</option>
        <option <s:property value='%{"初中".equals(staff.degree)?"selected":""}' /> >初中</option>
         </select></td>
      <td class="TD02" >毕业时间:
      </td>
      <td>  <input type="text" name="staff.graduationDate" id="graduationDate" value="<s:property value="staff.graduationDateFormatYYYYMMDD" />">  
      </td>
      </tr>
      <tr>
      <td class="TD02" >技术等级:</td>
      <td><select name="staff.technicalClass" id="technicalClass">
        <option value="">不限</option>
        
        <option <s:property value='%{"高".equals(staff.technicalClass)?"selected":"" }' />  >高</option>
        
        <option <s:property value='%{"中".equals(staff.stechnicalClass)?"selected":"" }' /> >中</option>
        <option <s:property value='%{"低".equals(staff.technicalClass)?"selected":"" }' /> >低</option>
                  </select></td>
      <td class="TD02" >姓名：</td>
      <td><input type="text" name="staff.userChinaname" id="userChinaname" value="<s:property value="staff.userChinaname" />"/></td>
      </tr>
      <tr>
      <td width="72" class="TD02" >性别:</td>
      <td width="83"><select name="staff.sex" id="sex">
        <option value="">不限</option>
        
        <option <s:property value='%{"男".equals(staff.sex)?"selected":"" }' />  >男</option>
        
        <option <s:property value='%{"女".equals(staff.sex)?"selected":"" }' /> >女</option>
                  </select></td>
      <td class="TD02" >居住地址：</td>
      <td><input type="text" name="staff.homeAdress" id="homeAdress" value="<s:property value="staff.homeAdress" />"/></td>
    </tr>
  </table>
</form>
<br>
<table width="800"   border="1" align="center" cellspacing="0">
<tr >
  	<td colspan="14">
		<table width="100%" border="0" cellspacing="0" >
			<tr>
	    		<th width="55%" align="middle" class="TH02">员工一览</th>
				<th width="45%" align="right" class="TH02"><a href="<%=path %>/system/manager/staff/addStaffAction"><img src="<%=path %>/common/images/icon01.gif" align="middle" border="0"></a></th>
			</tr>
		</table>
	</td>
 </tr>
 
  <tr  class="TD02">
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
    <td class="TD03">操作</td>
  </tr>
  <s:iterator id="staff" value="pagination.list">
	 <tr>
	    <td>&nbsp;<s:property value="#staff.Id"/></td>
	    <td>&nbsp;<s:property value="#staff.userChinaname"/></td>
	    <td>&nbsp;<s:property value="#staff.birthdayFormatYYYYMMDD()"/></td>
	    <td>&nbsp;<s:property value="#staff.sex"/></td>
	    <td>&nbsp;<s:property value="#staff.comeDateFormatYYYYMMDD"/></td>
	    <td>&nbsp;<s:property value="#staff.homepostCode"/></td>
	    <td>&nbsp;<s:property value="#staff.mobile"/></td>
	    <td>&nbsp;<s:property value="#staff.email2"/></td>
	    <td>&nbsp;<s:property value="#staff.homeAdress"/></td>
	    <td>&nbsp;<s:property value="#staff.school"/></td>
	    <td>&nbsp;<s:property value="#staff.major"/></td>
	    <td>&nbsp;<s:property value="#staff.graduationDateFormatYYYYMMDD"/></td> 
	    <td>&nbsp;<s:property value="#staff.degree"/></td>
	    <td><a href="<%=path %>/system/manager/staff/detailStaffAction?staff.id=<s:property value="#staff.id"/>">详细</a>
	    <img src="<%=path %>/common/images/btn_edit.gif" alt='编辑' onClick="updateStaff(<s:property value="#staff.id"/>)"> 
		<img src="<%=path %>/common/images/btn_del.gif" alt='删除' onClick="deleteStaff(<s:property value="#staff.id"/>)"></td>
	  </tr>
    </s:iterator>
  </table>
<br/>
<%@ include file="/common/util/pageBean.jsp" %>

</body>
</html>

