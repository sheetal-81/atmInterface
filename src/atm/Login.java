package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import java.awt.Color;
public class Login extends JFrame implements ActionListener{
    JButton login,signup,clear;
    JTextField cardTextField,pinTextField;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        
        
        JLabel text=new JLabel("WELCOME TO ATM INTERFACE");
        text.setFont(new Font("osward",Font.BOLD,35));
        text.setBounds(200,40 ,700,40);
        add(text);
        
        JLabel cardno=new JLabel("CARD NO.");
        cardno.setFont(new Font("osward",Font.BOLD,28));
        cardno.setBounds(120,150 ,150,40);
        add(cardno);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,250,28);
        add(cardTextField);
        
        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("osward",Font.BOLD,28));
        pin.setBounds(120,220 ,250,30);
        add(pin);
        
        pinTextField=new JTextField();
        pinTextField.setBounds(300,220,230,28);
        add(pinTextField);
        
        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource()==login){
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardNumber ='"+cardNumber+"' and pinnumber = '"+pinnumber+"'";
            try{
                 ResultSet rs = conn.s.executeQuery(query);
                 if(rs.next()){
                     setVisible(false);
                     new Transactions(pinnumber).setVisible(true);
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"INCOORECT card number or pin number");
                 }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
    }
    }
    public static void main(String args[]){
        new Login();
    }

    
    
}
