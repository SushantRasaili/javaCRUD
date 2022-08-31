
import java.awt.FlowLayout;

import javax.swing.*;
import java.awt.event.*;

//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;


public class StudentForm {

	public StudentForm() {
		JFrame frame = new JFrame("Student Form");
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		JLabel fName = new JLabel("First Name");
        frame.getContentPane().add(fName);
        
        JTextField fnVal = new JTextField(20);
        frame.getContentPane().add(fnVal);
        
        JLabel lName = new JLabel("Last Name");
        frame.getContentPane().add(lName);
        
        JTextField lnVal = new JTextField(20);
        frame.getContentPane().add(lnVal);
        
        JLabel addr = new JLabel("Address");
        frame.getContentPane().add(addr);
        
        JTextField addrVal = new JTextField(20);
        frame.getContentPane().add(addrVal);
        
        JLabel conNum = new JLabel("Contact:");
        frame.getContentPane().add(conNum);
        
        JTextField conVal= new JTextField(20);
        frame.getContentPane().add(conVal);
        
        JLabel clas = new JLabel("Class");
        frame.getContentPane().add(clas);
        
        JComboBox clasVal = new JComboBox();
        clasVal.setModel(new DefaultComboBoxModel(new String[] {"Nursery","LKG","UKG"}));
        frame.getContentPane().add(clasVal);
        
        JLabel gender = new JLabel("Gender");
        frame.getContentPane().add(gender);
        
        JComboBox genderVal = new JComboBox();
        genderVal.setModel(new DefaultComboBoxModel(new String[] {"Male","Female","Others"}));
        frame.getContentPane().add(genderVal);
        
        JLabel sec = new JLabel("Section");
        frame.getContentPane().add(sec);
        
        JComboBox secVal = new JComboBox();
        secVal.setModel(new DefaultComboBoxModel(new String[] {"A","B","C","D"}));
        frame.getContentPane().add(secVal);
        
        JButton subBtn = new JButton("Submit");
        frame.getContentPane().add(subBtn);
        subBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		StudentDao student = new StudentDao();
        		student.setFirstName(fnVal.getText());
        		student.setLastName(lnVal.getText());
        		student.setAddress(addrVal.getText());
        		student.setContactNumber(Long.valueOf(conVal.getText()));
        		student.setGrade((String)clasVal.getSelectedItem());
        		student.setGender((String)genderVal.getSelectedItem());
        		student.setSection((String)secVal.getSelectedItem());
        		
           Student s1= new StudentImpl();
           s1.saveStudent(student);
            frame.dispose();
            new StudentDetails().setVisible(true);
          	
        		
        	}
        });
      
        
        
		frame.setVisible(true);
		
		

	}

	public static void main(String[] args) {
		new StudentForm();

	}

}
