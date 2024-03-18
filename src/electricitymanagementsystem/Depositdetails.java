
package electricitymanagementsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Depositdetails extends JFrame implements ActionListener  {
    
    Choice meternumber , month;
    JTable table;
    JButton search , print;
    
    Depositdetails()
    {
        super("Deposit Deatils");
        
        setSize(700 , 600);
        setLocation(400 , 100);
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblmeternumber = new JLabel("Search By Meter Number");
        lblmeternumber.setBounds(20 ,20 , 150 , 20);
        add(lblmeternumber);
        
        meternumber = new Choice();
        meternumber.setBounds(180 , 20 , 150 , 20);
        add(meternumber);
        
        try
        {
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("select *from customer");
          while(rs.next())
          {
              meternumber.add(rs.getString("mater_no"));
          }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel lblmonth = new JLabel("Search by Month");
        lblmonth.setBounds(350 ,20 , 150 , 20);
        add(lblmonth);
        
        month = new Choice();
        month.setBounds(500 , 20 , 150 , 20);
        month.add("January");
        month.add("February");
        month.add("March");
        month.add("April");
        month.add("May");
        month.add("June");
        month.add("July");
        month.add("August");
        month.add("September");
        month.add("October");
        month.add("November");
        month.add("December");
        add(month);
        
        table = new JTable();
        
        try
        {
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("select *from bill");
          
          table.setModel(DbUtils.resultSetToTableModel(rs));
          
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0 ,100 ,700 ,600);
        add(sp);
        
        search = new JButton("search");
        search.setBounds(20 , 70 , 80 , 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("print");
        print.setBounds(550 , 70 , 80 , 20);
        print.addActionListener(this);
        add(print);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == search)
        {
            String query = "select * from bill where meter_no = '"+meternumber.getSelectedItem()+"' and month = '"+month.getSelectedItem()+"'";
            try
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }else
        {
            try
            {
              table.print();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args)
    {
       new Depositdetails();   
    }
}
