<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
		<link href="../../../style/styles.css" rel="stylesheet" type="text/css"/>
		<link type="text/css" rel="stylesheet" href="../../../style/validator.css"/>
	</head>

	<body class="body0">
		<div align="center">
		<div id="dialog">
			<h2 id="subtitle"></h2>
			<p id="msg"></p>
		</div>
			<table class="table_path">
				<tr>
					<td align="left">
						您当前的位置：
						<a href="#"><span class="txtpath">部门管理</span></a> &gt; 编辑部门信息
					</td>
					<td align="left">
						<span class="txtpath" id="info" style="color:red;"></span>
					</td>
					<td align="right">
						<script language=JavaScript>
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
						<th width="102" align="right">
							部门编号：
						</th>
						<td width="380" align="left" class="tr_s"
							onMouseOver="this.className='tr_o'"
							onMouseOut="this.className='tr_s'">
							<input type="text" name="depart_id" id="depart_id"/>
							<span id="depart_idTip"></span>
							<input type="hidden" id="id" name="id"/>
							<input type="hidden" id="version" name="version"/>
						</td>
						<th width="132" align="right" nowrap>
							部门名称：
						</th>
						<td width="430" align="left" nowrap class="tr_s"
							onMouseOver="this.className='tr_o'"
							onMouseOut="this.className='tr_s'">
							<input type="text" name="depart_name" id="depart_name"/>
							<span id="depart_nameTip"></span>
						</td>
					</tr>
					<tr align=middle>
						<th nowrap bgcolor="#66FFFF">
							简介：
						</th>
						<td colspan="3" align="left" nowrap class="tr_s"
							onMouseOver="this.className='tr_o'"
							onMouseOut="this.className='tr_s'">
							<textarea name="depart_info" id="depart_info" cols="60" rows="6"></textarea>
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
				</table>
			
		</div>
	</body>
</html>
