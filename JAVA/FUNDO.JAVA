import javax.swing.*;
import java.awt.*;

public class Fundo extends JFrame{
  public Fundo(){
    super("Posicionando controles sobre uma imagem de fundo");
    
       
    
    JPanel painel = new JPanel();
    painel.setOpaque(false);
    painel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    
    JLabel lblUsuario = new JLabel("Usuário:");
    JTextField txtUsuario = new JTextField(8);
    JButton btnOK = new JButton("OK");
    
    painel.add(lblUsuario);
    painel.add(txtUsuario);
    painel.add(btnOK);
    
    setGlassPane(painel);
    getGlassPane().setVisible(true);
    
    Container tela = getContentPane();
    tela.setLayout(new BorderLayout());
      
    ImageIcon imagem = new ImageIcon("java_exemplos/imagens/fundo.jpg");//fundo.jpg
    JLabel rotulo = new JLabel(imagem);
    
    tela.add(rotulo, BorderLayout.CENTER);
    
    setLocation(280,235);
    setSize(460,200);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Fundo app = new Fundo();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}