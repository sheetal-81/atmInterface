package atm;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        back = new JButton("BLACK");
        back.setBounds(355,520,150,30);
        back.setBackground(Color.RED);
        back.addActionListener(this);
        add(back);
        
        
            Conn c = new Conn();
            int balance = 0;
            try {
                ResultSet rs = c.s.executeQuery("SELECT SUM(amount) AS total FROM bank WHERE pin ='" + pinnumber + "'");
                if (rs.next()) {
                    balance = rs.getInt("total");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

            JLabel text = new JLabel("YOUR CURRENT BALANCE IS RS = " + balance);

            text.setForeground(Color.RED);
            text.setBounds(100, 300, 800, 40);
            text.setFont(new Font("System",Font.BOLD,38));
            add(text);
                
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
