package euler.upto20;

import org.junit.Test;
import euler.upto20.Problem6;
import euler.TimedTest;

/**
 * Problem6Test
 * User: MOD
 * Date: Oct 13, 2008
 * Time: 7:28:57 PM
 */
public class Problem6Test extends TimedTest
{
   @Test
   public void testSumOfSquares()
   {
      int n = 10;
      long expected = 385L;

      assertEquals(expected, Problem6.sumOfSquares(n));
   }

   @Test
   public void testSquareOfSum()
   {
      int n = 10;
      long expected = 3025L;

      assertEquals(expected, Problem6.squareOfSum(n));
   }

   @Test
   public void testDiff()
   {
      int n = 10;
      long expected = 2640L;

      assertEquals(expected, Problem6.diff(n));
   }

   @Test
   public void testAnswer()
   {
      int n = 100;
      long expected = 25164150L;

      assertEquals(expected, Problem6.diff(n));
   }
}
