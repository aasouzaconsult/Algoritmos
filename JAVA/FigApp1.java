//Aplicação de teste das classes Ponot, Circulo e Quadrado
//

//imports...
import java.io.*;
import java.lang.Integer;

//a classe principal
public class FigApp1 {

	//din é necessário para utilizarmos readLine();
	static DataInputStream din = new DataInputStream(System.in);

	//Os métodos lerObjecto permitem-nos ler um objecto de 
	//cada classe. Embora os métodos tenham o mesmo nome
	//tem assinaturas (conjunto de parâmetros diferentes)
	//i.e. "overloading".
	static void lerObjecto(Ponto p) throws java.io.IOException
	{
		System.out.println("x:");
		p.x=Integer.parseInt(din.readLine());
		System.out.println("y:");
		p.y=Integer.parseInt(din.readLine());
	}

	static void lerObjecto(Circulo c) throws java.io.IOException
	{
		System.out.println("centro:");
		lerObjecto(c.centro);
		System.out.println("raio:");
		c.raio=Integer.parseInt(din.readLine());
	}

	static void lerObjecto(Quadrado q) throws java.io.IOException
	{
		System.out.println("centro:");
		lerObjecto(q.centro);
		System.out.println("lado:");
		q.lado=Integer.parseInt(din.readLine());
	}

	//Os métodos mostrarObjecto permitem-nos ver o conteúdo
	//de um objecto de cada classe. 
	static void mostrarObjecto(Ponto p)
	{
		System.out.println("x:"+p.x);
		System.out.println("y:"+p.y);
	}

	static void mostrarObjecto(Circulo c)
	{
		System.out.println("centro:");
		mostrarObjecto(c.centro);
		System.out.println("raio:"+c.raio);
	}

	static void mostrarObjecto(Quadrado q)
	{
		System.out.println("centro:");
		mostrarObjecto(q.centro);
		System.out.println("lado:"+q.lado);
	}

	//o método principal da nossa classe...
	public static void main(String args[]) throws java.io.IOException
	{
		//criar objectos base
		Ponto p=new Ponto();
		Circulo c1=new Circulo();
		Circulo c2=new Circulo();
		Quadrado q=new Quadrado();
		
		//Ler dados
		System.out.println("Ler Dados...\n");
		System.out.println("Ponto:");
		lerObjecto(p);
		System.out.println("Circulo 1:");
		lerObjecto(c1);
		System.out.println("Circulo 2:");
		lerObjecto(c2);
		System.out.println("Quadrado:");
		lerObjecto(q);

		//Mostrar dados...
		System.out.println("\nMostar Dados...\n");
		System.out.println("Ponto:");
		mostrarObjecto(p);
		System.out.println("Circulo 1:");
		mostrarObjecto(c1);
		System.out.println("Circulo 2:");
		mostrarObjecto(c2);
		System.out.println("Quadrado:");
		mostrarObjecto(q);

		//Aguardar por [Enter] do utilizador...
		din.readLine();
	}
}