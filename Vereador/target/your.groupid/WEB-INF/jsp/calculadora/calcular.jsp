<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action='<c:url value="/calculadora/resultado"></c:url>' method="get">
		<input type="text" name="valor1" />
		<br>
		<input type="text" name="valor2" />
		<br>
		<input type="submit" name="Somar"/>
	</form>

</body>
</html>