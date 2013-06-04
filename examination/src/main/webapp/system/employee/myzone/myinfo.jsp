<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<link href="../../../style/styles.css" rel="stylesheet"
			type="text/css" />
	</head>

	<body class="body0">
		<div align="center">
			<table class="table_path">
				<tr>
					<td align="left">
						您当前的位置：我的地盘&gt; 我的信息详情
					</td>
					<td align="center"></td>
					<td align="right">
						<script type="text/javascript">
	today = new Date();
	function initArray() {
		this.length = initArray.arguments.length
		for ( var i = 0; i < this.length; i++)
			this[i + 1] = initArray.arguments[i]
	}
	var d = new initArray(" 星期日", " 星期一", " 星期二", " 星期三", " 星期四", " 星期五",
			" 星期六");
	document.write("", today.getYear(), "年", today.getMonth() + 1, "月", today
			.getDate(), "日 ", d[today.getDay() + 1], "");
</script>
					</td>
				</tr>
			</table>
			<table cellSpacing=1 cellPadding=2 class="table2">
				<tr align="middle">
					<th align="right">
						编号：
					</th>
					<td width="380" align="left" class="tr_s">
						<input type="text" value="<s:property value='myInfo.emp_id'/>" readonly="readonly" />
					</td>
					<th width="132" align="right" nowrap>
						姓名：
					</th>
					<td width="430" align="left" nowrap class="tr_s">
						<input name="emp_name" value="<s:property value='myInfo.emp_name'/>" type="text" id="emp_name"
							readonly="readonly" />
					</td>
				</tr>
				<tr align="middle">
					<th align="right">
						性别：
					</th>
					<td align="left" class="tr_s">
						<input name="gender" type="text" value="<s:property value='myInfo.gender'/>" id="gender" readonly="readonly" />
					</td>
					<th align="right" nowrap>
						所属部门：
					</th>
					<td align="left" nowrap class="tr_s">
						<input name="depart_name" value="<s:property value='myInfo.department.depart_name'/>" type="text" id="depart_name"
							readonly="readonly" />
					</td>
				</tr>
				<tr align="middle">
					<th align="right">
						级别：
					</th>
					<td align="left" class="tr_s">
						<input name="level" value="<s:property value='myInfo.level'/>" type="text" id="level" readonly="readonly" />
					</td>
					<th align="right" nowrap>
						生日：
					</th>
					<td align="left" nowrap class="tr_s">
						<input name="birthday" value="<s:property value='myInfo.strBirthday'/>" type="text" id="birthday"
							readonly="readonly" />
					</td>
				</tr>
				<tr align="middle">
					<th align="right">
						电话：
					</th>
					<td align="left" class="tr_s">
						<input name="phone" value="<s:property value='myInfo.phone'/>" type="text" id="phone" readonly="readonly" />
					</td>
					<th align="right" nowrap>
						Email：
					</th>
					<td align="left" nowrap class="tr_s">
						<input name="email" value="<s:property value='myInfo.email'/>" type="text" id="email" readonly="readonly" />
					</td>
				</tr>
				<tr align="middle">
					<th align="right">
						备用联系方式：
					</th>
					<td align="left" class="tr_s">
						<input name="contact" value="<s:property value='myInfo.contact'/>" type="text" id="contact" readonly="readonly" />
					</td>
					<th align="right" nowrap>
						部门管理人员：
					</th>
					<td align="left" nowrap class="tr_s">
						<input name="dep_manager" value="<s:property value='myInfo.dep_manager'/>" type="text" id="dep_manager"
							readonly="readonly" />
					</td>
				</tr>
				<tr align="middle">
					<th width="102" align="right">
						地址：
					</th>
					<td colspan="3" align="left" class="tr_s">
						<input name="address" value="<s:property value='myInfo.address'/>" type="text" id="address" size="60"
							readonly="readonly" />
					</td>
				</tr>
				<tr align="middle">
					<th nowrap bgcolor="#66FFFF">
						备注：
					</th>
					<td colspan="3" align="left" nowrap class="tr_s">
						<textarea name="memo" cols="60" rows="6" readonly="readonly"
							id="memo"><s:property value="myInfo.memo"/></textarea>
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="table0">
				<tr>
					<td></td>
				</tr>
			</table>
		</div>
		<s:debug></s:debug>
	</body>
</html>
