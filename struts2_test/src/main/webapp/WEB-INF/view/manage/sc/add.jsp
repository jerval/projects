<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>

	<body>
	<s:fielderror></s:fielderror>
	<s:actionmessage/>
		<form action="save" method="post">
			<table width="90%" align="center">
				<tr>
					<th align="right">
						学生编号：
					</th>
					<td>
					<s:token></s:token>
						<input name="s_id" type="text" value="<s:property value="s_id"/>"/>
					</td>
				</tr>
				<tr>
					<th align="right">
						课程编号：
					</th>
					<td>
						<input name="c_id" type="text" value="<s:property value="c_id"/>"/>
					</td>
				</tr>
				
				<tr>
					<th align="right">
						成绩：
					</th>
					<td>
						<input name="sc_score" type="text" value="<s:property value="sc_score"/>"/>
					</td>
				</tr>
				<tr>
					<th align="right">
						备注:
					</th>
					<td>
						<textarea rows="5" cols="40" name="sc_memo"><s:property value="sc_memo"/></textarea>
					</td>
				</tr>
				<tr>
					<th align="right"></th>
					<td>
						<input type="submit" value="提交" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
