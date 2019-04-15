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
	<form style="margin-left: 2%" action= '<c:url value="/projeto/enviar"></c:url>'  method= "post">
		<br>
		<div class="form-group">
			<label>Nome: </label> <input required="required" type="text" name="projeto.nome" />
		</div>
			<label>Aprovado: </label>
				<input id="radioAp" type="radio" name="aprovado" value=true  >
		    	<label for="radioAp">Sim</label>   		
				<input id="radioNAp" type="radio" name="aprovado" value=false >
		    	<label for="radioNAp">Não</label>
		<br>
			<label>Apresentado: </label> 
				<input id="radioApr" type="radio" name="apresentado" value=true  >
	    		<label for="radioApr">Sim</label>
				<input id="radioNApr" type="radio" name="apresentado" value=false >
	    		<label for="radioNApr">Não</label>
    	<br>
    	<label>Vereador:</label>
    	<select class="browser-default custom-select" id= codigo name="projeto.vereador.codigo">
			<c:forEach var="v" items="${vereadores}">
				<option value="${v.codigo}">${v.nome}</option>
			</c:forEach>
		</select> 
		<br>
		<input class="btn btn-primary" type="submit" name="Enviar" />
	</form>
		<br>
	
	<a href = "<c:url value = "/vereador/cadastro"/>"><button class="btn btn-default" style="margin-left: 2%">Cadastrar vereador</button></a>
	<a href = "<c:url value = "/partido/cadastro"/>"><button class="btn btn-default" style="margin-left: 2%">Cadastrar partido</button></a>
	<br>
	<a href = "<c:url value = "/projeto/listar"/>"><button class="btn btn-default" style="margin-left: 2%">Lista projetos</button></a>
	
		
</body>
</html>