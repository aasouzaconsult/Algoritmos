import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Formulario extends JFrame {
  Container ventana;
  JPanel panel, botones;
  JTextField nombre, apellidos;
  JScrollBar edad;
  JComboBox puesto;
  JButton aceptar, reiniciar;
  JLabel anios;
  String[] lista = { "Director", "Gestor", "Técnico", "Administrador" };

  public Formulario() {
    super("Controles");
    ventana = this.getContentPane();
    ventana.setLayout(new BorderLayout(5, 20));
    // titulo = new JPanel();
    // JLabel tit = new JLabel("Datos personales", JLabel.CENTER);
    // titulo.add(tit);
    ventana.add(new JLabel("Datos personales", JLabel.CENTER), BorderLayout.NORTH);
    panel = new JPanel();
    panel.setLayout(new GridLayout(0, 2, 10, 30));
    JLabel etiqueta = new JLabel("Nombre:", JLabel.RIGHT);
    panel.add(etiqueta);
    nombre = new JTextField();
    panel.add(nombre);
    etiqueta = new JLabel("Apellidos:", JLabel.RIGHT);
    panel.add(etiqueta);
    apellidos = new JTextField();
    panel.add(apellidos);
    anios = new JLabel("Edad: 0", JLabel.RIGHT);
    panel.add(anios);
    edad = new JScrollBar(Scrollbar.HORIZONTAL, 0, 0, 0, 120);
    edad.addAdjustmentListener(new OyenteBarra()); /* scroll de 0 a 120*/
    panel.add(edad);
    etiqueta = new JLabel("Puesto:", JLabel.RIGHT);
    panel.add(etiqueta);
    String[] lista = { "Director", "Gestor", "Técnico", "Administrador" };
    puesto = new JComboBox();
    for(int i = 0; i < lista.length; i++) puesto.addItem(lista[i]);
    panel.add(puesto);
    ventana.add(panel, BorderLayout.CENTER);
    botones = new JPanel();
    aceptar = new JButton("Enviar");
    aceptar.addActionListener(new OyenteBoton());
    botones.add(aceptar);
    reiniciar = new JButton("Volver a empezar");
    reiniciar.addActionListener(new OyenteBoton());
    botones.add(reiniciar);
    ventana.add(botones, BorderLayout.SOUTH);
    setSize(300, 300);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public static void main(String args[]) {
    Formulario ventana = new Formulario();
  }

  class OyenteBoton implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == aceptar) {
        System.out.println("Datos introducidos...");
        System.out.println("Nombre: " + nombre.getText());
        System.out.println("Apellidos: " + apellidos.getText());
        System.out.println("Edad: " + edad.getValue());
        System.out.println("Profesión:" + puesto.getSelectedItem());
        System.exit(0);
      }
      else if(e.getSource() == reiniciar) {
        Object[] textoOpciones = { "Si, adelante", "Mejor no" };
        int opcion = JOptionPane.showOptionDialog(null,
        "¿Estás seguro de querer borrar los datos?", "Confirmación de borrado",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, textoOpciones,
        textoOpciones[0]);
        if(opcion == JOptionPane.YES_OPTION) {
          nombre.setText("");
          apellidos.setText("");
          edad.setValue(0);
          anios.setText("Edad: 0");
          puesto.setSelectedIndex(0);
        }
      }
    }
  }

  class OyenteBarra implements AdjustmentListener {
    public void adjustmentValueChanged(AdjustmentEvent e) {
      int valor = edad.getValue();
      anios.setText("Edad: " + valor);
    }
  }
}
