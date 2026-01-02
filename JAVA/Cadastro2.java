
// Copyright (c) 2001 .
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A Swing-based top level window class.
 * <P>
 * @author .
 */
public class Cadastro2 extends JFrame {
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JMenuBar menuBar1 = new JMenuBar();
  JMenu menuFile = new JMenu();
  JMenuItem menuFileExit = new JMenuItem();
  JMenuItem jMenuAbrir = new JMenuItem();

  /**
   * Constructs a new instance.
   */
  public Cadastro2() {
    super();
    try  {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Initializes the state of this instance.
   */
  private void jbInit() throws Exception {
    this.getContentPane().setLayout(borderLayout1);
    this.setSize(new Dimension(400, 300));
    this.setTitle("Teste");
    menuFile.setText("File");
    menuFileExit.setText("Exit");
    jMenuAbrir.setText("Abrir");
    jMenuAbrir.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        jMenuAbrir_actionPerformed(e);
      }
    });
    menuFileExit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fileExit_ActionPerformed(e);
      }
    });
    menuFile.add(jMenuAbrir);
    menuFile.add(menuFileExit);
    menuBar1.add(menuFile);
    this.setJMenuBar(menuBar1);
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
  }

  /**
   * Performs the action defined for "File|Exit".
   * @param e
   */
  void fileExit_ActionPerformed(ActionEvent e) {
    System.exit(0);
  }

  void jMenuAbrir_actionPerformed(ActionEvent e) {
    Cadatro2 cad = new Cadastro2();
    cad.show();
  }
}

 
