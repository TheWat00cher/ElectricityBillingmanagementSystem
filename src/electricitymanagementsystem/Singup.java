
package electricitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Singup extends JFrame implements ActionListener {
    JButton back , create;
    Choice accounttype;
    JTextField meter , username ,name , password;
    Singup()
    {
        setBounds(350 , 150 , 700 , 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(30, 30 , 650 , 320);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173 , 216 , 230 ) , 2) , "Create Acount"  , TitledBorder.LEADING , TitledBorder.TOP , null , Color.BLUE));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(Color.BLACK);
        add(panel);
        
        JLabel heading = new JLabel("Create Acount As");
        heading.setBounds(100 , 50 , 140 , 34);
        heading.setForeground(Color.GRAY);
        panel.add(heading);
        
        accounttype = new Choice();
        accounttype.add("Admin");
        accounttype.add("Customer");
        accounttype.setBounds(260 , 60 , 160 , 20);
        panel.add(accounttype);
        
        
        
        JLabel Ibmeter = new JLabel("Meter Number");
        Ibmeter.setBounds(100 , 90 , 140 , 34);
        Ibmeter.setForeground(Color.GRAY);
        Ibmeter.setVisible(false);
        panel.add(Ibmeter);
        
        meter = new JTextField();
        meter.setBounds(260 , 100 , 160 , 20);
        meter.setVisible(false);
        panel.add(meter);
        
        
        
        JLabel Ibusername = new JLabel("User Name");
        Ibusername.setBounds(100 , 130 , 140 , 34);
        Ibusername.setForeground(Color.GRAY);
        panel.add(Ibusername);
        
        username = new JTextField();
        username.setBounds(260 , 140 , 160 , 20);
        panel.add(username);
        
        JLabel Ibname = new JLabel("Name");
        Ibname.setBounds(100 , 170 , 140 , 34);
        Ibname.setForeground(Color.GRAY);
        panel.add(Ibname);
        
        name = new JTextField();
        name.setBounds(260 , 180 , 160 , 20);
        panel.add(name);
        
        meter.addFocusListener(new FocusListener()                
                {
                  public void focusGained(FocusEvent fe)
                  {
                      
                  }
                  public void focusLost(FocusEvent fe)
                  {
                    try
                    {
                        Conn c = new Conn();
                        ResultSet rs = c.s.executeQuery("Select *from login where meter_no = '"+meter.getText()+"'");
                        while(rs.next())
                        {
                           name.setText(rs.getString("name")); 
                        }
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                  }
                });
        
        JLabel Ibpassword = new JLabel("Password");
        Ibpassword.setBounds(100 , 210 , 140 , 34);
        Ibpassword.setForeground(Color.GRAY);
        panel.add(Ibpassword);
        
        password = new JTextField();
        password.setBounds(260 , 220 , 160 , 20);
        panel.add(password);
        
        accounttype.addItemListener(new ItemListener()
                {
                   public void itemStateChanged(ItemEvent ie)
                   {
                       String user = accounttype.getSelectedItem();
                       if(user.equals("Customer"))
                       {
                           Ibmeter.setVisible(true);
                           meter.setVisible(true);
                           name.setEditable(false);
                       }
                       else
                       {
                           Ibmeter.setVisible(false);
                           meter.setVisible(false);
                           name.setEditable(true);
                       }
                   }
                });
                
        
        create = new JButton("Create");
        create.setBounds(140 , 260 , 160 , 25);
        create.addActionListener(this);
        panel.add(create);
        
        back = new JButton("Back");
        back.setBounds(320 , 260 , 160 , 25);
        back.addActionListener(this);
        panel.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupimage.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450 , 35 , 200 , 200);
        panel.add(image);
        
        
        setVisible(true);
    }       
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == create)
        {
            String atype = accounttype.getSelectedItem();
            String susername = username.getText();
            String sname = name.getText();
            String spassword = password.getText();
            String smeter = meter.getText();
            
            try
            {
                Conn c = new Conn();
                String query = null ;
                if(atype.equals("Admin")){
                query ="insert into login values('"+smeter+"' , '"+susername+"' ,'"+sname+"' , '"+spassword+"' , '"+atype+"')";
                } else
                {
                    query ="update login set username = '"+susername+"' , password = '"+spassword+"' ,  user ='"+atype+"' where  meter_no = '"+smeter+"'";
                }
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null , "Account Created Successfully");
                
                setVisible(false);
                new login();
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back)
        {
            
            setVisible(false);
          
            new login();
        }
    }
    
      public static void main(String[] args)
      {
         new Singup(); 
      }
}
