import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.text.DecimalFormat; 

public class BarraStatus extends JFrame{
  JLabel horas, data;
  String diaSemana[] = {"domingo", "segunda-feira",
                        "terça-feira", "quarta-feira",
                        "quinta-feira", "sexta-feira",
                        "sábado"};
                        
  String meses[] = {"janeiro", "fevereiro", "mar�o",
                    "abril", "maio", "junho", "julho",
                    "agosto", "setembro", "outubro",
                    "novembro", "dezembro"}; 
  
  public BarraStatus(){
    super("Criando uma barra de status");
 
    Container tela = getContentPane();
    
    BorderLayout layout = new BorderLayout();
    tela.setLayout(layout);
    
    Border border = BorderFactory.createLoweredBevelBorder();
    
    horas = new JLabel("horas", JLabel.CENTER);
    horas.setPreferredSize(new Dimension(75, 20));
    horas.setBorder(border);
    
    data = new JLabel("data", JLabel.CENTER);
    data.setPreferredSize(new Dimension(215, 20));
    data.setBorder(border);
    
    JPanel inferior = new JPanel();
    inferior.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 0));
    inferior.add(horas);
    inferior.add(data);
    
    tela.add(inferior, BorderLayout.SOUTH);
    
    ActionListener tarefa = new ActionListener(){
      public void actionPerformed(ActionEvent e){
        horasData();
      }
    };

    javax.swing.Timer timer = new javax.swing.Timer(1000, tarefa);
    timer.start();
    
    setLocation(280,235);
    setSize(410,200);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    BarraStatus app = new BarraStatus();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private void horasData(){
    Calendar agora = Calendar.getInstance();
    int ho = agora.get(Calendar.HOUR_OF_DAY);
    int mi = agora.get(Calendar.MINUTE);
    int se = agora.get(Calendar.SECOND);
    
    int ds = agora.get(Calendar.DAY_OF_WEEK);
    int dia = agora.get(Calendar.DAY_OF_MONTH);
    int mes = agora.get(Calendar.MONTH);
    int ano = agora.get(Calendar.YEAR);
    
    horas.setText(formatar(ho % 12) + ":" + formatar(mi) + ":" + formatar(se) + "");
    
    data.setText(diaSemana[ds - 1] + ", " + formatar(dia) + " de " + meses[mes] + " de " + ano + "");
  }
  
  private String formatar(int num){
    DecimalFormat df = new DecimalFormat("00");
    
    return df.format(num);
  }
}