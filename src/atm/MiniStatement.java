
package atm;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;


public class MiniStatement extends JFrame {
    MiniStatement(String pinnumber){
        setTitle("MINI STATEMENT ");
        setLayout(null);
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("MINE BANK ");
        bank.setBounds(150, 20, 100, 30);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 30);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("card number:" + rs.getString(" cardNumber").substring(0,4));
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html> " + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+ "<br><br></html>");
                if(rs.getString("type").equals("Deposit")){
                        bal +=Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        bal -=Integer.parseInt(rs.getString("amount"));
                    } 
            }
            balance.setText("YOUR CURRENT BALANCE IS RS " + bal);
        }catch(Exception e){
            System.out.println(e);
        }
        mini.setBounds(20, 140, 400, 200);
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String args[]){
        new MiniStatement("");
    }
}
