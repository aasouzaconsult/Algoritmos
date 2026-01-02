/**----------------------------------------------------------------------*/
/** Classe para datas do calendário gregoriano (inicio em 15/10/1582).   */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
public class Data {  
  private int dia = 1, mes = 1, ano = 1583;   // Primeira data válida
  private int[] tabela = {31,28,31,30,31,30,31,31,30,31,30,31};

  // Construtor com os três parâmetros
  public Data(int d, int m, int a) {
    setData(d,m,a);
  }
  
  // Construtor com outra data
  public Data(Data d) {
    setData(d);
  }
  // Retorna o dia
  public int getDia() {
    return dia; 
  }
  
  // Retorna o mês
  public int getMes() {
    return mes; 
  }

  // Retorna o ano
  public int getAno() {
    return ano; 
  }

  // Altera o dia
  public void setDia(int d) {
    if (d >= 1 && d <= tabela[mes-1]) dia = d;
  }
  
  // Altera o mês
  public void setMes(int m) {
    if (m >=1 && m <= 12) mes = m; 
  }

  // Altera o ano
  public void setAno(int a) {
    if (a > 1582) {
      ano = a; 
      if (bissexto(ano)) tabela[1] = 29;
      else tabela[1] = 28; 
    }
  }

  // Altera a data inteira
  public void setData(int d, int m, int a) {
    setAno(a);  // Precisa ser o primeiro
    setMes(m);  // Precisa ser o segundo
    setDia(d);  // Precisa ser o terceiro   
  }

  // Altera a data inteira
  public void setData(Data d) {
    setData(d.dia,d.mes,d.ano);   
  }

  // Altera data para o dia seguinte
  public void diaSeguinte() {
    dia++;
    if (dia > tabela[mes-1]) {
      dia = 1;
      mesSeguinte();
    }
  }

  // Altera data para o mês seguinte
  public void mesSeguinte() {
    mes++;
    if (mes > 12) {
      mes = 1;
      anoSeguinte();
    }
    if (dia > tabela[mes-1]) dia = tabela[mes-1];
  }

  // Altera data para o ano seguinte
  public void anoSeguinte() {
    int a = ano + 1;
    setAno(a);
  }

  // Altera data para o dia anterior
  public void diaAnterior() {
    dia--;
    if (dia == 0) {
      mesAnterior();
      dia = tabela[mes-1];
    }
  }
  
  // Altera data para o mês anterior
  public void mesAnterior() {
    mes--;
    if (mes == 0) {
      anoAnterior();
      mes = 12;
    }
  }

  // Altera data para o ano anterior
  public void anoAnterior() {
    int a = ano - 1;
    setAno(a);
  }

  // Verifica se duas datas são iguais
  public boolean equals(Data d) {
    return dia == d.mes && mes == d.mes && ano == d.ano;
  }

  // Verifica se data é anterior ao parâmetro
  public boolean anterior(Data d) {
    return ano < d.ano || 
           ano == d.ano && mes < d.mes ||
           ano == d.ano && mes == d.mes && dia < d.dia;
  }

  // Verifica se data é posterior ao parâmetro
  public boolean posterior(Data d) {
    return d.anterior(this);
  }
 
  // Verifica se o ano da data é bissexto
  public static boolean bissexto(int a) {
    return a % 4 == 0 && a % 100 != 0 || a % 400 == 0; 
  }

  public String toString() {
    return dia + "/" + mes + "/" + ano;
  }

}
