import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class IM102_finals {

	private JFrame frame;
	private JTable table;
	private JTextField StudID;
	private JTextField StudFname;
	private JTextField StudLname;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_1;
	private JTextField BookID;
	private JTextField BookISBN;
	private JTextField BookTitle;
	private JTable table_2;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IM102_finals window = new IM102_finals();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IM102_finals() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 514, 477);
		frame.getContentPane().add(tabbedPane);
		
		JPanel borrowing = new JPanel();
		tabbedPane.addTab("borrowing", null, borrowing, null);
		borrowing.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(221, 25, 261, 383);
		borrowing.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setBounds(10, 48, 85, 14);
		borrowing.add(lblNewLabel);
		
		StudID = new JTextField();
		StudID.setBounds(81, 48, 116, 20);
		borrowing.add(StudID);
		StudID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("First name");
		lblNewLabel_1.setBounds(10, 73, 61, 14);
		borrowing.add(lblNewLabel_1);
		
		StudFname = new JTextField();
		StudFname.setBounds(81, 73, 116, 20);
		borrowing.add(StudFname);
		StudFname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(10, 98, 61, 14);
		borrowing.add(lblNewLabel_2);
		
		StudLname = new JTextField();
		StudLname.setBounds(81, 101, 116, 20);
		borrowing.add(StudLname);
		StudLname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Middle Name");
		lblNewLabel_3.setBounds(10, 123, 61, 14);
		borrowing.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(81, 126, 116, 20);
		borrowing.add(textField);
		textField.setColumns(10);
		
		JComboBox Studcourse = new JComboBox();
		Studcourse.setBounds(81, 157, 116, 22);
		borrowing.add(Studcourse);
		
		JLabel lblNewLabel_4 = new JLabel("Course");
		lblNewLabel_4.setBounds(10, 161, 46, 14);
		borrowing.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("BORROWER INFORMATION");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 23, 201, 14);
		borrowing.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(81, 254, 116, 20);
		borrowing.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Book ID");
		lblNewLabel_6.setBounds(10, 260, 46, 14);
		borrowing.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("status");
		lblNewLabel_7.setBounds(10, 285, 46, 14);
		borrowing.add(lblNewLabel_7);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"available", "borrowed", "overdue"}));
		comboBox_1.setBounds(81, 285, 116, 22);
		borrowing.add(comboBox_1);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBounds(10, 337, 89, 23);
		borrowing.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setBounds(108, 337, 89, 23);
		borrowing.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setBounds(108, 371, 89, 23);
		borrowing.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CLEAR");
		btnNewButton_3.setBounds(10, 371, 89, 23);
		borrowing.add(btnNewButton_3);
		
		JComboBox StudYear = new JComboBox();
		StudYear.setBounds(81, 190, 116, 22);
		borrowing.add(StudYear);
		
		JLabel lblNewLabel_8 = new JLabel("Year Level");
		lblNewLabel_8.setBounds(10, 194, 61, 14);
		borrowing.add(lblNewLabel_8);
		
		JPanel inventory = new JPanel();
		tabbedPane.addTab("Inventory", null, inventory, null);
		inventory.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(238, 11, 261, 400);
		inventory.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_1.setViewportView(table_1);
		
		BookID = new JTextField();
		BookID.setBounds(83, 39, 126, 20);
		inventory.add(BookID);
		BookID.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Book ID");
		lblNewLabel_9.setBounds(18, 39, 46, 14);
		inventory.add(lblNewLabel_9);
		
		BookISBN = new JTextField();
		BookISBN.setBounds(83, 70, 126, 20);
		inventory.add(BookISBN);
		BookISBN.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Title");
		lblNewLabel_10.setBounds(18, 108, 46, 14);
		inventory.add(lblNewLabel_10);
		
		JComboBox AuthID = new JComboBox();
		AuthID.setBounds(83, 135, 126, 22);
		inventory.add(AuthID);
		
		JLabel lblNewLabel_11 = new JLabel("Author ID");
		lblNewLabel_11.setBounds(18, 139, 65, 14);
		inventory.add(lblNewLabel_11);
		
		JComboBox PubID = new JComboBox();
		PubID.setBounds(83, 168, 126, 22);
		inventory.add(PubID);
		
		JLabel lblNewLabel_12 = new JLabel("Publisher ID");
		lblNewLabel_12.setBounds(18, 172, 65, 14);
		inventory.add(lblNewLabel_12);
		
		BookTitle = new JTextField();
		BookTitle.setBounds(83, 101, 126, 20);
		inventory.add(BookTitle);
		BookTitle.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("ISBN");
		lblNewLabel_13.setBounds(18, 73, 46, 14);
		inventory.add(lblNewLabel_13);
		
		JButton btnNewButton_4 = new JButton("ADD");
		btnNewButton_4.setBounds(18, 222, 89, 23);
		inventory.add(btnNewButton_4);
		
		JButton btnNewButton_3_1 = new JButton("CLEAR");
		btnNewButton_3_1.setBounds(18, 256, 89, 23);
		inventory.add(btnNewButton_3_1);
		
		JButton btnNewButton_1_1 = new JButton("UPDATE");
		btnNewButton_1_1.setBounds(116, 222, 89, 23);
		inventory.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("DELETE");
		btnNewButton_2_1.setBounds(116, 256, 89, 23);
		inventory.add(btnNewButton_2_1);
		
		JPanel search = new JPanel();
		tabbedPane.addTab("Search", null, search, null);
		search.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(252, 42, 247, 342);
		search.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		textField_2 = new JTextField();
		textField_2.setBounds(95, 73, 132, 20);
		search.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Title");
		lblNewLabel_14.setBounds(21, 80, 46, 14);
		search.add(lblNewLabel_14);
		
		textField_3 = new JTextField();
		textField_3.setBounds(96, 42, 131, 20);
		search.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel(" Book ID");
		lblNewLabel_15.setBounds(21, 49, 64, 14);
		search.add(lblNewLabel_15);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(95, 136, 132, 22);
		search.add(comboBox);
		
		JLabel lblNewLabel_16 = new JLabel("Author");
		lblNewLabel_16.setBounds(21, 144, 64, 14);
		search.add(lblNewLabel_16);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(95, 169, 132, 22);
		search.add(comboBox_2);
		
		JLabel lblNewLabel_17 = new JLabel("Publisher");
		lblNewLabel_17.setBounds(21, 177, 64, 14);
		search.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("FILTERS BY:");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_18.setBounds(21, 24, 97, 14);
		search.add(lblNewLabel_18);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(95, 202, 132, 22);
		search.add(comboBox_3);
		
		JLabel lblNewLabel_19 = new JLabel("Year ");
		lblNewLabel_19.setBounds(21, 206, 46, 14);
		search.add(lblNewLabel_19);
		
		textField_4 = new JTextField();
		textField_4.setBounds(95, 104, 132, 20);
		search.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel(" ISBN");
		lblNewLabel_20.setBounds(21, 107, 46, 14);
		search.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel(" Category:");
		lblNewLabel_21.setBounds(21, 235, 74, 14);
		search.add(lblNewLabel_21);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("category");
		chckbxNewCheckBox.setBounds(21, 258, 97, 23);
		search.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("category");
		chckbxNewCheckBox_1.setBounds(21, 281, 97, 23);
		search.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("category");
		chckbxNewCheckBox_2.setBounds(21, 305, 97, 23);
		search.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("category");
		chckbxNewCheckBox_3.setBounds(115, 258, 97, 23);
		search.add(chckbxNewCheckBox_3);
		
		JLabel lblNewLabel_18_1 = new JLabel("SEARCH RESULTS:");
		lblNewLabel_18_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_18_1.setBounds(252, 25, 132, 14);
		search.add(lblNewLabel_18_1);
		
		JButton btnNewButton_5 = new JButton("SEARCH");
		btnNewButton_5.setBounds(21, 335, 89, 23);
		search.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("CLEAR");
		btnNewButton_6.setBounds(115, 335, 89, 23);
		search.add(btnNewButton_6);
	}
}
