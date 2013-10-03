package euler.upto20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

/**
 * Problem13
 * <pre>
 * Work out the first ten digits of the sum of the following
 * one-hundred 50-digit numbers.  (See Problem13.in).
 * sum: 5537376230390876637302048746832985971773659831892672
 * </pre>
 * User: MOD
 * Date: Oct 19, 2008
 * Time: 5:49:11 PM
 * @link http://projecteuler.net/index.php?section=problems&id=13
 */
public class Problem13 {
    public static final String DEFAULT_PATH = "data/Problem13.in";

    public static void main(String[] args) {
        BigInteger sum = new BigInteger("0");

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(DEFAULT_PATH));
            String line;
            while ((line = br.readLine()) != null) {
                BigInteger x = new BigInteger(line);
                sum = sum.add(x);
            }

            System.out.println("sum: " + sum);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

