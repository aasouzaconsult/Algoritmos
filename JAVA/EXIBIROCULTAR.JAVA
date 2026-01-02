import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExibirOcultar extends JFrame{
  JTextField caixa;
  JButton exibir, ocultar;
  
  public ExibirOcultar(){
    super("Exibindo e ocultando componentes");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    TratadorEventos trat = new TratadorEventos();
    
    caixa = new JTextField("Digite aqui...", 10);
    
    exibir = new JButton("Exibir");
    exibir.addActionListener(trat);
    
    ocultar = new JButton("Ocultar");
    ocultar.addActionListener(trat);
    
    tela.add(caixa);
    tela.add(exibir);
    tela.add(ocultar);
    
    setSize(350, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    ExibirOcultar app = new ExibirOcultar();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class TratadorEventos implements ActionListener{
    public void actionPerformed(ActionEvent evento){
      if(evento.getSource() == exibir){
        caixa.setVisible(true);
      }
      else{
        caixa.setVisible(false);
      }
    }
  }
}