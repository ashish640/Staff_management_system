
package view;

import Model.staff;
import dao.dao;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class View1 implements ActionListener
{
	JFrame f;
	JTextField t;
	JLabel l1,l2;
	JButton b,b2;
	View1()
	{
		f=new JFrame("View");
		f.setBackground(Color.green);
		f.setLayout(null);
		//f.setDefaultCloseOperation(EXIT_ON_CLOSE);

		l1=new JLabel();
		l1.setBounds(600,150,800,600);
		l1.setLayout(null);
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Images/d1.jpg"));
		l1.setIcon(img);

		l2=new JLabel("STAFF ID");
		l2.setVisible(true);
		l2.setBounds(40,15,250,300);//40,-70,250,300
		l2.setForeground(Color.black);
		Font f1=new Font("Times New Roman",Font.BOLD,30);
		l2.setFont(f1);
		l1.add(l2);
		f.add(l1);

		t=new JTextField();
		t.setBounds(240,150,220,30);
		l1.add(t);

		b=new JButton("Search");
		b.setBounds(240,250,100,30);
		b.addActionListener(this);
		l1.add(b);

		b2=new JButton("Cancel");
		b2.setBounds(360,250,100,30);
		b2.addActionListener(this);
		l1.add(b2);

		f.setSize(1920,1080);
		//f.setLocation(450,250);
		f.setLocationRelativeTo(null);
                f.setVisible(true);


	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b2)
		{
			f.setVisible(false);
		}

		if(ae.getSource() == b)
		{
			//new Printdata();
                    dao d=new dao();
                    try {
                        staff s=d.getstaff(Integer.parseInt(t.getText()));
                        if(s!=null)
                        {
                         new Printdata(s);
                         f.setVisible(false);
                        }
                        else
                        {
                        JOptionPane.showMessageDialog(null,"SORRY ! DATA NOT FOUND");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(View1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
		}
	}
	public static void main(String args[])
	{
		View1 v=new View1();
	}
}

