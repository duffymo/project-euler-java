package euler.upto20;

/**
 * Problem6
 * <pre>
 * The sum of the squares of the first ten natural numbers is,
 * 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 * </pre>
 * User: MOD
 * Date: Oct 13, 2008
 * Time: 7:22:45 PM
 * @link http://projecteuler.net/index.php?section=problems&id=6
 */
public class Problem6 {
    public static long sumOfSquares(int n) {
        long sumOfSquares = 0L;

        for (int i = 1; i <= n; ++i) {
            sumOfSquares += i * i;
        }

        return sumOfSquares;
    }

    public static long squareOfSum(int n) {
        long sum = 0L;

        for (int i = 1; i <= n; ++i) {
            sum += i;
        }

        return sum * sum;
    }

    public static long diff(int n) {
        long diff = 0L;

        for (int i = 1; i <= n; ++i) {
            for (int j = (i + 1); j <= n; ++j) {
                diff += i * j;
            }
        }

        return 2L * diff;
    }
}
