<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<SCRIPT type="text/javascript">
<!--

var screen=false;
function shiftwindow()
{
if(screen==false)
{
parent.ind.cols='0,8,*';screen=true;
splitbtn.src = '../../images/showbutton.gif'; 
}
else if(screen==true)
{
	parent.ind.cols='180,8,*';screen=false;
	splitbtn.src = '../../images/shidebutton.gif';
}

}
//-->
</SCRIPT>

</HEAD>
<BODY leftMargin=0 topMargin=0>
<TABLE height="100%" cellSpacing=0 cellPadding=0 border=0>
  <TBODY>
  <TR>
    <TD background="../../images/ge_bg2.gif">
      <TABLE cellSpacing=0 cellPadding=0 width=8 border=0>
        <TBODY>
        <TR>
          <TD><A style ="cursor:hand;"><IMG 
            src="../../images/shidebutton.gif"
      border=0 id=splitbtn onclick=shiftwindow()></A></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></BODY></HTML>

