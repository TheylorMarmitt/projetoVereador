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
	<h3>Usuario ${usuario} está logado</h3>
	<br>
	<br>
	<p><a href = "<c:url value = "../calculadora/calcular"/>"> Calculadora</a></p>
</body>
</html>