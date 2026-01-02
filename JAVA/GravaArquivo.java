// GravaArquivo.java

import java.io.*;

public class GravaArquivo
{
    public static void main(String args[])
    {
        int[] data = { 71, 73, 70, 56, 57, 97, 15, 0, 15, 0,
                       128, 0, 0, 255, 255, 255, 0, 0, 0, 44, 0, 0, 0, 
                       0, 15, 0, 15, 0, 0, 2, 33, 132, 127, 161, 200,
                       185, 205, 84, 128, 241, 81, 35, 175, 155, 26,
                       228, 254, 105, 33, 102, 121, 165, 201, 145, 169,
                       154, 142, 172, 116, 162, 240, 90, 197, 5, 0, 59 };
        try
        {
            FileOutputStream file = new FileOutputStream("pix.gif");
            for (int i = 0; i < data.length; i++)
            {
                file.write(data[i]);
            }
            file.close();
        }
        catch (IOException e)
        {
            System.out.println("Erro:" + e.toString());
        }
    }
}
