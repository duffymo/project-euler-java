package euler.upto20;

import java.math.BigInteger;

/**
 * Problem20
 * <pre>
 * n! means n  (n  1)  ...  3  2  1
 * Find the sum of the digits in the number 100!
 * Solution:
 * factorial = 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
 * length = 158
 * sum = 648
 * </pre>
 * User: MOD
 * Date: Oct 13, 2008
 * Time: 9:39:31 PM
 * link http://projecteuler.net/index.php?section=problems&id=20
 */
public class Problem20 {
    public static void main(String[] args) {
        String f = factorial(100).toString();
        System.out.println("factorial = " + f);
        System.out.println("length = " + f.length());
        System.out.println("sum = " + sumOfDigits(f));
    }

    public static long sumOfDigits(String f) {
        long sum = 0L;
        for (int i = 0; i < f.length(); ++i) {
            int digit = Character.digit(f.charAt(i), 10);
            sum += digit;
        }
        return sum;
    }


    public static BigInteger factorial(int n) {
        BigInteger f = new BigInteger("1");

        for (int i = 1; i <= n; ++i) {
            f = f.multiply(new BigInteger(Integer.toString(i)));
        }

        return f;
    }
}
