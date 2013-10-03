package euler.upto40;

import euler.common.PermutationGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem24
 * <pre>
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the
 * digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it
 * lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 * 012   021   102   120   201   210
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * </pre>
 * <code>
 * millionth lexicographic permutation=2783915460
 * wall time=5672 msecs
 * </code>
 * User: MOD
 * Date: Nov 26, 2008
 * Time: 1:54:06 PM
 * @link http://projecteuler.net/index.php?section=problems&id=24
 */
public class Problem24 {
    private static final int DEFAULT_SIZE = 10;
    private static final int MILLIONTH_INDEX = 1000000 - 1;
    private static final int INITIAL_CAPACITY = 3628800;

    public static void main(String[] args) {
        long begTime = System.currentTimeMillis();
        // There will be 10! = 3,628,800 for [0..9]
        List<String> permutations = new ArrayList<String>(INITIAL_CAPACITY);

        PermutationGenerator generator = new PermutationGenerator(DEFAULT_SIZE);

        while (generator.hasMore()) {
            int[] p = generator.getNext();
            StringBuilder builder = new StringBuilder(DEFAULT_SIZE);
            for (int i = 0; i < p.length; i++) {
                int aP = p[i];
                builder.append(aP);
            }
            permutations.add(builder.toString());
        }

        Collections.sort(permutations);

        System.out.println("millionth lexicographic permutation=" + permutations.get(MILLIONTH_INDEX));
        long endTime = System.currentTimeMillis();
        System.out.println("wall time=" + (endTime - begTime) + " msecs");
    }
}
