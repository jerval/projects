<%@ page pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>后台管理</title>
		<%@ include file="/WEB-INF/pages/public/commons.jspf"%>
	</head>

	<frameset border="0" rows="70px,20px,*" border="0" id="framesetRows">
		<frame name="top" src="${basePath }/manage/portal.do?method=forward&jsp=top" noresize="noresize" scrolling="no"></frame>
		<frame name="top" src="${basePath }/manage/portal.do?method=forward&jsp=top2" noresize="noresize" scrolling="no"></frame>
		<frameset cols="200px,17px,*" border="0" id="framesetCols">
			<frame name="left" src="${basePath }/manage/portal.do?method=forward&jsp=left" noresize="noresize"></frame>
			<frame name="middle" src="${basePath }/manage/portal.do?method=forward&jsp=middle" noresize="noresize" scrolling="no"></frame>
			<frame name="right" src="${basePath }/manage/portal.do?method=forward&jsp=right" noresize="noresize"></frame>
		</frameset>
	</frameset>
</html>
