 
package view;

import Model.Classs;
import Model.staff;
import dao.dao;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.script.*;

class EDetails extends JFrame implements ActionListener
{



String s[]={"Name","Email","Mobile","Degree","Designation","Address","City","Class","Basic Pay","Salary","DOB","Gender"};
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
JRadioButton rb1,rb2;
ButtonGroup g;
JComboBox jc1,jc2,jc3,jc;
JButton b,ed,b1;
JLabel j[]=new JLabel[12];
JPasswordField p;
int k=0;
int x,y;
//int w=300;int h=80;
EDetails() throws SQLException
{
setTitle("Registration Page");
setVisible(true);
setLayout(null);
setSize(1920,1080);


//setLocation(100,0);
setLocationRelativeTo(null);
Font f=new Font("Times New Roman",Font.BOLD,20);
setDefaultCloseOperation(EXIT_ON_CLOSE);
x=10;
y=100;
for(int i=0;i<=6;i++)
{
j[k]=new JLabel(s[k]);

j[k].setFont(f);
j[k].setSize(300,40);
j[k].setLocation(x,y);
add(j[k]);
x=10;
y=y+60;
k++;

}

x=600;
y=100;
for(int i=8;i<=12;i++)
{
j[k]=new JLabel(s[k]);

j[k].setFont(f);
j[k].setSize(300,40);
j[k].setLocation(x,y);
add(j[k]);
x=600;
y=y+60;
k++;

}

ed=new JButton("ADD NEW STAFF");
ed.setFont(f);
ed.setSize(1920,60);
ed.setLocation(0,5);
add(ed);

t1=new JTextField(30);
t1.setFont(f);
t1.setLocation(200,100);
t1.setSize(300,30);
add(t1);

t2=new JTextField(30);
t2.setFont(f);
t2.setLocation(200,160);
t2.setSize(300,30);
add(t2);

t3=new JTextField(30);
t3.setFont(f);
t3.setLocation(200,220);
t3.setSize(300,30);
add(t3);

t4=new JTextField(30);
t4.setFont(f);
t4.setLocation(200,280);
t4.setSize(300,30);
add(t4);

t5=new JTextField(30);
t5.setFont(f);
t5.setLocation(200,340);
t5.setSize(300,30);
add(t5);

t6=new JTextField(30);
t6.setFont(f);
t6.setLocation(200,400);
t6.setSize(300,30);
add(t6);

t7=new JTextField(30);
t7.setFont(f);
t7.setLocation(200,460);
t7.setSize(300,30);
add(t7);


//t9=new JTextField(30);
//t9.setFont(f);
//t9.setLocation(800,60);
//t9.setSize(300,30);
//add(t9);
dao d=new dao();
jc=new JComboBox();
jc.setFont(f);
jc.setLocation(800,100);
jc.setSize(300,30);
for(String s:d.getAllClasses())
{
jc.addItem(s);
}
add(jc);
jc.addActionListener(this);

t10=new JTextField(30);
t10.setFont(f);
t10.setLocation(800,160);
t10.setSize(300,30);
add(t10);

t11=new JTextField(30);
t11.setFont(f);
t11.setLocation(800,220);
t11.setSize(300,30);
add(t11);


//Font f=new Font("Forte",Font.BOLD,20);

jc1=new JComboBox();
jc1.setFont(f);
jc1.setLocation(800,280);
jc1.setSize(50,30);
for(int i=1;i<=31;i++){jc1.addItem(""+i);}
add(jc1);
jc2=new JComboBox();
jc2.setFont(f);
jc2.setLocation(850,280);
jc2.setSize(40,30);
for(int j=1;j<=12;j++){jc2.addItem(""+j);}
add(jc2);
jc3=new JComboBox();
jc3.setFont(f);
jc3.setLocation(900,280);
jc3.setSize(80,30);
for(int k=1980;k<=2002;k++){jc3.addItem(""+k);}
add(jc3);


g=new ButtonGroup();
rb1=new JRadioButton("Male");
rb1.setFont(f);
rb1.setLocation(800,340);
rb1.setSize(100,30);
rb1.setActionCommand("Male");
g.add(rb1);
add(rb1);
rb2=new JRadioButton("Female");
rb2.setFont(f);
rb2.setLocation(910,340);
rb2.setSize(100,30);
rb2.setActionCommand("Female");
g.add(rb2);
add(rb2);





b=new JButton("ADD");
b.setFont(f);
b.setLocation(550,650);
b.setSize(120,40);
add(b);
b.addActionListener(this);


b1=new JButton("Cancel");
b1.setFont(f);
b1.setLocation(700,650);
b1.setSize(120,40);
add(b1);
b1.addActionListener(this);

}
 
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource() == b1)
{

setVisible(false);
 }

if(ae.getSource() == jc)
{
Classs s=new Classs();
        try {
            dao d=new dao();
            s=d.getClasssByname((String) jc.getSelectedItem());
            t10.setText(s.getBasic_pay()+ "");
            t11.setText((s.getBasic_pay()+ s.getMa() + s.getRa()+s.getTa())+ "");
            t10.setEditable(false);
            t11.setEditable(false);
        } catch (SQLException ex) {
            
        }
//setVisible(false);
 }

if(ae.getSource() == b)
{
 try{
   staff s=new staff();
  dao d=new dao();
  s.setStaff_id(d.Staff_Id_Increment());
  s.setClass_id(d.getClasssByname(jc.getSelectedItem().toString()).getClass_id());
  s.setName(t1.getText());
  s.setEmail(t2.getText());
  s.setMobile(t3.getText());
  s.setDegree(t4.getText());
  s.setDesignation(t5.getText());
  s.setAddress(t6.getText());
  s.setCity(t7.getText());
  s.setDOB(jc1.getSelectedItem().toString()+ "/" +jc2.getSelectedItem().toString()+"/"+jc3.getSelectedItem().toString());
  s.setGender(g.getSelection().getActionCommand());
  if(d.Addstaff(s)>0)
  {
  JOptionPane.showMessageDialog(null,"Staff Added Successfully");
  setVisible(false);
  }
  else
  {
  JOptionPane.showMessageDialog(null,"Not Added");
  }
 }
 catch(Exception e)
 {
 JOptionPane.showMessageDialog(null,e);
 }
}
}

public static void main(String args[])
{
EDetails ld=null;
    try {
        ld = new EDetails();
    } catch (SQLException ex) {
        Logger.getLogger(EDetails.class.getName()).log(Level.SEVERE, null, ex);
    }
Container c=ld.getContentPane();
c.setBackground(Color.gray);
}
 }




