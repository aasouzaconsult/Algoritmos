// DadosCompartilhados.java

class Conta 
{
    static int balanco = 10000000;
    static int despesa = 0;    

    static public synchronized void transacao(int montante)
    {
        if (montante <= balanco)
        {
            balanco = balanco - montante;      
            for (float a = 0; a < 100000; a++);
            despesa = despesa + montante;
            System.out.print(balanco + despesa + " ");
        }
        else 
        {
            System.out.println("Saldo inferior ao necessário");
        }
    }
}

class minhaThread extends Thread
{
    public void run()
    {
        for (int i = 0; i < 1000; i++)
            Conta.transacao((int)(Math.random() * 100));
    }
}

public class DadosCompartilhados
{
    public static void main(String args[])
    {
        new minhaThread().start();
        new minhaThread().start();
        new minhaThread().start();
        new minhaThread().start();
        new minhaThread().start();
        new minhaThread().start();
    }
}

