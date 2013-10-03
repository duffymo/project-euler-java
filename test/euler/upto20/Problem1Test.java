package euler.upto20;

import static junit.framework.Assert.assertEquals;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import euler.upto20.Problem1;
import euler.TimedTest;

/**
 * EulerProblem1Test
 * User: MOD
 * Date: Oct 11, 2008
 * Time: 10:51:09 PM
 */
public class Problem1Test extends TimedTest
{
   @Test
   public void testSumOfAllMultiplesBelowMaxValue()
   {
      int maxValue = 1000;
      List<Integer> multiples = new ArrayList<Integer>(2);
      multiples.add(3);
      multiples.add(5);

      Problem1 euler1 = new Problem1(maxValue, multiples);
      Set<Integer> values = euler1.getValues();
      LOGGER.info("values: " + values);
      int expected = 233168; // correct answer

      Assert.assertEquals(expected, euler1.sum(values));
   }
}
