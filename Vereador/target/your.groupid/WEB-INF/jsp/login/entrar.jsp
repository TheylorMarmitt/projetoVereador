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
	<form action= '<c:url value="/login/verifica"></c:url>'  method= "post">
		<label>Usuário: </label> <input type="text" name="usuario"  required="required"/>
		<br>
		<label>Senha: </label> <input type="password" name="senha" required="required"/>
		<br>
		<input type="submit" name="Enviar" />
	</form>
</body>
</html>