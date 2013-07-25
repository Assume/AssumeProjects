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
	static DefaultListModel<String> modelScripts = new DefaultListModel<String>();
	static DefaultListModel<String> modelInfo = new DefaultListModel<String>();
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
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(152, 11, 96, 27);
		contentPane.add(lblNewLabel);

		JLabel lblScriptInformation = new JLabel("Script Information");
		lblScriptInformation.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblScriptInformation.setBounds(496, 11, 170, 27);
		contentPane.add(lblScriptInformation);

		
		

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(439, 50, 256, 476);
		contentPane.add(scrollPane_1);

		scriptInformationList = new JList(modelInfo);
		scrollPane_1.setViewportView(scriptInformationList);
		scriptInformationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 49, 340, 478);
		contentPane.add(scrollPane);

		scriptList = new JList(modelScripts);
		scrollPane.setViewportView(scriptList);
		scriptList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(292, 531, 89, 23);
		contentPane.add(btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelScripts.removeElement(scriptList.getSelectedValuesList().toString());
			}
		});
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIHandler.updateInfoList(modelInfo.toArray());
			}
		});
		btnRefresh.setBounds(606, 531, 89, 23);
		contentPane.add(btnRefresh);

		scriptList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				String s = scriptList.getSelectedValue().toString();
				if(s != null)
				{
					GUIHandler.updateInfoList(s);
				}	
			}
		});
	}
}
