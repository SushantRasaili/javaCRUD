import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class StudentDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JButton btnNew;
	private JButton btnDelete;

	Student getStudents = new StudentImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetails frame = new StudentDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 976, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		 
		        // Column Names
		      
		
		        
		table = new JTable();
		table.setBounds(59, 47, 569, 212);
		contentPane.add(table);
		String[] columnNames = { "id","FirstName", "LastName", "Address","Class","Gender","Section","Contacts" };
	        
		  DefaultTableModel tblModel = new DefaultTableModel(columnNames,0);
		  
		  
		  table.setModel(tblModel);
		  
		  loadDataInTable();
		  
		  JScrollPane scrollPane = new JScrollPane(table);
		  scrollPane.setBounds(59, 47, 830, 382);
		  contentPane.add(scrollPane);
		  
		  
		  
		  
		  
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSearch.setBounds(616, 10, 68, 27);
		contentPane.add(lblSearch);
		
		textField = new JTextField();
		textField.setBounds(715, 10, 154, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StudentForm().setVisible(true);
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(42, 526, 85, 21);
		contentPane.add(btnNewButton);
		
		btnNew = new JButton("Edit");
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNew.setBounds(215, 526, 85, 21);
		contentPane.add(btnNew);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(376, 526, 85, 21);
		contentPane.add(btnDelete);
		
		
		
	}
	
//	"LastName", "Address","Class","Gender","Section","Contacts" };
	public void loadDataInTable() {
		ArrayList<StudentDao> studentDatas = getStudents.getStudentList();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		for(StudentDao value: studentDatas) {
			tableModel.addRow(new Object[] {value.getId(),value.getFirstName(),
					value.getLastName(),
					value.getAddress(),
					value.getGrade(),
					value.getGender(),
					value.getSection(),
					value.getContactNumber()
					});
		}
	}
	
}
