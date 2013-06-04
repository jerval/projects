<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
    <form action="test" method="post">
			<table width="90%" align="center">
				<tr>
					<th align="right">
						姓名：
					</th>
					<td>
						<input name="user.username" type="text" />
					</td>
				</tr>
				<tr>
					<th align="right">
						birth：
					</th>
					<td>
						<input name="user.birthday" type="text"/>
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
