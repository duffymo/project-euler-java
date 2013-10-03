package euler.upto40;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Problem26
 * <pre>
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with
 * denominators 2 to 10 are given:
 * <p/>
 *   1/2	= 	0.5
 *   1/3	= 	0.(3)
 *   1/4	= 	0.25
 *   1/5	= 	0.2
 *   1/6	= 	0.1(6)
 *   1/7	= 	0.(142857)
 *   1/8	= 	0.125
 *   1/9	= 	0.(1)
 *   1/10	= 	0.1
 * <p/>
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
 * <p/>
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 * </pre>
 * <code>
 * 983 has a cycle that's 982 digits long
 * </code>
 * User: MOD
 * Date: Nov 26, 2008
 * Time: 2:17:47 PM
 * @link http://projecteuler.net/index.php?section=problems&id=26
 * @link http://xorlogic.blogspot.com/2007_09_01_archive.html
 * @link http://blog.csdn.net/No_End_Point/archive/2008/08/26/2835285.aspx
 */
public class Problem26 {
    private static final int DEFAULT_SCALE = 2000;

    public static void main(String[] args) {
        long begTime = System.currentTimeMillis();
        for (long d = 2; d < 1000; ++d) {
            MathContext context = new MathContext(DEFAULT_SCALE, RoundingMode.HALF_EVEN);
            BigDecimal fraction = BigDecimal.ONE.divide(new BigDecimal(d), context);
            System.out.println("d=" + d + " fraction=" + fraction.toString());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("wall time=" + (endTime - begTime) + " msec");
    }

    public String findRepeat(String d) {
        StringBuilder repeat = new StringBuilder(DEFAULT_SCALE);

        int numChars = d.length();
        for (int i = 0; i < numChars; ++i) {
            char c = d.charAt(i);
            if (d.indexOf(c) != -1) {
                repeat.append(c);
            }
        }

        return repeat.toString();
    }
}
