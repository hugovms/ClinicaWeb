<%@page import="br.senai.clinica.model.Veterinario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE	html>
<html>
<head>
<title>Sistema Clinica</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/personalizar.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<c:if test="${empty sessionScope.usuarioSession}">
	<meta http-equiv="refresh"
		content="0; url=http://localhost:8080/ClinicaWeb">
</c:if>
<c:set var="usuario" value="${sessionScope.usuarioSession}"></c:set>
</head>
<body>

	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<div class="container">
				<ul class="nav nav-tabs">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="">Cliente</a>
						<ul class="dropdown-menu">
							<li><a href="formCliente.jsp">Cadatrar</a></li>
							<li><a href="listaCliente.jsp">Listar</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="">Animal</a>
						<ul class="dropdown-menu">
							<li><a href="listaAnimal.jsp">Listar</a></li>
						</ul></li>
					<li><a href="formVeterinario.jsp">Veterinário</a></li>
					<!-- Usando IF com JSP puro -->
					<% Veterinario vet = (Veterinario) request.getSession().getAttribute("veterinarioSession"); 
					if(vet != null){
					%>					
						<li><a href="formConsulta.jsp">Consulta</a></li>
					<% } %>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="">Usuário</a>
						<ul class="dropdown-menu">
							<li><a href="formUsuario.jsp">Novo</a></li>
							<li><a href="formSenha.jsp">Alterar Senha</a></li>
						</ul></li>
					<li><a href="LoginServlet?saida=0">Sair</a></li>
				</ul>

				<div class="jumbotron">
					<div class="container">
						<h1>sisClinica - VET</h1>
						<p>Bem vindo a clinica VET</p>
					</div>
				</div>
				Usuario: ${usuario.nome}
				<!-- Usando IF com JSTL taglibs -->
				<c:if test="${not empty sessionScope.veterinarioSession}">
				
					<c:set var="veterinario" value="${sessionScope.veterinarioSession}" />
					<b>CRV:</b>${veterinario.crv} 
					
				</c:if>
				<br><br>