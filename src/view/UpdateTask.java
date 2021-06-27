
package view;


import Model.Classs;
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

class UpdateTask extends JFrame implements ActionListener
{

JTextField t1,t2,t3;
JButton b,ed,s;
JLabel j1,j2,j3,j4,j5;
JComboBox jc1,jc2,jc3;
UpdateTask()
{

// j5=new JLabel();
// 		j5.setBounds(0,150,1920,1080); //0,0,800,600
// 		j5.setLayout(null);
// 		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("sal.jfif"));
// 		j5.setIcon(img);
		

setTitle("UPDATE TASK");
setVisible(true);
setLayout(null);
setSize(1920,1080);
//add(j5);
Font f1=new Font("Times New Roman",Font.BOLD,20);

		


setLocation(0,0);
//Font f=new Font("Forte",Font.BOLD,20);
setDefaultCloseOperation(EXIT_ON_CLOSE);

ed=new JButton("UPDATE TASK");
ed.setFont(f1);
ed.setSize(1920,35);
ed.setLocation(0,5);
add(ed);


j1=new JLabel("STAFF ID");
j1.setFont(f1);
j1.setLocation(60,180);
j1.setSize(300,30);
add(j1);

j2=new JLabel("TASK ID");
j2.setFont(f1);
j2.setLocation(60,240);
j2.setSize(300,30);
add(j2);

j3=new JLabel("Current Status");
j3.setFont(f1);
j3.setLocation(60,300);
j3.setSize(300,30);
add(j3);

// j4=new JLabel("Select Staff");
// j4.setFont(f1);
// j4.setLocation(60,360);
// j4.setSize(300,30);
// add(j4);


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

jc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              
                dao d=new dao();
              
              java.util.List<task> l3=new ArrayList<task>();
              try {
                  String s2=jc1.getSelectedItem().toString();
    String a[]=s2.split(" ");
    String staffid=a[0];
       l3 = d.getalltaskbystaffid(Integer.parseInt(staffid));
       int j=0; 
       jc2.removeAllItems();
       for(task tas:l3)
        {
            jc2.addItem(tas.getTask_id()+" - "+tas.getTask_name());
        } 
        
        
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

	 
	

	
add(jc2);




jc3=new JComboBox();
jc3.setFont(f1);
jc3.setLocation(300,300);
jc3.setSize(300,30);
jc3.addItem("Status");
jc3.addItem("Complete");
jc3.addItem("Decline");
add(jc3);



b=new JButton("UPDATE");
b.setFont(f1);
b.setLocation(150,450);
b.setSize(200,30);
add(b);
b.addActionListener(this);

s=new JButton("CANCEL");
s.setFont(f1);
s.setLocation(450,450);
s.setSize(200,30);
add(s);
s.addActionListener(this);

}

public void actionPerformed(ActionEvent e)
{
if(e.getSource() == s)
{
	setVisible(false);
}
if(e.getSource() == b)
{
    if(jc3.getSelectedIndex()==0)
    {
    JOptionPane.showMessageDialog(null,"Select Valid Option");
    }
    else{
try{
     String s2=jc2.getSelectedItem().toString();
    String a[]=s2.split(" ");
    String taskid=a[0];
    dao d=new dao();
     int tid=Integer.parseInt(taskid);
  if(d.updateTaskStatus(tid,jc3.getSelectedItem().toString())>0)
  {
  JOptionPane.showMessageDialog(null,"TASK Status updated successfully");
  setVisible(false);
  }
  else
  {
  JOptionPane.showMessageDialog(null,"SORRY !!TASK NOT updated");
  }
 }
 
 catch(Exception a)
 {
 JOptionPane.showMessageDialog(null,a);
 } 	
    }
//setVisible(false);
}
}

public static void main(String args[])
{
UpdateTask s1=new UpdateTask();
Container c=s1.getContentPane();
c.setBackground(Color.gray);
}
}


