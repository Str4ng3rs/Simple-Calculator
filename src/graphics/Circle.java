package graphics;

import java.awt.*;

/*
*
* Experimental Class using AWT to generate graphics.
*
*/

public class Circle extends Canvas {
	public void paint(Graphics graphics){
		//graphics.drawOval(384,0,100,100);
		graphics.fillOval(384,0,100,100);
	}
}
