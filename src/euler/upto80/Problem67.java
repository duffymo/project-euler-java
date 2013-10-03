package euler.upto80;

import euler.upto20.Problem18;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem67
 * <pre>
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 * 3
 * 7 5
 * 2 4 6
 * 8 5 9 3
 * That is, 3 + 7 + 4 + 9 = 23.
 * Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text
 * file containing a triangle with one-hundred rows.
 * NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this
 * problem, as there are 299 altogether! If you could check one trillion (1012) routes every second it would take over
 * twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
 * </pre>
 * <code>
 * max total=7273
 * </code>
 * User: MOD
 * Date: Nov 28, 2008
 * Time: 11:40:04 AM
 * @link http://projecteuler.net/index.php?section=problems&id=67
 */
public class Problem67 {
    private static final String DATA_PATH = "data/triangle.txt";

    public static void main(String[] args) {
        InputStream is;

        try {
            is = new FileInputStream(DATA_PATH);

            long[][] triangle = readTriangle(is);

            System.out.println("max total=" + Problem18.maxTotalFromTriangle(triangle));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long[][] readTriangle(InputStream is) throws IOException {
        long[][] triangle = null;

        List<long[]> rows = new ArrayList<long[]>();

        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                long[] temp = new long[tokens.length];
                for (int i = 0; i < temp.length; ++i) {
                    temp[i] = Long.parseLong(tokens[i]);
                }
                rows.add(temp);
            }

            int numRows = rows.size();
            triangle = new long[numRows][];
            for (int i = 0; i < numRows; ++i) {
                long[] data = rows.get(i);
                triangle[i] = new long[data.length];
                System.arraycopy(data, 0, triangle[i], 0, triangle[i].length);
            }
        } finally {
            try {
                if (br != null) br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return triangle;
    }


}
