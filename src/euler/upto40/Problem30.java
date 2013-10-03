package euler.upto40;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem30
 * <pre>
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 *   1634 = 14 + 64 + 34 + 44
 *   8208 = 84 + 24 + 04 + 84
 *   9474 = 94 + 44 + 74 + 44
 * As 1 = 1^4 is not a sum it is not included.
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 * </pre>
 * <code>
 * values=[4150, 4151, 54748, 92727, 93084, 194979]
 * wall time=16656813 msec
 * </code>
 * User: MOD
 * Date: Nov 26, 2008
 * Time: 7:29:09 PM
 * @link http://projecteuler.net/index.php?section=problems&id=30
 */
public class Problem30 {
    private static final int MAX_RANGE = Integer.MAX_VALUE;
    private static final int POWER = 5;

    public static void main(String[] args) {
        long begTime = System.currentTimeMillis();

        List<Integer> equalToSumOfDigitsToPower = new ArrayList<Integer>();
        for (int i = 2; i < MAX_RANGE; ++i) {
            if (isEqualToSumOfDigitsToPower(i, POWER)) {
                equalToSumOfDigitsToPower.add(i);
            }

            if ((i % 1000000) == 0) {
                System.out.println(i + "...");
            }
        }

        System.out.println("values=" + equalToSumOfDigitsToPower);
        long endTime = System.currentTimeMillis();
        System.out.println("wall time=" + (endTime - begTime) + " msec");
    }

    public static boolean isEqualToSumOfDigitsToPower(int v, int n) {
        String str = Integer.toString(v);
        double sum = 0.0;
        int numDigits = str.length();
        int x = v;
        for (int i = 0; i < str.length(); ++i) {
            int mask = (int) Math.pow(10, (numDigits - i - 1));
            int d = x / mask;
            sum += Math.pow(d, n);
            x -= d * mask;
        }

        return ((int) sum == v);
    }
}
