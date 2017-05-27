package org.assume.api.formatting;

public class ShapeDrawer {

	private Shape shape;
	private char spacingChar;
	private char drawingChar;
	private int maxSize;
	private boolean atMax;
	private int currentSize;

	public ShapeDrawer(Shape shape, char spacingChar, char drawingChar, int maxSize) {
		this(shape, spacingChar, drawingChar, maxSize, false, 1);
	}

	private ShapeDrawer(Shape shape, char spacingChar, char drawingChar, int maxSize, boolean atMax, int currentSize) {
		this.setShape(shape);
		this.setSpacingChar(spacingChar);
		this.setDrawingChar(drawingChar);
		this.setMaxSize(maxSize);
		this.atMax = atMax;
		this.currentSize = currentSize;
	}

	public void draw() {
		this.getShape().draw(this.getMaxSize(), this.getSpacingChar(), this.getCurrentSize(), this.getDrawingChar(),
				this.atMax);
	}

	public int getCurrentSize() {
		return currentSize;
	}

	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}

	public char getDrawingChar() {
		return drawingChar;
	}

	public void setDrawingChar(char drawingChar) {
		this.drawingChar = drawingChar;
	}

	public char getSpacingChar() {
		return spacingChar;
	}

	public void setSpacingChar(char spacingChar) {
		this.spacingChar = spacingChar;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	enum Shape {
		STAR {
			@Override
			void draw(int max, char spacing, int x, char drawing, boolean atMax) {
			}
		},
		DIAMOND {
			@Override
			void draw(int max, char spacing, int x, char drawing, boolean atMax) {

				if (x < 1) {
					return;
				} else if (x > max && !atMax) {
					draw(max, spacing, x - 4, drawing, !atMax);
				} else {
					for (int r = 0; r < (Math.ceil((max - x) / 2)); r++) {
						System.out.print(spacing);
					}
					for (int i = 0; i < x; i++) {
						System.out.print(drawing);
					}
					for (int r = 0; r < (Math.ceil((max - x) / 2)); r++) {
						System.out.print(spacing);
					}
					System.out.println();
					if (atMax) {
						draw(max, spacing, x - 2, drawing, atMax);
					} else {
						draw(max, spacing, x + 2, drawing, atMax);
					}
				}
			}
		};

		abstract void draw(int max, char u, int x, char c, boolean t);
	}

	public static void main(String[] args) {
		new ShapeDrawer(Shape.DIAMOND, ' ', '*', 7).draw();
	}

}
