<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>welcome</title>
		<link href="../../../style/css.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="../../../js/jquery-1.4.2.js"></script>
		<!-- ui -->
		<link type="text/css" href="../../../ui/jquery-ui-1.8.custom.css" rel="stylesheet" />
	<script type="text/javascript" src="../../../ui/jquery.bgiframe-2.1.1.js"></script>
	<script type="text/javascript" src="../../../ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="../../../ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="../../../ui/jquery.ui.mouse.js"></script>
	<script type="text/javascript" src="../../../ui/jquery.ui.button.js"></script>
	<script type="text/javascript" src="../../../ui/jquery.ui.draggable.js"></script>
	<script type="text/javascript" src="../../../ui/jquery.ui.position.js"></script>
	<script type="text/javascript" src="../../../ui/jquery.ui.resizable.js"></script>
	<script type="text/javascript" src="../../../ui/jquery.ui.dialog.js"></script>
	<!-- ui -->
		<script src="../../../js/base.js" type="text/javascript"></script>
		<script type="text/javascript" src="exam.js"></script>
	</head>
	<body>
		<div id="dialog">
			<h2 id="subtitle"></h2>
			<p id="msg"></p>
		</div>
		<table width="1002" bgcolor="#FFFFFF" border="0" align="center"
			cellpadding="0" cellspacing="0">
			<tr>
				<td align="left" valign="top" bgcolor="#FFFFFF">
					<table width="1002" height="150" border="0" align="center"
						cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
						<tr>
							<td width="54" rowspan="2">
								<img src="../../../img/1-2.jpg" width="53" height="59"
									align="middle">
							</td>
							<td width="594" height="0">
								<p class="style4">
									<span class="text"><span style="color: red;"><s:property
												value="#session.operateEmployee.emp_name" /> </span>
										您好！欢迎进入在线考试系统,员工号：<s:property
											value="#session.operateEmployee.emp_id" /> ,考试时间为：<span
										id="answerTime"></span>分钟</span>
								</p>
							</td>
							<td width="354">
								<span class="style4"><span class="text">剩余时间是：<strong
										id="RemainD"></strong> <span id="minute" class="STYLE1"></span>分<span
										id="scond" class="STYLE1"></span>秒
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
											id="getresult" value="交卷"> </span> </span>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<form id="form1" action="getExamAction!result" post="post">
						<input type="hidden" id="pageNo" name="pageNo" />
						<table width="1002" bgcolor="#FFFFFF" border="0" align="center"
							cellpadding="0" cellspacing="0">
							<tr>
								<td width="948" height="300" align="center" valign="top"
									class="thin">
									<table align='center' width='585' border='0'>
										<tbody id="dataArea"></tbody>
									</table>
									<span class="text" id="pageBar"></span>
									<span class="text" id="pageOperateBar"></span>
								</td>
							</tr>
							<tr>
								<td height="70" align="center"
									background="../../../img/buttom.jpg" class="text buttom"></td>
							</tr>
						</table>
					</form>

				</td>
			</tr>
			</tr>
		</table>

	</body>
</html>