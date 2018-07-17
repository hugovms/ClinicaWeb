<%@include file="cabecalho.jsp"%>

<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-10">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">Cadastro de Usuário</h2>
			</div>
			<div class="panel-body">
				<!-- formulário de cadastro de Usuário -->
				<form action="UsuarioServlet" method="post">
					<fieldset>
						<div class="form-group">
							<label for="nome">Nome Completo</label> <input type="text"
								class="form-control" id="nome" name="nome" autofocus required
								placeholder="Insira seu nome"> <label for="email">E-mail</label>
							<input type="text" name="email" required id="email"
								class="form-control" placeholder="nome@com.br"> <label
								for="crv">Crv</label> <input type="text"
								class="form-control" id="crv" name="crv"  
								placeholder="Se veterinário incluir CRV">

						</div>
						<button type="submit" class="btn btn-primary">Gravar</button>
					</fieldset>
				</form>
			</div>
		</div>

	</div>
</div>

</div>
</div>
</div>
</body>
</html>


