package atm;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    JTextField pin,repin;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.red);
        text.setFont(new Font("System",Font.BOLD,38));
        text.setBounds(250,150,700,35);
        add(text);
        
        JLabel pintext = new JLabel("NEW PIN :-");
        pintext.setForeground(Color.BLACK);
        pintext.setFont(new Font("System",Font.BOLD,22));
        pintext.setBounds(100,380,500,35);
        add(pintext);
        
        pin = new JTextField();
        pin.setFont(new Font("Raleway",Font.BOLD,18));
        pin.setBounds(250, 380, 500,35 );
        add(pin);
        
        JLabel repintext = new JLabel(" RE- ENTER NEW PIN :-");
        repintext.setForeground(Color.BLACK);
        repintext.setFont(new Font("System",Font.BOLD,22));
        repintext.setBounds(100,500,500,35);
        add(repintext);
        
        repin = new JTextField();
        repin.setFont(new Font("Raleway",Font.BOLD,16));
        repin.setBounds(360, 500, 500,35 );
        add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(100, 680, 200, 40);
        change.addActionListener(this);
        change.setBackground(Color.RED);
        add(change);
        
        back = new JButton("BACK");
        back.setBounds(600, 680, 200, 40);
        back.setBackground(Color.RED);
        back.addActionListener(this);
        add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==change){
                try{
                    String npin = pin.getText();
                    String rpin = repin.getText();
                    if(!npin.equals(rpin)){
                        JOptionPane.showMessageDialog(null,"does not match");
                        return;

                    }
                    if(npin.equals("")){
                        JOptionPane.showMessageDialog(null,"enter the  new pin");
                        return;
                    }
                    if(rpin.equals("")){
                        JOptionPane.showMessageDialog(null,"enter the re-pin");
                        return;
                    }
                    Conn conn = new Conn();
                    String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                    String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                    String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null,"PIN CHANGED SUCCESSFULLY");
                    setVisible(false);
                    new Transactions(rpin).setVisible(true);
                    
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else{
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
    }
                
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
