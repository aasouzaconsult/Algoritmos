/**
 * CenarioDeUsoLaboratorio.java
 * Copyright (c) 2002, by Jorge Henrique C Fernandes
 **/
public class CenarioDeUsoLaboratorio {
  public static void main(String[] args) {
    Laboratorio lab1 = 
        new Laboratorio("Centro de Patologia");
    TipoExame te1 =
       lab1.criaTipoExame("Parasitologico Fezes", 5);
    TipoExame te2 = 
       lab1.criaTipoExame("Sumario Urina", 2);
    TipoExame te6 = 
        lab1.criaTipoExame("Anti-HIV", 6);

    Exame ex1 = 
       lab1.realizaExame("Anti-HIV", "Beltrano");
    Exame ex2 = 
       lab1.realizaExame("Sumario Urina", "Beltrano");
    Exame ex3 = 
       lab1.realizaExame("Parasitologico Fezes", "Al Cano");
    Exame ex4 = 
	   lab1.realizaExame("Parasitologico Fezes", "Ben Zeno");

    System.out.println("O valor atual em caixa eh "+lab1.caixa);
  }
}
