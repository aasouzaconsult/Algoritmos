import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JSpinnerTeste2 extends JFrame{
  JSpinner spinner;
  
  public JSpinnerTeste2(){
    super("Uso do controle JSpinner");
 
    Container tela = getContentPane();
    tela.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    SpinnerDateModel modelo = new SpinnerDateModel();
    modelo.setCalendarField(Calendar.DAY_OF_MONTH);
    spinner = new JSpinner(modelo);
    JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
    spinner.setEditor(editor);
    
    JButton exibir = new JButton("Exibir!");
    exibir.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          String texto = "Data de Nascimento: " + spinner.getValue();
          JOptionPane.showMessageDialog(null, texto);  
        } 
      }
    );
    
    tela.add(new JLabel("Data de Nascimento:"));
    tela.add(spinner);
    tela.add(exibir);
    
    setSize(300, 150);
    setVisible(true);
  }
  
  public static void main(String args[]){
    JSpinnerTeste2 app = new JSpinnerTeste2();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}