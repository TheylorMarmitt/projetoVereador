<%@ page import= "java.util.Date" %>
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
<form style="margin-left: 2%" action= '<c:url value="/vereador/cadastro"></c:url>'  method= "post">
		<br>
		<div class="form-group">
			<label>Nome: </label> <input required="required" type="text" name="vereador.nome" />
		</div>	
		<div class="form-group">
			<label>Data de associação: </label> <input required="required" type="date" name="dataAssociacao" />
		</div>
		<label>Partido:</label>
    	<select class="browser-default custom-select" id= codigo name="vereador.partido.codigo">
			<c:forEach var="p" items="${partidos}">
				<option value="${p.codigo}">${p.nome}</option>
			</c:forEach>
		</select> 
		<br>
		<input type="submit" class="btn btn-primary" name="Enviar" />
	</form>
		<br>
		<br>
	<a href = "<c:url value = "/projeto/cadastro"/>"><button class="btn btn-default" style="margin-left: 2%">Cadastrar projeto</button></a>
	<a href = "<c:url value = "/partido/cadastro"/>"><button class="btn btn-default" style="margin-left: 2%">Cadastrar partido</button></a>
	<br>
	<a href = "<c:url value = "/vereador/listar"/>"><button class="btn btn-default" style="margin-left: 2%">Lista vereadores</button></a>
	

</body>
</html>