<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../../style/styles.css" rel="stylesheet" type="text/css">
<base target="mainframe">
<title>目录树</title>
<script type="text/javascript"> 
	<!-- 
	var old_menu0 = ''; 
	function menuclick0( submenu0) 
	{ 
	if( old_menu0 != submenu0 ){ 
	if( old_menu0 !='' ){ 
	old_menu0.style.display = 'none'; 
	} 
	submenu0.style.display = 'block'; 
	old_menu0 = submenu0; 

	}else{ 
	submenu0.style.display = 'none'; 
	old_menu0 = ''; 
	} 
	} 
	
	var old_menu1 = ''; 
	function menuclick1( submenu1) 
	{ 
	if( old_menu1 != submenu1 ){ 
	if( old_menu1 !='' ){ 
	old_menu1.style.display = 'none'; 
	} 
	submenu1.style.display = 'block'; 
	old_menu1 = submenu1; 

	}else{ 
	submenu1.style.display = 'none'; 
	old_menu1 = '';
	} 
	} 
	
	function MM_preloadImages(){
	// v3.0 
	var d=document; if(d.images){if(!d.MM_p) d.MM_p=new Array(); 
	var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++) 
	if (a[i].indexOf("#")!=0){d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}} 
	} 

	function MM_findObj(n, d){
	// v3.0 
	var p,i,x; if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length){ 
	d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);} 
	if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n]; 
	for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document); return x; 
	} 

	function MM_nbGroup(event, grpName){
	// v3.0 
	var i,img,nbArr,args=MM_nbGroup.arguments; 
	if (event == "init" && args.length > 2){ 
	if ((img = MM_findObj(args[2])) != null && !img.MM_init){ 
	img.MM_init = true; img.MM_up = args[3]; img.MM_dn = img.src; 
	if ((nbArr = document[grpName]) == null) nbArr = document[grpName] = new Array(); 
	nbArr[nbArr.length] = img; 
	for (i=4; i < args.length-1; i+=2) if ((img = MM_findObj(args[i])) != null){ 
	if (!img.MM_up) img.MM_up = img.src; 
	img.src = img.MM_dn = args[i+1]; 
	nbArr[nbArr.length] = img; 
	}} 
	}else if (event == "over"){ 
	document.MM_nbOver = nbArr = new Array(); 
	for (i=1; i < args.length-1; i+=3) if ((img = MM_findObj(args[i])) != null){ 
	if (!img.MM_up) img.MM_up = img.src; 
	img.src = (img.MM_dn && args[i+2]) ? args[i+2] : args[i+1]; 
	nbArr[nbArr.length] = img; 
	} 
	}else if (event == "out" ){ 
	for (i=0; i < document.MM_nbOver.length; i++){ 
	img = document.MM_nbOver[i]; img.src = (img.MM_dn) ? img.MM_dn : img.MM_up;} 
	}else if (event == "down"){ 
	if ((nbArr = document[grpName]) != null) 
	for (i=0; i < nbArr.length; i++){img=nbArr[i]; img.src = img.MM_up; img.MM_dn = 0;} 
	document[grpName] = nbArr = new Array(); 
	for (i=2; i < args.length-1; i+=2) if ((img = MM_findObj(args[i])) != null){ 
	if (!img.MM_up) img.MM_up = img.src; 
	img.src = img.MM_dn = args[i+1]; 
	nbArr[nbArr.length] = img; 
	}} 
	} 
	//--> 
	</script>
</head>
<body topmargin="0" leftmargin="0" style="BACKGROUND: url('../../images/leftbg.jpg');background-position: bottom;overflow-x:hidden;overflow-y:hidden;">
<table border="0" width="180" id="table6" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td valign="top"><table border="0" width="180" id="table2" cellspacing="2" cellpadding="0">
        <tr>
          <td><div align="center">
              <table border="0" width="160" id="table3" cellspacing="0" cellpadding="0">
                <tr valign="middle" >
                  <td height="27" valign="top" style="cursor:hand;"  onclick="menuclick0(submenu0100);"><div align="center">
                      <table width="100%" height="24" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#99CCFF">
                        <tr>
                          <td valign="bottom"><div align="center"><font color="#666666" size="2" face="宋体"><span style="color:red;"><s:property value="#session.operateUser.username"/></span> ，您好</font></div></td>
                        </tr>
                      </table>
                    </div></td>
                </tr>
                
                <!-- 部门管理 -->
                <tr id="departMgr">
                  <td height="23" background="../../images/box_top.gif" style="cursor:hand;"  onclick="menuclick0(submenu0100);">　<font color="#ffffff"><img src="../../images/sub1_001.gif" border="0" width="16" height="16" align="absmiddle"> </font> <font color="#000080"> <b>部门管理</b></font></td>
                </tr>
                <tr>
                  <td><table id="submenu0100" style="display:none;" border="0" width="100%" cellspacing="0" cellpadding="0" >
                      <tr>
                        <td background="../../images/box_mid.gif">&nbsp;&nbsp;&nbsp;&nbsp; <a style="text-decoration: none;" href="department/department_add.html"><img border="0" src="../../images/page.gif" width="16" height="16"> 添加部门信息</a><br>
                          &nbsp;&nbsp;&nbsp;&nbsp; <a style="text-decoration: none;" href="department/department_list.html"><img border="0" src="../../images/page.gif" width="16" height="16"> 部门信息列表</a><br></td>
                      </tr>
                      <tr>
                        <td><img border="0" src="../../images/box_footer.gif" width="160" height="8"></td>
                      </tr>
                    </table></td>
                </tr>
                <tr id="departMgr_margin">
                  <td height="4"></td>
                </tr>
                <!-- 员工管理 -->
                <tr id="empMgr">
                  <td height="23" background="../../images/box_top.gif" style="cursor:hand;"  onclick="menuclick0(submenu0200);">　<font color="#ffffff"><img src="../../images/sub1_001.gif" border="0" width="16" height="16" align="absmiddle"> </font> <font color="#000080"> <b>员工管理</b></font></td>
                </tr>
                <tr>
                  <td><table id="submenu0200" style="display:none;" border="0" width="100%" cellspacing="0" cellpadding="0" >
                      <tr>
                        <td background="../../images/box_mid.gif">&nbsp;&nbsp;&nbsp;&nbsp; <a style="text-decoration: none;" href="employee/employee_add.html"><img border="0" src="../../images/page.gif" width="16" height="16"> 添加员工信息</a><br>
                          &nbsp;&nbsp;&nbsp;&nbsp; <a style="text-decoration: none;" href="employee/employee_list.html"><img border="0" src="../../images/page.gif" width="16" height="16"> 员工列表</a><br></td>
                      </tr>
                      <tr>
                        <td><img border="0" src="../../images/box_footer.gif" width="160" height="8"></td>
                      </tr>
                    </table></td>
                </tr>
                <tr id="empMgr_margin">
                  <td height="4"></td>
                </tr>
                <!-- 试卷管理-->
                <tr id="paperMgr">
                  <td height="23" background="../../images/box_top.gif" style="cursor:hand;"  onclick="menuclick0(submenu0300);">　<font color="#ffffff"><img src="../../images/sub1_001.gif" border="0" width="16" height="16" align="absmiddle"> </font> <font color="#000080"> <b>试卷管理</b></font></td>
                </tr>
                <tr>
                  <td><table id="submenu0300" style="display:none;" border="0" width="100%" cellspacing="0" cellpadding="0" >
                      <tr>
                        <td background="../../images/box_mid.gif">&nbsp;&nbsp;&nbsp;&nbsp; <a style="text-decoration: none;" href="exampaper/exam_paper_add.html"><img border="0" src="../../images/page.gif" width="16" height="16"> 添加试卷信息</a><br>
                          &nbsp;&nbsp;&nbsp;&nbsp; <a style="text-decoration: none;" href="exampaper/exam_paper_list.html"><img border="0" src="../../images/page.gif" width="16" height="16"> 试卷列表</a><br></td>
                      </tr>
                      <tr>
                        <td><img border="0" src="../../images/box_footer.gif" width="160" height="8"></td>
                      </tr>
                    </table></td>
                </tr>
                <tr id="paperMgr_margin">
                  <td height="4"></td>
                </tr>
                <!--试题管理 -->
                <tr id="quesMgr">
                  <td height="23" background="../../images/box_top.gif" style="cursor:hand;"  onclick="menuclick0(submenu0400);">　<font color="#ffffff"><img src="../../images/sub1_001.gif" border="0" width="16" height="16" align="absmiddle"> </font> <font color="#000080"> <b>试题管理</b></font></td>
                </tr>
                <tr>
                  <td><table id="submenu0400" style="display:none;" border="0" width="100%" cellspacing="0" cellpadding="0" >
                      <tr>
                        <td background="../../images/box_mid.gif">&nbsp;&nbsp;&nbsp;&nbsp; <a style="text-decoration: none;" href="examquestion/exam_question_add.html"><img border="0" src="../../images/page.gif" width="16" height="16"> 添加试题</a><br>
                          &nbsp;&nbsp;&nbsp;&nbsp; <a style="text-decoration: none;" href="examquestion/exam_question_list.html"><img border="0" src="../../images/page.gif" width="16" height="16"> 试题列表</a><br></td>
                      </tr>
                      <tr>
                        <td><img border="0" src="../../images/box_footer.gif" width="160" height="8"></td>
                      </tr>
                    </table></td>
                </tr>
                <tr id="quesMgr_margin">
                  <td height="4"></td>
                </tr>
                <!-- 试题答案选项管理-->
                <tr id="keyMgr">
                  <td height="23" background="../../images/box_top.gif" style="cursor:hand;"  onclick="menuclick0(submenu0500);">　<font color="#ffffff"><img src="../../images/sub1_001.gif" border="0" width="16" height="16" align="absmiddle"> </font> <font color="#000080"> <b>试题答案选项管理</b></font></td>
                </tr>
                <tr>
                  <td><table id="submenu0500" style="display:none;" border="0" width="100%" cellspacing="0" cellpadding="0" >
                      <tr>
                        <td background="../../images/box_mid.gif">&nbsp;&nbsp;&nbsp;&nbsp; <a style="text-decoration: none;" href="examkey/exam_key_add.html"><img border="0" src="../../images/page.gif" width="16" height="16"> 添加试题答案</a><br>
                          &nbsp;&nbsp;&nbsp;&nbsp; <a style="text-decoration: none;" href="examkey/exam_key_list.html"><img border="0" src="../../images/page.gif" width="16" height="16"> 试题答案列表</a><br></td>
                      </tr>
                      <tr>
                        <td><img border="0" src="../../images/box_footer.gif" width="160" height="8"></td>
                      </tr>
                    </table></td>
                </tr>
                <tr id="keyMgr_margin">
                  <td height="4"></td>
                </tr>
                <!-- 成绩管理-->
                <tr id="scoreMgr">
                  <td height="23" background="../../images/box_top.gif" style="cursor:hand;"  onclick="menuclick0(submenu0600);">　<font color="#ffffff"><img src="../../images/sub1_001.gif" border="0" width="16" height="16" align="absmiddle"> </font> <font color="#000080"> <b>成绩管理</b></font></td>
                </tr>
                <tr>
                  <td><table id="submenu0600" style="display:none;" border="0" width="100%" cellspacing="0" cellpadding="0" >
                      <tr>
                        <td background="../../images/box_mid.gif">&nbsp;&nbsp;&nbsp;&nbsp; 
                          <a style="text-decoration: none;" href="examscore/exam_score_list.html"><img border="0" src="../../images/page.gif" width="16" height="16"> 成绩信息列表</a><br></td>
                      </tr>
                      <tr>
                        <td><img border="0" src="../../images/box_footer.gif" width="160" height="8"></td>
                      </tr>
                    </table></td>
                </tr>
                <tr id="scoreMgr_margin">
                  <td height="4"></td>
                </tr>
                
                <!-- 用户管理-->
                <tr id="userMgr">
                  <td height="23" background="../../images/box_top.gif" style="cursor:hand;"  onclick="menuclick0(submenu0700);">　<font color="#ffffff"><img src="../../images/sub1_001.gif" border="0" width="16" height="16" align="absmiddle"> </font> <font color="#000080"> <b>用户管理</b></font></td>
                </tr>
                <tr>
                  <td><table id="submenu0700" style="display:none;" border="0" width="100%" cellspacing="0" cellpadding="0" >
                      <tr>
                        <td background="../../images/box_mid.gif">&nbsp;&nbsp;&nbsp;&nbsp; <a style="text-decoration: none;" href="user/user_add.html"><img border="0" src="../../images/page.gif" width="16" height="16"> 添加用户</a><br>
                          &nbsp;&nbsp;&nbsp;&nbsp; <a style="text-decoration: none;" href="user/user_list.html"><img border="0" src="../../images/page.gif" width="16" height="16"> 查看所有用户</a><br></td>
                      </tr>
                      <tr>
                        <td><img border="0" src="../../images/box_footer.gif" width="160" height="8"></td>
                      </tr>
                    </table></td>
                </tr>
                <tr id="userMgr_margin">
                  <td height="4"></td>
                </tr>
                
                <!-- 系统管理-->
                <tr id="sysMgr">
                  <td height="23" background="../../images/box_top.gif" style="cursor:hand;"  onclick="menuclick0(submenu0800);">　<font color="#ffffff"><img src="../../images/sub1_001.gif" border="0" width="16" height="16" align="absmiddle"> </font> <font color="#000080"> <b>系统管理</b></font></td>
                </tr>
                <tr>
                  <td><table id="submenu0800" style="display:none;" border="0" width="100%" cellspacing="0" cellpadding="0" >
                      <tr>
                        <td background="../../images/box_mid.gif">&nbsp;&nbsp;&nbsp;&nbsp; <a style="text-decoration: none;" href="sys/sys_updatePassword.html"><img border="0" src="../../images/page.gif" width="16" height="16"> 修改密码</a><br>
                          &nbsp;&nbsp;&nbsp;&nbsp; <a id="logout"  target="_top" style="text-decoration: none;" href="../loginAction!logout"><img border="0" src="../../images/page.gif" width="16" height="16"> 注销</a><br>
                          &nbsp;&nbsp;&nbsp;&nbsp; <a style="text-decoration: none;" href="sys/sys_help.html"><img border="0" src="../../images/page.gif" width="16" height="16"> 帮助</a><br></td>
                      </tr>
                      <tr>
                        <td><img border="0" src="../../images/box_footer.gif" width="160" height="8"></td>
                      </tr>
                    </table></td>
                </tr>
                <tr id="sysMgr_margin">
                  <td height="4"></td>
                </tr>
                
                <!-- 日志管理-->
                <tr id="logMgr">
                  <td height="23" background="../../images/box_top.gif" style="cursor:hand;"  onclick="menuclick0(submenu0900);">　<font color="#ffffff"><img src="../../images/sub1_001.gif" border="0" width="16" height="16" align="absmiddle"> </font> <font color="#000080"> <b>日志管理</b></font></td>
                </tr>
                <tr>
                  <td><table id="submenu0900" style="display:none;" border="0" width="100%" cellspacing="0" cellpadding="0" >
                      <tr>
                        <td background="../../images/box_mid.gif">&nbsp;&nbsp;&nbsp;&nbsp; <a style="text-decoration: none;" href="../../system/manager/reader/reader_list.jsp"><img border="0" src="../../images/page.gif" width="16" height="16"> 查看日志</a><br></td>
                      </tr>
                      <tr>
                        <td><img border="0" src="../../images/box_footer.gif" width="160" height="8"></td>
                      </tr>
                    </table></td>
                </tr>
                <tr id="logMgr_margin">
                  <td height="4"></td>
                </tr>
               
                <tr>
                  <td>&nbsp;</td>
                </tr>
              </table>
            </div></td>
        </tr>
      </table></td>
  </tr>
</table>
</html>