<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Class.forName("com.mysql.jdbc.Driver").newInstance();
String url="jdbc:mysql://localhost/Birthday?user=root&password=123456&useUnicode=true&characterEncoding=utf8";
Connection conn=DriverManager.getConnection(url);
Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
String sql="select * from user_infot_table";
%>
<table border=1>
<tr>
<td>id_phone_number</td>
<td>name</td>
<td>phone</td>
<td>email</td>
<td>phone</td>
<td>nickname</td>
<td>password</td>
</tr>
<%
ResultSet rs=stmt.executeQuery(sql);
while(rs.next()){%>
<tr>
<td><%=rs.getString("id_phone_number")%> </td>
<td><%=rs.getString("name")%> </td>
<td><%=rs.getString("phone")%> </td>
<td><%=rs.getString("email")%> </td>
<td><%=rs.getString("phone")%> </td>
<td><%=rs.getString("nickname")%> </td>
<td><%=rs.getString("password")%> </td>
</tr>
<%}%>
</table>
<%rs.close();
stmt.close();
conn.close();
%>


</body>
</html>