/**----------------------------------------------------------------------*/
/** Testa classe Quadrilátero.                                           */
/** Define losango, retângulo, e quadrado, e chama os métodos.           */ 
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
import java.awt.*;
public class TestaQuad {

  public static void main(String[] p) {
    define(4,1,5,6,7,2,2,6); // Qualquer  
    define(4,1,6,5,4,9,2,5); // Losango
    define(3,1,6,4,4,6,1,3); // Retângulo
    define(3,2,6,5,3,8,0,5); // Quadrado
  }

  public static void define(int x1, int y1, int x2, int y2,
                            int x3, int y3, int x4, int y4) {
    Point v1 = new Point(x1,y1);
    Point v2 = new Point(x2,y2);
    Point v3 = new Point(x3,y3);
    Point v4 = new Point(x4,y4);
    Quadrilatero q = new Quadrilatero(v1,v2,v3,v4);
    
    System.out.println();
    System.out.println("Largura   = " + q.largura());
    System.out.println("Espessura = " + q.espessura());
    System.out.println("Losango   = " + q.ehLosango());
    System.out.println("Retângulo = " + q.ehRetangulo());
    System.out.println("Quadrado  = " + q.ehQuadrado());    
  }

}
