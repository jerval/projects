<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>

	<body>
		课程信息列表|<a href="add">添加课程信息</a>
		<br>
		<table width="90%" border="1">
			<tr>
				<th>
					<input id="checkAll" type="checkbox" />
				</th>
				<th>
					课程编号
				</th>
				<th>
					课程名称
				</th>
				<th>
					备注
				</th>
				<th>
					操作
				</th>
			</tr>
			<s:iterator value="pagination.list" var="course">
				<tr>
					<td>
						<input name="ids" type="checkbox" value="<s:property value="#course.id"/>"/>
					</td>
					<td><s:property value="#course.c_id"/> </td>
					<td><s:property value="#course.c_name"/></td>
					<td><s:property value="#course.c_memo"/></td>
					<td>
						<a href="update?id=<s:property value="#course.id"/>">修改</a>｜
						<a href="delete?id=<s:property value="#course.id"/>">删除</a>
					</td>
				</tr>
			</s:iterator>
		</table>

	</body>
</html>
