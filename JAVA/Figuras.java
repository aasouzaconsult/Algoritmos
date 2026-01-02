/**----------------------------------------------------------------------*/
/** Exemplos de sub classe abstrata, construtores, métodos,              */
/** polimorfismo, heranças de atributos e métodos, composição de objetos.*/
/** Hierarquia de classes:                                               */
/** Figura --> Ponto --> Circulo -->  Cilindro --> Cone                  */
/**                 |--> Reta   |-->  Esfera                             */
/**                 |--> Poligono --> Prisma   --> Piramide              */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
import javax.swing.*;
import java.text.DecimalFormat;
public class Figuras {

  public static void main(String args[]) {
    Ponto    pico = new Ponto(7,9);   
    Reta     reta = new Reta(1,1,4,5);
    Circulo  roda = new Circulo(3,2,6);  
    Esfera   bola = new Esfera(3,2,6);
    Cilindro rolo = new Cilindro(1,2,6,7);
    Cone     cone = new Cone(1,2,6,7);
    Poligono reto = new Poligono(2,1,6,8);
    Prisma   crst = new Prisma(2,1,6,8,7);
    Piramide pira = new Piramide(2,1,6,8,7);

    Figura[] lista = new Figura[9];

    lista[0] = pico;
    lista[1] = reta;
    lista[2] = roda;
    lista[3] = bola;
    lista[4] = rolo;  
    lista[5] = cone;
    lista[6] = reto;
    lista[7] = crst;
    lista[8] = pira;

    DecimalFormat casas = new DecimalFormat("0.00");
    String saida = ""; 

    // Chamadas polimórficas
    for (int i=0; i < lista.length; i++) {
      saida +=  
        lista[i].getNome()  + ": " +
        lista[i].toString() + "\nArea = " +
        casas.format(lista[i].area()) + "\nVolume = " +
        casas.format(lista[i].volume()) + "\n\n";
    }
    JOptionPane.showMessageDialog(null,
       saida,"Classes, Métodos, Herança, Polimorfismo",
       JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);
  }
}
/*-----------------------------------------------------------------------*/
/* Superclasse abstrata de quem todas as figuras descendem.              */
/*-----------------------------------------------------------------------*/
abstract class Figura {           

  // Construtores (omitidos) herdados da super classe Object

  public double area() {
    return 0;
  }
  
  public double volume() {  
    return 0;
  }

  // Método abstrato; tem que ser substituído nas sub classes
  public abstract String getNome();   
}
/*-----------------------------------------------------------------------*/
/* Subclasse Ponto: herda de Figura.                                     */
/*-----------------------------------------------------------------------*/
class Ponto extends Figura {
  protected int x,y;            // Coordenadas do ponto

  // Construtor padrão
  public Ponto() {               
    // Chama implicitamente o construtor da super classe aqui
    setPonto(0,0);
  }
  
  // Construtor sobrecarregado
  public Ponto(int x, int y) { 
    // Chama  implicitamente o construtor da super classe aqui
    setPonto(x,y);
  }
  
  // Estabelece as coordenadas do ponto
  public void setPonto(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  // Retorna coordenada X
  public int getX() {
    return x;
  }
  
  // Retorna coordenada Y
  public int getY() {
    return y;
  }
  
  // Retorna a identificação da classe 
  public String getNome() {
    return "Ponto";
  }
  
  // Converte implícita ou explicitamente objeto em string 
  // Substitui método herdado de Object
  public String toString() {
    return "[" + x + ", " + y + "]";
  }
}
/*-----------------------------------------------------------------------*/
/* Subclasse Reta: herda de Ponto.                                       */
/*-----------------------------------------------------------------------*/
class Reta extends Ponto {
  protected int w,z;        // Coordenadas do fim do segmento de reta

  // Construtor
  public Reta(int x1, int y1, int x2, int y2) { 
    super(x1,y1);
    setFim(x2,y2);
  }
  
  // Estabelece o início da reta
  public void setInicio(int x1, int y1) {
    x = x1;
    y = y1;
  }

  // Estabelece o fim da reta
  public void setFim(int x2, int y2) {
    w = x2;
    z = y2;
  }  

  // Retorna início da reta
  public Ponto getInicio() {
    return new Ponto(x,y);
  }
  
  // Retorna fim da reta
   public Ponto getFim() {
    return new Ponto(w,z);
  }

  // Calcula o comprimento do segmento de reta
  public double comprimento() {
    return Math.sqrt((w-x) * (w-x) + (z-y) * (z-y));
  }

  // Retorna a identificação da classe 
  public String getNome() {
    return "Reta";
  }
  
  // Converte implícita ou explicitamente objeto em string 
  // Substitui método herdado de Object
  public String toString() {
    return "[" + x + ", " + y + "] , " +  "[" + w + ", " + z + "]";
  }
}
/*-----------------------------------------------------------------------*/
/* Subclasse Circulo: herda de Ponto.                                    */
/*-----------------------------------------------------------------------*/
class Circulo extends Ponto {  
  protected double raio;           // Raio do círculo 

  // Construtor
  public Circulo(int x, int y, double r) {
    // Chama o construtor da super classe
    // Construtor padrão da super classe não é chamado
    super(x,y);         
    setRaio(r);  
  }

  // Estabelece o raio
  public void setRaio(double r) {
    raio = r >= 0 ? r : 0;
  }

  // Retorna o raio
  public double getRaio() {
    return raio; 
  }

  // Calcula a área 
  public double area() {
    return Math.PI * raio * raio;
  }

  // Calcula a circunferência
  public double circunferencia() {
    return 2 * Math.PI * raio;
  }  

  // Retorna a identificação da classe 
  public String getNome() {
    return "Circulo";
  }

  // Converte implícita ou explicitamente objeto em string 
  // Substitui método herdado de Object
  public String toString() {
    return "Centro = " + super.toString() + "; raio = " + raio;
  }
}
/*-----------------------------------------------------------------------*/
/* Subclasse Esfera: herda de Circulo.                                   */
/*-----------------------------------------------------------------------*/
class Esfera extends Circulo {
   
  // Construtor
  public Esfera(int x, int y, double r) {
    // Chama o construtor da super classe
    // Construtor padrão da super classe não é chamado
    super(x,y,r);   
  }

  // Calcula a área
  public double area() {
    return 4 * super.area();
  }
   
  // Calcula o volume
  public double volume() {
    return area() * raio / 3;
  }

  // Retorna a identificação da classe 
  public String getNome() {
    return "Esfera";
  }
}
/*-----------------------------------------------------------------------*/
/* Subclasse Cilindro: herda de Circulo.                                 */
/*-----------------------------------------------------------------------*/
class Cilindro extends Circulo {
  protected double altura;         // Altura do cilindro
   
  // Construtor
  public Cilindro(int x, int y, double r, double h) {
    // Chama o construtor da super classe
    // Construtor padrão da super classe não é chamado
    super(x,y,r);   
    setAltura(h);
  }

  // Estabelece a altura
  public void setAltura(double h) {
    altura = h >= 0 ? h : 0;
  }   

  // Retorna a altura
  public double getAltura() {
    return altura;
  }

  // Calcula a área
  public double area() {
    return 2 * super.area() + super.circunferencia() * altura;
  }
   
  // Calcula o volume
  public double volume() {
    return super.area() * altura;
  }

  // Retorna a identificação da classe 
  public String getNome() {
    return "Cilindro";
  }
  
  // Converte implícita ou explicitamente objeto em string 
  // Substitui método herdado de Object
  public String toString() {
    return super.toString() + "; altura = " + altura;
  }
}
/*-----------------------------------------------------------------------*/
/* Subclasse Cone: herda de Cilindro.                                    */
/*-----------------------------------------------------------------------*/
class Cone extends Cilindro {

  // Construtor
  public Cone(int x, int y, double r, double h) {
    // Chama o construtor da super classe
    // Construtor padrão da super classe não é chamado
    super(x,y,r,h); 
  }

  // Calcula a área
  public double area() {
    return super.area() / 2;
  }
   
  // Calcula o volume
  public double volume() {
    return super.volume() / 3;
  }

  // Retorna a identificação da classe 
  public String getNome() {
    return "Cone";
  }
}
/*-----------------------------------------------------------------------*/
/* Subclasse Poligono: herda de Ponto.                                   */
/*-----------------------------------------------------------------------*/
class Poligono extends Ponto {  
  protected int quantidade;        // Quantidade de lados do polígono 
  protected double lado;           // Lado do polígono regular

  // Construtor 
  public Poligono(int x, int y, int n, double a) {
    // Chama o construtor da super classe
    // Construtor padrão da super classe não é chamado
    super(x,y);
    setQuantidade(n);
    setLado(a);
  }

  // Estabelece a quantidade de arestas
  public void setQuantidade(int n) {
    quantidade = n >= 3 ? n : 0;
  }

  // Estabelece o lado
  public void setLado(double a) {
    lado = a >= 0 ? a : 0;
  }

  // Retorna a quantidade de lados
  public int getQuantidade() {
    return quantidade; 
  }

  // Retorna o lado
  public double getLado() {
    return lado; 
  }

  // Calcula o perímetro (soma dos lados)
  public double perimetro() {
    return quantidade * lado;
  }  

  // Calcula o apótema (distância do centro a um dos lados)
  public double apotema() {
    return lado / (2 * Math.tan(Math.PI/quantidade));
  }  

  // Calcula a área
  public double area() {
    return perimetro() * apotema() / 2;
  }

  // Retorna a identificação da classe 
  public String getNome() {
    return "Polígono";
  }

  // Converte implícita ou explicitamente objeto em string 
  // Substitui método herdado de Object
  public String toString() {
    return "Centro = " + super.toString() + "; nº lados = " +
    quantidade + "; lado = " + lado;
  }
}
/*-----------------------------------------------------------------------*/
/* Subclasse Prisma: herda de Poligono.                                  */
/*-----------------------------------------------------------------------*/
class Prisma extends Poligono {
  protected double altura;         // Altura do prisma regular
   
  // Construtor 
  public Prisma(int x, int y, int n, double a, double h) {
    // Chama o construtor da super classe
    // Construtor padrão da super classe não é chamado
    super(x,y,n,a);   
    setAltura(h);
  }

  // Estabelece a altura
  public void setAltura(double h) {
    altura = h >= 0 ? h : 0;
  }   

  // Retorna a altura
  public double getAltura() {
    return altura;
  }

  // Calcula a área
  // Variáveis quantidade e lado herdadas de Polígono
  public double area() {
    return 2 * (super.area()) + quantidade * lado * altura;
  }
   
  // Calcula o volume
  public double volume() {
    return super.area() * altura;
  }

  // Retorna a identificação da classe 
  public String getNome() {
    return "Prisma";
  }
  
  // Converte implícita ou explicitamente objeto em string 
  // Substitui método herdado de Object
  public String toString() {
    return super.toString() + "; altura = " + altura;
  }
}
/*-----------------------------------------------------------------------*/
/* Subclasse Piramide: herda de Prisma.                                  */
/* Usa a classe Poligono (composição).                                   */
/*-----------------------------------------------------------------------*/
class Piramide extends Prisma {
   Poligono poli;
   
  // Construtor 
  public Piramide(int x, int y, int n, double a, double h) {
    // Chama o construtor da super classe
    // Construtor padrão da super classe não é chamado
    super(x,y,n,a,h); 
    poli = new Poligono(x,y,n,a);
  }

  // Calcula apótema da pirâmide 
  // Distância do vértice da pirâmide a um lado do polígono da base
  // Precisa-se do apótema do polígono  
  public double apotema() {
    return Math.sqrt(altura * altura + poli.apotema() * poli.apotema());
  }

  // Calcula a aresta da pirâmide 
  // Distância do vértice da pirâmide a um vértice do polígono da base
  // Variável lado herdada de Poligono através de Prisma 
  public double aresta() {
    return Math.sqrt(poli.apotema() * poli.apotema() + 
      lado * lado / 4);   
  }

  // Calcula a área
  // Variáveis quantidade e lado herdadas de Poligono através de Prisma
  // Precisa-se da área do polígono
  public double area() { 
    return poli.area() + quantidade * lado * apotema() / 2;  
  }
   
  // Calcula o volume
  // Precisa-se da área do polígono
  public double volume() {
   return poli.area() * altura / 3;
  }

  // Retorna a identificação da classe 
  public String getNome() {
    return "Piramide";
  }

}
