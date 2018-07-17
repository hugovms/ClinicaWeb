<table class="table table-hover table-striped">
	<tr>
		<th>Nome</th>
		<th>Tipo</th>
		<th>Raça</th>
		<th>Idade</th>
		<th>Alergico</th>
		<th>Cliente</th>
	</tr>

	<%
		for (Animal animal : listaAnimal) {
	%>
	<tr>
		<td><%=animal.getNome()%></td>
		<td><%=animal.getTipo()%></td>
		<td><%=animal.getRaca()%></td>
		<td><%=animal.getIdade()%></td>
		<td>
			<%
				if (animal.getAlergico().equals("Sim")) {
			%> <span style="color: green;" class="glyphicon glyphicon-ok"></span>
			<%
				} else {
			%> <span style="color: red;" class="glyphicon glyphicon-remove"></span>
			<%
				}
			%>
		</td>
		<td><%=animal.getCliente().getNome()%></td>
		<td><a href="formAnimal.jsp?cod=<%=animal.getCod()%>">
		<span style="color: blue;" class="glyphicon glyphicon-edit"></span></a></td>
		<c:if test="${not empty sessionScope.veterinarioSession}">
			<td><a href="AnimalServlet?cod=<%=animal.getCod()%>"
				onclick="return confirm('Realmente que apagar esse animal?')">
				<span style="color: red;" class="glyphicon glyphicon-trash"></span></a></td>
			<td><a href="formConsulta.jsp?cod=<%=animal.getCod()%>">
			<span style="color: green;" class="glyphicon glyphicon-asterisk"></span></a></td>
		</c:if>
	</tr>

	<%
		}
	%>


</table>