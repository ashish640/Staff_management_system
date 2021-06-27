
package view;

import dao.dao;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Thread;
import javax.swing.ImageIcon;
import java.sql.*;
class Login implements ActionListener
{
	
	JFrame f;
	JLabel l1,l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;

	
	Login()
	{
		
		f=new JFrame("Login Page");
		f.setLayout(null);

		l1=new JLabel("Username");
		l1.setBounds(500,330,100,30);
                l1.setFont(new Font("serif",Font.BOLD,20));
		f.add(l1);
		f.add(l1);

		l2=new JLabel("Password");
		l2.setBounds(500,390,100,30);
                l2.setFont(new Font("serif",Font.BOLD,20));
		f.add(l2);
		f.add(l2);

		t1=new JTextField();
		t1.setBounds(700,330,150,30);
		f.add(t1);

		t2=new JPasswordField();
		t2.setBounds(700,390,150,30);
		f.add(t2);

		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/log1.jpg"));
		Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l3=new JLabel(i3);
		l3.setBounds(950,330,150,150);
		f.add(l3);

		b1=new JButton("Login");
		b1.setBounds(550,480,120,30);
		b1.setFont(new Font("serif",Font.BOLD,20));
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		f.add(b1);

		b2=new JButton("Cancel");
		b2.setBounds(750,480,120,30);
		b2.setFont(new Font("serif",Font.BOLD,20));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		f.add(b2);
		b2.addActionListener(this);

		f.setVisible(true);
		f.setSize(1920,1080);
		//f.setLocation(500,400);
                f.setLocationRelativeTo(null);
//f.setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		

	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
                    try
                    {
                      dao d=new dao();
                      String user=t1.getText();
                      String pass=t2.getText();
                      if(d.checkLogin(user, pass))
                      {
                      JOptionPane.showMessageDialog(null,"Login Successfully");
                      new Userint();
		      f.setVisible(false);
                      }
                      else
                      {
                      JOptionPane.showMessageDialog(null,"Wrong Username/Password");
                      }
                    }
                    catch(Exception e)
                    {
                    JOptionPane.showMessageDialog(null,e);
                    }
			
                        
                }

		if(ae.getSource() == b2)
		{
			f.setVisible(false);
			new FrontPage();
		}



	}
	 public static void main(String args[])
	 {
	 	Login l1=new Login();
	 }

}
