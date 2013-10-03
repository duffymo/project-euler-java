package euler.common;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import euler.TimedTest;
import euler.common.CollatzSequence;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CollatzSequenceTest
 * User: MOD
 * Date: Nov 24, 2008
 * Time: 2:03:50 PM
 */
public class CollatzSequenceTest extends TimedTest
{
   @Test
   public void testCollatz()
   {
      List<Long> expected = Arrays.asList(13L,40L,20L,10L,5L,16L,8L,4L,2L,1L);
      List<Long> actual = CollatzSequence.collatz(13L);
      
      assertEquals(expected, actual);
   }

   @Test
   public void testSloan()
   {
      //http://www.research.att.com/~njas/sequences/table?a=6577&fmt=4
      long [] expected =
      {
         0, 1, 7, 2, 5, 8, 16, 3, 19, 6,
         14, 9, 9, 17, 17, 4, 12, 20, 20, 7,
         7, 15, 15, 10, 23, 10, 111, 18, 18, 18,
         106, 5, 26, 13, 13, 21, 21, 21, 34, 8,
         109, 8, 29, 16, 16, 16, 104, 11, 24, 24,
         24, 11, 11, 112, 112, 19, 32, 19, 32, 19,
         19, 107, 107, 6, 27, 27, 27, 14, 14, 14,
         102, 22,
      };

      for (int i = 0; i < expected.length; ++i)
      {
         List<Long> actual = CollatzSequence.collatz((long)(i+1));
         assertEquals("wrong chain length for starting value = " + i+1, (expected[i]+1), actual.size());
      }
   }

   @Test
   public void testAtt() throws IOException
   {
      // see http://www.research.att.com/~njas/sequences/b006577.txt
      Map<Integer, Integer> expected = readExpected("data/Problem14.in");
      Multimap<Integer, Integer> lengths = HashMultimap.create();
      for (Integer start : expected.keySet())
      {
         List<Long> actual = CollatzSequence.collatz(start);
         assertEquals("wrong chain length for starting value = " + start, (expected.get(start)+1), actual.size());
         lengths.put(actual.size(), start);
      }
   }

   @Test
   public void testXkcd()
   {
      // http://forums.xkcd.com/viewtopic.php?f=11&t=5123
      long start = 837799L;
      List<Long> solution = CollatzSequence.collatz(start);
      System.out.println("start=" + start + " length=" + solution.size() + " chain=" + solution);
   }

   private static Map<Integer, Integer> readExpected(String path) throws IOException
   {
      Map<Integer, Integer> expected = new HashMap<Integer, Integer>();
      BufferedReader br = null;

      try
      {
         br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
         String line;

         while ((line = br.readLine()) != null)
         {
            if ((line != null) && (line.trim().length() > 0))
            {
               String [] tokens = line.split("\\s+");
               expected.put(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
            }
         }
      }
      finally
      {
         close(br);
      }

      return expected;
   }

   private static void close(BufferedReader br)
   {
      try
         {
            if (br != null)
         {
            br.close();
         }
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }
}
