
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;


public class StudentForm {
	public JLabel idlabel;
	public JTextField fnVal;
	public JTextField lnVal;
	public JTextField addrVal;
	public JTextField conVal;
	public JComboBox clasVal;
	public JComboBox genderVal;
	public JComboBox secVal;

	public StudentForm() {
		JFrame frame = new JFrame("Student Form");
//		frame.getContentPane().setLayout(new GridLayout(8,2));
		frame.getContentPane().setLayout(null);
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		JLabel fName = new JLabel("First Name");
		fName.setBounds(20, 20, 100, 20);
        frame.getContentPane().add(fName);
        
         idlabel = new JLabel("");
        idlabel.setBounds(361, 24, 100, 25);
        frame.getContentPane().add(idlabel);
        
         fnVal = new JTextField(20);
        fnVal.setBounds(100,20,100,20);
        frame.getContentPane().add(fnVal);
        
        JLabel lName = new JLabel("Last Name");
        lName.setBounds(20, 60, 100, 20);
        frame.getContentPane().add(lName);
      
        
         lnVal = new JTextField(20);
        lnVal.setBounds(100, 60, 100, 20);
        frame.getContentPane().add(lnVal);
        
        
        JLabel addr = new JLabel("Address");
        addr.setBounds(20, 100, 100, 20);
        frame.getContentPane().add(addr);
        
        
         addrVal = new JTextField(20);
        addrVal.setBounds(100, 100, 100, 20);
        frame.getContentPane().add(addrVal);
       
        
        JLabel conNum = new JLabel("Contact:");
        conNum.setBounds(20, 140, 100, 20);
        frame.getContentPane().add(conNum);
        
        
        conVal= new JTextField(20);
        conVal.setBounds(100, 140, 100, 20);
        frame.getContentPane().add(conVal);
      
        
        JLabel clas = new JLabel("Class");
        clas.setBounds(20, 180, 100, 20);
        frame.getContentPane().add(clas);
       
        
        clasVal = new JComboBox();
        clasVal.setModel(new DefaultComboBoxModel(new String[] {"Nursery","LKG","UKG"}));
        clasVal.setBounds(100, 180, 100, 20);
        frame.getContentPane().add(clasVal);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(20, 220, 100, 20);
        frame.getContentPane().add(gender);
        
        genderVal = new JComboBox();
        genderVal.setModel(new DefaultComboBoxModel(new String[] {"Male","Female","Others"}));
        genderVal.setBounds(100, 220, 100, 20);
        frame.getContentPane().add(genderVal);
        
        JLabel sec = new JLabel("Section");
        sec.setBounds(20, 260, 100, 20);
        frame.getContentPane().add(sec);
        
        secVal = new JComboBox();
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
        		if(idlabel.getText()!=null || idlabel.getText() != "") {
        			student.setId(Integer.valueOf(idlabel.getText()));	
        		}
        		
        		student.setFirstName(fnVal.getText());
        		student.setLastName(lnVal.getText());
        		student.setAddress(addrVal.getText());
        		student.setContactNumber(Long.valueOf(conVal.getText()));
        		student.setGrade((String)clasVal.getSelectedItem());
        		student.setGender((String)genderVal.getSelectedItem());
        		student.setSection((String)secVal.getSelectedItem());
        		
        		   Student s1= new StudentImpl();
        		
        		if(idlabel.getText()==null || idlabel.getText()=="") {
//        			System.out.println("hello");
        			 s1.saveStudent(student);
        		}
        		else {
        			s1.updateStudent(student);
        		}
        		
          
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
