/**----------------------------------------------------------------------*/
/** Jogo de Ping Pong                                                    */
/** Adaptado (algumas poucas alterações) de um jogo da Internet.         */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// arquivo html para executar:
// <applet code=PingPong.class width=450 height=350>
// </applet>

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public final class PingPong extends Applet implements Runnable, 
        MouseMotionListener, ActionListener {

  int m1X, m1Y, batY = 60, hits = 0;
  boolean perdeu = false;
  
  static AudioClip bate, perde;
  Font fonte1 = new Font("TimesRoman",Font.BOLD,20);
  Font fonte2 = new Font("TimesRoman",Font.PLAIN,12);
  MesaPingPong mesa = new MesaPingPong(400,350);
  Button começa = new Button("Já!"); 
  Thread jogo;
  Image duplo;
  Graphics fora;

  public void init() {
    setBackground(Color.white);
    bate = getAudioClip(getCodeBase(),"bate.au");
    perde = getAudioClip(getCodeBase(),"perde.au");
    setLayout(null);
    
    começa.setBounds(408,18,35,20);
    começa.addActionListener(this);
    add(começa);

    duplo = createImage(getWidth(),getHeight());
    fora = duplo.getGraphics();
    addMouseMotionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    mesa.setSpeed(2);
    perdeu = false;
    hits = 0;
    começa.setEnabled(false);
  }

  public void update(Graphics g) {
    fora.setColor(Color.gray);
    fora.fillRect(0,0,400,350);
    paint(g);
  }

  public void paint(Graphics g) {
    fora.setColor(Color.white);
    fora.setFont(fonte1);
    fora.drawString("Jogo de Ping-Pong",0,28);
    fora.drawRect(0,50,398,298);
    fora.drawRect(1,51,396,296);
    fora.drawLine(200,50,200,347);
    fora.drawLine(388,batY,388,batY + 36);
    fora.drawLine(387,batY,387,batY + 36);
    fora.drawLine(386,batY,386,batY + 36);
    fora.drawLine(12,getBatY(),12,getBatY() + 36);
    fora.drawLine(13,getBatY(),13,getBatY() + 36);
    fora.drawLine(14,getBatY(),14,getBatY() + 36);
    fora.fillRoundRect(mesa.getX(),mesa.getY(),5,5,2,2);
    fora.drawRect(367,32,30,14);
    fora.setFont(fonte2);
    fora.drawString(String.valueOf(hits),372,44);
    fora.drawString("Marca",367,28);
    g.drawImage(duplo,0,0,this);
  }

  public void start() {
    if (jogo == null) {
      jogo = new Thread(this);
      jogo.start();
    }
  }

  public void stop() {
    if (jogo != null) {
      jogo.interrupt();
      jogo = null;
    }
  }

  public void run() {
    long proxima = 0;
    
    while (jogo != null) {
      try {
        jogo.sleep(Math.max(3,proxima - System.currentTimeMillis()));
      }
      catch(InterruptedException e) {}
      proxima = System.currentTimeMillis() + 10;
      
      if (mesa.getX() > 400) {
        perdeu = true;
        playSound(perde);
        começa.setEnabled(true);
        mesa.setX(198);
        mesa.setY(200);
        mesa.setSpeed(0);
        mesa.setHeading(1);
        mesa.getNext();
        começa.setEnabled(true);
      } 
      else if (mesa.getX() < 15) mesa.headingSkiftX1();
      
      if (!perdeu) {
        if (mesa.getX() + 5 >= 386 && mesa.getX() + 5 <= 392) {
          if (mesa.getY() + 3 >= batY && mesa.getY() <= batY + 36) {
            if (mesa.getY() >= batY + 6 && mesa.getY() <= (batY + 36) - 6)
              mesa.headingSkiftX1();
            else mesa.headingSkiftX2();
            hits++;
          }
          if(hits % 5 == 0) mesa.setSpeed(mesa.getSpeed() + 1);
        }
        mesa.move();
      }
      repaint();
    }
  }

  final int getBatY() {
    if (mesa.getY() - 15 < 52) return 52;
    if (mesa.getY() - 15 > 310) return 310;
    else return mesa.getY() - 15;
  }

  public static void playSound(AudioClip s) {
    if (s == null && bate != null) s = bate;
    if (s != null) s.play();
  }
  
  public void mouseDragged(MouseEvent e) {
    getMouse(e.getY());
  }

  public void mouseMoved(MouseEvent e) {
    getMouse(e.getY());
  }

  private void getMouse(int x) {
    if (x < 52) batY = 52;
    else if (x > 310) batY = 310;
    else batY = x;
  }

}


final class MesaPingPong {

  private int x, y, nextX, nextY;
  private int step, heading, speed;
  private int maxX, maxY, minY, minX;
  
  public MesaPingPong(int i, int j) {
    x = i / 2 - 2;
    y = j / 2 + 25;
    maxX = i;
    maxY = j - 9;
    minX = 0;
    minY = 51;
    heading = 1;
    step = 0;
    speed = 0;
    nextX = i / 2 - 2;
    nextY = j / 2 + 25;
    getNext();
  }

  public int getX() {
    return x;
  }

  public void setX(int i) {
    x = i;
  }

  public int getY() {
    return y;
  }

  public void setY(int i) {
    y = i;
  }

  public int getHeading() {
    return heading;
  }

  public void setHeading(int i) {
    heading = i;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int i) {
    speed = i;
  }

  public void move() {
    y = nextY;
    x = nextX;
    getNext();
  }

  public void headingSkiftY() {
    int[] y = {3,5,1,6,2,4};
    heading = y[heading-1];
    PingPong.playSound(null);
  }

  public void headingSkiftX1() {
    int[] x1 = {6,5,4,3,2,1};
    heading = x1[heading-1];
    getNext();
    PingPong.playSound(null);
  }

  public void headingSkiftX2() {
    int[] x2 = {4,5,6,1,2,3};
    heading = x2[heading-1];
    getNext();
    PingPong.playSound(null);
  }

  public void getNext() {
    if (heading == 1) 
      if (y >= minY + 2) {
        nextY = y - speed;
        nextX = x + speed;
      } 
      else headingSkiftY();

    else if (heading == 2)
      nextX = x + speed;

    else if (heading == 3) 
      if (y <= maxY - 2) {
        nextY = y + speed;
        nextX = x + speed;
      }
      else headingSkiftY();

    else if (heading == 4) 
      if (y <= maxY - 2) {
        nextY = y + speed;
        nextX = x - speed;
      } 
      else headingSkiftY();

    else if (heading == 5) 
      nextX = x - speed;

    else if (heading == 6) 
      if (y >= minY + 2) {
        nextY = y - speed;
        nextX = x - speed;
      }
      else headingSkiftY();
  }

}
