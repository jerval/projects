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
    <title>培训反馈编辑</title>
     <link href="<%=path%>/common/css/table.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
  <table width="800"  border="1" cellspacing="0" align="center">
  <tr>
    <td> <a href="<%=path%>/system/manager/feedback/feedbackListAction">员工培训反馈</a>-&gt; 培训反馈编辑</td>
  </tr>
</table>
<br>
<form name="form1" method="post" action="<%=path %>/system/manager/feedback/feedbackAddSaveAction">
 <s:token/>
<input type="hidden" name="feedback.trainingplanSeq" value="<s:property value="course.id.trainPlan.trainPlanNo"/>"/>
<input type="hidden" name="feedback.execsubNO" value="<s:property value="course.id.CourseNo"/>"/>
<input type="hidden" name="feedback.userId" value="10000007"/>
  <table width="800"   border="1" align="center" cellspacing="0">
    <tr>
      <td colspan="4">
      <table width="100%"   border="0" align="center" cellspacing="0">
        <tr>
          <th class="TH00" style="background-image:url(<%=path%>/common/images/bg.gif)" >培训反馈编辑</th>
          <th class="TH02" colspan="3" style="background-image:url(<%=path%>/common/images/bg.gif)"><span class="TD01">
            <input type="submit" name="button" id="button" value="提交" style="background-image:url(<%=path%>/common/images/icon04.gif)">
          </span></th>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td class="TD02">评价自己</td>
      <td width="647" class="TD01">
      <select name="feedback.selfEvl" >
        <option value="优秀">优秀</option>
        <option value="良好">良好</option>
        <option selected value="合格">合格</option>
        <option value="不合格">不合格</option>
      </select></td>
    </tr>
    <tr>
      <td width="143" class="TD02">评价老师</td>
      <td width="647" class="TD01">
        <textarea name="feedback.teacherEvl" id="textarea" cols="90" rows="5"><s:property value="feedback.teacherEvl"/></textarea>
      </td>
    </tr>
    <tr>
      <td class="TD02">改善建议</td>
      <td width="647" class="TD01">
      <textarea name="feedback.studentAdvise" id="textarea2" cols="90" rows="5"><s:property value="feedback.studentAdvise"/></textarea></td>
    </tr>
  </table>
</form>
  </body>
</html>
