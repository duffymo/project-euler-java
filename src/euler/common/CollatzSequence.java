package euler.common;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem14
 * <pre>
 * The following iterative sequence is defined for the set of positive integers:
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 40 20 10 5 16 8 4 2 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * Solution:
 * max size: 524
 * max start: 837799
 * (Using long instead of int was the key).
 * </pre>
 * User: MOD
 * Date: Nov 24, 2008
 * Time: 1:59:02 PM
 * @link http://projecteuler.net/index.php?section=problems&id=14
 */
public class CollatzSequence {
    private static final int MAX_START = 1000000;

    public static void main(String[] args) {
        int maxSize = Integer.MIN_VALUE;
        int maxStart = Integer.MIN_VALUE;
        List longestChain = Collections.EMPTY_LIST;
        Multimap<Integer, Integer> lengths = TreeMultimap.create();

        for (int i = 1; i < MAX_START; ++i) {
            List<Long> chain = CollatzSequence.collatz((long) i);
            lengths.put(chain.size() - 1, i);
            if (chain.size() - 1 > maxSize) {
                maxSize = chain.size() - 1;
                maxStart = i;
                longestChain = chain;
            }
        }

        for (Integer length : lengths.keySet()) {
            System.out.println("length=" + length + " # starts=" + lengths.get(length).size() + " starts=" + lengths.get(length));
        }

        System.out.println("max size: " + maxSize);
        System.out.println("max start: " + maxStart);
        System.out.println("max chain: " + longestChain);
    }

    public static List<Long> collatz(long n) {
        List<Long> chain = new ArrayList<Long>();

        long v = n;
        while (v > 1L) {
            chain.add(v);
            v = (((v % 2L) == 0) ? v / 2L : 3L * v + 1L);
        }

        chain.add(1L);

        return chain;
    }
}
