//Exemplo de uma classe com um construtor
public class Point {
	public int x = 0;
	public int y = 0;
	//construtor
	//Os construtores tem sempre o mesmo nome que a classe
	public Point(int x, int y) {
		// A palavra chave this é utilizada para distinguir
		// os parâmetros x e y do construtor dos campos x
		// e y da classe (this.x refere-se ao campo da classe)
		this.x = x;
		this.y = y;
	}
}
//Após a definição poderíamos utilizar:
//
// Point p1 = new Point();
// p1.x=10;
// p2.y=20;
// Point p2 = new Point(10,20);
//
// O conteúdo dos objectos p2 e p1 é o mesmo