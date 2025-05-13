
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
//import com.toedter.calender.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
    
    long random;
    JTextField nameTextField, fnameTextField,emailTextField;
    JButton next;
    JRadioButton male, female;
    
     SignupOne(){
         
         setLayout(null);
         
         Random ran = new Random();
         random = Math.abs((ran.nextLong()%9000L)+1000L);
         
         JLabel formno =new JLabel("Application Form No." + random);
         formno.setFont(new Font("Raleway",Font.BOLD,38));
         formno.setBounds(140,20,600,40);
         add(formno);
         
          JLabel personalDetails =new JLabel("Page 1: Personal Details");
         personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
         personalDetails.setBounds(290,80,400,30);
         add(personalDetails);
         
         JLabel name = new JLabel("Name:");
         name.setFont(new Font("Raleway",Font.BOLD,20));
         name.setBounds(100,140,100,30);
         add(name);
         
          nameTextField =new JTextField();
         nameTextField.setFont(new Font("Raleway", Font.BOLD,14));
         nameTextField.setBounds(300,140,400,30);
         add(nameTextField);
         
         JLabel fname = new JLabel("Father's Name:");
         fname.setFont(new Font("Raleway",Font.BOLD,20));
         fname.setBounds(100,190,200,30);
         add(fname);
         
         fnameTextField =new JTextField();
         fnameTextField.setFont(new Font("Raleway", Font.BOLD,14));
         fnameTextField.setBounds(300,190,400,30);
         add(fnameTextField);
         
         JLabel dob = new JLabel("Date of birth");
         dob.setFont(new Font("Raleway",Font.BOLD,20));
         dob.setBounds(100,240,200,30);
         add(dob );
         
         /*JDateChooser dateChooser =new JDateChooser();
         dateChooser.setBounds(300,240,400,30);
         add(dateChooser);*/
         
         JLabel gender = new JLabel("Gender:");
         gender.setFont(new Font("Raleway",Font.BOLD,20));
         gender.setBounds(100,290,200,30);
         add(gender);
         
         setLayout(null);
         male =new JRadioButton("Male");
         male.setBounds(300,290,60,30);
         male.setBackground(Color.WHITE);
         add(male);
         
         female =new JRadioButton("Female");
         female.setBounds(450,290,120,30);
         female.setBackground(Color.WHITE);
         add(female);
         
         ButtonGroup gendergroup = new ButtonGroup();
         gendergroup.add(male);
         gendergroup.add(female);
         
         JLabel email = new JLabel("Email Address:");
         email.setFont(new Font("Raleway",Font.BOLD,20));
         email.setBounds(100,340,200,30);
         add(email);
         
          emailTextField =new JTextField();
         emailTextField.setFont(new Font("Raleway", Font.BOLD,14));
         emailTextField.setBounds(300,340,400,30);
         add(emailTextField);
          
        next = new JButton("next");
        next.setFont(new Font("raleway", Font.BOLD,14 ));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
   
         
         getContentPane().setBackground(Color.WHITE);
         
         setSize(850,800);
         setLocation(305,10);
         setVisible(true);
     }
     
    @Override
     public void actionPerformed(ActionEvent ae){
         String formno = ""+random;
         String name = nameTextField.getText(); //setText
         String fname =fnameTextField.getText();
       //  String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
       String gender = null;
       if(male.isSelected()){
           gender="Male";
       }else if (female.isSelected()){
           gender = "Female";
       }
         String email = emailTextField.getText();
         
         try {
             if (name.equals("")){
                 JOptionPane.showMessageDialog(null, "Name is Required");
             } else {
                 Conn c =new Conn();
                 String query ="insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+gender+"','"+email+"')";
                 c.s.executeUpdate(query);
                 
                 setVisible(false);
                new SignupTwo(formno).setVisible(true);
             }
         }  catch (Exception e) {
             System.out.println(e);
         }
     }
    
    public static void main(String args[]) {
        new SignupOne();
        {
        
    }
        
        // TODO code application logic here
    }
}
