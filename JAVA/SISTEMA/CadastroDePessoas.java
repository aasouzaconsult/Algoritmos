/*
 * Created on 03/01/2003
 *
 * Formulário de Cadastro de Pessoas
 */

/**
 * @author 
 *
 * Formulário de Cadastro de Pessoas
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CadastroDePessoas extends JInternalFrame {
	//Pessoa   pessoa;
	private ImageIcon icone;
	private Border bordaMargem, bordaNorte, bordaSul; 
	private Container container;
	private GridBagLayout gbLayout;
	private GridBagConstraints gbConstraints;
	private JLabel lblCodigo, lblNome, lblSexo, lblTipo, lblObs;
	private JTextField txfCodigo, txfNome;
	private JTextArea  txaObs; 
	private JComboBox cbxSexo, cbxTipo;
	private String tipos[]  = {"Fisica","Juridica"};
	private String sexos[] = {"Masculino","Feminino"}; 
	private JButton btnBuscar, btnEndereco, btnNovo, btnAlterar, btnSalvar, btnExcluir, btnSair;
	private JPanel  panelNorte, panelSul;
	
	CadastroDePessoas(){
		super("Cadastro de Pessoas", false, false, false, true);
		
		//Adiciona o icone à janela
		icone = new ImageIcon("SuperJava.gif");
		icone.setImage(icone.getImage().getScaledInstance(30, 18, 500));
		setFrameIcon(icone);
		
		container = getContentPane();
		container.setLayout(new BorderLayout(10, 10));
		
		gbLayout = new GridBagLayout();
		
		//Instancia as limitacões do gridbag
		gbConstraints = new GridBagConstraints();
		
		//Painéis
		panelNorte  = new JPanel();
		panelSul      = new JPanel();
		panelNorte.setLayout(gbLayout);
		panelSul.setLayout(new GridLayout(1, 5));
		
		//Instancia os JLabels
		lblNome  = new JLabel(" Nome: ");
		lblCodigo = new JLabel(" Código: ");
		lblSexo    = new JLabel(" Sexo: ");
		lblTipo    = new JLabel(" Tipo: ");
		lblObs     = new JLabel(" Observacão: "); 
		
		//Instancia os JTextFields
		txfNome  = new JTextField(37);
		txfCodigo = new JTextField(15);
				
		//Instancia a JTextArea
		txaObs = new JTextArea(3, 37);
		Dimension d = new Dimension(10, 5);
		txaObs.setPreferredSize(d);
		txaObs.setMaximumSize(d);
		txaObs.setMinimumSize(d);
		txaObs.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		//Instancia os ComboBoxes
		cbxSexo = new JComboBox(sexos);
		cbxTipo = new JComboBox(tipos);
        
        //Instancia os JButtons
		btnBuscar      = new JButton("Buscar");
		btnEndereco  = new JButton("Cadastro de Endereco"); 
		btnNovo        = new JButton("Novo");
		btnSalvar      = new JButton("Salvar");
		btnAlterar      = new JButton("Alterar");
		btnExcluir     = new JButton("Excluir");
		btnSair          = new JButton("Sair");		
		
		ActionEventHandler tratador = new ActionEventHandler();
		
		//Adiciona um ActionListener aos botões
		btnBuscar.addActionListener(tratador);
		btnEndereco.addActionListener(tratador);
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
		adicionarComponente(lblSexo, 2, 0, 1, 1, "EAST");
		adicionarComponente(cbxSexo, 2, 1, 1, 1, "WEST");
		adicionarComponente(lblTipo, 2, 2, 1, 1, "EAST");
		adicionarComponente(cbxTipo, 2, 3, 1, 1, "WEST");	
		adicionarComponente(lblObs, 3, 0, 1, 1, "EAST");
		adicionarComponente(txaObs, 3, 1, 3, 1, "WEST");
		adicionarComponente(btnEndereco, 4, 3, 1, 1, "EAST");	
		
		//Adiciona os componentes ao painel sul
		panelSul.add(btnNovo);
		panelSul.add(btnAlterar);
		panelSul.add(btnSalvar);
		panelSul.add(btnExcluir);
		panelSul.add(btnSair);
		
        //Bordas
		bordaMargem = BorderFactory.createEmptyBorder(4,4,-1,4);
		bordaNorte     = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		bordaSul         = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		panelNorte.setBorder(bordaMargem);	
		panelNorte.setBorder(BorderFactory.createCompoundBorder(bordaMargem, bordaNorte));
		panelSul.setBorder(bordaSul);		
													
		container.add(panelNorte, BorderLayout.NORTH);
		container.add(panelSul, BorderLayout.SOUTH);
					
		setSize(520, 240);
		setVisible(true);
		setOpaque(true);
		setResizable(false);
		
		desabilitarCampos();
		abilitarBotoes(true, false, true, false, false, false, true);
	}
	
	
   //Método para adicionar componentes no grid
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
 			
		//Configura limitacões
		gbLayout.setConstraints(c, gbConstraints);
			
		//Adiciona componente
		panelNorte.add(c);
   }
   
   private void limparCampos(){
	    txfNome.setText("");
        txfCodigo.setText("");		
		cbxSexo.setSelectedIndex(0);
		cbxTipo.setSelectedIndex(0);
		txaObs.setText("");
   }
   
   private void abilitarCampos(){
	    txfNome.setEditable(true);
   		txfCodigo.setEditable(true);
		cbxSexo.setEnabled(true);
		cbxTipo.setEnabled(true);
		txaObs.setEnabled(true);
		txaObs.setBackground(Color.WHITE);		 	
   }
   
   private void desabilitarCampos(){
	    txfNome.setEditable(false);
   		txfCodigo.setEditable(false);
		cbxSexo.setEnabled(false);
		cbxTipo.setEnabled(false);
		txaObs.setEnabled(false);
		Color c = new Color(204, 204, 204);
	 	txaObs.setBackground(c);	
   }
   
   private void abilitarBotoes(boolean buscar, boolean endereco, boolean novo, boolean alterar, boolean salvar, boolean excluir, boolean sair){
   		btnBuscar.setEnabled(buscar);
   		btnEndereco.setEnabled(endereco);
   		btnNovo.setEnabled(novo);
   		btnAlterar.setEnabled(alterar);
   		btnSalvar.setEnabled(salvar);
   		btnExcluir.setEnabled(excluir);
   		btnSair.setEnabled(sair);    	
   }
   
   private JanelaPrincipal getJP(){
		JanelaPrincipal JP =  ((JanelaPrincipal)getDesktopPane().getParent().getParent().getParent().getParent());  
	 	return JP;	
   }
   
	private class ActionEventHandler implements ActionListener{
			public void actionPerformed(ActionEvent evento){
			    
                //Fecha a janela
				if (evento.getSource().equals(btnSair)){
					dispose();
	     		}	
	     		
                //Abre a janela de cadastro de enderecos
				else if (evento.getSource().equals(btnEndereco)){
					getJP().criaFrame("CadastroDeEndereco", true); 
				}
				
                //Buscar
                else if (evento.getSource().equals(btnBuscar)){
					abilitarBotoes(false, true, false, true, false, false, true);
				}
		
				//Novo
				else if (evento.getSource().equals(btnNovo)){
					limparCampos();
					abilitarCampos();
					abilitarBotoes(false, true, true, false, true, false, false); 			  
				}
				
                //Alterar
				else if (evento.getSource().equals(btnAlterar)){
					abilitarCampos();
					abilitarBotoes(false, true, false, false, true, true, false);				  
				}
				
                //Salvar
				else if (evento.getSource().equals(btnSalvar)){
					limparCampos();
					desabilitarCampos();
					abilitarBotoes(true, false, true, false, false, false, true);
				}
                				
                //Excluir
				else if (evento.getSource() == btnExcluir){
					limparCampos();
					desabilitarCampos();				
					abilitarBotoes(true, false, true, false, false, false, true);								 
				}							
			}
		}
		
}