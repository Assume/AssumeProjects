package org.assume.math;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {

	private JPanel contentPane;
	private List<MatrixAnswer> answers;
	private List<Matrix> matrices;
	private GUI gui;
	private DefaultComboBoxModel<Matrix> matrix_model_one;
	private DefaultComboBoxModel<Matrix> matrix_model_two;
	private DefaultComboBoxModel<MatrixAnswer> matrix_model_three;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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

	public void addMatrix(Matrix x) {
		this.matrices.add(x);
	}

	public void addAnswer(MatrixAnswer an) {
		this.answers.add(an);
	}

	public GUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.gui = this;
		this.answers = new ArrayList<MatrixAnswer>();
		this.matrices = new ArrayList<Matrix>();
		matrix_model_one = new DefaultComboBoxModel<Matrix>();
		matrix_model_two = new DefaultComboBoxModel<Matrix>();
		matrix_model_three = new DefaultComboBoxModel<MatrixAnswer>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 143);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JComboBox<Matrix> matrix_one_combo = new JComboBox<Matrix>(
				getMatrices());
		matrix_one_combo.setBounds(6, 71, 132, 27);
		contentPane.add(matrix_one_combo);
		matrix_one_combo.setModel(this.matrix_model_one);

		final JComboBox<Matrix> matrix_two_combo = new JComboBox<Matrix>(
				getMatrices());
		matrix_two_combo.setBounds(150, 71, 132, 27);
		contentPane.add(matrix_two_combo);
		matrix_two_combo.setModel(this.matrix_model_two);

		final JComboBox<ExecuteType> execute_type = new JComboBox<ExecuteType>(
				ExecuteType.values());

		JButton btnNewMatrix = new JButton("New Matrix");
		btnNewMatrix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MatrixMaker(gui);
			}
		});
		btnNewMatrix.setBounds(438, 17, 117, 29);
		contentPane.add(btnNewMatrix);

		JButton btnExecute = new JButton("Execute");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Matrix one = (Matrix) matrix_one_combo.getSelectedItem();
				Matrix two = (Matrix) matrix_two_combo.getSelectedItem();
				if (one == null || two == null)
					return;
				MatrixAnswer x = ((ExecuteType) execute_type.getSelectedItem())
						.execute(one, two);
				if (x == null) {
					JOptionPane
							.showMessageDialog(
									null,
									"You cannot do that operation on these two matrices. Check to make sure they are compatible!");
				} else {
					if (!answers.contains(x)) {
						answers.add(x);
						matrix_model_three.addElement(x);
					}
				}
			}
		});
		btnExecute.setBounds(438, 70, 117, 29);
		contentPane.add(btnExecute);

		execute_type.setBounds(294, 71, 132, 27);
		contentPane.add(execute_type);

		final JComboBox<MatrixAnswer> matrix_edit_box = new JComboBox<MatrixAnswer>();
		matrix_edit_box.setModel(this.matrix_model_three);
		matrix_edit_box.setBounds(6, 18, 132, 27);
		contentPane.add(matrix_edit_box);

		JButton matrix_edit_remove_button = new JButton("Print");
		matrix_edit_remove_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MatrixAnswer an = (MatrixAnswer) matrix_edit_box
						.getSelectedItem();
				if (an == null)
					return;
				new PrintGUI().print(an);
			}
		});
		matrix_edit_remove_button.setBounds(150, 17, 117, 29);
		contentPane.add(matrix_edit_remove_button);

	}

	public void update() {
		matrix_model_one.removeAllElements();
		matrix_model_two.removeAllElements();
		for (Matrix x : getMatrices()) {
			matrix_model_one.addElement(x);
			matrix_model_two.addElement(x);
		}
	}

	private Matrix[] getMatrices() {
		return this.matrices.toArray(new Matrix[this.matrices.size()]);
	}
}
