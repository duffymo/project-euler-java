package euler.upto20;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import euler.common.CheckWriter;

/**
 * Problem17Test
 * User: MOD
 * Date: Oct 21, 2008
 * Time: 8:49:55 PM
 */
public class Problem17Test
{
   private static final int DEFAULT_CAPACITY = 512;

   @Test
   public void testLessThanTen()
   {
      String[] expected =
            {
                  "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            };

      CheckWriter checkWriter = new CheckWriter();
      for (int i = 0; i < expected.length; ++i)
      {
         assertEquals(expected[i], checkWriter.asWords((i+1L)));
      }
   }

   @Test
   public void testTeens()
   {
      String[] expected =
            {
                  "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                  "sixteen", "seventeen", "eighteen", "nineteen",
            };

      CheckWriter checkWriter = new CheckWriter();
      for (int i = 0; i < expected.length; ++i)
      {
         assertEquals(expected[i], checkWriter.asWords(i + 11L));
      }
   }

   @Test
   public void testLessThanOneHundred()
   {
      String[] expectedTens =
      {
         "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety",
      };

      String[] expectedOnes =
      {
         "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
      };

      CheckWriter checkWriter = new CheckWriter();
      for (int i = 0; i < expectedTens.length; ++i)
      {
         for (int j = 0; j < expectedOnes.length; ++j)
         {
            StringBuilder builder = new StringBuilder(DEFAULT_CAPACITY);
            builder.append(expectedTens[i]).append(' ').append(expectedOnes[j]);
            long n = 10L*(i+2L)+j;
            String actual = checkWriter.asWords(n);
            assertEquals(builder.toString().trim(), actual);
         }
      }
   }

   @Test
   public void testLessThanOneThousand()
   {
      String[] expectedTens =
      {
         "", "ten", "twenty", "thirty", "forty", "fifty",
         "sixty", "seventy", "eighty", "ninety",
      };

      String[] expectedOnes =
      {
         "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
      };

      CheckWriter checkWriter = new CheckWriter();
      for (int k = 1; k < expectedOnes.length; ++k)
      {
         for (int i = 0; i < expectedTens.length; ++i)
         {
            for (int j = 0; j < expectedOnes.length; ++j)
            {
               long n = 100L*k + 10L*i + j;
               String actual = checkWriter.asWords(n);
               System.out.println("n=" + n + " actual=" + actual);
            }
         }
      }
   }

   @Test
   public void testNationalDebt()
   {
      // As of Wed 22-Oct-2008
      // See http://www.brillig.com/debt_clock/
      long debt = 10471798673474L;
//      long debt = 10,471,798,673,474L;
      String expected = "ten trillion four hundred seventy one billion seven "
      + "hundred ninety eight million six hundred seventy three thousand four hundred seventy four";

      CheckWriter checkWriter = new CheckWriter();
      String actual = checkWriter.asWords(debt, false);
      assertEquals(("debt is " + debt), expected, actual);
   }
}

