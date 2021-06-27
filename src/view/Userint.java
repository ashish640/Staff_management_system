
package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Thread;
import javax.swing.ImageIcon;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Userint extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,bi;
	public Userint()
	{       Font f=new Font("Times New Roman",Font.BOLD,25);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		b1=new JButton("Add Staff");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(10,40,290,50);//10,30,200,40
		b1.addActionListener(this);
                b1.setFont(f);
		add(b1);
		
		b2=new JButton("View Staff");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(10,120,290,50);
		b2.addActionListener(this);
                b2.setFont(f);
		add(b2);

		b3=new JButton("Remove Staff");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(10,200,290,50);
		b3.addActionListener(this);
                b3.setFont(f);
		add(b3);

		b4=new JButton("Upadate Staff");
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.setBounds(10,280,290,50);
		b4.addActionListener(this);
                b4.setFont(f);
		add(b4);

		b5=new JButton("Add Class");
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.setBounds(10,360,290,50);
		b5.addActionListener(this);
                b5.setFont(f);
		add(b5);
                
                bi=new JButton("Update Class");
		bi.setBackground(Color.BLACK);
		bi.setForeground(Color.WHITE);
		bi.setBounds(10,440,290,50);
		bi.addActionListener(this);
                bi.setFont(f);
		add(bi);

		b6=new JButton("Salary");
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		b6.setBounds(10,520,290,50);
		b6.addActionListener(this);
                b6.setFont(f);
		add(b6);

		b7=new JButton("Salary Report");
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);
		b7.setBounds(10,600,290,50);
		b7.addActionListener(this);
                b7.setFont(f);
		add(b7);

		b8=new JButton("Task");
		b8.setBackground(Color.BLACK);
		b8.setForeground(Color.WHITE);
		b8.setBounds(10,680,290,50);
		b8.addActionListener(this);
                b8.setFont(f);
		add(b8);

		b9=new JButton("Logout");
		b9.setBackground(Color.BLACK);
		b9.setForeground(Color.WHITE);
		b9.setBounds(10,760,290,50);
		b9.addActionListener(this);
                b9.setFont(f);
		add(b9);

		

	    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/dashboard3.jpg"));
	    JLabel l1=new JLabel(i1);
	    l1.setBounds(150,-115,1920,1080);//250,30,500,470
	    add(l1);
		

		getContentPane().setBackground(Color.WHITE);

		setLayout(null);
		setSize(1920,1080);
                setLocationRelativeTo(null);
		setVisible(true);

	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
			
                    try {
                        EDetails ld=new EDetails();
                    } catch (SQLException ex) {
                        Logger.getLogger(Userint.class.getName()).log(Level.SEVERE, null, ex);
                    }

		}
		else if(ae.getSource()==b2)
		{
			View1 v=new View1();
		}
		else if(ae.getSource()==b3)
		{
			new Remove1();
                        //setVisible(false);

		}
		else if(ae.getSource()==b4)
		{
		 new Search1();	
		}
		else if(ae.getSource()==b5)
		{
		new AClass();	
		}
		else if(ae.getSource()==b6)
		{
                    try {	
                        new Salary1();
                    } catch (SQLException ex) {
                        Logger.getLogger(Userint.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
		else if(ae.getSource()==b7)
		{
			new SalaryReport();
		}
		else if(ae.getSource()==b8)
		{
			new Task();
		}
		else if(ae.getSource()==b9)
		{
                    new Login();
                    setVisible(false);
		}
                else if(ae.getSource()==bi)
		{
                    try {
                        //setVisible(false);
                        new UpdateClass();
                    } 
                    catch (SQLException ex) {
                        
                    }
		}
	}
 

	public static void main(String args[])
	{
		new Userint().setVisible(true);
	}
}

