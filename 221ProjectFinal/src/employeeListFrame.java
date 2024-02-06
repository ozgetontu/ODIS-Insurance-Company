import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class employeeListFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeeListFrame frame = new employeeListFrame();
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
	public employeeListFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textEmpListDisplay = new JTextArea();
		textEmpListDisplay.setBounds(38, 57, 523, 533);
		contentPane.add(textEmpListDisplay);
		
		JButton btnEmpListClose = new JButton("Close");
		btnEmpListClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnEmpListClose.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEmpListClose.setBounds(495, 600, 92, 37);
		contentPane.add(btnEmpListClose);
		
		JButton btnDisplayAllCar = new JButton("DISPLAY ALL CAR'S INFO");
		btnDisplayAllCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = CarSys.display();
				textEmpListDisplay.setText(output);
			}
		});
		btnDisplayAllCar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDisplayAllCar.setBounds(115, 10, 260, 37);
		contentPane.add(btnDisplayAllCar);
	}

}
