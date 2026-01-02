import javax.swing.*;
import java.awt.*;

public class ListaCorAlternada extends JFrame{
  JList lista;
  String cidades[] = {"Goiânia", "São Paulo",
                      "Brasília", "Rio de Janeiro",
                      "Salvador", "Cuiabá",
                      "Curitiba", "Belo Horizonte"};
  
  public ListaCorAlternada(){
    super("Uso da classe JList");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout);
    
    Cores renderizador = new Cores();
    
    lista = new JList(cidades);
    lista.setCellRenderer(renderizador);
    lista.setVisibleRowCount(7);
    lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    tela.add(new JScrollPane(lista));
    
    setSize(250, 160);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    ListaCorAlternada app = new ListaCorAlternada();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Cores extends JLabel implements ListCellRenderer{
  	public Cores(){
      setOpaque(true);
    }
    
    public Component getListCellRendererComponent(
      JList list, Object value, int index, boolean isSelected,
      boolean cellHasFocus){
        
        setText(value.toString());
        
        if(!isSelected){
          if(index % 2 == 0)
            setBackground(Color.orange);
          else
            setBackground(lista.getBackground());
        }
        else
          setBackground(lista.getSelectionBackground()); 
      
      return this;
    }
  }
}