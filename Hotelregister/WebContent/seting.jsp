<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>登陆页面</title>
<script>
function check()
{ 
	if(form1.customid.value=="")
	{ 
		alert("未输入身份证号");
		form1.name.focus(); 
		return false;
	} 
	else if(form1.customid.value.length!=3)
	{ 
		alert("请输入3位身份证号");
		form1.name.focus(); 
		return false;
	}
	else if(form1.name.value=="")
	{ 
		alert("未输入姓名");
		form1.name.focus(); 
		return false;
	} 
	else if(form1.phone.value.length!=11)
	{ 
		alert("请输入正确的11位电话号码");
		form1.phone.focus();
		return false;
	} 
	else if(form1.settime.value=="")
	{ 
		alert("未输入入住时间");
		form1.settime.focus();
		return false; 
	} 
	else if(form1.livetime.value=="")
	{
	alert("未输入离开时间");
	form1.livetime.focus();
	return false; 
	} 
	else if(form1.roomid.value=="")
	{
	alert("没有分配房间号");
	form1.roomid.focus();
	return false; 
	} 
	return true;
} 
</script>
</head>
<body>
<Form name="form1" method="post"  action="set.action" onSubmit="return check()">
<table border="0">
<center><tr><td>客户入住登记</td></tr></center>
<tr>
<td>身份证号</td><td><input type="text" name="customid"></td>
</tr>
<tr>
<td>姓名</td><td><input type="text" name="name"></td>
</tr>
<tr>
<td>电话</td>
<td><input type="text" name="phone"></td>
</tr>
<tr>
<td>入住时间</td>
<td><input type="text" name="settime"></td>
</tr>
<tr>
<td>离开时间</td>
<td><input type="text" name="livetime"></td>

</tr>
<tr>
<td>房间号</td>
<td><input type="text" name="roomid"></td>

</tr>
</table>
<input type="submit" value="提交">
<a href="start.jsp">放弃提交并返回主页面</a>
</Form>
</body>
</html>