package euler.common;

/**
 * Matrix
 * User: MOD
 * Date: Oct 16, 2008
 * Time: 9:22:49 PM
 */
public interface Matrix {
    int getNumRows();

    int getNumCols();

    double get(int row, int col);

    void set(int row, int col, double value);
}
