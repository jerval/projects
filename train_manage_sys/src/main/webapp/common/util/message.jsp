<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />    
    <title>系统消息提示</title>
    <script type="text/javascript">
    	var mess = "${messageContent }"
    	if(mess != 'null' && mess != ""){
    		alert(mess);
    	}
    </script>
  </head>
  
  <body>
  </body>
</html>