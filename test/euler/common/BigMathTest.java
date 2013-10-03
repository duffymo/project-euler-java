package euler.common;

import euler.TimedTest;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * BigMathTest
 * User: MOD
 * Date: Nov 25, 2008
 * Time: 6:25:00 PM
 */
public class BigMathTest extends TimedTest
{
   @Test
   public void testSqrt()
   {
      int maxValues = 2;
      for (int i = 1; i <= maxValues; ++i)
      {
         double expected = Math.sqrt(i);
         BigDecimal actual = BigMath.sqrt(new BigDecimal(i));
         assertEquals("wrong square root for value " + i, expected, actual.doubleValue(), BigMath.DEFAULT_ERROR.doubleValue());
      }
   }
}
