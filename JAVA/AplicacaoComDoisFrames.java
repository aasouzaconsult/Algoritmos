/**
 * class AplicacaoComDoisFrames
 * Copyright (c) 2002, Jorge Henrique Cabral Fernandes
 * Exemplo de aplicação com vários frames, que compartilha um mesmo modelo de dados
 */
import java.awt.*;
import java.awt.event.*;

public class AplicacaoComDoisFrames {
  public static void main(String[] args) {
    F0 f0 = new F0();
  }
}

class F0 extends Frame {
  Button f1Button, f2Button, imprimirButton;
  // modelo de dados
  StringBuffer modelo;
  // frames
  FrameEntradaDeDados f1Frame, f2Frame;
  F0() {
    super();
    this.setTitle("F0");
    this.setLayout(new GridLayout(3,1));
    // cria o modelo
    modelo = new StringBuffer();
    // cria os frames
    f1Frame = new FrameEntradaDeDados("F1", modelo);
    f2Frame = new FrameEntradaDeDados("F2", modelo);
    // cria os componentes visuais
    f1Button = new Button("F1");
    f2Button = new Button("F2");
    imprimirButton = new Button("Imprimir");
    add(f1Button);
    add(f2Button);    
    add(imprimirButton);
    // colocar tratadores de evento
    f1Button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        f1Frame.pack();
        f1Frame.show();
      }
    });
    f2Button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        f2Frame.pack();
        f2Frame.show();
      }
    });
    imprimirButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        System.out.println(modelo.toString());
      }
    });
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
    pack();
    show();
  }
}
class FrameEntradaDeDados extends Frame {
  Button inserirButton, fecharButton;
  TextArea textoTextArea;
  // modelo de dados
  StringBuffer modelo;
  FrameEntradaDeDados(String titulo, StringBuffer modelo) {
    super();
    this.setTitle(titulo);
    this.setLayout(new GridLayout(3,1));
    this.modelo = modelo;
    // cria os componentes visuais
    inserirButton = new Button("Inserir");
    fecharButton = new Button("Fechar");
    textoTextArea = new TextArea();
    add(textoTextArea);
    add(inserirButton);
    add(fecharButton);    
    // colocar tratadores de evento
    inserirButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        inserirTexto();
      }
    });
    fecharButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        this_hide();
      }
    });
  }
  private void this_hide() {
    hide();
  }
  private void inserirTexto() {
    String texto = textoTextArea.getText();
    modelo.append(texto);
  }
}
