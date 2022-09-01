
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
//		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().setLayout(null);
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		JLabel fName = new JLabel("First Name");
		fName.setBounds(20, 20, 100, 20);
        frame.getContentPane().add(fName);
       
        
        JTextField fnVal = new JTextField();
        fnVal.setBounds(100,20,100,20);
        frame.getContentPane().add(fnVal);
        
        JLabel lName = new JLabel("Last Name");
        lName.setBounds(20, 60, 100, 20);
        frame.getContentPane().add(lName);
      
        
        JTextField lnVal = new JTextField();
        lnVal.setBounds(100, 60, 100, 20);
        frame.getContentPane().add(lnVal);
        
        
        JLabel addr = new JLabel("Address");
        addr.setBounds(20, 100, 100, 20);
        frame.getContentPane().add(addr);
        
        
        JTextField addrVal = new JTextField(20);
        addrVal.setBounds(100, 100, 100, 20);
        frame.getContentPane().add(addrVal);
       
        
        JLabel conNum = new JLabel("Contact:");
        conNum.setBounds(20, 140, 100, 20);
        frame.getContentPane().add(conNum);
        
        
        JTextField conVal= new JTextField(20);
        conVal.setBounds(100, 140, 100, 20);
        frame.getContentPane().add(conVal);
      
        
        JLabel clas = new JLabel("Class");
        clas.setBounds(20, 180, 100, 20);
        frame.getContentPane().add(clas);
       
        
        JComboBox clasVal = new JComboBox();
        clasVal.setModel(new DefaultComboBoxModel(new String[] {"Nursery","LKG","UKG"}));
        clasVal.setBounds(100, 180, 100, 20);
        frame.getContentPane().add(clasVal);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(20, 220, 100, 20);
        frame.getContentPane().add(gender);
        
        JComboBox genderVal = new JComboBox();
        genderVal.setModel(new DefaultComboBoxModel(new String[] {"Male","Female","Others"}));
        genderVal.setBounds(100, 220, 100, 20);
        frame.getContentPane().add(genderVal);
        
        JLabel sec = new JLabel("Section");
        sec.setBounds(20, 260, 100, 20);
        frame.getContentPane().add(sec);
        
        JComboBox secVal = new JComboBox();
        secVal.setModel(new DefaultComboBoxModel(new String[] {"A","B","C","D"}));
        secVal.setBounds(100, 260, 100, 20);
        frame.getContentPane().add(secVal);
        
        JButton subBtn = new JButton("Submit");
        subBtn.setBounds(100, 300, 100, 20);
        frame.getContentPane().add(subBtn);
        
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(20, 300, 100, 20);
        backBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
          frame.dispose();
          new StudentDetails().setVisible(true);
        	}
        });
        frame.getContentPane().add(backBtn);
        
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

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
