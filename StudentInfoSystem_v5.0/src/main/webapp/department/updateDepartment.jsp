<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>修改系别信息</title>
	</head>
	<body>
		<form name="form1" method="post" action="departmentAction!updateSave">
			<table width="600" border="0">
				<tr>
					<td align="right">
						系别编号
					</td>
					<td><input id="version" name="version" type="hidden" value="<s:property value='department.version'/>">
						<input name="departmentId" type="text" id="departmentId" size="18"
							value="<s:property value='department.departmentId'/>">
					</td>
				</tr>
				<tr>
					<td align="right">
						系别名称
					</td>
					<td>
						<input type="text" name="name" id="name" value="<s:property value='department.name'/>">
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="submit" name="button" id="button" value="提交">
					</td>
				</tr>
			</table>
			<p>
				&nbsp;
			</p>
		</form>
	</body>
</html>