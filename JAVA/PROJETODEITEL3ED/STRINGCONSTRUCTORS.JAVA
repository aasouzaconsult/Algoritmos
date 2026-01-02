/*
 * Created on 14/05/2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author claudemir
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
// Fig. 10.1: StringConstructors.java
// This program demonstrates the String class constructors.
import javax.swing.*;

public class StringConstructors {
   public static void main( String args[] )
   {
	  char charArray[] = { 'c', 'l', 'a', 'u', 'd', ' ',
						   'e', 'm', 'i', 'r' };
	  byte byteArray[] = { (byte) 'n', (byte) 'e', (byte) 'w',
						   (byte) ' ', (byte) 'y', (byte) 'e',
						   (byte) 'a', (byte) 'r' };
	  StringBuffer buffer;
	  String s, s1, s2, s3, s4, s5, s6, s7, output;

	  s = new String( "Ola" );
	  buffer =
		 new StringBuffer( "Bem Vindo a Programacao Java!" );

	  // use the String constructors
	  s1 = new String();
	  s2 = new String( s );
	  s3 = new String( charArray );
	  s4 = new String( charArray, 6, 3 );
	  s5 = new String( byteArray, 4, 4 );
	  s6 = new String( byteArray );
	  s7 = new String( buffer );

	  output = "s1 = " + s1 +
			   "\ns2 = " + s2 +
			   "\ns3 = " + s3 +
			   "\ns4 = " + s4 +
			   "\ns5 = " + s5 +
			   "\ns6 = " + s6 +
			   "\ns7 = " + s7;

	  JOptionPane.showMessageDialog( null, output,
		 "Demonstrating String Class Constructors",
		 JOptionPane.INFORMATION_MESSAGE );

	  System.exit( 0 );
   }
}
