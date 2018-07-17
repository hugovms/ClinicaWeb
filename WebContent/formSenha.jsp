<%@include file="cabecalho.jsp"%>

<script>
	function validarSenha() {
		var senha = document.getElementById('senha').value;
		var senhaC = document.getElementById('senhaC').value;
		if (senha == senhaC && senha != "" && senhaC != "") {
			//alert("Senha Ok");
			document.getElementById('valSenha').innerHTML = '';
		} else {
			//alert("Senha Invalida");
			document.getElementById('valSenha').innerHTML = 'Senha invalida';
			document.getElementById('senha').focus();
			return false;
		}
	}
</script>


<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-10">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">Alterar Senha</h2>
			</div>
			<div class="panel-body">
				<!-- formulário de cadastro de Usuário -->
				<form onsubmit="return validarSenha()"
				action="SenhaServlet" method="post">
					<fieldset>
						<div class="form-group">

							<label for="senha">Senha Atual</label> 
							<input type="password"
								name="senhaAtual" 
								id="senhaAtual" 
								class="form-control" 
								required 
								placeholder="*******"> 
							
							<label for="senha">Nova Senha</label>
							<input type="password" 
								name="senha" 
								id="senha"
								class="form-control" 
								required 
								placeholder="*******"> 
							
							<label for="senhaC">Confirmar Senha</label> 
							<input type="password" 
								name="senhaC" 
								id="senhaC"
								required 								
								class="form-control" 
								placeholder="*******"> 
								
							<span id="valSenha"></span>
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


