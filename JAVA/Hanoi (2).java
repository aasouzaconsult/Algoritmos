/*-----------------------------------------------------------------------*/
/* Torre de Hanói: lista os movimentos necessários para completar o jogo.*/
/* O objetivo é transferir todos os discos empilhados em uma haste       */
/* para uma outra haste, inicialmente vazia, usando uma terceira haste   */
/* para armazenamento temporário. Os discos estão ordenados por tamanho  */
/* com o maior disco em baixo. Pode-se mover apenas um disco por vez e,  */
/* em nenhum momento, um disco maior pode pousar sobre um disco maior.   */
/* Como o algoritmo é exponencial, o número de discos não deve ser grande*/
/* Solução iterativa (não recursiva).                                    */
/* Francisco A. S. Grossi                                                */
/*-----------------------------------------------------------------------*/
public class Hanoi {
/*-----------------------------------------------------------------------*/
/* 1)Transfere n-1 discos da haste 'a' para a haste 'c' ('b' auxiliar)   */
/* 2)Move o último disco da haste  'a' para a haste 'b'                  */
/* 3)Transfere n-1 discos da haste 'c' para a haste 'b' ('a' auxiliar)   */
/* Parâmetros: 1) Número de discos que devem ser transferidos            */
/*             2) Haste onde estão os discos                             */
/*             3) Haste para onde vão os discos                          */
/*             4) Haste auxiliar                                         */
/*-----------------------------------------------------------------------*/
  public static void transfere(int n, char a, char b, char c) {
    if (n > 0) {
       transfere(n-1,a,c,b);
       System.out.println("Move disco " + n + " da haste " + a +
		            " para haste " + b);
       transfere(n-1,c,b,a);
    }
  }
/*-----------------------------------------------------------------------*/
/* Programa principal: Move n discos de A para B, usando C como auxiliar.*/
/* Identificam-se as hastes pelas letras A,B,C.                          */
/*-----------------------------------------------------------------------*/
  public static void main(String argumentos[]) {
    int numero;

    do {
      numero = Teclado.readInt("Entre o número de discos:");
    } while (numero < 0 || numero > 16);
    
    transfere(numero,'A','B','C');  
  }
}
