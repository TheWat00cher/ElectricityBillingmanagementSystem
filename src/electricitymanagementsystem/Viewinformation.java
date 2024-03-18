
package electricitymanagementsystem;

import java.awt.Color;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Viewinformation extends JFrame implements ActionListener {
    
    JButton cancel;
    
    Viewinformation(String meter)
    {
        setBounds(350 , 50 , 850 , 650 );
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(260 , 0 , 500 , 40);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 22));
        add(heading);
        
        JLabel lblname  = new JLabel("Name");
        lblname.setBounds(80 , 80 , 100 , 20);
        //lblname.setFont(new Font("Tahoma" , Font.BOLD , 22));
        add(lblname);
        
        JLabel name  = new JLabel("");
        name.setBounds(250 , 80 , 100 , 20);
        //lblname.setFont(new Font("Tahoma" , Font.BOLD , 22));
        add(name);
        
        JLabel lblmeternumber  = new JLabel("Meter Number");
        lblmeternumber .setBounds(80 ,120 , 100 , 20);
        add(lblmeternumber );
        
        JLabel meternumber  = new JLabel("");
        meternumber .setBounds(250 , 120 , 100 , 20);
        add(meternumber );
        
        JLabel lbladdress  = new JLabel("Address");
        lbladdress.setBounds(80 ,160 , 100 , 20);
        add(lbladdress);
        
        JLabel address = new JLabel("");
        address.setBounds(250 , 160 , 100 , 20);
        add(address);
        
        JLabel lblcity  = new JLabel("City");
        lblcity.setBounds(80 ,200 , 100 , 20);
        add(lblcity);
        
        JLabel city = new JLabel("");
        city.setBounds(250 , 200 , 100 , 20);
        add(city);
        
        JLabel lblstate  = new JLabel("State");
        lblstate.setBounds(400 ,200 , 100 , 20);
        add(lblstate);
        
        JLabel state = new JLabel("");
        state.setBounds(600 , 200 , 100 , 20);
        add(state);
        
        JLabel lblemail  = new JLabel("Email");
        lblemail.setBounds(80 ,240 , 100 , 20);
        add(lblemail);
        
        JLabel email = new JLabel("");
        email.setBounds(250 , 240 , 150 , 20);
        add(email);
        
        JLabel lblphone  = new JLabel("Phone Number");
        lblphone.setBounds(450 ,240 , 100 , 20);
        add(lblphone);
        
        JLabel phone = new JLabel("");
        phone.setBounds(650 , 240 , 100 , 20);
        add(phone);
        
        try{
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("Select * from customer where mater_no = '"+meter+"'");
           while(rs.next())
           {
               name.setText(rs.getString("name"));
               address.setText(rs.getString("address"));
               city.setText(rs.getString("city"));
               state.setText(rs.getString("state"));
               phone.setText(rs.getString("phone_no"));
               email.setText(rs.getString("email"));
               meternumber.setText(rs.getString("mater_no"));
           }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(350 , 280 , 100 , 20);
        cancel.addActionListener(this);
        add(cancel);
        //cancel.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100 , 320 , 600 , 300);
        add(image);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
    }
    public static void main(String[] args)
    {
        new Viewinformation("");
        
    }
}
