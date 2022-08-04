<%@page import="servlet.model.User"%>
<%@page import="servlet.model.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	User vo = (User)session.getAttribute("vo");
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
<a href="login.html">로그인 화면으로 이동합니다....</a>
</body>
</html>