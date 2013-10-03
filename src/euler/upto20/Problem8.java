package euler.upto20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem8
 * <pre>
 * Find the greatest product of five consecutive digits in the 1000-digit number.
 * </pre>
 * <pre>
 * max product: 40824
 * index      : 364
 * group      : 99879
 * wall time  : 16 msec
 * </pre>
 * User: MOD
 * Date: Oct 15, 2008
 * Time: 10:18:24 PM
 * @link http://projecteuler.net/index.php?section=problems&id=8
 */
public class Problem8 {
    private static final String DEFAULT_PATH = "data/Problem8.in";
    private static final int DEFAULT_CAPACITY = 1024;
    private static final int DEFAULT_GROUP = 5;

    public static void main(String[] args) {
        long begTime = System.currentTimeMillis();
        long endTime = 0L;

        try {
            // read in the number from the input file
            String number = read(DEFAULT_PATH);
            // loop over groups of five and keep track of the max product
            // min possible product is zero; max possible product is 9^5 = 59049
            int maxProduct = Integer.MIN_VALUE;
            int index = 0;
            for (int i = 0; i < (number.length() - DEFAULT_GROUP); ++i) {
                int product = calculateProduct(number.substring(i, (i + DEFAULT_GROUP)));
                if (product > maxProduct) {
                    maxProduct = product;
                    index = i;
                }
            }

            System.out.println("max product: " + maxProduct);
            System.out.println("index      : " + index);
            System.out.println("group      : " + number.substring(index, (index + DEFAULT_GROUP)));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            endTime = System.currentTimeMillis();
            System.out.println("wall time: " + (endTime - begTime) + " msec");
        }
    }

    private static int calculateProduct(String s) {
        if (s.contains("0"))
            return 0;

        int product = 1;
        for (int i = 0; i < s.length(); ++i) {
            int digit = Character.digit(s.charAt(i), 10);
            product *= digit;
        }

        return product;
    }

    private static String read(String path) throws IOException {
        StringBuffer buffer = new StringBuffer(DEFAULT_CAPACITY);

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return buffer.toString();
    }
}
