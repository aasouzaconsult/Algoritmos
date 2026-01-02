/**----------------------------------------------------------------------*/
/** Classe (ADT) para números racionais.                                 */
/** Se o denominador for zero, lança uma exceção aritmética.             */ 
/** Como todas as classes descendem de Object (por default),             */
/** todos os métodos da classe Object também estão disponíveis.          */
/** Francisco A. S. Grossi                                               */
/*-----------------------------------------------------------------------*/
public final class Racional {  
  private int num = 0, den = 1;

  // Construtor sem parâmetros: inicializa com 0/1
  public Racional() {
    this(0,1);    // Invoca o construtor com parâmetros
  }

  // Construtor com parâmetros: inicializa com os valores
  public Racional(int x, int  y) {
    setRacional(x,y);
  }

  // Altera os valores do racional 
  public final void setRacional(int x, int y) {
    num = x;;
    setDenominador(y);
  }

  // Altera apenas o numerador
  public final void setNumerador(int x) {
    num = x;
    simples(this);
  }

  // Altera apenas o denominador 
  public final void setDenominador(int y) {
    if (y != 0) {
      den = y;
      simples(this);
    }
    else throw new ArithmeticException("Denominador=0");
  } 

  // Retorna o numerador do racional
  public final int getNumerador() {
    return num;
  }

  // Retorna o denominador do racional
  public final int getDenominador() {
    return den;
  }

  // Inverte o racional (troca numerador com denominador)
  public final void inverte() {
    num ^= den;
    den ^= num;
    num ^= den;
  }   

  // Retorna a soma deste objeto com o parâmetro
  public final Racional soma(Racional y) {
    Racional s = new Racional();
    s.num = num * y.den + y.num * den;
    s.den = den * y.den;
    simples(s);
    return s;
  }

  // Retorna este objeto menos o parâmetro
  public final Racional subtrai(Racional y) {
    Racional s = new Racional(); 
    s.num = num * y.den - y.num * den;
    s.den = den * y.den;
    simples(s);
    return s;
  }  

  // Retorna o produto deste objeto e o parâmetro
  public final Racional multiplica(Racional y) {
    Racional p = new Racional();
    p.num = num * y.num;
    p.den = den * y.den;
    simples(p);
    return p;
  } 

  // Retorna o quociente deste objeto pelo parâmetro
  public final Racional divide(Racional y) {
    if (y.num != 0) {
      Racional q = new Racional();
      q.num = num * y.den;
      q.den = den * y.num;
      simples(q);
      return q;
    } 
    else throw new ArithmeticException("Denominador=0");
  } 

  // Compara dois números racionais
  // Substitui o método equals da superclasse Object 
  public final boolean equals(Racional x) {
    return num == x.num && den == x.den;
  }

  // Retorna string para exibição deste objeto
  // Substitui o método toString da superclasse Object
  public final String toString() {
    return num + "/" + den;
  }

  // Simplifica um racional (método privado)
  private void simples(Racional o) {
    int divisor = mdc(o);
    if (den < 0) { 
      o.num = - o.num;
      o.den = - o.den;
    }
    o.num = o.num / divisor;
    o.den = o.den / divisor;
  }

  // Calcula o máximo divisor comum (método privado}
  private int mdc(Racional o) { 
    int x = Math.abs(o.num); 
    int y = Math.abs(o.den); 
    while (y != 0) {
      int r = x%y;
      x = y;
      y = r;
    }
    return x;
  }

}