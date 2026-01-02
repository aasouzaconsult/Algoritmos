package aula2.cadastro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: Cadastro
 *
 */
 public class Cadastro extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   public Cadastro() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		String sexo = request.getParameter("sexo");
		
		PrintWriter pw = response.getWriter();
		pw.println("<html><head></head>");
		pw.println("<body><h2>Cadastro</h2>");
		pw.println("Nome ......:" + nome);
		pw.println("<br>");
		pw.println("Endereco ..:" + idade);
		pw.println("<br>");
		pw.println("Sexo ......:" + sexo);
		pw.println("<br>");
		pw.println("<br>");
		pw.println("By Antonio Alex </body>");
		pw.println("</html>");

	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}