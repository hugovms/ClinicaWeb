package br.senai.clinica.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.clinica.dao.UsuarioDao;
import br.senai.clinica.dao.VeterinarioDao;
import br.senai.clinica.model.Usuario;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest entrada,
			HttpServletResponse saida) throws ServletException, IOException {
		if(entrada.getParameter("saida").equals("0")) {
			entrada.getSession().removeAttribute("usuarioSession");
			entrada.getSession().removeAttribute("veterinarioSession");
			RequestDispatcher direcionar 
			= entrada.getRequestDispatcher("index.jsp");
			direcionar.forward(entrada, saida);
		}
			
	}
	
	public void doPost(HttpServletRequest entrada,
			HttpServletResponse saida) throws ServletException, IOException {
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = dao.logar(entrada.getParameter("email")
				, entrada.getParameter("senha"));
		if (usuario != null) {
			System.out.println("Ta fluindo");
			// agora vamos incluir um usuario na sessão
			entrada.getSession().setAttribute("usuarioSession", usuario);
			if(usuario.getCrv() > 0) {
				VeterinarioDao vDao = new VeterinarioDao();
				entrada.getSession().setAttribute(
						"veterinarioSession", vDao.buscar(usuario.getCrv()));
			}
			
			
			
			RequestDispatcher direcionar = 
			entrada.getRequestDispatcher("listaCliente.jsp");
			direcionar.forward(entrada, saida);
		}else {
			System.out.println("Usuario não encontrado");
		}
	}
}
