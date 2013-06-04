<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>

	<body>
		学生信息列表|<a href="add">添加学生信息</a>
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
					学生姓名
				</th>
				<th>
					性别
				</th>
				<th>
					生日
				</th>
				<th>
					备注
				</th>
				<th>
					操作
				</th>
			</tr>
			<s:iterator value="pagination.list" var="student">
				<tr>
					<td>
						<input name="ids" type="checkbox" value="<s:property value="#student.id"/>"/>
					</td>
					<td><s:property value="#student.s_id"/> </td>
					<td><s:property value="#student.s_name"/></td>
					<td><s:property value="#student.s_sex==true?'男':'女'"/></td>
					<td><s:property value="#student.s_birthday"/></td>
					<td><s:property value="#student.s_memo"/></td>
					<td>
						<a href="update?id=<s:property value="#student.id"/>">修改</a>｜
						<a href="delete?id=<s:property value="#student.id"/>">删除</a>
					</td>
				</tr>
			</s:iterator>
		</table>

	</body>
</html>
