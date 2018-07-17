package br.senai.clinica.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.clinica.dao.VeterinarioDao;
import br.senai.clinica.model.Veterinario;

@WebServlet("/VeterinarioServlet")
public class VeterinarioServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int crv = Integer.parseInt(
				request.getParameter("crv"));
		
		Veterinario objVeterinario = new Veterinario(crv);
		objVeterinario.setNome(request.getParameter("nome"));
		objVeterinario.setCidade(request.getParameter("cidade"));
		objVeterinario.setEndereco(request.getParameter("endereco"));
		objVeterinario.setCelular(request.getParameter("celular"));
		objVeterinario.setCpf(request.getParameter("cpf"));
		
		VeterinarioDao dao = new VeterinarioDao();
		System.out.println(dao.inserir(objVeterinario));
		
		RequestDispatcher direcionar = 
				request.getRequestDispatcher(
						"listaCliente.jsp");
		direcionar.forward(request, response);
	}
	
}
