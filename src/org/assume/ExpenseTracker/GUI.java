package org.assume.ExpenseTracker;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.assume.api.types.Category;
import org.assume.api.types.Date;
import org.assume.api.types.Month;
import org.assume.api.types.Purchase;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField priceField;
	final static DefaultListModel<String> MODEL_PURCHASE = new DefaultListModel<String>();
	final static DefaultComboBoxModel<String> MODEL_CATEGORY = new DefaultComboBoxModel<String>();
	private JComboBox yearComboBox;
	private JComboBox dayComboBox;
	private JComboBox monthComboBox;
	private JComboBox categoryBox;
	private JTextField nameField;
	private JTextField searchNameField;
	private JTextField lowTextField;
	private JTextField highTextField;

	static void updateList() {
		for (int i = 0; i < Tracker.list.size(); i++) {
			MODEL_PURCHASE.addElement(Tracker.list.get(i).toString());
		}
	}

	Category getCategoryFromString(String s) {
		for (int i = 0; i < Tracker.categoryList.size(); i++) {
			if (Tracker.categoryList.get(i).toString().equals(s)) {
				return Tracker.categoryList.get(i);
			}
		}
		return null;
	}

	Month getMonthFromString(String s) {
		for (Month m : Month.values()) {
			if (m.toString().equals(s)) {

				return m;
			}
		}
		return null;
	}
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args)
	// {

	// }

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAddPurchase = new JButton("路径点列表");
		btnAddPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Purchase d = new Purchase(Double.parseDouble(priceField.getText()), nameField.getText(),
						new Date(Integer.parseInt(yearComboBox.getSelectedItem().toString()),
								getMonthFromString(monthComboBox.getSelectedItem().toString()).getMonth(),
								Integer.parseInt(dayComboBox.getSelectedItem().toString())),
						new Category(categoryBox.getSelectedItem().toString()));
				Tracker.addNewPurchase(d);

				double temp = Tracker.totalMap.get(d.getCategory().toString());
				Tracker.totalMap.remove(d.getCategory().toString());
				// Tracker.totalMap.put(d.getCategory().toString(), (temp +
				// Tracker.list.get(Tracker.list.indexOf(d)).getPrice()));

				System.out.println(d.getCategory().toString() + "Hi");
				// System.out.println(Tracker.totalMap.get(d.getCategory()));
				// double temp = Tracker.totalMap.get(d.getCategory());
				Tracker.totalMap.remove(d.getCategory());
				// System.out.println("Hi "+(temp +
				// Tracker.list.get(Tracker.list.indexOf(d)).getPrice()));
				// Tracker.totalMap.put(d.getCategory(), (temp +
				// Tracker.list.get(Tracker.list.indexOf(d)).getPrice()));

				MODEL_PURCHASE.addElement(Tracker.list.get(Tracker.list.indexOf(d)).toString());
			}
		});
		btnAddPurchase.setBounds(693, 478, 120, 23);
		contentPane.add(btnAddPurchase);

		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(20, 417, 46, 14);
		contentPane.add(lblYear);
		final DefaultComboBoxModel<String> MODEL_MONTH = new DefaultComboBoxModel<String>();
		monthComboBox = new JComboBox(MODEL_MONTH);
		monthComboBox.setBounds(150, 442, 136, 20);
		contentPane.add(monthComboBox);

		for (Month m : Month.values()) {
			MODEL_MONTH.addElement(m.toString());
		}

		categoryBox = new JComboBox(MODEL_CATEGORY);
		categoryBox.setBounds(442, 442, 120, 20);
		contentPane.add(categoryBox);

		for (Category b : Tracker.categoryList.toArray(new Category[Tracker.categoryList.size()])) {
			MODEL_CATEGORY.addElement(b.toString());
		}

		JLabel monthLabel = new JLabel("Month");
		monthLabel.setBounds(150, 417, 46, 14);
		contentPane.add(monthLabel);
		final DefaultComboBoxModel<Integer> MODEL_YEAR = new DefaultComboBoxModel<Integer>();
		yearComboBox = new JComboBox(MODEL_YEAR);
		yearComboBox.setBounds(20, 442, 120, 20);
		contentPane.add(yearComboBox);
		for (int i = 1970; i <= 2013; i++) {
			MODEL_YEAR.addElement(i);
		}
		MODEL_YEAR.setSelectedItem(2013);
		final DefaultComboBoxModel<Integer> MODEL_DAY = new DefaultComboBoxModel<Integer>();
		dayComboBox = new JComboBox(MODEL_DAY);
		dayComboBox.setBounds(296, 442, 136, 20);
		contentPane.add(dayComboBox);
		for (int i = 1; i <= Month.JANUARY.getDays(); i++) {
			MODEL_DAY.addElement(i);
		}
		monthComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == arg0.SELECTED) {
					MODEL_DAY.removeAllElements();
					Month d = null;
					for (Month m : Month.values()) {
						if (m.toString().equals(MODEL_MONTH.getSelectedItem().toString())) {
							d = m;
							break;
						}
					}
					if (d != null) {
						for (int i = 1; i <= d.getDays(); i++) {
							MODEL_DAY.addElement(i);
						}
					}
				}
			}
		});

		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(296, 417, 46, 14);
		contentPane.add(lblDay);

		priceField = new JTextField();
		priceField.setBounds(572, 442, 86, 20);
		contentPane.add(priceField);
		priceField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Price");
		lblNewLabel.setBounds(572, 417, 86, 14);
		contentPane.add(lblNewLabel);

		nameField = new JTextField();
		nameField.setBounds(668, 442, 86, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);

		JLabel lblItemName = new JLabel("Item name");
		lblItemName.setBounds(668, 417, 86, 14);
		contentPane.add(lblItemName);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 11, 389, 350);
		contentPane.add(scrollPane);

		JList purchaseList = new JList(MODEL_PURCHASE);
		scrollPane.setViewportView(purchaseList);

		JLabel searchLabel = new JLabel("Search ");
		searchLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchLabel.setBounds(538, 11, 73, 14);
		contentPane.add(searchLabel);

		searchNameField = new JTextField();
		searchNameField.setBounds(558, 36, 86, 20);
		contentPane.add(searchNameField);
		searchNameField.setColumns(10);

		JLabel lblItemName_1 = new JLabel("Item name");
		lblItemName_1.setBounds(482, 39, 79, 14);
		contentPane.add(lblItemName_1);

		lowTextField = new JTextField();
		lowTextField.setBounds(558, 122, 86, 20);
		contentPane.add(lowTextField);
		lowTextField.setColumns(10);

		highTextField = new JTextField();
		highTextField.setBounds(558, 153, 86, 20);
		contentPane.add(highTextField);
		highTextField.setColumns(10);

		JLabel betweenPriceLabel = new JLabel("Between Prices");
		betweenPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		betweenPriceLabel.setBounds(498, 84, 146, 14);
		contentPane.add(betweenPriceLabel);

		JLabel lblNewLabel_1 = new JLabel("High");
		lblNewLabel_1.setBounds(482, 156, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblLow = new JLabel("Low");
		lblLow.setBounds(482, 125, 46, 14);
		contentPane.add(lblLow);

		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(442, 417, 67, 14);
		contentPane.add(lblCategory);

		JButton expenseButton = new JButton("Generate expense report");
		expenseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FileIO.output();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		expenseButton.setBounds(10, 478, 174, 23);
		contentPane.add(expenseButton);
		lowTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (lowTextField.getText().equals("") && highTextField.getText().equals("")
						&& priceField.getText().equals("")) {
					MODEL_PURCHASE.clear();
					for (int r = 0; r < Tracker.list.size(); r++) {
						MODEL_PURCHASE.addElement(Tracker.list.get(r).toString());
					}
				}
			}
		});
		highTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (lowTextField.getText().equals("") && highTextField.getText().equals("")
						&& priceField.getText().equals("")) {
					MODEL_PURCHASE.clear();
					for (int r = 0; r < Tracker.list.size(); r++) {
						MODEL_PURCHASE.addElement(Tracker.list.get(r).toString());
					}
				}
			}
		});
		priceField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (lowTextField.getText().equals("") && highTextField.getText().equals("")
						&& priceField.getText().equals("")) {
					MODEL_PURCHASE.clear();
					for (int r = 0; r < Tracker.list.size(); r++) {
						MODEL_PURCHASE.addElement(Tracker.list.get(r).toString());
					}
				}
			}
		});
		lowTextField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				updateL();
			}

			public void removeUpdate(DocumentEvent e) {
				updateL();
			}

			public void insertUpdate(DocumentEvent e) {
				updateL();
			}

			public void updateL() {
				MODEL_PURCHASE.clear();
				if (lowTextField.getText().equals("") && highTextField.getText().equals("")
						&& priceField.getText().equals("")) {
					MODEL_PURCHASE.clear();
					for (int r = 0; r < Tracker.list.size(); r++) {
						MODEL_PURCHASE.addElement(Tracker.list.get(r).toString());
					}
				} else {
					MODEL_PURCHASE.clear();
					for (int i = 0; i < Tracker.list.size(); i++) {
						if (!highTextField.getText().equals("") && !searchNameField.getText().equals("")) {
							if (Tracker.list.get(i).getPrice() <= Double.parseDouble(highTextField.getText())
									&& Tracker.list.get(i).getPrice() >= Double.parseDouble(lowTextField.getText())
									&& Tracker.list.get(i).getItem().contains(searchNameField.getText())) {
								MODEL_PURCHASE.addElement(Tracker.list.get(i).toString());
							}
						} else if (!highTextField.getText().equals("") && !lowTextField.getText().equals("")) {
							if (Tracker.list.get(i).getPrice() <= Double.parseDouble(highTextField.getText())
									&& Tracker.list.get(i).getPrice() >= Double.parseDouble(lowTextField.getText())) {
								MODEL_PURCHASE.addElement(Tracker.list.get(i).toString());
							}
						} else if (!searchNameField.getText().equals("") && !lowTextField.getText().equals("")) {
							if (Tracker.list.get(i).getPrice() <= Double.parseDouble(highTextField.getText())
									&& Tracker.list.get(i).getItem().contains(searchNameField.getText())) {
								MODEL_PURCHASE.addElement(Tracker.list.get(i).toString());
							}
						} else if (!lowTextField.getText().equals("")
								&& Tracker.list.get(i).getPrice() >= Double.parseDouble(lowTextField.getText())) {
							MODEL_PURCHASE.addElement(Tracker.list.get(i).toString());
						}
					}
				}
			}
		});

		highTextField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				updateH();
			}

			public void removeUpdate(DocumentEvent e) {
				updateH();
			}

			public void insertUpdate(DocumentEvent e) {
				updateH();
			}

			public void updateH() {
				MODEL_PURCHASE.clear();
				if (lowTextField.getText().equals("") && highTextField.getText().equals("")
						&& priceField.getText().equals("")) {
					MODEL_PURCHASE.clear();
					for (int r = 0; r < Tracker.list.size(); r++) {
						MODEL_PURCHASE.addElement(Tracker.list.get(r).toString());
					}
				} else {
					MODEL_PURCHASE.clear();
					for (int i = 0; i < Tracker.list.size(); i++) {
						if (!lowTextField.getText().equals("") && !searchNameField.getText().equals("")) {
							if (Tracker.list.get(i).getPrice() <= Double.parseDouble(highTextField.getText())
									&& Tracker.list.get(i).getPrice() >= Double.parseDouble(lowTextField.getText())
									&& Tracker.list.get(i).getItem().contains(searchNameField.getText())) {
								MODEL_PURCHASE.addElement(Tracker.list.get(i).toString());
							}
						} else if (!lowTextField.getText().equals("") && !highTextField.getText().equals("")) {
							if (Tracker.list.get(i).getPrice() <= Double.parseDouble(highTextField.getText())
									&& Tracker.list.get(i).getPrice() >= Double.parseDouble(lowTextField.getText())) {
								MODEL_PURCHASE.addElement(Tracker.list.get(i).toString());
							}
						} else if (!searchNameField.getText().equals("")) {
							if (Tracker.list.get(i).getPrice() <= Double.parseDouble(highTextField.getText())
									&& Tracker.list.get(i).getItem().contains(searchNameField.getText())) {
								MODEL_PURCHASE.addElement(Tracker.list.get(i).toString());
							}
						} else if (!highTextField.getText().equals("")
								&& Tracker.list.get(i).getPrice() <= Double.parseDouble(highTextField.getText())
								&& lowTextField.getText().equals("")) {
							MODEL_PURCHASE.addElement(Tracker.list.get(i).toString());
						}
					}
				}
			}
		});

		searchNameField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				updateN();
			}

			public void removeUpdate(DocumentEvent e) {
				updateN();
			}

			public void insertUpdate(DocumentEvent e) {
				updateN();
			}

			public void updateN() {
				if (lowTextField.getText().equals("") && highTextField.getText().equals("")
						&& priceField.getText().equals("")) {

					MODEL_PURCHASE.clear();
					for (int r = 0; r < Tracker.list.size(); r++)

						/*
						 * if(!lowTextField.getText().equals("") &&
						 * !highTextField.getText().equals("")) {
						 * MODEL_PURCHASE.addElement(Tracker.list.get(r).
						 * toString()); } } else { MODEL_PURCHASE.clear();
						 * for(int i = 0; i < Tracker.list.size(); i++) {
						 * if(!lowTextField.getText().equals("") &&
						 * !highTextField.getText().equals("")) {
						 * if(Tracker.list.get(i).getPrice() <=
						 * Double.parseDouble(highTextField.getText()) &&
						 * Tracker.list.get(i).getPrice() >=
						 * Double.parseDouble(lowTextField.getText()) &&
						 * Tracker.list.get(i).getItem().contains(
						 * searchNameField.getText())) {
						 * MODEL_PURCHASE.addElement(Tracker.list.get(i).
						 * toString()); } } else
						 * if(!lowTextField.getText().equals("")) {
						 * if(Tracker.list.get(i).getPrice() <=
						 * Double.parseDouble(highTextField.getText()) &&
						 * Tracker.list.get(i).getPrice() >=
						 * Double.parseDouble(lowTextField.getText())) {
						 * MODEL_PURCHASE.addElement(Tracker.list.get(i).
						 * toString()); } }
						 * 
						 * else if(!highTextField.getText().equals("")) {
						 * if(Tracker.list.get(i).getPrice() <=
						 * Double.parseDouble(highTextField.getText()) &&
						 * Tracker.list.get(i).getItem().contains(
						 * searchNameField.getText())) {
						 * MODEL_PURCHASE.addElement(Tracker.list.get(i).
						 * toString()); } } else
						 * if(Tracker.list.get(i).getItem().contains(
						 * searchNameField.getText()))
						 * 
						 * } else if(Tracker.list.get(i).getItem().contains(
						 * searchNameField.getText())) {
						 * MODEL_PURCHASE.addElement(Tracker.list.get(i).
						 * toString()); }
						 */
						// else
						// {
						MODEL_PURCHASE.clear();
					for (int d = 0; d < Tracker.list.size(); d++) {
						MODEL_PURCHASE.addElement(Tracker.list.get(d).toString());
					}
					// }
				}
			}
		});
	}
}
