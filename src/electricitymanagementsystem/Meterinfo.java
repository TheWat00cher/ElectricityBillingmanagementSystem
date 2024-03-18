
package electricitymanagementsystem;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.*;


public class Meterinfo extends JFrame implements ActionListener {
    JTextField tfname , tfaddress ,tfstate , tfcity ,tfemail , tfphone;
    JButton next , cancel;
    JLabel lblmeter;
    Choice meterlocation , metertype ,phasecode , billtype;
    String meter;
    Meterinfo(String meter)
    {
        this.meter = meter;
        
        setSize(700 , 500);
        setLocation(400 , 100);
        
        JPanel p = new JPanel();
        p.setBackground(new Color(173 , 216 , 230));
        p.setLayout(null);
        add(p);
        
        JLabel heading = new JLabel("Meter information");
        heading.setBounds(250 , 10 , 200 , 20);
        heading.setFont(new Font("Tahoma" , Font.BOLD ,20));
        p.add(heading);
        
        JLabel lblname = new JLabel("Meter Number");
        lblname.setBounds(100 , 80 , 150 , 20);
        //heading.setFont(new Font("Tahoma" , Font.BOLD ,20));
        p.add(lblname);
        
        JLabel lblmeternumber = new JLabel(meter);
        lblmeternumber.setBounds(240 , 80 , 100 , 20);
        p.add(lblmeternumber);
        
//        tfname = new JTextField();
//        tfname.setBounds(250 , 80 , 200 , 20);
//        p.add(tfname);
        
        JLabel lblmeterno = new JLabel("Meter Location");
        lblmeterno.setBounds(100 , 120 , 100 , 20);
        p.add(lblmeterno);
        
        meterlocation  = new Choice();
        meterlocation.add("Outside");
        meterlocation.add("Inside");
        meterlocation.setBounds(250 , 120 , 200 , 20);
        p.add(meterlocation);
        
        
//        lblmeter = new JLabel("");
//        lblmeter.setBounds(250 , 120 , 100 , 20);
//        p.add(lblmeter);
        
//        Random ran = new Random();
//        long number = ran.nextLong() % 1000000;
//        lblmeter.setText("" + Math.abs(number));
        
        JLabel lbladdress = new JLabel("Meter Type");
        lbladdress.setBounds(100 , 160 , 150 , 20);
        p.add(lbladdress);
        
        metertype  = new Choice();
        metertype.add("Solar Meter");
        metertype.add("Digital Meter");
        metertype.add("Analog Meter");
        metertype.setBounds(250 , 160 , 200 , 20);
        p.add(metertype);
        
//        tfaddress = new JTextField();
//        tfaddress.setBounds(250 , 160 , 200 , 20);
//        p.add(tfaddress);
        
        JLabel lblstate = new JLabel("Phase Code");
        lblstate.setBounds(100 , 200 , 150 , 20);
        p.add(lblstate);
        
        phasecode  = new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        phasecode.setBounds(250 , 200 , 200 , 20);
        p.add(phasecode);
        
//        tfstate = new JTextField();
//        tfstate.setBounds(250 , 200 , 200 , 20);
//        p.add(tfstate);
        
        JLabel lblcity = new JLabel("Bill Type");
        lblcity.setBounds(100 , 240 , 150 , 20);
        p.add(lblcity);
        
        billtype  = new Choice();
        billtype.add("Indutrail");
        billtype.add("Household");
//        billtype.add("Analog Meter");
        billtype.setBounds(250 , 240 , 200 , 20);
        p.add(billtype);
        
//        tfcity = new JTextField();
//        tfcity.setBounds(250 , 240 , 200 , 20);
//        p.add(tfcity);
        
        JLabel lblemail = new JLabel("Days");
        lblemail.setBounds(100 , 280 , 150 , 20);
        p.add(lblemail);
        
        JLabel lblemails = new JLabel("30 Days");
        lblemails.setBounds(250 , 280 , 150 , 20);
        p.add(lblemails);
        
        JLabel lblphone = new JLabel("Note");
        lblphone.setBounds(100 , 320 , 150 , 20);
        p.add(lblphone);
        
        JLabel lblphones= new JLabel("By Default bill can only calculated for 30 days only");
        lblphones.setBounds(250 , 320 , 400 , 20);
        p.add(lblphones);
        
//        tfphone = new JTextField();
//        tfphone.setBounds(250 , 320 , 200 , 20);
//        p.add(tfphone);
        
        next = new JButton("Submit");
        next.setBounds(200 , 370 , 100 , 25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);
        
//        cancel = new JButton("Cancel");
//        cancel.setBounds(250 , 370 , 100 , 25);
//        cancel.setBackground(Color.BLACK);
//        cancel.setForeground(Color.WHITE);
//        cancel.addActionListener(this);
//        p.add(cancel);
        
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
         String meternumber = meter;
         String location = meterlocation.getSelectedItem();
         String type = metertype.getSelectedItem();
         String code = phasecode.getSelectedItem();
         String typebill = billtype.getSelectedItem();
         String days = "30";
         
//         String query1 = "insert into customer values('"+name+"' , '"+meter+"' , '"+address+"' , '"+state+"' , '"+city+"' , '"+phone+"' ,'"+email+"')" ;
         String query = "insert into meter_info values('"+meter+"' , '"+location+"' , '"+type+"' , '"+code+"' , '"+typebill+"'  ,'"+days+"')";
         
         try
         {
             Conn c = new Conn();
             c.s.executeUpdate(query);
//             c.s.executeUpdate(query2);
             
             JOptionPane.showMessageDialog(null , "Meter Execution Added Successfully");
             setVisible(false);
             
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
        new Meterinfo("");
    }
}
