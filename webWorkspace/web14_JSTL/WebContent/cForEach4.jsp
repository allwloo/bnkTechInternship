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
<h2>c:foreach 사용법2</h2>
<%
	ArrayList<String> list = new ArrayList<>();
	list.add("apple");
	list.add("banana");
	list.add("orange");
	list.add("grape");
	list.add("watermelon");
	
	request.setAttribute("list", list);
%>
<jsp:forward page="cForEach_view.jsp"/>
<c:forEach var="cnt" begin="1" end="10">
	<font size="${cnt}">Hello NiceDay~~</font><br>
</c:forEach>
</body>
</html>