package org.assume.api.flightchecking;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.assume.api.types.Flight;
import org.joda.time.DateTime;

public class FlightGUI extends JFrame
{
	
	private static final long serialVersionUID = -6201380246640590199L;
	private JPanel frame;
	private JTextField confirmationNumberField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField yearField;
	private JTextField monthField;
	private JTextField dayField;
	private JTextField hourField;
	private JLabel lblNewLabel_7;
	private JTextField minuteField;
	private JButton btnShowFlights;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					FlightGUI frame = new FlightGUI();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FlightGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 377);
		frame = new JPanel();
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frame);
		frame.setLayout(null);

		JLabel lblNewLabel = new JLabel("Confirmation Number:");
		lblNewLabel.setBounds(10, 11, 136, 14);
		frame.add(lblNewLabel);

		confirmationNumberField = new JTextField();
		confirmationNumberField.setBounds(156, 8, 144, 20);
		frame.add(confirmationNumberField);
		confirmationNumberField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setBounds(10, 39, 112, 14);
		frame.add(lblNewLabel_1);

		firstNameField = new JTextField();
		firstNameField.setBounds(156, 39, 144, 20);
		frame.add(firstNameField);
		firstNameField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Last Name:");
		lblNewLabel_2.setBounds(10, 70, 86, 14);
		frame.add(lblNewLabel_2);

		lastNameField = new JTextField();
		lastNameField.setBounds(156, 70, 144, 20);
		frame.add(lastNameField);
		lastNameField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Year:");
		lblNewLabel_3.setBounds(10, 106, 46, 14);
		frame.add(lblNewLabel_3);

		yearField = new JTextField();
		yearField.setBounds(156, 101, 144, 20);
		frame.add(yearField);
		yearField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Month:");
		lblNewLabel_4.setBounds(10, 144, 112, 14);
		frame.add(lblNewLabel_4);

		monthField = new JTextField();
		monthField.setBounds(156, 141, 144, 20);
		frame.add(monthField);
		monthField.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Day:");
		lblNewLabel_5.setBounds(10, 184, 46, 14);
		frame.add(lblNewLabel_5);

		dayField = new JTextField();
		dayField.setBounds(156, 181, 144, 20);
		frame.add(dayField);
		dayField.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Hour:");
		lblNewLabel_6.setBounds(10, 216, 46, 14);
		frame.add(lblNewLabel_6);

		hourField = new JTextField();
		hourField.setBounds(156, 212, 144, 20);
		frame.add(hourField);
		hourField.setColumns(10);

		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				DateTime time = new DateTime(Integer.parseInt(yearField
						.getText().trim()), Integer.parseInt(monthField
						.getText().trim()), Integer.parseInt(dayField.getText()
						.trim()), Integer.parseInt(hourField.getText().trim()),
						Integer.parseInt(minuteField.getText().trim()), 1);
				
				new Flight(firstNameField.getText(), lastNameField.getText(),
						confirmationNumberField.getText(), new Date(time.getMillis()))
						.schedule();
				
				System.out.println(confirmationNumberField.getText());
			}
		});
		btnSchedule.setBounds(211, 304, 89, 23);
		frame.add(btnSchedule);
		
		lblNewLabel_7 = new JLabel("Minute:");
		lblNewLabel_7.setBounds(10, 252, 46, 14);
		frame.add(lblNewLabel_7);
		
		minuteField = new JTextField();
		minuteField.setBounds(156, 243, 144, 20);
		frame.add(minuteField);
		minuteField.setColumns(10);
		
		btnShowFlights = new JButton("Show Flights");
		btnShowFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShowFlights.setBounds(7, 304, 103, 23);
		frame.add(btnShowFlights);
	}
}
