package euler.upto40;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Problem30Test
 * User: MOD
 * Date: Nov 26, 2008
 * Time: 7:41:44 PM
 */
public class Problem30Test
{
   @Test
   public void testIsEqualToSumOfDigitsToPower()
   {
      int [] v = { 1634, 8208, 9474, };

      for (int i = 0; i < v.length; ++i)
      {
         assertTrue("wrong result for value " + v[i], Problem30.isEqualToSumOfDigitsToPower(v[i], 4));
      }
   }
}
