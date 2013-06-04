<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
    <form action="modeldriven" enctype="multipart/form-data" method="post">
    <s:i18n name="messages">
    <s:property value="getText('jerval')" />
</s:i18n>

			<table width="90%" align="center">
				<tr>
					<th align="right">
						姓名：
					</th>
					<td>
						<input name="username" type="text" value="<s:property value="user.username"/>"/>
					</td>
				</tr>
				<tr>
					<th align="right">
						ID：
					</th>
					<td>
						<input name="id" type="text" />
					</td>
				</tr>
				<tr>
					<th align="right">
						birth：
					</th>
					<td>
						<input name="birthday" type="text"/>
					</td>
				</tr>
				<tr>
					<th align="right">
						文件1:
					</th>
					<td>
						<input type="file" name="image">
					</td>
				</tr>
				<tr>
					<th align="right">
						文件2:
					</th>
					<td>
						<input type="file" name="image">
					</td>
				</tr>
				<tr>
					<th align="right">
						文件3:
					</th>
					<td>
						<input type="file" name="image">
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
