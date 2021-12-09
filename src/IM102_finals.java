package libraryManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class libraryFinalsSystem extends JFrame {
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	DefaultTableModel model;
	private JPanel contentPane;
	private JTextField schoolID;
	private JTextField bookID;
	private JTable table;
	String showBook;
	String showStatus;
	String showSchool;
	String showFirst;
	String showLast;
	String showMiddle;
	String showDepartment;
	String showCollege;
	String[] dep = {"CAS", "CAM", "MDCN", "BSIT", "BSA", "BSN", "SHS"};
	String[] pos = {"Employee","1st Year","2nd Year", "3rd Year", "4th Year", "Grade 11", "Grade 12"};
	String[] sta = {"Borrowed", "Overdue"};
	final Object[] row = new Object[8];
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_13;
	private JTextField textField_1;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_19;
	private JTextField textField_18;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					libraryFinalsSystem frame = new libraryFinalsSystem();
					frame.setVisible(true);
				
				} catch (Exception e) {
					System.out.println("Error");
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public libraryFinalsSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1064, 467);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("BORROWING", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" BORROWER INFORMATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(26, 26, 248, 44);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID number");
		lblNewLabel_1.setBounds(26, 81, 86, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_7 = new JLabel("Book ID");
		lblNewLabel_7.setBounds(26, 106, 86, 14);
		panel.add(lblNewLabel_7);
		
		schoolID = new JTextField();
		schoolID.setBounds(146, 78, 107, 20);
		panel.add(schoolID);
		schoolID.setColumns(10);
		
		bookID = new JTextField();
		bookID.setBounds(146, 103, 107, 20);
		panel.add(bookID);
		bookID.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(267, 11, 782, 417);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		model = new DefaultTableModel();
		Object[] column = {"Book ID","Book Status","School ID","First Name","Last Name","Middle Name","Department","Position"};
		final Object[] row = new Object[8];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "puzzlefan29");
			System.out.println("Database Connection Successful!");
			PreparedStatement displayData = con.prepareStatement("Select * from userreadtbl");
			ResultSet rs = displayData.executeQuery();
			while(rs.next()) {
				showBook =  rs.getString("bookID");
				showStatus = rs.getString("status");
				showSchool = rs.getString("schoolID");
				showFirst = rs.getString("fName");
				showLast = rs.getString("lName");
				showMiddle = rs.getString("mName");
				showDepartment = rs.getString("department");
				showCollege = rs.getString("college");
			
				System.out.println(showBook + showStatus + showSchool + showFirst + showLast + showMiddle + showDepartment + showCollege);
				
				row[0]=showBook;
				row[1]=showStatus;
				row[2]=showSchool;
				row[3]=showFirst;
				row[4]=showLast;
				row[5]=showMiddle;
				row[6]=showDepartment;
				row[7]=showCollege;
				model.addRow(row);
			    }

		
		
		JButton addData = new JButton("Add");
		addData.setFont(new Font("Tahoma", Font.PLAIN, 11));
		addData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String school;
				String first;
				String last;
				String middle;
				String book;
				String depChoice;
				String posChoice;
				String staChoice;
				
				row[0]=showBook;
				row[1]=showStatus;
				row[2]=showSchool;
				row[3]=showFirst;
				row[4]=showLast;
				row[5]=showMiddle;
				row[6]=showDepartment;
				row[7]=showCollege;
				model.addRow(row);
				
				try {
					
					school = schoolID.getText();
					first = fName.getText();
					last = lName.getText();
					middle = mName.getText();
					book = bookID.getText();
					depChoice = department.getSelectedItem().toString();
					posChoice = position.getSelectedItem().toString();
					staChoice = status.getSelectedItem().toString();
					
			
					PreparedStatement pst = con.prepareStatement("Insert into userreadtbl(bookID,status,schoolID,fName,lName,mName,department,college) values(?,?,?,?,?,?,?,?)");
					pst.setString(1, book);
					pst.setString(2, staChoice);
					pst.setString(3, school);
					pst.setString(4, first);
					pst.setString(5, last);
					pst.setString(6, middle);
					pst.setString(7, depChoice);
					pst.setString(8, posChoice);
					pst.executeUpdate();
					
					PreparedStatement displayData = con.prepareStatement("Select * from userreadtbl");
					ResultSet rs = displayData.executeQuery();
					model.setRowCount(0);
					while(rs.next()) {
						showBook =  rs.getString("bookID");
						showStatus = rs.getString("status");
						
						showSchool = rs.getString("schoolID");
						showFirst = rs.getString("fName");
						showLast = rs.getString("lName");
						showMiddle = rs.getString("mName");
						showDepartment = rs.getString("department");
						showCollege = rs.getString("college");
					
						System.out.println(showBook + showStatus + showSchool + showFirst + showLast + showMiddle + showDepartment + showCollege);
						
						row[0]=showBook;
						row[1]=showStatus;
						row[2]=showSchool;
						row[3]=showFirst;
						row[4]=showLast;
						row[5]=showMiddle;
						row[6]=showDepartment;
						row[7]=showCollege;
						model.addRow(row);
					}
					
					JOptionPane.showMessageDialog(null, "Data Added Successfully!");
					}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		addData.setBounds(52, 253, 80, 23);
		panel.add(addData);
		}catch(SQLException exe) {
			System.out.println("ERROR: Connection Failed");
            System.out.println("SQLException: " + exe.getMessage());
            System.out.println("SQLState: " + exe.getSQLState());
            System.out.println("VendorError: " + exe.getErrorCode());
		}
		JButton deleteData = new JButton("Delete");
		deleteData.setFont(new Font("Tahoma", Font.PLAIN, 11));
		deleteData.setBounds(52, 276, 80, 23);
		panel.add(deleteData);
		
		JButton updateData = new JButton("Update");
		updateData.setFont(new Font("Tahoma", Font.PLAIN, 11));
		updateData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String value1 = schoolID.getText();
					String value2 = fName.getText();
					String value3 = lName.getText();
					String value4 = mName.getText();
					String value5 = department.getSelectedItem().toString();
					String value6= position.getSelectedItem().toString();
					String value7 = bookID.getText();
					String value8 = status.getSelectedItem().toString();
					
					String sql1 = "Update userreadtbl set bookID='"+value7+"', status=  '"+value8+"',schoolID=  '"+value1+"', fName=  '"+ value2+"', lName=  '"+ value3+"', mName=  '"+ value4+"', department=  '"+ value5+"', college=  '"+ value6+"' Where bookID='"+value7+"'  ";
					pst = con.prepareStatement(sql1);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
							
					PreparedStatement displayData = con.prepareStatement("Select * from userreadtbl");
					ResultSet rs = displayData.executeQuery();
					model.setRowCount(0);
					while(rs.next()) {
						showBook =  rs.getString("bookID");
						showStatus = rs.getString("status");
						
						showSchool = rs.getString("schoolID");
						showFirst = rs.getString("fName");
						showLast = rs.getString("lName");
						showMiddle = rs.getString("mName");
						showDepartment = rs.getString("department");
						showCollege = rs.getString("college");
					
						System.out.println(showBook + showStatus + showSchool + showFirst + showLast + showMiddle + showDepartment + showCollege);
						
						row[0]=showBook;
						row[1]=showStatus;
						row[2]=showSchool;
						row[3]=showFirst;
						row[4]=showLast;
						row[5]=showMiddle;
						row[6]=showDepartment;
						row[7]=showCollege;
						model.addRow(row);
					}
					/*	
					school = schoolID.getText();
					first = fName.getText();
					last = lName.getText();
					middle = mName.getText();
					book = bookID.getText();
					depChoice = department.getSelectedItem().toString();
					posChoice = position.getSelectedItem().toString();
					staChoice = status.getSelectedItem().toString();
					
					*/
				}catch(Exception exe) {
					
					
				}
				
			}
		});
		updateData.setBounds(134, 253, 80, 23);
		panel.add(updateData);
		
		JButton showData = new JButton("Clear");
		showData.setFont(new Font("Tahoma", Font.PLAIN, 11));
		showData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		showData.setBounds(134, 276, 80, 23);
		panel.add(showData);
		
		textField_9 = new JTextField();
		textField_9.setBounds(147, 169, 86, 20);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("date borrowed");
		lblNewLabel_4.setBounds(27, 175, 86, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("due date");
		lblNewLabel_5.setBounds(26, 200, 46, 14);
		panel.add(lblNewLabel_5);
		
		textField_10 = new JTextField();
		textField_10.setBounds(147, 197, 86, 20);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 240, 227, 2);
		panel.add(separator);
		
		textField_12 = new JTextField();
		textField_12.setBounds(146, 128, 107, 20);
		panel.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Book title");
		lblNewLabel_8.setBounds(26, 131, 46, 14);
		panel.add(lblNewLabel_8);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("RETURN", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(267, 11, 782, 417);
		panel_3.add(scrollPane_3);
		
		JLabel lblReturningBook = new JLabel("Returning book");
		lblReturningBook.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReturningBook.setBounds(57, 11, 248, 44);
		panel_3.add(lblReturningBook);
		
		textField_11 = new JTextField();
		textField_11.setBounds(111, 63, 114, 20);
		panel_3.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("book ID");
		lblNewLabel_6.setBounds(16, 69, 46, 14);
		panel_3.add(lblNewLabel_6);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setBounds(111, 156, 114, 20);
		panel_3.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("Actual due date");
		lblNewLabel_18.setBounds(16, 162, 85, 14);
		panel_3.add(lblNewLabel_18);
		
		textField_15 = new JTextField();
		textField_15.setBounds(111, 187, 114, 20);
		panel_3.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel lblNewLabel_19 = new JLabel("Date returned");
		lblNewLabel_19.setBounds(16, 193, 75, 14);
		panel_3.add(lblNewLabel_19);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setBounds(111, 94, 114, 20);
		panel_3.add(textField_16);
		textField_16.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("ID number");
		lblNewLabel_20.setBounds(16, 131, 75, 14);
		panel_3.add(lblNewLabel_20);
		
		textField_17 = new JTextField();
		textField_17.setEditable(false);
		textField_17.setBounds(111, 125, 114, 20);
		panel_3.add(textField_17);
		textField_17.setColumns(10);
		
		JLabel lblNewLabel_21 = new JLabel("Book Title");
		lblNewLabel_21.setBounds(16, 100, 46, 14);
		panel_3.add(lblNewLabel_21);
		
		textField_19 = new JTextField();
		textField_19.setBounds(111, 248, 60, 20);
		panel_3.add(textField_19);
		textField_19.setColumns(10);
		
		JLabel lblNewLabel_24 = new JLabel("Fine amount");
		lblNewLabel_24.setBounds(16, 251, 75, 14);
		panel_3.add(lblNewLabel_24);
		
		textField_18 = new JTextField();
		textField_18.setBounds(111, 279, 60, 20);
		panel_3.add(textField_18);
		textField_18.setColumns(10);
		
		JLabel lblNewLabel_22 = new JLabel("Amount deposited");
		lblNewLabel_22.setBounds(16, 282, 103, 14);
		panel_3.add(lblNewLabel_22);
		
		textField_20 = new JTextField();
		textField_20.setBounds(111, 310, 114, 20);
		panel_3.add(textField_20);
		textField_20.setColumns(10);
		
		JLabel lblNewLabel_26 = new JLabel("Transaction date");
		lblNewLabel_26.setBounds(16, 313, 86, 14);
		panel_3.add(lblNewLabel_26);
		
		textField_21 = new JTextField();
		textField_21.setBounds(111, 218, 114, 20);
		panel_3.add(textField_21);
		textField_21.setColumns(10);
		
		JLabel lblNewLabel_27 = new JLabel("Transaction ID");
		lblNewLabel_27.setBounds(16, 221, 75, 14);
		panel_3.add(lblNewLabel_27);
		
		JButton addData = new JButton("Add");
		addData.setFont(new Font("Tahoma", Font.PLAIN, 11));
		addData.setBounds(37, 351, 80, 23);
		panel_3.add(addData);
		
		JButton updateData_1 = new JButton("Update");
		updateData_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		updateData_1.setBounds(127, 351, 80, 23);
		panel_3.add(updateData_1);
		
		JButton deleteData_1 = new JButton("Delete");
		deleteData_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteData_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		deleteData_1.setBounds(37, 382, 80, 23);
		panel_3.add(deleteData_1);
		
		JButton showData_1 = new JButton("Clear");
		showData_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		showData_1.setBounds(129, 382, 80, 23);
		panel_3.add(showData_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("INVENTORY", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Book ID");
		lblNewLabel_9.setBounds(36, 47, 76, 14);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("ISBN");
		lblNewLabel_10.setBounds(36, 72, 76, 14);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Book Title");
		lblNewLabel_11.setBounds(36, 97, 76, 14);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Publisher");
		lblNewLabel_12.setBounds(36, 122, 76, 14);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Author ID");
		lblNewLabel_13.setBounds(36, 200, 76, 14);
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("First Name");
		lblNewLabel_14.setBounds(36, 225, 76, 14);
		panel_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Last Name");
		lblNewLabel_15.setBounds(36, 250, 76, 14);
		panel_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Middle Initial");
		lblNewLabel_16.setBounds(36, 275, 76, 14);
		panel_1.add(lblNewLabel_16);
		
		textField = new JTextField();
		textField.setBounds(127, 44, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(127, 94, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(127, 119, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(127, 197, 86, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(127, 222, 86, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(127, 247, 86, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(127, 272, 86, 20);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(25, 353, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setBounds(25, 387, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(124, 353, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(124, 387, 89, 23);
		panel_1.add(btnNewButton_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(242, 11, 807, 417);
		panel_1.add(scrollPane_1);
		
		JLabel lblNewLabel_17 = new JLabel("Adding New Book");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_17.setBounds(60, 11, 153, 22);
		panel_1.add(lblNewLabel_17);
		
		JLabel lblNewLabel_25 = new JLabel("Publish Year");
		lblNewLabel_25.setBounds(36, 147, 76, 14);
		panel_1.add(lblNewLabel_25);
		
		textField_13 = new JTextField();
		textField_13.setBounds(127, 144, 86, 20);
		panel_1.add(textField_13);
		textField_13.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 69, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Category");
		lblNewLabel_2.setBounds(36, 300, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(127, 296, 86, 22);
		panel_1.add(comboBox);
		
		textField_22 = new JTextField();
		textField_22.setBounds(127, 322, 86, 20);
		panel_1.add(textField_22);
		textField_22.setColumns(10);
		
		JLabel lblNewLabel_28 = new JLabel("Price");
		lblNewLabel_28.setBounds(36, 325, 46, 14);
		panel_1.add(lblNewLabel_28);
		
		textField_23 = new JTextField();
		textField_23.setBounds(127, 171, 86, 20);
		panel_1.add(textField_23);
		textField_23.setColumns(10);
		
		JLabel lblNewLabel_29 = new JLabel("Edition");
		lblNewLabel_29.setBounds(36, 172, 46, 14);
		panel_1.add(lblNewLabel_29);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("SEARCH", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Search");
		btnNewButton_4.setBounds(32, 115, 89, 23);
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(139, 115, 89, 23);
		panel_2.add(btnNewButton_5);
		
		JLabel lblNewLabel_23 = new JLabel("FILTER BY:");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_23.setBounds(48, 56, 115, 14);
		panel_2.add(lblNewLabel_23);
		
		textField_8 = new JTextField();
		textField_8.setBounds(127, 84, 86, 20);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(287, 11, 762, 417);
		panel_2.add(scrollPane_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(48, 82, 69, 22);
		panel_2.add(comboBox_2);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setEditable(false);
		formattedTextField.setBounds(32, 186, 181, 57);
		panel_2.add(formattedTextField);
		
		JLabel lblNewLabel_3 = new JLabel("active filters:");
		lblNewLabel_3.setBounds(32, 164, 89, 14);
		panel_2.add(lblNewLabel_3);
	}
}
