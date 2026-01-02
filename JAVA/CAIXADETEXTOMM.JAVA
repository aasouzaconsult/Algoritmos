import javax.swing.text.*;

class CaixaDeTextoMM extends PlainDocument{
  String texto, tipo;
  
  public CaixaDeTextoMM(String tp){
    tipo = tp;
  }
  
  public void insertString(int offs, String str, AttributeSet a) 
                           throws BadLocationException{
    if(tipo == "ma")
      texto = str.toUpperCase();
    else if(tipo == "mi")
      texto = str.toLowerCase();
    
    super.insertString(offs, texto, a);
  } 
}