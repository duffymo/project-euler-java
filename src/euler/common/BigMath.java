package euler.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * BigMath
 * User: MOD
 * Date: Nov 25, 2008
 * Time: 6:14:51 PM
 */
public class BigMath {
    private static final Log LOGGER = LogFactory.getLog(BigMath.class);

    public static final BigDecimal TWO = new BigDecimal("2");

    public static final BigDecimal DEFAULT_ERROR = new BigDecimal(1.0e-3);
    public static final int DEFAULT_SCALE = 10;
    public static final int DEFAULT_MAX_ITERATIONS = 50;

    private static BigDecimal getInitialApproximation(BigDecimal n) {
        BigInteger integerPart = n.toBigInteger();
        int length = integerPart.toString().length();
        if ((length % 2) == 0) {
            --length;
        }

        length /= 2;

        return BigDecimal.ONE.movePointRight(length);
    }


    /**
     * Calculate square root of a BigDecimal using Newton-Raphson iteration
     * @param x value to take square root of
     * @return square root of x.
     */
    public static BigDecimal sqrt(BigDecimal x) {
        return sqrt(x, DEFAULT_ERROR, DEFAULT_SCALE, DEFAULT_MAX_ITERATIONS);
    }

    /**
     * Calculate square root of a BigDecimal using Newton-Raphson iteration
     * @param x             value to take square root of
     * @param error         tolerance for stopping iteration
     * @param scale         for initial guess
     * @param maxIterations for convergence
     * @return square root of x.
     * @link http://www.merriampark.com/bigsqrt.htm
     */
    public static BigDecimal sqrt(BigDecimal x, BigDecimal error, int scale, int maxIterations) {
        if (x.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("input must be positive");

        if (error.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("error must be positive");

        if (scale <= 0)
            throw new IllegalArgumentException("scale must be positive");

        if (maxIterations <= 0)
            throw new IllegalArgumentException("maxIterations must be positive");


        BigDecimal initialGuess = getInitialApproximation(x);
        LOGGER.debug("Old guess=" + initialGuess.toString());
        BigDecimal lastGuess;
        BigDecimal guess = new BigDecimal(initialGuess.toString());

        int iterations = 0;
        boolean more = true;
        while (more) {
            lastGuess = guess;
            guess = x.divide(guess, scale, BigDecimal.ROUND_HALF_UP);
            guess = guess.add(lastGuess);
            guess = guess.divide(TWO, scale, BigDecimal.ROUND_HALF_UP);
            LOGGER.debug("New guess=" + guess.toString());
            error = x.subtract(guess.multiply(guess));
            if (++iterations >= maxIterations) {
                more = false;
            } else if (lastGuess.equals(guess)) {
                more = error.abs().compareTo(BigDecimal.ONE) >= 0;
            }
        }

        LOGGER.debug("# iterations=" + iterations);

        return guess;
    }
}
