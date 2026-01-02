/*
 * cadastro.java
 *
 * Created on 26 de Setembro de 2003, 12:40
 */

import java.io.*;
import java.net.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author  d1go_2
 * @version
 */
public class cadastro extends HttpServlet {
    
        Statement State;
        ResultSet rs;
        String url; 
    
    /** Initializes the servlet.
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try
        {
            url = "jdbc:odbc:Banco";
            Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );                  
            Connection db = DriverManager.getConnection(url);
            State = db.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
       	                               ResultSet.CONCUR_READ_ONLY);
        }
        catch(ClassNotFoundException e){System.out.println("Driver JDBC-ODBC não encontrado!");}
        catch(SQLException e){System.out.println("Problemas na conexao com a fonte de dados");}
    }
    
    /** Destroys the servlet.
     */
    public void destroy() {
        
    }
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String nome = request.getParameter("nome");
        String mensagem = request.getParameter("mensagem");
        
        try
        {
            String SQL = "INSERT INTO tmensagem (nome,mensagem) VALUES ('"+nome+"','"+mensagem+"')";
            State.executeUpdate(SQL);
        }
        catch (SQLException e){}
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Recados v1.0</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<BR>++Recado+++<BR><BR>Nome:"+nome+"<BR>Mensagem:"+mensagem);
        out.println("<BR><BR><BR>Mensagem gravada com sucesso!");
        out.println("<BR><BR><a href=\"recados\">Voltar</a>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    
}
