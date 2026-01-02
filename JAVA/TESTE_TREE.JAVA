/*
 * Teste_Tree.java
 *
 * Created on 1 de Outubro de 2004, 16:15
 */

/**
 *
 * @author  claudemir
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

/**
* @author Felipe Lutz
*
* To change the template for this generated type comment go to
* Window>Preferences>Java>Code Generation>Code and Comments
*/
public class Teste_Tree {
   public static void main(String[] args) {
    JFrame frame =new FrameTree();      
   frame.show();
   }
}

class FrameTree extends JFrame
{
   public FrameTree()
   {
    setTitle("Arvore simples");
    setLocation(280,235);
    setSize(300,300);
    addWindowListener(new WindowAdapter()
   { public void WindowClosing(WindowEvent e)
      {
      System.exit(0);
      }
   });
   
    //Configura dados do modelo de arvore
   
    DefaultMutableTreeNode root= new DefaultMutableTreeNode("SUPGS");
   DefaultMutableTreeNode servico= new DefaultMutableTreeNode("PORTAL DE GERENCIA");
   DefaultMutableTreeNode servico2= new DefaultMutableTreeNode("CAS");
   root.add(servico);
   root.add(servico2);
   
   //Mais um teste
   DefaultMutableTreeNode root2= new DefaultMutableTreeNode("JAVA");
   DefaultMutableTreeNode servico3= new DefaultMutableTreeNode("J2SE - Standart Edition");
   DefaultMutableTreeNode servico4= new DefaultMutableTreeNode("J2EE - Enterprise Editon");
   DefaultMutableTreeNode subservico= new DefaultMutableTreeNode("J2ME - Micro Edition");
   servico3.add(subservico);
   root2.add(servico3);
   root2.add(servico4);
      
   //Constroi uma arvore com painel de rolagem
   
   JTree arvore=new JTree(root);
   //arvore.setToolTipText("aa"); ñ funciona!!!!!!!!!!!! aki
   //ToolTipManager.sharedInstance().registerComponent(arvore); nem aki
   Container contentPane=getContentPane();
   contentPane.add(new JScrollPane(arvore));
   
   JTree arvore1=new JTree(root2);
   Container contentPane1=getContentPane();
   contentPane1.add(new JScrollPane(arvore1));
      
   
    }           
}
   
   
