/**----------------------------------------------------------------------*/
/** Exemplo de um applet com threads, que deixa um rastro de seu         */
/** para que o usário acompanhe a mecânica de execução dos applets.      */
/** Execute com o APPLETVIEWER, cubra e descubra a área do applet,       */
/** minimize sua janela, maximixe, e cancele o applet, acompanhando na   */
/** janela DOS as mensagens emitidas pelos métodos.                      */
/** O uso do browser é interessante para ver o abandono e volta à página */
/** do applet; neste caso, habilite a exibição da console do Java para   */
/** verificar as mensagens do percurso (veja configuração do browser).   */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Rastro2.java
// <applet code=Rastro2.class width=500 height=100>
// </applet>

import java.awt.Graphics;
import java.awt.Font;
import java.util.*;
import java.applet.*;

public class Rastro2 extends Applet implements Runnable {
  Font fonte = new Font("TimesRoman",Font.BOLD,24);
  Thread tarefa;
/*-----------------------------------------------------------------------*/
/* Chamado automaticamente pelo browser quando o applet é carregado, o   */
/* que inclui a volta à página após tê-la abandonado.                    */
/*-----------------------------------------------------------------------*/
  public void init() {
    System.out.println("Método init()");
  }
/*-----------------------------------------------------------------------*/
/* Chamado automaticamente após o init() e quando usuário maximiza a     */
/* página depois de minimizada.                                          */ 
/*-----------------------------------------------------------------------*/
  public void start() {
    System.out.println("Método start()");
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
    System.out.println("Método stop()");
    tarefa = null;
  }
/*-----------------------------------------------------------------------*/
/* Chamado por uma mensagem start() emitido, geralmente no método start()*/
/*-----------------------------------------------------------------------*/
  public void run() {
    System.out.println("Método run()");
    while (tarefa != null) {
      repaint();    // invoca paint sem necessidade de parâmetro
      try {
        tarefa.sleep(1000);
      } catch (InterruptedException e) {}
    }
  }
/*-----------------------------------------------------------------------*/
/* Chamado após o init() e o método start() começou a ser executado.     */
/* Chamado também todas as vezes em que o applet precisa ser redesenhado */
/* devido, por exemplo, a cobertura da tela por outra janela.            */
/*-----------------------------------------------------------------------*/
  public void paint(Graphics tela) {
    System.out.println("Método paint()");
    Calendar data = new GregorianCalendar();
    tela.setFont(fonte);
    tela.drawString("" + data.getTime(),10,50);
  }
/*-----------------------------------------------------------------------*/
/* Chamado automaticamente quando o applet é removido da memória, o que  */
/* ocorre, normalmente, quando o usuário fecha ou abandona a página.     */
/*-----------------------------------------------------------------------*/
  public void destroy() {
    System.out.println("Método destroy()");
  }

}