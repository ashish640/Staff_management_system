
package view;

import Model.staff;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class Printdata implements ActionListener
{
	
		JFrame f;
		JLabel i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19,i20,i21,i22,i23,id;
		String Name,Address,City,Pincode,Contact,Degree,Designation,DOB,Class,Salary;
		JButton b1,b2;
		ImageIcon icon;

		Printdata(staff s)
		{
		f=new JFrame("Print Data");
                f.setVisible(true);
                f.setSize(1920,1080);//595,642
                //f.setLocation(450,200);
                f.setLocationRelativeTo(null);
                f.setBackground(Color.white);
                f.setLayout(null);

        i1=new JLabel();
        i1.setBounds(0,0,1920,1080);
        i1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Images/p6.jpg"));
        i1.setIcon(img);

        i2 = new JLabel("STAFF DETAILS");
        i2.setBounds(50,10,250,30);
        //f.add(i2);
        i2.setFont(new Font("Times New Roman",Font.BOLD,25));
        i1.add(i2);
        f.add(i1);
        
         id = new JLabel("Staff Id:");
        id.setBounds(50,70,120,30);
        id.setFont(new Font("serif",Font.BOLD,20));
        i1.add(id);

        i3 = new JLabel(s.getStaff_id()+"");
        i3.setBounds(200,70,200,30);
        f.add(i3);
        i3.setFont(new Font("Times New Roman",Font.BOLD,20));
        i1.add(i3);

        i4 = new JLabel("Name:");
        i4.setBounds(50,120,100,30);
        i4.setFont(new Font("serif",Font.BOLD,20));
        i1.add(i4);

        i5 = new JLabel(s.getName());
        i5.setBounds(200,120,300,30);
        i5.setFont(new Font("serif",Font.BOLD,20));
        i1.add(i5);

        i6 = new JLabel("Address:"); 
        i6.setBounds(50,170,200,30);
        i6.setFont(new Font("serif",Font.BOLD,20));
        i1.add(i6);

        i7 = new JLabel(s.getAddress());
        i7.setBounds(200,170,300,30);
        i7.setFont(new Font("serif",Font.BOLD,20));
        i1.add(i7);

        i8= new JLabel("City");
        i8.setBounds(50,220,100,30);
        i8.setFont(new Font("serif",Font.BOLD,20));
        i1.add(i8);

        i9= new JLabel(s.getCity());
        i9.setBounds(200,220,300,30);
        i9.setFont(new Font("serif",Font.BOLD,20));
        i1.add(i9);

        i10= new JLabel("Email");  
        i10.setBounds(50,270,100,30);
        i10.setFont(new Font("serif",Font.BOLD,20));
        i1.add(i10);

        i11= new JLabel(s.getEmail());
        i11.setBounds(200,270,300,30); 
        i11.setFont(new Font("serif",Font.BOLD,20));
        i1.add(i11);

        
        i12= new JLabel("Mobile");
        i12.setBounds(50,320,100,30);
        i12.setFont(new Font("serif",Font.BOLD,20));
        i1.add(i12);

        i13= new JLabel(s.getMobile());
        i13.setBounds(200,320,300,30);
        i13.setFont(new Font("serif",Font.BOLD,20));
        i1.add(i13);

        
        i14= new JLabel("Degree");
        i14.setBounds(50,370,100,30);
        i14.setFont(new Font("serif",Font.BOLD,20));
        i1.add(i14);

        i15= new JLabel(s.getDegree());
        i15.setBounds(200,370,300,30); 
        i15.setFont(new Font("serif",Font.BOLD,20));
        i1.add(i15);


        i16= new JLabel("Designation");
        i16.setBounds(50,420,100,30);
        i16.setFont(new Font("serif",Font.BOLD,20));
        i1.add(i16);

        i17= new JLabel(s.getDesignation());
        i17.setBounds(200,420,300,30);
        i17.setFont(new Font("serif",Font.BOLD,20));
        i1.add(i17);

        i18= new JLabel("DOB");
        i18.setBounds(50,470,100,30);
        i18.setFont(new Font("serif",Font.BOLD,20));
        i1.add(i18);

        i19= new JLabel(s.getDOB());
        i19.setBounds(200,470,300,30);
        i19.setFont(new Font("serif",Font.BOLD,20));
        i1.add(i19);

        b1=new JButton("Done");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,520,100,30);
        b1.addActionListener(this);
        i1.add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250,520,100,30);
        b2.addActionListener(this);
        i1.add(b2);




		}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
//                 PrinterJob pjob = PrinterJob.getPrinterJob();
//PageFormat preformat = pjob.defaultPage();
//preformat.setOrientation(PageFormat.LANDSCAPE);
//PageFormat postformat = pjob.pageDialog(preformat);
////If user does not hit cancel then print.
//if (preformat != postformat) {
//    //Set print component
//    pjob.setPrintable(new Printer(f), postformat);
//    if (pjob.printDialog()) {
//        try {
//            pjob.print();
//        } catch (PrinterException ex) {
//            Logger.getLogger(Printdata.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//} 
//  
//             JOptionPane.showMessageDialog(null,"printed successfully");
             f.setVisible(false);
            
        }
        if(ae.getSource()==b2)
        {
             
              f.setVisible(false);
             new View1();
        }
	}
	public static void main(String args[])
	{
		//Printdata p1=new Printdata();
	}	
}
