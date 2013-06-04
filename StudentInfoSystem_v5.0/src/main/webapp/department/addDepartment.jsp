<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加系别信息</title>
</head>
<body>
<form name="form1" method="post" action="departmentAction!addSave">
  <table width="600" border="0">
    <tr>
      <td align="right">系别编号</td>
      <td><input name="departmentId" type="text" id="departmentId" size="18"></td>
    </tr>
    <tr>
      <td align="right">系别名称 </td>
      <td><input type="text" name="name" id="name"></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" name="button" id="button" value="提交"></td>
    </tr>
  </table>
<p>&nbsp;</p>
</form>
</body>
</html>