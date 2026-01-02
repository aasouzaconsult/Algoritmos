public class Curso {
  String nome;  // nome do Curso
  Aluno	alunos[]; // alunos d curso
  int  qtdAlunos; // qtd alunos matriculados
  // cria um curso
  Curso(String nome, int creditos) {
    this.nome = nome;
    this.alunos = new Aluno[200];
    this.qtdAlunos = 0;
  }
  // cria um aluno e o matricula no curso
  Aluno criaAluno(String nome) {
    if (qtdAlunos < 200) {
      Aluno novoAluno = new Aluno(nome, this);
      alunos[qtdAlunos] = novoAluno;
      qtdAlunos = qtdAlunos + 1;
      return novoAluno;
    }
    return null;
  }
}

