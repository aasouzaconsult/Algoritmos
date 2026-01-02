/**----------------------------------------------------------------------*/
/** Classe para quadiláteros quaisquer.                                  */
/** Aplicativo que usa tem que criar os quatro pontos dos vértices.      */
/** Assume-se que os vértices estejam ligados da seguinte maneira:       */
/** Vértice 1 ==> vértice 2 ==> vértice 3 ==> vértice 4 ==> vértice 1    */ 
/** e que os pontos definem um quadrilátero convexo, mas não é testado.  */ 
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
import java.awt.*;
public class Quadrilatero {  
  private Point v1, v2, v3, v4;
  private final static double p = 1e-7;

  // Construtor: precisa de quatro pontos para vértices
  public Quadrilatero(Point v1, Point v2, Point v3, Point v4) {
    setQuadrilatero(v1,v2,v3,v4); 
  }

  // Altera as coordenadas dos vértices
  public void setQuadrilatero(Point v1, Point v2, Point v3, Point v4) {
    this.v1 = v1; 
    this.v2 = v2;
    this.v3 = v3;
    this.v4 = v4;
  }
  
  // Método auxiliar: calcula o comprimento entre dois pontos
  private double comprimento(Point p1, Point p2) {
    return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x) + 
                     (p2.y-p1.y)*(p2.y-p1.y));
  }

  // Retorna maior largura (v1=>v2 ou v3=>v4)
  public double largura() {
    double c1 = comprimento(v1,v2);
    double c2 = comprimento(v3,v4);
    return c1 > c2 ? c1 : c2;
  }

  // Retorna maior espessura (v2=>v3 ou v4=>v1) 
  public double espessura() {
    double c1 = comprimento(v2,v3);
    double c2 = comprimento(v4,v1);
    return c1 > c2 ? c1 : c2;
  } 

  // Retorna soma dos quatro lados
  public double perimetro() {
    return comprimento(v1,v2) + comprimento(v2,v3) + 
           comprimento(v3,v4) + comprimento(v4,v1); 
  }

  // Retorna true se for um losango (quatro lados iguais)
  public boolean ehLosango() {
    double c1 = comprimento(v1,v2);
    double c2 = comprimento(v2,v3);
    double c3 = comprimento(v3,v4);
    double c4 = comprimento(v4,v1);
    return Math.abs(c1 - c2) < p && 
           Math.abs(c1 - c3) < p && 
           Math.abs(c1 - c4) < p;     
  } 

  // Retorna true se for um retângulo
  public boolean ehRetangulo() {
    double c1 = comprimento(v1,v2);
    double c2 = comprimento(v2,v3);
    double c3 = comprimento(v3,v4);
    double c4 = comprimento(v1,v4);
    double seno1 = Math.abs(v1.y-v2.y)/c1;
    double seno2 = Math.abs(v1.x-v4.x)/c4; 
    double seno3 = Math.abs(v2.y-v3.y)/c2; 
    double seno4 = Math.abs(v3.x-v4.x)/c3; 
    return Math.abs(seno1 - seno2) < p && 
           Math.abs(seno3 - seno4) < p &&
           Math.abs(c1 - c3) < p;
  }

  // Retorna true se for um quadrado
  public boolean ehQuadrado() {
    return ehRetangulo() && ehLosango();
  }

}
