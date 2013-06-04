<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>培训计划一览</title>
		<LINK href="<%=path%>/common/css/table.css" type=text/css
			rel=stylesheet />
		<script language="text/javascript"
			src="<%=path%>/common/js/util/calendar.js">
</script>
		<script type="text/javascript"
			src="<%=path%>/common/js/jquery-1.4.2.js">
</script>
		<script type="text/javascript"
			src="<%=path%>/common/js/util/deleteCheckbox.js">
</script>
	</head>

	<body>
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td>
					&nbsp;培训课程施管理-> 培训课程一览
				</td>
			</tr>
		</table>


		<br>
		<table width="800" border="0" align="left" cellspacing="0">
			<tr>
				<td>
					<!--查询条件表单开始 -->
					<form id="queryForm" action="courseListAction" method="post">
						<input type="hidden" id="deleteUrl" value="courseDeleteAction" />
						<input type="hidden" id="noName" value="ids" />
						<input type="hidden" id="pageNo" name="pageNo"
							value="<s:property value="pageNo"/>">
						<input type="hidden" id="pageSize" name="pageSize"
							value="<s:property value="pageSize"/>">
						<input type="hidden" id="maxPages"
							value="<s:property value="pagination.maxPages"/>">
						<table width="800" border="1" align="center" cellspacing="0">
							<tr>
								<td colspan="4">
									<table width="100%" border="0" cellspacing="0">
										<tr>
											<th width="55%" class="TH02">
												培训课程查询
											</th>
											<th width="45%" class="TH02" colspan="3">
												<input type="image"
													src="<%=path%>/common/images/icon07.gif">
											</th>
										</tr>
									</table>
								</td>

							</tr>
							<tr>
								<td width="150" class="TD02">
									<div align="left" class="txt">
										培训课程标号
									</div>
								</td>
								<td width="259" class="TD01">
									<input name="dto.execsubNO" value="<s:property value="dto.execsubNO"/>">
								</td>
								<td width="150" class="TD02">
									<div align="left" class="txt">
										培训课程名称
									</div>
								</td>
								<td width="259" class="TD01">
									<input name="dto.companytrainName" value="<s:property value="dto.companytrainName"/>"
										>
								</td>
							</tr>
							<tr>
								<td class="TD02">
									<div align="left" class="txt">
										培训师
									</div>
								</td>
								<td class="TD01">
									<input 
										value="<s:property value="dto.companytrainManager"/>" name="dto.companytrainManager">
								</td>
								<td class="TD02">
									<div align="left" class="txt">
										结课标志
									</div>
								</td>
								<td class="TD01">
									<select name="dto.execFlag" style="width: 80px;">
										<option></option>
										<option value="是">
											已结课
										</option>
										<option value="否">
											未结课
										</option>
									</select>
								</td>
								<td class="TD01" colspan="2">
									&nbsp;
								</td>
							</tr>
						</table>
					</form>
					<!--查询条件表单结束 -->

					<!--列表开始-->
					<table width="800" border="1" align="center" cellspacing="0">
						<tr>
							<td colspan="12">
								<table width="100%" border="0" cellspacing="0">
									<tr>
										<th width="55%" align="middle" class="TH02">
											培训课程一览
										</th>
										<th width="35%" align="right" class="TH02">
											<a href="courseAddAction"><img
													src="<%=path%>/common/images/icon01.gif" align="middle"
													border="0">
											</a>
										</th>
										<th width="15%" align="left" class="TH02">
											<img id="deleteSelected"
												src="<%=path%>/common/images/icon03.gif" align="middle"
												border="0">
										</th>
									</tr>
								</table>
							</td>
						</tr>
						<tr class="TD02">
							<td width="4%" class="TD03">
								<input type="checkbox" id="checkboxAll" />
							</td>
							<td width="8%" class="TD03">
								培训课程标号
							</td>
							<td width="8%" class="TD03">
								培训课程名称
							</td>
							<td width="8%" class="TD03">
								培训师
							</td>
							<td width="10%" class="TD03">
								结课标志
							</td>
							<td width="8%" class="TD03">
								实际开始时间
							</td>
							<td width="8%" class="TD03">
								实际结束时间
							</td>
							<td width="8%" class="TD03">
								实际培训课时
							</td>
							<td width="8%" class="TD03">
								结课小结
							</td>
						</tr>
						<s:iterator id="execDetail" value="pagination.list" status="row">
							<tr>
								<td width="4%" class="TD03">
									<input type="checkbox" name="ids"
										value="<s:property value="#execDetail.id"/>" />
								</td>
								<td width="8%" class="TD01">
									<s:property value="#execDetail.execsubNO" />
								</td>
								<td width="8%" class="TD01">
									<s:property value="#execDetail.companytrainName" />
								</td>
								<td width="8%" class="TD01">
									<s:property value="#execDetail.companytrainManager" />
								</td>
								<td width="6%" class="TD01">
									<s:property value="#execDetail.execFlag" />
								</td>
								<td width="8%" class="TD01">
									<s:date name="#execDetail.execbeginTime" format="yyyy/MM/dd" />
								</td>
								<td width="8%" class="TD01">
									<s:date name="#execDetail.execendTime" format="yyyy/MM/dd" />
								</td>
								<td width="8%" class="TD01">
									<s:property value="#execDetail.execHour" />
								</td>
								<td width="10%" class="TD01">
									<s:property value="#execDetail.courcesummary" />
								</td>
							</tr>
						</s:iterator>
					</table>
					<!--列表结束-->
					<%@ include file="/common/util/pageBean.jsp"%>
					<br>
				</td>
			</tr>
		</table>
		<br>
		<br>
	</body>
</html>

