import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CadastroDeEstados extends JInternalFrame {
	private Estado estado;
	private ImageIcon icone;
	private Border bordaMargem, bordaNorte, bordaSul; 
	private Container container;
	private GridBagLayout gbLayout;
	private GridBagConstraints gbConstraints;
	private JLabel lblCodigo, lblNome;
	private JTextField txfCodigo, txfNome;
	private JButton btnBuscar, btnNovo, btnAlterar, btnSalvar, btnExcluir, btnSair;
	private JPanel panelNorte, panelSul ;
	
	CadastroDeEstados(){
		super("Cadastro de Estados", false, false, false, true);	
		
        //Adiciona o icone a  janela
		icone = new ImageIcon("SuperJava.gif");
		icone.setImage(icone.getImage().getScaledInstance(30, 18, 500));
		setFrameIcon(icone);
		
		container = getContentPane();
		container.setLayout(new BorderLayout(10, 10));
		
		gbLayout = new GridBagLayout();
		
		//Instancia as limitacoes do gridbag
		gbConstraints = new GridBagConstraints();
		
		//Painel´s
		panelNorte = new JPanel();
		panelSul     = new JPanel();
		panelNorte.setLayout(gbLayout);
		panelSul.setLayout(new GridLayout(1, 5));
		
		//Instancia os JLabels
		lblCodigo = new JLabel(" Codigo: ");
		lblNome  = new JLabel(" Nome: ");
		
		//Instancia os JTextFields
		txfNome  = new JTextField(25);
		txfCodigo = new JTextField(15);
			
		//Instancia os JButtons
		btnBuscar   = new JButton("Buscar");
		btnNovo     = new JButton("Novo");
		btnAlterar  = new JButton("Alterar");
		btnSalvar   = new JButton("Salvar");
		btnExcluir   = new JButton("Excluir");
		btnSair       = new JButton("Sair");		
		
		ActionEventHandler tratador = new ActionEventHandler();
		
		//Adiciona um ActionListener aos botoes
		btnBuscar.addActionListener(tratador);
		btnNovo.addActionListener(tratador);
		btnAlterar.addActionListener(tratador);
		btnSalvar.addActionListener(tratador);
		btnExcluir.addActionListener(tratador);
		btnSair.addActionListener(tratador);
		
        //Adiciona todos os componentes ao painel norte
		adicionarComponente(lblNome, 0, 0, 1, 1, "EAST");
		adicionarComponente(txfNome, 0, 1, 3, 1, "WEST");
		adicionarComponente(lblCodigo, 1, 0, 1, 1, "EAST");
		adicionarComponente(txfCodigo, 1, 1, 1, 1, "WEST");
		adicionarComponente(btnBuscar,1, 3, 1, 1, "EAST");	
				
		//Adiciona todos os componentes ao painel sul
		panelSul.add(btnNovo);
		panelSul.add(btnAlterar);
		panelSul.add(btnSalvar);
		panelSul.add(btnExcluir);		
		panelSul.add(btnSair);
		
		//Bordas
		bordaMargem = BorderFactory.createEmptyBorder(4,4,-1,4);
		bordaNorte  = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		bordaSul    = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		panelNorte.setBorder(bordaMargem);	
		panelNorte.setBorder(BorderFactory.createCompoundBorder(bordaMargem, bordaNorte));
		panelSul.setBorder(bordaSul);
		
		container.add(panelNorte, BorderLayout.NORTH);
		container.add(panelSul, BorderLayout.SOUTH);
	    
		setSize(400, 130);
		setVisible(true);
		setOpaque(true);
		setResizable(false);
		
		desabilitarCampos();
		abilitarBotoes(true, true, false, false, false, true);
	}
	
   //Metodo para adicionar componentes no grid
   private void adicionarComponente( Component c, int linha, int coluna, int largura, int altura, String lado ) {
   	
	    if (lado.equals("EAST")) { gbConstraints.anchor = GridBagConstraints.EAST; }
	    else if (lado.equals("WEST")){ gbConstraints.anchor = GridBagConstraints.WEST; }
	    
		gbConstraints.insets = new Insets(5, 0, 0, 0); 
           	    
		//Configura gridx e gridy
		gbConstraints.gridx = coluna;
		gbConstraints.gridy = linha;
			
		//Configura gridwidth e gridheight
		gbConstraints.gridwidth  = largura;
		gbConstraints.gridheight = altura;
 			
		//Configura limitacoes
		gbLayout.setConstraints(c, gbConstraints);
			
		//Adiciona componente
		panelNorte.add(c);
   }
		
   private void limparCampos(){
	  txfNome.setText("");
	  txfCodigo.setText("");   		
   }
   
   private void abilitarCampos(){
	  txfNome.setEditable(true);
	  txfCodigo.setEditable(true);	
   }
   
   private void desabilitarCampos(){
   	  txfNome.setEditable(false);
   	  txfCodigo.setEditable(false);
   }
   
   private void abilitarBotoes(boolean buscar, boolean novo, boolean alterar, boolean salvar, boolean excluir, boolean sair){
	  btnBuscar.setEnabled(buscar); 
	  btnNovo.setEnabled(novo);
	  btnAlterar.setEnabled(alterar);
	  btnSalvar.setEnabled(salvar);
	  btnExcluir.setEnabled(excluir);
	  btnSair.setEnabled(sair);    	
   }
   
          		
   private class ActionEventHandler implements ActionListener{
		  public void actionPerformed(ActionEvent evento){
			
			  //Fecha a janela
			  if (evento.getSource() == btnSair){
				  dispose();
			  }	
				
			  //Buscar
			  else if (evento.getSource().equals(btnBuscar)){
				  abilitarBotoes(false, false, true, false, false, true);
			  }
		
		
			  //Novo
			  else if (evento.getSource() == btnNovo){
				  limparCampos();
				  abilitarCampos();
				  abilitarBotoes(false, true, false, true, false, false); 			  
			  }	
				
			  //Alterar
			  if (evento.getSource() == btnAlterar){
				  abilitarCampos();
				  abilitarBotoes(false, false, false, true, true, false);                	
			  }	
							  
			  //Salvar
			  if (evento.getSource() == btnSalvar){
				  limparCampos();
				  desabilitarCampos();
				  abilitarBotoes(true, true, false, false, false, true);                	
			  }
				
			  //Excluir 
			  if (evento.getSource() == btnExcluir){
				  limparCampos();
				  desabilitarCampos();				
				  abilitarBotoes(true, true, false, false, false, true);	                
			  }											
		  }
	  }
	

}