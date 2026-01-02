package telejogo4;


abstract public class ObjetoParado extends ObjetoSimulado {

  public static final int TOTAL = -1;

  abstract public void paint( MaquinaJogo j, java.awt.Graphics g, int wTotal, int hTotal );
}
