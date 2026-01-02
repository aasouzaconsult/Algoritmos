/**
 * CenarioDeUsoLaboratorioComErros.java
 * Copyright (c) 2002, by Jorge Henrique C Fernandes
 **/
public class CenarioDeUsoLaboratorioComErros {
  public static void main(String[] args) {
    Laboratorio lab1 = 
        new Laboratorio("Centro de Patologia");
    Laboratorio lab2 = 
        new Laboratorio("Hemolab");
    TipoExame te1 =
       lab1.
         criaTipoExame("Parasitologico Fezes", 5);
    TipoExame te2 = 
       lab1.
         criaTipoExame("Sumario Urina", 2);
    TipoExame te3 =      
        lab2.criaTipoExame("VSH", 10);
    TipoExame te4 = 
        lab2.criaTipoExame("TGP", 8);
    TipoExame te5 = 
        lab2.criaTipoExame("TGO", 7);
    TipoExame te6 = 
        lab1.criaTipoExame("Anti-HIV", 6);

    Exame ex1 = 
       lab2.realizaExame("VSH", "Fulano");
    Exame ex2 = 
       lab1.realizaExame("VSH", "Beltrano");
    Exame ex3 = 
       lab1.realizaExame("Anti-HIV", "Beltrano");
    Exame ex4 = 
       lab1. realizaExame("Sumario Urina", 
                                      "Beltrano");
    Exame ex5 = 
       lab2.realizaExame("Ácido Úrico", 
                                     "Sicrano");
    Exame ex6 = 
       lab2.realizaExame("Parasitologico Fezes", 
                                     "Al Cano");
    Exame ex7 =
       lab1.realizaExame("Parasitologico Fezes", 
                                    "Ben Zeno");
    Exame ex8 = 
       lab2.realizaExame("TGP", "Aceti Leno");
    Exame ex9 = 
       lab2.realizaExame("TGP", "Habanero");
  }
}
