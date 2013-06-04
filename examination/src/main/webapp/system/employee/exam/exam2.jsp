<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>welcome</title>
		<link href="../../../style/css.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="../../../js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="exam2.js"></script>
	</head>
	<body>
		<form id="form1" action="">
			<input type="hidden" id="pageNo" name="pageNo" />
			<table width="1002" height="100%" bgcolor="#FFFFFF" border="0"
				align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td width="948" height="100%" align="center" valign="top"
						class="thin">
						<table align='center' width='585' border='0'>
							<tbody id="dataArea"></tbody>
						</table>
						<span class="text" id="pageBar"></span>
						<span class="text" id="pageOperateBar"></span>
					</td>
				</tr>
				<tr>
					<td height="70" align="center" background="../../../img/buttom.jpg"
						class="text buttom"></td>
				</tr>
			</table>
		</form>
	</body>
</html>