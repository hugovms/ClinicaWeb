package br.senai.clinica.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.clinica.dao.UsuarioDao;
import br.senai.clinica.model.Usuario;

@WebServlet("/SenhaServlet")
public class SenhaServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String senhaAtual = request.getParameter("senhaAtual");
		
		Usuario usuario = 
				 (Usuario) request.getSession().getAttribute("usuarioSession");
		if(usuario.getSenha().equals(senhaAtual)) {
			// podemos mudar a senha
			UsuarioDao dao = new UsuarioDao();
			String novaSenha = request.getParameter("senha");
			usuario.setSenha(novaSenha);
			dao.mudarSenha(usuario);
			RequestDispatcher direcionar = 
					request.getRequestDispatcher(
							"listaCliente.jsp");
			direcionar.forward(request, response);
		}else {
			// a senha não pode ser modificada
		}
	}
}
