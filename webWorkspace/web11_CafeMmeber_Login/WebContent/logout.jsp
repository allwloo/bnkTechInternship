<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- html 주석 -->
<%-- jsp 주석  
	로그인 되어져 있다면 세션을 invalidate 시킵니다...
	세션에 VO가 NULL이 아니면 
	
--%>
<%
	MemberVO vo = (MemberVO)session.getAttribute("vo");
	if(vo==null){  // 로그인 안된거
		
%>
	<h2><a href="login.jsp"></a></h2>
<% 
	}
	else{
		session.invalidate();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function logout(){
		alert("Log Out~");
	}
</script>
</head>
<body onload="return logout()">
<b>로그아웃 되셨습니다.....</b><br>
<a href="index.html">Index</a>
</body>
</html>