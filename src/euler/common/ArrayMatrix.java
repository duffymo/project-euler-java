package euler.common;

/**
 * ArrayMatrix
 * User: MOD
 * Date: Oct 16, 2008
 * Time: 9:24:00 PM
 */
public class ArrayMatrix implements Matrix {
    private double[][] values;

    public ArrayMatrix(int numRows, int numCols) {
        if (numRows <= 2)
            throw new IllegalArgumentException("number of rows must be greater than one");

        if (numCols <= 2)
            throw new IllegalArgumentException("number of cols must be greater than one");

        this.values = new double[numRows][numCols];

        for (int i = 0; i < numRows; ++i) {
            this.values[i] = new double[numCols];
        }
    }

    public int getNumRows() {
        return this.values.length;
    }

    public int getNumCols() {
        return this.values[0].length;
    }

    public double get(int row, int col) {
        return this.values[row][col];
    }

    public void set(int row, int col, double value) {
        this.values[row][col] = value;
    }
}
