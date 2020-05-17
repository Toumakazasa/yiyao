<%@page import="entity.physic"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
request.setCharacterEncoding("UTF-8");
int ypid=Integer.parseInt(request.getParameter("ypis"));
physic p=new physic();
p.setYpid(ypid);
%>
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size: 30px;">
<form action="updatayp.doc" method="post">
<table cellpadding="0" cellspacing="0" border="0">
<tr>
<td>药品名称</td>
<td><input name="ypname">  </td>
</tr>
<tr>
<td>药品类别</td>
<td><input name="tid"></td>
</tr>
<tr>
<td>参考进价</td>
<td><input name="ypjp"></td>
</tr>
<tr>
<td>参考售价</td>
<td><input name="ypsp"></td>
</tr>
<tr>
<td>保质期</td>
<td><input name="ypbzq"></td>
</tr>
<tr>
<td>药品描述</td>
<td><input name="ypms"></td>
</tr>
<tr>
<td>药品规格</td>
<td><input name="ypgg"></td>
</tr>
<tr>
<td>药品id</td>
<td><input type="hidden" name="ypid" value=<%=p.getYpid() %>></td>
</tr>
</table >
<input type="reset" value="重置">
<input type="submit" value="确定">

</form>


</body>
</html>