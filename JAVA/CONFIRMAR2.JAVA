import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Confirmar2 extends JFrame{
  JLabel status;
  
  public Confirmar2(){
    super("Usando diálogos de confirmação");
 
    Container tela = getContentPane();
    tela.setLayout(new FlowLayout(FlowLayout.LEFT));
 
    status = new JLabel("Status");
    
    JButton clique = new JButton("Clique");
    clique.addMouseListener(
      new MouseAdapter(){
        public void mouseClicked(MouseEvent e){
          Object[] botoes = {"Sim", "Não", "Cancelar"};

          int result = JOptionPane.showOptionDialog(null,
                "Você gosta mesmo de programar em Java?",
                "Pesquisa", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, botoes, botoes[0]);
                
          if(result == 0)
            status.setText("Opção escolhida: Sim, escolha correta.");
          if(result == 1)
            status.setText("Opção escolhida: Não, pense na besteira que vai fazer!");
          if(result == 2)
            status.setText("Opção escolhida: Cancelar");
          if(result == JOptionPane.CLOSED_OPTION)
            status.setText("Fechou o diálogo sem responder");
        } 
      }
    );
    
    tela.add(clique);
    tela.add(status);
 
    setLocation(280,235);
    setSize(350, 200);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Confirmar2 app = new Confirmar2();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}