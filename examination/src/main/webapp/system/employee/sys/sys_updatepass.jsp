<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<link href="../../../style/styles.css" rel="stylesheet"
			type="text/css" />
		<link type="text/css" rel="stylesheet"
			href="../../../style/validator.css" />
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
		<script src="../../../js/formValidator.js" type="text/javascript"
			charset="UTF-8"></script>
		<script src="../../../js/formValidatorRegex.js" type="text/javascript"
			charset="UTF-8"></script>
			<script src="../../../js/base.js" type="text/javascript"></script>
		 <script src="sys_updatePassword.js" type="text/javascript"></script>
	</head>

	<body class="body0">
		<div align="center">
		<form action="../../loginAction" target="_top" id="gotologin" ></form>
		<div id="dialog">
			<h2 id="subtitle"></h2>
			<p id="msg"></p>
		</div>
			<table class="table_path">
				<tr>
					<td align="left">
						您当前的位置：
						<a href="#"><span class="txtpath">系统管理</span> </a> &gt; 修改密码
				  </td>
					<td align="left">
						<span class="txtpath" id="info" style="color: red;"></span>
					</td>
					<td align="right">
						<script type="text/javascript">
										 today=new Date();
										 function initArray(){
										 this.length=initArray.arguments.length
										 for(var i=0;i<this.length;i++)
										 this[i+1]=initArray.arguments[i]  }
										 var d=new initArray(
											 " 星期日",
											 " 星期一",
											 " 星期二",
											 " 星期三",
											 " 星期四",
											 " 星期五",
											 " 星期六");
												document.write(
											 "",
											 today.getYear(),"年",
											 today.getMonth()+1,"月",
											 today.getDate(),"日 ",
											d[today.getDay()+1],
											 "" ); 
									</script>
					</td>
				</tr>
			</table>
			<form action="" id="form1">
				<table cellSpacing=1 cellPadding=2 class="table2">
					<tr align="middle">
					  <th align="right">旧密码：</th>
					  <td colspan="3" align="left" class="tr_s"
							onMouseOver="this.className='tr_o'"
							onMouseOut="this.className='tr_s'">
							<input type="password" name="oldPassword" id="oldPassword"/>
							<span id="oldPasswordTip"></span></td>
				  </tr>
					<tr align="middle">
						<th width="102" align="right">
							新密码：
						</th>
						<td width="380" align="left" class="tr_s"
							onMouseOver="this.className='tr_o'"
							onMouseOut="this.className='tr_s'">
					    <input type="password" name="password" id="password"/>
					    <span id="passwordTip"></span></td>
						<th width="132" align="right" nowrap>
							重复密码：
						</th>
						<td width="430" align="left" nowrap class="tr_s"
							onMouseOver="this.className='tr_o'"
							onMouseOut="this.className='tr_s'">
							<input type="password" name="repassword" id="repassword"/>
								<span id="repasswordTip"></span>
						</td>
					</tr>
				</table>
  </form>
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="table0">
				<tr>
					<td>
						<div align="center">
							<input id="save" type="button" class=btn_mouseout
								onMouseDown="this.className='btn_mousedown'"
								onMouseUp="this.className='btn_mouseup'"
								onMouseOver="this.className='btn_mouseover'"
								onMouseOut="this.className='btn_mouseout'" value="保存"/>
								<input id="reset" type="button" class=btn_mouseout
									onMouseDown="this.className='btn_mousedown'"
									onMouseUp="this.className='btn_mouseup'"
									onMouseOver="this.className='btn_mouseover'"
									onMouseOut="this.className='btn_mouseout'" value="清空"/>
						</div>
					</td>
				</tr>
				<tr>
					<td>&nbsp;
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
