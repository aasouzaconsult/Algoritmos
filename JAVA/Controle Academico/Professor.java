public class Professor {
  String nome; // nome do professor
  Turma[] turmas;  // Turmas pelas quais
  int qtdTurmas; // o professor é responsável
  // cria um professor
  Professor(String nomeProfessor) {
    nome = nomeProfessor;
    turmas = new Turma[3];
    qtdTurmas = 0;
  }
  // inclui uma nova turma para o professor
  Turma incluiTurma(Turma novaTurma) {
    if (qtdTurmas < 3) {
      turmas[qtdTurmas] = novaTurma;
      qtdTurmas = qtdTurmas + 1;
      return novaTurma;
    }
    return null;
  }
}

