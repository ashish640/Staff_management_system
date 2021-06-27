package view;

import Model.Classs;
import Model.staff;
import dao.dao;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class Update1 extends JFrame implements ActionListener {

    JFrame f;
    JLabel id, id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12, id15, lab, lab1, i1, i2;
    JTextField t, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13;
    JButton b, b1, b2, b3;
    JComboBox jc;
    //String id_emp;

    Update1(staff s1) throws SQLException {

        f = new JFrame("Update Employee details");
        setTitle("UPDATE STAFF DETAILS");
        setVisible(true);
        setSize(1920, 1080);
        //setLocation(450,250);
        setLocationRelativeTo(null);
        setBackground(Color.white);
        setLayout(null);

        id15 = new JLabel();
        id15.setBounds(0, 0, 1920, 1000);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Images/u3.jpg"));
        id15.setIcon(img);

        id8 = new JLabel("Update Staff Details:");
        id8.setBounds(50, 10, 500, 50);
        id8.setFont(new Font("serif", Font.ITALIC, 40));
        id8.setForeground(Color.white);
        id15.add(id8);
        add(id15);

        id1 = new JLabel("Name");
        id1.setBounds(50, 100, 100, 30);
        id1.setFont(new Font("serif", Font.BOLD, 20));
        id1.setForeground(Color.white);
        id15.add(id1);

        t1 = new JTextField(s1.getName());
        t1.setBounds(200, 100, 150, 30);
        id15.add(t1);

        id2 = new JLabel("Address");
        id2.setBounds(400, 100, 200, 30);
        id2.setFont(new Font("serif", Font.BOLD, 20));
        id2.setForeground(Color.white);
        id15.add(id2);

        t2 = new JTextField(s1.getAddress());
        t2.setBounds(600, 100, 150, 30);
        id15.add(t2);

        id3 = new JLabel("City");
        id3.setBounds(50, 150, 100, 30);
        id3.setFont(new Font("serif", Font.BOLD, 20));
        id3.setForeground(Color.white);
        id15.add(id3);

        t3 = new JTextField(s1.getCity());
        t3.setBounds(200, 150, 150, 30);
        id15.add(t3);

        id4 = new JLabel("Email");
        id4.setBounds(400, 150, 100, 30);
        id4.setFont(new Font("serif", Font.BOLD, 20));
        id4.setForeground(Color.white);
        id15.add(id4);

        t4 = new JTextField(s1.getEmail());
        t4.setBounds(600, 150, 150, 30);
        id15.add(t4);

        id5 = new JLabel("Mobile");
        id5.setBounds(50, 200, 100, 30);
        id5.setFont(new Font("serif", Font.BOLD, 20));
        id5.setForeground(Color.white);
        id15.add(id5);

        t5 = new JTextField(s1.getMobile());
        t5.setBounds(200, 200, 150, 30);
        id15.add(t5);

        id6 = new JLabel("Degree");
        id6.setBounds(400, 200, 100, 30);
        id6.setFont(new Font("serif", Font.BOLD, 20));
        id6.setForeground(Color.white);
        id15.add(id6);

        t6 = new JTextField(s1.getDegree());
        t6.setBounds(600, 200, 150, 30);
        id15.add(t6);

        id7 = new JLabel("Designation");
        id7.setBounds(50, 250, 100, 30);
        id7.setFont(new Font("serif", Font.BOLD, 20));
        id7.setForeground(Color.white);
        id15.add(id7);

        t7 = new JTextField(s1.getDesignation());
        t7.setBounds(200, 250, 150, 30);
        id15.add(t7);

        id9 = new JLabel("Class");
        id9.setBounds(400, 250, 100, 30);
        id9.setFont(new Font("serif", Font.BOLD, 20));
        id9.setForeground(Color.white);
        id15.add(id9);

        dao d = new dao();
        jc = new JComboBox();
//jc.setFont(f);
        jc.setLocation(600, 250);
        jc.setSize(150, 30);
        for (String s : d.getAllClasses()) {
            jc.addItem(s);
        }
        id15.add(jc);
        jc.addActionListener(this);
        try{
        jc.setSelectedItem((String)d.getClasssByid(s1.getClass_id()).getClass_Name());
        //System.out.println(d.getClasssByid(s1.getClass_id()).getClass_Name());
        }
        catch(Exception a)
        {
        }
        jc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
             Classs s = new Classs();
            try {
                
                dao d = new dao();
                s = d.getClasssByname((String) jc.getSelectedItem());
                t13.setText(s.getBasic_pay() + "");
                t12.setText((s.getBasic_pay() + s.getMa() + s.getRa() + s.getTa()) + "");
                t13.setEditable(false);
                t12.setEditable(false);
                //System.out.println("Hello Ashish here");
            } catch (SQLException ex) {

            } 
            }
        });
        
        id10 = new JLabel("Staff Id");
        id10.setBounds(50, 300, 150, 30);
        id10.setFont(new Font("serif", Font.BOLD, 20));
        id10.setForeground(Color.white);
        id15.add(id10);
        f.setVisible(false);

        t9 = new JTextField(s1.getStaff_id() + "");
        t9.setBounds(200, 300, 150, 30);
        id15.add(t9);
        t9.setEditable(false);

        Classs s2 = d.getClasssByid(s1.getClass_id());
        i1 = new JLabel("Salary");
        i1.setBounds(50, 350, 150, 30);
        i1.setFont(new Font("serif", Font.BOLD, 20));
        i1.setForeground(Color.white);
        id15.add(i1);
        f.setVisible(false);

        t12 = new JTextField((s2.getBasic_pay() + s2.getMa() + s2.getRa() + s2.getTa()) + "");
        t12.setBounds(200, 350, 150, 30);
        t12.setEditable(false);
        id15.add(t12);

        i2 = new JLabel("Basic Pay");
        i2.setBounds(400, 300, 150, 30);
        i2.setFont(new Font("serif", Font.BOLD, 20));
        i2.setForeground(Color.white);
        id15.add(i2);

        t13 = new JTextField(s2.getBasic_pay() + "");
        t13.setBounds(600, 300, 150, 30);
        t13.setEditable(false);
        id15.add(t13);

        b = new JButton("Update");
        b.setBounds(250, 450, 100, 30);
        b.addActionListener(this);
        id15.add(b);

        b1 = new JButton("Cancel");
        b1.setBounds(450, 450, 100, 30);
        b1.addActionListener(this);
        id15.add(b1);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            //new Userint();
            setVisible(false);
            
        }

        if (ae.getSource() == b) {
            try {
                staff s = new staff();
                dao d = new dao();
                s.setStaff_id(Integer.parseInt(t9.getText()));
                s.setClass_id(d.getClasssByname(jc.getSelectedItem().toString()).getClass_id());
                s.setName(t1.getText());
                s.setEmail(t4.getText());
                s.setMobile(t5.getText());
                s.setDegree(t6.getText());
                s.setDesignation(t7.getText());
                s.setAddress(t2.getText());
                s.setCity(t3.getText());

                if (d.updatestaff(s) > 0) {
                    JOptionPane.showMessageDialog(null, "Staff Updated Successfully");
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Not updated Successfully");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

//        if (ae.getSource() == jc) {
//            
////setVisible(false);
//        }
      
    }

    public static void main(String[] arg) {
//        try {
//            new Update1();
//        } catch (SQLException ex) {
//            Logger.getLogger(Update1.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
