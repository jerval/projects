<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="../../../style/styles.css" rel="stylesheet"
			type="text/css"/>
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
	<script src="../../../js/pageOperate.js" type="text/javascript"></script>
<script type="text/javascript" src="myscore_list.js"></script>
</head>
<body class="body0">
<div align="center">
<div id="dialog">
			<h2 id="subtitle"></h2>
			<p id="msg"></p>
		</div>
  <table width="101%" class="table_path">
    <tr>
      <td align="left"> 您当前的位置： <a href="#"><span class="txtpath">成绩管理</span> </a> &gt; 我的成绩信息 </td>
      <td align="left"><span id="info" style="color:red"><img src="../../../images/loading.gif" align="middle"/>正在执行,请稍候...</span></td>
      <td align="right"><script type="text/javascript">
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
									</script></td>
    </tr>
  </table>
  <form id="queryForm" action="">
				<input type="hidden" id="pageNo" name="pageNo"/>
				<input type="hidden" id="pageSize" name="pageSize"/>
  </form>
                
  <table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="table0">
    <tr>
      <td align="left"><font color="#008080">
        
        </font></td>
      <td width="63%" align="left"><p align="right"> <font color="#008080" id="pageBar1"></font> <font color="#008080">&nbsp; 每页显示
          <input id="pagesize1" name="pagesize1"
											type="text" size="3"/>
          条
          <input id="show1" name="show"
								type="button" class=btn_mouseout
								onMouseDown="this.className='btn_mousedown'"
								onMouseUp="this.className='btn_mouseup'"
								onMouseOver="this.className='btn_mouseover'"
								onMouseOut="this.className='btn_mouseout'" value="显示"/>
          &nbsp; &nbsp; &nbsp; &nbsp;</font> <font color="#008080" id="pageOperateBar1"></font> <font color="#008080">&nbsp; 跳转
          <input id="page1" name="page1"
											type="text" size="4"/>
          页</font> </td>
      <td width="6%"><font color="#008080">
        <input id="go1" name="go1"
								type="button" class=btn_mouseout
								onMouseDown="this.className='btn_mousedown'"
								onMouseUp="this.className='btn_mouseup'"
								onMouseOver="this.className='btn_mouseover'"
								onMouseOut="this.className='btn_mouseout'" value="跳转"/>
        </font></td>
    </tr>
  </table>
  
  <table width="98%" cellPadding=2 cellSpacing=1 class="table1" id="table4">
				<thead>
				<tr>
					<th width="12%" scope="col">编号</th>
					<th width="15%" scope="col">所属员工编号</th>
					<th width="11%" scope="col">
					  所属员工姓名</th>
					<th width="14%" scope="col">所属试卷编号</th>
					<th width="14%" scope="col">所属试卷名称</th>
					<th width="19%" scope="col">作答日期</th>
					<th width="10%" scope="col">答卷用时(分钟)</th>
					<th width="5%" scope="col">成绩</th>
				  </tr>
				</thead>
			<tbody id="dataArea"></tbody>
			</table>
			
  
  <table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="table0">
    <tr>
      <td align="left"><font color="#008080">
        
        </font></td>
      <td width="63%" align="left"><p align="right"> <font color="#008080" id="pageBar2"></font> <font color="#008080">&nbsp; 每页显示
          <input id="pagesize2" name="pagesize2"
											type="text" size="3"/>
          条
          <input id="show2" name="show"
								type="button" class=btn_mouseout
								onMouseDown="this.className='btn_mousedown'"
								onMouseUp="this.className='btn_mouseup'"
								onMouseOver="this.className='btn_mouseover'"
								onMouseOut="this.className='btn_mouseout'" value="显示"/>
          &nbsp; &nbsp; &nbsp; &nbsp;</font> <font color="#008080" id="pageOperateBar2"></font> <font color="#008080">&nbsp; 跳转
          <input id="page2" name="page2"
											type="text" size="4"/>
          页</font> </td>
      <td width="6%"><font color="#008080">
        <input id="go2" name="button3"
								type="button" class=btn_mouseout
								onMouseDown="this.className='btn_mousedown'"
								onMouseUp="this.className='btn_mouseup'"
								onMouseOver="this.className='btn_mouseover'"
								onMouseOut="this.className='btn_mouseout'" value="跳转"/>
        </font></td>
    </tr>
  </table>
</div>
</body>
</html>
