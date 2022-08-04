<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO vo = (MemberVO)session.getAttribute("vo");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>LOGIN INFORMATION</h2>
<%= vo.getName() %> <br>
<%= vo.getId() %> <br>
<%= vo.getAddress() %>
<a href="logout.jsp">LOG OUT</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="index.html">INDEX</a>
</body>
</html>