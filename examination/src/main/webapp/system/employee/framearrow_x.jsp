<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<SCRIPT type="text/javascript">
<!--

var screen=false;
function shiftwindow_x()
{
if(screen==false)
{
parent.ind.rows='0,8,*';screen=true;
splitbtn.src = '../../images/showbutton_x.gif'; 
}
else if(screen==true)
{
	parent.ind.rows='71,8,*';screen=false;
	splitbtn.src = '../../images/shidebutton_x.gif';
}

}
//-->
</SCRIPT>
</HEAD>
<BODY leftMargin=0 topMargin=0>
<table border="0" width="100%" id="table1" cellspacing="0" cellpadding="0" height="8" background="../../images/ge_bg1.gif">
	<tr>
		<td align="center" width="180"><A style ="cursor:hand;"><IMG 
            src="../../images/shidebutton_x.gif"
      border=0 id=splitbtn onclick=shiftwindow_x()></A></td>
		<td> </td>
	</tr>
</table>

</BODY></HTML>