/*
 * Janela Principal da Aplicacao
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class JanelaPrincipal extends JFrame{
	private ImageIcon icone;
	private JDesktopPane painelPrincipal;
	private JMenuBar barraDeMenus;
	private JMenu menuDeArquivo, menuDeCadastros, menuDeAjuda;  
	private JMenuItem sair, cadastroDePessoa, cadastroDeCidade, cadastroDeEstado, sobre;
	
	public JanelaPrincipal(){
		super( "Sistema" );
		
		//Adiciona o icone à janela
		icone = new ImageIcon("SuperJava.gif");
		icone.setImage(icone.getImage().getScaledInstance(30, 18, 500));
		setIconImage(icone.getImage());
       
		//Instancia os componentes de menu
		barraDeMenus = new JMenuBar();
		menuDeArquivo = new JMenu("Arquivo");
		menuDeArquivo.setMnemonic('A');
		menuDeCadastros = new JMenu("Cadastros");
		menuDeCadastros.setMnemonic('C');
		menuDeAjuda = new JMenu("Ajuda");
		menuDeAjuda.setMnemonic('J');
		sair = new JMenuItem("Sair");
		sair.setMnemonic('S');
		cadastroDePessoa = new JMenuItem("Pessoas");
		cadastroDePessoa.setMnemonic('P');
		cadastroDeCidade = new JMenuItem("Cidades");
		cadastroDeCidade.setMnemonic('C');
		cadastroDeEstado = new JMenuItem("Estados");
		cadastroDeEstado.setMnemonic('E');
		sobre = new JMenuItem("Sobre");
		sobre.setMnemonic('S');
		
		//Adiciona os itens ao menu
		menuDeArquivo.add(sair);
		menuDeCadastros.add(cadastroDePessoa);
		menuDeCadastros.add(cadastroDeCidade);
		menuDeCadastros.add(cadastroDeEstado);
		menuDeAjuda.add(sobre);
		
		
		//Adiciona o menu a� barra de menus
		barraDeMenus.add(menuDeArquivo);
		barraDeMenus.add(menuDeCadastros);
		barraDeMenus.add(menuDeAjuda);
		
		ActionEventHandler tratador = new ActionEventHandler();
		
		//Adiciona um ActionListener aos itens de menu
		sair.addActionListener(tratador);
		cadastroDePessoa.addActionListener(tratador);
		cadastroDeCidade.addActionListener(tratador);
		cadastroDeEstado.addActionListener(tratador);
		sobre.addActionListener(tratador);
		
		setJMenuBar(barraDeMenus);
		
		painelPrincipal = new JDesktopPane();
		painelPrincipal.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(painelPrincipal);	
		
		setSize(800,600);
		setVisible(true);					
	}
	
	// Verifica se um frame do tipo strTipoFrame ja foi criado. Se tiver sido criado retorna true e seleciona 
	// o frame existente do mesmo tipo de strTipoFrame, caso contrario retorna false.
	private boolean verificaFrame(String strTipoFrameInterno){
		boolean criado = false;
		JInternalFrame filhos[] = painelPrincipal.getAllFrames();
		for(int i = 0; i < filhos.length; i++){
			if (filhos[i].getClass().getName().equals(strTipoFrameInterno)){
				criado = true;
				try {
					filhos[i].setSelected(true);
				}catch (java.beans.PropertyVetoException e) {}
			}
		}
		return criado;
	}
	
	//Cria um frame interno se ele não existir. O frame sera modal se o parametro modal for true. 
	protected void criaFrame(String strTipoFrameInterno, boolean modal){
		if (!verificaFrame(strTipoFrameInterno)){
			Class classe;
			Object tela;
			try{
				classe = Class.forName(strTipoFrameInterno);
				try{
					tela = classe.newInstance();
					painelPrincipal.add((JInternalFrame)tela);
					if (modal){
						tornaFrameModal((JInternalFrame)tela);
					}
					try{
						((JInternalFrame)tela).setSelected(true);
					}
					catch (java.beans.PropertyVetoException e){}
					painelPrincipal.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
					painelPrincipal.setDragMode(JDesktopPane.LIVE_DRAG_MODE);
					}
					catch (InstantiationException e){}
		   }
		   catch (ClassNotFoundException ex){}
		   catch (IllegalAccessException ex){}
		}
	}
	
	private void tornaFrameModal(JInternalFrame frameInterno){
		JPanel glass = new JPanel();
		glass.setOpaque(false);
		frameInterno.addInternalFrameListener(new ModalAdapter(glass));
		glass.add(frameInterno);
		setGlassPane(glass);
		glass.setVisible(true);
		frameInterno.setVisible(true);
	}
	
	public static void main(String args[]){
		
		JanelaPrincipal aplicacao = new JanelaPrincipal();
		aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	}
	
	static class ModalAdapter extends InternalFrameAdapter {
		Component glass;

		public ModalAdapter(Component glass) {
		  this.glass = glass;
		  MouseInputAdapter adapter = new MouseInputAdapter(){};
		  glass.addMouseListener(adapter);
		  glass.addMouseMotionListener(adapter);
		}

		public void internalFrameClosed(InternalFrameEvent e) {
		  glass.setVisible(false);
		}
	  }
	  
	  	
	private class ActionEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			
			//Sai do sistema
			if (evento.getSource().equals(sair)){
				System.exit(0);
			}
			
			//Carrega o cadastro de Pessoas
			else if (evento.getSource().equals(cadastroDePessoa)){
				criaFrame("CadastroDePessoas", false);
		    }
			
            //Carrega o cadastro de Cidades 
			else if (evento.getSource().equals(cadastroDeCidade)){
				criaFrame("CadastroDeCidades", false); 
			}
			
			//Carrega o cadastro de Estados
			else if (evento.getSource().equals(cadastroDeEstado)){
				criaFrame("CadastroDeEstados", false); 			
			}
			
			else if (evento.getSource().equals(sobre)){
				criaFrame("Sobre", false);
			}
		}
	}
}
