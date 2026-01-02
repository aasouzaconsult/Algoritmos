class cpfsimples{ 
  public static void main(String args[]){ 
    if(args.length!=1){ 
      System.out.println("Forneca o numero do CPF na linha de comando"); 
      System.exit(0); 
    } 
    int cpf= Integer.parseInt(args[0]); 
    System.out.println("calculo dos digitos verificadores do cpf:"+cpf); 
    int d0, d1, d2, d3, d4, d5, d6, d7, d8; 
    int somaprod1, somaprod2; 
    int dezena, unidade; 
    int restoAux; 
    d0=cpf%10;         d1=cpf/10%10;       d2=cpf/100%10; 
    d3=cpf/1000%10;    d4=cpf/10000%10;    d5=cpf/100000%10; 
    d6=cpf/1000000%10; d7=cpf/10000000%10; d8=cpf/100000000%10; 

    somaprod1=d0*2+d1*3+d2*4+d3*5+d4*6+d5*7+d6*8+d7*9+d8*10; 
  

    restoAux=somaprod1%11; 

    dezena=restoAux<2 ? 0 : 11-restoAux; 

    somaprod2=dezena*2+ 
              d0*3+d1*4+d2*5+d3*6+d4*7+d5*8+d6*9+d7*10+d8*11; 
    restoAux=somaprod2%11; 

    unidade=restoAux<2 ? 0 : 11-restoAux; 

    System.out.print(dezena); 
    System.out.println(unidade); 
  } 
} 


