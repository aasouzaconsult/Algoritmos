import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MostraConsultas extends JFrame
{
    // java.sql objetos requeridos para accesso ao banco de dados
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData rsMetaData;

    // javax.swing objetos requeridos para a interface gráfica
    private JTable table;
    private JTextArea inputQuery;
    private JButton submitQuery;
    
    public MostraConsultas() 
    {   
        super("Entre com uma Consulta e clique em Submeter");

		String url = "jdbc:mysql://localhost/pds";  
        String username = "root";
        String password = "";

        // Carrega o driver para permitir a conexão
        try
        {
            Class.forName("org.gjt.mm.mysql.Driver");

            connection = DriverManager.getConnection(url, username, password);
        } 
        catch (ClassNotFoundException cnfex)
        {
            System.err.println("Falha ao carregar o driver JDBC/MySQL");
            cnfex.printStackTrace();
            System.exit(1);  // termina o programa
        }
        catch (SQLException sqlex)
        {
            System.err.println( "Unable to connect" );
            sqlex.printStackTrace();
            System.exit(1);  // termina o programa
        }

        // Se a conexão foi bem sucedida, monta a GUI      
        inputQuery = new JTextArea( "SELECT * FROM usuarios", 4, 30 );
        submitQuery = new JButton( "Submeter Consulta" );
        submitQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
               getTable();
            }
        });

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(new JScrollPane( inputQuery), BorderLayout.CENTER);
        topPanel.add(submitQuery, BorderLayout.SOUTH);
 
        table = new JTable( 4, 4 );
  
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(topPanel, BorderLayout.NORTH);
        c.add(table, BorderLayout.CENTER);      

        getTable();
  
        setSize(500, 500);
        show();
    }

    private void getTable()
    {
        try
        {
            String query = inputQuery.getText();

            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);         
            displayResultSet(resultSet);
        }
        catch (SQLException sqlex)
        {
            sqlex.printStackTrace();
        }
    }

    private void displayResultSet(ResultSet rs) throws SQLException
    {
        // existem registros?
        boolean moreRecords = rs.next();  

        // Se não existem registros, mostra uma mensagem
        if (!moreRecords)
        {
            JOptionPane.showMessageDialog(this, "O ResultSet não contém registros");
            setTitle( "Nenhum registro para mostrar" );
            return;
        }

        Vector columnHeads = new Vector();
        Vector rows = new Vector();

        try
        {
            // obtém o nome dos campos
            ResultSetMetaData rsmd = rs.getMetaData();
      
            for (int i = 1; i <= rsmd.getColumnCount(); ++i) 
                columnHeads.addElement(rsmd.getColumnName(i));

            // obtém as linhas de dados (registros)
            do
            {
                rows.addElement(getNextRow(rs, rsmd)); 
            } while (rs.next());

            // Mostra a tabela com o resultado do ResultSet
            table = new JTable(rows, columnHeads);
            JScrollPane scroller = new JScrollPane(table);
            Container c = getContentPane();
            c.remove(1);
            c.add( scroller, BorderLayout.CENTER );
            c.validate();
        }
        catch (SQLException sqlex)
        {
            sqlex.printStackTrace();
        }
    }

    private Vector getNextRow(ResultSet rs, ResultSetMetaData rsmd) throws SQLException
    {
        Vector currentRow = new Vector();
      
        for (int i = 1; i <= rsmd.getColumnCount(); ++i)
            switch(rsmd.getColumnType(i))
            {
                case Types.CHAR:
                case Types.VARCHAR:
                case Types.LONGVARCHAR:
                    currentRow.addElement(rs.getString(i));
                    break;
                case Types.INTEGER:
                    currentRow.addElement(new Long(rs.getLong(i)));
                    break;
                default: 
                System.out.println("Tipo era: " + rsmd.getColumnTypeName(i));
            }
      
        return currentRow;
    }

    public void shutDown()
    {
        try
        {
            connection.close();
        }
        catch (SQLException sqlex)
        {
            System.err.println( "Não foi possível desconectar do banco" );
            sqlex.printStackTrace();
        }
    }

    public static void main(String args[]) 
    {
        final MostraConsultas app = new MostraConsultas();

        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) 
            {  
                app.shutDown();
                System.exit(0);
            }
        });
    }
}

