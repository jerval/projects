<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<table width="100%">
  <tr> 
    <td align="right" >
    <script language=JavaScript>
		var today=new Date();
		function initArray(){
			this.length=initArray.arguments.length
			for(var i=0;i<this.length;i++)
			this[i+1]=initArray.arguments[i]  }
		var d=new initArray(" 星期日"," 星期一"," 星期二"," 星期三"," 星期四"," 星期五"," 星期六");
		document.write("",today.getYear(),"年",today.getMonth()+1,"月",
				today.getDate(),"日 ",d[today.getDay()+1],"" );
	</script></td>
  </tr>
</table>
