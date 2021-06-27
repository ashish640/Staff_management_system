package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;


public class Splash extends JFrame
{
//  JFrame f;
  public  JLabel l1;
  public JProgressBar jb;
  


	
	public Splash()
	{
            
                 
    
jb=new JProgressBar(0,100);    
jb.setBounds(100,100,600,100); //100,100,800,100        
jb.setValue(0);    
jb.setStringPainted(true);    
add(jb);    
setSize(900,600); 
setLocationRelativeTo(null);
setLayout(null); 

//l1=new JLabel();
//l1.setSize(1200,800);
//l1.setVisible(true);
//l1.setLayout(null);
//add(l1);
setUndecorated(true);
setTitle("My frame");
//f=new JFrame("Login 123");
//setLayout(null);
//setSize(1200,800);
//setVisible(true);

		

//		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/log1.jpg"));
//		Image i2=i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
//		ImageIcon i3=new ImageIcon(i2);
//		JLabel l3=new JLabel(i3);
//		l3.setBounds(350,20,150,150);
//		f.add(l3);

		

		

		//f.setVisible(true);
//		f.setSize(600,300);
//		f.setLocation(500,400);
		//f.setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		

	}  
}
