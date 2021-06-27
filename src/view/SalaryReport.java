
package view;


import Model.salary;
import Model.staff;
import dao.dao;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
//import javax.script.*;

class SalaryReport extends JFrame implements ActionListener
{
JFrame f;
JComboBox jc;
JLabel l1,l2,l4;
JTable t1;
JComboBox jc3;
JButton b3;

SalaryReport()
{
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f=new JFrame("SALARY REPORT");
	setSize(1920,1080);
	setLocationRelativeTo(null);
        
        

	

    String data[][]={};    
    String column[]={"#","Salary_ID","Month/Year","Basic Pay","TravelAllowance","MedicalAllowance","RentalAllowance","Salary"};         
    
    Font f1=new Font("Times New Roman",Font.BOLD,15);
    JTable jt=new JTable(); 
    DefaultTableModel d1=new DefaultTableModel();
    d1.setColumnIdentifiers(column);
    jt.setModel(d1);
    //jt.setBounds(100,40,100,500);          
    jt.setFont(f1);
    jt.setRowHeight(30);
    
    JScrollPane sp=new JScrollPane(jt);
    sp.setBounds(500,200,1000,500);  
    jt.getTableHeader().setPreferredSize(new Dimension(sp.getWidth(),30));
    jt.getTableHeader().setFont(f1);
    sp.setVisible(true);
    
    //sp.setFont(f1);
    add(sp);
    l4=new JLabel("STAFF ID");
l4.setFont(f1);
l4.setLocation(600,100);
l4.setSize(300,30);
add(l4);

b3=new JButton("CANCEL");
b3.setFont(f1);
b3.setLocation(880,750);
b3.setSize(200,30);
add(b3);
b3.addActionListener(this);
    //validate();
    jc3=new JComboBox();
    jc3.setFont(f1);
jc3.setLocation(700,100);
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
              
              java.util.List<salary> l4=new ArrayList<salary>();
              try {
                  String s2=jc3.getSelectedItem().toString();
    String a[]=s2.split(" ");
    String staffid=a[0];
       l4 = d.getallsalarybystaffid(Integer.parseInt(staffid));
       int j=0; 
       int rowCount = d1.getRowCount();

      for (int i = rowCount - 1; i >= 0; i--) {
             d1.removeRow(i);
}
       for(salary sal:l4)
        {
            j++;
            int salary=sal.getBasic_pay()+sal.getTa()+sal.getMa()+sal.getRa();
            d1.addRow(new Object[]{
              j,sal.getS_id(),sal.getMonth(),sal.getBasic_pay(),sal.getTa(),sal.getMa(),sal.getRa(),salary
                
            
                
            } );
        } 
        //jc4.setSelectedIndex(-1);
        
    } catch (SQLException ex) {
        Logger.getLogger(Salary1.class.getName()).log(Level.SEVERE, null, ex);
    }
            }
        });
        
	
add(jc3);
setLayout(null);
setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b3)
{
setVisible(false);
}
}

public static void main(String args[])
{
	SalaryReport s=new SalaryReport();
}
}
