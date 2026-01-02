package telejogo4;

import java.awt.Rectangle;

abstract public class ObjetoSimulado{

  protected String tipo = "Sem tipo";
  protected String nome = "Sem nome";

  protected boolean visible = true;


  public String getTipo(){
    return tipo;
  }

  public void setTipo( String s){
    tipo = s;
  }

  public String getNome(){
    return nome;
  }

  public void setNome( String n){
    nome = n;
  }

  public boolean isVisible(){
    return visible;
  }

  public void setVisible( boolean v){
    visible = v;;
  }

  public void show( String s){
    System.out.println(s);
  }

  abstract public Rectangle toRectangle();


}

