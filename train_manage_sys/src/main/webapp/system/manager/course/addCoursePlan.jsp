<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>培训课程明细</title>
  
    <link href="<%=path %>/common/css/table.css" type=text/css rel=stylesheet />
    <script language="javascript" src="<%=path %>/common/js/calendar.js"></script>

</head>
<body>
<table width="100%"  border="0" cellspacing="0">
  <tr>
    <td>&nbsp;培训课程管理-> 添加培训课程信息</td>
  </tr>
</table>
<br>

<form method="post"  name="addTrainPlan" action="courseAddSaveAction">
<s:token/>
	<table width="800"   border="1" align="left" cellspacing="0">
		<tr>
		      <td colspan="4">
					<table width="100%"   border="0" align="center" cellspacing="0">
					  <tr>
							<th class="TH00" >添加培训课程</th>
							<th class="TH02" colspan="3">
							<input type="image" src="<%=path %>/common/images/icon01.gif" align="middle" border="0">
							<a href="<%=path %>/system/manager/course/courseListAction"><img src="<%=path %>/common/images/icon06.gif" align="middle" border="0"></a>
							</th>
					  </tr> 
					</table>
		      </td>
		</tr>
		<tr>
			<td width="143" class="TD02"> <div align="left" class="txt">培训课程标号</div></td>	
			<td width="242" class="TD01"> <input name="execDetail.execsubNO"/><font color="red">*</font></td> 
			<td width="151" class="TD02"> <div align="left" class="txt">培训课程名称</div></td>	
		    <td width="242" class="TD01"> <input name="execDetail.companytrainName"/><font color="red">*</font></td> 
		</tr>
	   <tr>
			<td width="143" class="TD02"> <div align="left" class="txt">结课标志</div></td>
			<td width="242" class="TD01"> 
			<select name="execDetail.execFlag">
			  <option></option>
			  <option value="是">已结课</option>
			  <option value="否">未结课</option>
			  </select>
			<font color="red">*</font></td> 
			<td width="151" class="TD02"> <div align="left" class="txt">培训师</div></td>
		    <td width="242" class="TD01">		
		        <input name="execDetail.companytrainManager"/><font color="red">*</font>
		    </td>
		</tr>
		<tr>
			<td width="143" class="TD02"> <div align="left" class="txt">实际开始时间</div></td>	
			<td width="242" class="TD01"> 
			 <input name="execDetail.execbeginTime" type="text" value="" maxlength="20" id="dateInput2" style="font-size:12px;width:150px;"/>
			 <input name="image" type="image" title="显示日历" onClick="fPopCalendar(dateInput2,dateInput2);return false" src="<%=path %>/common/images/calendar.gif" width="18" height="17" />
			</td> 
			<td width="151" class="TD02"> <div align="left" class="txt">实际结束时间</div></td>	
			<td width="242" class="TD01">
			 <input name="execDetail.execendTime" type="text" value="" maxlength="20" id="dateInput3" style="font-size:12px;width:150px;"/>
			 <input name="image" type="image" title="显示日历" onClick="fPopCalendar(dateInput3,dateInput3);return false" src="<%=path %>/common/images/calendar.gif" width="18" height="17" />
			</td>	
		</tr>
		<tr>	
			<td class="TD02"> <div align="left" class="txt">实际培训课时</div></td>
			<td width="242" class="TD01" colspan="3"> 
			<input name="execDetail.execHour"/></td> 
		</tr>
		<tr>	
			<td class="TD02"> <div align="left" class="txt">结课小结</div></td>	
			<td width="242" class="TD01" colspan="3">
			<textarea name="execDetail.courcesummary" cols="130" rows="5" class="textarea_edit" ></textarea>
			</td>
		</tr>
	</table>
</form>
<br> 
</body>
</html>