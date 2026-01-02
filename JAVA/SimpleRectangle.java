//Isto é um exemplo de uma classe em Java
//que usa outra classe.
//Definimos aqui a classe SimpleRectangle 
//que recorre à classe SimplePoint.
public class SimpleRectangle {
	public int width = 0;
	public int height = 0;
	public SimplePoint origin = new SimplePoint();
}
//Após a definição poderíamos utilizar:
//
// SimpleRectangle r = new SimpleRectangle();
// r.width=100;
// r.height=200;
// r.origin.x=10;
// r.origin.y=30;
//
// Nota: r.origin é do tipo SimplePoint