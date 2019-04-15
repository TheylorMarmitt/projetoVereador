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
	<div class="form-group">
		<form action= '<c:url value="/projeto/filtrarNome"></c:url>'  method= "get" style="margin-left: 25%" >
		<label>Filtrar por nome </label>
			<input type="text" name="filtro">
			<input class="btn btn-default" type="submit" value="Filtrar"/>
		</form>
	</div>	
	<br>
	<div class="form-group">
		<form action= '<c:url value="/projeto/filtrarVereador"></c:url>'  method= "get" style="margin-left: 25%" >
		<label>Filtrar por vereador</label>
			<input type="text" name="filtroVereador">
			<input class="btn btn-default" type="submit" value="Filtrar"/>
		</form>
	</div>	
	<table style="width:50%; margin:0 auto" class="table table-striped" >
		  <tr>
		    <th >Codigo</th>
		    <th >Nome</th> 
		    <th >Aprovado</th>
		    <th >Apresentado</th>
		    <th >Vereador</th>
		  </tr>
			<c:forEach var="p" items="${projetos}">
  				<tr>
	    			<td >${p.codigo}</td> 
	    			<td >${p.nome}</td>
	    			<td >${p.aprovado}</td>
	    			<td >${p.apresentado}</td>
	    			<td >${p.vereador.nome}</td> 
  				</tr>
			</c:forEach>
	</table>
	<a href = "<c:url value = "/projeto/cadastro"/>"><button class="btn btn-default" style="margin-left: 25%">Voltar para cadastros</button></a>

</body>
</html>