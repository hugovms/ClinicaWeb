<%@include file="cabecalho.jsp"%>

<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-10">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">Cadastro de Consulta</h2>
			</div>
			<div class="panel-body">
				<!-- formulário de cadastro de cliente -->
				<form action="ConsultaServlet" method="post">
					<fieldset>
						<div class="form-group">
							<label for="codAnimal">Cod Animal</label> 
							<input type="number" class="form-control" id="codAnimal"
								name="codAnimal" placeholder="12345"
								value="${param.cod}"
								> 
								<label for="peso">Peso</label>
							<input type="text" name="peso" id="peso" class="form-control"
								placeholder="99,99"> 
							<label for="altura">Altura</label>
							<input type="text" name="altura" id="altura"
								class="form-control" placeholder="99,99"> 
							<label
								for="valor">Valor</label> 
							<input type="text" name="valor"
								id="valor" class="form-control" placeholder="99,99"> <label
								for="diagnostico">Diagnostico</label>
							<textarea class="form-control" name="diagnostico"
								id="diagnostico"></textarea>
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


