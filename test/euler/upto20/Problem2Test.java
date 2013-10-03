package euler.upto20;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import euler.upto20.Problem2;
import euler.TimedTest;

/**
 * EulerProblem2Test
 * User: MOD
 * Date: Oct 11, 2008
 * Time: 11:03:35 PM
 */
public class Problem2Test extends TimedTest
{
   @Test
   public void testFibonnaciSum()
   {
      Problem2 euler2 = new Problem2();

      long maxTerm = 4000000L;
      long divisor = 2L;
      long expected = 4613732L;

      Assert.assertEquals(expected, euler2.calcFibonacciSum(maxTerm, divisor));


   }
}
