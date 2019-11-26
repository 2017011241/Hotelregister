<%@ page contentType="text/html; charset=GBK" import="java.util.*,hotel.model.Custom"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>用户信息列表</title>
</head>
<body>
<h2>用户信息列表</h2>
<Form name="form1" action="live.action" method="post" >
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
 <tr><td>请确认身份证号</td></tr>
 <tr><td><input type="text" name="customid"></td></tr>
<tr><td><input type="submit" value="确认结账删除"></td></tr>
 </Form>
 </table>
</body>
</html>