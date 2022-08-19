<%@page import="spring.service.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- html 주석 -->
<%-- jsp 주석  
	로그인 되어져 있다면 세션을 invalidate 시킵니다...
	세션에 VO가 NULL이 아니면 
	
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	alert("로그아웃~~~!");
	//자바스크립트에서 페이ㅣㅈ 연결...
	location.href="index.jsp";
</script>
</head>
</body>
</html>