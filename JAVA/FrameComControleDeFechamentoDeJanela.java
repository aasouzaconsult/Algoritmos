import java.awt.*;

class FrameComControleDeFechamentoDeJanela {
  public static void main(String[] args) {
    Frame f1 = new Frame();
    f1.setTitle("Teste");
    BorderLayout bl1 = new BorderLayout();
    f1.setLayout(bl1);

    Panel p1 = new Panel();
    GridLayout gl1 = new GridLayout(2, 4);
    p1.setLayout(gl1);
    Button b1 = new Button();
    b1.setLabel("Botão 1");
    p1.add(b1);

    Button b2 = new Button("Botão 2");
    p1.add(b2);

    Label[] labels = new Label[4];
    for (int i = 0; i < 4; i++) {
      labels[i] = new Label("Rótulo "+i);
      p1.add(labels[i]);
    }
    f1.add(p1, "North");

    Panel p2 = new Panel();
    p2.setLayout(new GridLayout(3,1));
    p2.add(new Button("Botão 3"));
    p2.add(new Button("Botão 4"));
    p2.add(new Button("Botão 5"));
    f1.add(p2, "South");

    f1.pack();
    f1.show();

    java.awt.event.WindowAdapter wa1 = new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent we) {
        System.exit(0);
      }
    };
    f1.addWindowListener(wa1);
  }
}

    
  
