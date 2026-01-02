/**----------------------------------------------------------------------*/
/** Resolução Gráfica das Torres de Hanoi                                */
/** Objetivo: Passar todos os discos da primeira haste para a última,    */
/** obedecendo às regras:                                                */
/**   - Pode-se mover apenas um disco (o de cima) de cada vez            */
/**   - Nunca um disco maior pode pousar sobre um disco menor            */
/**   - A haste central é usada como pouso temporário                    */
/** Esta versão foi programada usando o AWT (obsoleto).                  */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// <applet code=Hanoi.class width=637 height=280>
// </applet>

import java.awt.*;
import java.text.*;
import java.applet.*;
import java.awt.event.*;

/*-----------------------------------------------------------------------*/
/*   Classe principal: inicializa painel, começa o jogo,                 */
/*   começa o thread de solução automática, trata os                     */
/*   de movimentos de discos.                                            */
/*-----------------------------------------------------------------------*/
public final class Hanoi extends Applet implements Runnable {
  static final int WIDTH=431, HEIGHT=205, PEG1=0, PEG2=1, PEG3=2,
                   MINDISCS=3, MAXDISCS=12;
  static final Color lightBlue = new Color(143,143,189);
  static AudioClip auSelect, auVictory, auAlmost, auDone;
  static Image img;        // Imagem fora da tela
  static Graphics off;     // Objeto gráfico para imagem fora da tela

  private boolean playing;

  private Label info;
  private Thread automatic;
  private java.util.Timer timer;

  private HanoiClock clock;
  private HanoiBoard bd;
  private HanoiPanel bp;
  private HanoiControl cp;

  // Entrada do programa (herdado de Applet)
  public void init() {
    auSelect  = getAudioClip(getCodeBase(),"move.au");
    auVictory = getAudioClip(getCodeBase(),"vitoria.au");
    auAlmost  = getAudioClip(getCodeBase(),"quase.au");
    auDone    = getAudioClip(getCodeBase(),"termino.au");

    // Obtém área para buferização dupla em HanoiPanel
    img = createImage(WIDTH,HEIGHT);
    off = img.getGraphics();

    Panel lb = new Panel(new FlowLayout(FlowLayout.LEFT));
    info = new Label();
    info.setFont(new Font("Helvetica",Font.BOLD,18));
    info.setForeground(Color.orange);
    lb.add(info);

    Label title = new Label("  Jogo das Torres  de  Hanói",Label.LEFT);
    title.setFont(new Font("TimesRoman",Font.BOLD,24));
    title.setForeground(Color.orange);

    setLayout(new BorderLayout());
    setBackground(lightBlue);
    add(title,BorderLayout.NORTH);
    add(cp = new HanoiControl(this),BorderLayout.EAST);
    add(lb,BorderLayout.SOUTH);
    add(bp = new HanoiPanel(this,cp),BorderLayout.CENTER);
    bp.setSize(WIDTH,HEIGHT);

    newGame();
  }

  // Começa um novo jogo
  void newGame() {
    int discs = cp.getDiscs();
    bp.setGameOver(false);
    info.setText("Use o MOUSE para mover os " +
      discs + " discos para uma outra haste.");
    bd = new HanoiBoard(discs,this);
    bp.drawBoard(bd,0,0,0);
    cp.setCount(0,bd.getMinMoves());
    if (cp.isClockOn() && automatic == null)
      clock = new HanoiClock(cp);
    else cp.setClock(null);
  }

  // Trata o evento 'Recomeçar'
  void restartGame() {
    stopIt();
    cp.setAutoSolveEnable(true);
    cp.setClockEnable(true);
    newGame();
  }

  // Destrói todos os threads
  void stopIt() {
    if (automatic != null) {
      automatic.interrupt();
      automatic = null;
    }
    if (playing) {
      timer.cancel();
      playing = false;
    }
  }

  // Dispara o thread 'Automático'
  void startAutomatic() {
    stopIt();
    automatic = new Thread(this,"Automatico");
    automatic.start();
  }

  // Executa o thread 'Automático' (herdado de Runnable)
  public void run() {
    newGame();
    info.setText("Resolvendo ...");
    try {solve(cp.getDiscs(),PEG1,PEG2,PEG3);}
    catch (InterruptedException e) {}
    if (auDone != null) auDone.play();
    info.setText("Terminou!");
    bp.setGameOver(true);
    automatic = null;
    cp.setAutoSolveEnable(true);
  }

  // Algoritmo recursivo das Torres de Hanói
  private void solve(int discs, int source, int aux, int target)
       throws InterruptedException {
    if (discs == 0) return;                          // Caso base
    solve(discs-1,source,target,aux);                // Chamada recursiva
    bd.moveDisc(source,target);                      // Faz um movimento
    cp.setCount(bd.getMoveCount(),bd.getMinMoves()); // Atualiza contador
    bp.drawBoard(bd,0,0,0);                          // Desenha a imagem
    automatic.sleep(cp.getDelay());                  // Espera um pouco
    solve(discs-1,aux,source,target);                // Chamada recursiva
  }

  void setTimer() {
    if (!playing && cp.isClockOn()) {
      playing = true;
      timer = new java.util.Timer();
      timer.scheduleAtFixedRate(clock,1000,1000);
    }
  }

  void setInfo(String msg) {
    info.setText(msg);
  }

  boolean isAutomatic() {
    return automatic != null;
  }

}
/*-----------------------------------------------------------------------*/
/*   Classe HanoiClock: escreve o tempo de jogo.                         */
/*-----------------------------------------------------------------------*/
final class HanoiClock extends java.util.TimerTask {
  private DecimalFormat d = new DecimalFormat("00");
  private int time;
  private HanoiControl cp;

  // Construtor
  HanoiClock(HanoiControl cp) {
    this.cp = cp;
    cp.setClock(convertTime(0));
    time = 0;
  }

  public void run() {
    cp.setClock(convertTime(++time));
  }

  private String convertTime(int time) {
    int h, m, s, r;
    h =  time / (60*60);
    r = time % (60*60);
    m = r / 60;
    s = r % 60;
    return d.format(h) + ":" + d.format(m) + ":" + d.format(s);
  }

}
/*-----------------------------------------------------------------------*/
/* Classe HanoiBoard: controla posições dos discos e regras do jogo.     */
/*-----------------------------------------------------------------------*/
final class HanoiBoard {
  static final int PEGS=3,
         DISCSIZES[][]={{68,18},{76,16},{84,14},{92,13},{100,12},
                        {108,12},{112,11},{116,10},{120,9},{124,9}};
  private int peg[][], pegTop[] = new int[PEGS], discWidth[];
  private int discs, moveCount, minMoves;
  private Hanoi main;

  // Construtor
  HanoiBoard(int discs, Hanoi main) {
    this.discs = discs;
    this.main = main;
    peg = new int[discs][PEGS];

    // Coloca todos os discos na primeira haste
    for (int i = 0; i < discs; ++i) peg[i][main.PEG1] = discs-i;
    pegTop[main.PEG1] = discs-1;
    for (int i = 1; i < PEGS; ++i) pegTop[i] = -1;

    // Calcula tamanho dos discos
    discWidth = new int[discs];
    for (int i = discs-1; i >= 0; --i)
      discWidth[i] = DISCSIZES[discs-main.MINDISCS][0] -
                     (DISCSIZES[discs-main.MINDISCS][1] *
                     (discs-1-i));

    moveCount = 0;
    minMoves = (int) Math.pow(2,discs) - 1;
  }

  void setDisc(int d,int p) {
    peg[++pegTop[p]][p] = d;
  }

  int getDisc(int d,int p) {
    return peg[d][p];
  }

  int getTopDisc(int p) {
    return peg[pegTop[p]--][p];
  }

  int getPegTop(int p) {
    return pegTop[p];
  }

  int getMoveCount() {
    return moveCount;
  }

  int getMinMoves() {
    return minMoves;
  }

  int getDiscWidth(int d) {
    return discWidth[d-1];
  }

  boolean isStartPeg(int i) {
    if ((i >= 0) && (pegTop[i] >= 0)) return true;
    else return false;
  }

  String getBoardStatus() {
    String status = null;
    if (pegTop[PEGS-1] == discs-1 || pegTop[PEGS-2] == discs-1)
      if (moveCount == minMoves) {
        status = " Parabéns! Você resolveu o problema.";
        if (main.auSelect != null) main.auVictory.play();
      }
      else {
        status = "Acertou, mas fez mais que" + minMoves + " movimentos.";
        if (main.auSelect != null) main.auAlmost.play();
      }
    return status;
  }

  // Movimentos manuais
  boolean moveDisc(int d, int p1, int p2) {
    if (p1 >= 0 && p2 >= 0) {
       // Para haste diferente que está vazia ou tem disco maior
       if (p1 != p2 && (pegTop[p2] < 0 || peg[pegTop[p2]][p2] > d)) {
          if (main.auSelect != null) main.auSelect.play();
          setDisc(d,p2);
          moveCount++;
          return true;
       }
    }
    setDisc(d,p1);
    return false;
  }

  // Movimentos automáticos
  void moveDisc(int p1, int p2) {
    setDisc(getTopDisc(p1),p2);
    moveCount++;
  }

}
/*-----------------------------------------------------------------------*/
/* Classe HanoiPanel: desenha hastes e discos usando buffer duplo.       */
/* Passa eventos do mouse para a classe principal.                       */
/*-----------------------------------------------------------------------*/
final class HanoiPanel extends Panel implements MouseListener,
	        MouseMotionListener {
  static final int PEGSPACE = 72, DISCHEIGHT = 15;
  static final Color COLOR1 = new Color(102,51,0),
                     COLOR2 = new Color(153,102,0),
                     COLOR3 = new Color(204,153,51),
                     COLOR4 = new Color(255,204,0),
                     COLOR5 = new Color(255,255,204),
                     COLOR6 = new Color(230,230,230);

  private int x, y, dragged, pegspace;
  private int sourceDisc, sourcePeg, targetPeg;
  private boolean gameOver;

  private String gameStatus;
  private Hanoi main;
  private HanoiBoard bd;
  private HanoiControl cp;

  // Construtor
  protected HanoiPanel(Hanoi main, HanoiControl cp) {
    this.main = main;
    this.cp = cp;
    addMouseListener(this);
    addMouseMotionListener(this);
  }

  void drawBoard(HanoiBoard bd, int dragged, int x, int y) {
    this.dragged = dragged;
    this.bd = bd;
    this.x = x;
    this.y = y;
    repaint();
  }

  // Chamado por repaint(), limpa o buffer fora da tela
  public void update(Graphics g) {
    main.off.setColor(COLOR6);
    main.off.fillRect(0,0,getWidth(),getHeight());
    paint(g);
  }

  public void paint(Graphics g) {
    // Desenha hastes
    drawPeg(main.off,PEGSPACE);        // Centro da primeira haste
    drawPeg(main.off,3*PEGSPACE);      // Centro da segunda haste
    drawPeg(main.off,5*PEGSPACE);      // Centro da terceira haste

    // Desenha discos
    for (int p = main.PEG1; p <= main.PEG3; p++) {
      for (int d = 0; d <= bd.getPegTop(p); d++) {
        int disc = bd.getDisc(d,p);
        if (disc != 0) {
          int width = bd.getDiscWidth(disc);
          drawDisc(main.off,(2*p+1)*PEGSPACE-width/2,
            main.HEIGHT-(d+1)*DISCHEIGHT,width);
        }
      }
    }

    // Desenha disco arrastado
    if (dragged != 0) {
      int width = bd.getDiscWidth(dragged);
      drawDisc(main.off,x-width/2,y-(int)(DISCHEIGHT/2),width);
    }

    g.drawImage(main.img,0,0,this); // Copia para a tela do Applet
  }

  // Desenha uma haste (largura 12 pixels) com 3 cores
  private void drawPeg(Graphics g, int x) {
    x -= 5;                         // Coordenada da haste
    int h = getHeight();            // Altura do painel
    int ha = 20;                    // Topo do haste
    int[] x1 = {x,x+5,x+7,x+11};    // Coordenadas x do polígono
    int[] y1 = {ha,ha-5,ha-5,ha};   // Coordenadas y do polígono
    g.setColor(COLOR1);             // Marrom mais escuro
    g.fillPolygon(x1,y1,x1.length); // Ponta da haste
    g.setColor(COLOR2);             // Marrom escuro
    g.fillRect(x,ha,2,h-ha);        // 2 pixels
    g.setColor(COLOR3);             // Marrom claro
    g.fillRect(x+2,ha,4,h-ha);      // 4 pixels
    g.setColor(COLOR2);             // Marrom escuro
    g.fillRect(x+6,ha,2,h-ha);      // 2 pixels
    g.setColor(COLOR1);             // Marrom mais escuro
    g.fillRect(x+8,ha,4,h-ha);      // 4 pixels
  }

  // Desenha um disco com 15 pixels de altura com primitivos
  private void drawDisc(Graphics g, int x, int y, int width) {
    x = fixX(x,width);                     // Acerta x
    y = fixY(y,DISCHEIGHT);                // Acerta y
    g.setColor(COLOR3);
    g.drawLine(x+4,y,x+width-4,y);         // pixel 1
    g.drawLine(x+2,y+1,x+width-2,y+1);     // pixel 2
    g.drawRect(x,y+7,width,1);             // pixels 8,9
    g.setColor(COLOR4);
    g.drawLine(x+1,y+2,x+width-1,y+2);     // pixel 3
    g.drawRect(x,y+5,width,1);             // pixels 6,7
    g.setColor(COLOR5);
    g.drawLine(x+1,y+3,x+width-1,y+3);     // pixel 4
    g.drawLine(x,y+4,x+width,y+4);         // pixel 5
    g.setColor(COLOR2);
    g.drawRect(x,y+9,width,1);             // pixels 10,11
    g.drawLine(x+1,y+11,x+width-1,y+11);   // pixel 12
    g.setColor(COLOR1);
    g.drawLine(x+1,y+12,x+width-1,y+12);   // pixel 13
    g.drawLine(x+2,y+13,x+width-2,y+13);   // pixel 14
    g.drawLine(x+4,y+14,x+width-4,y+14);   // pixel 15
  }

  // Acerta a coodenada x do disco arrastado
  private int fixX(int x, int width) {
    if (x < 0) x = 0;
    if (x > getWidth() - width) x = getHeight() - width;
    return x;
  }

  // Acerta a coordenada y do disco arrastado
  private int fixY(int y, int height) {
    if (y < height) y = 0;
    if (y > getHeight() - height) y = getHeight() - height;
    return y;
  }

  // Trata evento de seleção do disco com o mouse
  public void mousePressed(MouseEvent e) {
    if (!gameOver && !main.isAutomatic()) {
       sourcePeg = pixelToPeg(e.getX(),e.getY());
       if (bd.isStartPeg(sourcePeg)) {
         main.setTimer();
         sourceDisc = bd.getTopDisc(sourcePeg);
         drawBoard(bd,sourceDisc,e.getX(),e.getY());
       }
    }
  }

  // Trata evento de arrasto do disco com o mouse
  public void mouseDragged(MouseEvent e) {
    if (!gameOver && sourceDisc != 0)
       drawBoard(bd,sourceDisc,e.getX(),e.getY());
  }

  // Trata evento de pouso do disco com o mouse
  public void mouseReleased(MouseEvent e) {
    if (!gameOver && (sourceDisc != 0)) {
      targetPeg = pixelToPeg(e.getX(),e.getY());
      if (bd.moveDisc(sourceDisc,sourcePeg,targetPeg)) {
        cp.setCount(bd.getMoveCount(),bd.getMinMoves());
        gameStatus = bd.getBoardStatus();
        if (gameStatus == null)
          main.setInfo("O menor número possível de movimentos é " +
               bd.getMinMoves() + ".");
        else {
          gameOver = true;
          main.setInfo(gameStatus);
          main.stopIt();
        }
      }
      drawBoard(bd,0,0,0);
      sourceDisc = 0;
    }
  }

  // Conversão dos eventos de mouse (seleciona a haste)
  int pixelToPeg(int x, int y) {
    double peg = (double) x / PEGSPACE;
    if (peg < 2) return main.PEG1;
    else if (peg < 4) return main.PEG2;
    else return main.PEG3;
  }

  void setGameOver(boolean b) {
    gameOver = b;
  }

  public void mouseMoved(MouseEvent e)   {}
  public void mouseClicked(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e)  {}

}
/*-----------------------------------------------------------------------*/
/* Classe HanoiControl:  componentes de controle do jogo.                */
/*-----------------------------------------------------------------------*/
final class HanoiControl extends Panel implements ActionListener,
                  MouseListener, ItemListener, AdjustmentListener {
  private Hanoi main;
  private Color yellow = new Color(0xea,0xea,0xae);
  private Color silver = new Color(0xe6,0xe8,0xfa);
  private Button bMinus, bPlus, bReset, bSolve;
  private Label lDisc1, lDisc2, lSpeed, lPerc, lMove, lCount, lClock;
  private Scrollbar sbSpeed;
  private Checkbox cbClock;
  private int ndiscs = main.MINDISCS+1, vzero = 70, delay = (vzero-1)*10;

  // Construtor
  HanoiControl(Hanoi main) {
    this.main = main;
    setFont(new Font("Helvetica",Font.BOLD,14));

    // Discos
    Panel discs = new Panel(new FlowLayout());

    discs.add(lDisc1 = new Label("Discos"));
    lDisc1.setForeground(Color.white);

    Panel control = new Panel(new BorderLayout(7,0));
    control.setBackground(Color.cyan);

    Font button = new Font("Courier",Font.BOLD,18);
    control.add(bMinus = createButton(" - "),BorderLayout.WEST);
    bMinus.setFont(button);
    control.add(bPlus  = createButton(" + "),BorderLayout.EAST);
    bPlus.setFont(button);

    control.add(lDisc2 = new Label("",Label.CENTER),BorderLayout.CENTER);
    lDisc2.setForeground(Color.red);
    setDiscs(ndiscs);

    setPlusMinusEnable();
    discs.add(control);

   // Botões Recomeçar e Automático
    Panel buttons = new Panel();

    buttons.add(bReset = createButton("Recomeçar"));
    buttons.add(bSolve = createButton("Automático"));

    // Tempo
    Panel times = new Panel(new FlowLayout(FlowLayout.LEFT));

    times.add(cbClock = new Checkbox("Tempo",true));
    cbClock.setForeground(Color.white);
    cbClock.addItemListener(this);


    times.add(lClock = new Label("00:00:00"));
    lClock.setForeground(Color.yellow);

    // Contador de movimentos
    Panel moves = new Panel(null);
    moves.add(lMove = new Label(" Movimentos:"));
    lMove.setBounds(0,0,96,40);
    lMove.setForeground(Color.white);
    moves.add(lCount = new Label());
    lCount.setBounds(102,0,100,40);
    lCount.setForeground(Color.yellow);

    // Velocidade
    Panel speeds = new Panel(new BorderLayout());

    speeds.add(lSpeed = new Label(" Velocidade:"),BorderLayout.WEST);
    lSpeed.setForeground(Color.white);

    speeds.add(lPerc = new Label(vzero + "%"),BorderLayout.CENTER);
    lPerc.setForeground(Color.yellow);

    sbSpeed = new Scrollbar(Scrollbar.HORIZONTAL,vzero,1,1,101);
    sbSpeed.setBackground(Color.cyan);
    sbSpeed.setBlockIncrement(10);
    sbSpeed.setUnitIncrement(1);
    sbSpeed.addAdjustmentListener(this);
    speeds.add(sbSpeed,BorderLayout.SOUTH);

    // Constrói o painel
    setLayout(new GridLayout(5,1,0,7));
    add(discs);
    add(buttons);
    add(times);
    add(moves);
    add(speeds);
  }

  private Button createButton(String lb) {
    Button b = new Button(lb);
    b.setBackground(yellow);
    b.setForeground(Color.blue);
    b.addActionListener(this);
    b.addMouseListener(this);
    return b;
  }

  void setClockEnable(boolean b) {
    cbClock.setEnabled(b);
  }

  void setAutoSolveEnable(boolean b) {
    bSolve.setEnabled(b);
  }

  void setPlusMinusEnable() {
    bPlus.setEnabled(ndiscs < main.MAXDISCS);
    bMinus.setEnabled(ndiscs > main.MINDISCS);
  }

  void setDiscs(int i) {
    lDisc2.setText(String.valueOf(i));
  }

  void setClock(String s) {
    lClock.setText(s);
  }

  void setCount(int c, int m) {
    lCount.setText(c + " de " +  m);
  }

  int getDiscs() {
    return ndiscs;
  }

  int getDelay() {
    return delay;
  }

  boolean isClockOn() {
    return cbClock.getState();
  }

  // Trata cliques dos botões
  public void actionPerformed(ActionEvent e) {
    Component action = (Component) e.getSource();
    if (action == bSolve) {
      setAutoSolveEnable(false);
      setClockEnable(false);
      bMinus.setEnabled(false);
      bPlus.setEnabled(false);
      main.startAutomatic();
    }
    else {
      if (action == bPlus) setDiscs(++ndiscs);
      else if (action == bMinus) setDiscs(--ndiscs);
      if (action == bReset);   // Só para dizer que existe
      setPlusMinusEnable();
      main.restartGame();
    }
  }

  // Trata contagem de tempo (checkbox)
  public void itemStateChanged(ItemEvent e) {
    main.restartGame();
  }

  // Trata barra de rolamento
  public void adjustmentValueChanged(AdjustmentEvent e) {
    int value = sbSpeed.getValue();
    lPerc.setText(value + "%");
    delay = 1000 - (value-1)*10;  // Tempo de espera entre movimentos
  }

  // Trata mouse em cima dos botões
  public void mouseEntered(MouseEvent e) {
    ((Button) e.getSource()).setBackground(silver);
  }

  public void mouseExited(MouseEvent e) {
    ((Button) e.getSource()).setBackground(yellow);
  }

  public void mousePressed(MouseEvent e)  {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseClicked(MouseEvent e)  {}

}
