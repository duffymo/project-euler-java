package euler.upto20;

import euler.common.PrimeSequence;

/**
 * Problem10
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * User: MOD
 * Date: Oct 12, 2008
 * Time: 10:42:53 PM
 * @link http://projecteuler.net/index.php?section=problems&id=10
 */
public class Problem10 {
    public static void main(String[] args) {
        PrimeSequence sequence = new PrimeSequence(10000000L);
        int numPrimes = sequence.size();
        long maxPrime = sequence.get(numPrimes - 1);
        long maxTerm = 2000000L;

        System.out.println("# primes: " + numPrimes);
        System.out.println("max prime: " + maxPrime);

        long sum = 0L;
        for (int i = 0; i < numPrimes; ++i) {
            long term = sequence.get(i);
            if (term > maxTerm) {
                break;
            }

            sum += term;
        }

        System.out.println("sum: " + sum); // Correct answer = 142913828922.  Got it!

    }
}
