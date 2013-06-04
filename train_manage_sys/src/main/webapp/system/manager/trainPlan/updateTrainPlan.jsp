
<%//王长江 %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>培训计划详细信息</title>
  
    <link href="<%=path %>/common/css/table.css" type=text/css rel=stylesheet />
    <script language="javascript" src="<%=path %>/common/js/calendar.js"></script>

</head>
<body>
<table width="100%"  border="0" cellspacing="0">
  <tr>
    <td>&nbsp;培训实施管理-> 培训计划详细信息</td>
  </tr>
</table>
<br>
<!-- 培训计划修改表单开始 -->
<form method="post"  name="addTrainPlan"  id="addTrainPlan" action="<%=path %>/system/manager/trainPlan/trainPlan_update.action">
<s:token/>
	<table width="800"   border="1" align="left" cellspacing="0">
		<tr>
		      <td colspan="4">
					<table width="100%"   border="0" align="center" cellspacing="0">
					  <tr>
							<th class="TH00" >培训计划详细信息</th>
							<th class="TH02" colspan="3">
							<input type="image" src="<%=path %>/common/images/icon04.gif" align="middle" border="0">
							<a href="<%=path %>/system/manager/trainPlan/TrainPlan_update.action"><img src="<%=path %>/common/images/icon06.gif" align="middle" border="0"></a>
							</th>
					  </tr>
					</table>
		      </td>
		</tr>
		<tr>
		    
			<td width="143" class="TD02"> <div align="left" class="txt">培训计划名称</div></td>	
			<td width="242" class="TD01">
			           <input name="trainPlan.planName" value="<s:property value="trainPlan.planName"/>"/><font color="red">*</font>
			</td> 
			<td width="151" class="TD02"> <div align="left" class="txt">计划制定人</div></td>	
		    <td width="242" class="TD01"> <input name="trainPlan.userChinaname" value="<s:property value="trainPlan.userChinaname"/>"/><font color="red">*</font></td> 
		</tr>
	   <tr>
			<td width="143" class="TD02"> <div align="left" class="txt">培训类型 </div></td>
			<td width="242" class="TD01"> 
			<select name="trainPlan.trainingType">
			  <option  value="校内培训" >校内培训</option>
			  <option <s:property value="'校外培训'.equals(trainPlan.trainingType)?'selected':''"/> value="校外培训">校外培训</option>
			</select>
			<font color="red">*</font></td> 
			
		</tr>
		<tr>	
			<td class="TD02"> <div align="left" class="txt">实施标志</div></td>
			<td width="242" class="TD01" colspan="3"> 
			<input type="radio" name="trainPlan.planexecFlag" value="实施">实施
		    <input type="radio" name="trainPlan.planexecFlag"  value="未实施" <s:property value="'未实施'.equals(trainPlan.planexecFlag)?checked:''"/>>未实施
			<font color="red">*</font></td> 
		</tr>
		
</table>
</form>
</body>
</html>