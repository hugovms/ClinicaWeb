<%@include file="cabecalho.jsp"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="edit" class="br.senai.clinica.dao.AnimalDao" />
<c:set var="animal" value="${edit.buscar(param.cod)}" />
<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-10">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">Cadastro do Animal</h2>
			</div>
			<div class="panel-body">
			
				<!-- formulário de cadastro de cliente -->
				<form action="AnimalServlet" method="post">
					<fieldset>
						<div class="form-group">
							<label for="nome">Nome</label> <input type="text"
							value="${animal.nome}"
								class="form-control" id="nome" name="nome" autofocus required
								placeholder="Insira seu nome">

							<label>Tipo</label> <select id="tipo" name="tipo"
								class="form-control"
								onchange="carregaRaca(this.options.selectedIndex)">
								<option value="${animal.tipo}">${animal.tipo}</option>
								<option value="cao">Cachorro</option>
								<option value="gato">Gato</option>
								<option value="lagarto">Iguana</option>
								<option value="passaro">Passaro</option>
								<option value="vaca">Vaca</option>
							</select> <label>Raça</label> <select id="raca" name="raca"
								class="form-control">
								<option value="${animal.raca}">${animal.raca}</option>
								
								
							</select> <label for="idade">Idade</label> <input type="number"
								value="${animal.idade}"
								name="idade" id="idade" class="form-control" placeholder="100">

							<div class="checkbox">
								<label> <input type="checkbox" name="alergico"
								<c:if test="${animal.alergico == 'Sim' }">
								checked="checked"
								</c:if>
									value="sim"> Alergico ?
								</label>
							</div>
							<div class="row">
								<div class="col-md-9"></div>
								<div class="col-md-1">
									<button type="submit" class="btn btn-primary">
										<span class="glyphicon glyphicon-ok"></span> Gravar
									</button>
								</div>
							</div>
					</fieldset>
					
					<input type="hidden" name="clienteAnimal" value="${param.cli}${animal.cliente.cod}">
					<input type="hidden" name="cod" value="${param.cod}">
				</form>
			</div>
<%@page import="br.senai.clinica.model.Animal"%>
<%@page import="java.util.List"%>
<%@page import="br.senai.clinica.dao.AnimalDao"%>
			<%
				AnimalDao dao = new AnimalDao();
				String filtro = "where cod_cliente = "+request.getParameter("cli");
				List<Animal> listaAnimal = dao.pesquisar(filtro);
			%>
			
		</div>
		<%@include file="tbAnimal.jsp"%>
	</div>
</div>
</div>
</div>

</div>
</div>
<script>
	var qtTipo = document.getElementById('tipo').options.length
	//alert(qtTipo)//teste pra ver se carregou o tamanho da combo
	// Array = vetor = matriz
	var grupo = new Array(qtTipo);
	for (i = 0; i < qtTipo; i++)
		grupo[i] = new Array();// nÃ­vel vetor de [0..5]

	grupo[0][0] = new Option("Selecione");

	grupo[1][0] = new Option("Selecione");
	grupo[1][1] = new Option("Pitbul");
	grupo[1][2] = new Option("Poodle");
	grupo[1][3] = new Option("Fila");
	grupo[1][4] = new Option("Daschunb");
	grupo[1][5] = new Option("Pastor Alemão");

	grupo[2][0] = new Option("Selecione");
	grupo[2][1] = new Option("Siamês");
	grupo[2][2] = new Option("Persa");
	grupo[2][3] = new Option("Ragdoll");
	grupo[2][4] = new Option("Maine Coon");
	grupo[2][5] = new Option("Gato-de-bengala");

	var temp = document.getElementById('raca');

	function carregaRaca(tipo) {

		for (i = 0; i < grupo[tipo].length; i++) {
			temp.options[i] = new Option(grupo[tipo][i].text,
					grupo[tipo][i].value);
		}
		temp.options[0].selected = true
	}
</script>
</body>
</html>


