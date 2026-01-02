/**
 * Laboratorio.java
 * Copyright (c) 2002, by Jorge Henrique C Fernandes
 **/
public class Laboratorio {
  String nome;
  TipoExame[] tiposDeExames;
  int qtdTiposExames = 0;
  Exame[] exames;
  int qtdExamesRealizados = 0;
  int caixa;
  Laboratorio(String nome) {
    tiposDeExames = new TipoExame[5];
    exames = new Exame[100];
    caixa = 0;
  }
  TipoExame criaTipoExame(String nome, int preco) {
    TipoExame tipoExame = new TipoExame(nome, preco);
    tiposDeExames[qtdTiposExames] = tipoExame;
    qtdTiposExames = qtdTiposExames + 1;
    return tipoExame;
  }
  Exame realizaExame(String nomeTipoExame, 
                                     String nomeCliente) {
    TipoExame tipoExame = buscaTipoExame(nomeTipoExame);
    if (tipoExame != null) {
      // exame existe
      Exame exame = new Exame(tipoExame, nomeCliente);
      exames[qtdExamesRealizados] = exame;
      qtdExamesRealizados = qtdExamesRealizados + 1;
      caixa = caixa + tipoExame.preco;
      return exame;
    } else {
      System.out.println("Tipo Exame Inexistente" 
          +nomeTipoExame+"]!");
      return null;
    } 
  }
  TipoExame buscaTipoExame(String nomeTipoExame) {
    for (int i = 0; i < qtdTiposExames; i++) {
      TipoExame tipo = tiposDeExames[i];
      if (tipo.nome.equals(nomeTipoExame)) {
        return tipo;
      }
    }
    return null;
  }
}

