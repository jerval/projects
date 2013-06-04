<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>welcome</title>
		<link href="../../../style/css.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="../../../js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="exam1.js"></script>
	</head>
	<body>
	<s:token></s:token>
		<table width="1002" height="100%" bgcolor="#FFFFFF" border="0"
			align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td align="left" valign="top" bgcolor="#FFFFFF">
					<table width="1002" height="100%" border="0" align="center"
						cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
						<tr>
							<td width="54" rowspan="2">
								<img src="../../../img/1-2.jpg" width="53" height="59"
									align="middle">
							</td>
							<td width="594" height="0">
								<p class="style4">
									<span class="text"><span style="color:red;"><s:property value="#session.operateEmployee.emp_name"/></span>
									 您好！欢迎进入在线考试系统,员工号：<s:property value="#session.operateEmployee.emp_id"/>
										,考试时间为：<s:property value="examPaper.answerTime"/>分钟</span>
								</p>
							</td>
							<td width="354">
								<span class="style4"><span class="text">剩余时间是：<strong
										id="RemainD"></strong> <span class="STYLE1">XX</span>分<span
										class="STYLE1">XX</span>秒 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="submit" id="submit" value="交卷"> 
										</span> </span>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<form id="form1" action="getExamAction!getResult" target="_top"></form>
	</body>
</html>
