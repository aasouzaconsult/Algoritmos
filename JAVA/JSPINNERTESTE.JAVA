import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class JSpinnerTeste extends JFrame{
  JSpinner spinner;
  
  public JSpinnerTeste(){
    super("Uso do controle JSpinner");
 
    Container tela = getContentPane();
    tela.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    SpinnerNumberModel modelo = new SpinnerNumberModel(1980, 1970, 2020, 1);
    spinner = new JSpinner(modelo);
    JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinner, "0000");
    spinner.setEditor(editor);
    
    JButton exibir = new JButton("Exibir!");
    exibir.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          String texto = "Valor selecionado: " + spinner.getValue();
          JOptionPane.showMessageDialog(null, texto);  
        } 
      }
    );
    
    tela.add(new JLabel("Ano de nascimento:"));
    tela.add(spinner);
    tela.add(exibir);
    
    setSize(300, 150);
    setVisible(true);
  }
  
  public static void main(String args[]){
    JSpinnerTeste app = new JSpinnerTeste();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}