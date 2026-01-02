public class Disciplina {
  String	nome;  // nome da disciplina
  Turma[] turmas; // turmas ofertadas
  int qtdTurmas;
  int creditos; // qtd de créditos
  // cria disciplina
  Disciplina (String nomeD, int creditosD) {
    nome = nomeD;
    creditos = creditosD;
    turmas = new Turma[20];
    qtdTurmas = 0;
  }
  // cria oferta de turma para disciplina
  Turma criaTurma(String periodo) {
    if (qtdTurmas < 20) {
      Turma umaTurma = new Turma(this,periodo);
      turmas[qtdTurmas] = umaTurma;
      qtdTurmas = qtdTurmas + 1;
      return umaTurma;
    }
    return null;
  }
}

