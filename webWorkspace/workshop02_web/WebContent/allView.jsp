
<%@page import="servlet.model.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	ArrayList<ProductVO> list = (ArrayList)request.getAttribute("list");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">전체 상품 리스트 보기</h2>
<table border="2" width="350" bgcolor="yellow" align="center">
<%
	for(ProductVO vo : list){
%>
	<tr>
		<td><%= vo.getPronum() %>
		<td><%= vo.getName()%></td>
		<td><%= vo.getPrice()%></td>
		<td><%= vo.getDetail()%></td>
	</tr>
<%
	}
%>
</table>
<h3 align="center"><a href="register.html">상품 등록...</a></h3>
</body>
</html>