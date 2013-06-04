<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>系统登录</title>
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		<script type="text/javascript" src="js/login.js"></script>
		<link rel="stylesheet" type="text/css" href="css/login.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="main_container">
			<div id="header">
				<div id="logo">
				</div>
				<div class="banner_adds">
				</div>
			</div>
			<div id="main_content">
				<div class="admin_login">
					<div class="left_box">
						<div class="top_left_box">
						</div>
						<div class="center_left_box">
							<div class="box_title">
								<span>系统登录</span>
							</div>
							<form id="loginForm" action="loginAction!login" method="post">
								<div class="form">
									<div class="form_row">
										<label class="left">
											用 户:
										</label>
										<input name="username" type="text" class="form_input"
											id="username" />
									</div>
									<div class="form_row">
										<label class="left">
											密 码:
										</label>
										<input name="password" type="password" class="form_input"
											id="password" />
									</div>

									<div style="float: right; padding: 10px 25px 0 0;">
										<img id="login" src="images/login.gif" />
									</div>
									<div style="float: right; padding: 10px 0 0 0;">
										<span class="error"><s:actionerror /> </span>
									</div>
								</div>
							</form>
						</div>
						<div class="bottom_left_box">
						</div>
					</div>
				</div>
			</div>
			<!-- end of main_content -->

			<div id="footer">
				<div id="copyright">
					<div style="float: left; padding: 3px;">
						<a href="#"><img src="images/_logo.gif" width="174"
								height="60" alt="" title="" border="0" /> </a>
					</div>
					<div style="float: left; padding: 30px 10px 10px 10px;">
						杰威网络.&copy; All Rights Reserved 2010
					</div>
				</div>
			</div>
		<!-- end of main_container -->
		</div>
	</body>
</html>