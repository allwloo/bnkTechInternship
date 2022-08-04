<%@page import="servlet.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	ArrayList<Book> list = (ArrayList)request.getAttribute("list");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">회원 전체 명단 보기</h2>
<table border="2" width="350" bgcolor="yellow" align="center">
<%
	for(Book vo : list){
%>
	<tr>
		<td><%= vo.getIsbn()%></td>
		<td><%= vo.getTitle()%></td>
		<td><%= vo.getCatalogue()%></td>
		<td><%= vo.getNation()%></td>
		<td><%= vo.getPublish_date()%></td>
		<td><%= vo.getPublisher()%></td>
		<td><%= vo.getAuthor()%></td>
		<td><%= vo.getPrice()%></td>
		<td><%= vo.getCurrency()%></td>
		<td><%= vo.getDescription()%></td>
	</tr>
<%
	}
%>
</table>
<h3 align="center"><a href="Book.html">다시 도서 등록하기....</a></h3>
</body>
</html>