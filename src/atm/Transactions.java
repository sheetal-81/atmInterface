
package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceEnquire,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        
        JLabel text = new JLabel(" PLEASE SELECT THE TRANSACTIONS ");
        text.setBounds(100, 200, 800,30 );
        text.setForeground(Color.RED);
        text.setFont(new Font("System",Font.BOLD,40));
        add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(170,350,250,30);
        deposit.addActionListener(this);
        add(deposit);
        
        withdrawl=new JButton("CASH WITHDRAWL");
        withdrawl.setBounds(570,350,250,30);
        withdrawl.addActionListener(this);
        add(withdrawl);
        
        fastcash=new JButton("FAST CASH");
        fastcash.setBounds(170,450,250,30);
        fastcash.addActionListener(this);
        add(fastcash);
        
        ministatement=new JButton("MINI STATEMENT");
        ministatement.setBounds(570,450,250,30);
        ministatement.addActionListener(this);
        add(ministatement);
        
        pinchange=new JButton("PIN CHANGE");
        pinchange.setBounds(170,550,250,30);
        pinchange.addActionListener(this);
        add(pinchange);
        
        balanceEnquire=new JButton("BALANCE ENQUIRY");
        balanceEnquire.setBounds(570,550,250,30);
        balanceEnquire.addActionListener(this);
        add(balanceEnquire);
        
        exit=new JButton("EXIT");
        exit.setBounds(170,650,660,50);
        exit.addActionListener(this);
        exit.setBackground(Color.RED);
        add(exit);
        
        
      setSize(900,900);
      setLocation(300,0);
     // setUndecorated(true);
      setVisible(true);
      
      
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == balanceEnquire){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == ministatement){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Transactions(" ");
    }
    
}
