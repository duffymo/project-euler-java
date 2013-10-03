package euler.upto20;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * EulerProblem1
 * <pre>
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9.  The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * </pre>
 * @author MOD
 * @link http://projecteuler.net/index.php?section=problems&id=1
 * @since Oct 10, 2008 9:15:50 AM
 */
public class Problem1 {
    private int maxValue;
    private List<Integer> multiples;


    public static void main(String[] args) {
        long begTime = System.currentTimeMillis();
        long endTime;

        try {
            int maxValue = ((args.length > 0) ? Integer.parseInt(args[0]) : 0);
            List<Integer> multiples = new ArrayList<Integer>();
            if (args.length > 1) {
                for (int i = 1; i < args.length; ++i) {
                    multiples.add(Integer.parseInt(args[i]));
                }
            }
            Problem1 euler1 = new Problem1(maxValue, multiples);
            Set<Integer> values = euler1.getValues();
            System.out.println("max: " + maxValue);
            System.out.println("multiples: " + multiples);
            System.out.println(values.size() + " values: " + values);
            System.out.println("sum: " + euler1.sum(values));
        } finally {
            endTime = System.currentTimeMillis();
            System.out.println("wall time: " + (double) (endTime - begTime) / 1000 + " sec");
        }
    }

    public Problem1(int maxValue, List<Integer> multiples) {
        if (maxValue < 0)
            throw new IllegalArgumentException("max value must be positive");

        this.maxValue = maxValue;
        this.multiples = new ArrayList<Integer>(multiples);
    }

    public Set<Integer> getValues() {
        Set<Integer> values = new TreeSet<Integer>();

        for (int i = 0; i < this.maxValue; ++i) {
            for (Integer multiple : this.multiples) {
                if ((i % multiple) == 0) {
                    values.add(i);
                }
            }
        }

        return values;
    }

    public int sum(Set<Integer> values) {
        int sum = 0;

        for (Integer value : values) {
            sum += value;
        }

        return sum;
    }
}
