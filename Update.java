package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Update extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		setBounds(100, 100, 240, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStudentUpdate = new JButton("Student update");
		btnStudentUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				updateStudent ust = new updateStudent();
				ust.setVisible(true);
			}
		});
		btnStudentUpdate.setBounds(50, 30, 107, 23);
		contentPane.add(btnStudentUpdate);
		
		JButton btnMachineUpdate = new JButton("Machine Update");
		btnMachineUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				updateMachine umh = new updateMachine();
				umh.setVisible(true);
			}
		});
		btnMachineUpdate.setBounds(50, 86, 107, 23);
		contentPane.add(btnMachineUpdate);
	}

}
