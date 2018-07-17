<!DOCTYPE	html>
<html>
<head>
<title>Sistema Clinica</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/personalizar.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<div class="container">

				<div class="jumbotron">
					<div class="container">
						<h1>sisClinica - VET</h1>
						<p>Bem vindo a clinica VET</p>
					</div>
				</div>

				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">

						<div class="panel panel-default">
							<div class="panel-heading">
								<h2 class="panel-title">Login</h2>
							</div>
							<div class="panel-body">
								<form method="post" action="LoginServlet">
									<fieldset>
										<div class="form-group">
											<label for="email">E-mail</label> <input type="text"
												name="email" required id="email" class="form-control"
												placeholder="nome@com.br"> <label for="senha">Senha</label>
											<input type="password" name="senha" id="senha"
												class="form-control" required
												placeholder="*******">
										</div>
										<button type="submit" class="btn btn-primary">Entrar</button>
									</fieldset>
								</form>
							</div>
						</div>

					</div>
				</div>
				<%@include file="rodape.jsp"%>