
package view;



import Model.staff;
import dao.dao;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

class Search1 implements ActionListener{
    JFrame f;
    JTextField t;
    JLabel l,l5;
    JButton b,b2;

    Search1(){
        f=new JFrame("search");
        f.setBackground(Color.green);
        f.setLayout(null);

        l5=new JLabel();
        l5.setBounds(0,-30,1920,1080);//500 270
        l5.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Images/s3.jpg"));
        l5.setIcon(img);


        l=new JLabel("STAFF ID");
        l.setVisible(true);
        l.setBounds(600,300,250,30);
        l.setForeground(Color.WHITE);
        Font F1=new Font("serif",Font.BOLD,30);
        l.setFont(F1); 
        l5.add(l);
        f.add(l5);

        t=new JTextField();
        t.setBounds(800,300,240,30);
        l5.add(t);

        b=new JButton("Search");
        b.setBounds(800,400,100,30);
        b.addActionListener(this);
        l5.add(b);


        b2=new JButton("Cancel");
        b2.setBounds(940,400,100,30);
        b2.addActionListener(this);
        l5.add(b2);

        f.setSize(1920,1080);//500 270
        //f.setLocation(450,250);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            // f.setVisible(false);
            // details d=new details();
        }
        if(ae.getSource()==b){
           dao d=new dao();
                    try {
                        staff s=d.getstaff(Integer.parseInt(t.getText()));
                        if(s!=null)
                        {
                         new Update1(s);
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
if(ae.getSource()==b2)
        {
        f.setVisible(false);
        }
    }
    
    public static void main(String[]ar)
    {
        new Search1();
    } 	
}
