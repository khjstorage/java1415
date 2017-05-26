package awt.swing.gui;
import java.awt.*;
public class PulldownMenu {
	public static void main(String args[ ]) {
		Frame f = new Frame("Pulldown Menu");
		
		MenuBar mb = new MenuBar( );
		
		Menu m = new Menu("Menu1");
		
		m.add(new MenuItem("MenuItem1"));
		
		Menu sm = new Menu("SubMenu1");
		
		sm.add(new MenuItem("SubMenuItem1"));
		sm.add(new MenuItem("SubMenuItem2"));
		
		m.add(sm);
		m.add(new MenuItem("MenuItem2"));
		mb.add(m);
		
		f.setMenuBar(mb);
		f.setSize(200, 200);
		f.setBackground(Color.white);
		f.setVisible(true);
	}
}
