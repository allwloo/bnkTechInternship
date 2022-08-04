<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Attribute에 바인딩 된 값을 jsp 결과페이지에서 받아와서 출력합니다...</h2>
<b>1~50까지의 총합 결과값 1) :: </b>
<%= request.getAttribute("RESULT") %><br>
<%= session.getAttribute("RESULT") %><br>
<b>1~50까지의 총합 결과값 1) :: </b>
${RESULT}<BR>
${sessionScope.RESULT}
${applicationScope.NAME}
${RESULT+100 }
</body>
</html>