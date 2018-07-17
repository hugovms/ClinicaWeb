package br.senai.clinica.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.clinica.dao.AnimalDao;
import br.senai.clinica.dao.ClienteDao;
import br.senai.clinica.model.Animal;

@WebServlet("/AnimalServlet")
public class AnimalServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AnimalDao daoA = new AnimalDao();
		boolean teste = false; 
		if(request.getParameter("cod")!=null) {
			// faremos uma alteração
			int cod = Integer.parseInt(request.getParameter("cod"));
			teste = daoA.apagar(cod);
		}
		if(teste) {
			RequestDispatcher rd 
			= request.getRequestDispatcher("listaAnimal.jsp");

			rd.forward(request, response);
		}else {
			System.out.println("Analisar falha.");
		}
		
	}
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ClienteDao daoC = new ClienteDao();
		int cli = Integer.parseInt(
				request.getParameter("clienteAnimal"));
//		Animal animal = new Animal();
//		animal.setCliente(daoC.buscar(cli));
		// usando metodo construtor cliente
		Animal animal = new Animal(daoC.buscar(cli));
		animal.setIdade(Integer.parseInt(
				request.getParameter("idade")));
		animal.setNome(request.getParameter("nome"));
		animal.setTipo(request.getParameter("tipo"));
		animal.setRaca(request.getParameter("raca"));
		animal.setAlergico(
				request.getParameter("alergico") != null ? "Sim":"Nao");
		 
		AnimalDao daoA = new AnimalDao();
		boolean teste; 
		if(animal.getCod()<=0) {
			// faremos uma alteração
			teste = daoA.incluir(animal);
		}else {
			// fazer um incluir
			animal.setCod(Integer.parseInt(request.getParameter("cod")));
			teste = daoA.editar(animal);
		}
		if(teste) {
			RequestDispatcher rd 
			= request.getRequestDispatcher("listaAnimal.jsp?cli="+cli);
			request.setAttribute("cli", cli);
			rd.forward(request, response);
		}else {
			System.out.println("Analisar falha.");
		}
		
	}
}
