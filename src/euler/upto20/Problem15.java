package euler.upto20;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Problem15
 * <pre>
 * Starting in the top left corner of a 22 grid, there are 6 routes (without backtracking)
 * to the bottom right corner.  How many routes are there through a 2020 grid?
 * </pre>
 * <code>
 * </code>
 * User: MOD
 * Date: Nov 28, 2008
 * Time: 12:33:31 PM
 * @link http://projecteuler.net/index.php?section=problems&id=15
 */
public class Problem15 {
    private static final Log LOGGER = LogFactory.getLog(Problem15.class);
    private static final int INITIAL_SIZE = 1024;

    public static void main(String[] args) {
        int size = ((args.length > 0) ? Integer.parseInt(args[0]) : 2);

        int[][] grid = createGrid(size);

        if (LOGGER.isDebugEnabled()) {
            for (int m = 0; m < grid.length; ++m) {
                StringWriter sw = new StringWriter(INITIAL_SIZE);
                PrintWriter pw = new PrintWriter(sw);
                for (int n = 0; n < grid[m].length; ++n) {
                    pw.format("%5d", grid[m][n]);
                }
                LOGGER.debug(sw.toString());
            }
            LOGGER.debug(" ");
        }

    }

    public static int[][] createGrid(int n) {
        int[][] grid = new int[n][];

        for (int i = 0; i < grid.length; ++i) {
            grid[i] = new int[n];
            for (int j = 0; j < grid[i].length; ++j) {
                grid[i][j] = j + i * n + 1;
            }
        }

        return grid;
    }
}
