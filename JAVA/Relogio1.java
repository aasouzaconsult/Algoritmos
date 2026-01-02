/**----------------------------------------------------------------------*/
/** Exemplo de um applet com thread: relógio digital simples.            */
/** A classe Applet contém métodos vazios para todos os métodos          */
/** obrigatórios; portanto, somente é necesário codificar aqueles        */
/** que contém algum código do usuário. Os métodos vazios estão          */
/** codificados neste exemplo para explicar o seu funcionamento.         */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Relogio1.java            
// <applet code=Relogio1.class width=500 height=100>
// </applet>

import java.awt.*;
import java.util.*;
import java.applet.*;

public class Relogio1 extends Applet implements Runnable {
  Font fonte = new Font("TimesRoman",Font.BOLD,24);
  Thread tarefa;
  AudioClip tique;
/*-----------------------------------------------------------------------*/
/* Chamado pelo browser quando o applet é carregado.                     */
/*-----------------------------------------------------------------------*/
  public void init() {
    tique = getAudioClip(getCodeBase(),"tique.au");
  }
/*-----------------------------------------------------------------------*/
/* Chamado após o init() e cada vez que o usário retorna à página.       */
/*-----------------------------------------------------------------------*/
  public void start() {
    if (tarefa == null) {
      tarefa = new Thread(this);
      tarefa.start();
    }
  }
/*-----------------------------------------------------------------------*/
/* Deve ser chamado quando o applet deve deixar de executar.             */
/* Chamado automaticamente quando o usário minimiza ou deixa a págima.   */ 
/* Normalmente, modifica uma variável que indica o fim de sua execução.  */
/*-----------------------------------------------------------------------*/
  public void stop() {
    tarefa = null;
  }
/*-----------------------------------------------------------------------*/
/* Chamado por uma mensagem start() emitido, geralmente no método start()*/
/*-----------------------------------------------------------------------*/
  public void run() {
    while (tarefa != null) {
      try {
        tarefa.sleep(1000);
        if (tique != null) tique.play();
      } 
      catch (InterruptedException e) {}
      repaint();    // invoca paint sem necessidade de parâmetro
    }
  }
/*-----------------------------------------------------------------------*/
/* Chamado após o init() e o método start() começou a ser executado.     */
/* Chamado também todas as vezes em que o applet precisa ser redesenhado */
/* devido, por exemplo, a cobertura da tela por outra janela.            */
/*-----------------------------------------------------------------------*/
  public void paint(Graphics tela) {
    GregorianCalendar data = new GregorianCalendar();
    tela.setFont(fonte);
    tela.drawString("" + data.getTime(),10,50);
  }
/*-----------------------------------------------------------------------*/
/* Chamado pelo browser quando o applet é removido da memória, o que     */
/* ocorre, normalmente, quando o usuário abandona a página.              */
/*-----------------------------------------------------------------------*/
  public void destroy() {
  }

}