package euler.upto20;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Problem18
 * <pre>
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 * <p/>
 * 3
 * 7 5
 * 2 4 6
 * 8 5 9 3
 * <p/>
 * That is, 3 + 7 + 4 + 9 = 23.
 * <p/>
 * Find the maximum total from top to bottom of the triangle below:
 * <p/>
 * 75
 * 95 64
 * 17 47 82
 * 18 35 87 10
 * 20 04 82 47 65
 * 19 01 23 75 03 34
 * 88 02 77 73 07 63 67
 * 99 65 04 28 06 16 70 92
 * 41 41 26 56 83 40 80 70 33
 * 41 48 72 33 47 32 37 16 94 29
 * 53 71 44 65 25 43 91 52 97 51 14
 * 70 11 33 28 77 73 17 78 39 68 17 57
 * 91 71 52 38 17 14 91 43 58 50 27 29 48
 * 63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 * <p/>
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
 * <p/>
 * </pre>
 * <code>
 * max total=1074
 * (My hand solution from yesterday was 1064.  Did I simply make a calculator error?
 * NO, got the same result.  Your first "strategy" was wrong.)
 * </code>
 * User: MOD
 * Date: Nov 28, 2008
 * Time: 10:26:03 AM
 * @link http://projecteuler.net/index.php?section=problems&id=18
 */
public class Problem18 {
    private static final Log LOGGER = LogFactory.getLog(Problem18.class);
    private static final int INITIAL_SIZE = 1024;

    public static void main(String[] args) {
        long[][] triangle = new long[15][];
        triangle[0] = new long[]{75};
        triangle[1] = new long[]{95, 64};
        triangle[2] = new long[]{17, 47, 82};
        triangle[3] = new long[]{18, 35, 87, 10};
        triangle[4] = new long[]{20, 4, 82, 47, 65};
        triangle[5] = new long[]{19, 1, 23, 75, 3, 34};
        triangle[6] = new long[]{88, 2, 77, 73, 7, 63, 67};
        triangle[7] = new long[]{99, 65, 4, 28, 6, 16, 70, 92};
        triangle[8] = new long[]{41, 41, 26, 56, 83, 40, 80, 70, 33};
        triangle[9] = new long[]{41, 48, 72, 33, 47, 32, 37, 16, 94, 29};
        triangle[10] = new long[]{53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14};
        triangle[11] = new long[]{70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57};
        triangle[12] = new long[]{91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48};
        triangle[13] = new long[]{63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31};
        triangle[14] = new long[]{4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23};

        System.out.println("max total=" + maxTotalFromTriangle(triangle));
    }

    // http://coding-experiments.blogspot.com/2008/04/project-euler-problem-18.html
    public static long maxTotalFromTriangle(long[][] triangle) {
        long max = 0;

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
// Accumulating maximum total
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == triangle[i].length - 1) {
                    triangle[i][j] += triangle[i - 1][triangle[i - 1].length - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
                }
// Finding maximum from last row
                if (i == triangle.length - 1) {
                    if (triangle[i][j] > max) {
                        max = triangle[i][j];
                    }
                }
            }

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("row " + i);
                for (int m = 0; m < triangle.length; ++m) {
                    StringWriter sw = new StringWriter(INITIAL_SIZE);
                    PrintWriter pw = new PrintWriter(sw);
                    for (int n = 0; n < triangle[m].length; ++n) {
                        pw.format("%5d", triangle[m][n]);
                    }
                    LOGGER.debug(sw.toString());
                }
                LOGGER.debug(" ");
            }
        }
        return max;
    }
}
