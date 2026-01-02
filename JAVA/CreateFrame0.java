import java.awt.*;

class CreateFrame0 {
  public static void main(String[] args) {
    // criação dos componentes
    Frame frame1 = new Frame();
    Label label1 = new Label("Label 1");
    Panel panel1 = new Panel();
    Button button1 = new Button("Button 2");
    Button button2 = new Button("Button 2");
    // montagem da estrutura dos componentes
    frame1.add(label1);
    frame1.add(panel1);
    panel1.add(button1);
    panel1.add(button2);
    // organização visual da tela
    frame1.setLayout(new FlowLayout());
    frame1.pack();
    frame1.show();
  }
}

    
  
