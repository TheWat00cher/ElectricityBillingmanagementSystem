
package electricitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class paybill extends JFrame implements ActionListener{
    Choice cmonth;
    JButton pay , back;
    String meter;
    paybill(String meter)
    {
        this.meter = meter;
       setLayout(null);
       setBounds(300 , 100 , 900,600);
       
       JLabel heading = new JLabel("Electricity Bill");
       heading.setFont(new Font("Fahoma" , Font.BOLD , 26));
       heading.setBounds(350 , 5 , 400 , 30);
       add(heading);
       
       JLabel lblmeternumber = new JLabel("Meter Number");
       lblmeternumber.setBounds(150 , 100 , 100 , 30);
       add(lblmeternumber);
       
       JLabel meternumber = new JLabel("");
       meternumber.setBounds(300 , 100 , 100 , 30);
       add(meternumber);
       
       JLabel lblname = new JLabel("Name");
       lblname.setBounds(150 , 140 , 100 , 30);
       add(lblname);
       
       JLabel labelname = new JLabel("");
       labelname.setBounds(300 , 140 , 100 , 30);
       add(labelname);
       
       JLabel lblmonth = new JLabel("Month :");
       lblmonth.setBounds(150 , 180 , 100 , 30);
       add(lblmonth);
       
        cmonth = new Choice();
        cmonth.setBounds(250 , 180 , 150 , 30);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        add(cmonth);
        
       JLabel lblunits = new JLabel("Units  :");
       lblunits.setBounds(150 , 220 , 100 , 30);
       add(lblunits);
       
       JLabel labelunits = new JLabel("");
       labelunits.setBounds(300 , 220 , 100 , 30);
       add(labelunits);
       
       
       JLabel lbltotalbill = new JLabel("TotalBill  :");
       lbltotalbill.setBounds(150 , 260 , 100 , 30);
       add(lbltotalbill);
       
       JLabel labeltotalbill = new JLabel("");
       labeltotalbill.setBounds(300 , 260 , 100 , 30);
       add(labeltotalbill);
       
       
       JLabel lblstatus = new JLabel("Status :");
       lblstatus.setBounds(150 , 300 , 100 , 30);
       add(lblstatus);
       
       JLabel labelstatus = new JLabel("");
       labelstatus.setBounds(300 , 300 , 100 , 30);
       labelstatus.setForeground(Color.RED);
       add(labelstatus);
       
       try
       {
         Conn c = new Conn();
         ResultSet rs = c.s.executeQuery("select * from customer where mater_no = '"+meter+"'");
         while(rs.next())
         {
             meternumber.setText(meter);
             labelname.setText(rs.getString("name"));
         }
         
        rs = c.s.executeQuery("select * from bill where meter_no = '"+meter+"' AND month = 'January'");
         while(rs.next())
         {
            labelunits.setText(rs.getString("units"));
            labeltotalbill.setText(rs.getString("totalbill"));
            labelstatus.setText(rs.getString("status"));
         }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       
       cmonth.addItemListener(new ItemListener()
       { 

           public void itemStateChanged(ItemEvent ae)
           {
               try
       {
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from bill where meter_no = '"+meter+"' AND month = '"+cmonth.getSelectedItem()+"'");
         while(rs.next())
         {
            labelunits.setText(rs.getString("units"));
            labeltotalbill.setText(rs.getString("totalbill"));
            labelstatus.setText(rs.getString("status"));
         }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
           }
       });
       
       pay = new JButton("Pay");
       pay.setBackground(Color.BLACK);
       pay.setForeground(Color.white);
       pay.setBounds(150 , 400 , 100 , 45);
       pay.addActionListener(this);
       add(pay);
       
       back = new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.white);
       back.setBounds(350 , 400 , 100 , 45);
       back.addActionListener(this);
       add(back);
       
       getContentPane().setBackground(Color.WHITE);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
       Image i2 = i1.getImage().getScaledInstance(600 , 300 , Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(400 , 120 , 600 , 300);
       add(image);
       
       setVisible(true);
       
       
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == pay)
        {
            try
            {
                Conn c = new Conn();
                c.s.executeUpdate("update bill set status = 'Paid' where meter_no= '"+meter+"' AND month = '"+cmonth.getSelectedItem()+"'");
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            setVisible(false);
            new Paytm(meter);
        }else
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new paybill("");
    }
}
