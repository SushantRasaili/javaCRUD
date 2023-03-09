import java.awt.EventQueue;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractButton;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class StudentDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField searchBox;
	private JButton btnNew,btnDelete;

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

	/*Create the frame.
	 */
	public StudentDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 976, 623);
		setSize(900,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		        
		table = new JTable();
		table.setBounds(59, 47, 569, 212);
		contentPane.add(table);
		String[] columnNames = { "id","FirstName", "LastName", "Address","Class","Gender","Section","Contacts" };
	        
		  DefaultTableModel tblModel = new DefaultTableModel(columnNames,0);
		  table.setModel(tblModel);
		  
		  loadDataInTable();
		  
		  JScrollPane scrollPane = new JScrollPane(table);
		  scrollPane.setBounds(0, 47, 879, 382);
		  contentPane.add(scrollPane);
		  
		  
		  
		  
		  
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSearch.setBounds(616, 10, 68, 27);
		contentPane.add(lblSearch);
		
		searchBox = new JTextField();
		searchBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String name = searchBox.getText();
				searchDataInTable(name);	
			}
		});
		
		
		searchBox.setBounds(715, 10, 154, 27);
		contentPane.add(searchBox);
		searchBox.setColumns(10);
		
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
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				Object id =  tableModel.getValueAt(row,0);				
				Object firstName = tableModel.getValueAt(row,1);
				Object lastName = tableModel.getValueAt(row,2);
				Object address = tableModel.getValueAt(row,3);
				Object clas = tableModel.getValueAt(row,4);
				Object gender = tableModel.getValueAt(row,5);
				Object section = tableModel.getValueAt(row,6);
				Object contacts = tableModel.getValueAt(row,7);	
				
				StudentForm student = new StudentForm();
				student.idlabel.setText(id.toString());
				student.fnVal.setText(firstName.toString());	
				student.lnVal.setText(lastName.toString());
				student.addrVal.setText(address.toString());
				student.conVal.setText(contacts.toString());
				student.clasVal.setSelectedItem(clas);
				student.genderVal.setSelectedItem(gender);
				student.secVal.setSelectedItem(section);
				
				dispose();
//				new StudentForm().setVisible(true);
			}
		});
		
		
		
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNew.setBounds(215, 526, 85, 21);
		contentPane.add(btnNew);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				Object id =  tableModel.getValueAt(row,0);
			int status=JOptionPane.showConfirmDialog(StudentDetails.this, "Delete", "Do You Want To Delete", JOptionPane.YES_NO_OPTION);
			Student stdObj = new StudentImpl();
			if(status==0) {
				stdObj.deleteStudentInfo(Integer.parseInt(id.toString())); 
				loadDataInTable();
			}
			}
		});
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
	
	public void searchDataInTable(String name) {
		
		
		if(name!=null) {
			ArrayList<StudentDao> studentDatas = getStudents.searchName(name);
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
		}else {
			loadDataInTable();
		}
		
		
	}
	
}
