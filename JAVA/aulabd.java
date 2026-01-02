/*
 * aulabd.java
 * Created on 25 de Fevereiro de 2003, 09:48
 * @author  Fabricio
 */
import java.sql.*;
import javax.swing.*;
import java.io.*;
import java.util.Vector;

public class aulabd extends java.awt.Frame{
    
    private Connection connection = null;
    private Statement stdados = null;
    private ResultSet rsdados = null;
    private JTable table;

    public aulabd() {
        initComponents();
    }

    private void initComponents() {//GEN-BEGIN:initComponents
        label1 = new java.awt.Label();
        labelid = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        labelnome = new java.awt.Label();
        labelidade = new java.awt.Label();
        labelemail = new java.awt.Label();
        labelfone = new java.awt.Label();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        button5 = new java.awt.Button();
        textArea1 = new java.awt.TextArea();
        button1 = new java.awt.Button();
        button6 = new java.awt.Button();
        button7 = new java.awt.Button();

        setLayout(null);

        setTitle("Acessando Banco de Dados");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        label1.setText("Id:");
        add(label1);
        label1.setBounds(30, 80, 20, 20);

        labelid.setName("labelid");
        add(labelid);
        labelid.setBounds(50, 80, 100, 20);

        label3.setText("nome:");
        add(label3);
        label3.setBounds(30, 110, 39, 20);

        label4.setText("Idade:");
        add(label4);
        label4.setBounds(30, 140, 38, 20);

        label5.setText("fone:");
        add(label5);
        label5.setBounds(260, 140, 31, 20);

        label6.setText("e-mail:");
        add(label6);
        label6.setBounds(30, 170, 42, 20);

        labelnome.setName("labelnome");
        add(labelnome);
        labelnome.setBounds(70, 110, 280, 20);

        labelidade.setName("labelidade");
        add(labelidade);
        labelidade.setBounds(70, 140, 110, 20);

        labelemail.setName("labelemail");
        add(labelemail);
        labelemail.setBounds(70, 170, 280, 20);

        labelfone.setName("labelfone");
        add(labelfone);
        labelfone.setBounds(290, 140, 70, 20);

        button2.setLabel("Primeiro");
        button2.setName("btnprimeiro");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        add(button2);
        button2.setBounds(50, 40, 63, 24);

        button3.setLabel("Pr\u00f3ximo");
        button3.setName("btnproximo");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        add(button3);
        button3.setBounds(190, 40, 61, 24);

        button4.setLabel("Anterior");
        button4.setName("btnanterior");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        add(button4);
        button4.setBounds(120, 40, 58, 24);

        button5.setLabel("\u00daltimo");
        button5.setName("btnultimo");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        add(button5);
        button5.setBounds(260, 40, 60, 24);

        textArea1.setText("SELECT * from alunos order by idade");
        add(textArea1);
        textArea1.setBounds(10, 200, 350, 80);

        button1.setLabel("Abre BD");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        add(button1);
        button1.setBounds(10, 290, 90, 24);

        button6.setLabel("Executa Consulta");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        add(button6);
        button6.setBounds(250, 290, 110, 24);

        button7.setLabel("mostra tabela");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        add(button7);
        button7.setBounds(110, 290, 100, 24);

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new java.awt.Dimension(372, 507));
        setLocation((screenSize.width-372)/2,(screenSize.height-507)/2);
    }//GEN-END:initComponents

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        try{
            ExibeTabela(rsdados);
        }catch(SQLException erro){
            System.out.println(erro);
        }
    }//GEN-LAST:event_button7ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
         ExecutaSQL();
    }//GEN-LAST:event_button6ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        if (AcessaBD()){
            ExecutaSQL();
            ExibeRegistro(rsdados);
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        MovAnterior(rsdados);
    }//GEN-LAST:event_button4ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        MovProximo(rsdados);
    }//GEN-LAST:event_button3ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        MovUltimo(rsdados);
    }//GEN-LAST:event_button5ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        MovPrimeiro(rsdados);
    }//GEN-LAST:event_button2ActionPerformed

    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        Sair();
        System.exit(0);
    }//GEN-LAST:event_exitForm

    public void MovProximo(ResultSet rs){
                try{
              if (rsdados != null){
                if(!rsdados.isLast()){
                    rsdados.next();
                    ExibeRegistro(rs);
                }else{
                    JOptionPane.showMessageDialog(this,"Não existe próximo elemento.");
                }
            }
        }catch(Exception erro){
            System.out.println(erro);
        }
    }
    
    public void MovAnterior(ResultSet rs){
        try{
            if (rsdados != null){
                if (!rsdados.isFirst()){
                    rsdados.previous();
                    ExibeRegistro(rs);
                }else{
                    JOptionPane.showMessageDialog(this,"Não existe registro anterior.");
                }
            }
        }catch(Exception erro){
            System.out.println(erro);
        }
    }
    
    public void MovUltimo(ResultSet rs){
        try{
            if (rsdados != null){
                if (!rsdados.isLast()){
                    rsdados.last();
                    ExibeRegistro(rs);
                }else{
                    JOptionPane.showMessageDialog(this,"O último resgistro já está selacionado.");
                }
            }
        }catch(Exception erro){
            System.out.println(erro);
        }
    }
    
    public void MovPrimeiro(ResultSet rs){
        try{
            if (rsdados != null){
                if (!rsdados.isFirst()){
                    rsdados.first();
                    ExibeRegistro(rs);
                }else{
                    JOptionPane.showMessageDialog(this,"O primeiro registro já está selacionado.");
                }
            }
        }catch(Exception erro){
            System.out.println(erro);
        }
    }    
    
    public void ExibeRegistro(ResultSet rs){
        try{
            //faz a leitura do registro corrento do ResutSet e atribui os valores lidos aos objetos visuais (Textfields)
            labelid.setText(String.valueOf(rs.getInt("id")));
            labelnome.setText(rs.getString("nome"));
            labelidade.setText(String.valueOf(rs.getInt("idade")));
            labelfone.setText(rs.getString("fone"));
            labelemail.setText(rs.getString("email"));
        }catch(Exception erro){
            System.out.println(erro);
        }
    }
    
    public boolean AcessaBD(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        System.out.println(this.getLocale());
        
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.CANCEL_OPTION){return false;}
        
        File arquivo = fileChooser.getSelectedFile();
      
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            connection = DriverManager.getConnection("jdbc:odbc:Driver={MicroSoft Access Driver (*.mdb)};DBQ="+arquivo.getAbsolutePath(),"","");         
        }catch(ClassNotFoundException erro){
            System.out.println("Falha ao carregar o driver JDBC/ODBC."+erro);
            return false;
        }catch(SQLException erro){
            System.out.println( "Falha na conexao, comando sql = "+erro);
            return false;
        }
        return true;
    }
    
    public void ExecutaSQL(){
        try{
            String querydados = textArea1.getText();
            
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            //ResultSet.TYPE_FORWARD_ONLY = O conjunto de dados nao é rolável, isto é, só anda para frente uma única vez.
            //ResultSet.TYPE_SCROLL_INSENSITIVE = O conjunto de dados é rolável, mas nao é sensível às alteraçoes do banco de dados.
            //ResultSet.TYPE_SCROLL_SENSITIVE = O conjunto de dados é rolável e é sensível às alteraçoes do banco de dados.
            int concorrencia = ResultSet.CONCUR_READ_ONLY;
            //ResultSet.CONCUR_READ_ONLY = O conjunto de resultados nao pode ser usado para atualizar o banco de dados.
            //ResultSet.CONCUR_UPDATABLE = O conjunto de resultados pode ser usado para atualizar o banco de dados.
            
            stdados = connection.createStatement(tipo, concorrencia);
            rsdados = stdados.executeQuery(querydados);
            //stdados.executeQuery = retorna um resultSet
            MovPrimeiro(rsdados);
        }catch (SQLException erro) {
            System.out.println(erro);
        }
    }
    
    public void Sair(){
        try{
            if (rsdados != null){
                rsdados.close();
                stdados.close();
                connection.close();
            }
        }catch (SQLException erro){
            System.out.println( "Nao foi possivel a desconexão."+erro );
        }
    }        

 private void ExibeTabela(ResultSet rs) throws SQLException{
     if (!rs.first()) {// Se não houver registros, exibe uma mensagem e termina a execuçao do método
         JOptionPane.showMessageDialog(this,"O ResultSet está vazio.");
         return;
     }
     
     Vector cabecalhos = new Vector();
     Vector registros  = new Vector();
     //comentário sobre a classe Vector
     
     
     try{
        // obtém títulos de coluna
        ResultSetMetaData rsmd = rs.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); i++){
            cabecalhos.addElement(rsmd.getColumnName(i));
        }
        // obtém dados da linha
        do{
           registros.addElement(ProximoRegistro(rs,rsmd));
        }while(rs.next());
        
        table = new JTable(registros, cabecalhos);
        
        // exibe a tabela com conteúdos de ResultSet
        JScrollPane scroller = new JScrollPane(table);
        add(scroller);
        scroller.setBounds(10, 390, 350, 80);
        validate();
     }catch (SQLException erro){
         System.out.println(erro);
     }
 }

 private Vector ProximoRegistro(ResultSet rs, ResultSetMetaData rsmd)throws SQLException{
    Vector registro = new Vector();
    for ( int i = 1; i <= rsmd.getColumnCount();i++){
        //A classe Types é uma classo do pacote java.sql
        if (rsmd.getColumnType(i) == Types.VARCHAR){//para string
            registro.addElement(rs.getString(i));
        }else if (rsmd.getColumnType(i) == Types.INTEGER){//para inteiros
            registro.addElement(new Long(rs.getLong(i)));
        }else{
            //tratamento para os tipos que serao lidos do banco de dados.
        }
    }
    return registro;
 }
    
    public static void main(String args[]) {
        new aulabd().show();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Label label3;
    private java.awt.Label label1;
    private java.awt.Label labelfone;
    private java.awt.Label labelidade;
    private java.awt.Label labelemail;
    private java.awt.TextArea textArea1;
    private java.awt.Label labelid;
    private java.awt.Label labelnome;
    private java.awt.Button button7;
    private java.awt.Button button6;
    private java.awt.Button button5;
    private java.awt.Button button4;
    private java.awt.Label label6;
    private java.awt.Button button3;
    private java.awt.Label label5;
    private java.awt.Button button2;
    private java.awt.Label label4;
    // End of variables declaration//GEN-END:variables
}