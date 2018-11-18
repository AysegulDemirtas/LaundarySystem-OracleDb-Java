package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class deleteStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblDeleteMachineWith;
	private JTextField textField_1;
	private JButton btnDelete_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteStudent frame = new deleteStudent();
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
	public deleteStudent() {
		setBounds(100, 100, 364, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteStudentWith = new JLabel("Delete student with student id = ");
		lblDeleteStudentWith.setBounds(29, 27, 178, 14);
		contentPane.add(lblDeleteStudentWith);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

					try{
					
					Class.forName("java.sql.Driver");
					Connection con= (Connection)DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","MERTKAN","mertkan");
					String studentkey = textField.getText();
					
					String sql = "DELETE FROM STUDENT_TABLE WHERE STUDENTID = ' " +studentkey+ " ' ";
					
					
					Statement st = (Statement) con.createStatement();
					st.executeQuery(sql);
					

					textField_2.setText("deleted");
					
					
					con.close();	
				
			}
			
		catch (Exception ex) {
			System.out.println(" " + ex.getMessage());
		}
				
				
			}
		});
		btnDelete.setBounds(118, 52, 89, 23);
		contentPane.add(btnDelete);
		
		textField = new JTextField();
		textField.setBounds(208, 24, 98, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblDeleteMachineWith = new JLabel("Delete machine with machine id =");
		lblDeleteMachineWith.setBounds(29, 115, 178, 14);
		contentPane.add(lblDeleteMachineWith);
		
		textField_1 = new JTextField();
		textField_1.setBounds(220, 112, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnDelete_1 = new JButton("Delete");
		btnDelete_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try{
				
					Class.forName("java.sql.Driver");
					Connection con= (Connection)DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","MERTKAN","mertkan");
					
					String machinekey = textField_1.getText();
					
					System.out.printf(textField_1.getText());
					
					Statement st = (Statement) con.createStatement();
					st.executeQuery("DELETE FROM MACHINE_TABLE WHERE MACHINEID = ' " + machinekey + " ' ");
					
					textField_3.setText("deleted");
					
					con.close();	
				}
				catch (Exception ex) {
					System.out.println("erör " + ex.getMessage());
				}
				
				
			}
		});
		btnDelete_1.setBounds(118, 140, 89, 23);
		contentPane.add(btnDelete_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(220, 53, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(220, 141, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}

}
