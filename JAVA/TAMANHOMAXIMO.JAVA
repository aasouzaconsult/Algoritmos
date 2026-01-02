import javax.swing.text.*;

class TamanhoMaximo extends PlainDocument{
  int tamMax;
  
  public TamanhoMaximo(int tam){
    tamMax = tam;
  }
  
  public void insertString(int offs, String str, AttributeSet a) 
                           throws BadLocationException{
    if((getLength() + str.length()) <= tamMax)
      super.insertString(offs, str, a);
  } 
}