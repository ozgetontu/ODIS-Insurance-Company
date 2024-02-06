import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class employeeSearchFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textEmpLicensePlate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeeSearchFrame frame = new employeeSearchFrame();
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
	public employeeSearchFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter License Plate: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(50, 64, 134, 32);
		contentPane.add(lblNewLabel);
		
		textEmpLicensePlate = new JTextField();
		textEmpLicensePlate.setBounds(237, 66, 156, 32);
		contentPane.add(textEmpLicensePlate);
		textEmpLicensePlate.setColumns(10);
		
		JTextArea textEmpSearchDisplay = new JTextArea();
		textEmpSearchDisplay.setBounds(46, 192, 347, 303);
		contentPane.add(textEmpSearchDisplay);
		
		JButton btnEmpPlateSearch = new JButton("SEARCH");
		btnEmpPlateSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cars car = CarSys.searchCar(textEmpLicensePlate.getText());
				textEmpSearchDisplay.setText(car.toString());
			}
		});
		btnEmpPlateSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEmpPlateSearch.setBounds(155, 128, 126, 32);
		contentPane.add(btnEmpPlateSearch);
		
		
		
		JButton btnEmpSearchClose = new JButton("Close");
		btnEmpSearchClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnEmpSearchClose.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEmpSearchClose.setBounds(335, 518, 91, 32);
		contentPane.add(btnEmpSearchClose);
	}

}
