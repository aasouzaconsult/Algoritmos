/***
 ***  Classe que implementa um fila de prioridades simples
 ***  Fundão da Computação © 2002
 ***  e-Mail: fundao@fundao.pro.br
 ***/
class IntPriorityQueue 
{
    private int[] queue;
    private int   size;
    private int   elements;

    public IntPriorityQueue( int TAM )
    {
        queue    = new int[TAM];
        size     = TAM;
        elements = 0;
        for ( int j = 0; j < TAM; j++ )
           queue[j] = -1;
    }
    
    // Insere um valor na fila
    public void Insert( int value ) {
        if ( value > -1 && elements < size )
           queue[ elements++ ] = value;
    }
    
    // Remove o maior valor da fila
    public int Remove() {
        int j, aux, max = 0;
        if ( elements > 0 ) {
           for ( j = 1; j < elements; j++ )
              if ( queue[max] < queue[j] )
                 max = j;
           // Troca
           aux = queue[max];
           queue[max] = queue[elements-1];
           queue[elements-1] = aux;
           return queue[--elements];
        }
        return -1;        
    }
    
    // Imprime os elementos da fila
    public void Print()
    {
        for( int i=0; i<elements; i++ )
           System.out.println(queue[i]);
    }
}

/*  Exemplo de utilização da classe */

/*
public class sample {

   public static void main(String[] args) {
     int TAM = args.length > 0 ? args.length : 10;
     Heap pq;
     pq = new Heap(TAM);
     pq.Insert(45);
     pq.Insert(65);
     pq.Insert(15);
     pq.Insert(2);
     pq.Insert(100);
     pq.Insert(30);
     pq.Print();
   }
}
*/