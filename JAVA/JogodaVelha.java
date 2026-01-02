/**---------------------------------------------------------------------*/
/** Objetivo: Preencher uma linha, coluna, ou diagonal.                 */
/** Usuário joga com "X" e o programa com "O".                          */
/** Quando o jogo terminar, um clique em qualquer lugar, recomeça jogo. */
/** Usuário sempre começa, o que lhe dá uma pequena vantagem.           */
/**                                                                     */
/** Programa escolhe uma das jogadas abaixo, na ordem listada:          */
/** 1) Casa vencedora.                                                  */
/** 2) Casa que impede a derrota.                                       */
/** 3) Casa do centro.                                                  */
/** 4) A melhor casa do canto.                                          */
/** 5) Uma casa qualquer (a primeira que achar).                        */
/**                                                                     */
/** Usando estas estratégias, o programa ganha muitas vezes, mas há     */
/** uma maneira de o usuário ganhar sempre.                             */
/** Francisco A. S. Grossi                                              */
/**---------------------------------------------------------------------*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JogoDaVelha extends JFrame implements ActionListener {
    
  int numero = 9, resto; 
  boolean acabou;
  JButton[] casas = new JButton[numero];
  String[] c = new String[numero];
 
  public JogoDaVelha() {
    Container c = getContentPane();
    c.setLayout(new GridLayout(3,3));
    for (int i = 0; i < casas.length; ++i) {
      casas[i] = new JButton();
      casas[i].setFont(new Font("SansSerif",Font.BOLD,76));
      casas[i].addActionListener(this);
      c.add(casas[i]);
    }
    fiatLux();
    novoJogo();
  }     

  final private void fiatLux() {
    Toolkit toolkit = Toolkit.getDefaultToolkit();   // Ferramentas
    int x = 0, y = 0;                      // Coordenadas do quadro
	  int largura = 300;                     // Largura do quadro
    int altura  = 340;                     // Altura do quadro
    Dimension sz = toolkit.getScreenSize();// Resolução do monitor
    if (sz.width > largura) x = (sz.width-largura)/2;
    if (sz.height > altura) y = (sz.height-altura)/2;
    setResizable(false);                   // Não permite alterar tamanho
    setBounds(x,y,largura,altura);         // Estabelece posição e tamanho
    setVisible(true);                      // Mostra o quadro construído
  }   

  final private void novoJogo() {
    setTitle("Jogo da Velha");
    acabou = false;
    resto = numero;
    for (int i = 0; i < casas.length; ++i) {
     casas[i].setBackground(Color.cyan);
     casas[i].setText("");
    }
  }
  
  public void actionPerformed(ActionEvent e) {
    if (acabou)  {
      novoJogo();
      return;
    } 
    JButton b = (JButton) e.getSource();
    if (b.getText().equals("X") || b.getText().equals("O")) return;
                        
    b.setText("X");             // Usuário fez uma jogada 
    b.setForeground(Color.red); // Acerta a sua cor
    --resto;                    // Menos uma casa vazia 
                    
    if (!verifica()) {          // Verifica se terminou
      programa();               // Programa joga 
      --resto;                  // Menos uma casa vazia 
      verifica();               // Verifica se terminou
    }
  } 

  final private void programa() {       // Programa faz uma jogada
    int i = tentaGanhar();             
    if (i == -1) i = tentaBloquear(); 
    if (i == -1) i = tentaCentro();  
    if (i == -1) i = tentaCanto();
    if (i == -1) i = tentaQualquer();
    casas[i].setText("O");              // Programa jogou
    casas[i].setForeground(Color.blue); // Acerta sua cor
  }    

  final private boolean verifica() {
    if (fimDeJogo(0,1,2)) return true;
    if (fimDeJogo(3,4,5)) return true;
    if (fimDeJogo(6,7,8)) return true;       
    if (fimDeJogo(0,3,6)) return true;
    if (fimDeJogo(1,4,7)) return true;
    if (fimDeJogo(2,5,8)) return true;       
    if (fimDeJogo(0,4,8)) return true;
    if (fimDeJogo(2,4,6)) return true;
    if (resto <= 0) {
      setTitle("Empatamos!");
      return acabou = true;
    }
    else return false;
  }
  
  final private boolean fimDeJogo(int a, int b, int c) {
    if (casas[a].getText().equals(casas[b].getText()) &&
      casas[a].getText().equals(casas[c].getText())   &&
      !casas[a].getText().equals("")) {
      pintaTres(a,b,c);
      return acabou = true;
    }
    else return false;
  }

  final private void pintaTres(int a, int b, int c) {
    casas[a].setBackground(Color.lightGray);
    casas[b].setBackground(Color.lightGray);
    casas[c].setBackground(Color.lightGray);  
    if (casas[a].getText().equals("X"))
      setTitle("Parabéns - você ganhou!");
    else setTitle("Lamento - você perdeu!");
  }
    
  final private int tentaGanhar() {    // Vê se programa pode ganhar
    return casaVazia("OO");            // Há alguma com dois O's?
   }
    
  final private int tentaBloquear() {  // Bloqueia se usuário puder ganhar
    return casaVazia("XX");            // Há alguma com dois X's?
  }
  
  final private int tentaCentro() {    // Retorna centro se estiver vago
    if (casas[4].getText().equals("")) return 4;
    else return -1;
  }

  final private int tentaCanto() {     // Retorna a melhor casa de canto
    for (int i = 0; i < c.length; ++i)  
      c[i] = casas[i].getText();

    if ((c[0] + c[5] + c[2]).equals("OO")) return 2;
    if ((c[0] + c[7] + c[6]).equals("OO")) return 6; 
    if ((c[0] + c[7] + c[8]).equals("OO")) return 8;      
    if ((c[2] + c[3] + c[0]).equals("OO")) return 0;  
    if ((c[2] + c[7] + c[8]).equals("OO")) return 8;  
    if ((c[2] + c[7] + c[6]).equals("OO")) return 6;  
    if ((c[6] + c[1] + c[0]).equals("OO")) return 0;  
    if ((c[6] + c[5] + c[8]).equals("OO")) return 8; 
    if ((c[6] + c[5] + c[2]).equals("OO")) return 2;      
    if ((c[8] + c[1] + c[2]).equals("OO")) return 2;  
    if ((c[8] + c[3] + c[6]).equals("OO")) return 6;  
    if ((c[8] + c[3] + c[0]).equals("OO")) return 0;  
    else return -1;
  }

  final private int tentaQualquer() {  // Retorna primeira casa vaga
   int i;
   for (i = 0; !casas[i].getText().equals(""); ++i);
   return i;
  }    

  final private int casaVazia(String ganhador) {  // Retorna casa ganhadora
    for (int i = 0; i < c.length; ++i)  
      c[i] = casas[i].getText();

    int x;
    if ((x = melhorCasa(ganhador,0,1,2)) > -1) return x;   
    else if ((x = melhorCasa(ganhador,3,4,5)) > -1) return x;   
    else if ((x = melhorCasa(ganhador,6,7,8)) > -1) return x;   
    else if ((x = melhorCasa(ganhador,0,3,6)) > -1) return x;   
    else if ((x = melhorCasa(ganhador,1,4,7)) > -1) return x;   
    else if ((x = melhorCasa(ganhador,2,5,8)) > -1) return x;   
    else if ((x = melhorCasa(ganhador,0,4,8)) > -1) return x;   
    else if ((x = melhorCasa(ganhador,2,4,6)) > -1) return x;   
    else return -1;    // Não existe casa ganhadora
  }

  final private int melhorCasa(String ganhador, int i, int j, int k) {
    if ((c[i] + c[j] + c[k]).equals(ganhador)) { 
      if (c[i].equals("")) return i;
      else if (c[j].equals("")) return j;
      else return k;
    }
    else return -1;
  }

  // MAIN: instancia a classe para GUI e dispara o seu construtor
  public static void main(String args[]) {
    JogoDaVelha app = new JogoDaVelha();                // Cria e dispara
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termina
 }

}
