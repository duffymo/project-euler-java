package euler.upto20;

import static junit.framework.Assert.assertEquals;
import junit.framework.Assert;
import org.junit.Test;
import euler.upto20.Problem3;
import euler.TimedTest;

/**
 * EulerProblem3Test
 * User: MOD
 * Date: Oct 11, 2008
 * Time: 10:26:49 PM
 */
public class Problem3Test extends TimedTest
{

   @Test
   public void testMaxPrime_1()
   {
      Problem3 euler3 = new Problem3();

      long value = 13195L;
      long expected = 29L;

      Assert.assertEquals(expected, euler3.findMaxPrimeFactor(value));
   }

   @Test
   public void testMaxPrime_2()
   {
      Problem3 euler3 = new Problem3();

      long value = 600851475143L;
      long expected = 6857L; // correct answer; wall time: 62 msec

      Assert.assertEquals(expected, euler3.findMaxPrimeFactor(value));
   }

}
