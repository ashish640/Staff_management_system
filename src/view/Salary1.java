
package view;


import Model.Classs;
import Model.salary;
import Model.staff;
import dao.dao;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.*;
//import java.awt.event.*;
//import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import javax.script.*;

class Salary1 extends JFrame implements ActionListener
{

JTextField t1,t2,t3;
JButton b,ed,b2;
JLabel j1,j2,j3,j4;
JComboBox jc1,jc2,jc3;
JComboBox<String> jc4;
Salary1() throws SQLException
{
setTitle("Registration page");
setVisible(true);
setLayout(null);
setSize(1920,1080);
Font f1=new Font("Times New Roman",Font.BOLD,20);


//setLocation(100,0);
setLocationRelativeTo(null);
//Font f=new Font("Forte",Font.BOLD,20);
setDefaultCloseOperation(EXIT_ON_CLOSE);

ed=new JButton("Generate Salary");
ed.setFont(f1);
ed.setSize(1920,35);
ed.setLocation(0,5);
add(ed);


j1=new JLabel("Select Class");
j1.setFont(f1);
j1.setLocation(60,180);
j1.setSize(300,30);
add(j1);

j2=new JLabel("Month");
j2.setFont(f1);
j2.setLocation(60,240);
j2.setSize(300,30);
add(j2);

j3=new JLabel("Current year");
j3.setFont(f1);
j3.setLocation(60,300);
j3.setSize(300,30);
add(j3);

j4=new JLabel("Select Staff/ID");
j4.setFont(f1);
j4.setLocation(60,360);
j4.setSize(300,30);
add(j4);

dao d=new dao();
jc1=new JComboBox();
jc1.setFont(f1);
jc1.setLocation(300,180);
jc1.setSize(300,30);
jc1.addActionListener(this);
jc1.addItem("Select Class");
    
        for(String s:d.getAllClasses())
        {
            jc1.addItem(s);
        }
        //jc1.setSelectedIndex(-1);
jc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              dao d=new dao();
              jc4.removeAllItems();
              jc4.addItem("Select staff");
              

    List<staff> l3=new ArrayList<staff>();
    
    try {
        l3 = d.getallstaffbyclass(d.getClasssByname((String)jc1.getSelectedItem()).getClass_id());
        for(staff a:l3)
        {
            String s4=a.getName();
            jc4.addItem(a.getStaff_id()+"  -  " +s4);
            
            //System.out.println(a.getName());
        } 
        //jc4.setSelectedIndex(-1);
        
    } catch (SQLException ex) {
        Logger.getLogger(Salary1.class.getName()).log(Level.SEVERE, null, ex);
    }
            }
        });
        
    
add(jc1);


jc2=new JComboBox();
jc2.setFont(f1);
jc2.setLocation(300,240);
jc2.setSize(300,30);

	jc2.addItem("JANUARY");
	jc2.addItem("FEBRUARY");
	jc2.addItem("MARCH");
	jc2.addItem("APRIL");
	jc2.addItem("MAY");
	jc2.addItem("JUNE");
	jc2.addItem("JULY");
	jc2.addItem("AUGUST");
	jc2.addItem("SEPTEMBER");
	jc2.addItem("OCTOBER");
	jc2.addItem("NOVEMBER");
	jc2.addItem("DECEMBER");

	
add(jc2);




jc3=new JComboBox();
jc3.setFont(f1);
jc3.setLocation(300,300);
jc3.setSize(300,30);
jc3.addItem("2020");
	jc3.addItem("2021");
	jc3.addItem("2022");
	jc3.addItem("2023");
	jc3.addItem("2024");
add(jc3);


jc4=new JComboBox();
//jc4.setModel(new DefaultComboBoxModel<>(new String[]{"Ashish"}));
jc4.setFont(f1);
jc4.setLocation(300,360);
jc4.setSize(300,30);
//jc4.addItem("");
//jc4.addActionListener(this);


add(jc4);


b=new JButton("ASSIGN SALARY");
b.setFont(f1);
b.setLocation(150,450);
b.setSize(200,30);
add(b);
b.addActionListener(this);

b2=new JButton("CANCEL");
b2.setFont(f1);
b2.setLocation(450,450);
b2.setSize(200,30);
add(b2);
b2.addActionListener(this);

}
@Override
public void actionPerformed(ActionEvent e)
{
if(e.getSource() == b2)
{
	setVisible(false);
}

if(e.getSource() == b)
{
    
 try{
    String s2=jc4.getSelectedItem().toString();
    String a[]=s2.split(" ");
    String staffid=a[0];
    dao d=new dao();
    staff s=d.getstaff(Integer.parseInt(staffid));
    salary s1=new salary();
    Classs c=d.getClasssByid(s.getClass_id());
    if(d.checkSalary(Integer.parseInt(staffid),jc2.getSelectedItem().toString()+"-"+jc3.getSelectedItem().toString()))
    {
    JOptionPane.showMessageDialog(null,"ALREADY SALARY ASSIGNED FOR GIVEN MONTH");
    }
    else
    {
        
    s1.setS_id(d.Salary_Id_Increment());
    s1.setStaff_id(s.getStaff_id());
    s1.setMonth(jc2.getSelectedItem().toString()+"-"+jc3.getSelectedItem().toString());
    s1.setBasic_pay(c.getBasic_pay());
    s1.setTa(c.getTa());
    s1.setMa(c.getMa());
    s1.setRa(c.getRa());
  
  if(d.AddSalary(s1)>0)
  {
  JOptionPane.showMessageDialog(null,"SALARY ASSIGN SUCCESSFULLY");
  setVisible(false);
  }
  else
  {
  JOptionPane.showMessageDialog(null,"OOPS !! NOT ASSIGN");
  }
 }
 }
 catch(Exception a)
 {
 JOptionPane.showMessageDialog(null,a);
 }
}
}
//}

public static void main(String args[])
{
//Salary1 s1=new Salary1();
//Container c=s1.getContentPane();
//c.setBackground(Color.gray);
}

}


