import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AlarmMemo implements Runnable{
	
	private int nanoSecond ;	
	private String message;
	private JFrame frame;
	private JLabel label;
	
	public AlarmMemo(int aNanoSecond, String aMessage)
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		Dimension dim = kit.getScreenSize();
		
		nanoSecond = aNanoSecond * 1000;
		message = aMessage == null ? "그러라고 사준 컴퓨터가 아닐텐데!!!!" : aMessage;
		frame = new JFrame("이 놈아!");
		label = new JLabel(message);
		frame.add(label);
		frame.setAlwaysOnTop(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLocation((int)(dim.getWidth()/2), (int)(dim.getHeight()/2));
	}
	
	public void run()
	{
		try{
			while( true )
			{
				Thread.sleep(nanoSecond);
				frame.setVisible(true);
				Thread.sleep(1000);
				frame.setVisible(false);
			}
		}catch(InterruptedException ie){ ie.printStackTrace();
		}
	}
	
	public static void main(String[] a)
	{
		int nanoSecond;
		String message = null;
		AlarmMemo alarm;
		try{
			nanoSecond = Integer.parseInt(JOptionPane.showInputDialog("시간 간격을 입력하세요. (단위 초)"));
			message = (message = JOptionPane.showInputDialog("메시지를 입력하세요.")).equals("") ? null : message;
			alarm = new AlarmMemo(nanoSecond, message);
			
			new Thread(alarm).start();
				
		}catch(IllegalArgumentException iae){ iae.printStackTrace();
			System.exit(1);
		}
	}

}
