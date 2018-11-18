package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

@SuppressWarnings("serial")
public class updateMachine extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton btnUpdate;
	private JLabel lblMachineId;
	private JLabel lblType;
	private JLabel lblLaundaryDate;
	private JLabel lblTimezone;
	private JLabel lblLaundarytime;
	private JLabel lblMachineName;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateMachine frame = new updateMachine();
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
	public updateMachine() {
		setBounds(100, 100, 521, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 36, 485, 28);
		contentPane.add(table);
		
		JLabel lblGetMachineWith = new JLabel("Get machine with machineID=");
		lblGetMachineWith.setBounds(10, 11, 204, 14);
		contentPane.add(lblGetMachineWith);
		
		textField = new JTextField();
		textField.setBounds(236, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnGetMschine = new JButton("Get Maschine");
		btnGetMschine.addMouseListener(new MouseAdapter() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void mouseClicked(MouseEvent e) {
				
					try{
					
					Class.forName("java.sql.Driver");
					Connection con= (Connection)DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","MERTKAN","mertkan");
			       
							
					String sql = "select * from MACHINE_TABLE where MACHINEID = '"  + textField.getText() + "'" ;
					
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
		btnGetMschine.setBounds(334, 7, 161, 23);
		contentPane.add(btnGetMschine);
		
		textField_1 = new JTextField();
		textField_1.setBounds(220, 75, 204, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(220, 117, 204, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(220, 158, 204, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(220, 193, 204, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(220, 226, 204, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(220, 257, 204, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		btnUpdate = new JButton("update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					
					Class.forName("java.sql.Driver");
					Connection con= (Connection)DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","MERTKAN","mertkan");
					
					    String key = textField_1.getText() ;
	
						String MachineID = textField_1.getText();
						String Type = textField_2.getText();
						String LaundaryDate = textField_3.getText();
						String TimeZone = textField_4.getText();
						String LaundaryTime = textField_5.getText();
						String MachineName = textField_6.getText();
						
		
					
						//String sql2 = "UPDATE MACHINE_TABLE SET  MACHINEID =' " +MachineID+" ', TYPE ='"+Type+"',LAUNDARYDATE='"+LaundaryDate+"',TIMEZONE='"+TimeZone+"',LAUNDARYTIME='"+LaundaryTime+"', MACHÝNENAME='"+MachineName+"' WHERE select MACHINEID = ' " +key+ "' ";
						
						Statement st2 = (Statement) con.createStatement();
						st2.executeQuery("UPDATE MACHINE_TABLE SET MACHINEID = ' " +MachineID+" ' , TYPE =  '"+Type+"' , LAUNDARYDATE ='"+LaundaryDate+"',TIMEZONE = '"+TimeZone+"',LAUNDARYTIME = '"+LaundaryTime+"' ,MACHÝNENAME ='"+MachineName+"' WHERE MACHINEID  = ' " +key+ "'  ");
				
						textField_7.setText(" Updated");
					con.close();	
					
			}
					catch (Exception ex) {
							System.out.println(" " + ex.getMessage());
						}

				
				
				
			}
		});
		btnUpdate.setBounds(164, 303, 89, 23);
		contentPane.add(btnUpdate);
		
		lblMachineId = new JLabel("Machine ID");
		lblMachineId.setBounds(103, 78, 112, 14);
		contentPane.add(lblMachineId);
		
		lblType = new JLabel("Type");
		lblType.setBounds(103, 120, 46, 14);
		contentPane.add(lblType);
		
		lblLaundaryDate = new JLabel("Laundary Date");
		lblLaundaryDate.setBounds(103, 161, 86, 14);
		contentPane.add(lblLaundaryDate);
		
		lblTimezone = new JLabel("Timezone");
		lblTimezone.setBounds(103, 196, 46, 14);
		contentPane.add(lblTimezone);
		
		lblLaundarytime = new JLabel("LaundaryTime");
		lblLaundarytime.setBounds(103, 229, 107, 14);
		contentPane.add(lblLaundarytime);
		
		lblMachineName = new JLabel("Machine Name");
		lblMachineName.setBounds(103, 260, 86, 14);
		contentPane.add(lblMachineName);
		
		textField_7 = new JTextField();
		textField_7.setBounds(263, 304, 161, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
	}

}
