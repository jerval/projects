<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>

	<body>
		成绩信息列表|<a href="add">添加成绩信息</a>
		<br>
		<table width="90%" border="1">
			<tr>
				<th>
					<input id="checkAll" type="checkbox" />
				</th>
				<th>
					学生编号
				</th>
				<th>
					课程编号
				</th>
				<th>
					成绩
				</th>
				<th>
					备注
				</th>
				<th>
					操作
				</th>
			</tr>
			<s:iterator value="pagination.list" var="sc">
				<tr>
					<td>
						<input name="ids" type="checkbox" />
					</td>
					<td><s:property value="#sc.s_id"/> </td>
					<td><s:property value="#sc.c_id"/></td>
					<td><s:property value="#sc.sc_score"/></td>
					<td><s:property value="#sc.sc_memo"/></td>
					<td>
						<a href="update?id=<s:property value="#sc.id"/>">修改</a>｜
						<a href="delete?id=<s:property value="#sc.id"/>">删除</a>
					</td>
				</tr>
			</s:iterator>
		</table>
<s:debug></s:debug>
	</body>
</html>
