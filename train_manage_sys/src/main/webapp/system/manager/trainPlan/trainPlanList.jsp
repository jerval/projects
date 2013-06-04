
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
    <base href="<%=basePath%>">
   <title>培训计划一览</title>
<LINK href="common/css/table.css" type=text/css rel=stylesheet />
<script language="text/javascript" src="common/js/util/calendar.js"></script>
<script type="text/javascript" src="<%=path %>/common/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=path %>/common/js/util/deleteCheckbox.js"></script>
<script type="text/javascript">
  $(function(){
      $("#query").click(function(){
         $("pageIndex").val("1");
      });
  });
  
</script>
</head>

<body>
  <input type="hidden" id="deleteUrl" value="<%=path %>/system/manager/trainPlan/trainPlan_delete.action">
  <input type="hidden" id="noName" value="trainPlan_nos">
<table width="100%"  border="0" cellspacing="0">
  <tr>
    <td>&nbsp;培训实施管理-> 培训计划一览</td>
  </tr>
</table>


<br>
<table width="800"  border="0" align="left" cellspacing="0">
  <tr>
     <td>
       <!--查询条件表单开始 -->
             <form id="queryForm" action="<%=path %>/system/manager/trainPlan/trainPlan_list.action" method="post">
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
									  <th width="55%" class="TH02">培训计划查询</th>
						   			  <th width="45%" class="TH02" colspan="3">
						   			      <input type="submit" value="查询" id="query"/>
						   			  </th>
								  </tr>
							  </table>
						  </td>
						   
					    </tr>
					    <tr>
							<td width="150" class="TD02" >  <div align="left" class="txt">培训计划编号</div></td>	
							<td width="259"  class="TD01">  <input value="<s:property value="trainPlan.trainingplanSeq"/>" name="trainPlan.trainingplanSeq"></td>
							<td width="150"  class="TD02"> <div align="left" class="txt">培训计划名称</div></td>	
							<td width="259"  class="TD01"> <input value="<s:property value="trainPlan.planName"/>" name="trainPlan.planName"> </td>		
					    </tr>
					    <tr>
							<td  class="TD02"> <div align="left" class="txt">计划制定人</div></td>	
							<td class="TD01">  <input type="text" value="<s:property value="trainPlan.userChinaname"/>" name="trainPlan.userChinaname"/></td>	
							<td class="TD02" > <div align="left" class="txt"> 培训类型</div></td>	
							<td   class="TD01">  
							<span class="TD01"><select style=" width:80px;" name="trainPlan.trainingType">
							  <option></option>
							  <option value="社内培训" <s:property value="'社内培训'.equals(trainPlan.trainingType)?selected:''"/>></option>>社内培训</option>
							  <option value="社外培训" <s:property value="'社外培训'.equals(trainPlan.trainingType)?selected:''"/>></option>>社外培训</option> 
							  </select></span>
							</td>	
					    </tr>
					    <tr>	
							<td class="TD02" >  <div align="left" class="txt">实施标志</div></td>	
							<td   class="TD01">  <select style=" width:80px;" name="trainPlan.planexecFlag">
							  <option></option>
							  <option value="已实施" <s:property value="'已实施'.equals(trainPlan.planexecFlag)?'selected':''"/>>已实施</option>
							  <option value="未实施" <s:property value="'未实施'.equals(trainPlan.planexecFlag)?'selected':''"/>>未实施</option> 
							  </select></td>
							<td class="TD01" colspan="2">&nbsp;</td>	
					    </tr>
					</table>
				</form>
		   <!--查询条件表单结束 -->
 
         <!--列表开始-->
		<table width="800"   border="1" align="center" cellspacing="0">
			<tr >
			  	<td colspan="12">
					<table width="100%" border="0" cellspacing="0" >
						<tr>
				    		<th width="55%" align="middle" class="TH02">培训计划一览</th>
							<th width="35%" align="right" class="TH02"><a href="<%=path %>/system/manager/trainPlan/addTrainPlan.jsp"><img src="common/images/icon01.gif" align="middle" border="0"></a></th>
							<th width="15%" align="left" class="TH02"><img id="deleteSelected" src="<%=path %>/common/images/icon03.gif" align="middle" border="0"></th>
						</tr>
					</table>
				</td>
			 </tr>
			 <tr class="TD02" >
			    <td width="4%" class="TD03"><input type="checkbox" id="checkboxAll" /></td>
				<td width="8%" class="TD03"  >培训计划编号</td>
				<td width="8%" class="TD03"  >培训计划名称</td>
				<td width="8%" class="TD03"  >计划制定人</td>
				<td width="8%" class="TD03"  >培训类型</td>
				<td width="10%" class="TD03" >实施标志</td>	
			</tr >
			<s:if test="#request.trainPlanList!=null&&#request.trainPlanList.size>0">
		     <s:iterator id="trainPlan" value="#request.trainPlanList" status="row">
		            <tr
		               <s:if test="#row.odd==true">
		                   bgcolor="#EEEEEE";
		               </s:if>
		               <s:else>
		                 bgcolor="#DDDDDD"
		               </s:else>
		            >
		                <td width="4%" class="TD03" > <input  type="checkbox" id="checkbox_no" name="checkbox_no" value="<s:property value="#trainPlan.trainingplanSeq"/>" /></td>
						<td width="8%" class="TD01" ><s:property value="#trainPlan.trainingplanSeq"/></td>
						<td width="8%" class="TD01" ><s:property value="#trainPlan.planName"/></td>
						<td width="8%" class="TD01" ><s:property value="#trainPlan.userChinaname"/></td>
						<td width="6%" class="TD01" ><s:property value="%{#trainPlan.trainingType}"/></td>
						<td width="6%" class="TD01" >${trainPlan.planexecFlag}</td>
						<td>
						  <a onclick="return confirm('你确定要删除该数据吗？')" href="<%=path %>/system/manager/trainPlan/trainPlan_list.action?delete_nos=<s:property value="#trainPlan.trainingplanSeq"/>">删除</a>
						  <a href="<%=path %>/system/manager/trainPlan/trainPlan_toUpdate.action?trainPlan.trainingplanSeq=<s:property value="#trainPlan.trainingplanSeq"/>">修改</a>
						</td>
					</tr >
	
		     </s:iterator>
		     <tr><input type="button" value="删除所选" id="deleteSelected"/></tr>
		     </s:if>
		     <s:else>
		     <tr><td colspan="9">暂无数据</td></tr>
		     </s:else>
		</table>
		<!--列表结束-->
        <%@ include file="/common/util/pageBean.jsp" %>
   <br>
    </td>
   </tr>
 </table>
<br>
<br>
</body>
</html>

