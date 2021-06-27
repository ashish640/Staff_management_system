
package view;


import Model.Classs;
import Model.staff;
import dao.dao;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.script.*;

class UpdateClass extends JFrame implements ActionListener
{



String s[]={"Class Name","Class ID","Basic pay","TravelAllowance","MedicalAllowance","RentalAllowance"};
JTextField t1,t2,t3,t4,t5,t6;
JButton b,ed,b1;
JLabel j[]=new JLabel[7];
//JLabel l1;
JComboBox <String>jc1;
int k=0;
int x,y;
//int w=300;int h=80;
UpdateClass() throws SQLException
{
setTitle("UPDATE CLASS");
setVisible(true);
setLayout(null);
setSize(1920,1080);




setLocation(0,0);
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
ed=new JButton("UPDATE CLASS");
ed.setFont(f);
ed.setSize(1920,35);
ed.setLocation(0,5);
add(ed);

jc1=new JComboBox();
jc1.setFont(f);
jc1.setLocation(300,120);
jc1.setSize(300,30);
//jc1.addActionListener(this);

dao d=new dao();
    
        for(String s:d.getAllClasses())
        {
            jc1.addItem(s);
        }
        jc1.setSelectedIndex(-1);
jc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              dao d=new dao();
    try {
        Classs c=d.getClasssByname((String)jc1.getSelectedItem() );
       t2.setText(c.getClass_id()+"");
        t2.setEditable(false);
        t3.setText(c.getBasic_pay()+"");
        t4.setText(c.getTa()+"");
        t5.setText(c.getMa()+"");
        t6.setText(c.getRa()+"");
    } catch (SQLException ex) {
        
    }
            }
        });
        
add(jc1);

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

b=new JButton("UPDATE");
b.setFont(f);
b.setLocation(350,550);
b.setSize(200,30);
add(b);
b.addActionListener(this);

b1=new JButton("CANCEL");
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
        
  //new Userint();
}

if(e.getSource() == b)
{
try{
  Classs c=new Classs();
  dao d=new dao();
  
  c.setClass_id(Integer.parseInt(t2.getText()));
  c.setClass_Name((String)jc1.getSelectedItem());
  c.setBasic_pay(Integer.parseInt(t3.getText()));
  c.setTa(Integer.parseInt(t4.getText()));
  c.setMa(Integer.parseInt(t5.getText()));
  c.setRa(Integer.parseInt(t6.getText()));
  
  if(d.updateclass(c)>0)
  {
  JOptionPane.showMessageDialog(null,"CLASS UPDATED SUCCESSFULLY !!!");
  setVisible(false);
  new Userint();
  }
  else
  {
  JOptionPane.showMessageDialog(null,"SORRY ! CLASS NOT UPDATED");
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
//UpdateClass ld=new UpdateClass();
//Container c=ld.getContentPane();
//c.setBackground(Color.gray);
}
}


