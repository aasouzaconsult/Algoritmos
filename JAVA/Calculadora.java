import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.applet.*;
//import javax.swing.JApplet;

public class Calculadora extends java.applet.Applet
{
	String versao = "11/01/2004 - Por Antonio Alex";
	private Panel funcoes,funcoes_trig;
	private Label status = new Label("Versão" + versao);
	private TextField numero1 = new TextField(20);
	private TextField numero2 = new TextField(20);
	private Label resultado = new Label();
	private Button b_somar = new Button("+");
	private Button b_subtrair = new Button("-");
	private Button b_multiplicar = new Button("*");
	private Button b_dividir = new Button("/");
	private Button b_fatorial = new Button("!");
	private Button b_aleatorio = new Button("#");
	private Button b_sin = new Button("Sin(x)");
	private Button b_cos = new Button("Cos(x)");
	private Button b_tan = new Button("Tan(x)");
	private Button b_pri = new Button("Primo(x)");
	
	public void init()
	{
		setSize(320,320);
		setBackground(Color.lightGray);
		setLayout(new GridLayout(8,1));
		add(status);
		add(resultado);
		add(new Label("Digite o Valor de x "));
		add(numero1);
		add(new Label("Digite o Valor de y "));
		add(numero2);
		
		funcoes = new Panel(new GridLayout(1,6));
		//funcoes.setBackground(Color.cyan);
		funcoes.add(b_somar);
		funcoes.add(b_subtrair);
		funcoes.add(b_multiplicar);
		funcoes.add(b_dividir);
		funcoes.add(b_fatorial);
		funcoes.add(b_aleatorio);
		add(funcoes,BorderLayout.CENTER);
		
		funcoes_trig = new Panel (new GridLayout(1,6));
		//funcoes_trig.setBackground(Color.red);
		funcoes_trig.add(b_sin);
		funcoes_trig.add(b_cos);
		funcoes_trig.add(b_tan);
		funcoes_trig.add(b_pri);
		add(funcoes_trig,BorderLayout.CENTER);
		iniciar();				
	}

	public void iniciar()
	{
		numero1.setText("0");
		numero2.setText("0");
		resultado.setText("0");
		resultado.setAlignment(1);
		resultado.setFont(new java.awt.Font("Dialog",1,20));
		resultado.setBackground(Color.black);
		resultado.setForeground(Color.yellow);
		numero1.requestFocus();
		aviso("" + versao);
	}
	
	public void erro(String w)
	{
		status.setBackground(Color.red);
		status.setText("Erro : " + w);
		repaint();
	}
	
	public void aviso(String w)
	{
		status.setAlignment(1);
		status.setFont(new java.awt.Font("Dialog",1,10));
		status.setBackground(Color.lightGray);
		status.setForeground(Color.black);
		status.setText("" + w);
		repaint();
	}
	
	public void calcular(char operacao)
	{
		aviso("");
		double x = 0;
		double y = 0;
		x = Double.parseDouble(numero1.getText());
		y = Double.parseDouble(numero2.getText());
		
		switch (operacao)
		{
			case '+' : aviso ("Soma");
			x = x + y;
			resultado.setText("" + x);
			break;
			
			case '-' : aviso ("Subtrair");
			x = x - y;
			resultado.setText("" + x);
			break;
			
			case '*' : aviso ("Multiplicar");
			x = x * y;
			resultado.setText("" + x);
			break;
			
			case '/' : aviso ("Dividir");
			if (y == 0)
			{
				erro("Não e possível dividir por zero");
				return;
			}
			x = x / y;
			resultado.setText("" + x);
			break;
			
			case '!' : aviso ("O Fatorial de " + numero1.getText() +" é");
			numero2.setText("0");
			if (x > 100)
			{
				erro("O Número " + numero1.getText() + " é maior (>) que 100");
				return;
			}
			x = 1;
			for (short i=1;i<=Integer.parseInt(numero1.getText());i++)
			{
				x = x * i;
			}
			resultado.setText("" + x);
			break;
			
			case '#' : aviso("Gerador de Numeros Aleatorios ");
			numero2.setText("0");
			x = Math.random();
			resultado.setText("" + x);
			break;
			
			case 's' : aviso("O Sin de ("+ x +") é ");
			numero2.setText("0");
			x = Math.sin(x);
			resultado.setText("" + x);
			break;
			
			case 'c' : aviso("O Cos de ("+ x +") é");
			numero2.setText("0");
			x = Math.cos(x);
			resultado.setText("" + x);
			break;
			
			case 't' : aviso("A Tan de ("+ x +") é");
			numero2.setText("0");
			x = Math.tan(x);
			resultado.setText("" + x);
			break;
			
			case 'p' : aviso("Primo("+ x+")");
			numero2.setText("0");
			long fator,ultimo;
            boolean primo;
            if (x == 0)
            {
            	x++;
            	resultado.setText("0");
            	erro("Entre com um número maior que " + x);break;
            }
            if (x == 1)
            {
            	resultado.setText("" + x);
            	erro("Entre com um número maior que " + x);break;
            }
            while (x < 2); 
            primo = x < 4 || x % 2 == 1; 
            ultimo = (long) Math.sqrt(x);
            for (fator=3; primo && fator <= ultimo; fator += 2)
            primo = x % fator != 0;
            if (primo) aviso(x + " é um número PRIMO");
            else aviso(x + " não é primo e sim um número COMPOSTO");
            break;
			
			default:
		}
		
		//resultado.setText("" + x);
		repaint();
     }
	
	public boolean action (Event e, Object o)
	{
		if (e.target.equals(b_somar)) 
		{
			calcular('+');
		}
		
		if (e.target.equals(b_subtrair)) 
		{
			calcular('-');
		}
		
		if (e.target.equals(b_multiplicar)) 
		{
			calcular('*');
		}
		
		if (e.target.equals(b_dividir)) 
		{
			calcular('/');
		}
		
		if (e.target.equals(b_fatorial)) 
		{
			calcular('!');
		}
		
		if (e.target.equals(b_aleatorio)) 
		{
			calcular('#');
		}
		
		if (e.target.equals(b_sin)) 
		{
			calcular('s');
		}
		
		if (e.target.equals(b_cos)) 
		{
			calcular('c');
		}
		
		if (e.target.equals(b_tan)) 
		{
			calcular('t');
		}
		
		if (e.target.equals(b_pri)) 
		{
			calcular('p');
		}
		
		return true;
	}
		 		
}
