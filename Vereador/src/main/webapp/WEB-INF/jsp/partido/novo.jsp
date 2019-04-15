<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>
<br>
	<form style="margin-left: 2%" action= '<c:url value="/partido/enviar"></c:url>'  method= "post">
		<div class="form-group">
			<label>Nome: </label> <input required="required" type="text" name="partido.nome" />
		</div>
		<div class="form-group">	
			<label>Numero: </label> <input required="required" type="text" name="partido.numero" />
		</div>
		<input type="submit" class="btn btn-primary" name="Enviar" />
	</form>
	<br>
	<br>
	<a href = "<c:url value = "/vereador/cadastro"/>"><button class="btn btn-default" style="margin-left: 2%">Cadastrar vereador</button></a>
	<a href = "<c:url value = "/projeto/cadastro"/>"><button class="btn btn-default" style="margin-left: 2%">Cadastrar projeto</button></a>
	<br>
	<a href = "<c:url value = "/partido/listar"/>"><button class="btn btn-default" style="margin-left: 2%">Lista partidos</button></a>

</body>
</html>