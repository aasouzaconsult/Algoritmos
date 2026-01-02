import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CadastroDeEndereco extends JInternalFrame {	
	private Endereco endereco;
	private ImageIcon icone;
	private Border bordaMargem, bordaNorte, bordaSul; 
	private Container container;
	private GridBagLayout gbLayout;
	private GridBagConstraints gbConstraints;
	private JLabel lblLogradouro, lblComplemento, lblNumero, lblBairro, lblCep, lblCidade, lblEstado;
	private JTextField txfLogradouro, txfComplemento, txfNumero, txfBairro, txfCep;
	private JComboBox cbxCidade, cbxEstado;
	private String cidades[] = {"Selecione a cidade", "Fortaleza", "Aracati", "Tianguá", "Russas"};
	private String estados[] = {"Selecione o estado", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", 
	"Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", 
	"Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", 
	"Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"}; 
	private JButton btnBuscar, btnNovo, btnAlterar, btnSalvar, btnExcluir, btnCancelar, btnSair;
	private JPanel panelNorte, panelSul ;
	
	CadastroDeEndereco() {
		super("Cadastro de Endereco", false, false, false, true);
		
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
		panelNorte = new JPanel();
		panelSul     = new JPanel();
		panelNorte.setLayout(gbLayout);
		panelSul.setLayout(new GridLayout(1, 6));
		
		//Instancia os JLabels
		lblLogradouro = new JLabel(" Logradouro: ");
		lblComplemento = new JLabel(" Complemento: ");
		lblNumero = new JLabel(" Número: ");
		lblBairro = new JLabel(" Bairro: ");
		lblCep = new JLabel(" CEP: ");
		lblCidade = new JLabel(" Cidade: ");
		lblEstado = new JLabel(" Estado: ");
		
		//Instancia os JTextFields
		txfLogradouro = new JTextField(25);
		txfComplemento = new JTextField(25);
		txfNumero = new JTextField(10);
		txfBairro = new JTextField(25);
		txfCep = new JTextField(10);
		
		//Instancia os ComboBoxes
		cbxCidade = new JComboBox(cidades);
		cbxEstado = new JComboBox(estados);
        
		//Instancia os JButtons
		btnBuscar   = new JButton("Buscar");
		btnNovo     = new JButton("Novo");
		btnAlterar  = new JButton("Alterar");
		btnSalvar   = new JButton("Salvar");
		btnExcluir   = new JButton("Excluir");
		btnCancelar = new JButton("Cancelar");
		btnSair       = new JButton("Sair");		
		
		ActionEventHandler tratador = new ActionEventHandler();
		
		//Adiciona um ActionListener aos botões
		btnBuscar.addActionListener(tratador);
		btnNovo.addActionListener(tratador);
		btnAlterar.addActionListener(tratador);
		btnSalvar.addActionListener(tratador);
		btnExcluir.addActionListener(tratador);
		btnCancelar.addActionListener(tratador); 
		btnSair.addActionListener(tratador);
		
		//Adiciona todos os componentes ao painel norte
		adicionarComponente(lblLogradouro, 0, 0, 1, 1, "EAST");
		adicionarComponente(txfLogradouro, 0, 1, 3, 1, "WEST");
		adicionarComponente(lblNumero, 1, 0, 1, 1, "EAST");
		adicionarComponente(txfNumero, 1, 1, 1, 1, "WEST");
		adicionarComponente(btnBuscar,1, 3, 1, 1, "EAST");
		adicionarComponente(lblCep, 2, 0, 1, 1, "EAST");
		adicionarComponente(txfCep, 2, 1, 1, 1, "WEST");
	    adicionarComponente(lblComplemento, 3, 0, 1, 1, "EAST");
		adicionarComponente(txfComplemento, 3, 1, 3, 1, "WEST");
		adicionarComponente(lblBairro, 4, 0, 1, 1, "EAST");
		adicionarComponente(txfBairro, 4, 1, 3, 1, "WEST");	
		adicionarComponente(lblCidade, 5, 0, 1, 1, "EAST");
		adicionarComponente(cbxCidade, 5, 1, 1, 1, "WEST");
		adicionarComponente(lblEstado, 6, 0, 1, 1, "EAST");
		adicionarComponente(cbxEstado, 6, 1, 1, 1, "WEST");
		
        //Adiciona todos os componentes ao painel sul
		panelSul.add(btnNovo);
		panelSul.add(btnAlterar);
		panelSul.add(btnSalvar);
		panelSul.add(btnExcluir);	
		panelSul.add(btnCancelar);	
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
					
		setSize(405, 250);
		setVisible(true);
		setOpaque(true);
		setResizable(false);
		
		desabilitarCampos();
		abilitarBotoes(true, true, false, false, false, true);
	
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
   		txfLogradouro.setText("");
		txfNumero.setText("");
		txfCep.setText("");
		txfComplemento.setText("");
		txfBairro.setText("");
		cbxCidade.setSelectedIndex(0);
		cbxEstado.setSelectedIndex(0);   		
   }
   
   private void abilitarCampos(){
		txfLogradouro.setEditable(true);
		txfNumero.setEditable(true);
		txfCep.setEditable(true);
		txfComplemento.setEditable(true);
		txfBairro.setEditable(true);
		cbxCidade.setEnabled(true);
		cbxEstado.setEnabled(true);		 	
   }
   
   private void desabilitarCampos(){
	  	txfLogradouro.setEditable(false);
	  	txfNumero.setEditable(false);
	  	txfCep.setEditable(false);
	  	txfComplemento.setEditable(false);
	  	txfBairro.setEditable(false);
	  	cbxCidade.setEnabled(false);
	  	cbxEstado.setEnabled(false);	
   }
   
   private void abilitarBotoes(boolean buscar, boolean novo, boolean alterar, boolean salvar, boolean excluir, boolean cancelar, boolean sair){
   	    btnBuscar.setEnabled(buscar); 
   	    btnNovo.setEnabled(novo);
		btnAlterar.setEnabled(alterar);
		btnSalvar.setEnabled(salvar);
		btnExcluir.setEnabled(excluir);
		btnCancelar.setEnabled(cancelar); 
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