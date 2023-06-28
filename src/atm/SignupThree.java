package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignupThree extends JFrame  implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
   SignupThree( String formno){
       this.formno=formno;
       setLayout(null);
       
       JLabel l1=new JLabel("PAGE 3:--ACCOUNT DETAILS");
       l1.setFont(new Font("Raleway",Font.BOLD,28));
       l1.setBounds(280,40,400,40);
       add(l1);
       
       JLabel type =new JLabel("ACCOUNT TYPE: ");
       type.setFont(new Font("Raleway",Font.BOLD,22));
       type.setBounds(100,140,200,40);
       add(type);
       
       r1=new JRadioButton("SAVING ACCOUNT");
       r1.setFont(new Font("Raleway",Font.BOLD,14));
       r1.setBackground(Color.WHITE);
       r1.setBounds(100,180,180,20);
       add(r1);
       
       r2=new JRadioButton("FIXED DEPOSIT");
       r2.setFont(new Font("Raleway",Font.BOLD,14));
       r2.setBackground(Color.WHITE);
       r2.setBounds(350,180,180,20);
       add(r2);
       
       r3=new JRadioButton("CURRENT ACCOUNT");
       r3.setFont(new Font("Raleway",Font.BOLD,14));
       r3.setBackground(Color.WHITE);
       r3.setBounds(100,220,180,20);
       add(r3);
       
       r4=new JRadioButton("Recurring deposit ACCOUNT");
       r4.setFont(new Font("Raleway",Font.BOLD,14));
       r4.setBackground(Color.WHITE);
       r4.setBounds(350,220,250,20);
       add(r4);
       
       ButtonGroup groupaccount=new ButtonGroup();
       groupaccount.add(r1);
       groupaccount.add(r2);
       groupaccount.add(r3);
       groupaccount.add(r4);
       
       JLabel card =new JLabel("Card no: ");
       card.setFont(new Font("Raleway",Font.BOLD,22));
       card.setBounds(100,300,200,40);
       add(card);
       
       JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
       number.setFont(new Font("Raleway",Font.BOLD,22));
       number.setBounds(330,300,300,40);
       add(number);
       
       JLabel carddetail =new JLabel("YOUR 16 DIGIT CARD NO.: ");
       carddetail.setFont(new Font("Raleway",Font.BOLD,12));
       carddetail.setBounds(100,330,300,20);
       add(carddetail);
       
       
       JLabel pin=new JLabel("PIN no: ");
       pin.setFont(new Font("Raleway",Font.BOLD,22));
       pin.setBounds(100,370,200,40);
       add(pin);
       
       JLabel pnumber=new JLabel("XXXX");
       pnumber.setFont(new Font("Raleway",Font.BOLD,22));
       pnumber.setBounds(330,370,300,40);
       add(pnumber);
       
       JLabel pindetail =new JLabel("YOUR 4 DIGIT PIN NO.: ");
       pindetail.setFont(new Font("Raleway",Font.BOLD,12));
       pindetail.setBounds(100,400,300,20);
       add(pindetail);
       
       JLabel services =new JLabel("SERVICES REQUIRED.:-- ");
       services.setFont(new Font("Raleway",Font.BOLD,22));
       services.setBounds(100,450,300,20);
       add(services);
       
       c1=new JCheckBox("ATM");
       c1.setBackground(Color.WHITE);
       c1.setFont(new Font("Raleway",Font.BOLD,16));
       c1.setBounds(100, 500,200,30);
       add(c1);
       
       c2=new JCheckBox("INTERNET BANKING");
       c2.setBackground(Color.WHITE);
       c2.setFont(new Font("Raleway",Font.BOLD,16));
       c2.setBounds(350, 500,200,30);
       add(c2);
       
       c3=new JCheckBox("MOBILE BANKING");
       c3.setBackground(Color.WHITE);
       c3.setFont(new Font("Raleway",Font.BOLD,16));
       c3.setBounds(100, 550,200,30);
       add(c3);
       
       c4=new JCheckBox("EMAIL & SMS ALERTS");
       c4.setBackground(Color.WHITE);
       c4.setFont(new Font("Raleway",Font.BOLD,16));
       c4.setBounds(350, 550,300,30);
       add(c4);
       
       c5=new JCheckBox("cheque book");
       c5.setBackground(Color.WHITE);
       c5.setFont(new Font("Raleway",Font.BOLD,16));
       c5.setBounds(100, 600,200,30);
       add(c5);
       
       c6=new JCheckBox("E statement");
       c6.setBackground(Color.WHITE);
       c6.setFont(new Font("Raleway",Font.BOLD,16));
       c6.setBounds(350, 600,200,30);
       add(c6);
       
       c7=new JCheckBox("I hereby declare that above mentined details are correct");
       c7.setBackground(Color.WHITE);
       c7.setFont(new Font("Raleway",Font.BOLD,16));
       c7.setBounds(100, 680,480,30);
       add(c7);
       
       submit=new JButton("SUBMIT");
       submit.setBackground(Color.RED);
       submit.setForeground(Color.WHITE);
       submit.setFont(new Font("Raleway",Font.BOLD,14));
       submit.setBounds(220,740,100,30);
       submit.addActionListener(this);
       add(submit);
       
       cancel=new JButton("CANCEL");
       cancel.setBackground(Color.RED);
       cancel.setForeground(Color.WHITE);
       cancel.setFont(new Font("Raleway",Font.BOLD,14));
       cancel.setBounds(480,740,100,30);
       cancel.addActionListener(this);
       add(cancel);
       
       getContentPane().setBackground(Color.WHITE);
       
       setSize(850,820);
       setLocation(350,0);
       setVisible(true);
   }
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==submit){
           String accountType=null;
           if(r1.isSelected()){
               accountType="SAVING ACCOUNT";
           }
           else if(r2.isSelected()){
               accountType="FIXED DEPOSIT";
           }
           else if(r3.isSelected()){
               accountType="CURRENT ACCOUNT";
           }
           else if(r4.isSelected()){
               accountType="Recurring deposit ACCOUNT";
           }
           Random random=new Random();
           String cardNumber="" + Math.abs((random.nextLong() % 90000000L) + 50409360000000000L);
           String pinnumber="" + Math.abs((random.nextLong() % 9000L) + 1000L);
           String facility="";
           if(c1.isSelected()){
               facility = facility + "ATM";
           }
           else if(c2.isSelected()){
               facility = facility + "INTERNET BANKING";
           }
            else if(c3.isSelected()){
               facility = facility + "MOBILE BANKING";
           }
            else if(c4.isSelected()){
               facility = facility + "EMAIL & SMS ALERTS";
           }
            else if(c5.isSelected()){
               facility = facility + "cheque book";
           }
            else if(c6.isSelected()){
               facility = facility + "E statement";
           }
            else if(c7.isSelected()){
               facility = facility + "ATM";
           }
           try{
               if(accountType.equals("")){
                   JOptionPane.showMessageDialog(null,"ACCOUNT TYPE IS REQUIRED");
               }
               else{
                   Conn conn = new Conn();
                   String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinnumber+"', '"+facility+"')";
                   String query2 = "insert into login values('"+formno+"', '"+cardNumber+"', '"+pinnumber+"' )";
                   conn.s.executeUpdate(query1);
                   conn.s.executeUpdate(query2);
                   JOptionPane.showMessageDialog(null,"card no:" + cardNumber +"\n pin: " + pinnumber );
               }
               setVisible(false);
               new Deposit(pinnumber).setVisible(false);
               
           }catch(Exception e){
               System.out.println(e);
           }
           
           
       }else if(ae.getSource()==cancel){
           setVisible(false);
           new Login().setVisible(true);
       }
   }
   public static void main(String args[]){
       new SignupThree("");
   }
}
