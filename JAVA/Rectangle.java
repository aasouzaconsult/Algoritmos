//Exemplo de uma classe com múltiplos construtores, campos e métodos
public class Rectangle {
	
	// Campos (Fields)
	
	// Neste caso todos os campos são
	// acessíveis por outras classes
	public int width = 0;
	public int height = 0;
	// O campo origin é do tipo Point
	// (ver exemplo anterior)
	public Point origin;
	//Utilização:
	//
	//Rectangle r = new Rectangle();
	//r.width=10;
	//r.height=20;
	//r.origin.x=30;
	//r.origin.y=40;
	//
	//ou:
	//
	//Rectangle r = new Rectangle();
	//Point p;
	//
	//r.width=10;
	//r.height=20;
	//p=r.origin;
	//p.x=30;
	//p.y=40;

	//Construtores
	
	public Rectangle() {
		origin = new Point(0,0);
	}
	//Utilização:
	//
	//Rectangle r = new Rectangle();
	
	public Rectangle(Point p) {
		origin = p;
	}
	//Utilização:
	//
	//Point p = new Point(10,20);
	//Rectangle r = new Rectangle(p);
	
	public Rectangle(int w, int h) {
		//neste caso utilizamos outro construtor
		//desta classe
		this(new Point(0,0), w, h);
	}
	//Utilização:
	//
	//Rectangle r = new Rectangle(40,40);
	
	public Rectangle(Point p, int w, int h) {
		origin = p;
		width = w;
		height = h;
		// como não há confusão entre os parâmetros do
		// método e os campos não precisamos de utilizar
		// a palavra chave this
	}
	//Utilização:
	//
	//Point p = new Point(10,20);
	//Rectangle r1 = new Rectangle(p,40,40);
	//Rectangle r2 = new Rectangle(new Point(10,20),30,40);

	//Métodos

	public void move(int x, int y) {
		origin.x = x;
		origin.y = y;
	}
	//Utilização:
	//
	//Rectangle r = new Rectangle(20,30);
	//r.move(40,50);
		
	public int area() {
		return width * height;
	}
	//Utilização:
	//
	//Rectangle r = new Rectangle(new Point(10,20),20,30);
	//int a1 = r.area();
	//System.out.println("A area e': " + a1);
	//
	//Nota: utilizamos "r.area()" que é um método mas
	// fazemos "r.width" pois no segundo caso temos um campo.

	protected void finalize() throws Throwable {
		origin = null;
		super.finalize();
	}
	//Método especial que é chamado automaticamente pelo
	//Java a partir do momento em que não existem mais 
	//referências ao objecto. Nota importante: o método
	//pode ser chamado imediatamente depois de eliminada 
	//a última referência, mas também pode ser chamado 
	//mais tarde. Mas é sempre chamado antes de terminar
	//a execução da aplicação.
	//
	//Por exemplo:
	//
	//Rectangle r1 = new Rectangle();
	//Rectangle r2 = r1;
	//
	//r1=null; //ainda existe uma referência em r2
	//r2=null; //já não existe nenhuma referência
	//         //o método finalize() já pode ser chamado
	//         //pelo Java.
}
