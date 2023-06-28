package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceEnquire,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        
        JLabel text = new JLabel("SELECT THE WITHDRAWL AMOUNT ");
        text.setBounds(100, 200, 800,30 );
        text.setForeground(Color.RED);
        text.setFont(new Font("System",Font.BOLD,40));
        add(text);
        
        deposit=new JButton("RS 100");
        deposit.setBounds(170,350,250,30);
        deposit.addActionListener(this);
        add(deposit);
        
        withdrawl=new JButton("RS 500");
        withdrawl.setBounds(570,350,250,30);
        withdrawl.addActionListener(this);
        add(withdrawl);
        
        fastcash=new JButton("RS 1000");
        fastcash.setBounds(170,450,250,30);
        fastcash.addActionListener(this);
        add(fastcash);
        
        ministatement=new JButton("RS 2000");
        ministatement.setBounds(570,450,250,30);
        ministatement.addActionListener(this);
        add(ministatement);
        
        pinchange=new JButton("RS 5000");
        pinchange.setBounds(170,550,250,30);
        pinchange.addActionListener(this);
        add(pinchange);
        
        balanceEnquire=new JButton("10,000");
        balanceEnquire.setBounds(570,550,250,30);
        balanceEnquire.addActionListener(this);
        add(balanceEnquire);
        
        exit=new JButton("EXIT");
        exit.setBounds(170,650,660,30);
        exit.addActionListener(this);
        add(exit);
        
        
      setSize(900,900);
      setLocation(300,0);
     // setUndecorated(true);
      setVisible(true);
      
      
    }
    
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == exit) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    } else {
        String buttonText = ((JButton) ae.getSource()).getText().substring(3); // Renamed 'amount' to 'buttonText'
        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin ='" + pinnumber + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            if (ae.getSource() != exit && balance < Integer.parseInt(buttonText)) {
                JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE");
                return;
            }
            Date date = new Date();
            double amountValue = Double.parseDouble(buttonText); // Convert the buttonText string to a double value
            String query = "INSERT INTO bank VALUES ('" + pinnumber + "','" + date + "','withdraw','" + amountValue + "')";

            // String query = "insert into bank values('"+pinnumber+"', '"+date+"', '"+withdrawl+"', '"+amount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs " + buttonText + " DEBITED SUCCESSFULLY");
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

    
    public static void main(String args[]){
        new FastCash(" ");
    }
    
}