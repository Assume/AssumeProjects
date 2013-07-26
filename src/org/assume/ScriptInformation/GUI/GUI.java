package org.assume.ScriptInformation.gui;


import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import org.assume.ScriptInformation.handlers.GUIHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame
{


	private static final long serialVersionUID = -6662234732912027441L;
	private JPanel contentPane;
	public static List<String> listOfUsers = new ArrayList<String>();
	static JList scriptInformationList;
	public static JList scriptList;
	public static DefaultListModel<String> modelScripts = new DefaultListModel<String>();
	public static DefaultListModel<String> modelInfo = new DefaultListModel<String>();
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
		setBounds(100, 100, 882, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Scripts");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel.setBounds(145, 11, 96, 27);
		contentPane.add(lblNewLabel);

		JLabel lblScriptInformation = new JLabel("Script Information");
		lblScriptInformation.setFont(new Font("Arial", Font.BOLD, 17));
		lblScriptInformation.setBounds(528, 37, 170, 27);
		contentPane.add(lblScriptInformation);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(268, 323, 89, 23);
		contentPane.add(btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index  = scriptList.getSelectedIndex();
				if(index > -1)
				{
					listOfUsers.remove(handler.getUsername(modelScripts.get(index)));
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
		btnRefresh.setBounds(729, 323, 89, 23);
		contentPane.add(btnRefresh);

		JLabel lblNewLabel_1 = new JLabel("Script Name | Username | Script Status");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(47, 38, 310, 26);
		contentPane.add(lblNewLabel_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 74, 336, 237);
		contentPane.add(scrollPane_1);

		scriptList = new JList(modelScripts);
		scrollPane_1.setViewportView(scriptList);
		scriptList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scriptList.setFont(new Font("Arial",Font.BOLD,14));
		scriptList.setCellRenderer(new SelectedListCellRenderer());
		scriptList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				handler.refresh();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(382, 75, 436, 237);
		contentPane.add(scrollPane);

		scriptInformationList = new JList(modelInfo);
		scrollPane.setViewportView(scriptInformationList);
		scriptInformationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scriptInformationList.setFont(new Font("Arial",Font.BOLD,11));
	}
}


class SelectedListCellRenderer extends DefaultListCellRenderer 
{
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if (value.toString().contains("Paused") || value.toString().contains("Stopped")) 
		{
			c.setBackground(Color.RED);
		}
		return c;
	}
}
