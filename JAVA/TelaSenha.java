import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 class TelaSenha extends JFrame implements ActionListener
{
    JLabel L1,L2;
    JTextField T1;
    JPasswordField P1;
    
  
    public static void main (String args[])
    {
        JFrame Janela = new TelaSenha();
        Janela.show();
        WindowListener x = new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        };
        Janela.addWindowListener(x);
    }
    
    
    TelaSenha()
    {
        
        setLocation(280,235);
        setTitle("Verifica Senha");
        setSize(350,65);
        
        getContentPane().setBackground(new Color(150,150,150));
        getContentPane().setLayout(new GridLayout(5,5));
        
        L1 = new JLabel("Digite a SENHA:");
        L1.setForeground(Color.black);
        L1.setFont(new Font("",Font.BOLD,14));
        
        L2 = new JLabel("Usuario:");
        L2.setForeground(Color.black);
        L2.setFont(new Font("",Font.BOLD,14));
        
        P1 = new JPasswordField();
        //P1.setEchoChar('?');
        P1.addActionListener(this); // registra o P1
        
        getContentPane().add(L1);
        getContentPane().add(P1);
        getContentPane().add(L2);
        getContentPane().add(T1);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (P1.getText().equals("java"))
            
            T1.setText("Senha Válida");
        else
            
            T1.setText("Senha Inválida");
    }
}