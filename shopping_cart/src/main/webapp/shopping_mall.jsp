<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<title>购物中心</title>
     <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  <style type="text/css">
<!--
body {
	background-color: #CCC;
}
.main{
	margin-top:100;
	margin-left:100;
	margin-right:100;
}
form{
	padding-left:150;
	text-align:left;
}
body,td,th {
	font-family: 宋体;
	font-size: 13px;
	color: #06C;
}
-->
</style>
  <script src="SpryAssets/SpryValidationTextField.js" type="text/javascript"></script>
  <link href="SpryAssets/SpryValidationTextField.css" rel="stylesheet" type="text/css">
</head>
  
  <body>
  <div class="main">
    <form name="form1" method="post" action="<%=path%>/AddGoodsTOCar">
    <p>商品编号：     
       <input name="id" type="text" id="id" value="0001" size="12" readonly="readonly">
     </p>
     <p>商品名称：     
       <input name="goodsname" type="text" id="goodsname" value="耐克上衣" size="16" readonly="readonly">
     </p>
    <p>商品单价：
      <input name="price" type="text" id="price" value="299.00" size="10" readonly="readonly">
      元/件 </p>
    <p>商品数量：
      <span id="sprytextfield1">
      <input name="count" type="text" id="count" size="6">
      <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldInvalidFormatMsg">格式无效。</span></span> 件</p>
    <p>商品描述：是一个好东西</p>
    <p>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="submit" name="button" id="button" value="购买">
    </p>
    </form>
<p>&nbsp;</p>
   <form name="form2" method="post" action="<%=path%>/AddGoodsTOCar">
   <p>商品编号：     
       <input name="id" type="text" id="id" value="0002" size="12" readonly="readonly">
     </p>
     <p>商品名称： 
       <input name="goodsname" type="text" id="goodsname" value="阿迪运动鞋" size="16">
     </p>
    <p>商品单价：
      <input name="price" type="text" id="price" value="239.00" size="10" readonly="readonly">
     元/双 </p>
    <p>商品数量：
      <span id="sprytextfield2">
      <input name="count" type="text" id="count" size="6">
     <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldInvalidFormatMsg">格式无效。</span></span> 双</p>
    <p>商品描述：是一个好东西</p>
    <p>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="submit" name="button" id="button" value="购买">
    </p>
    </form>
    <p>&nbsp;</p> 
   <form name="form3" method="post" action="<%=path%>/AddGoodsTOCar">
   <p>商品编号：     
       <input name="id" type="text" id="id" value="0003" size="12" readonly="readonly">
     </p>
     <p>商品名称：     
       <input name="goodsname" type="text" id="goodsname" value="Dell电脑" size="16" readonly="readonly">
     </p>
    <p>商品单价：
      <input name="price" type="text" id="price" value="5999.00" size="10" readonly="readonly">
     元/台 </p>
    <p>商品数量：
      <span id="sprytextfield3">
      <input name="count" type="text" id="count" size="6">
     <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldInvalidFormatMsg">格式无效。</span></span> 台</p>
    <p>商品描述：是一个好东西</p>
    <p>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="submit" name="button" id="button" value="购买">
    </p>
    </form>
    <p>&nbsp;</p> 
    <form name="form4" method="post" action="<%=path%>/AddGoodsTOCar">
    <p>商品编号：     
       <input name="id" type="text" id="id" value="0004" size="12" readonly="readonly">
     </p>
     <p>商品名称：     
       <input name="goodsname" type="text" id="goodsname" value="双星书包" size="16" readonly="readonly">
     </p>
    <p>商品单价：
      <input name="price" type="text" id="price" value="129.00" size="10" readonly="readonly">
      元/个 </p>
    <p>商品数量：
      <span id="sprytextfield4">
      <input name="count" type="text" id="count" size="6">
      <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldInvalidFormatMsg">格式无效。</span></span> 个</p>
    <p>商品描述：是一个好东西</p>
    <p>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="submit" name="button" id="button" value="购买">
    </p>
    </form>
    <p>&nbsp;</p>    
  <form name="form5" method="post" action="<%=path%>/AddGoodsTOCar">
  <p>商品编号：     
       <input name="id" type="text" id="id" value="0005" size="12" readonly="readonly">
     </p>
    <p>商品名称：     
      <input name="goodsname" type="text" id="goodsname" value="韩炫时尚迷你裙" size="16" readonly="readonly">
    </p>
    <p>商品单价：
      <input name="price" type="text" id="price" value="99.00" size="10" readonly="readonly">
    元/件 </p>
    <p>商品数量：
      <span id="sprytextfield5">
      <input name="count" type="text" id="count" size="6">
    <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldInvalidFormatMsg">格式无效。</span></span> 件
    
    </p>
    <p>商品描述：是一个好东西</p>
    <p>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="submit" name="button" id="button" value="购买">
    </p>
    </form>

  </div>
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytextfield1", "integer", {validateOn:["change"]});
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytextfield2", "integer", {validateOn:["change"]});
var sprytextfield3 = new Spry.Widget.ValidationTextField("sprytextfield3", "integer", {validateOn:["change"]});
var sprytextfield4 = new Spry.Widget.ValidationTextField("sprytextfield4", "integer", {validateOn:["change"]});
var sprytextfield5 = new Spry.Widget.ValidationTextField("sprytextfield5", "integer", {validateOn:["change"]});
//-->
  </script>
</body>
</html>
