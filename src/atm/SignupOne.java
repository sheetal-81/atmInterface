package atm;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,FnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton male,female,married,unmarried;
    JDateChooser dateChooser;
    SignupOne(){
        setLayout(null);
        Random ran=new Random();
        long random=Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formno=new JLabel("APPLICATION FORM NO."+ random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personDetails=new JLabel("page 1:- personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,20));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,22));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel name=new JLabel("NAME:--");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,200,30);
        add(name);
        
        FnameTextField=new JTextField();
        FnameTextField.setFont(new Font("Raleway",Font.BOLD,22));
        FnameTextField.setBounds(300,190,400,30);
        add(FnameTextField);
        
        JLabel Fname=new JLabel(" FATHER'S NAME:--");
        Fname.setFont(new Font("Raleway",Font.BOLD,20));
        Fname.setBounds(100,190,200,30);
        add(Fname);
        
        JLabel DOB=new JLabel(" DATE OF BIRTH :--");
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        DOB.setBounds(100,240,200,30);
        add(DOB);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,200,30);
        add(dateChooser);
        
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,22));
        emailTextField.setBounds(300,290,400,30);
        add(emailTextField);
        
        JLabel email=new JLabel(" EMAIL ADDRESS :--");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,290,200,30);
        add(email);
        
        JLabel gender=new JLabel(" GENDER :--");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,340,200,30);
        add(gender);
        
        male=new JRadioButton("male");
        male.setBounds(300,340,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female=new JRadioButton("female");
        female.setBounds(450,340,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        JLabel marital=new JLabel(" MARITAL STATUS:--");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        married=new JRadioButton("married");
        married.setBounds(300,390,80,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried=new JRadioButton("unmarried");
        unmarried.setBounds(450,390,120,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        ButtonGroup other=new ButtonGroup();
        other.add(married);
        other.add(unmarried);
        
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,22));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        JLabel add=new JLabel(" ADDRESS :--");
        add.setFont(new Font("Raleway",Font.BOLD,20));
        add.setBounds(100,440,200,30);
        add(add);
        
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,22));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel city=new JLabel(" CITY :--");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,22));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        JLabel state=new JLabel(" STATE :--");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        pincodeTextField=new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,22));
        pincodeTextField.setBounds(300,590,400,30);
        add(pincodeTextField);
        
        JLabel pincode=new JLabel(" PINCODE :--");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,16));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno="" + random;
        String name=nameTextField.getText();
        String Fname=FnameTextField.getText();
        String DOB=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="male";
        }
        else if(female.isSelected()){
            gender="female";
        }
        String email=emailTextField.getText();
        String marital=null;
        if(married.isSelected()){
            marital="married";
        }else if(unmarried.isSelected()){
            marital="unmarried";
        }
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pincode=pincodeTextField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"required");
            }
            else{
                Conn c=new Conn();
                String query = "INSERT INTO signup VALUES('" + formno + "', '" + name + "', '" + Fname + "', '" + DOB + "', '" + email + "', '" + gender + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pincode + "')";

                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    

    public static void main(String args[]){
    new SignupOne();
    }
}


