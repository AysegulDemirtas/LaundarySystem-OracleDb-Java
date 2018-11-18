
package database;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


@SuppressWarnings("serial")
public class LaundarySystem extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaundarySystem frame = new LaundarySystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public LaundarySystem() {
		//create frame
		setTitle("Laundary System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToLaundary = new JLabel("Welcome to Laundary System Application of ");
		lblWelcomeToLaundary.setForeground(Color.PINK);
		lblWelcomeToLaundary.setBounds(44, 0, 359, 25);
		contentPane.add(lblWelcomeToLaundary);
		
		JButton btnGetTable = new JButton("is there any free machine?");
		btnGetTable.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			//investigate whether there is free machine or not	
					try{
					
					Class.forName("java.sql.Driver");
					Connection con= (Connection)DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","MERTKAN","mertkan");
					
		 			 Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 			st = con.createStatement();
		 			
		 		    ResultSet rs = st.executeQuery("SELECT * FROM MACHINE_TABLE  ");
		 		    rs = st.executeQuery("SELECT COUNT(*) FROM MACHINE_TABLE");

		 		   Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 		  st2 = con.createStatement();
		 		  
		 		    ResultSet rs2 = st2.executeQuery("SELECT * FROM STUDENT_TABLE");
		 		    rs2 = st2.executeQuery("SELECT COUNT(*) FROM STUDENT_TABLE");
		 		    
   	 	     rs.next();
   	 	     rs2.next();

   	 	     if(rs.getInt(1)<=rs2.getInt(1))
   	 	     {
   	 	    	textField_1.setText("No");	
   	 	     }
   	 	     else{
   	 	    	textField_1.setText("Yes");	
   	 	     }
   	 	     
			
					con.close();	
					
				}
				
			catch (Exception ex) {
				System.out.println(" " + ex.getMessage());
			}
				
			}


		});
		btnGetTable.setForeground(Color.DARK_GRAY);
		btnGetTable.setBounds(59, 54, 186, 23);
		contentPane.add(btnGetTable);
		
		JLabel lblerifeBacKz = new JLabel("\u015Eerife Bac\u0131 K\u0131z Yurdu ");
		lblerifeBacKz.setForeground(Color.PINK);
		lblerifeBacKz.setBounds(86, 22, 217, 14);
		contentPane.add(lblerifeBacKz);
		
		JButton btnGetTable_1 = new JButton("Get Student Table");
		btnGetTable_1.setForeground(Color.DARK_GRAY);
		btnGetTable_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				GetStudent student = new GetStudent();
				student.setVisible(true);
				
			}
		});
		
		btnGetTable_1.setBounds(25, 278, 130, 23);
		contentPane.add(btnGetTable_1);
		
		JButton btnNewButton = new JButton("Get Machine Table");
		btnNewButton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
			//Get machine table	
				GetMachine machine = new GetMachine();
				machine.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBounds(173, 278, 130, 23);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 88, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnGetFreeMachine = new JButton("get free machine list");
		btnGetFreeMachine.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent arg0) {
				//free machine list window
				GetfreeMachine freemachine = new GetfreeMachine();
				freemachine.setVisible(true);
				
			}
		});
		btnGetFreeMachine.setForeground(Color.BLUE);
		btnGetFreeMachine.setBounds(59, 201, 186, 23);
		contentPane.add(btnGetFreeMachine);
		
		JButton btnDeleteFromStudent = new JButton("Delete Options");
		btnDeleteFromStudent.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				//delete from student window
				deleteStudent dlt = new deleteStudent();
				dlt.setVisible(true);
				
			}
		});
		btnDeleteFromStudent.setForeground(Color.WHITE);
		btnDeleteFromStudent.setBounds(59, 167, 186, 23);
		contentPane.add(btnDeleteFromStudent);
		
		JLabel lblDesignedByAyegl = new JLabel("Designed by Ay\u015Feg\u00FCl Demirta\u015F");
		lblDesignedByAyegl.setForeground(Color.PINK);
		lblDesignedByAyegl.setBounds(10, 321, 174, 14);
		contentPane.add(lblDesignedByAyegl);
		
		JButton btnNewButton_1 = new JButton("Update Options");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				Update updt = new Update();
				updt.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.MAGENTA);
		btnNewButton_1.setBounds(55, 133, 190, 23);
		contentPane.add(btnNewButton_1);
	}
}


