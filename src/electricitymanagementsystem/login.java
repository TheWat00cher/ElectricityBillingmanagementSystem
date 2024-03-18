
package electricitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {
    
    JButton login , singup , cancel ;
    JTextField username , password;
    Choice Loginas;
    login()
    {
       super("Login Page");
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
        
       JLabel ibusername = new JLabel("Username");
       ibusername.setBounds(250 ,80 , 100 ,20);
       add(ibusername);
       
       username = new JTextField();
       username.setBounds(350 , 80 , 150 , 20);
       add(username);
       
       JLabel ibpassword = new JLabel("Password");
       ibpassword.setBounds(250 ,120 , 100 ,20);
       add(ibpassword);
       
       password = new JTextField();
       password.setBounds(350 , 120 , 150 , 20);
       add(password);
       
       JLabel loginas = new JLabel("Login As");
       loginas.setBounds(250 ,160 , 100 ,20);
       add(loginas);
       
//       JTextField Loginas = new JTextField();
//       Loginas.setBounds(325 , 160 , 150 , 20);
//       add(Loginas);
       
       Loginas = new Choice();
       Loginas.add("Admin");
       Loginas.add("Customer");
       Loginas.setBounds(350 , 160 , 150 , 20);
       add(Loginas);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
       Image i2 = i1.getImage().getScaledInstance(16 , 16 , Image.SCALE_DEFAULT);
       login = new JButton("Login" , new ImageIcon(i2));
       login.setBounds(200 , 220 , 150 , 20);
       login.addActionListener(this);
       add(login);
       
       ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
       Image i4 = i3.getImage().getScaledInstance(16 , 16 , Image.SCALE_DEFAULT);
       cancel = new JButton("Cancel" , new ImageIcon(i4));
       cancel.setBounds(400 , 220 , 150 , 20);
       cancel.addActionListener(this);
       add(cancel);
       
       ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
       Image i6 = i5.getImage().getScaledInstance(16 , 16 , Image.SCALE_DEFAULT);
       singup = new JButton("Sing Up" , new ImageIcon(i6));
       singup.setBounds(300 , 260 , 150 , 20);
       singup.addActionListener(this);
       add(singup);
       
       ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
       Image i8 = i7.getImage().getScaledInstance(250 , 250 , Image.SCALE_DEFAULT);
       ImageIcon i9 = new ImageIcon(i8);
       JLabel image = new JLabel(i9);
       image.setBounds(0 , 0 , 250 , 250);
       add(image);
       
       
       setSize(600 , 350);
       setLocation(400 , 200);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== login)
        {
            String susername = username.getText();
            String spassword = password.getText();
            String suser = Loginas.getSelectedItem();
            
            try
            {
              Conn c = new Conn();
              String query = "select * from login where username = '"+susername+"' and password = '"+spassword+"' and user = '"+suser+"'";
              
              ResultSet rs = c.s.executeQuery(query);
              
              if(rs.next())
              {
                  String meter = rs.getString("Meter_no");
                  setVisible(false);
                  new project(suser , meter);
              }
              else
              {
                  JOptionPane.showMessageDialog(null, "Invalid Login");
              }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == singup)
        {
            setVisible(false);
            new Singup();
        }
        else if(ae.getSource() == cancel)
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
       new login(); 
    }
    
}
