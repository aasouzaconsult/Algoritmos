import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BotaoPadrao extends JFrame{
  JButton btnUm, btnDois, btnTres;
  Container tela;
  
  public BotaoPadrao(){
    super("Definindo o do bot�o padr�o");
 
    tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    btnUm = new JButton("Bot�o 1");
    btnDois = new JButton("Bot�o 2");
    btnTres = new JButton("Bot�o 3");
    
    getRootPane().setDefaultButton(btnDois);
    
    tela.add(btnUm);
    tela.add(btnDois);
    tela.add(btnTres);
    
    TratEventos trat = new TratEventos();
    
    for(int i = 0; i < tela.getComponentCount(); i++){
    	((JButton) tela.getComponent(i)).addActionListener(trat);
    }
    
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    BotaoPadrao app = new BotaoPadrao();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class TratEventos implements ActionListener{
  	public void actionPerformed(ActionEvent evento){
  	  String nome = ((JButton)(evento.getSource())).getText();
  	  JOptionPane.showMessageDialog(null, nome);    
  	}
  } 
}