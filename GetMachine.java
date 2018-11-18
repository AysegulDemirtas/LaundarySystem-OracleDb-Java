package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

@SuppressWarnings("serial")
public class GetMachine extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetMachine frame = new GetMachine();
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
	public GetMachine() {
		setBounds(100, 100, 576, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGetTable = new JButton("get table");
		btnGetTable.addActionListener(new ActionListener() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					Class.forName("java.sql.Driver");
					Connection con= (Connection)DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","MERTKAN","mertkan");
					
					String sql = "select * from MACHINE_TABLE"  ;
					
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
		btnGetTable.setBounds(213, 11, 89, 23);
		contentPane.add(btnGetTable);
		
		table = new JTable();
		table.setBounds(10, 45, 540, 600);
		contentPane.add(table);
	}
}
