public class Departamento {
  String nome; // nome do departamento
  Professor professores[]; // professores do depto
  int qtdProfessores;
  Disciplina disciplinas[]; // Disciplinas do depto
  int qtdDisciplinas;
  // cria um departamento
  Departamento (String umNome) {
    nome = umNome;
    professores = new Professor[10];
    qtdProfessores = 0;
    disciplinas = new Disciplina[20];
    qtdDisciplinas = 0;
  }
  // inclui um professor no departamento
  Professor lotaProfessor (Professor umProfessor) {
    if (qtdProfessores < 10) {
      professores[qtdProfessores] = umProfessor;
      qtdProfessores = qtdProfessores + 1;
      return umProfessor;
    }
    return null;
  }
  // inclui uma disciplina no departamento
  Disciplina criaDisciplina(String nome,int creditos) {
    if (qtdDisciplinas < 20) {
      Disciplina novaDisciplina =
        new Disciplina(nome, creditos);
      disciplinas[qtdDisciplinas] = novaDisciplina;
      qtdDisciplinas = qtdDisciplinas + 1;
      return novaDisciplina;
    }
    return null;
  }
}

