<%@include file="cabecalho.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-10">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">Cadastro de Cliente</h2>
			</div>
			<div class="panel-body">
				<!-- formulário de cadastro de cliente -->
				<form method="get" action="ClienteServlet">
					<fieldset>
						<jsp:useBean id="editaCliente"
							class="br.senai.clinica.dao.ClienteDao" />
						<c:set var="cliente" value="${editaCliente.buscar(param.cod)}" />
						<div class="form-group">
							<label for="nome">Nome Completo</label> <input type="text"
								class="form-control" id="nome" name="nome" autofocus
								placeholder="Insira seu nome" value="${cliente.nome}">
							<label>Cidade</label> <select name="cidade" class="form-control">
								<option value="">Selecione</option>
								<option value="tagua">Taguatinga</option>
								<option value="guara">Guará</option>
								<option value="cei">Ceilândia</option>
							</select> <label for="endereco">Endereço</label> <input type="text"
								name="endereco" id="endereco" class="form-control"
								value="${cliente.endereco}" placeholder="Logradouro"> <label
								for="telefone">Telefone</label> <input type="tel"
								name="telefone" id="telefone" value="${cliente.telefone}"
								class="form-control" placeholder="(61) 9.9999-9999"> <label
								for="celular">Celular</label> <input type="tel" name="celular"
								value="${cliente.celular}" id="celular" class="form-control"
								placeholder="(61) 9.9999-9999"> <label for="cpf">CPF</label>
							<input type="tel" name="cpf" value="${cliente.cpf}" id="cpf"
								class="form-control" placeholder="999.999.999-99">

						</div>
						<input type="hidden" value="${cliente.cod}" name="cod" />
						<button type="submit" class="btn btn-primary">Gravar</button>
					</fieldset>
					<script>
						$(document).ready(function() {
							$('#${cliente.cidade}').attr({
								selected : "selected"
							});
						});
					</script>
				</form>
			</div>
		</div>

	</div>
</div>
<%@include file="rodape.jsp"%>