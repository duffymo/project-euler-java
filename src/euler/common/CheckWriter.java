package euler.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem17
 * <pre>
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains
 * 20 letters. The use of "and" when writing out numbers is in compliance
 * with British usage.
 * </pre>
 * User: MOD
 * Date: Oct 19, 2008
 * Time: 6:03:01 PM
 * @link http://projecteuler.net/index.php?section=problems&id=17
 */
public class CheckWriter {
    private static final int DEFAULT_CAPACITY = 512;

    private Map<Long, String> words;
    private Map<Long, String> powers;

    public CheckWriter() {
        this.words = new HashMap<Long, String>();

        this.words.put(0L, "");
        this.words.put(1L, "one");
        this.words.put(2L, "two");
        this.words.put(3L, "three");
        this.words.put(4L, "four");
        this.words.put(5L, "five");
        this.words.put(6L, "six");
        this.words.put(7L, "seven");
        this.words.put(8L, "eight");
        this.words.put(9L, "nine");
        this.words.put(10L, "ten");
        this.words.put(11L, "eleven");
        this.words.put(12L, "twelve");
        this.words.put(13L, "thirteen");
        this.words.put(14L, "fourteen");
        this.words.put(15L, "fifteen");
        this.words.put(16L, "sixteen");
        this.words.put(17L, "seventeen");
        this.words.put(18L, "eighteen");
        this.words.put(19L, "nineteen");
        this.words.put(20L, "twenty");
        this.words.put(30L, "thirty");
        this.words.put(40L, "forty");
        this.words.put(50L, "fifty");
        this.words.put(60L, "sixty");
        this.words.put(70L, "seventy");
        this.words.put(80L, "eighty");
        this.words.put(90L, "ninety");
        this.words.put(100L, "hundred");
        this.words.put(1000L, "thousand");

        // http://www.unc.edu/~rowlett/units/large.html
        this.powers = new HashMap<Long, String>();

        this.powers.put(0L, "one");
        this.powers.put(1L, "ten");
        this.powers.put(2L, "hundred");
        this.powers.put(3L, "thousand");
        this.powers.put(6L, "million");
        this.powers.put(9L, "billion");
        this.powers.put(12L, "trillion");
        this.powers.put(15L, "quadrillion");
    }

    public String asWords(long n) {
        return this.asWords(n, false);
    }

    public String asWords(long n, boolean isBritish) {
        StringBuilder builder = new StringBuilder(DEFAULT_CAPACITY);

        if (n < 0L)
            throw new IllegalArgumentException("input must be one or greater");

        if (n <= 20L) {
            builder.append(this.words.get(n));
        } else if (n < 100L) {
            long tens = n / 10 * 10;
            long ones = n % tens;

            builder.append(this.words.get(tens)).append(' ').append(this.words.get(ones));
        } else if (n < 1000L) {
            long hundreds = n / 100L;
            builder.append(this.words.get(hundreds)).append(" hundred");

            long tens = n - 100L * hundreds;

            if (tens != 0L) {
                if (isBritish) {
                    builder.append(" and");
                }
                builder.append(' ').append(asWords(tens));
            }
        } else {
            long logn = (long) Math.log10(n);
            logn -= logn % 3;
            String power = this.powers.get(logn);

            if (power == null)
                throw new IllegalArgumentException("no name found for log10(n)=" + logn);

            long d = (long) Math.pow(10L, logn);
            long u = n / d;
            long r = n - d * u;

            builder.append(this.asWords(u)).append(' ').append(power).append(' ');

            builder.append(asWords(r));
        }

        return builder.toString().trim();
    }
}
