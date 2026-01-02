import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class JSpinnerTeste3 extends JFrame{
  JSpinner spinner;
  
  public JSpinnerTeste3(){
    super("Uso do controle JSpinner");
 
    Container tela = getContentPane();
    tela.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    String[] dias = new DateFormatSymbols().getWeekdays();
    SpinnerListModel modelo = new SpinnerListModel(Arrays.asList(dias).subList(1, 8));
    spinner = new JSpinner(modelo);
    spinner.setPreferredSize(new Dimension(120, 20));
    
    JButton exibir = new JButton("Exibir!");
    exibir.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          String texto = "Dia da Semana: " + spinner.getValue();
          JOptionPane.showMessageDialog(null, texto);  
        } 
      }
    );
    
    tela.add(new JLabel("Dia da Semana:"));
    tela.add(spinner);
    tela.add(exibir);
    
    setSize(300, 150);
    setVisible(true);
  }
  
  public static void main(String args[]){
    JSpinnerTeste3 app = new JSpinnerTeste3();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}