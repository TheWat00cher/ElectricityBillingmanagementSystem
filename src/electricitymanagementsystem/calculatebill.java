
package electricitymanagementsystem;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
//import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;




public class calculatebill extends JFrame implements ActionListener {
    JTextField   tfaddress ,tfstate , tfcity ,tfemail , tfphone , tfunits ;
    JButton next , cancel;
    JLabel lblname , labeladdress;
    Choice meternumber , cmonth;
    calculatebill()
    {
        setSize(700 , 500);
        setLocation(400 , 100);
        
        JPanel p = new JPanel();
        p.setBackground(new Color(173 , 216 , 230));
        p.setLayout(null);
        add(p);
        
        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(100 , 10 , 250 , 20);
        heading.setFont(new Font("Tahoma" , Font.BOLD ,20));
        p.add(heading);
        
        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(100 , 80 , 100 , 20);
        //heading.setFont(new Font("Tahoma" , Font.BOLD ,20));
        p.add(lblmeternumber);
        
        meternumber = new Choice();
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer");
            while(rs.next())
            {
               meternumber.add(rs.getString("mater_no"));
            }
                        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        meternumber.setBounds(250 , 80 , 100 , 20);
        p.add(meternumber);
        
        
        JLabel lblmeterno = new JLabel("Name");
        lblmeterno.setBounds(100 , 120 , 100 , 20);
        p.add(lblmeterno);
        
        lblname = new JLabel("");
        lblname.setBounds(250 , 120 , 100 , 20);
        p.add(lblname);
        
//        Random ran = new Random();
//        long number = ran.nextLong() % 1000000;
//        lblmeter.setText("" + Math.abs(number));
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100 , 160 , 150 , 20);
        p.add(lbladdress);
        
//        tfaddress = new JTextField();
//        tfaddress.setBounds(250 , 160 , 200 , 20);
//        p.add(tfaddress);

        labeladdress = new JLabel("");
        labeladdress.setBounds(250 , 160 , 100 , 20);
        p.add(labeladdress);
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from customer where mater_no ='"+meternumber.getSelectedItem()+"'");
            while(rs.next())
            {
                lblname.setText(rs.getString("name"));
                labeladdress.setText(rs.getString("address"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        meternumber.addItemListener(new ItemListener()
                {
                   public void itemStateChanged(ItemEvent ie)
                   {
                           try
                          {
                              Conn c = new Conn();
                              ResultSet rs = c.s.executeQuery("select *from customer where mater_no ='"+meternumber.getSelectedItem()+"'");
                              while(rs.next())
                              {
                                  lblname.setText(rs.getString("name"));
                                  labeladdress.setText(rs.getString("address"));
                              }
                          }catch(Exception e)
                          {
                              e.printStackTrace();
                          } 
                   }
                });
        
        JLabel lblstate = new JLabel("Unit Consumed");
        lblstate.setBounds(100 , 200 , 150 , 20);
        p.add(lblstate);
        
        tfunits = new JTextField();
        tfunits.setBounds(250 , 200 , 200 , 20);
        p.add(tfunits);
        
        JLabel lblcity = new JLabel("Month");
        lblcity.setBounds(100 , 240 , 150 , 20);
        p.add(lblcity);
        
        cmonth = new Choice();
        cmonth.setBounds(250 , 240 , 200 , 20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("Agust");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        p.add(cmonth);
        
//        JLabel lblemail = new JLabel("Email");
//        lblemail.setBounds(100 , 280 , 150 , 20);
//        p.add(lblemail);
//        
//        tfemail = new JTextField();
//        tfemail.setBounds(250 , 280 , 200 , 20);
//        p.add(tfemail);
//        
//        JLabel lblphone = new JLabel("Phone Number");
//        lblphone.setBounds(100 , 320 , 150 , 20);
//        p.add(lblphone);
//        
//        tfphone = new JTextField();
//        tfphone.setBounds(250 , 320 , 200 , 20);
//        p.add(tfphone);
        
        next = new JButton("Submit");
        next.setBounds(120 , 350 , 100 , 25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250 , 350 , 100 , 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout());
        
        add(p , "Center");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
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
         String name = lblname.getText();
         String meter = meternumber.getSelectedItem();
         String units = tfunits.getText();
         String month = cmonth.getSelectedItem();
         
         int totalbill = 0 ;
         int unit_consumed = Integer.parseInt(units);
         String query = "select *from tax";
         
         
//         String query1 = "insert into customer values('"+name+"' , '"+meter+"' , '"+address+"' , '"+state+"' , '"+city+"' , '"+phone+"' ,'"+email+"')" ;
//         String query2 = "insert into login values('"+meter+"' , ' ' , '"+name+"' , ' ' , ' ')";
          
         try
         {
             Conn c = new Conn();
//             c.s.executeUpdate(query1);
//             c.s.executeUpdate(query2);
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
                    {
                        totalbill += unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                        totalbill += Integer.parseInt(rs.getString("meter_rent"));
                        totalbill += Integer.parseInt(rs.getString("service_charge"));
                        totalbill += Integer.parseInt(rs.getString("service_tax"));
                        totalbill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                        totalbill += Integer.parseInt(rs.getString("Fixed_tax"));
                    }

         }catch (Exception e)
         {
             e.printStackTrace();
         }
             String query2 = "insert into bill values('"+meter+"' ,'"+month+"' , '"+units+"' , '"+totalbill+"' ,' ' )";
             
             try
             {
                 Conn c = new Conn();
                 c.s.executeUpdate(query2);
                 
                 JOptionPane.showMessageDialog(null , "Customer Bill Updated Successfully");
             }catch(Exception e)
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
        new calculatebill();
    }
}
