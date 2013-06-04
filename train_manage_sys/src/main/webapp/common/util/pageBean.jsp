<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>分页页面</title>
    <script type="text/javascript">
  		function goToIndex(index){
  			var myQueryForm = document.getElementById("queryForm");
  			var pageNo = $("#pageNo");
  			var maxPages = $("#maxPages").val();
  			switch(index){
  				case 0:
  					if(pageNo.val() == 1){
  						alert("当前已经是第一页。");
  						return;
  					}else{
  						pageNo.val("1");
  					}
  					break;
  				case -1:
  					if(pageNo.val() == 1){
  						alert("当前已经是第一页。");
  						return;
  					}else{
  						pageNo.val(parseInt(pageNo.val())-1);
  					}
  					break;
  				case 1:
  					if(pageNo.val() == maxPages){
  						alert("当前已经是最后一页。");
  						return;
  					}else{
  						pageNo.val(parseInt(pageNo.val())+1);
  					}
  					break;
  				case 2:
  					if(pageNo.val() == maxPages){
  						alert("当前已经是最后一页。");
  						return;
  					}else{
  						pageNo.val(maxPages);
  					}
  			}
  			myQueryForm.submit();
  		}
  	</script>
  </head>
  
  <body>
    <table align="center" width="100%">
    	<tr align="center">
			<td width="30%">共&nbsp;<s:property value="pagination.maxElements" />&nbsp;条数据</td>
    		<td width="50">&nbsp;<a href="#" onclick="goToIndex(0);return false;">首页</a>&nbsp;</td>
    		<td width="80">&nbsp;<a href="#" onclick="goToIndex(-1);return false;">上一页</a>&nbsp;</td>
    		<td width="80">&nbsp;<a href="#" onclick="goToIndex(1);return false;">下一页</a>&nbsp;</td>
    		<td width="50">&nbsp;<a href="#" onclick="goToIndex(2);return false;">尾页</a>&nbsp;</td>
    		<td width="30%">第&nbsp;<s:property value="pagination.pageNo" />&nbsp;页/共&nbsp;<s:property value="pagination.maxPages" />&nbsp;页</td>
    	</tr>
    </table>
  </body>
</html>
