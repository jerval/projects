<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
	<title>培训实施一览</title>
	<LINK href="common/css/table.css" type=text/css rel=stylesheet />
	<script language="text/javascript" src="common/js/util/calendar.js"></script>
	<script type="text/javascript" src="<%=path %>/common/js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="<%=path %>/common/js/util/deleteCheckbox.js"></script>  
</head>

<body>
<input type="hidden" id="deleteUrl" value="<%=path %>/system/manager/trainPractise/TrainPractise_deleteTrainPractise.action">
<input type="hidden" id="noName" value="trainPractise_nos">
<table width="100%"  border="0" cellspacing="0">
  <tr>
    <td>&nbsp;培训实施管理-> 培训实施一览</td>
  </tr>
</table>
<br>
<table width="800"   border="0" align="left" cellspacing="0">
  <tr>
      <td>
            <!--查询条件表单开始 -->
             <form id="queryForm" action="<%=path %>/system/manager/trainPractise/TrainPractise_listTrainPractise.action" method="post">
	        <input type="hidden" id="pageIndex" name="pageBean.pageIndex" value="<s:property value="pageBean.pageIndex"/>">
	   		<input type="hidden" id="pageCount" name="pageBean.pageCount" value="<s:property value="pageBean.pageCount"/>">
   			<!--  
   			<input type="hidden" id="pageSize" name="pageBean.pageSize" value="<s:property value="pageBean.pageSize"/>">
   			-->
				<table width="800"   border="1" align="center" cellspacing="0">
				  <tr>
				  <td colspan="4">
									<table width="100%" border="0" cellspacing="0" >
										<tr>
											 <th width="55%" class="TH02">培训实施查询</th>
								   			 <th width="45%" class="TH02" colspan="3"><a href="#"><img src="common/images/icon07.gif" align="middle" border="0"></a></th>
										</tr>
									</table>
								</td>
								   
							  </tr>
							<tr>
								<td width="143" class="TD02"><div align="left" class="txt">培训计划名称</div></td>	
							    <td width="242" class="TD01"><select style=" width:115px; " name="select2" >
								  <option value=""></option>
							      <option value="100000000">2006年度计划</option>
							      <option value="200000000">2007年度计划</option>
							    </select></td>
								<td width="150"  class="TD02"> <div align="left" class="txt">培训实施编号</div></td>	
								<td width="259"  class="TD01">  <input >   </td>		
							</tr>
							<tr>
								<td  class="TD02"> <div align="left" class="txt">培训名称</div></td>	
								<td class="TD01">  <input ></td>	
								<td class="TD02" > <div align="left" class="txt"> 实施管理者</div></td>	
								<td   class="TD01">  <input ></td>	
							</tr>
							<tr>	
								<td class="TD02" >  <div align="left" class="txt">结案标志</div></td>	
								<td   class="TD01">  <select style=" width:80px; ">
								  <option></option>
								  <option value="已结案">已结案</option>
								  <option value="未结案">未结案</option> 
								  </select></td>
								<td class="TD01" colspan="2">&nbsp;</td>	
							</tr>
	          </table>	
		    </form>
		    <!--查询条件表单结束 -->
 <br>
         <!--列表开始-->
		<table width="800"   border="1" align="center" cellspacing="0">
		<tr >
		  	<td colspan="12">
				<table width="100%" border="0" cellspacing="0" >
					<tr>
			    		<th width="55%" align="middle" class="TH02">培训实施一览</th>
						<th width="45%" align="right" class="TH02"><a href="<%=path %>/system/manager/trainPractise/TrainPractise_selectForAdd.action"><img src="common/images/icon01.gif" align="middle" border="0"></a></th>
					    <th width="15%" align="left" class="TH02"><img id="deleteSelected" src="<%=path %>/common/images/icon03.gif" align="middle" border="0"></th>
					</tr>
				</table>
			</td>
		 </tr>
		  
		
		 <tr class="TD02" >
		    <td width="4%"  class="TD03"  ><input type="checkbox" id="checkboxAll" /></td>
			<td width="8%"  class="TD03"  >培训实施编号</td>
			<td width="20%" class="TD03"  >培训计划名称</td>
			<td width="20%" class="TD03"  >培训名称</td>
			<td width="20%" class="TD03"  >教学大纲</td>
			<td width="6%"  class="TD03"  >计划课时</td>
			<td width="8%"  class="TD03"  >实施管理者</td>
			<td width="6%"  class="TD03"  >结案标志</td>
			<td width="8%"  class="TD03"  >结案综合评价</td>	
		</tr >
		<s:iterator id="trainPractise" value="#request.trainPractiseList" status="row">
		 <tr>
		    <td width="4%"  class="TD03"  ><input  type="checkbox" id="checkbox_no" name="checkbox_no" value="<s:property value="#trainPractise.trainPractiseNo"/>" /></td>
			<td width="8%"  class="TD01"  ><a href="<%=path %>/system/manager/trainPractise/TrainPractise_selectForUpdate.action?trainPractise.trainingexecSeq=<s:property value="#trainPractise.trainingexecSeq"/>"><s:property value="#trainPractise.trainingexecSeq"/></a></td>
			<td width="20%" class="TD01"  ><s:property value="#trainPractise.trainPlan.trainingplan"/></td>
			<td width="6%"  class="TD05"  ><s:property value="#trainPractise.courceName"/></td>
			<td width="8%"  class="TD01"  ><s:property value="#trainPractise.courceOutline"/></td>
			<td width="6%"  class="TD01"  ><s:property value="#trainPractise.planHour"/></td>
			<td width="8%"  class="TD01"  ><s:property value="#trainPractise.courceManager"/></td>
            <td width="8%"  class="TD01"  ><s:property value="#trainPractise.okFlag"/></td>
            <td width="8%"  class="TD01"  ><s:property value="#trainPractise.trainnerImpact"/></td>
		</tr >
		</s:iterator>
		<!--列表结束-->
		</table>
		<%@ include file="/common/util/pageBean.jsp" %>

    </td>
  </tr>
</table>
<br>
<br>
</body>
</html>
