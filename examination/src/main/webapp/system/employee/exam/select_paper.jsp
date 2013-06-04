<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<link href="../../../style/styles.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="../../../js/jquery-1.4.2.js"></script>
		<script src="../../../js/pageOperate.js" type="text/javascript"></script>
		<script type="text/javascript" src="selcet_paper.js"></script>
	</head>
	<body class="body0">
		<div align="center">
			<div id="dialog">
				<h2 id="subtitle"></h2>
				<p id="msg"></p>
			</div>
			<table width="101%" class="table_path">
				<tr>
					<td align="left">
						您当前的位置：
						<a href="#"><span class="txtpath">选择试卷</span> </a> &gt; 试卷列表
					</td>
					<td align="left">
						<span id="info" style="color: red"><img
								src="../../../images/loading.gif" align="middle" />正在执行,请稍候...</span>
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
			<form action="myExamAction!toWelcome" method="post" id="form1"
				target="_top">
				<input id="paper_id" name="examPaper.paper_id" type="hidden">
			</form>
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="table0">
				<tr>
					<td align="left">

					</td>
					<td width="63%" align="left">
						<p align="right">
							<font color="#008080" id="pageBar1"></font>
							<font color="#008080">&nbsp; 每页显示 <input id="pagesize1"
									name="pagesize1" type="text" size="3" /> 条 <input id="show1"
									name="show" type="button" class=btn_mouseout
									onMouseDown="this.className='btn_mousedown'"
									onMouseUp="this.className='btn_mouseup'"
									onMouseOver="this.className='btn_mouseover'"
									onMouseOut="this.className='btn_mouseout'" value="显示" />
								&nbsp; &nbsp; &nbsp; &nbsp;</font>
							<font color="#008080" id="pageOperateBar1"></font>
							<font color="#008080">&nbsp; 跳转 <input id="page1"
									name="page1" type="text" size="4" /> 页</font>
					</td>
					<td width="6%">
						<font color="#008080"> <input id="go1" name="go1"
								type="button" class=btn_mouseout
								onMouseDown="this.className='btn_mousedown'"
								onMouseUp="this.className='btn_mouseup'"
								onMouseOver="this.className='btn_mouseover'"
								onMouseOut="this.className='btn_mouseout'" value="跳转" /> </font>
					</td>
				</tr>
			</table>

			<table cellSpacing=1 cellPadding=2 class="table1" id="table4">
				<thead>
					<tr>
						<th width="13%" scope="col">
							试卷编号
						</th>
						<th width="20%" scope="col">
							试卷名称
						</th>
						<th width="11%" scope="col">
							作答时间(分钟)
						</th>
						<th width="41%" scope="col">
							试卷简介
						</th>
						<th width="15%" scope="col">
							操作
						</th>
					</tr>
				</thead>
				<tbody id="dataArea"></tbody>
			</table>

			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="table0">
				<tr>
					<td align="left">

					</td>
					<td width="63%" align="left">
						<p align="right">
							<font color="#008080" id="pageBar2"></font>
							<font color="#008080">&nbsp; 每页显示 <input id="pagesize2"
									name="pagesize2" type="text" size="3" /> 条 <input id="show2"
									name="show" type="button" class=btn_mouseout
									onMouseDown="this.className='btn_mousedown'"
									onMouseUp="this.className='btn_mouseup'"
									onMouseOver="this.className='btn_mouseover'"
									onMouseOut="this.className='btn_mouseout'" value="显示" />
								&nbsp; &nbsp; &nbsp; &nbsp;</font>
							<font color="#008080" id="pageOperateBar2"></font>
							<font color="#008080">&nbsp; 跳转 <input id="page2"
									name="page2" type="text" size="4" /> 页</font>
					</td>
					<td width="6%">
						<font color="#008080"> <input id="go2" name="button3"
								type="button" class=btn_mouseout
								onMouseDown="this.className='btn_mousedown'"
								onMouseUp="this.className='btn_mouseup'"
								onMouseOver="this.className='btn_mouseover'"
								onMouseOut="this.className='btn_mouseout'" value="跳转" /> </font>
					</td>
				</tr>
			</table>
			<form id="queryForm" action="">
				<input type="hidden" id="pageNo" name="pageNo" />
				<input type="hidden" id="pageSize" name="pageSize" />
			</form>
		</div>
	</body>
</html>
