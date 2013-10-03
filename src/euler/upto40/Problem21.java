package euler.upto40;

import euler.common.Amicable;
import euler.common.DivisorSequence;

import java.util.*;

/**
 * Problem21
 * <pre>
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * Evaluate the sum of all the amicable numbers under 10000.
 * </pre>
 * [{a=220, b=284}, {a=1184, b=1210}, {a=2620, b=2924}, {a=5020, b=5564}, {a=6232, b=6368}]
 * sum=31626
 * User: MOD
 * Date: Nov 25, 2008
 * Time: 1:34:44 PM
 * @link http://projecteuler.net/index.php?section=problems&id=21
 */
public class Problem21 {
    private static final long MAX_RANGE = 10000L;

    public static void main(String[] args) {
        DivisorSequence divisorSequence = new DivisorSequence();
        Map<Long, List<Long>> divisorsMap = new TreeMap<Long, List<Long>>();
        Map<Long, Long> sigmaMap = new TreeMap<Long, Long>();
        for (long i = 1; i < MAX_RANGE; ++i) {
            divisorsMap.put(i, divisorSequence.calculate(i, true));
            sigmaMap.put(i, divisorSequence.sigmaOne(i, true));
        }

        System.out.println("divisors map=" + divisorsMap);
        System.out.println("sigma map=" + sigmaMap);
        Set<Amicable> amicables = new TreeSet<Amicable>();
        for (Long a : sigmaMap.keySet()) {
            Long b = sigmaMap.get(a);
            if (!a.equals(b) && sigmaMap.keySet().contains(b) && (sigmaMap.get(b).equals(a))) {
                Amicable amicable = new Amicable(a, b);
                Amicable symmetry = new Amicable(b, a);
                if (!amicables.contains(symmetry)) {
                    amicables.add(amicable);
                }
            }
        }

        System.out.println(amicables);
        long sum = 0L;
        for (Amicable amicable : amicables) {
            sum += amicable.getA();
            sum += amicable.getB();
        }

        System.out.println("sum=" + sum);
    }
}

