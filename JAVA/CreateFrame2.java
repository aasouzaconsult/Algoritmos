import java.awt.*;

class CreateFrame2 {
  public static void main(String[] args) {
    // criação dos componentes
    Frame frame1 = new Frame();
    Label label1 = new Label("Label 1");
    Panel panel1 = new Panel();
    Button button1 = new Button("Button 2");
    Button button2 = new Button("Button 2");
    // novo painel
    Panel panel2 = new Panel();
    TextField textField1 = new TextField();
    // montagem da estrutura dos componentes
    frame1.add(label1);
    frame1.add(panel1);
    panel1.add(button1);
    panel1.add(button2);
    panel1.add(panel2);
    panel2.add(textField1);
    // alteração de propriedades dos elementos
    label1.setBackground(Color.red);
    panel1.setBackground(Color.green);
    // organização visual da tela
    frame1.setLayout(new FlowLayout());
    frame1.pack();
    frame1.show();
  }
}

    
  
