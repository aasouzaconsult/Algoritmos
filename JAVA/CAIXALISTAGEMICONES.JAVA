import javax.swing.*;
import java.awt.*;

public class CaixaListagemIcones extends JFrame{
  JList lista;
  ImageIcon icone1, icone2;
  String cidades[] = {"Goiânia", "São Paulo",
                      "Brasília", "Rio de Janeiro",
                      "Salvador", "Cuiabá",
                      "Curitiba", "Belo Horizonte"};
  
  public CaixaListagemIcones(){
    super("Uso da classe JList");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout);
    
    icone1 = new ImageIcon("diretorio.gif");
    icone2 = new ImageIcon("box.gif");
    
    Icones renderizador = new Icones();
    
    lista = new JList(cidades);
    lista.setCellRenderer(renderizador);
    lista.setVisibleRowCount(6);
    lista.setSelectedIndex(1);  
    lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    tela.add(new JScrollPane(lista));
    
    setSize(300, 160);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    CaixaListagemIcones app = new CaixaListagemIcones();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Icones extends JLabel implements ListCellRenderer{
  	public Icones(){
      setOpaque(true);
    }
    
    public Component getListCellRendererComponent(
      JList list, Object value, int index, boolean isSelected,
      boolean cellHasFocus){
        
        setText(value.toString());
        
        if(!isSelected){
          setIcon(icone1);
          setBackground(lista.getBackground());
        }
        else{
          setIcon(icone2);
          setBackground(lista.getSelectionBackground());
        } 
      
      return this;
    }
  }
}