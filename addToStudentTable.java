package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@SuppressWarnings("serial")
public class addToStudentTable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblLaundarydate;
	private JLabel lblTimezone;
	private JLabel lblMachined;
	private JLabel lblType;
	private JLabel lblLaundarytime;
	private JLabel lblMachinename;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JButton btnAddmachine;
	private JTextField textField_11;
	private JTextField textField_12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addToStudentTable frame = new addToStudentTable();
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
	public addToStudentTable() {
		
		setBounds(100, 100, 659, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(167, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblStudentNumber = new JLabel("Student Number");
		lblStudentNumber.setBounds(36, 14, 134, 14);
		contentPane.add(lblStudentNumber);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(36, 52, 115, 14);
		contentPane.add(lblStudentName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 49, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblStudentSurname = new JLabel("Student Surname");
		lblStudentSurname.setBounds(36, 89, 115, 14);
		contentPane.add(lblStudentSurname);
		
		textField_2 = new JTextField();
		textField_2.setBounds(167, 86, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblStudentRoom = new JLabel("Student Room");
		lblStudentRoom.setBounds(36, 126, 86, 14);
		contentPane.add(lblStudentRoom);
		
		textField_3 = new JTextField();
		textField_3.setBounds(167, 123, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblMachineId = new JLabel("Machine ID");
		lblMachineId.setBounds(36, 161, 100, 14);
		contentPane.add(lblMachineId);
		
		textField_4 = new JTextField();
		textField_4.setBounds(167, 158, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAddstudent = new JButton("addStudent");
		btnAddstudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					try{
					
					Class.forName("java.sql.Driver");
					Connection con= (Connection)DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","MERTKAN","mertkan");
					
					
						String StudentID = textField.getText();
						String StudentNAME = textField_1.getText();
						String StudentSURNAME = textField_2.getText();
						String StudentROOM = textField_3.getText();
						String MachineID = textField_4.getText();

						
					
					String sql = "INSERT INTO STUDENT_TABLE (STUDENTID,STUDENTNAME,STUDENTSURNAME,STUDENTROOM,MACHINEID) VALUES (' " +StudentID + "','" +StudentNAME + "','" + StudentSURNAME+ "','" + StudentROOM + "','" +MachineID + "')";
					
					Statement st = (Statement) con.createStatement();
					st.executeQuery(sql);
					
					textField_11.setText("This row is inserted to the table");
					
					con.close();	
					
			}
					catch (Exception ex) {
							System.out.println(" " + ex.getMessage());
						}
				
				
			}
		});
		btnAddstudent.setBounds(81, 199, 89, 23);
		contentPane.add(btnAddstudent);
		
		lblLaundarydate = new JLabel("LaundaryDate");
		lblLaundarydate.setBounds(344, 89, 100, 14);
		contentPane.add(lblLaundarydate);
		
		lblTimezone = new JLabel("TimeZone");
		lblTimezone.setBounds(344, 126, 71, 14);
		contentPane.add(lblTimezone);
		
		lblMachined = new JLabel("MachineId");
		lblMachined.setBounds(344, 14, 71, 14);
		contentPane.add(lblMachined);
		
		lblType = new JLabel("Type");
		lblType.setBounds(344, 52, 46, 14);
		contentPane.add(lblType);
		
		lblLaundarytime = new JLabel("LaundaryTime");
		lblLaundarytime.setBounds(344, 161, 71, 14);
		contentPane.add(lblLaundarytime);
		
		lblMachinename = new JLabel("MachineName ");
		lblMachinename.setBounds(344, 203, 115, 14);
		contentPane.add(lblMachinename);
		
		textField_5 = new JTextField();
		textField_5.setBounds(477, 11, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(477, 49, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(477, 86, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(477, 123, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(477, 161, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(477, 200, 86, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		btnAddmachine = new JButton("addMachine");
		btnAddmachine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try{
								
								Class.forName("java.sql.Driver");
								Connection con= (Connection)DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","MERTKAN","mertkan");
								
								
				
									String MachineID = textField_5.getText();
									String Type = textField_6.getText();
									String LaundaryDate = textField_7.getText();
									String TimeZone = textField_8.getText();
									String LaundaryTime = textField_9.getText();
									String MachineName = textField_10.getText();
									
					
								
									String sql2 = "INSERT INTO MACHINE_TABLE (MACHINEID,TYPE,LAUNDARYDATE,TIMEZONE,LAUNDARYTIME,MACHÝNENAME) VALUES (' " +MachineID+ "','" +Type + "','" +LaundaryDate+ "','" +TimeZone+ "','" +LaundaryTime+ "','" + MachineName + "')";
									
									Statement st2 = (Statement) con.createStatement();
									st2.executeQuery(sql2);
							
									textField_12.setText(" This row is inserted to the table");
								con.close();	
								
						}
								catch (Exception ex) {
										System.out.println(" " + ex.getMessage());
									}
				
			}
		});
		btnAddmachine.setBounds(402, 241, 89, 23);
		contentPane.add(btnAddmachine);
		
		textField_11 = new JTextField();
		textField_11.setBounds(10, 242, 285, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(344, 278, 266, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
	}
}
