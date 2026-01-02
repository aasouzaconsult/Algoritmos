import javax.swing.*;
import java.awt.*;

public class BorderLayoutAvancado extends JFrame{
  public BorderLayoutAvancado(){
    super("O gerenciador de layout BorderLayout");
 
    Container tela = getContentPane();
    
    BorderLayout layout = new BorderLayout();
    tela.setLayout(layout);
    
    JLabel rotulo = new JLabel("Nome do Usuário:");
    JLabel rotulo2 = new JLabel("Pressione ESC para sair da janela em ação");
    JTextField caixa = new JTextField(10);
    JButton bt1 = new JButton("<< Voltar");
    JButton bt2 = new JButton("Continuar >>");
    
    JPanel pSuperior = new JPanel();
    pSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));
    pSuperior.add(rotulo);
    pSuperior.add(caixa);
    
    JPanel pCentro = new JPanel();
    pCentro.setLayout(new FlowLayout(FlowLayout.LEFT));
    pCentro.add(bt1);
    pCentro.add(bt2);
    
    JPanel pInferior = new JPanel();
    pInferior.setLayout(new FlowLayout(FlowLayout.LEFT));
    pInferior.add(rotulo2);
    
    tela.add(BorderLayout.NORTH, pSuperior);
    tela.add(BorderLayout.CENTER, pCentro);
    tela.add(BorderLayout.SOUTH, pInferior);
    
    pack();
    
    setSize(280,350);
    setLocation(280,235);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    BorderLayoutAvancado app = new BorderLayoutAvancado();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}