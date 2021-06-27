
package view;

import Model.staff;
import Model.task;
import dao.dao;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


 public class Task extends JFrame implements ActionListener
{
JFrame f;
JComboBox jc;
JLabel l1;
JTable t1;
JComboBox jc3;
JButton b1,b2,b3;

Task()
{
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f=new JFrame("TASK");
	setSize(1920,1080);
	setLocationRelativeTo(null);
        setLayout(null);
        //setVisible(true);
        
        

	

    String data[][]={};    
    String column[]={"#","TASK ID","Assign Date","Task Name","Description","Status","Last Status Update"};         
    
    Font f1=new Font("Times New Roman",Font.BOLD,15);
    JTable jt=new JTable(); 
    DefaultTableModel d1=new DefaultTableModel();
    d1.setColumnIdentifiers(column);
    jt.setModel(d1);
    //jt.setBounds(100,40,100,500);          
    jt.setFont(f1);
    jt.setRowHeight(30);
    
    JScrollPane sp=new JScrollPane(jt);
    sp.setBounds(250,200,1500,500);  
    jt.getTableHeader().setPreferredSize(new Dimension(sp.getWidth(),30));
    jt.getTableHeader().setFont(f1);
    jt.getColumnModel().getColumn(0).setPreferredWidth(50);
    jt.getColumnModel().getColumn(1).setPreferredWidth(50);
    jt.getColumnModel().getColumn(2).setPreferredWidth(200);
    jt.getColumnModel().getColumn(3).setPreferredWidth(100);
    jt.getColumnModel().getColumn(4).setPreferredWidth(500);
    jt.getColumnModel().getColumn(5).setPreferredWidth(50);
    jt.getColumnModel().getColumn(6).setPreferredWidth(200);
    sp.setVisible(true);
    
    //sp.setFont(f1);
    add(sp); 
    jc3=new JComboBox();
    jc3.setFont(f1);
jc3.setLocation(900,110);
jc3.setSize(300,30);
try {
    dao d=new dao(); 
    java.util.List<staff> l3=new ArrayList<staff>();
    l3 = d.getallstaff();
        for(staff a:l3)
        {
            String s4=a.getName();
            jc3.addItem(a.getStaff_id()+"  -  " +s4);
            
            System.out.println(a.getName());
        } 
        //jc4.setSelectedIndex(-1);
        
    } catch (SQLException ex) {
        Logger.getLogger(Salary1.class.getName()).log(Level.SEVERE, null, ex);
    }

jc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              dao d=new dao();
              
              java.util.List<task> l3=new ArrayList<task>();
              try {
                  String s2=jc3.getSelectedItem().toString();
    String a[]=s2.split(" ");
    String staffid=a[0];
       l3 = d.getalltaskbystaffid(Integer.parseInt(staffid));
       int j=0; 
       int rowCount = d1.getRowCount();

      for (int i = rowCount - 1; i >= 0; i--) {
             d1.removeRow(i);
}
       for(task tas:l3)
        {
            j++;
            
            d1.addRow(new Object[]{
              j,tas.getTask_id(),tas.getAssign_date(),tas.getTask_name(),tas.getTask_description(),tas.getTask_status(),tas.getLast_update_date()
                
            
                
            } );
            } 
        //jc4.setSelectedIndex(-1);
        
    } catch (SQLException ex) {
        Logger.getLogger(Salary1.class.getName()).log(Level.SEVERE, null, ex);
    }
            }
        });
add(jc3);

l1=new JLabel("STAFF ID");
l1.setFont(f1);
l1.setLocation(800,110);
l1.setSize(300,30);
add(l1);



b1=new JButton("ASSIGN TASK");
b1.setFont(f1);
b1.setLocation(700,800);
b1.setSize(200,30);
add(b1);
b1.addActionListener(this);

b2=new JButton("UPDATE TASK");
b2.setFont(f1);
b2.setLocation(1000,800);
b2.setSize(200,30);
add(b2);
b2.addActionListener(this);

b3=new JButton("CANCEL");
b3.setFont(f1);
b3.setLocation(880,900);
b3.setSize(200,30);
add(b3);
b3.addActionListener(this);

setVisible(true);

}
@Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1)
        {
        new AssignTask();
        setVisible(false);
        }
        if(e.getSource() == b2)
        {
        new UpdateTask();
        setVisible(false);
        }
        if(e.getSource() == b3)
        {
        //new UpdateTask();
        //new Userint();
        setVisible(false);
        }
        
    }
    


public static void main(String args[])
{
Task t1=new Task();
}
    }

    