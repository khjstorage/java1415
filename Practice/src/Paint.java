import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.border.*;
import java.awt.print.*;


public class Paint extends JFrame
{ 
	boolean isFirstTime=true,flag;
	private JCheckBox FillButton;
	private JCheckBox AroundButton;
	private int check = 0;
	private int check2 = 0;
	private Shape currentShape = null; 
	private Color currentColor = Color.black;

	CustomPanel p2;
	New n;
	private Image image = null; 
	public Paint()
	{ 
		setTitle("Paint"); 
		setSize(1024,750); 
		
		 

		Container c = getContentPane(); 

		JPanel p = new JPanel(); 
		
		FillButton = new JCheckBox("Draw Color Filled Shape");
		FillButton.addItemListener(
		new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				if(FillButton.isSelected())
					check = 1;
				else
					check = 0;
			}
		}
		);  
		//addition from here again~~~//
		AroundButton = new JCheckBox("Border");
		AroundButton.addItemListener(
		new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				if(AroundButton.isSelected())
					check2 = 1;
				else
					check2 = 0;
			}
		}
		);  
		// up to here~~~~~~~~~
		
 
		p.setLayout(new GridBagLayout()); 

		p.add(new Pencil(),new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),25,10));
		p.add(new Line(),new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),38,10)); 
		p.add(new Rectangle(),new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),3,10));
		p.add(new Eraser(),new GridBagConstraints(1,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),24,10)); 
		p.add(new WhiteOut(),new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),3,10)); 
		p.add(new Oval(),new GridBagConstraints(1,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),39,10)); 
		p.add(new DRect(),new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),3,10)); 
		p.add(new DRect2(),new GridBagConstraints(1,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),8,10)); 
		p.add(new Round(),new GridBagConstraints(0,4,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),-1,10)); 
		

	//	new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),3,10)); 
	


		c.add(p, BorderLayout.WEST); 
		
		p2 = new CustomPanel(); 
		p2.setBackground( Color.white ); 
		c.add(p2, BorderLayout.CENTER); 
		
		
		JPanel p3 = new JPanel();
	//	n=new New();
	//	p3.add(n);
		//n,new GridBagConstraints(0,0,0,0,0,0,GridBagConstraints.WEST,GridBagConstraints.NONE,new Insets(0,0,0,0),100,10)); 
		
		p3.add(new ColorButton());

		p3.add(FillButton); // this make a color filled shape
		p3.add(AroundButton); 
		c.add(p3, BorderLayout.NORTH);


		
		JMenuBar bar = new JMenuBar(); 
		setJMenuBar( bar ); 

//Menu bar!~!~!~!~!~!~!~!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//File메뉴~~~
		JMenu FileMenu = new JMenu("File"); 
		FileMenu.setMnemonic('F'); 
		
		JMenuItem restart = new JMenuItem("New");
		restart.setMnemonic('N');
		FileMenu.add( restart );
		restart.addActionListener(
		new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				JLabel msg = new JLabel();
				msg.setFont( new Font( "Sanserif", Font.PLAIN, 12 ) );
		        msg.setForeground( Color.red );
		        msg.setText( "New  ( You are about to remake. Are you sure to re-draw? )" );
		        if( JOptionPane.showConfirmDialog( p2 ,msg, "Exiting", JOptionPane.YES_NO_OPTION ) !=
		                JOptionPane.YES_OPTION ) return;
				clearImage();				
			}
		}
		);
		FileMenu.addSeparator();
		
		JMenuItem print = new JMenuItem("Print!");
		print.setMnemonic('P');
		FileMenu.add( print );
		print.addActionListener(
		new ActionListener()
		{
			public void actionPerformed( ActionEvent e)
			{
				printnow();
			}
		}
		);
		FileMenu.addSeparator();
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic('X');
		FileMenu.add( exit );
		exit.addActionListener(
		new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
		        JLabel msg = new JLabel();
		        msg.setFont( new Font( "Sanserif", Font.PLAIN, 12 ) );
		        msg.setForeground( Color.red );
		        msg.setText( "Exiting  ( You are about to exit. Are you sure to exit? )" );
		        if( JOptionPane.showConfirmDialog( p2 ,msg, "Exiting", JOptionPane.YES_NO_OPTION ) !=
		                JOptionPane.YES_OPTION ) return;

		        System.exit(0);
			}
		}
		);
		FileMenu.addSeparator();
		bar.add( FileMenu );
//File메뉴의 끝~~~

//Edit메뉴 시작~~~
		JMenu EditMenu = new JMenu("Edit"); 
		EditMenu.setMnemonic('E'); 

		JMenuItem goFirst = new JMenuItem( "Return" ); 
		goFirst.setMnemonic( 'r' ); 
		EditMenu.add( goFirst ); 
		goFirst.addActionListener(  
		new ActionListener()
		{ 
			public void actionPerformed( ActionEvent e ) 
			{ 

			} 
		} 
		); 
		EditMenu.addSeparator(); 



		JMenuItem colorMenu = new JMenuItem("Color"); 
		colorMenu.setMnemonic( 'c' ); 
		EditMenu.add( colorMenu ); 
		colorMenu.addActionListener( 
		new ActionListener()
		{ 
			public void actionPerformed( ActionEvent e ) 
			{ 
				currentColor = JColorChooser.showDialog( Paint.this, "Choose a color", currentColor ); 

			} 
		} 
		); 

		bar.add( EditMenu );
		//여기까지 Edit 메뉴~~~~~

		//여기부터 Help메뉴~~
		JMenu HelpMenu = new JMenu("Help"); 
		HelpMenu.setMnemonic('H'); 

		JMenuItem howto = new JMenuItem("A Frame on Right");
		howto.setMnemonic( 'R' );
		HelpMenu.add ( howto );

		howto.addActionListener( 
		new ActionListener()
		{ 
			public void actionPerformed( ActionEvent e ) 
			{ 
				help();
			} 
		} 
		); 

		bar.add( HelpMenu );
		EditMenu.addSeparator(); 
		

 
		show();
	}
	
	private class PrintTest extends JFrame implements ActionListener, Printable
	{
		public PrintTest()
		{
			super("Print!");
			JButton but = new JButton("Click here to Print");
			but.addActionListener(this);
			getContentPane().add(but);
		}
		
		public void actionPerformed(ActionEvent ae)
		{
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPrintable(this);
			
			PageFormat pf = job.pageDialog(job.defaultPage());
			
			if ( job.printDialog() )
			{
				try
				{
					job.print();
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
				}
			}
		}
			
		public int print(Graphics g, PageFormat pf, int pageIndex)
		{
			if ( pageIndex != 0 )
			{
				return NO_SUCH_PAGE;
			}
			Graphics g2 = (Graphics2D)g;
			g2.translate ((int)pf.getImageableX(),(int)pf.getImageableY());
			paint(g2);
			
			return PAGE_EXISTS;
		}
	}
	
	public void printnow()
	{
		JFrame f = new PrintTest();
		f.setSize(100,100);
		f.setLocation(300,300);
		f.setVisible(true);
	}
		
	public void help()
    {
        HelpDialog helpme = new HelpDialog( this );

        helpme.setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
	//	helpme.setSize(700,700);
        helpme.setResizable( false );
        helpme.setLocation( new Point( 250, 250 ) );
        helpme.show();
    }


    private class HelpDialog extends JDialog     
    {
        Font defFont;
        JButton okButton;

        public HelpDialog(JFrame f)
        {
            super(f, "Help! How can I use it??", true);
        }

   
				public void show()
				{
					JPanel panel = new JPanel();
					Container c = getContentPane();

					Border endofpane = BorderFactory.createEmptyBorder(0,0,0,0);
					Border etched = BorderFactory.createEtchedBorder();

					panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );
					panel.setBorder( endofpane );
					c.setLayout( new BoxLayout( c, BoxLayout.Y_AXIS ) );

					okButton = new JButton( "OK" ); okButton.setFont( new Font( "Sanserif", Font.BOLD, 12) );

					ButtonHandler buttonHandler = new ButtonHandler();
					okButton.addActionListener( buttonHandler );

					Box lines[] = new Box[30];
					for(int i=0; i < lines.length; i++)
					lines[i] = Box.createHorizontalBox();

					JLabel pencil = new JLabel( "Pencil    : Draws with Pencil" );
					pencil.setFont( new Font( "Sanserif", Font.BOLD, 13) );
					lines[0].add( pencil );

					JLabel line = new JLabel  ( "Line      : Draws a line " );
					line.setFont( new Font( "Sanserif", Font.BOLD, 13) );
					lines[1].add( line );

					JLabel eraser = new JLabel( "Eraser (Special!!)   : Uses eraser to lessen the color " );
					eraser.setFont( new Font( "Sanserif", Font.BOLD, 13) );
					eraser.setForeground( Color.red );
					lines[2].add( eraser );
					
					JLabel white = new JLabel ( "White-Out : Perfactly cleans what you have drawn" );
					white.setFont( new Font( "Sanserif", Font.BOLD, 13) );
					lines[3].add( white );
					
					JLabel oval = new JLabel  ( "Oval      : Draws an Oval " );
					oval.setFont( new Font( "Sanserif", Font.BOLD, 13) );
					lines[4].add( oval );
					
					JLabel rect = new JLabel  ( "Rectangle : Draws a rectangle" );
					rect.setFont( new Font( "Sanserif", Font.BOLD, 13) );
					lines[5].add( rect );
					
					JLabel New = new JLabel  ( "New : Draw a new picture" );
					New.setFont( new Font( "Sanserif", Font.BOLD, 13) );
					lines[6].add( New );
					
					JLabel Change = new JLabel  ( "Change Color : Changes Color" );
					rect.setFont( new Font( "Sanserif", Font.BOLD, 13) );
					lines[7].add( rect );

					JLabel DCFS = new JLabel  ( "Draw Color Filled Shape : Check to draw a shape with color filled" );
					DCFS.setFont( new Font( "Sanserif", Font.BOLD, 13) );
					lines[8].add( DCFS );
					
					JLabel border = new JLabel  ( "Border : Check to draw a border around color filled shape" );
					border.setFont( new Font( "Sanserif", Font.BOLD, 13) );
					lines[9].add( border );
					
					lines[10].add( okButton );
					 for( int i=0; i<lines.length; i++ )
					 {
							panel.add( lines[i] );
							panel.add( Box.createRigidArea( new Dimension( 12, 8 ) ) );
					 }
						c.add( panel );
						setSize( 500, 360 );
						super.show();
				}			
			private class ButtonHandler implements ActionListener
			{
				public void actionPerformed( ActionEvent e )
				{
					if ( e.getSource() == okButton )
					   dispose();

				}
			}
		}
		
		
		//			JLabel check = new JLabel  ( "Draw Color Filled Shape : Check to Draw a shape with color filled" );
		//			check.setFont( new Font( "Sanserif", Font.BOLD, 10) );
		//			lines[6].add( check );

	private abstract class Shape extends JButton implements ActionListener
	{ 
		public Shape(String name)
		{ 
			super(name); 
			setMargin(new Insets(0,0,0,0));
			addActionListener(this); 
		} 

		public abstract void draw(Graphics g, int a, int b, int c, int d); 

		public void actionPerformed(ActionEvent e)
		{ 
			currentShape = this; 
			
			if(this==n){
				clearImage();
			}
		} 	
	} 
	
	private void clearImage()
	{
		Graphics g=image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0,0,1000,1000);
		p2.repaint();
	
	}
	private class Pencil extends Shape //연필~~
	{
		int x1,y1,x2,y2;
		public Pencil()
		{ 
			super("Pencil"); 
		} 
		public void draw (Graphics g, int a, int b, int c, int d)
		{ 
			if (isFirstTime)		
			{
				x1=x2=a;y1=y2=b;
				isFirstTime=false;
			}
			else
			{
				if (flag)
				{
					x1=c;y1=d;
				}
				else
				{
					x2=c;y2=d;
				}
			}
		//	System.out.println("x1 : "+x1+" y1 : "+y1+"x2 : "+x2+" y2 : "+y2);
			g.drawLine(x1,y1,x2,y2);
		}  //요기까지..
	}
	
	private class Eraser extends Shape //Eraser
	{
		int x1,y1,x2,y2;
		public Eraser()
		{ 
			super("Eraser"); 
		} 
		public void draw (Graphics g, int a, int b, int c, int d)
		{ 
			if (isFirstTime)		
			{
				x1=x2=a;y1=y2=b;
				isFirstTime=false;
			}
			else
			{
				if (flag)
				{
					x1=c;y1=d;
				}
				else
				{
					x2=c;y2=d;
				}
			}
		//	System.out.println("x1 : "+x1+" y1 : "+y1+"x2 : "+x2+" y2 : "+y2);
			g.setColor(Color.white);
			g.drawLine(x1,y1,x2,y2);
			g.drawLine(x1+1,y1+1,x2+3,y2+1);
			g.drawLine(x1-1,y1-1,x2-1,y2-1);
			g.drawLine(x1+2,y1+2,x2+2,y2+2);
			g.drawLine(x1-2,y1-2,x2-2,y2-2);
			g.drawLine(x1+3,y1+3,x2+3,y2+3);
			g.drawLine(x1-3,y1-3,x2-3,y2-3);
		}  
	}

	private class WhiteOut extends Shape //White-out
	{
		int x1,y1,x2,y2;
		public WhiteOut()
		{ 
			super("White Out"); 
		} 
		public void draw (Graphics g, int a, int b, int c, int d)
		{ 
			Graphics2D gg=(Graphics2D)g;

			if (isFirstTime)		
			{
				x1=x2=a;y1=y2=b;
				isFirstTime=false;
			}
			else
			{
				if (flag)
				{
					x1=c;y1=d;
				}
				else
				{
					x2=c;y2=d;
				}
			}
		//	System.out.println("x1 : "+x1+" y1 : "+y1+"x2 : "+x2+" y2 : "+y2);
			gg.setColor(Color.white);
			gg.setStroke(new BasicStroke(10.0f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
			gg.drawLine(x1,y1,x2,y2);
		}  
	}
	private class New extends Shape //버튼!!
	{
		public New()
		{
			super("New");
		}

		public void draw (Graphics g, int a, int b, int c, int d)
		{
		}

	} //요기까지~

	private class Line extends Shape
	{ 
		public Line()
		{ 
			super("Line"); 
		} 

		public void draw (Graphics g, int a, int b, int c, int d)
		{ 
			g.drawLine(a,b,c,d); 
		} 

	} 

	private class Oval extends Shape
	{ 
		public Oval()
		{ 
			super("Oval"); 
		} 

		public void draw (Graphics g, int a, int b, int c, int d)
		{ 
			int w = (c > a)?c - a:a - c; 
			int h = (d > b)?d - b:b - d; 
			if(check == 0)
				g.drawOval((c>a)?a:c,(d>b)?b:d,w,h);
			else
				g.fillOval((c>a)?a:c,(d>b)?b:d,w,h); 
			if (check2 == 1 && check == 1)
			{
				g.setColor(Color.black);	
				g.drawOval((c>a)?a:c,(d>b)?b:d,w,h);
			}	
		} 

	} 

	private class Rectangle extends Shape
	{ 
		public Rectangle()
		{ 
			super("Rectangle"); 
		} 

		public void draw (Graphics g, int a, int b, int c, int d)
		{ 
			int w = (c > a)?c - a:a - c; 
			int h = (d > b)?d - b:b - d; 
			if(check == 0)
				g.drawRect((c>a)?a:c,(d>b)?b:d,w,h);
			else
				g.fillRect((c>a)?a:c,(d>b)?b:d,w,h); 
			if (check2 == 1 && check == 1 ) 	
			{
				g.setColor(Color.black);
				g.drawRect((c>a)?a:c,(d>b)?b:d,w,h);
			}
		} 
	
	} 

	private class DRect extends Shape
	{ 
		public DRect()
		{ 
			super("H 3D-Rect"); 
		} 

		public void draw (Graphics g, int a, int b, int c, int d)
		{ 
			int w = (c > a)?c - a:a - c; 
			int h = (d > b)?d - b:b - d; 
			if(check == 0)
				g.draw3DRect((c>a)?a:c,(d>b)?b:d,w,h,true);
			else
				g.fill3DRect((c>a)?a:c,(d>b)?b:d,w,h,true); 
		} 
	}   
	private class DRect2 extends Shape
	{ 
		public DRect2()
		{ 
			super("L 3D-Rect"); 
		} 

		public void draw (Graphics g, int a, int b, int c, int d)
		{ 
			int w = (c > a)?c - a:a - c; 
			int h = (d > b)?d - b:b - d; 
			if(check == 0)
				g.draw3DRect((c>a)?a:c,(d>b)?b:d,w,h,false);
			else
				g.fill3DRect((c>a)?a:c,(d>b)?b:d,w,h,false); 
		} 
	} 

	private class Round extends Shape
	{ 
		public Round()
		{ 
			super("RoundRect"); 
		} 

		public void draw (Graphics g, int a, int b, int c, int d)
		{ 
			int w = (c > a)?c - a:a - c; 
			int h = (d > b)?d - b:b - d; 
			if(check == 0)
				g.drawRoundRect((c>a)?a:c,(d>b)?b:d,w,h,30,30);
			else
				g.fillRoundRect((c>a)?a:c,(d>b)?b:d,w,h,30,30); 
			if (check2 == 1 && check == 1 ) 	
			{
				g.setColor(Color.black);
				g.drawRoundRect((c>a)?a:c,(d>b)?b:d,w,h,30,30);
			}	
		} 
	} 

	private class ColorButton extends JButton
	{
		public ColorButton()
		{
			super("Change Color");

			addActionListener
			(
				new ActionListener()
				{
					public void actionPerformed( ActionEvent e)
					{
						currentColor = JColorChooser.showDialog( Paint.this, "Choose a color",currentColor);
				
						if( currentColor == null)
							currentColor = Color.black;
					
					}
				}
			);
		}
	}

	private class CustomPanel extends JPanel 
	{ 
		private int startx, starty; 
		private int lastx, lasty; 


		public CustomPanel() 
		{ 
			MouseKeeper k = new MouseKeeper(); 
			addMouseListener(k); 
			addMouseMotionListener(k); 
		} 

		public void paintComponent( Graphics g ) 
		{ 
			super.paintComponent( g ); 
			if(image == null) 
			{
				image = createImage(1000,1000);
				Graphics g2 = image.getGraphics();
				g2.setColor(Color.white);
				g2.fillRect(0,0,1000,1000);
			}

			if(image != null) 
			g.drawImage(image,0,0,this); 

		} 
	
		private class MouseKeeper extends MouseAdapter implements MouseMotionListener
		{ 

			private void drawShape( Graphics g ) 
			{ 

				g.setColor(currentColor);
				if(currentShape != null) 
				currentShape.draw(g, startx, starty, lastx, lasty); 
			} 

			public void mousePressed(MouseEvent e)
			{ 
				lastx = startx = e.getX(); 
				lasty = starty = e.getY(); 
			} 	

			public void mouseDragged(MouseEvent e)
			{ 
				flag=!flag;
				Graphics g = image.getGraphics(); 

				if(isFirstTime)
					g.setXORMode(Color.white); 
				drawShape(g); 
				lastx = e.getX(); 
				lasty = e.getY(); 
				drawShape(g); 
				repaint(); 
			} 

			public void mouseReleased(MouseEvent e)
			{ 
				Graphics g = image.getGraphics(); 
				g.setXORMode(Color.white); 
				drawShape(g); 
				g.setPaintMode(); 
				lastx = e.getX(); 
				lasty = e.getY(); 
				drawShape(g); 
				repaint(); 
				isFirstTime=true;
				flag=false;


			} 
		
			public void mouseMoved(MouseEvent e){} 

		} 
	} 

	public static void main(String args[])
	{ 
		JFrame world = new Paint(); 
		world.addWindowListener
		(	
			new WindowAdapter()
			{		
				public void windowClosing( WindowEvent e)
				{
					System.exit(0);
				}
			}	
		);
	}
 
}  
