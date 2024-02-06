import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class firstPageFrame extends JFrame {

	private JPanel contentPane;

	employeeFrame ef = new employeeFrame();
	customerFrame cf = new customerFrame();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					firstPageFrame frame = new firstPageFrame();
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
	public firstPageFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ODIS  INSURANCE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(119, 41, 252, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("I am a");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(119, 115, 70, 24);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCustomer = new JButton("CUSTOMER");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cf.setVisible(true);
			}
		});
		btnCustomer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCustomer.setBounds(199, 110, 126, 35);
		contentPane.add(btnCustomer);
		
		JLabel lblNewLabel_2 = new JLabel("I am an");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(119, 176, 70, 24);
		contentPane.add(lblNewLabel_2);
		
		JButton btnEmployee = new JButton("EMPLOYEE");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ef.setVisible(true);
			}
		});
		btnEmployee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEmployee.setBounds(199, 173, 126, 35);
		contentPane.add(btnEmployee);
		
		JButton btnNewButton = new JButton("FIRST READ FROM FILE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarSys.readfromFile();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(88, 232, 283, 21);
		contentPane.add(btnNewButton);
	}

}
