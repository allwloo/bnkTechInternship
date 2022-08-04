<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>LOGIN INFORMATION</h2>
${vo.id}<br>
${vo.name}<br>
${vo.address}
<a href="logout.jsp">LOG OUT</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="index.jsp">INDEX</a>
</body>
</html>