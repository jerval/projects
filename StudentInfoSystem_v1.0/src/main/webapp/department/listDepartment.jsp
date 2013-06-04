<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="../js/jquery.validate.js"></script>
		<script type="text/javascript" src="department.js"></script>
	</head>
	<body>
		<table width="100%">
			<thead>
				<tr>
					<th>
						&nbsp;
					</th>
					<th colspan="2">
						&nbsp;
					</th>
					<th>
						<a href="javascript:add()"><img alt="添加" src="../images/addoffer.png" /></a>
					</th>
				</tr>
				<tr>
					<th bgcolor="#C1E7FF">
						系别编号
					</th>
					<th colspan="2" bgcolor="#C1E7FF">
						系别名称
					</th>
					<th bgcolor="#C1E7FF">
						操作
					</th>
				</tr>
			</thead>
			<tbody id="dataArea">
				<s:iterator value="pagination.list" var="department">
					<tr>
						<s:set var="id" value="#department.departmentId" />
						<td>
							<s:property value="#id" />
						</td>
						<td colspan="2">
							<s:property value="#department.name" />
						</td>
						<td>
							<a href="javascript:update('<s:property value='#id'/>')">修改</a> |
							<a href="javascript:del('<s:property value='#id'/>')">删除</a>
						</td>
					</tr>
				</s:iterator>
				<tr>
					<td bgcolor="#C1E7FF">
						&nbsp;
					</td>
					<td colspan="2" bgcolor="#C1E7FF">
						&nbsp;
					</td>
					<td bgcolor="#C1E7FF">
						&nbsp;
					</td>
				</tr>
			</tbody>
			<tfoot id="footArea">
				<tr>
					<s:set var="pageNum" value="department.pageNum" />
					<td colspan="2" bgcolor="#C1E7FF">
						第
						<s:property value="#pageNum" />
						页，共
						<s:property value="department.maxPages" />
						页 |总记录数
						<s:property value="department.maxElements" />
						条
						<a href=""></a>
					</td>
					<td colspan="2" bgcolor="#C1E7FF">
						首页 |上一页 |下一页 |尾页
					</td>
				</tr>
			</tfoot>
		</table>
	</body>
</html>
