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
		<form action= '<c:url value="/vereador/filtrarNome"></c:url>'  method= "get" style="margin-left: 25%" >
		<div class="form-group">
		<label>Filtrar por nome </label>
			<input type="text" name="filtroNome">
			<input class="btn btn-default"	 type="submit" value="filtrar"/>
		</div>
		</form>
	</div>	
	<br>
	<div class="form-group">
	<form action= '<c:url value="/vereador/filtrarPartido"></c:url>'  method= "get" style="margin-left: 25%" >
	<label>Filtrar por partido </label>
		<input type="text" name="filtroPartido">
		<input class="btn btn-default" type="submit" value="Filtrar"/>
	</form>
	</div>
	<br>
	<div class="form-group">
	<form action= '<c:url value="/vereador/filtrarData"></c:url>'  method= "get" style="margin-left: 25%" >
		<label>Filtrar por data</label>
		<br>
		<label>Inicio:</label><input type="date" name="dataInicio">
		<label>Fim:</label><input type="date" name="dataFim">
		<input class="btn btn-default" type="submit" value="Filtrar"/>
	</form>
	</div>
	<table style="width:50%; margin:0 auto" class="table table-striped" >
		  <tr>
		    <th >Codigo</th>
		    <th >Nome</th> 
		    <th >Data de associação</th>
		    <th >Partido</th>
		    <th >Projetos aprovados</th>
		    <th >Projetos apresentados</th>
		    <th >Desempenho</th>
		  </tr>
			<c:forEach var="v" items="${vereadores}">
  				<tr>	
	    			<td >${v.codigo}</td> 
	    			<td >${v.nome}</td>
	    			<td >${v.dataAssociacao}</td>
	    			<td >${v.partido.nome}</td>
	    			<td >${v.qtdeProjetosAprovados()}</td>
	    			<td >${v.qtdeProjetosApresentados()}</td>
	    			<td >${v.desempenho()}</td>
  				</tr>
			</c:forEach>
	</table>
	<br>
	<a href = "<c:url value = "/vereador/cadastro"/>"><button class="btn btn-default" style="margin-left: 25%">Voltar para cadastros</button></a>


</body>
</html>