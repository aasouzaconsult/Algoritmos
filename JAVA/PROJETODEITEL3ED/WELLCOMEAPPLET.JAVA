/*
 * Created on 07/05/2004
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
// Fig. 3.6: WelcomeApplet.java
// A first applet in Java 
import javax.swing.JApplet;  // import class JApplet
import java.awt.Graphics;    // import class Graphics

public class WellcomeApplet extends JApplet {  
   public void paint( Graphics g )
   {
	  g.drawString( "Welcome to Java Programming!", 25, 25 );
   }
}