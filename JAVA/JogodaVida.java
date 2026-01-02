/**----------------------------------------------------------------------*/
/** Regras do Jogo da Vida:                                              */
/** 1.Uma célula viva com menos de dois vizinhos morre de isolamento.    */
/** 2.Uma célula viva com mais de três vizinhos morre sufocada.          */
/** 3.Uma célula morta nasce numa casa com exatamente três vizinhos.     */
/** 4.Consideram-se inexistentes os vizinhos virtuais fora da grade.     */
/** Um novo jogo dispõe algumas células aleatoriamente na grade.         */
/** É possível acrescentar ou remover células com cliques do mouse em    */
/** qualquer instante, mesmo com o jogo em andamento.                    */
/** Versão programada com AWT e botões nas células.                      */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

// <applet code=JogoDaVidaw.class width=402 height=454>
// </applet>

public class JogoDaVidaw extends Applet implements Runnable, ActionListener,
       AdjustmentListener { 
  
  final Color corViva  = new Color(0xff,0xf0,0xdc),
              corMorta = new Color(0x8f,0x8f,0xbd),
              corFundo = new Color(0xea,0xea,0xae), 
              corBotão = new Color(0xff,0xf0,0xdc);

  int vivas = 0, nrc = 25; 
  float prob = 0.2f;
  boolean[][] aestado = new boolean[nrc][nrc];
  boolean[][] nestado = new boolean[nrc][nrc];

  Label titulo, contador = new Label("000"); 
  Button bComeça, bPasso, bPausa, bLimpa, bNovo;
  Button[][] botões = new Button[nrc][nrc];
  Thread vida = null;
  Scrollbar sb;
  int  vzero = 80, espera = 1000 - (vzero-1)*10;

  public void init() {
    Panel norte = new Panel(new FlowLayout(FlowLayout.CENTER,15,15));
    norte.setBackground(corFundo);
    norte.add(bComeça=acertaBotão("Começa"));
    norte.add(bPausa=acertaBotão("Pausa"));
    norte.add(bPasso=acertaBotão("Passo"));
    norte.add(bLimpa=acertaBotão("Limpa"));
    norte.add(bNovo=acertaBotão("Novo"));

    Panel sul = new Panel(new BorderLayout());
    sul.setBackground(corFundo);
    Panel info = new Panel(new GridLayout(1,1,1,1));
    info.setBackground(corFundo);
    info.add(titulo = new Label(" População = ")); 
    titulo.setForeground(Color.blue); 
    info.add(contador);
    contador.setForeground(Color.magenta);
    Panel barra = new Panel(new BorderLayout());
    barra.setBackground(corFundo);
    sb = new Scrollbar(Scrollbar.HORIZONTAL,vzero,1,1,101);
    sb.setBackground(Color.cyan);
    sb.addAdjustmentListener(this);
    barra.add(new Label("Lento"),BorderLayout.WEST);
    barra.add(sb,BorderLayout.CENTER);
    barra.add(new Label("Rápido"),BorderLayout.EAST);
    sul.add(info,BorderLayout.WEST);
    sul.add(barra,BorderLayout.CENTER);

    Panel centro = new Panel(new GridLayout(nrc,nrc));
    centro.setBackground(corFundo);

    for (int i = 0; i < nrc; ++i)
      for (int j = 0; j < nrc; ++j) {
        centro.add(botões[i][j] = new Button(" "));
        botões[i][j].setBackground(corMorta);
        botões[i][j].setActionCommand(i + "," + j); 
        botões[i][j].addActionListener(this);
      }

    setLayout(new BorderLayout());
    add(norte,BorderLayout.NORTH);   
    add(centro,BorderLayout.CENTER);
    add(sul,BorderLayout.SOUTH);

    estadoBotão(true,true,false);
  }

  public Button acertaBotão(String nome) {
    Button b = new Button(nome);
    b.setBackground(corBotão);
    b.addActionListener(this);
    return b;
  }
  
  public void run() {
    while (vida != null && atualizaEstado() != 0) {
      try {vida.sleep(espera);}
      catch (InterruptedException e) {}
    }
    vida = null;
    estadoBotão(true,true,false);
  }

  public void stop() {
    if (vida != null) {
      vida.interrupt();
      vida = null;
    }
  }

  final private int atualizaEstado() {
    for (int i = 0; i < nrc; ++i)
      for (int j = 0; j < nrc; ++j) {
        
        int vizinhos = vizinho(i-1,j-1) + vizinho(i,j-1) + 
            vizinho(i+1,j-1) + vizinho(i-1,j) + vizinho(i+1,j) +
            vizinho(i-1,j+1) + vizinho(i,j+1) + vizinho(i+1,j+1);
        
        if (!aestado[i][j]) nestado[i][j] = (vizinhos == 3); 
        else nestado[i][j] = (1 < vizinhos && vizinhos < 4);
      }
    return desenhaCelula();  
  }

  final private int vizinho(int i,int j) {
    if (i < 0) return 0;
    else if (i > nrc-1) return 0;
    if (j < 0) return 0;
    else if (j > nrc-1) return 0;
    else return (aestado[i][j]) ? 1 : 0;
  }

  final private int desenhaCelula() {
    vivas = 0;
    for (int i = 0; i < nrc; ++i)
       for (int j = 0; j < nrc; ++j) {
         aestado[i][j] = nestado[i][j];
         if (nestado[i][j]) {
           botões[i][j].setBackground(corViva);
           ++vivas;
         }
         else botões[i][j].setBackground(corMorta);
       }
    contador.setText(String.valueOf(vivas));
    return (vivas);
  }

  public void actionPerformed(ActionEvent e) {
    Button ativo = (Button) e.getSource();
    if (bNovo == ativo) novoJogo(); 
    else if (bComeça == ativo) começaJogo();
    else if (bPasso == ativo) passoAPasso();
    else if (bPausa == ativo) suspendeJogo();
    else if (bLimpa == ativo) limpaGrade();
    else verificaBotão(ativo);
  }

  final private void novoJogo() {
    for (int i = 0; i < nrc; ++i)
      for (int j = 0; j < nrc; ++j)
        aestado[i][j] = nestado[i][j] = (Math.random() < prob);

    vida = null;
    estadoBotão(true,true,false);  
    desenhaCelula();
  }

  final private void começaJogo() {
    estadoBotão(false,true,true);
    espera = 1000 - (sb.getValue()-1)*10; 

    if (vida == null) {
      vida = new Thread(this);
      vida.start();
    }
    else vida.interrupt();
  }

  final private void passoAPasso() {
    espera = 1800*1000;
    if (vida != null) vida.interrupt();
    else começaJogo();
    estadoBotão(true,true,false);
  }

  final private void verificaBotão(Button b) {
    String s = b.getActionCommand();
    int v = s.indexOf(',');
    int i = Integer.parseInt(s.substring(0,v));
    int j = Integer.parseInt(s.substring(v+1));
    aestado[i][j] = !aestado[i][j];
    if (aestado[i][j]) {
      ++vivas;
      botões[i][j].setBackground(corViva);
    }
    else {
      --vivas;
      botões[i][j].setBackground(corMorta);
    }
    contador.setText(String.valueOf(vivas));
    bPausa.requestFocus();   
  }

  final private void suspendeJogo() {
    espera = 1800*1000;
    estadoBotão(true,true,false);
  }

  final private void limpaGrade() {

    for (int i = 0; i < nrc; ++i)
      for (int j = 0; j < nrc; ++j)
        nestado[i][j] = false;

    vida = null;
    estadoBotão(true,true,false);
    desenhaCelula();
  }

  final private void estadoBotão(boolean b1, boolean b2, boolean b3) {
    bComeça.setEnabled(b1); 
    bPasso.setEnabled(b2);
    bPausa.setEnabled(b3); 
  }

  public void adjustmentValueChanged(AdjustmentEvent e) {
    espera = 1000 - (sb.getValue()-1)*10; 
  }

}
