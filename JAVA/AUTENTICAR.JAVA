import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Autenticar extends JFrame{
  Senha janela;
  String usuario = "claudemir", senha = "javasun";
  
  public Autenticar(){
    super("Bem-vindo à janela principal do aplicativo");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    janela = new Senha(null, "Nome de Usuário de Senha", true);
    janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    janela.setVisible(true);
    
    setSize(400,300);
    setLocation(280,235);//RelativeTo(null)
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Autenticar app = new Autenticar();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void verificar(String u, String s){
    if((u.equals(usuario)) && (s.equals(senha)))
      janela.hide();
    else{
      JOptionPane.showMessageDialog(null, "Dados Incorretos.");
      janela.txtUsuario.requestFocus();
    }
  }
  
  private class Senha extends JDialog{
    JTextField txtUsuario;
    JPasswordField txtSenha;
    JButton entrar, cancelar;
  	
  	public Senha(Frame owner, String title, boolean modal){
  	  super(owner, title, modal);
  	  
      Container tela = getContentPane();
    
      BorderLayout layout = new BorderLayout();
      tela.setLayout(layout);
    
      JLabel lblUsuario = new JLabel("Nome do Usuário:");
      JLabel lblSenha = new JLabel("Senha:");
      txtUsuario = new JTextField(10);
      txtSenha = new JPasswordField(10);
    
      JPanel superior = new JPanel();
      superior.setLayout(new GridLayout(2, 2, 5, 5));
      superior.add(lblUsuario);
      superior.add(txtUsuario);
      superior.add(lblSenha);
      superior.add(txtSenha);
      
      JPanel superior2 = new JPanel();
      
      String titulo = "Informe o nome de usuário e Senha";
      Border etched = BorderFactory.createEtchedBorder();
      Border borda = BorderFactory.createTitledBorder(etched, titulo);
      
      superior2.setBorder(borda);
      superior2.setLayout(new FlowLayout(FlowLayout.LEFT));
      superior2.add(superior);
    
      Tratador trat = new Tratador();
      
      entrar = new JButton("Entrar");
      entrar.addActionListener(trat);
      getRootPane().setDefaultButton(entrar);
      
      cancelar = new JButton("Cancelar");
      cancelar.addActionListener(trat);
      
      JPanel inferior = new JPanel();
      inferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
      inferior.add(entrar);
      inferior.add(cancelar);
      
      tela.add(BorderLayout.NORTH, superior2);
      tela.add(BorderLayout.SOUTH, inferior);
      
  	  setSize(280, 150);
      setLocationRelativeTo(null);
  	}
  	
    private class Tratador implements ActionListener{
      public void actionPerformed(ActionEvent e){
        String senha = new String(txtSenha.getPassword());
        
        if(e.getSource() == entrar){
          verificar(txtUsuario.getText(), senha);
        }
        else
          System.exit(0);  
      }
    }
  }
}