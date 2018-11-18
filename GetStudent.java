package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GetStudent extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetStudent frame = new GetStudent();
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
	public GetStudent() {
		setBounds(100, 100, 497, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStudentTable = new JButton("Student Table");
		btnStudentTable.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent e) {
					try{
					
					Class.forName("java.sql.Driver");
					Connection con= (Connection)DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","MERTKAN","mertkan");
					
					String sql = "select * from STUDENT_TABLE " ;
					
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

					
					table_1.setModel(new DefaultTableModel(data, columns) {
					});
					
					
					
					con.close();	
				
				
				
			}
catch (Exception ex) {
	System.out.println(" " + ex.getMessage());
}
			}


		});
		btnStudentTable.setBounds(159, 11, 116, 23);
		contentPane.add(btnStudentTable);
		
		table = new JTable();
		table.setBounds(455, 72, -444, 331);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				try{
			 		Class.forName("java.sql.Driver");
					System.out.println("sürücü yüklendi");
					
					Connection con= (Connection)DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","DATABASE","Database");

					String query = new String("SELECT * FROM STUDENT_TABLE ");
				
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					while(rs.next()){
					
					System.out.println();
					System.out.print(rs.getString("STUDENTIDID"));
					
					System.out.print(rs.getString("STUDENTNAME"));
					System.out.println();

						} 
				
					con.close();
				}
					catch (Exception npe){
						JOptionPane.showMessageDialog(null,e);
						}
				
				
				
				
			}
		});
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(10, 42, 461, 357);
		contentPane.add(table_1);
		
	}
}