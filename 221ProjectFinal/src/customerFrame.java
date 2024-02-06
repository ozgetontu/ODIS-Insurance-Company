import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class customerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textCarLicensePlate;
	private JTextField textCarAge;
	private JTextField textCarEngine;

	customerSearchFrame csf = new customerSearchFrame();
	private JTextField textDriverInfo;
	private JTextField textCarModel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerFrame frame = new customerFrame();
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
	public customerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 948, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO ODIS INSURANCE  :)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(274, 41, 433, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("License Plate:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(80, 130, 171, 30);
		contentPane.add(lblNewLabel_1);
		
		textCarLicensePlate = new JTextField();
		textCarLicensePlate.setBounds(215, 133, 222, 30);
		contentPane.add(textCarLicensePlate);
		textCarLicensePlate.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Car's Age: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(80, 206, 171, 30);
		contentPane.add(lblNewLabel_2);
		
		textCarAge = new JTextField();
		textCarAge.setColumns(10);
		textCarAge.setBounds(215, 206, 222, 30);
		contentPane.add(textCarAge);
		
		JLabel lblNewLabel_3 = new JLabel("Driver Crash Info (None, Low, Medum, High) :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(80, 294, 331, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel addInfo = new JLabel("");
		addInfo.setBounds(231, 360, 231, 45);
		contentPane.add(addInfo);
		
		JButton btnCarAdd = new JButton("ADD CAR");
		btnCarAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( textCarLicensePlate.getText().isEmpty()|| textCarAge.getText().isEmpty() || textCarEngine.getText().isEmpty() || textCarModel.getText().isEmpty() || textDriverInfo.getText().isEmpty())
					addInfo.setText("Please fill\nall necessary fields");
				else
					{
					
				boolean res = CarSys.addCar(textCarModel.getText(), textCarLicensePlate.getText(), Integer.parseInt(textCarAge.getText()), textDriverInfo.getText(), Double.parseDouble(textCarEngine.getText()));
				
				if(res == false)
					addInfo.setText("This car is already added!");
				else
					addInfo.setText("This car is added.");
			}
					
			}
		});
		btnCarAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCarAdd.setBounds(80, 359, 141, 46);
		contentPane.add(btnCarAdd);
		
		JButton btnCarSearch = new JButton("SEARCH CAR");
		btnCarSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csf.setVisible(true);
			}
		});
		btnCarSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCarSearch.setBounds(497, 360, 141, 46);
		contentPane.add(btnCarSearch);
		
		JLabel lblNewLabel_4 = new JLabel("Model (Mercedes, BMW, AUDI):");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(537, 141, 222, 19);
		contentPane.add(lblNewLabel_4);
		
		textCarEngine = new JTextField();
		textCarEngine.setColumns(10);
		textCarEngine.setBounds(648, 206, 222, 30);
		contentPane.add(textCarEngine);
		
		JLabel lblNewLabel_5 = new JLabel("Engine Power:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(537, 217, 101, 19);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("HP");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(880, 215, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JTextArea textPayment = new JTextArea();
		textPayment.setBounds(724, 340, 171, 59);
		contentPane.add(textPayment);
		
		JButton btnCalcIns = new JButton("CALCULATE INSURANCE");
		btnCalcIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( textCarLicensePlate.getText().isEmpty()|| textCarAge.getText().isEmpty() || textCarEngine.getText().isEmpty() || textCarModel.getText().isEmpty() || textDriverInfo.getText().isEmpty())
					textPayment.setText("Please fill\nall necessary fields");
				else {
					if(CarSys.checkLicensePlate(textCarLicensePlate.getText()) == false)
						textPayment.setText("There is no\ncar matched...");
					else {
						Cars car = CarSys.searchCar(textCarLicensePlate.getText());
						CarSys.calcInsurance();
						textPayment.setText("Price is\n"+car.insurancePrice);
					}
				}
			}
		});
		btnCalcIns.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCalcIns.setBounds(684, 292, 241, 38);
		contentPane.add(btnCalcIns);
		
		textDriverInfo = new JTextField();
		textDriverInfo.setBounds(399, 288, 156, 30);
		contentPane.add(textDriverInfo);
		textDriverInfo.setColumns(10);
		
		textCarModel = new JTextField();
		textCarModel.setColumns(10);
		textCarModel.setBounds(769, 138, 156, 30);
		contentPane.add(textCarModel);
		
		
		
		
	}
}
