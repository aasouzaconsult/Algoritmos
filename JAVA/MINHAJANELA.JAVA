import javax.swing.*;

public class MinhaJanela extends Janela{
  public MinhaJanela(){
    titulo = "Esta é uma classe personalizada";
    altura = 600;
    largura = 800;
    redimensionavel = true;
    icone = "java_exemplos/imgensbox.gif";
    modo = "maximizada";
    mostrar();  
    
    setLocation(280,235);
  }
  
  public static void main(String args[]){
    MinhaJanela app = new MinhaJanela();
  }
}