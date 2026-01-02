// Dir.java

import java.io.*;

public class Dir
{
    public static void main(String args[])
    {
        File dirAtual = new File(".");
        String listaArquivos[] = dirAtual.list();

        for (int i = 0; i < listaArquivos.length; i++)
        {
            File arquivoAtual = new File(listaArquivos[i]);
            System.out.println(listaArquivos[i] + " [" +  
                               arquivoAtual.length() + " bytes]");
        }
    }
}
