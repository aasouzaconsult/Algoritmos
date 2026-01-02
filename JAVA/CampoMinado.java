/**----------------------------------------------------------------------*/
/** Jogo Campo Minado semelhante ao do Windows.                          */
/** Objetivo: Marcar com bandeiras (botão direito do mouse) as 40 bombas */
/** de uma matriz 16 X 16.                                               */
/** O botão esquerdo do mouse marca uma cécula sem bomba.                */
/** O botão direito do mouse marca ou desmarca uma bomba.                */
/** O número de bombas sem maracção e o tempo de jogo são mostrados no   */
/** topo da tela.                                                        */ 
/** Usa Swing e funciona como Applet ou como aplicativo.                 */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

import java.awt.*;
import java.text.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;

// <applet code=MinadoCampo.class width=385 height=415>
// </applet>

public final class MinadoCampo extends JApplet implements MouseListener {
  final int nada = 0, bomba = 9, bandeira = 10, erro = 11, explosão = 12;
  final int minas = 40, linhas = 16, colunas = 16;
  int resto;
  int[][] grade = new int[linhas][colunas];
  final String sério   = "Clique para recomeçar.";
  final String triste  = "Estourou uma bomba!";
  final String risonho = "Parabéns! Clique para começar.";

  java.applet.AudioClip perde, ganha;
  Border alta, baixa;
  JLabel tempo, conta;  
  JPanel painel;
  JButton cara; 
  
  Timer relógio;
  DecimalFormat d = new DecimalFormat("000");
  Font fonte = new Font("Courier",Font.BOLD,16);

  MinadoCelula outro = new MinadoCelula(this);
  MinadoCelula[][] label = new MinadoCelula[linhas][colunas];  
  java.util.Random a = new java.util.Random();
  
  public void init() {
    perde = getAudioClip(getCodeBase(),"perde.au");
    ganha = getAudioClip(getCodeBase(),"ganha.au");
    continua(); 
  }

  public void continua() {
    Container c = getContentPane();
    c.add(criaNorte(conta=criaLabel(),cara=criaCara(),
      tempo=criaLabel()),BorderLayout.NORTH);
    c.add(criaCentro(),BorderLayout.CENTER);
    alta  = BorderFactory.createRaisedBevelBorder(); 
    baixa = BorderFactory.createLoweredBevelBorder();

    cronômetro();
    novoJogo();
  }

  private JLabel criaLabel() {
    JLabel lb = new JLabel();
    lb.setBorder(new LineBorder(Color.red,2));
    lb.setForeground(Color.red);
    lb.setFont(fonte);
    return lb;
  }

  private JButton criaCara() {
    JButton b = new JButton();
    b.setFont(new Font("Helvetica",Font.PLAIN,18));
    b.setBorder(new LineBorder(Color.red,2));
    b.setBackground(Color.white);
    b.setForeground(Color.blue);
    b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          relógio.stop();
          label[0][0].requestFocus();
          painel.removeMouseListener(outro.main);
          novoJogo();
        }
      }
    );
    return b;
  }

  private JPanel criaNorte(JLabel c, JButton b, JLabel t) {
    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(alta); 
    p.setBackground(Color.cyan);
    p.add(c,BorderLayout.WEST);
    p.add(b,BorderLayout.CENTER);
    p.add(t,BorderLayout.EAST);
    return p;
  }
  
  private JPanel criaCentro() {
    painel = new JPanel(null);
    for (int i = 0; i < linhas; ++i)
      for (int j = 0; j < colunas; ++j) {
        painel.setBackground(new Color(255,240,220));
        painel.add(label[i][j] = new MinadoCelula(i,j));
      }
    return painel;
  }

  private void cronômetro() {
    ActionListener evento = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int seg = Integer.parseInt(tempo.getText()) + 1;
        tempo.setText(d.format(seg));
      }
    };
    relógio = new Timer(1000,evento);
  }

  private void novoJogo() {
    tempo.setText("000");
    cara.setText(sério);
    conta.setText(d.format(minas));
    painel.addMouseListener(this);

    for (int i = 0; i < linhas; ++i)
      for (int j = 0; j < colunas; ++j) {
        label[i][j].setBorder(alta);
        label[i][j].setValor(nada);
        grade[i][j] = nada;
      }

    resto = 0; 
    while(resto < minas) {
      int i = a.nextInt(linhas);
      int j = a.nextInt(colunas);
      if (grade[i][j] != bomba) {
        grade[i][j] = bomba;
        ++resto;
      }
    }
   
    for (int i = 0; i < linhas; ++i)
      for (int j = 0; j < colunas; ++j)
        if (grade[i][j] != bomba)
          grade[i][j] = contaBombas(i,j);

  }
  
  private int contaBombas(int i, int j) {
    return 
      vizinho(i-1,j-1) + vizinho(i,j-1) + vizinho(i+1,j-1) + 
      vizinho(i-1,j)   + vizinho(i+1,j) + vizinho(i-1,j+1) + 
      vizinho(i,j+1)   + vizinho(i+1,j+1);
  }

  private int vizinho(int i, int j) {
    if (i >= 0 && i < linhas && j >= 0 && 
      j < colunas && grade[i][j] == bomba) return 1;
    else return 0;
  }

  private void limpa(int i, int j) {
    if (i >= 0 && i < linhas && j >= 0 && j < colunas &&
        grade[i][j] != bomba && label[i][j].getValor() != bandeira &&
        label[i][j].getBorder() == alta) {
      label[i][j].setValor(grade[i][j]);
      label[i][j].setBorder(baixa);
      if (grade[i][j] == nada) {
        limpa(i-1,j-1);
        limpa(i,j-1);
        limpa(i+1,j-1);
        limpa(i-1,j);
        limpa(i+1,j); 
        limpa(i-1,j+1);
        limpa(i,j+1);
        limpa(i+1,j+1);
      }
    }
  }

  private void fimJogo(String msg, int i, int j) {
    relógio.stop();
    painel.removeMouseListener(this);
    cara.setText(msg);
    mostraGrade(i < 0);
    if (i >= 0 && j >= 0) {
      if (perde != null) perde.play();
      label[i][j].setValor(explosão);
    }
    else if (ganha != null) ganha.play();
  }

  private void mostraGrade(boolean fim) {
    for (int i = 0; i < linhas; i++) 
      for (int j = 0; j < colunas; j++)  {
        if (grade[i][j] == bomba && 
            label[i][j].getValor() == nada) {
          label[i][j].setBorder(baixa);
          label[i][j].setValor(bomba);
        }
        if (grade[i][j] != bomba && 
            label[i][j].getValor() == bandeira) {
          label[i][j].setBorder(baixa);
          label[i][j].setValor(erro);
        }
        if (fim && label[i][j].getValor() == nada) {
          label[i][j].setValor(grade[i][j]);
          label[i][j].setBorder(baixa);
        }
      }
  }

  private boolean verificaFim(int resto) {
    conta.setText(d.format(resto));
    int altas = 0;
    if (resto == 0) {
      for (int i = 0; i < linhas; ++i)
        for (int j = 0; j < colunas; ++j)
          if (label[i][j].getValor() == bandeira &&
              grade[i][j] == bomba) altas++;
      return altas == minas;
    }
    else return false;
  }

  public void mousePressed(MouseEvent e) {
    Point p = MinadoCelula.getCélula(e); 
    
    if (!relógio.isRunning()) relógio.start();
    
    if (SwingUtilities.isRightMouseButton(e) && p != null)
      if (label[p.x][p.y].getValor() == nada) {
        label[p.x][p.y].setValor(bandeira);
        if (verificaFim(--resto)) fimJogo(risonho,-1,-1);
      } 
      else if (label[p.x][p.y].getValor() == bandeira) {
        label[p.x][p.y].setValor(nada);
        if (verificaFim(++resto)) fimJogo(risonho,-1,-1);
      }
  }

  public void mouseReleased(MouseEvent e) {
    Point p = MinadoCelula.getCélula(e); 
    
    if (!relógio.isRunning()) relógio.start();
    
    if (SwingUtilities.isLeftMouseButton(e) && p != null) 
      if (label[p.x][p.y].getValor() == nada) 
        if (grade[p.x][p.y] != bomba) limpa(p.x,p.y);
        else fimJogo(triste,p.x,p.y);
  }

  public void mouseClicked(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}

  // Entrada do programa se executado como aplicativo
  public static void main(String[] s) {
    MinadoCampo minado = new MinadoCampo(); 
    JFrame frame = new JFrame("Campo Minado");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setBounds(0,0,392,444);
    frame.getContentPane().add(minado);
    frame.setVisible(true);
    minado.continua();
  }

}


final class MinadoCelula extends JComponent {
  final static Font fonte = new Font("Courier",Font.BOLD,24);
  final static int w = 24, h = 24; 
  static int altura, mais; 
  static MinadoCampo main;
  static FontMetrics fm;
  int indice;

  final static Color[] cores = {
    Color.gray,Color.blue,new Color(35,142,35),Color.red,
    new Color(153,51,51),new Color(166,128,100),
    new Color(204,153,204),new Color(255,51,255),
    Color.black
  };
 
  protected MinadoCelula(MinadoCampo main) {
    this.main = main;
    fm = getFontMetrics(fonte);
    altura = fm.getHeight();
    mais = fm.getAscent();
  }
  
  protected MinadoCelula(int i, int j) {
    setBackground(Color.lightGray);
    setBounds(i*w,j*h,w,h);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (indice <= 8)                  desenhaNumero(g);
    else if (indice == main.bomba)    desenhaBomba(g,Color.yellow);
    else if (indice == main.bandeira) desenhaBandeira(g);
    else if (indice == main.erro)     desenhaErro(g);
    else if (indice == main.explosão) desenhaBomba(g,Color.red);
    else throw new UnsupportedOperationException();
  }

  protected void setValor(int indice) {
    this.indice = indice;
    repaint();
  }

  protected int getValor() {
    return indice;
  }

  protected static Point getCélula(MouseEvent e) {
    int i = e.getX() / w;
    int j = e.getY() / h;
    if (i >= 0 && i < main.linhas && j >= 0 && j < main.colunas)
      return new Point(i,j);
    else return null;
  }

  private void desenhaNumero(Graphics g) {
    if (getBorder() == main.baixa) { 
      g.setColor(Color.white);
      g.fillRect(0,0,w,h);
    }
    if (indice > 0 && indice <= 8) {	 
      int largura = fm.charWidth((char)indice);
      g.setFont(fonte);
      g.setColor(cores[indice]);
      g.drawString(String.valueOf(indice),
        (w-largura)/2,(h-altura)/2 + mais);
    }
  }

  private void desenhaBomba(Graphics g, Color fundo) {
    int e = 4, dx = 4, dy = 4;
    g.setColor(fundo);
    g.fillRect(1,1,w-2,h-2);
    g.setColor(Color.black);
    g.fillRect((w-e)/2,dy,e,(h-2*dy));
    g.fillRect(dx,(h-e)/2,(w-2*dx),e);
    g.fillOval(dx+2,dy+2,w-2*(dx+2),h-2*(dy+2));
    g.setColor(Color.white);
    g.fillOval(dx+5,dy+5,4,3);
  }

  private void desenhaBandeira(Graphics g) {
    int e = 4, dx = 5, dy = 4, dh = (h - 2*dy - e)/2;
    int[] x = {dx+1,(w-e)/2,(w-e)/2,dx+1};
    int[] y = {dy+2,dy,dy+dh,dy+dh-2};
    g.setColor(Color.gray);
    g.fillRect(dx,h-e-dy,w-2*dx,e);
    g.fillRect((w-e)/2,dy+dh,e,dh);
    g.setColor(Color.red);
    g.fillRect((w-e)/2,dy,e,dh);
    g.fillPolygon(x,y,x.length);
  }

  private void desenhaErro(Graphics g) {
    desenhaBomba(g,Color.yellow);
    g.setColor(Color.red);
    g.drawLine(0,0,w,h);
    g.drawLine(1,3,w-3,h-1);
    g.drawLine(3,1,w-1,h-3);
    g.drawLine(2,h-2,w-2,2);
    g.drawLine(1,h-3,w-3,1);
    g.drawLine(3,h-1,w-1,3);
  }

}
