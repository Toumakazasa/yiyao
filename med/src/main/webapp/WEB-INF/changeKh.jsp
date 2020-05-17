<%@ page  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size: 30px;">
    <div>
       <h3>修改客户信息</h3>
       <form action="change.do" method="post">
        
                                  客户名称:<input type="text" name="khname"><br>
             
                                  联系人:<input type="text" name="khlxr"><br>
             
                                  联系电话:<input type="text" name="khtel"><br>
             
                                  联系地址:<input type="text" name="khaddress"><br> 
             <input type="button" value="取消"  onclick="location='/WEB-INF/cus.do'"><input type="submit" value="确定">
       </form>
    </div>
</body>
</html>