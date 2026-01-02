import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Formulario extends JFrame {
  Container janela;
  JPanel panel, botoes;
  JTextField nome, apelido;
  JScrollBar idade;
  JComboBox cargo;
  JButton aceitar, limpar;
  JLabel anos;
  String[] lista = { "Diretor", "Gerente", "Técnico", "Administrador" };

  public Formulario() {
    super("Controles");
    janela = this.getContentPane();
    janela.setLayout(new BorderLayout(5, 20));
    janela.add(new JLabel("Dados Pessoais", JLabel.CENTER), BorderLayout.NORTH);
    panel = new JPanel();
    panel.setLayout(new GridLayout(0, 2, 10, 30));
    JLabel etiqueta = new JLabel("Nome:", JLabel.RIGHT);
    panel.add(etiqueta);
    nome = new JTextField();
    panel.add(nome);
    etiqueta = new JLabel("Apelido:", JLabel.RIGHT);
    panel.add(etiqueta);
    apelido = new JTextField();
    panel.add(apelido);
    anos = new JLabel("Idade: 0", JLabel.RIGHT);
    panel.add(anos);
    idade = new JScrollBar(Scrollbar.HORIZONTAL, 0, 0, 0, 120);
    idade.addAdjustmentListener(new OyenteBarra()); /* Scroll de 0 a 120*/
    panel.add(idade);
    etiqueta = new JLabel("Cargo:", JLabel.RIGHT);
    panel.add(etiqueta);
    String[] lista = { "Diretor", "Gerente", "Técnico", "Administrador" };
    cargo = new JComboBox();
    for(int i = 0; i < lista.length; i++) cargo.addItem(lista[i]);
    panel.add(cargo);
    janela.add(panel, BorderLayout.CENTER);
    botoes = new JPanel();
    aceitar = new JButton("Enviar");
    aceitar.addActionListener(new OyenteBoton());
    botoes.add(aceitar);
    limpar = new JButton("Limpar");
    limpar.addActionListener(new OyenteBoton());
    botoes.add(limpar);
    janela.add(botoes, BorderLayout.SOUTH);
    setSize(300, 300);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public static void main(String args[]) {
    Formulario janela = new Formulario();
  }

  class OyenteBoton implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == aceitar) {
        System.out.println("Dados ...");
        System.out.println("Nome.....: " + nome.getText());
        System.out.println("Apelido..: " + apelido.getText());
        System.out.println("Idade....: " + idade.getValue());
        System.out.println("Professao: " + cargo.getSelectedItem());
        System.exit(0);
      }
      else if(e.getSource() == limpar) {
        Object[] textOpcao = { "Sim" , "Não" };
        int opcao = JOptionPane.showOptionDialog(null,
        "Voce realmente deseja limpar ?", "Confirmação - (Alex) ",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, textOpcao,
        textOpcao[0]);
        if(opcao == JOptionPane.YES_OPTION) {
          nome.setText("");
          apelido.setText("");
          idade.setValue(0);
          anos.setText("Idade: 0");
          cargo.setSelectedIndex(0);
        }
      }
    }
  }

  class OyenteBarra implements AdjustmentListener {
    public void adjustmentValueChanged(AdjustmentEvent e) {
      int valor = idade.getValue();
      anos.setText("Idade: " + valor);
    }
  }
}
