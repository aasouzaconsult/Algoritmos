/**----------------------------------------------------------------------*/
/** Exemplos de subclasses, métodos construtores, polimorfismo.          */
/** Este exemplo apenas mostra a relação entre classes e métodos, e não  */
/** tem a pretensão de ser uma boa maneira de implementar os métodos     */
/** para estas classes nem modelar uma hierarquia realista.              */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
import java.awt.*;
import javax.swing.*;

public class Animais extends JFrame {
  static String mensagem = "";
  JTextArea area = new JTextArea();
  
  public Animais() {
    Animal qq;         

    Animais.concatena("\nConstrutores:\n");
    Gato   gato1 = new Gato("Tom");
    Pato   pato1 = new Pato("Patolino");
    Rato   rato1 = new Rato("Jerry");
    Rato   rato2 = new Rato();
    Object rato3 = new Rato("Jerry");
    Animais.concatena("Rato1 igual Rato2 = " + rato1.equals(rato2));
    Animais.concatena("rato1 igual rato3 = " + rato1.equals(rato3));

    Animais.concatena("\nChamadas específicas:\n");
    gato1.fala(); gato1.come(); gato1.dorme();
    pato1.fala(); pato1.come(); pato1.dorme();
    rato1.fala(); rato1.come(); rato1.dorme();
    
    Animais.concatena("\nChamadas polimórficas:\n");
    qq = gato1; qq.fala(); qq.come(); qq.dorme();
    qq = pato1; qq.fala(); qq.come(); qq.dorme();
    qq = rato1; qq.fala(); qq.come(); qq.dorme();

    Animais.concatena("\nChamadas com coerção (casting):\n");
    if (qq instanceof Rato) {
      rato1 = (Rato) qq;
      rato1.fala(); rato1.come(); rato1.dorme();
      rato2 = (Rato) qq;
      rato2.fala(); rato2.come(); rato2.dorme();
    }
    
    JScrollPane scp = new JScrollPane(area);
    area.setEditable(false);
    area.setForeground(Color.blue);
    area.setLineWrap(true);    
    area.setText(mensagem);    
    getContentPane().add(scp);
    
    mostra();

  }

  // Calcula a pósição e mostra a janela
  private void mostra() {
    Dimension z = Toolkit.getDefaultToolkit().getScreenSize();
    int largura = 800;
    int altura = 600;
    int x = (z.width-largura)/2;
    int y = (z.height-altura)/2;

    setTitle("Teste das Classes da Hierarquia de Animais");
    setBounds(x,y,largura,altura);
    setResizable(false);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void concatena(String msg) {
    mensagem += msg + '\n';
  }

  // Cria a interface gráfica disparando seu construtor. 
  public static void main(String[] args) {
    Animais app = new Animais();
  }

}
/*-----------------------------------------------------------------------*/
/* Superclasse abstrata de que todas as outras descendem                 */
/*-----------------------------------------------------------------------*/
abstract class Animal {          
  protected String nome;
  
  //Construtor padrão da super classe
  // Chamado, implicita ou explicitamente, pelos construtores dos objetos
  public Animal() { 
    nome = "SemNome";
    Animais.concatena("Construtor padrão super para " + getClass().getName());
    Animais.concatena("Animal " + this + " foi criado\n");
  }

  // Construtor adicional da super classe (sobrecarga)
  // Chamado explicitamente pelos construtores dos objetos
  public Animal(String nome) { 
    this.nome = nome;
    Animais.concatena("Construtor super para " + getClass().getName());
    Animais.concatena("Animal " + this + " foi criado\n");
  }

  // Converte implícita ou explicitamente objeto em string 
  // Substitui método toString herdado de Object
  public String toString() {
    return getClass().getName() + " " + nome;
  }  
  
  // Verifica igualdade de dois objetos 
  // Substitui método equals herdado de Object
  public boolean equals(Object that) {
    return this.getClass().getName() == that.getClass().getName()
      && this.nome == ((Animal) that).nome;  
  }

  // Métodos abstratos que têm que ser implementados nas subclasses
  public abstract void fala();
  public abstract void come();
  public abstract void dorme();

}
/*-----------------------------------------------------------------------*/
/* Subclasse Gato: herda de Animal                                       */
/*-----------------------------------------------------------------------*/
class Gato extends Animal {      

  // Construtor padrão
  public Gato() {
    // Chama implicitamente o construtor padrão da super classe aqui
    nome = "gato";
    Animais.concatena("Construtor padrão da classe: " + this + " criado\n");
  }

  // Construtor sobrecarregado
  public Gato(String nome) {
    // Chama implicitamente o construtor padrão da super classe aqui
    this.nome = nome;
    Animais.concatena("Construtor da classe: " + this + " foi criado\n");
  }

  public void fala() {
    Animais.concatena(this + " mia");
  }    

  public void come() {
    Animais.concatena(this + " come pequenos animais");
  } 

  public void dorme() {
    Animais.concatena(this + " dorme durante o dia e noite");
  } 

}
/*----------------------------------------------------------------------*/
/* Subclasse Pato: herda de Animal                                      */
/*----------------------------------------------------------------------*/
class Pato extends Animal {     

  // Construtor padrão
  public Pato() {
    // Chama implicitamente o construtor padrão da super classe aqui
    nome = "pato";
    Animais.concatena("Construtor padrão da classe: " + this + " criado\n");
  }

  // Construtor sobrecarregado
  public Pato(String nome) {
    // Chama explicitamente o construtor sobrecarregado da super classe
    // Não chama implicitamente o construtor padrão da super classe
    super(nome);
    Animais.concatena("Construtor da classe: " + this + " foi criado\n");
  }

  public void fala() {
    Animais.concatena(this + " grasna");
  }

  public void come() {
    Animais.concatena(this + " come milho");
  }  

  public void dorme() {
    Animais.concatena(this + " dorme durante a noite"); 
  }

}
/*-----------------------------------------------------------------------*/
/* Subclasse Rato herda de Animal                                        */
/*-----------------------------------------------------------------------*/
class Rato extends Animal {   
  
  // Construtor padrão
  public Rato() {
    // Chama explicitamente o construtor da super classe aqui
    super("comum");
    Animais.concatena("Construtor padrão da classe: " + this + " criado\n");
  }

  // Construtor sobrecarregado
  public Rato(String nome) {
    // Chama  implicitamente o construtor padrão da super classe aqui
    this.nome = nome;
    Animais.concatena("Construtor da classe: " + this + " criado\n");
  }

  public void fala() {
    Animais.concatena(this + " guincha");
  }

  public void come() {
    Animais.concatena(this + " come cereais");
  }  

  public void dorme() {
    Animais.concatena(this + " dorme durante o dia"); 
  }

}