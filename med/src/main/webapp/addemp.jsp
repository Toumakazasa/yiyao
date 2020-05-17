<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size: 30px;">
<h1>添加员工</h1>
<form action="addemp.doc" method="post">
<table cellpadding="0" cellspacing="0" border="0">
<tr>
<td>员工编号</td>
<td><input name="ecode">  </td>
</tr>
<tr>
<td>员工姓名</td>
<td><input name="ename"></td>
</tr>
<tr>
<td>身份证</td>
<td><input name="esfz"></td>
</tr>
<tr>
<td>手机号码</td>
<td><input name="etel"></td>
</tr>
<tr>
<td>性别</td>
<td><select  name="gender" id="s1" >
  <option >请选择性别</option>
  <option value="1" >男</option>
  <option value="2" >女</option>
  </select>
  </td>
</tr>
<tr>
<td>出生日期</td>
<td><input name="birthday"></td>
</tr>
<tr>
<td>地址</td>
<td><input name="eaddress"></td>
</tr>
<tr>
<td>员工类别</td>
  <td>
  <select  name="etype" id="s1" >
  <option >请选择类别</option>
  <option value="0" >所有</option>
  <option value="销售人员" >销售人员</option>
  <option value="采购人员" >采购人员</option>
  <option value="库存管理员" >库存管理员</option>
  <option value="系统管理员" >系统管理员</option>
  </select>
  </td>
</tr>

</table >
<p><input type="submit" value="确定"></p>
</body>
</html>