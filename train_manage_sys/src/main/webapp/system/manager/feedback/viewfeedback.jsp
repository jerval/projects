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
    <title>反馈信息显示</title>
    <link href="<%=path%>/common/css/table.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
  <table width="800"  border="1" cellspacing="0" align="center">
      <tr>
        <td><a href="<%=path%>">课程反馈信息</a>-&gt;课程反馈信息显示</td>
      </tr>
   </table>
  <form name="form1" method="post" action="<%=path %>/system/manager/feedback/feedbackListAction">
    <table width="800" border="1" align="center" cellspacing="0">
      <tr>
        <td colspan="2" class="TH01" style="background-image:url(<%=path%>/common/images/bg.gif)">培训信息综合查询</td>
      </tr>
   
      <tr class="TD02">
        <th width="391">培训师</th>
        <th width="393">培训课程</th>
      </tr>
   
      <s:iterator id="course" value="#request.listCourse" status="row">
      <tr>
        <td><a href="<%=path%>/system/manager/feedback/toteacherfeedback.action?feedback.id.feedbackCourseNo=<s:property value="#course.id.courseNo"/>">
        <s:property value="#course.companytrainManager"/></a></td>
        <td>
        <s:property value="#course.companytrainName"/></td>
      </tr>
      </s:iterator>
    </table>
  </form>
  </body>
</html>
