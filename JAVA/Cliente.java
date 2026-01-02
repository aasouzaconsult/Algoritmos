/**----------------------------------------------------------------------*/
/** Exemplos de composição e herança.                                    */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
class Prato {
  Prato(int i) {
    System.out.println("Construtor de Prato " + i);
  }
}

class Pires extends Prato {
  Pires(int i) {
    super(i);
    System.out.println("Construtor de Pires " + i);
  }
}

class Talher {
  Talher(int i) {
    System.out.println("Construtor de Talher " + i);
  }
}

class Colher extends Talher {
  Colher(int i) {
    super(i);
    System.out.println("Construtor de Colher " + i);
  }
}

class Garfo extends Talher {
  Garfo(int i) {
    super(i);
    System.out.println("Construtor de Garfo " + i);
  }
}

class Faca extends Talher {
  Faca(int i) {
    super(i);
    System.out.println("Construtor de Faca " + i);
  }
}

class Pessoa {
  Pessoa(int i) {
    System.out.println("Construtor de Pessoa " + i);
  }
}

public class Cliente extends Pessoa {
  Colher colher;
  Garfo garfo;
  Faca faca;
  Pires pires;

  Cliente(int i) {
    super(i+1);
    colher = new Colher(i+2);
    garfo = new Garfo(i+3);
    faca = new Faca(i+4);
    pires = new Pires(i+5);
    System.out.println("Construtor de Cliente " + i);
  }

  public static void main(String[] args) {
    Cliente x = new Cliente(9);
  }
} 