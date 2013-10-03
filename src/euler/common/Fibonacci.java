package euler.common;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Fibonacci
 * User: Michael
 * Date: Oct 11, 2008
 * Time: 2:03:28 PM
 */
public class Fibonacci {
    private static final int MAX_LENGTH = 2;
    private static final BigDecimal SQRT_FIVE = new BigDecimal(Math.sqrt(5.0));
    private static final BigDecimal POSITIVE = BigDecimal.ONE.add(SQRT_FIVE).divide(BigMath.TWO);
    private static final BigDecimal NEGATIVE = BigDecimal.ONE.subtract(SQRT_FIVE).divide(BigMath.TWO);

    private int index;
    private FixedLengthFifo<Long> fifo;
    private static final int DEFAULT_NUM_TERMS = 15;

    public static void main(String[] args) {
        long begTime = System.currentTimeMillis();
        long endTime;

        try {
            int numTerms = ((args.length > 0) ? Integer.valueOf(args[0]) : DEFAULT_NUM_TERMS);
            Fibonacci f = new Fibonacci();
            List<Long> sequence = new ArrayList<Long>(numTerms);
            List<Long> evenTerms = new ArrayList<Long>();
            for (int i = 0; i < numTerms; ++i) {
                long next = f.getNext(i);
                sequence.add(next);
                if ((next % 2) == 0) {
                    evenTerms.add(next);
                }
            }

            System.out.println("sequence: " + sequence);
            System.out.println("even terms: " + evenTerms);
        } finally {
            endTime = System.currentTimeMillis();
            System.out.println("wall time: " + (double) (endTime - begTime) / 1000 + " sec");
        }
    }

    public Fibonacci() {
        this.index = 0;
        this.fifo = new FixedLengthFifo<Long>(MAX_LENGTH);

    }

    /**
     * Calculate the nth Fibonnaci number using Binet's formula
     * @param n term of the sequence
     * @return Fib(n)
     * @link http://www.mcs.surrey.ac.uk/Personal/R.Knott/Fibonacci/fibFormula.html#formula
     */
    public static BigInteger fib(int n) {
        return POSITIVE.pow(n)
                .subtract(NEGATIVE.pow(n))
                .divide(SQRT_FIVE)
                .toBigInteger();
    }

    public synchronized long getNext(int n) {
        long next;

        if (n < 0)
            throw new IllegalArgumentException("index must be positive");

        if (n != index)
            throw new IllegalArgumentException("index must increase monotonically");

        if (n == 0) {
            next = 0L;
        } else if (n == 1) {
            next = 1L;
        } else {
            next = this.fifo.get(0) + this.fifo.get(1);
        }

        this.fifo.add(next);
        ++this.index;

        return next;
    }
}
