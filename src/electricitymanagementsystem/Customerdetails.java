
package electricitymanagementsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;



public class Customerdetails extends JFrame implements ActionListener  {
    
    Choice meternumber , month;
    JTable table;
    JButton search , print;
    
    Customerdetails()
    {
        super("Customer Deatils");
        
        setSize(1000 , 600);
        setLocation(150 , 100);        
        
        table = new JTable();
        
        try
        {
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("select *from customer");
          
          table.setModel(DbUtils.resultSetToTableModel(rs));
          
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
//        sp.setBounds(0 ,100 ,700 ,600);        
        add(sp);
        
        print = new JButton("print");
//        print.setBounds(550 , 70 , 80 , 20);
        print.addActionListener(this);
        add(print , "South");
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try
            {
                table.print();
            }catch(Exception e)
            {
                e.printStackTrace();
            }     
    }
    
    public static void main(String[] args)
    {
       new Customerdetails();   
    }
}
