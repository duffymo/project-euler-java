package euler.common;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.math.BigInteger;

/**
 * FibonacciTest
 * User: MOD
 * Date: Nov 25, 2008
 * Time: 7:23:11 PM
 */
public class FibonacciTest
{
   @Test
   public void testFib()
   {
      // See http://www.research.att.com/~njas/sequences/A000045
      long [] expected =
      {
         0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,
         1597,2584,4181,6765,10946,17711,28657,46368,75025,
         121393,196418,317811,514229,832040,1346269,
         2178309,3524578,5702887,9227465,14930352,24157817,
         39088169,
      };

      for (int i = 1; i < expected.length; ++i)
      {
         BigInteger actual = Fibonacci.fib(i);
         System.out.println("i=" + i + " expected = " + expected[i] + " actual=" + actual);
         assertEquals("wrong value for i=" + i, expected[i], actual.longValue());
      }
   }
}
