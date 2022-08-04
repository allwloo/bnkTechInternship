<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String url = "https://search.naver.com/search.naver?query="+request.getParameter("word");
//페이지 이동
response.sendRedirect(url);
%>
</body>
</html>