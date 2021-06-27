
package view;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Thread;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class FrontPage implements ActionListener
{
	public JFrame f;
	JLabel id,l1;
	JButton b;
    //JMenuItem i1, i2, i3, i4, i5;
    //JMenu menu;  
	public FrontPage()
	{     
		  
//	JMenuBar mb=new JMenuBar(); 
//        menu=new JMenu("Menu");  
//        i1=new JMenuItem("Item 1");  
//          i2=new JMenuItem("Item 2");  
//          i3=new JMenuItem("Item 3");  
//          i4=new JMenuItem("Item 4");  
//          i5=new JMenuItem("Item 5");
//          menu.add(i1); 
//          menu.add(i2); 
//          menu.add(i3);
//          menu.add(i4);
//          menu.add(i5);  
//          mb.add(menu); 
//          i1.addActionListener(new ActionListener(){
//          	public void actionPerformed(ActionEvent ae)
//          	{
//          	Login obj=new Login();
//          	//obj.setVisible(true);	
//          	}
//          });
          

		f=new JFrame("STAFF MANAGEMENT SYSTEM");
                f.setDefaultCloseOperation(EXIT_ON_CLOSE);

		f=new JFrame("STAFF MANAGEMENT SYSTEM");
		f.setBackground(Color.red);
                
		f.setLayout(null);

		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/front.jpg"));
		Image i2=i1.getImage().getScaledInstance(1920,700,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l1=new JLabel(i3);

		l1.setBounds(0,100,1920,700);
		f.add(l1);

		b=new JButton("Click Here to Continue");
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);

		b.setBounds(650,680,400,70);//500,600,300,70
		b.addActionListener(this);

		id=new JLabel();
		id.setBounds(0,0,1360,750);
		id.setLayout(null);

		JLabel lid=new JLabel("STAFF MANAGEMENT SYSTEM");
		lid.setBounds(450,10,1500,80);//200,30,1500,100
		lid.setFont(new Font("serif",Font.PLAIN,60));
		lid.setForeground(Color.blue);
		id.add(lid);

		id.add(b);
		f.add(id);
		//f.setJMenuBar(mb);

		f.setVisible(true);
		f.setSize(1920,1080);//1360,750
                f.setLocationRelativeTo(null);
		//f.setLocation(200,100);

		while(true)
		{
			lid.setVisible(false);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e)
			{

			}
			lid.setVisible(true);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e)
			{

			}
		}
	
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b)
		{
			f.setVisible(false);
			new Login();
		}
		
	}

public static void main(String args[])
{
	FrontPage f1=new FrontPage();
}
}
