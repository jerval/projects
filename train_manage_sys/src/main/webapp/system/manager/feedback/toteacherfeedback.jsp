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
    <title>对培训师评价一览</title>
    <link href="<%=path%>/common/css/table.css" rel="stylesheet" type="text/css"/>
  </head>
  
  <body>
  <table width="800" border="1" align="center" cellspacing="0">
    <tr>
      <td><a href="<%=path%>/system/manager/feedback/viewFeedbackAction">培训管理</a>-&gt; 对培训师评价一览</td>
    </tr>
  </table>
   <br>
  <table width="800" border="1" align="center" cellspacing="0">
    <tr>
      <td colspan="4" class="TH01" style="background-image:url(<%=path%>/common/images/bg.gif)">基本信息</td>
    </tr>
    <tr>
      <td width="107" class="TD02">培训课程名称</td>
      <td width="354"><s:property value="feedback.companytrainName"/></td>
      <td width="92" class="TD02">培训师</td>
      <td width="229"><s:property value="feedback.companytrainManager"/></td>
    </tr>
  </table>
  <br>
  <table width="800" border="1" align="center" cellspacing="0">
    <tr>
      <td colspan="3" class="TH01" style="background-image:url(<%=path%>/common/images/bg.gif)">评价详细信息</td>
    </tr>
    <tr>
      <td width="101" class="TD02">受训员工</td>
      <td width="370" class="TD02">对教师评价</td>
      <td width="315" class="TD02">改善建议</td>
    </tr>
     <s:iterator id="feedback" value="#request.listFeedback" status="row">
    <tr>
      <td><s:property value="#feedback.userChinaName"/></td>
      <td><s:property value="#feedback.evlTeacher"/></td>
      <td><s:property value="#feedback.studentAdvise"/></td>
    </tr>
    </s:iterator>
  </table>
  </body>
</html>
