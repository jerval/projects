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
						编号：
					</th>
					<td>
					<s:token></s:token>
						<input name="c_id" type="text" value="<s:property value="c_id"/>"/>
					</td>
				</tr>
				<tr>
					<th align="right">
						名称：
					</th>
					<td>
						<input name="c_name" type="text" value="<s:property value="c_name"/>"/>
					</td>
				</tr>
				
				<tr>
					<th align="right">
						备注:
					</th>
					<td>
						<textarea rows="5" cols="40" name="c_memo"><s:property value="c_memo"/></textarea>
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
