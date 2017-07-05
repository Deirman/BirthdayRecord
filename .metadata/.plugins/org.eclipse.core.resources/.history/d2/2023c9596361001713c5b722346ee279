<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="entity.UserInfo" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<UserInfo> list = (List<UserInfo>)request.getAttribute("list");
		for(UserInfo userInfo:list){
		%>
		<%=userInfo.getId_phone_number() %>,<%=userInfo.getName() %>,<%=userInfo.getPhone() %>,<%=userInfo.getEmail() %>,<%=userInfo.getNickname() %>,<%=userInfo.getPassword() %><br>
		<%}%>
	
	%>
</body>
</html>