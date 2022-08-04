<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%--
  1. EL은 꼬라지 무조건..
  2. EL은 Attribute에 바인딩된 값을 받아오도록 만들어졌다.
  ${RESULT}
  
  
  [ request ] --- [         session              ] ---- [             context                ]
		  --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<H2>이것은 원래 서블릿 입니다.</H2>
<%
	int sum = 0;
	for(int cnt = 0; cnt<=50; cnt++)	sum+=cnt;
	
	
	//내장 객체// 내장객체
	request.setAttribute("RESULT", sum);
	session.setAttribute("RESULT", "session");
	application.setAttribute("NAME", "BNK");
	
	request.getRequestDispatcher("EL1_View.jsp").forward(request, response);
%>
	
</body>
</html>