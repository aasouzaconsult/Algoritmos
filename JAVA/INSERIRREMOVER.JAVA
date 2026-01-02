import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InserirRemover extends JFrame{
  JList lista1, lista2;
  DefaultListModel modelo1, modelo2;
  JButton removerBtn;
  String cidades[] = {"Goiânia", "São Paulo",
                      "Brasília", "Rio de Janeiro",
                      "Salvador", "Cuiabá",
                      "Curitiba", "Belo Horizonte"};
  
  public InserirRemover(){
    super("Uso da classe JList");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout();
    tela.setLayout(layout);
    
    Tratador trat = new Tratador();
    
    modelo1 = new DefaultListModel();
    modelo2 = new DefaultListModel();
    
    for(int i = 0; i < cidades.length; i++)
      modelo1.addElement(cidades[i]);
    
    lista1 = new JList(modelo1);
    lista1.setVisibleRowCount(5);
    lista1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    lista2 = new JList(modelo2);
    lista2.setVisibleRowCount(5);
    lista2.setFixedCellWidth(120);
    lista2.setFixedCellHeight(20);
    lista2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    removerBtn = new JButton("Remover >>>");
    removerBtn.addActionListener(trat);
    
    tela.add(new JScrollPane(lista1));
    tela.add(removerBtn);
    tela.add(new JScrollPane(lista2));
    
    pack();
    setVisible(true);  
  }
  
  public static void main(String args[]){
    InserirRemover app = new InserirRemover();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
  	public void actionPerformed(ActionEvent e){
  	  int index = lista1.getSelectedIndex();
  	  
  	  modelo2.addElement(lista1.getSelectedValue());
  	  modelo1.remove(index);
  	  
  	  if(modelo1.getSize() == 0)
  	    removerBtn.setEnabled(false); 
  	}
  }
}