<%@ page  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>add kh</title>
<link rel="stylesheet" type="text/css"
			href="css/style.css" />
</head>
<body style="font-size: 30px;">
  <div id="content">
  <h2>添加客户</h2>
  <form action="add.do" method="post">
   <table
							class="form_table">
      <tr>
        <td valign="middle" align="right">
                    客户名称:
        </td>
        <td valign="middle" align="left">
          <input type="text" class="inputgri" name="khname" >
        </td>
      </tr>
      <tr>
        <td valign="middle" align="right">
                     联系人:
        </td>
        <td valign="middle" align="left">
					<input type="text" class="inputgri" name="khlxr" />
			  </td>
      </tr>
      <tr>
				 <td valign="middle" align="right">
					联系电话:
				 </td>
				 <td valign="middle" align="left">
						<input type="text" class="inputgri" name="khtel" />
				 </td>
			</tr>
			<tr>
				 <td valign="middle" align="right">
					联系地址:
				 </td>
				 <td valign="middle" align="left">
						<input type="text" class="inputgri" name="khaddress" />
				 </td>
			</tr>
    </table>
    <p>
      <input type="submit" class="button" value="确定">
    </p>
  </form>
  </div>
    
</body>
</html>