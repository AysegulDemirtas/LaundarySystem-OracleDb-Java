package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class GetfreeMachine extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnGetTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetfreeMachine frame = new GetfreeMachine();
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
	public GetfreeMachine() {
		
		
		setBounds(100, 100, 457, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 38, 414, 276);
		contentPane.add(table);
		
		JButton btnAddstudent = new JButton("addtoTables");
		btnAddstudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addToStudentTable addstudent = new addToStudentTable();
				addstudent.setVisible(true);
			}
		});
	
		btnAddstudent.setBounds(110, 325, 144, 23);
		contentPane.add(btnAddstudent);
		
		btnGetTable = new JButton("get table");
		btnGetTable.addMouseListener(new MouseAdapter() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				try{
					
					Class.forName("java.sql.Driver");
					Connection con= (Connection)DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","MERTKAN","mertkan");
					
					String sql = "SELECT MACHINEID FROM MACHINE_TABLE MINUS SELECT MACHINEID FROM STUDENT_TABLE " ;
					
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
		btnGetTable.setBounds(147, 4, 89, 23);
		contentPane.add(btnGetTable);
		
		
		
		
	}
}
