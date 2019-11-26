<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<script>
function check()
{ 
	
	if(form1.customid.value.length!=3)
	{ 
		alert("请输入3位身份证号");
		form1.customid.focus(); 
		return false;
	} 
	return true;
} 
</script>
</head>
<body>
<Form name="form1" method="post"  action="selectCus.action" onSubmit="return check()">
<table border="0">
<center><tr><td>请输入身份证号</td></tr></center>
<tr>
<td>身份证号</td><td><input type="text" name="customid"></td>
</tr>
</table>
<input type="submit" value="提交">
</Form>
<a href="start.jsp">返回主页</a>
</body>
</html>