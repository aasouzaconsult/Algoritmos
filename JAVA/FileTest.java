//Pequena classe que testa escrita e leitura
//num ficheiro binário sequencial
import java.util.*;
import java.io.*;

//A classe principal da nossa Aplicação de teste
public class FileTest{
	public static void main(String args[]) throws java.io.IOException{
		
		//Criar objectos
		Aluno aluno1 = new Aluno("Paulo Sousa", 3, 15.0, new Date(74,3,12));
		Aluno aluno2 = new Aluno("Ricardo Silva", 2, 14.3, new Date(75,2,23));

		//Primeiro vamos guardar os dados

		//Abrir ficheiro para escrita
		FileOutputStream fos=new FileOutputStream("aluno.dat");
		
		//Guardar os dados dos alunos
		aluno1.toOutputStream(fos);
		aluno2.toOutputStream(fos);

		//Fechar ficheiro
		fos.close();

		//Agora vamos ler novamente os dados

		//Abrir ficheiro para leitura
		FileInputStream fis = new FileInputStream("aluno.dat");

		//Ler dados
		Aluno aluno1a = new Aluno(fis);
		Aluno aluno2a = new Aluno(fis);

		//Fechar ficheiro
		fis.close();

		//Mostrar dados
		System.out.print("Original:\n"+aluno1+"\n" + aluno2 + "\n\nGuardado:\n"+aluno1a + "\n" + aluno2a);
		
		System.in.read();
	}
}

//Classe com dados de um alunos
class Aluno {
	//Campos públicos
	public String nome;
	public int ano;
	public double media;
	public Date nasc;

	//Construtor normal
	public Aluno(String nome, int ano, double media, Date nasc) {
		this.nome = nome;
		this.ano = ano;
		this.media = media;
		this.nasc = nasc;
	}

	//Construtor a partir de InputStream 
	//Nota: FileInputStream é subclasse de InputStream
	public Aluno(InputStream in) throws java.io.IOException{
		//Usar um DataInputStream para ler os dados
		//formatados
		DataInputStream din=new DataInputStream(in);

		//Ler String...
		nome = din.readUTF();

		//Ler int...
		ano = din.readInt();

		//Ler double...
		media = din.readDouble();

		//Ler Date (utilizando vários readInt)...
		int dano = din.readInt();
		int dmes = din.readInt();
		int ddia = din.readInt();
		nasc=new Date(dano,dmes,ddia);
	}

	//Escrever os dados do objecto para um OutputStream
	//Nota: FileOutputStream é subclasse de OutputStream
	public void toOutputStream(OutputStream os) throws java.io.IOException{
		//Usar um DataOutputStream para escrever os dados
		//formatados
		DataOutputStream dos=new DataOutputStream(os);

		//Escrever String...
		dos.writeUTF(nome);

		//Escrever int...
		dos.writeInt(ano);

		//Escrever Double...
		dos.writeDouble(media);

		//Escrever Date (utilizando vários writeInt)...
		dos.writeInt(nasc.getYear());
		dos.writeInt(nasc.getMonth());
		dos.writeInt(nasc.getDate());
	}

	//Para facilitar a apresentação dos dados
	//da classe implementamos o método toString...
	public String toString() {
		return "Nome: " + nome +"\nAno: " + ano +"\nMedia: " + media +  "\nData Nascimento:" + nasc;
	}
}