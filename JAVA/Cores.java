/**----------------------------------------------------------------------*/
/** Três barras deslizantes fornecem os respectivos componentes          */
/** vermelho, verde, e azul, da cor mostrada acima das barras.           */
/** Francisco A. S. Grossi                                               */
/*-----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Cores.java         
// <applet code=Cores.class width=450 height=200>
// </applet>

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Cores extends Applet implements AdjustmentListener {
  Panel     barras    = new Panel(new GridLayout(3,3,15,15));
  Panel     info      = new Panel(new BorderLayout(40,15)); 
  Panel     rotulos   = new Panel(new GridLayout(3,3)); 
  Panel     cor       = new Panel(null);
  Label     lVermelho = new Label("Vermelho",Label.LEFT);  
  Label     lVerde    = new Label("Verde",Label.LEFT);  
  Label     lAzul     = new Label("Azul",Label.LEFT);  
  Label     nVermelho = new Label("128",Label.RIGHT);
  Label     nVerde    = new Label("128",Label.RIGHT);
  Label     nAzul     = new Label("128",Label.RIGHT);
  Scrollbar bVermelho = new Scrollbar(Scrollbar.HORIZONTAL,128,1,0,255+1);
  Scrollbar bVerde    = new Scrollbar(Scrollbar.HORIZONTAL,128,1,0,255+1);
  Scrollbar bAzul     = new Scrollbar(Scrollbar.HORIZONTAL,128,1,0,255+1);
  Font      fonte     = new Font("TimesRoman",Font.BOLD,14);

  public void init() {
    criaRotulo(rotulos,lVermelho,nVermelho,Color.red);
    criaRotulo(rotulos,lVerde,nVerde,Color.green);
    criaRotulo(rotulos,lAzul,nAzul,Color.blue);

    criaBarra(barras,bVermelho,Color.red,1,16);
    criaBarra(barras,bVerde,Color.green,1,16);
    criaBarra(barras,bAzul,Color.blue,1,16);

    setFont(fonte);
    cor.setBackground(new Color(128,128,128));
    barras.setBackground(Color.white);
    setLayout(new BorderLayout(10,10));
    info.add(barras,BorderLayout.CENTER);
    info.add(rotulos,BorderLayout.EAST);
    add(info,BorderLayout.SOUTH);
    add(cor,BorderLayout.CENTER);
  }

  public void criaRotulo(Panel painel, Label nome, 
              Label numero, Color cor) {
    nome.setForeground(cor);
    numero.setForeground(cor);
    painel.add(nome);
    painel.add(numero);
  }

  public void criaBarra(Panel painel, Scrollbar barra, 
              Color cor, int unit, int block) {
    barra.setUnitIncrement(unit);
    barra.setBlockIncrement(block);
    barra.addAdjustmentListener(this);
    barra.setForeground(cor);
    painel.add(barra);
  }

  public void adjustmentValueChanged(AdjustmentEvent e) {
    int vermelho =  bVermelho.getValue();
    int verde = bVerde.getValue();
    int azul = bAzul.getValue();
    nVermelho.setText(String.valueOf(vermelho));
    nVerde.setText(String.valueOf(verde));         
    nAzul.setText(String.valueOf(azul));
    cor.setBackground(new Color(vermelho,verde,azul));
  }

}
