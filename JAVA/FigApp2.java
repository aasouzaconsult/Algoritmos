//Applicação Java para teste do método toString() nas classes.
//

//imports...
import java.io.*;

//a classe principal
public class FigApp2 {

	//din é necessário para utilizarmos readLine();
	static DataInputStream din = new DataInputStream(System.in);

	//o método principal da nossa classe...
	public static void main(String args[]) throws java.io.IOException
	{
		//criar objectos e inicializá-los
		Ponto p1=new Ponto();
		Ponto p2=new Ponto(10,20);
		Circulo c1=new Circulo(p2,10);
		Circulo c2=new Circulo(50,50,5);
		Quadrado q1=new Quadrado(p2,20);
		Quadrado q2=new Quadrado(10,20,20);

		//Alterar os campos de p2
		p2.x=100;
		p2.y=110;

		//Mostar dados
		System.out.println("\nMostar Dados...\n");
		System.out.println("Ponto 1: " + p1);
		System.out.println("Ponto 2: " + p2);
		System.out.println("Circulo 1: " + c1);
		System.out.println("Circulo 2: " + c2);
		System.out.println("Quadrado 1: " + q1);
		System.out.println("Quadrado 2: " + q2);

		//Nota:
		//Como as classes Quadrado e Circulo guardam os objectos 
		//passados na criação (e não cópias dos mesmos) quando alteramos
		//p2 estamos a alterar o centro de q1 e de c1.


		//Aguardar por [Enter] do utilizador...
		din.readLine();
	}
}