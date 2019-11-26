<%@ page contentType="text/html; charset=GBK" import="java.util.*,hotel.model.Room"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>用户信息列表</title>
</head>
<body>
<h2>用户信息列表</h2>
<Form name="form1" action="seting.jsp" >
<table> 
 <tr>
 <th>房间号</th>
 <th>入主情况</th>
 <th>客户号</th> 
 <th>价格</th>
 </tr>
 <% 
 ArrayList<Room> list=(ArrayList<Room>)request.getAttribute("list"); 
 int i=1; 
 for(Room ui:list){
 %>
 <tr> 
 <td align="center"><%=i%> 
 <td align="center"><%=ui.getIsempty()%> 
 <td align="center"><%=ui.getCustomid()%>
 <td align="center"><%=ui.getPrice()%>
 <td><a href="seting.jsp">入住</a></td></tr>
 <% i++; } %> 
 <tr></tr>
 <tr>
<td><a href="start.jsp">返回主界面</a></td>
</tr>
 </Form>
 </table>
</body>
</html>