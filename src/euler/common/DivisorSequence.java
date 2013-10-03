package euler.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DivisorSequence
 * User: MOD
 * Date: Nov 25, 2008
 * Time: 9:02:54 AM
 */
public class DivisorSequence implements NumberSequence {
    public long sigmaOne(long n) {
        return sigmaOne(n, false);
    }

    public List<Long> calculate(long n) {
        return calculate(n, false);
    }

    public long sigmaOne(long n, boolean excludeSelf) {
        List<Long> divisors = this.calculate(n, excludeSelf);

        long sigma1 = 0;

        int numDivisors = divisors.size();
        for (int i = 0; i < numDivisors; ++i) {
            sigma1 += divisors.get(i);
        }

        return sigma1;
    }


    public boolean isDeficient(long n) {
        return (n < this.sigmaOne(n, true));
    }

    public boolean isAbundant(long n) {
        return (n > this.sigmaOne(n, true));
    }

    public boolean isPerfect(long n) {
        return (n == this.sigmaOne(n, true));
    }

    public List<Long> calculate(long n, boolean excludeSelf) {
        if (n <= 0) {
            throw new IllegalArgumentException("input must be positive");
        }

        List<Long> divisors = new ArrayList<Long>();


        long candidate = 2;
        while (candidate <= (long) (Math.sqrt(n))) {
            if ((n % candidate) == 0) {
                divisors.add(candidate);
            }

            ++candidate;
        }

        divisors.add(1L);
        Collections.sort(divisors);

        int numDivisors = divisors.size();
        int minIndex = (excludeSelf ? 1 : 0);
        for (int i = minIndex; i < numDivisors; ++i) {
            long pair = n / divisors.get(i);
            if (!divisors.contains(pair)) {
                divisors.add(pair);
            }
        }

        Collections.sort(divisors);

        return divisors;
    }
}
