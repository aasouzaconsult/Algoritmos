import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class CaixaListagemChange extends JFrame{
  JList lista;
  JTextField campo;
  String cidades[] = {"Goiânia", "São Paulo",
                      "Brasília", "Rio de Janeiro",
                      "Salvador", "Cuiabá",
                      "Curitiba", "Belo Horizonte"};
  
  public CaixaListagemChange(){
    super("Uso da classe JList");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout();
    tela.setLayout(layout);
    
    lista = new JList(cidades);
    lista.setVisibleRowCount(5);
    lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    lista.addListSelectionListener(
      new ListSelectionListener(){
      	public void valueChanged(ListSelectionEvent e){
      	  campo.setText(lista.getSelectedValue().toString());	
      	}
      }	
    );
    
    JScrollPane painelRolagem = new JScrollPane(lista);
     
    campo = new JTextField(10);
    campo.setEditable(false); 
    
    tela.add(painelRolagem);
    tela.add(new JLabel("Valor Selecionado:"));
    tela.add(campo);
    
    setSize(350, 150);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    CaixaListagemChange app = new CaixaListagemChange();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}