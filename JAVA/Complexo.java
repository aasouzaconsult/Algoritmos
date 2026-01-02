/**----------------------------------------------------------------------*/
/** Classe (ADT) para números complexos.                                 */
/** Como todas as classes descendem de Object (por default),             */
/** todos os métodos da classe Object também estão disponíveis.          */
/** Francisco A. S. Grossi                                               */
/*-----------------------------------------------------------------------*/
public final class Complexo {
  private double real = 0, imag = 0;

 // Construtor sem parâmetros: inicializa com zeros
  public Complexo() {
    setComplexo(0,0);
  }

  // Construtor com parâmetros: inicializa com os valores
  public Complexo(double x, double y) {
    setComplexo(x,y);
  }

  // Altera os valores do complexo
  public final void setComplexo(double x, double y) {
    real = x;
    imag = y;
  }

  // Altera apenas a parte real
  public final void setReal(double x) {
    real = x;
  }

  // Altera apenas a parte imaginária
  public final void setImaginario(double y) {
    imag = y;
  }

  // Retorna a parte real do complexo
  public final double getReal() {
    return real;
  }

  // Retorna a parte imaginária do complexo
  public final double getImaginario() {
    return imag;
  }
  // Retorna a soma deste objeto com o parâmetro
  public final Complexo soma(Complexo x) {
    return new Complexo(real + x.real,imag + x.imag);
  }

  // Retorna a diferença entre este objeto e o parâmetro
  public final Complexo subtrai(Complexo x) {
    return new Complexo(real - x.real,imag - x.imag);
  }

  // Retorna o produto deste objeto e o parâmetro
  public final Complexo multiplica(Complexo x) {
    Complexo p = new Complexo();
    p.real = real * x.real - imag * x.imag;
    p.imag = real * x.imag + imag * x.real;
    return p;
  }

  // Retorna o quociente deste objeto pelo parâmetro
  public final Complexo divide(Complexo x) {
    Complexo q = new Complexo();
    double den = x.real * x.real + x.imag * x.imag;
    q.real = (real * x.real + imag * x.imag) / den;
    q.imag = (imag * x.real - real * x.imag) / den;
    return q;
  }

  // Compara dois números complexos
  // Substitui o método equals da superclasse Object
  public final boolean equals(Complexo x) {
    return real == x.real && imag == x.imag;
  }

  // Retorna string para exibição deste objeto
  // Testa negativo para deixar o "-" separado
  // Substitui o método toString da superclasse Object
  public final String toString() {
    if (imag < 0) return real + " - " + (-imag) + "i";
    else return real + " + " + imag + "i";
  }

}
