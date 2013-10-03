package euler.upto20;

import euler.common.PrimeSequence;

/**
 * EulerProblem3
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * User: MOD
 * Date: Oct 11, 2008
 * Time: 3:37:04 PM
 * @link http://projecteuler.net/index.php?section=problems&id=3
 * @link http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 */
public class Problem3 {
    /**
     * Find the maximum prime factor of a number.  This algorithm depends
     * @param n from which we desire max prime factor
     * @return max prime factor
     */
    public long findMaxPrimeFactor(long n) {
        long maxPrimeFactor = 0L;

        // TODO: Think about this one.  It's costly in memory for recursion.
        PrimeSequence sequence = new PrimeSequence((long) Math.sqrt(n));

        int numPrimes = sequence.size();
        // work backwards - why not?
        for (int i = 0; i < numPrimes; ++i) {
            long prime = sequence.get(numPrimes - i - 1);
            if ((n % prime) == 0L) {
                maxPrimeFactor = prime;
                break;
            }
        }

        return maxPrimeFactor;
    }
}
