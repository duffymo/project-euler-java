package euler.upto20;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * EulerProblem4
 * <pre>
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91*99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * </pre>
 * User: MOD
 * Date: Oct 12, 2008
 * Time: 11:08:03 AM
 * @link http://projecteuler.net/index.php?section=problems&id=4
 */
public class Problem4 {
    public static final Log LOGGER = LogFactory.getLog(Problem4.class);

    public static void main(String[] args) {
        Problem4 euler4 = new Problem4();

        for (int i = 0; i < args.length; ++i) {
            int digits = Integer.valueOf(args[i]);

            System.out.println("palindrome: " + euler4.findLongestPalindrome(digits));
        }
    }

    public boolean isPalindrome(String s) {
        return isPalindrome(s, true);
    }

    /**
     * Return true if the given String is a palindrome, after
     * removing all whitespace and punctuation and converting to all lower case.
     * @param s      String to check for palindrome
     * @param remove true if whitespace and punctuation should be removed before check.
     * @return true if the given String is a palindrome; false otherwise.
     */
    public boolean isPalindrome(String s, boolean remove) {
        if (StringUtils.isBlank(s))
            return false;

        s = s.toLowerCase();

        if (remove) {
            s = s.replaceAll("\\s+", "");
            s = s.replaceAll("\\p{Punct}", "");
        }

        StringBuilder backwards = new StringBuilder(s);

        return (s.equals(backwards.reverse().toString()));
    }

    public String findLongestPalindrome(int digits) {
        String palindrome = "";
        int maxValue = Integer.MIN_VALUE;
        int imax = Integer.MIN_VALUE;
        int jmax = Integer.MIN_VALUE;

        int number = (int) Math.pow(10.0, digits) - 1;

        for (int i = number; i >= 0; --i) {
            for (int j = i; j >= 0; --j) {
                palindrome = Integer.toString(i * j);

                if (this.isPalindrome(palindrome) && (i * j > maxValue)) {
                    imax = i;
                    jmax = j;
                    maxValue = i * j;
                }
            }
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("imax = " + imax);
            LOGGER.debug("jmax = " + jmax);
        }

        return Integer.toString(maxValue);
    }
}
