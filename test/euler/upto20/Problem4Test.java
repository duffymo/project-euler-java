package euler.upto20;

import org.junit.Test;
import euler.upto20.Problem4;
import euler.TimedTest;

/**
 * EulerProblem4Test
 * User: MOD
 * Date: Oct 12, 2008
 * Time: 11:24:50 AM
 */
public class Problem4Test extends TimedTest
{
   @Test
   public void testIsPalidrome()
   {
      Problem4 euler4 = new Problem4();

      String [] palindromes =
      {
         "9009",
         "123321",
         "45455454",
         "A man, a plan, a canal: Panama.",
         "  1221   ",
      };

      String [] notPalindromes =
      {
         null,
         "",
         "   ",
         "Michael Owen Duffy",
         "0123456789"
      };

      for (int i = 0; i < palindromes.length; ++i)
      {
         assertTrue(("failed to find palindrome for '" + palindromes[i] + "'"), euler4.isPalindrome(palindromes[i]));
      }

      for (int i = 0; i < notPalindromes.length; ++i)
      {
         assertTrue(("found incorrect palindrome for '" + notPalindromes[i] + "'"), !euler4.isPalindrome(notPalindromes[i]));
      }
   }

   @Test
   public void testFindLongestPalindrome_2Digits()
   {
      Problem4 euler4 = new Problem4();

      int digits = 2;
      String expected = "9009";

      assertEquals(expected, euler4.findLongestPalindrome(digits));
   }


   @Test
   public void testFindLongestPalindrome_3Digits()
   {
      Problem4 euler4 = new Problem4();

      int digits = 3;
      String expected = "906609";  // i = 993, j = 913

      assertEquals(expected, euler4.findLongestPalindrome(digits));
   }
}
