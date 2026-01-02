// ThreadDemo1.java

class Linha extends Thread
{
    public void run()
    {
        for (int i = 0; i < 6; i++)
        {
            System.out.println("Teste" + i);
            try { sleep(10); }
            catch (InterruptedException e)
            { System.err.println(e.toString()); }
        }
    }
}

public class ThreadDemo1
{
    public static void main(String args[])
    {
        Linha l1 = new Linha();
        Linha l2 = new Linha();

        l1.start();
        l2.start();
    }
}
