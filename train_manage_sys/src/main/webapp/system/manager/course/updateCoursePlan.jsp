<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>编辑培训课程信息</title>
  
    <link href="<%=path %>/common/css/table.css" type=text/css rel=stylesheet />
    <script language="javascript" src="<%=path %>/common/js/calendar.js"></script>

</head>
<body>
<table width="100%"  border="0" cellspacing="0">
  <tr>
    <td>&nbsp;培训课程管理-> 编辑培训课程信息</td>
  </tr>
</table>
<br>
<!-- 培训计划修改表单开始 -->
<form method="post"  name="addTrainPlan"  id="addTrainPlan" action="<%=path %>/system/manager/trainPlan/TrainPlan_updateTrainPlan.action">
<s:token/>
	<table width="800"   border="1" align="left" cellspacing="0">
		<tr>
		      <td colspan="4">
					<table width="100%"   border="0" align="center" cellspacing="0">
					  <tr>
							<th class="TH00" >培训计划详细信息</th>
							<th class="TH02" colspan="3">
							<input type="image" src="<%=path %>/common/images/icon04.gif" align="middle" border="0">
							<a href="<%=path %>/system/manager/trainPlan/TrainPlan_listTrainPlan.action"><img src="<%=path %>/common/images/icon06.gif" align="middle" border="0"></a>
							</th>
					  </tr>
					</table>
		      </td>
		</tr>
		<tr>
		    
			<td width="143" class="TD02"> <div align="left" class="txt">培训计划名称</div></td>	
			<td width="242" class="TD01">
			           <input name="trainPlan.trainPlanName" value="<s:property value="trainPlan.trainPlanName"/>"/><font color="red">*</font>
			</td> 
			<td width="151" class="TD02"> <div align="left" class="txt">计划制定人</div></td>	
		    <td width="242" class="TD01"> <input name="trainPlan.trainPlanCreateUser" value="<s:property value="trainPlan.trainPlanCreateUser"/>"/><font color="red">*</font></td> 
		</tr>
	   <tr>
			<td width="143" class="TD02"> <div align="left" class="txt">培训类型 </div></td>
			<td width="242" class="TD01"> 
			<select name="trainPlan.trainPlanType">
			  <option  value="魔鬼" >魔鬼</option>
			  <option <s:property value='%{"常人".equals(trainPlan.trainPlanType)?"selected":""}'/> value="常人">常人</option>
			</select>
			<font color="red">*</font></td> 
			<td width="151" class="TD02"> <div align="left" class="txt">计划制定日期</div></td>
		    <td width="242" class="TD01">		
		        <input name="trainPlan.trainPlanCreateDate" type="text" value="<s:property value="trainPlan.trainPlanCreateDateStr"/>" maxlength="20" id="dateInput1" style="font-size:12px;width:150px;"/>
			    <input name="image" type="image" title="显示日历" onClick="fPopCalendar(dateInput1,dateInput1);return false" src="<%=path %>/common/images/calendar.gif" width="18" height="17" />
		        <font color="red">*</font>
		    </td>
		</tr>
		<tr>
			<td width="143" class="TD02"> <div align="left" class="txt">计划开始日期</div></td>	
			<td width="242" class="TD01"> 
			 <input name="trainPlan.trainPlanBeginDate" type="text" value="<s:property value="trainPlan.trainPlanBeginDateStr"/>" maxlength="20" id="dateInput2" style="font-size:12px;width:150px;"/>
			 <input name="image" type="image" title="显示日历" onClick="fPopCalendar(dateInput2,dateInput2);return false" src="<%=path %>/common/images/calendar.gif" width="18" height="17" />
			<font color="red">*</font></td> 
			<td width="151" class="TD02"> <div align="left" class="txt">计划结束日期</div></td>	
			<td width="242" class="TD01">
			 <input name="trainPlan.trainPlanEndDate" type="text" value="<s:property value="trainPlan.trainPlanEndDateStr"/>" maxlength="20" id="dateInput3" style="font-size:12px;width:150px;"/>
			 <input name="image" type="image" title="显示日历" onClick="fPopCalendar(dateInput3,dateInput3);return false" src="<%=path %>/common/images/calendar.gif" width="18" height="17" />
			<font color="red">*</font></td>	
		</tr>
		<tr>	
			<td class="TD02"> <div align="left" class="txt">实施标志</div></td>
			<td width="242" class="TD01" colspan="3"> 
			<input type="radio" name="trainPlan.trainPlanBeginFlag" value="实施">实施
		    <input type="radio" name="trainPlan.trainPlanBeginFlag"  value="未实施" checked>未实施
			<font color="red">*</font></td> 
		</tr>
		
		<!-- 不可更改的 -->
		<tr>
		    
			<td width="143" class="TD02"> <div align="left" class="txt">添加者</div></td>	
			<td width="242" class="TD01">
			          <s:property value="trainPlan.trainPlanInsertUser"/>
			</td> 
			<td width="151" class="TD02"> <div align="left" class="txt">添加日期</div></td>	
		    <td width="242" class="TD01"> <s:property value="trainPlan.trainPlanInsertDateStr"/></td> 
		</tr>
		<tr>
		    
			<td width="143" class="TD02"> <div align="left" class="txt">上次更新者</div></td>	
			<td width="242" class="TD01">
			          某某某
			</td> 
			<td width="151" class="TD02"> <div align="left" class="txt">更新日期</div></td>	
		    <td width="242" class="TD01"> <s:property value="trainPlan.trainPlanUpdateDateStr"/></td> 
		</tr>
		<tr>	
			<td class="TD02"> <div align="left" class="txt">删除标志</div></td>
			<td width="242" class="TD01" colspan="3"> 
			  <s:property value="trainPlan.trainPlanDeleteFlag"/>
			</td> 
		</tr>
		
		
		
		
		<tr>	
			<td class="TD02"> <div align="left" class="txt">课程目标</div></td>	
			<td width="242" class="TD01" colspan="3">
			<textarea name="trainPlan.trainPlanTarget" cols="130" rows="5" class="textarea_edit" ><s:property value="trainPlan.trainPlanTarget"/></textarea><font color="red">*</font>
			<!-- 以下是隐藏域 -->
			<input type="hidden" name="trainPlan.trainPlanNo" value="<s:property value="trainPlan.trainPlanNo"/>"/>
			<input type="hidden" name="trainPlan.trainPlanInsertUser" value="<s:property value="trainPlan.trainPlanInsertUser"/>"/>
			<input type="hidden" name="trainPlan.trainPlanInsertDate" value="<s:property value="trainPlan.trainPlanInsertDate"/>"/>
			<input type="hidden" name="trainPlan.trainPlanUpdateUser" value="某某某"/>
			<input type="hidden" name="trainPlan.trainPlanDeleteFlag" value="<s:property value="trainPlan.trainPlanDeleteFlag"/>"/>
			</td>
		</tr>
	</table>
</form>
<!-- 培训计划修改表单结束 -->
<br> 
</body>
</html>