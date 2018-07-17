package br.senai.clinica.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.clinica.dao.ClienteDao;
import br.senai.clinica.model.Cliente;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		ClienteDao manipulandoCliente = new ClienteDao();
		String excluir = request.getParameter("del");
		if (excluir != null) {
			System.out.println("tem coisa pra excluir");
			int codExcluir = Integer.parseInt(excluir);
			manipulandoCliente.apagar(codExcluir);
			RequestDispatcher direcionar = request.getRequestDispatcher("listaCliente.jsp");
			direcionar.forward(request, response);
		} else {

			Cliente objCliente = new Cliente();
			objCliente.setNome(request.getParameter("nome"));
			objCliente.setCidade(request.getParameter("cidade"));
			objCliente.setEndereco(request.getParameter("endereco"));
			objCliente.setTelefone(request.getParameter("telefone"));
			objCliente.setCelular(request.getParameter("celular"));
			objCliente.setCpf(request.getParameter("cpf"));

			int codCliente = Integer.parseInt(request.getParameter("cod"));
			
			boolean sucesso = false;
			if(codCliente>0) {
				// atualizar 
				objCliente.setCod(codCliente);
				sucesso = manipulandoCliente.atualizar(objCliente);
			}else {
				// novo
				sucesso = manipulandoCliente.incluir(objCliente);
			}
			
			// ao atualizar ou ao incluir
			if (sucesso) {
				RequestDispatcher direcionar = request.getRequestDispatcher("listaCliente.jsp");
				direcionar.forward(request, response);
			} else {
				// colocar codigos na tela
				PrintWriter tela = response.getWriter();
				tela.println("<html><body>");
				tela.println("Deu ruim");
				tela.println("</body></html>");
			}

			
		}
	}

	// os metodo anteriores doGet e doPost
}
