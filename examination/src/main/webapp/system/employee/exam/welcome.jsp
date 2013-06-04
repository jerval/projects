<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
<link href="../../../style/css.css" rel="stylesheet" type="text/css">
<SCRIPT type="text/javascript">
function toExam(){
//	location.href='myExamAction!toExam';
	//if(){
	//}
}
</SCRIPT>
</head>
<body>
<table width="1002" height="100%" bgcolor="#FFFFFF" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top" bgcolor="#FFFFFF"><table width="1032" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
        <tr>
          <td height="200" colspan="5"><div align="center"><span class="style4"><span class="text"><img src="../../../img/1-2.jpg" width="53" height="59" align="middle">
          <span style="color:red;"><s:property value="#session.operateEmployee.emp_name"/></span> 您好！欢迎使用信息安全知识在线考核平台！您的员工号是：<s:property value="#session.operateEmployee.emp_id"/></span> &nbsp;&nbsp;
              <input type="button" name="button" value="成绩查询"onClick="window.open('Report.htm')">
              </span></div></td>
        </tr>
        <tr>
          <td colspan="2">
            <div align="center"></div></td>
          <td height="100"><p class="text">信息安全知识考核是为了普及公司员工的信息安全意识，了解公司信息安全规定。<br>
              试题类型包含多项选择和单项选择，共计<s:property value=""/>题，每题5分，满分100分.考核时间：<s:property value="examPaper.answerTime"/>分钟.。考试过程中不允许回退，如需终止考试，请按[退出]按钮。</p></td>
          <td height="0" width="20%">&nbsp;</td>
        </tr>
        <tr>
          <td height="80" colspan="4" align="left" valign="top"><p align="center"> <span class="text" style="color:red">考试时间为<s:property value="examPaper.answerTime"/>分钟</span>&nbsp;<br/>
           <span class="text">显示模式：
           <input type="radio" name="showmodel" id="all" value="all">
           全部
           <input type="radio" name="showmodel" id="one" value="one" checked>单一
           </span>
           <br/>
              <input type="submit" name="Submit" value="开始考试" onClick="location.href='myExamAction!toExam'">
              &nbsp;
              <input type="button" name="button2" value="退出" onClick="location.href='../employeeIndex'">
            </p></td>
        </tr>
        <tr>
          <td height="70" colspan="5" align="center" background="../../../img/buttom.jpg" class="text buttom"></td>
        </tr>
      </table></td>
  </tr>
</table>
<s:debug></s:debug>
</body>
</html>
