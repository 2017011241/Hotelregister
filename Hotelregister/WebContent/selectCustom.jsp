<%@ page contentType="text/html; charset=GBK" import="java.util.*,hotel.model.Custom"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>用户信息列表</title>
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
<h2>用户信息列表</h2>
<Form name="form1" action="update.action" method="post" onSubmit="return check()">
<table> 
 <tr>
 <th>身份证号</th>
 <th>姓名</th>
 <th>手机号</th> 
 <th>入住时间</th>
 <th>离开时间</th>
 <th>房间号</th>
 </tr>
 <% 
 ArrayList<Custom> list=(ArrayList<Custom>)request.getAttribute("list"); 
 int i=1; 
 for(Custom ui:list){
 %>
 <tr> 
 <td align="center"><%=ui.getId()%> 
 <td align="center"><%=ui.getName()%> 
 <td align="center"><%=ui.getPhone()%>
 <td align="center"><%=ui.getSettime()%>
 <td align="center"><%=ui.getLivetime()%>
  <td align="center"><%=ui.getRoomid()%></tr>
 <% i++; } %> 
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
<tr>
<td>原来的房间号</td>
<td><input type="text" name="lastroomid"></td>
</tr>
<tr><td><input type="submit" value="确认更新"></td></tr>
 </Form>
 </table>
<a href="start.jsp">返回主页</a>
</body>
</html>