<%@ page language="java" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="/WEB-INF/pages/public/commons.jspf"%>
		<script type="text/javascript" src="${basePath }/widgets/jquery.treeview/lib/jquery.cookie.js"></script>
		<script type="text/javascript" src="${basePath }/widgets/jquery.treeview/jquery.treeview.js"></script>
		<link rel="stylesheet" href="${basePath }/widgets/jquery.treeview/jquery.treeview.css" />
		
		<script type="text/javascript">
			function doLogout(){
				var url = '<html:rewrite action="/user.do?method=logout"/>';
				if(window.confirm("您确定要注销吗？")){
					window.parent.location.href = url;
				}
			}	
			$(".menu").treeview({
				persist: "location",
				collapsed: true,
				unique: true
			});
		</script>
	</head>

	<body style="margin: 10px; font-size: 14px;">
		<ul class="menu treeview-famfamfam" style="list-style: disc;">
			<li><a href="javascript:doLogout()">注销 [${sessionScope["SESSION_LOGGED_ON_USER"].nickname}]</a></li>
			<li><html:link target="_parent" action='/portal?method=index'>论坛首页</html:link></li>
			<li>---------------</li>
			<li><html:link target="right" action='/manage/category?method=list'>版面管理</html:link></li>
			<li><html:link target="right" action='/manage/role?method=list'>角色管理</html:link></li>
			<li><html:link target="right" action='/manage/user?method=list'>会员管理</html:link></li>
			<li><html:link target="right" action='/manage/topicSearch?method=list'>主题搜索管理</html:link></li>
			<li><html:link target="right" action='/manage/blogLink?method=list'>博客链接管理</html:link></li>
			<li><a href='#'>系统设置</a></li>
		</ul>
	</body>
</html>
