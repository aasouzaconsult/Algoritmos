package com.expertcop.io;

import jade.core.*;
import java.util.*;
import java.text.SimpleDateFormat;
import jade.lang.acl.*;
import java.sql.SQLException;
import java.net.*;
import jade.core.behaviours.*;
import java.io.*;
import javax.sql.DataSource;
import com.expertcop.message.*;
import com.expertcop.agentes.*;
import com.expertcop.gui.*;
import com.expertcop.dao.*;
import com.expertcop.model.*;
import com.expertcop.beans.ConfigForm;
import com.expertcop.gerenciadores.*;
import com.expertcop.util.Relogio;
import com.expertcop.util.Posicao;
import com.expertcop.util.AcessoBanco;
import com.expertcop.util.Ambiente;
import com.expertcop.util.CarregaAgente;
import com.expertcop.util.Ontologia;
import com.expertcop.util.ConnectionPool;
import com.expertcop.util.XMLUTIL;
import org.apache.commons.dbcp.BasicDataSource;
import com.expertcop.comportamentos.*;



public class AgenteInterface extends Agente
{

	private int numPoliciais=0;
	private Vector policiais = new Vector();
	private Gui gui;
	public static Relogio relogio;
	private ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
	private AcessoBanco banco = new AcessoBanco("ExpertCop","xcop","xtcop" );
	public ServerSocket server;
	private	ConnectionPool cPool;
	private Vector epmList;
	private int fatorAceleracao=1;
	private Date dataInicio;
	private boolean pausado=false;


	public AgenteInterface()
	{

		 cPool = new ConnectionPool();
//		 	GregorianCalendar data = new GregorianCalendar();
//			data.set(1980,9,22,0,0);


//		relogio = new Relogio();
		Agente.relogio = new Relogio();

		//relogio.setFatorAceleracao(300);


		 }

	protected void setup()
	{
		//Inclue comportamento de escuta de mensagens

		 //Inicializa Interpretador socket-ACL
		 System.out.println("1");
		 CarregaAgente.startAgente(Ambiente.INTERPRETADOR,InterpretadorACL.class);
		 System.out.println("2");
       CarregaAgente.startAgente(Ambiente.CIOPS,CIOPS.class);
       System.out.println("3");
		 CarregaAgente.startAgente(Ambiente.GERENCIADOR_BANDIDOS,GerenciadorCriminosos.class);
		 System.out.println("4");
		 CarregaAgente.startAgente(Ambiente.GERENCIADOR_POLICIAIS,GerenciadorPoliciais.class);
		 System.out.println("5");
//		 CarregaAgente.startAgente(Ambiente.GERENCIADOR_PONTOS_NOTAVEIS,GerenciadorPoliciais.class);
//		CarregaAgente.startAgente(Ambiente.GERENCIADOR_GRAFICO,GerenciadorGrafico.class);
       CarregaAgente.startAgente(Ambiente.COMUNICADOR,AgenteComunicador.class);

		 //Carrega o GerenciadorCriminosos e instancia todos os pontos da area 3
//		 CarregaAgente.startAgente(Ambiente.GERENCIADOR_PONTOS_NOTAVEIS,GerenciadorPontosNotaveis2.class);
//		 iniciarPontosNotaveis("3");

		 //Inicializa a interface gráfica do sistema.
		 Gui.setDefaultLookAndFeelDecorated(true);
		 gui = new Gui(this);
     	 enviaMensagem("LIMPAR_TELA",Ambiente.INTERPRETADOR);
		 /**
		  * Adiciona comportamento para receber mensagens
		  */
		 this.addBehaviour(new EscutaMsg(this));
		 this.addBehaviour(new mostraRelogio(this));



	}
/**
 * Metodo para interpretacao de mensagens recebidas
 */
	public void interpretaMensagem(ACLMessage msg){

         System.out.println ("INTERFACE Interpreta Msg: "+msg.getContent());
         if (msg.getContent().startsWith("PLAY")/*||msg.getProtocol().startsWith("PLAY")*/)
        	{
        		//ConfigForm config =(ConfigForm) XMLUTIL.xml2object(msg.getContent());
        		//System.out.println (config.getDataInicio()+" - "+config.getDataFim());
        		//this.load(config);
        		//this.doWait(3000);
        		this.play();
        		enviaMensagem("PLAY_OK",Ambiente.COMUNICADOR);
        		System.out.println ("passou pelo PLAY_OK AgenteInterface");
        	}
        	else if(msg.getContent().startsWith("PAUSE"))
        	{
        		this.pause();
        		enviaMensagem("PAUSE_OK",Ambiente.COMUNICADOR);
        	}

        	else if(msg.getContent().startsWith("RESET"))
        	{
        		this.reset();
        		enviaMensagem("RESET_OK",Ambiente.COMUNICADOR);

        	}
        	else if(msg.getContent().startsWith("LOAD"))
        	{
        		ConfigForm config =(ConfigForm) XMLUTIL.xml2object(msg.getProtocol());
        		load(config);
        		enviaMensagem("LOAD_OK",Ambiente.COMUNICADOR);
        	}
        	else if(msg.getContent().startsWith("INFORMA_PATRULHA"))
        	{
        		enviaMensagem("INFORMAR_LATITUDE_LONGITUDE PP;",Ambiente.INTERPRETADOR);
        	}
            else if(msg.getContent().startsWith("RETORNO_LATITUDE_LONGITUDE"))
        	{
        		StringTokenizer st=new StringTokenizer(msg.getContent());
        		st.nextToken();
        		int Lat=Integer.parseInt(st.nextToken());
                int Long=Integer.parseInt(st.nextToken());
                Posicao pos=new Posicao();
                pos.setPosicao(Lat,Long);
                enviaMensagem("RETORNO_LATITUDE_LONGITUDE",Ambiente.COMUNICADOR,pos);
        	}
	}
	/**
     * metodo que estabelece os parametros de configuracao da simulacao e carrega agentes necessarios
     */
     //lembrar de deixar private
	public void load(ConfigForm config){

		System.out.println ("Carregando configuracao...");
	    if (config!=null){
	        SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
	    	try {
	    	    this.dataInicio = dFormat.parse(config.getDataInicio());
	    	}
			catch (Exception ex) {
			    System.out.println("Data invalida!");
			  	ex.printStackTrace();
			}
            this.fatorAceleracao=config.getFatorAceleracao();
	    }
	    else {
	     	this.dataInicio=new Date();
	     	this.fatorAceleracao=1;
        }
	    enviaMensagem("CARREGA_POLICIAIS",Ambiente.GERENCIADOR_POLICIAIS);
       	System.out.println ("Carregando configuração... FIM");

	}


	/**
     * metodo que inicia a simulacao
     */

    public void play(){
    	System.out.println ("Metodo PLAY");


	if(!pausado){
    	GregorianCalendar c = new GregorianCalendar();
    	c.setTime(this.dataInicio);

        //	c.set(2003,9,31,0,0);
//    	relogio = new Relogio(c);
//    	relogio.setFatorAceleracao(this.fatorAceleracao);
//    	relogio.play();
		Agente.relogio.setDataReferencia(c);
        Agente.relogio.setFatorAceleracao(this.fatorAceleracao);
	}
		pausado=false;
		Agente.relogio.play();

    	System.out.println (Agente.relogio.getHoje().getTime());
    	enviaMensagem(Ontologia.ativarAgente(),Ambiente.GERENCIADOR_POLICIAIS);
    	System.out.println ("FIM Metodo PLAY");

    }

    /**
     * metodo que interrompe a simulacao
     */
    public void pause(){

    	Agente.relogio.pause();
    	pausado=true;
    	enviaMensagem(Ontologia.desativarAgente(),Ambiente.GERENCIADOR_POLICIAIS);
    	ACLMessage msga = new ACLMessage(1);
    	Iterator i =msga.getAllReceiver();
    	while(i.hasNext())
    		System.out.println (i.next());
    }

    /**
     * metodo que reseta a simulacao
     */
     public void reset(){

     	enviaMensagem("LIMPAR_TELA",Ambiente.INTERPRETADOR);
     	GregorianCalendar c = new GregorianCalendar();
    	c.setTime(this.dataInicio);
     	Agente.relogio.reset(c);

     	enviaMensagem("RESET",Ambiente.GERENCIADOR_POLICIAIS);

     }

	public void incluirEquipe()
	{
//		numPoliciais++;
//		String id = Ambiente.POLICIAL + "_" + numPoliciais;
//		CarregaAgente.startAgente(id,EquipePolicial.class);
//		policiais.addElement(id);
//		enviaMensagem(Ontologia.alocarAgente(),Ambiente.GERENCIADOR_POLICIAIS);
	   //CarregaAgente.startAgente("policial_1",com.expertcop.agentes.EquipePolicial.class);

	this.carregaEquipesPoliciaisBanco();


	}




	public void iniciarInferencia()
	{

	   this.ativarEquipesPoliciais();


//	 System.out.println ("interface: " + relogio.getMinuto() + ":" + relogio.get);
//	 enviaMensagem("CARREGA_IDS",Ambiente.GERENCIADOR_POLICIAIS);
//		this.carregaEquipesPoliciaisBanco();
//
//		doWait(2000);
//		//enviaMensagem(Ontologia.ativarAgente(),"policial_1");
//		enviaMensagem(Ontologia.ativarAgente(),Ambiente.GERENCIADOR_POLICIAIS);
//
//
//	  	for(Iterator i= policiais.iterator(); i.hasNext();)
//	  	{
//			String id =  (String) i.next();
//			enviaMensagem(Ontologia.ativarAgente(),id);
//    	}
	}
	protected void iniciarPontosNotaveis(String area)
	{
		enviaMensagem(Ontologia.IniciarPontosNotaveis("3"),Ambiente.GERENCIADOR_PONTOS_NOTAVEIS);
	}


	/*protected void carregaPontosNotaveis()
	{
		try
	    {
	    	ResultSet registros = banco.AcessoDadosPontoNotavel("teste");
			boolean HaRegistro = registros.next();

			if (HaRegistro)
			{
				do
				{
					String id = Ambiente.PONTO_NOTAVEL + "_" + registros.getString(registros.findColumn("codigo"));
					CarregaAgente.startAgente(id,PontoNotavel.class);
					doWait(500);
					enviaMensagem(Ontologia.caracterizarPontoNotavel(registros.getString(registros.findColumn("descricao")), registros.getString(registros.findColumn("valorDensidade")), registros.getInt(registros.findColumn("permanencia")), registros.getInt(registros.findColumn("latitude")), registros.getInt(registros.findColumn("longitude"))),id);
				}
				while (registros.next());
			}
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}*/

	public void carregaEquipesPoliciaisBanco()
	{

		CartaoPrograma cp = null;
	   DataSource ds = cPool.getDataSource();
		EquipePolicialModelDAO epmDAO = new EquipePolicialModelDAO(ds);
		EquipePolicialModel epm = null;
		epmList = null;
		try {
	   	epmList = (Vector)epmDAO.list();
	   }
	   catch (Exception ex) {
	   	ex.printStackTrace();
	   }

		for (Iterator it=epmList.iterator(); it.hasNext(); ) {
			epm = (EquipePolicialModel)it.next();

			cp = getCartaoPrograma(ds, epm.getCodigoCartaoPrograma());
			CarregaAgente.startAgente(epm.getId(), com.expertcop.agentes.EquipePolicial.class);
			this.enviaMensagem(Ontologia.setCartaoPrograma(),epm.getId(),cp);
		}

	   //this.enviaMensagem(Ontologia.alocarAgente(),Ambiente.GERENCIADOR_POLICIAIS,cp);

	}


	private void ativarEquipesPoliciais()
	{
	  	for(Iterator i= epmList.iterator(); i.hasNext();)
	  	{
			EquipePolicialModel ep =  (EquipePolicialModel) i.next();
			enviaMensagem(Ontologia.ativarAgente(),ep.getId());
    	}
	}


	private CartaoPrograma getCartaoPrograma(DataSource ds, int cod)
	{
		CartaoPrograma cp = null;

		CartaoProgramaDAO cpDAO = new CartaoProgramaDAO(ds);
		CartaoProgramaPostoServicoDAO cppsDAO = new CartaoProgramaPostoServicoDAO(ds);
		PostoServicoPontoPatrulhaDAO psppDAO = new PostoServicoPontoPatrulhaDAO(ds);

		try {
	   	cp = cpDAO.retrieve(cod);

	   	Vector cppsList = (Vector)cppsDAO.queryByCartaoPrograma(cp.getCodigo());
	   	System.out.println ("CCPS: "+cppsList);
	   	cp.setCartaoProgramaPostoServico(cppsList);
	   	CartaoProgramaPostoServico cpps = null;

	   	// For a set or list
         for (Iterator it=cppsList.iterator(); it.hasNext(); ) {
             cpps = (CartaoProgramaPostoServico)it.next();
             Vector psppList = (Vector)psppDAO.queryByPostoServico(cpps.getCodigoPostoServico());
             cpps.setPontosPatrulha(psppList);
            // System.out.println("epa: " + psppList);
             ///////////Teste
            // System.out.println("Linha:"+cpps.getCodigoPostoServico()+" : "+cpps.getPontosPatrulha().size());

         }
	   }
	   catch (SQLException ex) {
	   	System.err.println("Erro ao carregar o cartão programa do banco.");
	   	ex.printStackTrace();
	   }
		return cp;
	}

	public static void main(String args[])
   {
      AgenteInterface ai = new AgenteInterface();
      ai.carregaEquipesPoliciaisBanco();
   }
}

class mostraRelogio extends CyclicBehaviour{

	private Agente agente;
private RelogioGui gui;

	public mostraRelogio(Agente a){

		agente=a;
//		j = new JFrame("Relogio");
		gui= new RelogioGui();

	}

	public void action(){


		gui.atualiza(Agente.relogio.getHoje().getTime().toLocaleString());

	}

}