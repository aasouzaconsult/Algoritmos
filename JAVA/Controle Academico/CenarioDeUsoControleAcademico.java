//DIMAP - UFRN - Engenharia de Software
//Professor Jorge Henrique Cabral Fernandes
//(jorge@dimap.ufrn.br)

public class CenarioDeUsoControleAcademico {
  public static void main (String args[]) {
    // cria alguns departamentos
    Departamento dimap = 
      new Departamento("Informatica");
    Departamento dee = 
      new Departamento("Eng.Eletrica");
    // cria alguns cursos
    Curso bach = new Curso("Bacharelado",100);
    Curso eng = new Curso("Engenharia",100);
    // cria alguns professores
    Professor jose    = new Professor("Jose");
    Professor ju    = new Professor("Juca");
    Professor andre = new Professor("Andre");
    Professor maria = new Professor("Maria");
    // lotando professores nos seus departamentos
    dimap.lotaProfessor(jose);
    dimap.lotaProfessor(ju);
    dee.lotaProfessor(andre);
    dee.lotaProfessor(maria);
    /* Criando algumas disciplinas */
    Disciplina ling =
      dimap.criaDisciplina("Ling. Programacao", 4);
    Disciplina logica =
      dimap.criaDisciplina("Logica", 6);
    Disciplina algs =
      dimap.criaDisciplina("algs", 6);
    Disciplina sinais =
      dee.criaDisciplina("Analise Sinais", 4);
    Disciplina circuitos =
      dee.criaDisciplina("Circuitos", 6);
    /* Cria algumas turmas */
    Turma ling_2000_1 = ling.criaTurma("2000/1");
    Turma logica_2000_1 =
      logica.criaTurma("2000/1");
    Turma algs_1999_2 = algs.criaTurma("1999/2");
    Turma sinais_2000_2 = sinais.criaTurma("2000/2");
    /* Alocando professores a turmas */
    ling_2000_1.alocaProfessor(jose);
    logica_2000_1.alocaProfessor(ju);
    algs_1999_2.alocaProfessor(jose);
    sinais_2000_2.alocaProfessor(ju);
    /* Criando alguns alunos */
    Aluno ivo    = eng.criaAluno("Ivo");
    Aluno paulo  = bach.criaAluno("Paulo");
    Aluno luiza   = eng.criaAluno("Luiza");
    Aluno chico  = eng.criaAluno("Francisco");
    Aluno paula  = bach.criaAluno("Paula");
    /* Inscrevendo alunos em turmas */
    sinais_2000_2.inscreveAluno(paula);
    sinais_2000_2.inscreveAluno(luiza);
    logica_2000_1.inscreveAluno(chico);
    logica_2000_1.inscreveAluno(luiza);
    logica_2000_1.inscreveAluno(ivo);
    logica_2000_1.inscreveAluno(chico);
    ling_2000_1.inscreveAluno(ivo);
    algs_1999_2.inscreveAluno(paula);
  }
}
