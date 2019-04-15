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
	<table class="table table-striped" style="width:50%; margin:0 auto">
		<thead>
			<tr>
				<th >Codigo</th>
				<th >Nome</th>
				<th >Numero</th>
			</tr>
		</thead>
		<c:forEach var="p" items="${partidos}">
			<tr>
				<td id="codigo">${p.codigo }</td>
				<td id="nome">${p.nome }</td>
				<td id="numero">${p.numero }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href = "<c:url value = "/partido/cadastro"/>"><button class="btn btn-default" style="margin-left: 25%">Voltar para cadastros</button></a>

</body>
</html>