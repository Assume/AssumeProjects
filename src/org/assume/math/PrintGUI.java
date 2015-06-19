package org.assume.math;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class PrintGUI extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	public PrintGUI() {
		setBounds(100, 100, 626, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		setVisible(true);
	}

	public void print(MatrixAnswer... all) {
		for (MatrixAnswer x : all) {
			if (x != null)
				this.textArea.append(x.print());
		}
	}
}
