
package electricitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class GenerateBill extends JFrame implements ActionListener{
    
    String meter;
    JButton bill;
    Choice cmonth;
    JTextArea area;
    GenerateBill(String meter)
    {
        this.meter = meter;
        setSize(500 , 700);
        setLocation(500 , 20);
        
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        JLabel heading = new JLabel("Generate Bill");
        JLabel meternumber = new JLabel(meter);
        
        cmonth = new Choice();
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
        
        area = new JTextArea(50 , 15);
        area.setText("\n\n\t ------- Click on the------\n\t Generate Bill Button to get \n\t the Bill of the Slected Month");
        area.setFont(new Font("Senserif" , Font.ITALIC , 20));
        JScrollPane pane = new JScrollPane(area);
        
        JButton bill = new JButton("Generate Bill");
        bill.addActionListener(this);
        
        panel.add(heading);
        panel.add(meternumber);
        panel.add(cmonth);
        add(panel , "North");
        
        add(pane , "Center");
        add(bill , "South");
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            Conn c = new Conn();
            
            String month = cmonth.getSelectedItem();
            
            
            area.setText("        Calcutta Electricity Supply Commission\n      Electricity Bill Generated For the month of \n\t "+month+" , 2024\n\n\n");
            
            ResultSet rs = c.s.executeQuery("select * from customer where mater_no = '"+meter+"' ");
            
            if(rs.next())
            {
                area.append("\n   Customer Name :  " +rs.getString("name"));
                area.append("\n   Meter Number  :  " +rs.getString("mater_no"));
                area.append("\n   Address       :  " +rs.getString("address"));
                area.append("\n   State         :  " +rs.getString("state"));
                area.append("\n   City          :  " +rs.getString("city"));
                area.append("\n   Phone Number  :  " +rs.getString("phone_no"));
                area.append("\n   Email Address :  " +rs.getString("email"));
                area.append("\n------------------------------------------");
                area.append("\n");
            }
            
            rs = c.s.executeQuery("select * from meter_info where meter_no = '"+meter+"' ");
            
            if(rs.next())
            {
                area.append("\n   Meter Location :  " +rs.getString("meter_location"));
                area.append("\n   Meter Type     :  " +rs.getString("meter_type"));
                area.append("\n   Phase Code     :  " +rs.getString("phase_code"));
                area.append("\n   Bill Type      :  " +rs.getString("bill_type"));
                area.append("\n   Days           :  " +rs.getString("days"));
                area.append("\n------------------------------------------");
                area.append("\n");
                
            }
            
            rs = c.s.executeQuery("select * from tax ");
            
            if(rs.next())
            {
                area.append("\n   Cost Per Unit        :  " +rs.getString("cost_per_unit"));
                area.append("\n   Meter Rent           :  " +rs.getString("meter_rent"));
                area.append("\n   Service Charge       :  " +rs.getString("service_charge"));
                area.append("\n   Service Tax          :  " +rs.getString("service_tax"));
                area.append("\n   Swacch Bharat Cess   :  " +rs.getString("swacch_bharat_cess"));
                area.append("\n   Fixed Tax            :  " +rs.getString("fixed_tax"));
//                area.append("\n   Days           :  " +rs.getString("days"));
                area.append("\n------------------------------------------");
                area.append("\n");
                
            }
            
            rs = c.s.executeQuery("select * from bill where meter_no = '"+meter+"' and month = '"+month+"'");
            
            if(rs.next())
            {
                area.append("\n   Current Month  :  " +rs.getString("month"));
                area.append("\n   Total Units     :  " +rs.getString("units"));
                area.append("\n   Total Bill     :  " +rs.getString("totalbill"));
                area.append("\n------------------------------------------");
                area.append("\n   Total Payable     :  " +rs.getString("totalbill"));
                area.append("\n");
                
            }
        }catch(Exception e)
        {
           e.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
      new GenerateBill("");  
    }
}
