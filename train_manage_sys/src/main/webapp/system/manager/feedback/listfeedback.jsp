<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>员工培训反馈</title>
    <link href="<%=path%>/common/css/table.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=path%>/common/js/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="<%=path%>/common/js/util/deleteCheckbox.js"></script>
  </head>
<body>
<table width="800"  border="1" cellspacing="0" align="center">
    <tr>
      <td><a href="<%=path%>">员工培训反馈</a>-&gt; 受训课程一览</td>
    </tr>
</table>
<form name="queryForm"  id="queryForm" method="post" action="<%=path %>/system/manager/feedback/feedbackListAction">
 <input type="hidden" id="pageNo" name="pageNo" value="<s:property value="pageNo"/>"/>
     <input type="hidden" id="pageSize" name="pageSize" value="<s:property value="pageSize"/>"/>
  <table width="800" border="1" cellspacing="0" align="center" >
    <tr>
      <th colspan="3" align="left" class="TH01" style="background-image:url(<%=path%>/common/images/bg.gif)">受训课程查询</th>
    </tr>
    <tr  class="TD02">
      <th width="39%" class="" align="left"">培训课程名称
        <input type="text" name="feedback.companytrainName" value="<s:property value="feedback.companytrainName"/>" id="textfield"></th>
      <th width="46%" class="">培训师
        <input type="text" name="feedback.companytrainManager" value="<s:property value="feedback.companytrainManager"/>" id="textfield2"></th>
      <th width="15%" class="">
      <input type="submit" name="button" id="button" value="查询"></th>
    </tr>
  </table>
  <table width="800" border="1" align="center" cellspacing="0">
    <tr>
      <td colspan="7"  style="background-image:url(<%=path%>/common/images/bg.gif)">&nbsp;</td>
    </tr>
    <tr  class="TD02">
      <th>培训课程名称</th>
      <th>培训师</th>
      <th>课程开始时间</th>
      <th>课程结束时间</th>
      <th>结课标志</th>
    </tr>
    <s:iterator id="feedback" value="#request.listFeedback" status="row">
    <tr>
      <td><a href="<%=path%>/system/manager/feedback/tofeedback.action?course.id.courseNo=<s:property value="#course.id.courseNo"/>">
      <s:property value="#feedback.companytrainName"/></a></td>
      <td><s:property value="#feedback.companytrainManager"/></td>
      <td><s:property value="#feedback.execbeginTime"/></td>
      <td><s:property value="#feedback.execendTime"/></td>
      <td><s:property value="#feedback.execFlag"/></td>
    </tr>
    </s:iterator>
  </table>
  <table width="800" border="1" align="center">
    <tr>
      <td><%@ include file="/common/util/pageBean.jsp" %></td>
    </tr>
  </table>
</form>
</body>
</html>
