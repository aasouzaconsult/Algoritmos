import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.lang.reflect.*;
import java.util.regex.*;

public class Visualizador extends JFrame{
  JTextField txtClasse, txtPesquisa;
  JTextArea pro, met, cons;
  JButton btnOK, btnFechar;
  String tM, tC, tP; 
  Pattern p = Pattern.compile("\\w+\\.");
  JCheckBox inter, prim;
  
  public Visualizador(){
    super("Visualizador de Métodos e Construtores");
 
    Container tela = getContentPane();
    BorderLayout layout = new BorderLayout();
    tela.setLayout(layout);
    
    Tratador trat = new Tratador();
    
    txtClasse = new JTextField(13);
    txtPesquisa = new JTextField(10);
    btnOK = new JButton("OK!");
    btnOK.addActionListener(trat);
    
    btnFechar = new JButton("Fechar");
    btnFechar.addActionListener(trat);
    
    String titulo = "Propriedades, Métodos e Construtores";
    Border etched = BorderFactory.createEtchedBorder();
    Border border = BorderFactory.createTitledBorder(etched, titulo);
    
    JPanel superior = new JPanel();
    superior.setLayout(new FlowLayout(FlowLayout.LEFT));
    superior.add(new JLabel("Classe:"));
    superior.add(txtClasse);
    superior.add(new JLabel("Pesquisar"));
    superior.add(txtPesquisa);
    superior.add(btnOK);
    superior.add(new JSeparator());
    
    superior.setBorder(border);
    
    JPanel meio = new JPanel();
    meio.setLayout(new GridLayout(1, 3, 0, 0));
    
    JPanel coluna1 = new JPanel();
    coluna1.setLayout(new FlowLayout(FlowLayout.LEFT));
    coluna1.add(new JLabel("Propriedades:"));
    
    pro = new JTextArea(8, 15);
    JScrollPane painelRolagem = new JScrollPane(pro);
    coluna1.add(painelRolagem);
    
    JPanel coluna2 = new JPanel();
    coluna2.setLayout(new FlowLayout(FlowLayout.LEFT));
    coluna2.add(new JLabel("Métodos:"));
    
    met = new JTextArea(8, 15);
    JScrollPane painelRolagem2 = new JScrollPane(met);
    coluna2.add(painelRolagem2);
    
    JPanel coluna3 = new JPanel();
    coluna3.setLayout(new FlowLayout(FlowLayout.LEFT));
    coluna3.add(new JLabel("Construtores:"));
    
    cons = new JTextArea(8, 15);
    JScrollPane painelRolagem3 = new JScrollPane(cons);
    coluna3.add(painelRolagem3);
    
    meio.add(coluna1);
    meio.add(coluna2);
    meio.add(coluna3);
    
    inter = new JCheckBox("Interface");
    prim = new JCheckBox("Tipo Primitivo");
    
    JPanel barra = new JPanel();
    barra.setLayout(new FlowLayout(FlowLayout.RIGHT));
    barra.add(inter);
    barra.add(prim);
    barra.add(btnFechar);
    
    JPanel inferior = new JPanel();
    inferior.setLayout(new BorderLayout());
    inferior.add(new JSeparator(), BorderLayout.NORTH);
    inferior.add(barra, BorderLayout.SOUTH);
    
    tela.add(superior, BorderLayout.NORTH);
    tela.add(meio, BorderLayout.CENTER);
    tela.add(inferior, BorderLayout.SOUTH);
    
    setLocation(280,235);
    setSize(550,300);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Visualizador app = new Visualizador();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if(e.getSource() == btnFechar)
        System.exit(0);
      else{
        tM = "";
        tP = "";
        tC = "";
        met.setText("");
        pro.setText("");
        cons.setText("");
         
        try{
          Class c = Class.forName(txtClasse.getText());
          Method[] m = c.getMethods();
          Constructor[] ctor = c.getConstructors();
          Field[] f = c.getFields();
            
          if(txtPesquisa.getText().equals("")){
            for(int i = 0; i < m.length; i++)
              tM += p.matcher(m[i].toString()).replaceAll("") + "\n";
            for(int i = 0; i < ctor.length; i++)
              tC += p.matcher(ctor[i].toString()).replaceAll("") + "\n";
            for(int i = 0; i < f.length; i++)
              tP += p.matcher(f[i].toString()).replaceAll("") + "\n";
          }
          else {
            for(int i = 0; i < m.length; i++){
              if(m[i].toString().indexOf(txtPesquisa.getText()) != -1)
                tM += p.matcher(m[i].toString()).replaceAll("")  + "\n";
            }    
            for(int i = 0; i < ctor.length; i++){
              if(ctor[i].toString().indexOf(txtPesquisa.getText()) != -1)
                tC += p.matcher(ctor[i].toString()).replaceAll("")  + "\n";
            }  
            for(int i = 0; i < f.length; i++){
              if(f[i].toString().indexOf(txtPesquisa.getText()) != -1)
                tP += p.matcher(f[i].toString()).replaceAll("")  + "\n";
            }
          }
          
          if(c.isInterface())
            inter.setSelected(true);
          else
            inter.setSelected(false);
            
          if(c.isPrimitive())
            prim.setSelected(true);
          else
            prim.setSelected(false);
        }
        catch(ClassNotFoundException excp){
           JOptionPane.showMessageDialog(null, "Classe não encontrada");
        }
         
        met.append(tM);
        cons.append(tC);
        pro.append(tP);
      }
    }
  }
}