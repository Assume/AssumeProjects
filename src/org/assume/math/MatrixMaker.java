package org.assume.math;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.CellRendererPane;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class MatrixMaker extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtName;
	private GUI gui;
	private DefaultTableModel table_model;
	private int col;
	private JScrollPane scrollPane;

	public MatrixMaker(final GUI gu) {
		this.gui = gu;
		int row = Integer.parseInt(JOptionPane.showInputDialog("Enter number of rows: "));
		int col = Integer.parseInt(JOptionPane.showInputDialog("Enter number of columns: "));
		this.col = col;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 19, 438, 204);
		contentPane.add(scrollPane);
		table_model = new DefaultTableModel();
		table = new JTable(table_model);
		table.setModel(table_model);
		table_model.setColumnCount(col);
		table_model.setColumnIdentifiers(getColumnNames());
		table_model.setRowCount(row);

		scrollPane.setViewportView(table);

		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(168, 235, 134, 28);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.getSelectionModel().clearSelection();
				Matrix r = getMatrix(txtName.getText());
				if (r == null)
					return;
				gui.addMatrix(r);
				gui.update();
				setVisible(false);
				dispose();
			}
		});

		btnDone.setBounds(327, 236, 117, 29);
		contentPane.add(btnDone);
		setVisible(true);

	}

	private Matrix getMatrix(String name) {
		try {
			Matrix x = new Matrix(this.table_model.getRowCount(), this.table_model.getColumnCount(), name);
			for (int i = 0; i < this.table_model.getRowCount(); i++) {
				for (int j = 0; j < this.table_model.getColumnCount(); j++) {
					x.set(i, j, Integer.parseInt((String) this.table_model.getValueAt(i, j)));
				}
			}
			return x;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
					"Make sure you have either entered numbers into all boxes and have deselect all boes (hit tab a few times).");
		}
		return null;
	}

	public String[] getColumnNames() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < this.col; i++)
			list.add("Number");
		return list.toArray(new String[list.size()]);
	}
}

class BetterJTable extends JTable {

	private static final Color EVEN_ROW_COLOR = new Color(241, 245, 250);
	private static final Color TABLE_GRID_COLOR = new Color(0xd9d9d9);

	private static final CellRendererPane CELL_RENDER_PANE = new CellRendererPane();

	public BetterJTable(TableModel dm) {
		super(dm);
		init();
	}

	private void init() {
		setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		setTableHeader(createTableHeader());
		getTableHeader().setReorderingAllowed(false);
		setOpaque(false);
		setGridColor(TABLE_GRID_COLOR);
		setIntercellSpacing(new Dimension(0, 0));
		// turn off grid painting as we'll handle this manually in order to
		// paint
		// grid lines over the entire viewport.
		setShowGrid(false);
	}

	/**
	 * Creates a JTableHeader that paints the table header background to the
	 * right of the right-most column if neccesasry.
	 */
	private JTableHeader createTableHeader() {
		return new JTableHeader(getColumnModel()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// if this JTableHEader is parented in a JViewport, then paint
				// the
				// table header background to the right of the last column if
				// neccessary.
				JViewport viewport = (JViewport) table.getParent();
				if (viewport != null && table.getWidth() < viewport.getWidth()) {
					int x = table.getWidth();
					int width = viewport.getWidth() - table.getWidth();
					paintHeader(g, getTable(), x, width);
				}
			}
		};
	}

	/**
	 * Paints the given JTable's table default header background at given x for
	 * the given width.
	 */
	private static void paintHeader(Graphics g, JTable table, int x, int width) {
		TableCellRenderer renderer = table.getTableHeader().getDefaultRenderer();
		Component component = renderer.getTableCellRendererComponent(table, "", false, false, -1, 2);

		component.setBounds(0, 0, width, table.getTableHeader().getHeight());

		((JComponent) component).setOpaque(false);
		CELL_RENDER_PANE.paintComponent(g, component, null, x, 0, width, table.getTableHeader().getHeight(), true);
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component component = super.prepareRenderer(renderer, row, column);
		// if the rendere is a JComponent and the given row isn't part of a
		// selection, make the renderer non-opaque so that striped rows show
		// through.
		if (component instanceof JComponent) {
			((JComponent) component).setOpaque(getSelectionModel().isSelectedIndex(row));
		}
		return component;
	}

	// Stripe painting Viewport. //////////////////////////////////////////////

	/**
	 * Creates a JViewport that draws a striped backgroud corresponding to the
	 * row positions of the given JTable.
	 */
	private static class StripedViewport extends JViewport {

		private final JTable fTable;

		public StripedViewport(JTable table) {
			fTable = table;
			setOpaque(false);
			initListeners();
		}

		private void initListeners() {
			// install a listener to cause the whole table to repaint when
			// a column is resized. we do this because the extended grid
			// lines may need to be repainted. this could be cleaned up,
			// but for now, it works fine.
			PropertyChangeListener listener = createTableColumnWidthListener();
			for (int i = 0; i < fTable.getColumnModel().getColumnCount(); i++) {
				fTable.getColumnModel().getColumn(i).addPropertyChangeListener(listener);
			}
		}

		private PropertyChangeListener createTableColumnWidthListener() {
			return new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
					repaint();
				}
			};
		}

		@Override
		protected void paintComponent(Graphics g) {
			paintStripedBackground(g);
			paintVerticalGridLines(g);
			super.paintComponent(g);
		}

		private void paintStripedBackground(Graphics g) {
			// get the row index at the top of the clip bounds (the first row
			// to paint).
			int rowAtPoint = fTable.rowAtPoint(g.getClipBounds().getLocation());
			// get the y coordinate of the first row to paint. if there are no
			// rows in the table, start painting at the top of the supplied
			// clipping bounds.
			int topY = rowAtPoint < 0 ? g.getClipBounds().y : fTable.getCellRect(rowAtPoint, 0, true).y;

			// create a counter variable to hold the current row. if there are
			// no
			// rows in the table, start the counter at 0.
			int currentRow = rowAtPoint < 0 ? 0 : rowAtPoint;
			while (topY < g.getClipBounds().y + g.getClipBounds().height) {
				int bottomY = topY + fTable.getRowHeight();
				g.setColor(getRowColor(currentRow));
				g.fillRect(g.getClipBounds().x, topY, g.getClipBounds().width, bottomY);
				topY = bottomY;
				currentRow++;
			}
		}

		private Color getRowColor(int row) {
			return row % 2 == 0 ? EVEN_ROW_COLOR : getBackground();
		}

		private void paintVerticalGridLines(Graphics g) {
			// paint the column grid dividers for the non-existent rows.
			int x = 0;
			for (int i = 0; i < fTable.getColumnCount(); i++) {
				TableColumn column = fTable.getColumnModel().getColumn(i);
				// increase the x position by the width of the current column.
				x += column.getWidth();
				g.setColor(TABLE_GRID_COLOR);
				// draw the grid line (not sure what the -1 is for, but
				// BasicTableUI
				// also does it.
				g.drawLine(x - 1, g.getClipBounds().y, x - 1, getHeight());
			}
		}
	}

	public static JScrollPane createStripedJScrollPane(JTable table) {
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewport(new StripedViewport(table));
		scrollPane.getViewport().setView(table);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setCorner(JScrollPane.UPPER_RIGHT_CORNER, createCornerComponent(table));
		return scrollPane;
	}

	/**
	 * Creates a component that paints the header background for use in a
	 * JScrollPane corner.
	 */
	private static JComponent createCornerComponent(final JTable table) {
		return new JComponent() {
			@Override
			protected void paintComponent(Graphics g) {
				paintHeader(g, table, 0, getWidth());
			}
		};
	}
}
