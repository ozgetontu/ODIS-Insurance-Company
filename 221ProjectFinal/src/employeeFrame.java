import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class employeeFrame extends JFrame {

	private JPanel contentPane;
	
	employeeSearchFrame esf = new employeeSearchFrame();
	employeeListFrame elf = new employeeListFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeeFrame frame = new employeeFrame();
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
	public employeeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("I would like to...");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(93, 71, 121, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnEmpSearch = new JButton("Search a Car");
		btnEmpSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esf.setVisible(true);
			}
		});
		btnEmpSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEmpSearch.setBounds(82, 137, 121, 27);
		contentPane.add(btnEmpSearch);
		
		JButton btnEmpList = new JButton("List All Car");
		btnEmpList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elf.setVisible(true);
			}
		});
		btnEmpList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEmpList.setBounds(82, 218, 121, 27);
		contentPane.add(btnEmpList);
	}

}
