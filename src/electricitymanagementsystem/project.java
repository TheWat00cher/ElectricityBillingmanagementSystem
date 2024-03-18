
package electricitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class project extends JFrame implements ActionListener{
    
    String atype;
    String meter;
    
    project(String atype , String meter)
        {
            this.meter = meter;
            this.atype = atype;
           setExtendedState(JFrame.MAXIMIZED_BOTH);
           
           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
           Image i2 = i1.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2);
           JLabel image = new JLabel(i3);
           add(image);
           
           JMenuBar mb = new JMenuBar();
           setJMenuBar(mb);
           
           JMenu master = new JMenu("Master");
           master.setForeground(Color.BLUE);
           
           
           JMenuItem newcustomer = new JMenuItem("New Customer");
           newcustomer.setFont(new Font("monospaced" , Font.PLAIN , 13));
           newcustomer.setBackground(Color.WHITE);
           ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
           Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           newcustomer.setIcon(new ImageIcon(image1));
           newcustomer.setMnemonic('D');
           newcustomer.addActionListener(this);
           newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D , ActionEvent.CTRL_MASK));
           master.add(newcustomer);
           
           JMenuItem customerdetails = new JMenuItem("Customer Details");
           customerdetails.setFont(new Font("monospaced" , Font.PLAIN , 13));
           customerdetails.setBackground(Color.WHITE);
           ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
           Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           customerdetails.setIcon(new ImageIcon(image1));
           customerdetails.setMnemonic('M');
           customerdetails.addActionListener(this);
           customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M , ActionEvent.CTRL_MASK));
           master.add(customerdetails);
           
           JMenuItem depositdetails = new JMenuItem("Deposit Details");
           depositdetails.setFont(new Font("monospaced" , Font.PLAIN , 13));
           depositdetails.setBackground(Color.WHITE);
           ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
           Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           depositdetails.setIcon(new ImageIcon(image1));
           depositdetails.setMnemonic('N');
           depositdetails.addActionListener(this);
           depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N , ActionEvent.CTRL_MASK));
           master.add(depositdetails);
           
           JMenuItem calculatebill = new JMenuItem("Calculate Bill");
           calculatebill.setFont(new Font("monospaced" , Font.PLAIN , 13));
           calculatebill.setBackground(Color.WHITE);
           ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
           Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           calculatebill.setIcon(new ImageIcon(image1));
           calculatebill.setMnemonic('B');
           calculatebill.addActionListener(this);
           calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B , ActionEvent.CTRL_MASK));
           master.add(calculatebill);
           
           JMenu info = new JMenu("Information");
           info.setForeground(Color.BLUE);
           
           
           JMenuItem upadteinfo = new JMenuItem("Update Information");
           upadteinfo.setFont(new Font("monospaced" , Font.PLAIN , 13));
           upadteinfo.setBackground(Color.WHITE);
           ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
           Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           upadteinfo.setIcon(new ImageIcon(image1));
           upadteinfo.setMnemonic('I');
           upadteinfo.addActionListener(this);
           upadteinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I , ActionEvent.CTRL_MASK));
           info.add(upadteinfo);
           
           JMenuItem viewinfo = new JMenuItem("View Information");
           viewinfo.setFont(new Font("monospaced" , Font.PLAIN , 13));
           viewinfo.setBackground(Color.WHITE);
           ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
           Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           viewinfo.setIcon(new ImageIcon(image1));
           viewinfo.setMnemonic('P');
           viewinfo.addActionListener(this);
           viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , ActionEvent.CTRL_MASK));
           info.add(viewinfo);
           
           JMenu user = new JMenu("User");
           user.setForeground(Color.BLUE);
           
           
           JMenuItem paybill = new JMenuItem("Pay Bill");
           paybill.setFont(new Font("monospaced" , Font.PLAIN , 13));
           paybill.setBackground(Color.WHITE);
           ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
           Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           paybill.setIcon(new ImageIcon(image1));
           paybill.setMnemonic('R');
           paybill.addActionListener(this);
           paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R , ActionEvent.CTRL_MASK));
           user.add(paybill);
           
           JMenuItem billdetails = new JMenuItem("Bill Details");
           billdetails.setFont(new Font("monospaced" , Font.PLAIN , 13));
           billdetails.setBackground(Color.WHITE);
           ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
           Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           billdetails.setIcon(new ImageIcon(image1));
           billdetails.setMnemonic('Y');
           billdetails.addActionListener(this);
           billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y , ActionEvent.CTRL_MASK));
           user.add(billdetails);
           
           JMenu report = new JMenu("Report");
           report.setForeground(Color.BLUE);
           
           
           JMenuItem generatebill = new JMenuItem("Generate Bill");
           generatebill.setFont(new Font("monospaced" , Font.PLAIN , 13));
           generatebill.setBackground(Color.WHITE);
           ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
           Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           generatebill.setIcon(new ImageIcon(image1));
           generatebill.setMnemonic('G');
           generatebill.addActionListener(this);
           generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G , ActionEvent.CTRL_MASK));
           report.add(generatebill);
           
           JMenu utility = new JMenu("Utility");
           utility.setForeground(Color.BLUE);
           
           
           JMenuItem notepad = new JMenuItem("Notepad");
           notepad.setFont(new Font("monospaced" , Font.PLAIN , 13));
           notepad.setBackground(Color.WHITE);
           ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon10.png"));
           Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           notepad.setIcon(new ImageIcon(image1));
           notepad.setMnemonic('U');
           notepad.addActionListener(this);
           notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U , ActionEvent.CTRL_MASK));
           utility.add(notepad);
           
           
           JMenuItem calculator = new JMenuItem("Calculator");
           calculator.setFont(new Font("monospaced" , Font.PLAIN , 13));
           calculator.setBackground(Color.WHITE);
           ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon10.png"));
           Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           calculator.setIcon(new ImageIcon(image1));
           calculator.setMnemonic('R');
           calculator.addActionListener(this);
           calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R , ActionEvent.CTRL_MASK));
           utility.add(calculator);
           
           JMenu mexit = new JMenu("Exit");
           mexit.setForeground(Color.BLUE);
           
           
           JMenuItem exit = new JMenuItem("Exit");
           exit.setFont(new Font("monospaced" , Font.PLAIN , 13));
           exit.setBackground(Color.WHITE);
           ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
           Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           exit.setIcon(new ImageIcon(image1));
           exit.setMnemonic('W');
           exit.addActionListener(this);
           exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W , ActionEvent.CTRL_MASK));
           mexit.add(exit);
           
           if(atype.equals("Admin"))
           {
              mb.add(master);
           }else
           {
               mb.add(info);
               mb.add(user);
               mb.add(report);
           }
           
           setLayout(new FlowLayout());
           
          
           mb.add(utility);
           mb.add(mexit);
           
           setVisible(true);
        }
    public void actionPerformed(ActionEvent ae)
    {
        String msg = ae.getActionCommand();
        if(msg.equals("New Customer"))
        {
            new Newcustomer();
        }else if(msg.equals("Customer Details"))
        {
            new Customerdetails();
        }else if(msg.equals("Deposit Details"))
        {
            new Depositdetails();
        }else if(msg.equals("Calculate Bill"))
        {
             new calculatebill();
        }else if(msg.equals("View Information"))
        {
            new Viewinformation(meter);
        }else if(msg.equals("Update Information"))
        {
            new update(meter);
        }else if(msg.equals("Bill Details"))
        {
            new Billdetails(meter);
        }else if(msg.equals("Notepad"))
        {
            try
            {
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e)
            {
                e.printStackTrace();
            }
               
        }
        else if(msg.equals("Calculator"))
        {
            try
            {
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e)
            {
                e.printStackTrace();
            }
         }
        else if(msg.equals("Exit"))
        {
            setVisible(false);
            new login();
        }else if(msg.equals("Pay Bill"))
        {
            new paybill(meter);
        }else if(msg.equals("Generate Bill"))
        {
            new GenerateBill(meter);
        }
    }
    
     public static void main(String[] args)
     {
        new project("" , ""); 
     }
}
