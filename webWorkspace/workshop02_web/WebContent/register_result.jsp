
<%@page import="servlet.model.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProductVO vo = (ProductVO)request.getAttribute("p1");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품이 저장되었습니다.</h2>
<b>상품 번호</b> <%= vo.getPronum() %><br>
<b>상품 명</b> <%= vo.getName() %><br>
<b>상품 가격</b> <%= vo.getPrice() %><br>
<b>상품 설명</b> <%= vo.getDetail() %><br>

<p><a href="AllProduct"> 전체 상품 보기 </a></p>
</body>
</html>