/**----------------------------------------------------------------------*/
/** Exemplo de um jogo gráfico usando gerentes de layout e botões.       */
/** O objetivo do jogo é acender todas as luzes do quadro (amarelo).     */
/** O clique em uma casa inverte o seu estado (acesa/apagada) além do    */
/** estado de todas as casas adjacentes na mesma linha e mesma coluna.   */
/** Substitui o método update para eliminar o tremido da tela.           */
/** Funciona tanto como applet quanto como aplicativo usa classe JANELA. */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Luzes2.java            
// <applet code=Luzes2.class width=300 height=200>
// </applet>

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Luzes2 extends Applet implements ActionListener {
  
  int dim = 5, acesas = 0, apagadas = 0;
  boolean[][] luzes = new boolean[dim][dim];
  boolean end = false;
  
  Label acesa = new Label(0 + " acesas");
  Label apagada = new Label(dim*dim + " apagadas");
  Button[][] casa = new Button[dim][dim];
  Button iniciar = new Button("Recomeçar"); 
  Label mensagem = new Label("");


  public Luzes2() {
    Panel centro = new Panel(new GridLayout(dim,dim,0,0));
    Panel leste  = new Panel(new GridLayout(4,1,0,26));
    Panel sul    = new Panel(new GridLayout(1,1));

    setLayout(new BorderLayout(10,10));
    setBackground(Color.white);

    for (int i = 0;  i < dim; i++) 
      for (int j = 0; j < dim; ++j) {
        centro.add(casa[i][j] = new Button("     "));
        casa[i][j].setBackground(Color.gray);
        casa[i][j].setActionCommand(i + "," + j);
        casa[i][j].addActionListener(this);
      }

    Font f = new Font("Courier New",Font.BOLD,18);
    leste.add(acesa);
    leste.add(apagada);
    leste.add(iniciar);   
    apagada.setBackground(Color.lightGray);
    acesa.setBackground(Color.yellow);
    iniciar.addActionListener(this);
    iniciar.setBackground(Color.cyan);
    mensagem.setBackground(Color.blue);
    mensagem.setForeground(Color.red);
    mensagem.setFont(f);
    sul.add(mensagem);
    add(centro,BorderLayout.CENTER);
    add(leste,BorderLayout.EAST);
    add(sul,BorderLayout.SOUTH);
  }

  public void init() {
    for (int i=0; i < dim; i++)
      for (int j=0; j < dim; j++)
        luzes[i][j] = false;
    end = false;
    repaint();
  }

  public void update(Graphics g) {
    mensagem.setText("");
    paint(g);
  }

  public void paint(Graphics g) {
    contaLuz(g);
    desenhaLuz(g); 
  }  

  private void desenhaLuz(Graphics g) {
    for (int i=0; i < dim; i++) 
       for (int j=0; j < dim; ++j) {
         if (luzes[i][j]) casa[i][j].setBackground(Color.yellow);
           else casa[i][j].setBackground(Color.gray);
    }    
  }

  private void contaLuz(Graphics g) {
    acesas = apagadas = 0;
    for (int i = 0; i < dim; i++)
      for (int j = 0; j < dim; j++)
        if (luzes[i][j]) ++acesas;
        else ++apagadas;
    acesa.setText(acesas + " acesas");
    apagada.setText(apagadas + " apagadas");
    if (apagadas <= 3) verifica(g);
  }

  private void verifica(Graphics g) {
    if (apagadas == 3) mensagem.setText("Chegou perto da solução!");
    else if (apagadas == 2) mensagem.setText("Faltou um pouquinho só!");
    else if (apagadas == 1) mensagem.setText("Quase vale uma vitória!");
    else mensagem.setText("Acertou! Meus parabéns!");
  }

  public void actionPerformed(ActionEvent e) { 
    Button b = (Button) e.getSource();
    if (b == iniciar) init();
    else if (end) return;
    else {
      String s = b.getActionCommand();
      int v = s.indexOf(',');
      int i = Integer.parseInt(s.substring(0,v));
      int j = Integer.parseInt(s.substring(v+1));
      luzes[i][j] = !luzes[i][j];
      if (j < dim-1) luzes[i][j+1] = !luzes[i][j+1];
      if (j > 0)     luzes[i][j-1] = !luzes[i][j-1];
      if (i < dim-1) luzes[i+1][j] = !luzes[i+1][j];
      if (i > 0)     luzes[i-1][j] = !luzes[i-1][j];
      repaint();
    }
  }

  public static void main(String[] args) {
    Janela1 frame = new Janela1("Jogo das Luzes");
    Luzes2 applet = new Luzes2();
    frame.add(applet,BorderLayout.CENTER);
    frame.setSize(320,230);
    frame.setLocation(300,300);
    frame.show();
    applet.init();
    applet.start();
  }
}