<%@include file="cabecalho.jsp"%>
<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-10">
		<form action="listaCliente.jsp" method="post">
			<div class="form-group">
				<label for="Pesquisar">Pesquisar</label> <input type="text"
					class="form-control" id="pesquisa" name="pesquisa" autofocus
					placeholder="Nome"> <input type="submit" name="Pesquisar">
			</div>
		</form>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">Lista dos Clientes</h2>
			</div>
			<%@page import="br.senai.clinica.dao.*"%>
			<%@page import="br.senai.clinica.model.*"%>
			<%@page import="java.util.*"%>
			<%
				ClienteDao acessoCliente = new ClienteDao();
			%>

			<table class="table table-hover table-striped">
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Endereco</th>
					<th>Celular</th>
					<th>Cpf</th>
				</tr>
				<%
					String q = request.getParameter("pesquisa");
					List<Cliente> listaCliente = acessoCliente.pesquisar(q);
					for (Cliente cliente : listaCliente) {
						//out.print("<>");
				%>
				<tr>
					<td><%=cliente.getCod()%></td>
					<td><%=cliente.getNome()%></td>
					<td><%=cliente.getEndereco()%></td>
					<td><%=cliente.getCelular()%></td>
					<td><%=cliente.getCpf()%></td>
					<!-- criando um link para excluir um cliente -->
					<td><a href="ClienteServlet?del=<%=cliente.getCod()%>"
						onclick="return confirm('Deseja excluir o cliente')"> <span
							style="color: red;" class="glyphicon glyphicon-trash"></span>
					</a></td>
					<td><a href="formCliente.jsp?cod=
					<%=cliente.getCod()%>">
							<span style="color: green;" class="glyphicon glyphicon-edit"></span>
					</a></td>
					<td><a href="formAnimal.jsp?cli=
						<%=cliente.getCod()%>">
							<span style="color: blue;" class="glyphicon glyphicon-plus"></span>
					</a></td>
				</tr>

				<%
					}
				%>


			</table>
		</div>
	</div>
</div>
</div>

</div>
</div>
</body>
</html>


