public class Turma {
  Disciplina disciplina; // disciplina referente
  String periodo; // período de oferta
  Professor professor; // professor responsavel
  Aluno alunos[]; // alunos inscritos 
  int qtdAlunos;
  // cria uma turma em um período
  Turma(Disciplina disciplina, String periodo) {
    this.disciplina = disciplina;
    this.periodo = periodo;
    alunos = new Aluno[30];
    qtdAlunos = 0;
  }
  // aloca um professor `a turma
  void alocaProfessor(Professor umProfessor) {
    professor = umProfessor;
    professor.incluiTurma(this);
  }
  // inscreve um aluno na turma
  boolean inscreveAluno(Aluno umAluno) {
    if (qtdAlunos < 30) {
      alunos[qtdAlunos] = umAluno;
      qtdAlunos = qtdAlunos + 1;
      return true;
    }
    return false;
  }
}
