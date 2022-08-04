<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#wrap{
		text-align:center;
		border: 2px dotted green;
	
	}
	h2{
		color: purlple;	
	}
</style>
</head>
<body>
<div id = "wrap">
<p><h2> EL, JSTL 활용한 Cafe Member Manage</h2></p>

	<p><a href="find.jsp"> 회원 검색 하기 </a></p>
	
	<C:choose>
		<C:when test="${!empty vo}">
			<p><a href="front.do?command=showAll"> 전체 회원 보기 </a></p>
			<p><a href="update.jsp"> 회원 정보 수정 하기 </a></p>
			<p><a href="front.do?command=logout"> 로그아웃 </a></p>
		</C:when>
		<C:otherwise>
			<p><a href="register.jsp"> 회원 가입 하기 </a></p>
			<p><a href="login.jsp"> 로그인 하기 </a></p>
		</C:otherwise>
	</C:choose>




</div></body>
</html>