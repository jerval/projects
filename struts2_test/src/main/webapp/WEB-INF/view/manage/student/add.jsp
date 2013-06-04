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
						<input name="s_id" type="text" value="<s:property value="s_id"/>"/>
					</td>
				</tr>
				<tr>
					<th align="right">
						姓名：
					</th>
					<td>
						<input name="s_name" type="text" value="<s:property value="s_name"/>"/>
					</td>
				</tr>
				<tr>
					<th align="right">
						性别：
					</th>
					<td>
						男
						<input name="s_sex" type="radio" checked="checked" value="true" />
						女
						<input name="s_sex" type="radio" <s:if test="s_sex==false">checked</s:if> value="false" />
					</td>
				</tr>
				<tr>
					<th align="right">
						生日
					</th>
					<td>
						<input name="s_birthday" type="text" value="<s:property value="s_birthday"/>"/>
					</td>
				</tr>
				<tr>
					<th align="right">
						备注
					</th>
					<td>
						<textarea rows="5" cols="40" name="s_memo"><s:property value="s_memo"/></textarea>
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
		<s:debug></s:debug>
	</body>
</html>
