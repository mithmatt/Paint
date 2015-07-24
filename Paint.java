import java.util.Arrays;

/**
 * Paint class with fill method implemented
 * 
 * @author Matt
 *
 */
public class Paint {

	static int[][] grid = { { 0, 5, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 0 },
			{ 0, 1, 2, 2, 1, 0 }, { 0, 1, 2, 2, 1, 0 }, { 0, 1, 1, 1, 1, 0 },
			{ 0, 0, 0, 6, 0, 0 } };

	static int colorToChange = -1;
	static int setColor = -1;

	/**
	 * Main method
	 * 
	 * @param args
	 *            none
	 */
	public static void main(String args[]) {
		print();

		// fill 7 from (0,3)
		fill(0, 3, 7);

		System.out.println("\nAfter Painting:\n");
		print();
	}

	/**
	 * Applies fill at the pixel (startX, startY) with color inputColor. Note: X
	 * is in the horizontal direction (step through columns of grid) and Y is in
	 * the vertical direction (step through rows of grid) with (0,0) at the left
	 * top corner
	 * 
	 * @param startX
	 *            X coordinate of the start pixel
	 * @param startY
	 *            Y coordinate of the start pixel
	 * @param inputColor
	 *            the color applied for the fill
	 */
	public static void fill(int startX, int startY, int inputColor) {

		int r = grid.length;
		if (r == 0)
			return;

		int c = grid[0].length;
		if (c == 0)
			return;

		// index of pixel to start from is outside the grid
		if (startX < 0 || startY < 0 || startX > c - 1 || startY > r - 1)
			return;

		// set the source color that has to be changed
		colorToChange = grid[startY][startX];
		// set the target color
		setColor = inputColor;

		// start recursive DFS
		visit(startY, startX);
	}

	/**
	 * Visit a particular pixel on the grid and paint it, visits adjacent pixels
	 * 
	 * @param i
	 *            Y coordinate of the pixel
	 * @param j
	 *            X coordinate of the pixel
	 */
	private static void visit(int i, int j) {

		int r = grid.length;
		int c = grid[0].length;

		grid[i][j] = setColor;
		if (i - 1 >= 0 && grid[i - 1][j] == colorToChange)
			visit(i - 1, j);
		if (i + 1 <= r - 1 && grid[i + 1][j] == colorToChange)
			visit(i + 1, j);
		if (j - 1 >= 0 && grid[i][j - 1] == colorToChange)
			visit(i, j - 1);
		if (j + 1 <= c - 1 && grid[i][j + 1] == colorToChange)
			visit(i, j + 1);
	}

	/**
	 * Prints the grid
	 */
	private static void print() {
		for (int i = 0; i < grid.length; i++)
			System.out.println(Arrays.toString(grid[i]));
	}
}
