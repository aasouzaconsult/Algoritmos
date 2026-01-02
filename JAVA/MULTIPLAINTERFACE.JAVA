import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MultiplaInterface extends JFrame{
  JDesktopPane desktop;
  int quantJanelas = 0;
    
  public MultiplaInterface(){
    super("Exemplo de aplicativo MDI");
    
    setLocation(190,235);
    JMenuBar barra = new JMenuBar();
    JMenu arquivo = new JMenu("Arquivo");
    JMenuItem novo = new JMenuItem("Abrir Nova Imagem");
    arquivo.add(novo);
    barra.add(arquivo);
    setJMenuBar(barra);
    
    final JFileChooser abrir = new JFileChooser();
    
    desktop = new JDesktopPane();
    setContentPane(desktop);
    
    novo.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          abrir.setFileSelectionMode(JFileChooser.FILES_ONLY);
          ExampleFileFilter filtro = new ExampleFileFilter();
          filtro.addExtension("jpg");
          filtro.addExtension("gif");
          filtro.setDescription("Imagens JPG & GIF");
          abrir.setFileFilter(filtro);
          
          int res = abrir.showOpenDialog(desktop);
          
          if(res == JFileChooser.APPROVE_OPTION){
            JInternalFrame janela = new JInternalFrame("Nova Imagem", true, true, true, true);
          
            Container telaInterna = janela.getContentPane();
            telaInterna.setLayout(new BorderLayout());
            
            ImageIcon imagem = new ImageIcon(abrir.getSelectedFile().getPath());
            JLabel rotulo = new JLabel(imagem);
            
            quantJanelas++;
            janela.setTitle(abrir.getSelectedFile().getPath());
            
            telaInterna.add(rotulo, BorderLayout.CENTER);
          
            janela.setSize(300, 200);
            janela.setLocation(20 * quantJanelas, 20 * quantJanelas);
            janela.setVisible(true);
            desktop.add(janela);
            
            try{
              janela.setSelected(true);
            } 
            catch(java.beans.PropertyVetoException excp){
              // O corpo do bloco catch pode ser deixado vazio	
            }
          }	
        }	
      }	
    );
    
    setSize(400, 300);
    setVisible(true); 
  }
  
  public static void main(String args[]){
    MultiplaInterface app = new MultiplaInterface();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}