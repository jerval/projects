<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/main.css" />
	</head>
	<body>
		<div class="column1">
			<div class="left_box">
				<div class="top_left_box"></div>
				<div class="center_left_box">
					<div class="center_left_box_content">
						<a href="department/departmentAction!findAll" target="mainFrame">系别管理</a>
					</div>
					<div class="center_left_box_content">
						<a href="#">年级管理</a>
					</div>
					<div class="center_left_box_content">
						<a href="#">班级管理</a>
					</div>
					<div class="center_left_box_content">
						<a href="#">学生管理</a>
					</div>
					<hr />
					<div class="center_left_box_content">
						<a href="#">修改登陆密码</a>
					</div>
					<div class="center_left_box_content">
						<a href="#">退出系统</a>
					</div>
					<s:if test="#session.user.typeString=='ADMIN'">
						<hr />
						<div class="center_left_box_content">
							<a href="#">用户管理</a>
						</div>
					</s:if>
				</div>
			</div>
			<div class="bottom_left_box"></div>
		</div>
	</body>
</html>
