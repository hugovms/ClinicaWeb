<%@page import="br.senai.clinica.model.Animal"%>
<%@page import="java.util.List"%>
<%@page import="br.senai.clinica.dao.AnimalDao"%>
<%@include file="cabecalho.jsp"%>
<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-10">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">Lista dos Animais</h2>
			</div>
			<%
				AnimalDao dao = new AnimalDao();
				List<Animal> listaAnimal = dao.pesquisar("");
			%>
			<%@include file="tbAnimal.jsp"%>
		</div>
	</div>
</div>
</div>

</div>
</div>
</body>
</html>


