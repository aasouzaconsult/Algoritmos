package br.pro.fundao;

/**
 *
 * @version 0.1 20 Junho 2002
 * @author  Fundão da Computação
 *
 */
public class Sorting {

    /**
      Método para ordenação de um array de inteiros utilizando o
      algoritmo Insertion Sort. Preferimos utilizar inteiros para
      facilitar o entendimento. Facilmente modificável para suportar
      outro tipo de dados ou então utilizar uma classe collection do Java.
      @param arrElements Um array de inteiros.
     */
    public static void Insertion( int [] arrElements )
    {
       int key, i;

       for( int j=1; j<arrElements.length; j++ )
       {
          key = arrElements[j];

          // Para ordem decrescente coloque arrElements[i]<key
          for( i=j-1; i>=0 && arrElements[i]>key; i-- )
             arrElements[i+1] = arrElements[i];

          arrElements[i+1]= key;
       }
    }

    public static void main(String[] args) {

        // Criando um pequeno array para teste
        int [] e = {11,250,130,41,58,71};

        // Ordenando o array
        Sorting.Insertion( e );

        // Neste ponto o array já estará ordenado
    }
}