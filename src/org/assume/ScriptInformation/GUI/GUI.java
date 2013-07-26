package org.assume.ScriptInformation.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame
{

	private JPanel contentPane;
	static List<String> listOfUsers = new ArrayList<String>();
	static JList scriptInformationList;
	static JList scriptList;
	public static DefaultListModel<String> modelScripts = new DefaultListModel<String>();
	static DefaultListModel<String> modelInfo = new DefaultListModel<String>();
	private final GUIHandler handler = new GUIHandler();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public GUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Scripts");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel.setBounds(176, 11, 96, 27);
		contentPane.add(lblNewLabel);

		JLabel lblScriptInformation = new JLabel("Script Information");
		lblScriptInformation.setFont(new Font("Arial", Font.BOLD, 17));
		lblScriptInformation.setBounds(488, 37, 170, 27);
		contentPane.add(lblScriptInformation);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(439, 75, 256, 451);
		contentPane.add(scrollPane_1);

		scriptInformationList = new JList(modelInfo);
		scrollPane_1.setViewportView(scriptInformationList);
		scriptInformationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scriptInformationList.setFont(new Font("Arial",Font.BOLD,11));
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(292, 531, 89, 23);
		contentPane.add(btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index  = scriptList.getSelectedIndex();
				if(index > -1)
				{
					listOfUsers.remove(handler.getUsername(modelScripts.get(index),"[", "]"));
					modelScripts.remove(index);

				}
			}
		});

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handler.updateInfoList(modelInfo.toArray());
			}
		});
		btnRefresh.setBounds(606, 531, 89, 23);
		contentPane.add(btnRefresh);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 74, 338, 451);
		contentPane.add(scrollPane);

		scriptList = new JList(modelScripts);
		scrollPane.setViewportView(scriptList);
		scriptList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scriptList.setFont(new Font("Arial",Font.BOLD,14));
		
		scriptList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				handler.refresh();
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Script Name | Username | Script Status");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(62, 37, 310, 26);
		contentPane.add(lblNewLabel_1);
	}
}
