<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.shopping.model.Goods"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>购物记录</title>

		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
<!--
body {
	background-color: #CCC;
}

.main {
	margin-top: 100;
	margin-left: 100;
	margin-right: 100;
}

body,td,th {
	font-family: 宋体;
	font-size: 13px;
	color: #06C;
}
-->
</style>
	</head>
	<body>
		<div class="main">
			<table width="600" border="0" cellpadding="10">
				<tr>
					<td width="210">
						商品编号
					</td>
					<td width="210">
						商品名称
					</td>
					<td width="224">
						商品价格
					</td>
					<td width="152">
						数量
					</td>
					<td width="152">
						操作
					</td>
				</tr>
				<%
					List list = (List) request.getSession().getAttribute("list");
					double totalPrice = 0;
					for (Object o : list) {
						Goods goods = (Goods) o;
				%>
				<tr>
					<td><%=goods.getId()%></td>
					<td><%=goods.getGoodsName()%></td>
					<td><%=goods.getPrice()%></td>
					<td><%=goods.getCount()%></td>
					<td><a href="<%=path%>/AddGoodsTOCar?id=<%=goods.getId()%>">删除</a></td>
				</tr>
				<%
					totalPrice = totalPrice + goods.getPrice() * goods.getCount();
					}
				%>
				<tr>
					<td colspan="5">
						共<%=list.size() %>种商品，总价格为:<%=totalPrice%>元</td>
				</tr>
			</table>

		</div>

	</body>
</html>
