package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        JLabel text=new JLabel("ENTER THE AMOUNT FOR WITHDRAW");
        text.setForeground(Color.RED);
        text.setFont(new Font("System",Font.BOLD,36));
        text.setBounds(170,300,700,45);
        add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(270, 400, 320, 50);
        add(amount);
        
        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(170, 550, 150, 50);
        withdraw.setBackground(Color.RED);
        withdraw.addActionListener(this);
        add(withdraw);
        
        back = new JButton("BACK");
        back.setBounds(525, 550, 150, 50);
        back.setBackground(Color.RED);
        back.addActionListener(this);
        add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
   
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == withdraw) {
        String number = amount.getText();
        Date date = new Date();
        if (number.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the amount");
        } else {
            try {
                Conn conn = new Conn();
                String query = "INSERT INTO bank VALUES ('" + pinnumber + "','" + date + "','withdraw','" + number + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + number + " withdrawn successfully");
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

    
    public static void main(String args[]){
       new Withdrawl(" "); 
       
    }
            
}
