<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>

<link href="../../../style/css.css" rel="stylesheet" type="text/css">

</head>
<body>
<table width="1002" height="100%" bgcolor="#FFFFFF" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top" bgcolor="#FFFFFF"><table width="1002" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
        <td colspan="2"><img src="../../../img/buttom.jpg" width="1002" height="90"></td>
      </tr>
      <tr>
        <td height="100%" colspan="2" align="center" valign="middle"><table width="439" height="293" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td background="../../../img/bey.gif"><p>&nbsp;</p>
                <p>&nbsp;</p>
                <table width="301" height="35" border="0" align="center" class="thin">
                
                <tr>
                  <td width="97" height="25" class="td2">&nbsp;您的成绩是:</td>
                  <td width="194" class="td2">&nbsp;<img src="../../../img/good.gif" width="26" height="25" align="absmiddle">
<s:property value="score"/>
</td>
                  </tr>
                
              </table>
<br>
<p align=center><input type='button' onClick="location.href='../employeeIndex'" value=" 退 出 "></p>

</td>
            </tr>
          </table></td>
      </tr>
	  <tr>
	    <td height="70" colspan="2" align="center" background="../../../img/buttom.jpg" class="text buttom"></td>
	  </tr>
    </table></td>
  </tr>
</table>
<s:debug></s:debug>
</body>
</html>
