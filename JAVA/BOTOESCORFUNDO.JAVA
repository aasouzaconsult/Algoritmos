import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BotoesCorFundo extends JFrame{
  JButton verde, amarelo, branco;
  Container tela;
  
  public BotoesCorFundo(){
    super("Cor de fundo para os botões");
 
    tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    verde = new JButton("Verde");
    verde.setBackground(Color.green);
    
    amarelo = new JButton("Amarelo");
    amarelo.setBackground(Color.yellow);
    
    branco = new JButton("Branco");
    branco.setBackground(Color.white);
    
    tela.add(verde);
    tela.add(amarelo);
    tela.add(branco);
    
    TratEventos trat = new TratEventos();
    
    for(int i = 0; i < tela.getComponentCount(); i++){
    	((JButton) tela.getComponent(i)).addActionListener(trat);
    }
    
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    BotoesCorFundo app = new BotoesCorFundo();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class TratEventos implements ActionListener{
  	public void actionPerformed(ActionEvent evento){
  	  Color cor = ((JButton)(evento.getSource())).getBackground();
  	  tela.setBackground(cor);    
  	}
  } 
}