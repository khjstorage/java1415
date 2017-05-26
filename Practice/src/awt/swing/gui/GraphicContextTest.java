package awt.swing.gui;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;

public class GraphicContextTest extends Frame {
	public GraphicContextTest( ) {   setSize(300, 150); }
	public void paint(Graphics g) {
		Insets inset = getInsets( );
		int origin_x, origin_y;
		origin_x = inset.left;
		origin_y = inset.top;
		
		g.translate(origin_x, origin_y);
		g.setColor(Color.blue);
		g.drawLine(0, 0, 50, 50);
		
		g.setColor(Color.red);
		g.drawRect(10, 10, 100, 100);
	}
	public static void main(String args[ ]) {
		Frame f = new Frame( );
		f.setVisible(true);
	}
}
