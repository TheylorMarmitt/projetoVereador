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
	<c:forEach var="p" items="${lista}">
		<br>${p.nome}
	</c:forEach>
	<form action= '<c:url value="/pessoa/enviar"></c:url>'  method= "post">
		<label>Código: </label> <input type="text" name="pessoa.codigo" />
		<label>Nome: </label> <input type="text" name="pessoa.nome" />
		<input type="submit" name="Enviar" />
	</form>

</body>
</html>