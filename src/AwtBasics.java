import java.awt.*;
//import java.util.*;



public class AwtBasics {
	
	Label lbl1,lbl2;
	TextField txtFl1,txtFl2;
	
	public AwtBasics() {
		Frame ob = new Frame("First time in Awt");
		
		lbl1 = new Label("First Name");
		lbl1.setBounds(20,40,70,20);
		
		 txtFl1 = new TextField();
		txtFl1.setBounds(100, 40, 70, 20);
		
		lbl2 = new Label("Course");
		lbl2.setBounds(20,70,70,20);
		
         Choice ch = new Choice();
         ch.add("BIM");
         ch.add("Bsc.CSIT");
         ch.add("BCA");
		
		ch.setBounds(100,70,70,20);
		
		
		
		Button btn = new Button("Submit");
//		btn.setBounds(20, 60, 70, 20);
		 
		
		ob.add(lbl1);
		ob.add(txtFl1);
		ob.add(lbl2);
		ob.add(ch);
		ob.add(btn);
		ob.setSize(500,700);
		ob.setVisible(true);	
		ob.setLayout(null);
	}

	
	
	
	public static void main(String[] args) {
		AwtBasics obj = new AwtBasics();
	}
	
}
