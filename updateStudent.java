package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

@SuppressWarnings("serial")
public class updateStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateStudent frame = new updateStudent();
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
	public updateStudent() {
		setBounds(100, 100, 450, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGetStudentWith = new JLabel("Get student with st\u0131dentID=");
		lblGetStudentWith.setBounds(23, 11, 153, 14);
		contentPane.add(lblGetStudentWith);
		
		textField = new JTextField();
		textField.setBounds(186, 8, 120, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBounds(23, 36, 401, 28);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Get Table");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public void actionPerformed(ActionEvent arg0) {
				

				try{
				
				Class.forName("java.sql.Driver");
				Connection con= (Connection)DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","MERTKAN","mertkan");
		       
						
				String sql = "select * from STUDENT_TABLE where STUDENTID = '"  + textField.getText() + "'" ;
				
				Statement st = (Statement) con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
				int columnCount = md.getColumnCount();

				Vector columns = new Vector(columnCount);
				for (int i = 1; i <= columnCount; i++) {

					columns.add(md.getColumnName(i));
					System.out.println(md.getColumnName(i));
				}
				Vector data = new Vector();
				Vector row;
				
				while (rs.next()) {
					row = new Vector(columnCount);
					for (int i = 1; i <= columnCount; i++) {
						row.add(rs.getString(i));
					}
					data.add(row);
				}

				
				table.setModel(new DefaultTableModel(data, columns) {
				});
				
				
				con.close();	
			
		}
		
	catch (Exception ex) {
		System.out.println(" " + ex.getMessage());
	}
			
			}
		});
	
		btnNewButton.setBounds(316, 7, 108, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(108, 75, 79, 14);
		contentPane.add(lblStudentId);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(108, 99, 92, 14);
		contentPane.add(lblStudentName);
		
		JLabel lblStudentSurname = new JLabel("Student Surname");
		lblStudentSurname.setBounds(108, 126, 92, 14);
		contentPane.add(lblStudentSurname);
		
		JLabel lblStudentRoom = new JLabel("Student Room");
		lblStudentRoom.setBounds(108, 152, 79, 14);
		contentPane.add(lblStudentRoom);
		
		JLabel lblMachineId = new JLabel("Machine ID");
		lblMachineId.setBounds(108, 177, 79, 14);
		contentPane.add(lblMachineId);
		
		JButton btnUpddate = new JButton("upddate");
		btnUpddate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
	try{
					
					Class.forName("java.sql.Driver");
					Connection con= (Connection)DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","MERTKAN","mertkan");
					
					    String key = textField.getText() ;
	
						String StudentID = textField_2.getText();
						String StudentName = textField_3.getText();
						String StudentSurname = textField_4.getText();
						String StudentRoom = textField_5.getText();
						String MachineID = textField_6.getText();
						
						String sql = "UPDATE STUDENT_TABLE SET STUDENTID =' "+ StudentID +" ' , STUDENTNAME ='"+StudentName+"' , STUDENTSURNAME ='"+StudentSurname+"' , STUDENTROOM ='"+ StudentRoom +"' , MACHINEID = '"+MachineID+"' where STUDENTID = ' " +key+ "' ";
						
						Statement st2 = (Statement) con.createStatement();
						st2.executeQuery(sql);
				
						textField_1.setText(" Updated");
					con.close();	
					
			}
					catch (Exception ex) {
							System.out.println(" " + ex.getMessage());
						}

				
				
			}
		});
		btnUpddate.setBounds(150, 210, 89, 23);
		contentPane.add(btnUpddate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(249, 211, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(231, 72, 193, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(231, 96, 193, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(231, 123, 193, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(231, 149, 193, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(231, 174, 193, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
	}

}
