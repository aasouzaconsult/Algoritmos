import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InserirRemover2 extends JFrame{
  JList lista1, lista2;
  DefaultListModel modelo1, modelo2;
  String cidades[] = {"Goiânia", "São Paulo",
                      "Brasília", "Rio de Janeiro",
                      "Salvador", "Cuiabá",
                      "Curitiba", "Belo Horizonte};
  
  public InserirRemover2(){
    super("Uso da classe JList");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout();
    tela.setLayout(layout);
     
    modelo1 = new DefaultListModel();
    modelo2 = new DefaultListModel();
    
    for(int i = 0; i < cidades.length; i++)
      modelo1.addElement(cidades[i]);
    
    lista1 = new JList(modelo1);
    lista1.setVisibleRowCount(5);
    lista1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    lista1.addMouseListener(
      new MouseAdapter(){
        public void MouseClicked(MouseEvent e){
          if(e.getClickCount() == 2){
            int index = lista1.locationToIndex(e.getPoint());
      
            if(modelo1.getSize() > 0){
              modelo2.addElement(lista1.getSelectedValues());
              modelo1.remove(index);
            }
          }
        }
      }
    );
    
    lista2 = new JList(modelo2);
    lista2.setVisibleRowCount(5);
    lista2.setFixedCellWidth(120);
    lista2.setFixedCellHeight(20);
    lista2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    tela.add(new JScrollPane(lista1));
    tela.add(new JScrollPane(lista2));
    
    pack();
    setVisible(true);  
  }
  
  public static void main(String args[]){
    InserirRemover2 app = new InserirRemover2();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}