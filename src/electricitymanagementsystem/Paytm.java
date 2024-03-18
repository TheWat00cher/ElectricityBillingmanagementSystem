
package electricitymanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Paytm extends JFrame implements ActionListener{
    
    
    JButton back;
    Paytm(String meter)
    {
        JEditorPane j = new JEditorPane();
        j.setEditable(false);
        
        try
        {
            j.setPage("https://paytm.com/online-payments");
        }catch(Exception e)
        {
            j.setContentType("text/html");
            j.setText("<html>Could Not Load</html>");
        }
          
        JScrollPane panel = new JScrollPane(j);
        add(panel);
        
        back = new JButton("BACK");
        back.setBounds(700 , 20 , 80 , 20);
        back.addActionListener(this);
        j.add(back);
        
        setSize(1000 , 600);
        setLocation(200 , 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new paybill("");
    }
    
    public static void main(String[] args)
    {
        new Paytm("");
    }
}
