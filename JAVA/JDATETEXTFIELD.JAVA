import javax.swing.text.*;

class JDateTextField extends PlainDocument{
  public void insertString(int offs, String str, AttributeSet a) 
                           throws BadLocationException{
    char digito;
    boolean numerico = true;
    
    if((getLength() + str.length()) <= 10){
      for(int i = 0; i < str.length(); i++){
        digito = str.charAt(i);
      
        if(!Character.isDigit(digito)){
      	  numerico = false;
      	  break; 
        }
      }
    
      if(numerico){ 
        int tam = getLength() + str.length();
        if((tam == 2) && (tam == 5))
          super.insertString(offs, str + "/", a);
        else
          super.insertString(offs, str, a);
      }
    }
  } 
}