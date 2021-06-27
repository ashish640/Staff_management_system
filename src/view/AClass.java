
package view;

import Model.Classs;
import Model.staff;
import dao.dao;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
//import javax.script.*;

class AClass extends JFrame implements ActionListener
{



String s[]={"Class name","Basic pay","Salary","TravelAllowance","MedicalAllowance","RentalAllowance"};
JTextField t1,t2,t3,t4,t5,t6;
JButton b,ed,b1;
JLabel j[]=new JLabel[6];
JComboBox jc1;
int k=0;
int x,y;
//int w=300;int h=80;
AClass()
{
setTitle("Registration page");
setVisible(true);
setLayout(null);
setSize(1920,1080);


//setLocation(100,0);
setLocationRelativeTo(null);
Font f=new Font("Times New Roman",Font.BOLD,20);
setDefaultCloseOperation(EXIT_ON_CLOSE);
x=60;
y=120;
for(int i=0;i<=5;i++)
{
j[k]=new JLabel(s[k]);

j[k].setFont(f);
j[k].setSize(300,40);
j[k].setLocation(x,y);
add(j[k]);
x=60;
y=y+60;
k++;

}
ed=new JButton("Add Class");
ed.setFont(f);
ed.setSize(1920,35);
ed.setLocation(0,5);
add(ed);

//jc1=new JComboBox();
//jc1.setFont(f);
//jc1.setLocation(300,120);
//jc1.setSize(300,30);
//for(int i=1;i<=3;i++){jc1.addItem("CLASS"+i);}
//add(jc1);
t1=new JTextField(30);
t1.setFont(f);
t1.setLocation(300,120);
t1.setSize(300,30);
add(t1);

t2=new JTextField(30);
t2.setFont(f);
t2.setLocation(300,180);
t2.setSize(300,30);
add(t2);

t3=new JTextField(30);
t3.setFont(f);
t3.setLocation(300,240);
t3.setSize(300,30);
add(t3);

t4=new JTextField(30);
t4.setFont(f);
t4.setLocation(300,300);
t4.setSize(300,30);
add(t4);

t5=new JTextField(30);
t5.setFont(f);
t5.setLocation(300,360);
t5.setSize(300,30);
add(t5);

t6=new JTextField(30);
t6.setFont(f);
t6.setLocation(300,420);
t6.setSize(300,30);
add(t6);

b=new JButton("Add Class");
b.setFont(f);
b.setLocation(350,550);
b.setSize(200,30);
add(b);
b.addActionListener(this);

b1=new JButton("Cancel");
b1.setFont(f);
b1.setLocation(600,550);
b1.setSize(200,30);
add(b1);
b1.addActionListener(this);

}

public void actionPerformed(ActionEvent e)
{
if(e.getSource() == b1)
{
	setVisible(false);
}
if(e.getSource() == b)
{
try{
  Classs c=new Classs();
  dao d=new dao();
  
  c.setClass_id(d.Class_Id_Increment());
  c.setClass_Name(t1.getText());
  c.setBasic_pay(Integer.parseInt(t2.getText()));
  c.setTa(Integer.parseInt(t4.getText()));
  c.setMa(Integer.parseInt(t5.getText()));
  c.setRa(Integer.parseInt(t6.getText()));
  
  if(d.AddClass(c)>0)
  {
  JOptionPane.showMessageDialog(null,"CLASS ADDED SUCCESSFULLY !!!");
  setVisible(false);
  }
  else
  {
  JOptionPane.showMessageDialog(null,"SORRY ! CLASS NOT ADDED");
  }
 }
 catch(Exception ae)
 {
 JOptionPane.showMessageDialog(null,ae);
 }	
}

}

public static void main(String args[])
{
AClass ld=new AClass();
Container c=ld.getContentPane();
c.setBackground(Color.gray);
}
}


