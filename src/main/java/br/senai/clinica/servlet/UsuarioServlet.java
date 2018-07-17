package br.senai.clinica.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.clinica.dao.UsuarioDao;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	public void doPost(HttpServletRequest entrada, HttpServletResponse saida) throws ServletException, IOException {
		String nome = entrada.getParameter("nome");
		String email = entrada.getParameter("email");
		int crv = 0;
		if(entrada.getParameter("crv")!=null) {
			crv = Integer.parseInt(entrada.getParameter("crv"));
		}
		UsuarioDao dao = new UsuarioDao();
		dao.incluir(nome,email,crv);
		RequestDispatcher direcionar = 
				entrada.getRequestDispatcher(
						"listaCliente.jsp");
		direcionar.forward(entrada, saida);
	}
}
