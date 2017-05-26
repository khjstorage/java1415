package awt.swing.gui;
import java.awt.*;
public class WindowFrame {
	public static void main(String args[]) {
		Frame f = new Frame("Frame");
		f.setSize(200, 200);
		f.setBackground(Color.white);
		f.setVisible(true);
		
		Window w = new Window(f) {
			public void paint(Graphics g) {
				g.drawString("Window", 10, 50);
			}
		};
		
		Rectangle r = new Rectangle(50, 50, 100, 100);
		w.setBounds(r);
		w.setBackground(Color.yellow);
		w.setVisible(true);
		w.toFront(); 
	}
}
