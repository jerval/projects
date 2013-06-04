<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <link href="<%=path %>/common/css/table.css" type=text/css rel=stylesheet />
<script language="javascript" src="<%=path %>/js/calendar.js"></script>
<title>
修改培训实施
</title>
</head>
<body>
<table width="100%"  border="0" cellspacing="0">
  <tr>
    <td>&nbsp;培训实施管理-> 修改培训实施</td>
  </tr>
</table>

<br>
<!-- 培训实施修改表单开始 -->
<form method="post"  name="addTrainPractise"  id="addTrainPractise" action="<%=path %>/system/manager/trainPractise/TrainPractise_updateTrainPractise.action">
<s:token/>
		<table width="800"   border="1" align="center" cellspacing="0">
		  <tr><td colspan="4">
			  <table width="100%"   border="0" align="center" cellspacing="0">
			    <tr>
					<th class="TH00" >修改培训实施基本信息</th>
					<th class="TH02" colspan="3">
					<input type="image" src="<%=path %>/common/images/icon04.gif" align="middle" border="0">
					<a href="<%=path %>/system/manager/trainPractise/TrainPractise_listTrainPractise.action"><img src="<%=path %>/common/images/icon06.gif" align="middle" border="0"></a>
					</th>
			    </tr> 
			 </table>
		  </td></tr>
		 <tr>
		    <td width="143" class="TD02"><div align="left" class="txt">培训计划名称</div></td>	
		    <td width="242" class="TD01">
			     <s:select theme="simple" name="trainPractise.trainPlan.trainingexecSeq" listValue="optionValue" listKey="optionName" list="#request.selectOptionList">
                 </s:select>
			 </td>  
		    <td width="143" class="TD02"> <div align="left" class="txt">培训名称</div></td>	
			<td width="242" class="TD01"> <input name="trainPractise.courceName" value="<s:property value="trainPractise.courceName"/>"><font color="red">*</font></td> 
		  </tr>
		<tr>
			<td class="TD02"> <div align="left" class="txt">结案综合评价</div></td>	
			<td width="242" class="TD01">
			<select name="trainPractise.trainnerImpact">
				  <option value="优秀">优秀</option>
				  <option value="良好">良好</option>
				  <option selected value="合格">合格</option> 
				  <option value="不合格">不合格</option>
			 </select>
			</td>
			<td width="151" class="TD02"> <div align="left" class="txt">实施管理者</div></td>
		    <td width="242" class="TD01">
		      <input name="trainPractise.courceManager" value="<s:property value="trainPractise.courceManager"/>"><font color="red">*</font></td>
		</tr>
		<tr>
			<td width="143" class="TD02"> <div align="left" class="txt">培训资料有无</div></td>	
			<td width="242" class="TD01"> 
			<input type="radio" name="trainPractise.courcedocFlag" value="有" checked>有
		    <input type="radio" name="trainPractise.courcedocFlag" value="无">无
			</td> 
			<td width="151" class="TD02"> <div align="left" class="txt">计划课时（小时）</div></td>
		    <td width="242" class="TD01"> <input name="trainPractise.planHour" value="<s:property value="trainPractise.trainPractisePlanHour"/>"><font color="red">*</font></td>			
		</tr>
		<tr>
			<td width="143" class="TD02"> <div align="left" class="txt">结案标志</div></td>	
			<td width="242" class="TD01"> 
			<input type="radio" name="trainPractise.okFlag" value="未结案" checked>未结案
		    <input type="radio" name="trainPractise.okFlag" value="已结案">已结案
			</td> 
			<td width="151" class="TD02"> <div align="left" class="txt">实际课时（小时）</div></td>	
			<td width="242" class="TD01"><input name="trainPractise.execHour" value="<s:property value="trainPractise.execHour"/>"><font color="red">*</font></td>	
		</tr>
		
		<!-- 不可更改的 -->
		<tr>
		    
			<td width="143" class="TD02"> <div align="left" class="txt">添加者</div></td>	
			<td width="242" class="TD01">
			          <s:property value="trainPractise.insertID"/>
			</td> 
			<td width="151" class="TD02"> <div align="left" class="txt">添加日期</div></td>	
		    <td width="242" class="TD01"> <s:property value="trainPractise.insertDate"/></td> 
		</tr>
		<tr>
		    
			<td width="143" class="TD02"> <div align="left" class="txt">上次更新者</div></td>	
			<td width="242" class="TD01">
			          某某某
			</td> 
			<td width="151" class="TD02"> <div align="left" class="txt">更新日期</div></td>	
		    <td width="242" class="TD01"> <s:property value="trainPractise.updateDate"/></td> 
		</tr>
		<tr>	
			<td class="TD02"> <div align="left" class="txt">删除标志</div></td>
			<td width="242" class="TD01" colspan="3"> 
			  <s:property value="trainPractise.deleteFlag"/>
			</td> 
		</tr>
		<!-- 不可更改的结束 -->
		<tr>	
			<td class="TD02"> <div align="left" class="txt">培训目标</div></td>	
			<td width="242" class="TD01" colspan="3">
			<textarea  name="trainPractise.courceAim" cols="130" rows="5" class="textarea_edit" ><s:property value="trainPractise.courceAim"/></textarea><font color="red">*</font>
			</td>
		</tr>
		<tr>	
			<td class="TD02"> <div align="left" class="txt">教学大纲</div></td>	
			<td width="242" class="TD01" colspan="3">
			<textarea  name="trainPractise.courceOutline" cols="130" rows="5" class="textarea_edit" ><s:property value="trainPractise.courceOutline"/></textarea><font color="red">*</font>
			</td>
		</tr>
		<tr>	
			<td class="TD02"> <div align="left" class="txt">结案报告概要</div></td>	
			<td width="242" class="TD01" colspan="3">
			<textarea name="trainPractise.trainingReport" cols="130" rows="5" class="textarea_edit" ><s:property value="trainPractise.trainingReport"/></textarea>
			
			<!-- 以下是隐藏域 -->
			<input type="hidden" name="trainPractise.trainingexecSeq" value="<s:property value="trainPractise.trainingexecSeq"/>"/>
			<input type="hidden" name="trainPractise.insertID" value="<s:property value="trainPractise.insertID"/>"/>
			<input type="hidden" name="trainPractise.insertDate" value="<s:property value="trainPractise.insertDate"/>"/>
			<input type="hidden" name="trainPractise.updateID" value="   某某某"/>
			<input type="hidden" name="trainPractise.deleteFlag" value="<s:property value="trainPractise.deleteFlag"/>"/>
			</td>
		</tr>
	</table>
</form>
<!-- 培训实施修改表单结束 -->
</body>
</html>