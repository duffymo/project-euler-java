package euler.common;

import java.util.ArrayList;
import java.util.List;

/**
 * PrimeSequence
 * User: MOD
 * Date: Oct 11, 2008
 * Time: 5:15:30 PM
 */
public class PrimeSequence implements NumberSequence {
    private List<Long> primes;

    public PrimeSequence(long maxValue) {
        this.primes = calculate(maxValue);
    }

    /**
     * Calculate all primes less than N, using an implementation of the
     * Sieve of Eratosthenes by Robert Sedgewick.
     * @param maxValue all calculated primes are less than N
     * @return List of all primes less than N
     * @throws IllegalArgumentException if N is negative
     * @link http://www.cs.princeton.edu/introcs/14array/PrimeSieve.java.html
     */
    public List<Long> calculate(long maxValue) {
        if (maxValue < 0L) {
            throw new IllegalArgumentException("number of primes must be positive");
        }

        List<Long> primes = new ArrayList<Long>();

        // zero and one are not prime; two is prime
        boolean[] isPrime = new boolean[(int) (maxValue + 3)];
        isPrime[2] = true;

        // initially assume all odd integers are prime
        for (int i = 3; i <= maxValue; i += 2) {
            isPrime[i] = true;
        }

        // mark non-primes <= N using Sieve of Eratosthenes
        for (int i = 2; i * i <= maxValue; ++i) {
            // if i is prime, then mark multiples of i as nonprime
            // suffices to consider mutiples i, i+1, ..., N/i
            if (isPrime[i]) {
                for (int j = i; i * j <= maxValue; ++j) {
                    isPrime[i * j] = false;
                }
            }
        }

        // Now load all the primes into the List
        for (int i = 0; i < isPrime.length; ++i) {
            if (isPrime[i]) {
                primes.add((long) i);
            }
        }

        return primes;
    }

    public Long get(int index) {
        return this.primes.get(index);
    }

    public boolean isPrime(long n) {
        return this.primes.contains(n);
    }

    public int size() {
        return this.primes.size();
    }

    /**
     * Find the Least Common Multiple of two values
     * @param m 1st value
     * @param n 2nd value
     * @return least common multiple of m and n
     * @link http://en.wikipedia.org/wiki/Least_common_multiple
     */
    public long lcm(long m, long n) {
        return (m * n) / gcd(m, n);
    }

    /**
     * Find the Greatest Common Divisor
     * @param m 1st value
     * @param n 2nd value
     * @return greatest common divisor of the two values
     * @throws IllegalArgumentException if either of the parameters is negative
     * @link http://en.wikipedia.org/wiki/Euclidean_algorithm
     */
    public static long gcd(long m, long n) {
        if ((m < 0) || (n < 0)) {
            throw new IllegalArgumentException("arguments must be positive");
        }

        if (m == 0L) {
            return n;
        }

        if (n == 0L) {
            return m;
        }

        long t;
        while (n != 0) {
            t = n;
            n = m % n;
            m = t;
        }

        return m;
    }
}
