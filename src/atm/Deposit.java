package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    Deposit(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        JLabel text=new JLabel("ENTER THE AMOUNT FOR DEPOSIT");
        text.setForeground(Color.RED);
        text.setFont(new Font("System",Font.BOLD,36));
        text.setBounds(170,300,700,50);
        add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(270, 390, 320, 40);
        add(amount);
        
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(170, 520, 150, 50);
        deposit.setBackground(Color.RED);
        deposit.addActionListener(this);
        add(deposit);
        
        back = new JButton("BACK");
        back.setBounds(600, 520, 150, 50);
        back.addActionListener(this);
        back.setBackground(Color.RED);
        add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == deposit) {
        String number = amount.getText();
        Date date = new Date();
        if (number.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the amount");
        } else {
            try {
                Conn conn = new Conn();
                String transactionType = "deposit";
                String amountData = number.substring(0, Math.min(number.length(), 210)); // Truncate the 'amount' data if it exceeds 210 characters
                String query = "INSERT INTO bank VALUES ('" + pinnumber + "','" + date + "','withdraw','" + amountData + "')";

                //String query = "INSERT INTO bank VALUES ('" + pinnumber + "','" + date + "','" + transactionType + "','" + amount + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + number + " DEPOSITED SUCCESSFULLY");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    } else if (ae.getSource() == back) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
}

public static void main(String args[]) {
    new Deposit(" ");
}
}

