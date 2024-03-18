
package electricitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Newcustomer extends JFrame implements ActionListener {
    
    JTextField tfname , tfaddress ,tfstate , tfcity ,tfemail , tfphone;
    JButton next , cancel;
    JLabel lblmeter;
    Newcustomer()
    {
        setSize(700 , 500);
        setLocation(400 , 100);
        
        JPanel p = new JPanel();
        p.setBackground(new Color(173 , 216 , 230));
        p.setLayout(null);
        add(p);
        
        JLabel heading = new JLabel("New Customer");
        heading.setBounds(250 , 10 , 200 , 20);
        heading.setFont(new Font("Tahoma" , Font.BOLD ,20));
        p.add(heading);
        
        JLabel lblname = new JLabel("Customer Name");
        lblname.setBounds(100 , 80 , 100 , 20);
        //heading.setFont(new Font("Tahoma" , Font.BOLD ,20));
        p.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(250 , 80 , 200 , 20);
        p.add(tfname);
        
        JLabel lblmeterno = new JLabel("Meter Number");
        lblmeterno.setBounds(100 , 120 , 100 , 20);
        p.add(lblmeterno);
        
        lblmeter = new JLabel("");
        lblmeter.setBounds(250 , 120 , 100 , 20);
        p.add(lblmeter);
        
        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        lblmeter.setText("" + Math.abs(number));
        
        JLabel lbladdress = new JLabel("Customer Address");
        lbladdress.setBounds(100 , 160 , 150 , 20);
        p.add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(250 , 160 , 200 , 20);
        p.add(tfaddress);
        
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(100 , 200 , 150 , 20);
        p.add(lblstate);
        
        tfstate = new JTextField();
        tfstate.setBounds(250 , 200 , 200 , 20);
        p.add(tfstate);
        
        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(100 , 240 , 150 , 20);
        p.add(lblcity);
        
        tfcity = new JTextField();
        tfcity.setBounds(250 , 240 , 200 , 20);
        p.add(tfcity);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(100 , 280 , 150 , 20);
        p.add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(250 , 280 , 200 , 20);
        p.add(tfemail);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(100 , 320 , 150 , 20);
        p.add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(250 , 320 , 200 , 20);
        p.add(tfphone);
        
        next = new JButton("Next");
        next.setBounds(120 , 370 , 100 , 25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250 , 370 , 100 , 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout());
        
        add(p , "Center");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150 , 300 , Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image , "West");
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource() == next)
       {
         String name = tfname.getText();
         String meter = lblmeter.getText();
         String address = tfaddress.getText();
         String city = tfcity.getText();
         String state = tfstate.getText();
         String email = tfemail.getText();
         String phone = tfphone.getText();
         
         String query1 = "insert into customer values('"+name+"' , '"+meter+"' , '"+address+"' , '"+state+"' , '"+city+"' , '"+phone+"' ,'"+email+"')" ;
         String query2 = "insert into login values('"+meter+"' , ' ' , '"+name+"' , ' ' , ' ')";
         
         try
         {
             Conn c = new Conn();
             c.s.executeUpdate(query1);
             c.s.executeUpdate(query2);
             
             JOptionPane.showMessageDialog(null , "Customer Details Added Successfully");
             setVisible(false);
             
             new Meterinfo(meter);
         }catch (Exception e)
         {
             e.printStackTrace();
         }
                 
       }else
       {
           setVisible(false);
       }
    }
    
    public static void main(String[] args)
    {
        new Newcustomer();
    }
}
