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
<script type="text/javascript">
	function btnclick(){
		alert("button Clicek~~~~!");
	}
</script>
</head>
<body><div id = "wrap">
<h2>REGISTER MEMBER FORM</h2>
<form action="front.do" method="post">
		<!--값이 노출되지 않으면서 서버로 전달할 때 사용하는 태그 -->
		<input type="hidden" name="command" value="update">
		ID <Input type="text" name="id" readonly="readonly" value="${vo.id}">
		PASS <Input type="password" name="password" value="${vo.password}">
		NAME <Input type="text" name="name" value="${vo.name}">
		ADDR <Input type="text" name="address" value="${vo.address}">
		<input type="submit" value="UPDATE">
		<input type="button" value="click" onclick="btnclick()">
</form>
</div>
</body>
</html>