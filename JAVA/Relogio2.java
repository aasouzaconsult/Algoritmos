/**----------------------------------------------------------------------*/
/** Exemplo de um applet com thread: relógio analógico simples.          */
/** Usa buffer duplo para evitar tremidos.                               */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Relogio2.java            
// <applet code=Relogio2.class width=300 height=300>
// </applet>

import java.awt.*;
import java.applet.*;
import java.util.*;

public class Relogio2 extends Applet implements Runnable {
  Thread tarefa;
  Image imagem;
  Graphics fora;
  AudioClip tique;
  int x, y, largura, altura;
  int pontsegs = 85, pontmins = 80, ponthora = 60;

  public void init() {
    largura = getSize().width;
    altura = getSize().height;
    x = largura / 2;
    y = altura / 2;
    imagem = createImage(largura,altura);
    fora = imagem.getGraphics();
    tique = getAudioClip(getCodeBase(),"tique.au");
  }

  public void start() {
    if (tarefa == null) {
      tarefa = new Thread (this);
      tarefa.start();
    }
  }

  public void stop() {
    tarefa = null;
  }

  public void run() {
    while (tarefa != null) {
      try {
        tarefa.sleep(1000);
        if (tique != null) tique.play();
      } catch (InterruptedException e) {}
      repaint();    
    }
  }

  public void paint(Graphics g) {

    fora.setColor(Color.white);
    fora.fillRect(0,0,largura,altura);

    GregorianCalendar data = new GregorianCalendar();
    int segs = data.get(Calendar.SECOND);
    int mins = data.get(Calendar.MINUTE);
    int hora = data.get(Calendar.HOUR_OF_DAY);

    double vs = segs * Math.PI * 2 / 60.0;
    double vm = mins * Math.PI * 2 / 60.0;
    double vh = hora * Math.PI * 2 / 12 + vm / 12;

    int sx = (int) (x+pontsegs * Math.sin(vs));
    int sy = (int) (y-pontsegs * Math.cos(vs));

    int mx = (int) (x+pontmins * Math.sin(vm));
    int my = (int) (y-pontmins * Math.cos(vm));

    int hx = (int) (x+ponthora * Math.sin(vh));
    int hy = (int) (y-ponthora * Math.cos(vh));

    // Ponteiro dos segundos
    fora.setColor(Color.blue);
    fora.drawLine(x,y,sx,sy);

    // Ponteiro dos minutos
    fora.setColor(Color.red);
    fora.drawLine(x,y,mx,my);

    // Ponteiro das horas
    fora.setColor(Color.cyan);
    fora.drawLine(x,y,hx,hy);

    // Face e eixo do relógio 
    fora.setColor(Color.orange);
    fora.fillOval(x-6,y-6,12,12);
    fora.drawOval(x-90,y-90,180,180);
    fora.drawOval(x-94,y-94,188,188);
     
    // Números
    fora.setColor(Color.darkGray);
    fora.drawString("3",x+78,y+3);
    fora.drawString("6",x-5,y+85);
    fora.drawString("9",x-85,y+3); 
    fora.drawString("12",x-5,y-76);
    fora.drawString("TISSOT",x-15,y-45);
    fora.drawString("1853",x-9,y-30);
    fora.drawString("PR50",x-9,y+30);

    g.drawImage (imagem,0,0,this);
  }

  public void update(Graphics g) {
    paint(g);
  }

}

