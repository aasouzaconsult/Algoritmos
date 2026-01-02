/**----------------------------------------------------------------------*/
/** Mostra calendário completo do ano a partir do ano 1 da era Cristã.   */
/** Embora o algoritmo possa calcular qualquer data anterior à era       */
/** Cristã, o resultado seria inútil porque os calendários da época      */
/** continham muitos erros e inconsistências.                            */
/** Devido à reforma feita pelo Papa Gregorio XIII, ao dia 4/10/1582     */
/** seguiu-se o dia 15/10/1582 para compensar o erro cometido no cálculo */
/** da duração do ano pelo calendário Juliano. Assim, os dias 05/10/1582 */
/** a 14/10/158 não existem  no calendario; essa anomalia, contemplada   */
/** pela classe GregorianCalendar, pode ser vista no calendário de 1582. */
/** Como os browsers não suportam o SWING, este programa é um aplicativo;*/
/** Veja CALENDARIO3, um applet com AWT, suportado pelos browsers.       */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Calendario2 extends JFrame implements ActionListener {
  JPanel principal = new JPanel(new BorderLayout());
  JPanel anual = new JPanel(new GridLayout(4,3,0,0));
  JTextField texto = new JTextField(4); 
  Toolkit toolkit;
  Mensal[] mensal = new Mensal[12];    // Um objeto para cada mês do ano
  Mouse mouse = new Mouse();           // Trata eventos de mouse
  int largura = 224, altura = 128;     // Dimensão do painel dos meses
  int antigo, corrente;
  static final String[] nomeMes = {"Janeiro","Fevereiro","Março",
     "Abril","Maio","Junho","Julho","Agosto",
     "Setembro","Outubro","Novembro","Dezembro"};
  static final String nomeSemana = "  D  S  T  Q  Q  S  S ";  
  
  public Calendario2() {
    super("Calendário");
    toolkit = Toolkit.getDefaultToolkit();
    
    GregorianCalendar data = new GregorianCalendar();
    antigo = corrente = data.get(Calendar.YEAR);
    texto.setText(String.valueOf(corrente)); 
    texto.setBackground(Color.white);
    texto.addActionListener(this);

    JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
    adicionaBotao(botoes,"Corrente");
    adicionaBotao(botoes,"-100");          
    adicionaBotao(botoes,"-10");
    adicionaBotao(botoes,"-1");
    botoes.add(texto);
    adicionaBotao(botoes,"+1");   
    adicionaBotao(botoes,"+10");
    adicionaBotao(botoes,"+100");
    adicionaBotao(botoes,"Corrente");
    botoes.setBackground(Color.orange);

    principal.setLayout(new BorderLayout());
    principal.setBackground(Color.gray);
    principal.add(botoes,BorderLayout.NORTH);
    principal.add(anual,BorderLayout.CENTER);
    setContentPane(principal);

    for (int mes = Calendar.JANUARY; mes <= Calendar.DECEMBER; ++mes) {
      mensal[mes] = new Mensal(mes);       // Um para cada mês
      anual.add(mensal[mes]);              // Reserva espaço no painel
    }


    int x = 0, y = 0;                      
	  int largura = 683;                      
    int altura  = 582;                      
    Dimension sz = toolkit.getScreenSize(); 
    if (sz.width > largura) x = (sz.width-largura)/2;
    if (sz.height > altura) y = (sz.height-altura)/2;
    setResizable(false);                    
    setBounds(x,y,largura,altura);               
    setVisible(true);                      
    constroiAno();
  }

  public void adicionaBotao(JPanel painel, String rotulo) {
    JButton botao = new JButton(rotulo);
    painel.add(botao);
    botao.addActionListener(this);
    botao.addMouseListener(mouse);
  }

  public void constroiAno() {
    for (int mes = Calendar.JANUARY; mes <= Calendar.DECEMBER; ++mes)
      mensal[mes].repaint();               // Preenche o mês com os dias
    texto.selectAll();
    texto.requestFocus();
  }
  
  public void actionPerformed(ActionEvent e) {
    int novo;
    try {novo = Integer.parseInt(texto.getText().trim());} 
    catch (NumberFormatException ex) {
      toolkit.beep();
      return;
    }

    if (e.getSource() instanceof JButton) {
      String label = e.getActionCommand();
      label = label.replace('+','0');
      if (label.equals("Corrente")) novo = corrente;
      else novo = antigo + Integer.parseInt(label); 
    }

    if (novo > 0) antigo = novo;
    else toolkit.beep();
    texto.setText(String.valueOf(antigo));
    constroiAno();
  }

  public static void main(String[] args) {
    Calendario2 app = new Calendario2();
	  app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
/*-----------------------------------------------------------------------*/
/* Classe interna que trata eventos de mouse para trocar cor dos botões. */
/*-----------------------------------------------------------------------*/
  class Mouse extends MouseAdapter {

    public void mouseEntered(MouseEvent e) {
      ((JButton) e.getSource()).setBackground(Color.lightGray.brighter());
    }

   public void mouseExited(MouseEvent e) {
      ((JButton) e.getSource()).setBackground(Color.lightGray);
    }
  }
/*-----------------------------------------------------------------------*/
/* Classe interna que desenha um painel para cada mês do ano.            */
/* O mês de cada objeto é estabelecido na sua instanciação.              */
/* O ano é comum a todos: variável "antigo" da classe principal.         */
/* Tamanho do painel é estabelecido na classe principal.                 */
/* Usa primitivos no desenho para permitir maior precisão no desenho.    */
/*-----------------------------------------------------------------------*/
  class Mensal extends JPanel {
    int mes; 

    public  Mensal(int mes) {
      this.mes = mes; 
    }

    public void paintComponent(Graphics g) {      
      super.paintComponent(g);
      GregorianCalendar data = new GregorianCalendar();
      int mesHoje = data.get(Calendar.MONTH);
      int diaHoje = data.get(Calendar.DAY_OF_MONTH);
      int anoHoje = data.get(Calendar.YEAR);

      Font fonte1 = new Font("Courier",Font.BOLD,16);
      Font fonte2 = new Font("Courier",Font.PLAIN,16); 
      FontMetrics fm1 = getFontMetrics(fonte1);

      setBackground(Color.gray);
      g.setColor(Color.green);
      g.drawRect(0,0,largura,altura);
      int y = fm1.getHeight();
      g.drawLine(0,y+1,largura+1,y+1);

      String titulo = nomeMes[mes] + " de " + antigo; 
      g.setFont(fonte1);
      if (antigo == anoHoje && mes == mesHoje)
        g.setColor(Color.cyan);
      else g.setColor(Color.yellow);
      int x = (largura - fm1.stringWidth(titulo))/2;
      y = fm1.getAscent();
      g.drawString(titulo,x,y);

      g.setFont(fonte1);
      g.setColor(Color.orange);
      x = (largura - fm1.stringWidth(nomeSemana))/2;
      g.drawString(nomeSemana,x,y+=20);

      g.setFont(fonte2);
      g.setColor(Color.white);
   
      data.set(antigo,mes,1);                    // Início do mês desejado 
      int semana = data.get(Calendar.DAY_OF_WEEK);
      int digito = fm1.stringWidth("0");         // Espaço usado por dígito

      int dia = 1;                               // Primeiro dia do mês
      int linha = 7 * 3 * digito;                // Tamanho da linha 
      int xi = x + 3 * digito * (semana - 1);    // Começo primeira linha

      do {                                       // Percorre dias do mês
        y += 15;                                 // Abaixa coordenada y
        do {                                     // Sete dias numa linha
          xi += dia < 10 ? digito : 0;           // Um ou nenhum espaço
          if (antigo == anoHoje && mes == mesHoje && dia == diaHoje) 
            g.setColor(Color.cyan);              // Hoje ou 
          else g.setColor(Color.white);          // outro dia
          g.drawString(" " + dia,xi,y);          // Desenha dia do mês
          xi += fm1.stringWidth(" " + dia);      // Acerta coordenada x
          data.add(Calendar.DAY_OF_MONTH,1);     // Calcula dia seguinte
          dia = data.get(Calendar.DAY_OF_MONTH); // Obtém dia seguinte
        } while (xi < linha && dia != 1);        // Até acabar linha ou mês
        xi = x;                                  // Volta a início da linha
      } while (dia != 1);                        // Até dar a volta no mês
    }

  }
/*-----------------------------------------------------------------------*/
/* Fim da classe interna.                                                */
/*-----------------------------------------------------------------------*/
}