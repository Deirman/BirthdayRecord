<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="entity.UserInfo" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>edit.jsp</title>
</head>
  
  <body>
     <%  UserInfo userInfo = (UserInfo)request.getAttribute("userInfo"); %>
     <form action="UserInfoServlet?method=edit" method="post">
        <input type="hidden" name="id_phone_number" value="<%=userInfo.getId_phone_number() %>"><br> 
        姓名:<input type="text" name="name" value="<%=userInfo.getName() %>"><br>
        电话:<input type="text" name="phone" value="<%=userInfo.getPhone() %>"><br>
        邮件:<input type="text" name="email" value="<%=userInfo.getEmail() %>"><br>
        昵称:<input type="text" name="nickname" value="<%=userInfo.getNickname() %>"><br>
        密码:<input type="text" name="password" value="<%=userInfo.getPassword() %>"><br>
        <input type="submit" value="修改">
     </form>
  </body>
</html>

   <!-- http://localhost:8080/BirthdayRecord/UserInfoServlet?method=list -->
   
   <!-- http://localhost:8080/BirthdayRecord/UserInfosServlet/getAllUserInfo -->
   <!-- http://localhost:8080/BirthdayRecord/UserInfosServlet/login?username=4455&password=536333 --> <!-- 登录接口 -->
   
   
