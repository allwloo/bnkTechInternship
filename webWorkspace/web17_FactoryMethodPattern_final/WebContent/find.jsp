<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h2{
		text-align:center;
		color : purple;
	}
	#wrap{
	
		margin-left: 220px;
	}
</style>
</head>
<body><div id = "wrap">
<h2>FIND MEMBER</h2>
<form action="front.do" method="post">
		<input type="hidden" name="command" value="find">
		ID <Input type="text" name="id" required>
		<input type="submit" value="Find">
		<input type="button" value="click">
</form>
</div>
</body>
</html>