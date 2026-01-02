import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CaixaListagem2 extends JFrame{
  JList lista;
  String cidades[] = {"Goiânia", "São Paulo",
                      "Brasília", "Rio de Janeiro",
                      "Salvador", "Cuiabá",
                      "Curitiba", "Belo Horizonte"};
  
  public CaixaListagem2(){
    super("Uso da classe JList");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout();
    tela.setLayout(layout);
    
    Tratador trat = new Tratador();
    
    lista = new JList(cidades);
    lista.setVisibleRowCount(5);
    lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    
    JScrollPane painelRolagem = new JScrollPane(lista);
    
    JButton exibirBtn = new JButton("Exibir Valores Selecionados");
    exibirBtn.addActionListener(trat);
    
    tela.add(painelRolagem);
    tela.add(exibirBtn);
    
    pack();
    setVisible(true);  
  }
  
  public static void main(String args[]){
    CaixaListagem2 app = new CaixaListagem2();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
  	public void actionPerformed(ActionEvent e){
  	  Object sel[] = lista.getSelectedValues();
  	  String resultado = "Valores Selecionados:\n";
  	  
  	  for(int i = 0; i < sel.length; i++)
  	  	resultado += sel[i].toString() + "\n";
  	  
  	  JOptionPane.showMessageDialog(null, resultado);
  	}
  }
}