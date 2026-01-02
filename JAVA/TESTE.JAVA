/*
 * Teste.java
 *
 * Created on 27 de Setembro de 2004, 08:39
 */

/**
 *
 * @author  claudemir
 */
import javax.swing.*;
import java.awt.event.*;
public class Teste{
   
   JButton Botao1;
   JTextField Edit1;
   
public Teste(){

JFrame Frame = new JFrame("Calculadora Java");
Botao1 = new JButton("Botão");
Edit1 = new JTextField("");
Frame.setSize(280,300);
Frame.getContentPane().add(Botao1);

//Evento botao 1
Botao1.addActionListener(new ActionListener() {
public void actionPerformed( ActionEvent evt){
Edit1.setText("sssssssssss");
};
});

Frame.setVisible(true);
Frame.show();
}

public static void main(String args[]) {
new Teste();
}
}
