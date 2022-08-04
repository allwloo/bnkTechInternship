<%@page import="servlet.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">회원 전체 명단 보기</h2>
<table border="2" width="350" bgcolor="yellow" align="center">
<c:forEach var="item" items="${list}">
<tr>
	<td>${item.id}</td>
	<td>${item.name}</td>
	<td>${item.address}</td>
</tr>
</c:forEach>
</table>
<h3 align="center"><a href="index.jsp">Homm....</a></h3>
</body>
</html>