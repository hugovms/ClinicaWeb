package br.senai.clinica.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.clinica.dao.AnimalDao;
import br.senai.clinica.dao.ConsultaDao;
import br.senai.clinica.model.Consulta;
import br.senai.clinica.model.Veterinario;

@WebServlet("/ConsultaServlet")
public class ConsultaServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Consulta consulta = new Consulta();
		consulta.setPeso(
				Float.parseFloat(request.getParameter("peso").replace(",", ".")));
		consulta.setAltura(
				Float.parseFloat(request.getParameter("altura").replace(",", ".")));
		consulta.setValor(
				Float.parseFloat(
						request.getParameter("valor").replace(",", ".")));
		consulta.setDiagnostico(
				request.getParameter("diagnostico"));
		consulta.setVeterinario(
				(Veterinario) request.getSession().getAttribute("veterinarioSession"));
		AnimalDao daoAnimal = new AnimalDao();
		consulta.setAnimal(
			daoAnimal.buscar(
					Integer.parseInt(
							request.getParameter("codAnimal"))));
		ConsultaDao daoConsulta = new ConsultaDao();
		daoConsulta.gravar(consulta);
		RequestDispatcher direcionar = 
				request.getRequestDispatcher("listaAnimal.jsp");
				direcionar.forward(request, response);
		
	}
}
