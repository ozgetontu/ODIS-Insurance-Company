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

public class customerSearchFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textSearchPlate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerSearchFrame frame = new customerSearchFrame();
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
	public customerSearchFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter License PLate to Search:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(44, 56, 232, 38);
		contentPane.add(lblNewLabel);
		
		textSearchPlate = new JTextField();
		textSearchPlate.setBounds(311, 65, 196, 26);
		contentPane.add(textSearchPlate);
		textSearchPlate.setColumns(10);
		
		JTextArea textCustSearchDisplay = new JTextArea();
		textCustSearchDisplay.setBounds(44, 178, 463, 246);
		contentPane.add(textCustSearchDisplay);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cars car = CarSys.searchCar(textSearchPlate.getText());
				textCustSearchDisplay.setText(car.toString());
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBounds(207, 122, 139, 38);
		contentPane.add(btnSearch);
		
		
		
		JButton btnCustSearchClose = new JButton("Close");
		btnCustSearchClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCustSearchClose.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCustSearchClose.setBounds(452, 122, 91, 32);
		contentPane.add(btnCustSearchClose);
	}

}
