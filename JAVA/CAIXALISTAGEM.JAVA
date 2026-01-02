import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CaixaListagem extends JFrame{
  JList lista;
  String cidades[] = {"Goiânia", "São Paulo",
                      "Brasília", "Rio de Janeiro",
                      "Salvador", "Cuiabá",
                      "Curitiba", "Belo Horizonte"};
  
  public CaixaListagem(){
    super("Uso da classe JList");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout();
    tela.setLayout(layout);
    
    Tratador trat = new Tratador();
    
    lista = new JList(cidades);
    lista.setVisibleRowCount(5);
    lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    JScrollPane painelRolagem = new JScrollPane(lista);
    
    JButton exibirBtn = new JButton("Exibir Valor Selecionado");
    exibirBtn.addActionListener(trat);
    
    tela.add(painelRolagem);
    tela.add(exibirBtn);
    
    pack();
    setVisible(true);  
  }
  
  public static void main(String args[]){
    CaixaListagem app = new CaixaListagem();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
  	public void actionPerformed(ActionEvent e){
  	  JOptionPane.showMessageDialog(null, cidades[lista.getSelectedIndex()]);
  	}
  }
}