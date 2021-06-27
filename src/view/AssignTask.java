
package view;



import Model.Classs;
import Model.salary;
import Model.staff;
import Model.task;
import dao.dao;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.script.*;

class AssignTask extends JFrame implements ActionListener
{

JTextField t1,t2;
JButton b,ed,s;
JLabel j1,j2,j3,j4,j5;
JComboBox jc1,jc2;
JTextArea t3;
AssignTask()
{

// j5=new JLabel();
// 		j5.setBounds(0,150,1920,1080); //0,0,800,600
// 		j5.setLayout(null);
// 		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("sal.jfif"));
// 		j5.setIcon(img);
		

setTitle("TASK");
setVisible(true);
setLayout(null);
setSize(1920,1080);
//add(j5);
Font f1=new Font("Times New Roman",Font.BOLD,20);

		


setLocation(0,0);
//Font f=new Font("Forte",Font.BOLD,20);
setDefaultCloseOperation(EXIT_ON_CLOSE);

ed=new JButton("ASSIGN TASK");
ed.setFont(f1);
ed.setSize(1920,35);
ed.setLocation(0,5);
add(ed);


j1=new JLabel("STAFF ID");
j1.setFont(f1);
j1.setLocation(60,180);
j1.setSize(300,30);
add(j1);

j2=new JLabel("TASK NAME");
j2.setFont(f1);
j2.setLocation(60,240);
j2.setSize(300,30);
add(j2);

j3=new JLabel("DESCRIPTION");
j3.setFont(f1);
j3.setLocation(60,300);
j3.setSize(300,30);
add(j3);




jc1=new JComboBox();
jc1.setFont(f1);
jc1.setLocation(300,180);
jc1.setSize(300,30);
try {
    dao d=new dao(); 
    java.util.List<staff> l3=new ArrayList<staff>();
    l3 = d.getallstaff();
        for(staff a:l3)
        {
            String s4=a.getName();
            jc1.addItem(a.getStaff_id()+"  -  " +s4);
            
            System.out.println(a.getName());
        } 
        //jc4.setSelectedIndex(-1);
        
    } catch (SQLException ex) {
        Logger.getLogger(Salary1.class.getName()).log(Level.SEVERE, null, ex);
    }
add(jc1);




t1=new JTextField(30);
t1.setFont(f1);
t1.setLocation(300,240);
t1.setSize(300,30);
add(t1);



t3=new JTextArea();
t3.setBounds(300,300, 300,100);  
t3.setFont(f1);

add(t3);

b=new JButton("ASSIGN");
b.setFont(f1);
b.setLocation(150,500);
b.setSize(200,30);
add(b);
b.addActionListener(this);

s=new JButton("CANCEL");
s.setFont(f1);
s.setLocation(450,500);
s.setSize(200,30);
add(s);
s.addActionListener(this);

}

public void actionPerformed(ActionEvent e)
{
if(e.getSource() == b)
{
    try{
     String s2=jc1.getSelectedItem().toString();
    String a[]=s2.split(" ");
    String staffid=a[0];
    dao d=new dao();
    task t=new task();
    
    
  t.setTask_id(d.Task_Id_Increment());
  t.setStaff_id(Integer.parseInt(staffid));
  t.setTask_name(t1.getText());
  
  t.setTask_description(t3.getText().replace("\n"," "));
  t.setTask_status("Pending");
  
        System.out.println(t3.getText());
  
  if(d.Addtask(t)>0)
  {
  JOptionPane.showMessageDialog(null,"TASK ASSIGN SUCCESSFULLY");
  setVisible(false);
  }
  else
  {
  JOptionPane.showMessageDialog(null,"SORRY !!TASK NOT ASSIGN");
  }
 }
 
 catch(Exception a)
 {
 JOptionPane.showMessageDialog(null,a);
 }    
    setVisible(false);
}

if(e.getSource() == s)
{
	setVisible(false);
}
}

public static void main(String args[])
{
AssignTask s1=new AssignTask();
Container c=s1.getContentPane();
c.setBackground(Color.gray);
}
}


