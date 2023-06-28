package atm;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener{
    //long random;
    JTextField pan,aadhar;
    JButton next;
    JRadioButton SYES,SNO,EYES,ENO;
    JComboBox religion,category,income,qualification,occupation;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("APPLICATION FORM-PAGE 2");
        
        
        JLabel additionalDetails=new JLabel("page 2:- ADDITIONAL Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
       
        String valReligion[]={"HINDU","CHRISTIAN","MUSLIM","SIKH","other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel name=new JLabel("RELIGION: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,200,30);
        add(name);
        
        String valCategory[]={"GENERAL","SC","ST","OBC","VJNT","other"};
        category=new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        JLabel Fname=new JLabel(" CATEGORY: ");
        Fname.setFont(new Font("Raleway",Font.BOLD,20));
        Fname.setBounds(100,190,200,30);
        add(Fname);
        
        String valIncome[]={"NULL","<1 lakh","<5 lakh","<10 lakh","<50 lakh"};
        income=new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel DOB=new JLabel(" INCOME :--");
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        DOB.setBounds(100,240,200,30);
        add(DOB);
        
        String valQualification[]={"SSC","HSC","GRADUATE","POST-GRADUATE","other"};
        qualification=new JComboBox(valQualification);
        qualification.setBounds(300,290,400,30);
        qualification.setBackground(Color.WHITE);
        add(qualification);
        
       
        JLabel email=new JLabel(" QUALIFICATION: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,290,200,30);
        add(email);
        
        
        JLabel gender=new JLabel(" SENIOR CITIZEN : ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,340,200,30);
        add(gender);
        
        SYES=new JRadioButton("YES");
        SYES.setBounds(300,340,60,30);
        SYES.setBackground(Color.WHITE);
        add(SYES);
        
        SNO=new JRadioButton("NO");
        SNO.setBounds(450,340,120,30);
        SNO.setBackground(Color.WHITE);
        add(SNO);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(SYES);
        gendergroup.add(SNO);
        
        String valOccupation[]={"SALARIED","SELF-EMPLOYED","BUSSINESSMAN","STUDENT","other"};
        occupation=new JComboBox(valOccupation);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel marital=new JLabel(" OCCUPATION: ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,22));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel pan=new JLabel(" PAN number : ");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,22));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel aadhar=new JLabel(" Aadhar no.: ");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);
        
      
        EYES=new JRadioButton("YES");
        EYES.setBounds(300,590,60,30);
        EYES.setBackground(Color.WHITE);
        add(EYES);
        
        ENO=new JRadioButton("NO");
        ENO.setBounds(450,590,120,30);
        ENO.setBackground(Color.WHITE);
        add(ENO);
        
        ButtonGroup accountgroup=new ButtonGroup();
        accountgroup.add(EYES);
        accountgroup.add(ENO);
        
        JLabel pincode=new JLabel(" EXISTING ACCOUNT : ");
        pincode.setFont(new Font("Raleway",Font.BOLD,16));
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
        //String formno="" + random;
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String squalification=(String)qualification.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(SYES.isSelected()){
            seniorcitizen="yes";
        }
        else if(SNO.isSelected()){
            seniorcitizen="no";
        }
        
        String existingaccount=null;
        if(EYES.isSelected()){
            existingaccount="YES";
        }else if(ENO.isSelected()){
            existingaccount="NO";
        }
        String span=pan.getText();
        String saadhar=aadhar.getText();
        try{
                Conn c=new Conn();
                String query = "INSERT INTO signuptwo VALUES('" + formno + "', '" + sreligion + "', '"+scategory+"', '" + sincome + "', '" + squalification + "', '" + seniorcitizen + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + existingaccount + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        catch(Exception e){
            System.out.println(e);
        }
    }
    

    public static void main(String args[]){
    new SignupTwo("");
    }
}
 





