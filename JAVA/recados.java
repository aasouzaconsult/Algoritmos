/*
 * recados.java
 *
 * Created on 19 de Setembro de 2003, 20:20
 */

import java.io.*;
import java.net.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class recados extends HttpServlet {
    
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
        
        //Query
        try
        {
            String SQL = "SELECT * FROM tmensagem ORDER BY codigo DESC";
            rs = State.executeQuery(SQL);
       
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Recados v1.0</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Recados</h1><BR><BR>");

            while(rs.next())
            {   
                out.print("<font face=arial color=#333333 style=\"font-size:8pt\">");
                out.print("por "+rs.getString("nome"));
                out.print("</font><BR>");
                out.print("<font face=arial color=darkblue style=\"font-size:8pt\">");
                out.print(rs.getString("mensagem"));
                out.print("</font><BR>");
            }
        }
        catch (SQLException e){}
        
        out.println("<BR><form action=cadastro method=POST name=form>");
        out.println("Nome: <input type=text size=15 name=nome><BR>");
        out.println("Mensagem: <textarea name=mensagem rows=4 cols=10></textarea><BR>");
        out.println("<input type=submit value=OK>");
        out.println("</form>");
        
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
