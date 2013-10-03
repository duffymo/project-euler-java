package euler.upto20;

import euler.common.CheckWriter;

import java.util.Set;
import java.util.TreeSet;

/**
 * Problem17
 * <pre>
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains
 * 20 letters. The use of "and" when writing out numbers is in compliance
 * with British usage.
 * </pre>
 * <code>
 * total # characters : 21124
 * # unique characters: 18
 * characters: [a, d, e, f, g, h, i, l, n, o, r, s, t, u, v, w, x, y]
 * </code>
 * User: MOD
 * Date: Nov 24, 2008
 * Time: 12:47:33 PM
 * @link http://projecteuler.net/index.php?section=problems&id=17
 */
public class Problem17 {
    public static void main(String[] args) {
        Set<Character> characters = new TreeSet<Character>();
        CheckWriter checkWriter = new CheckWriter();
        long characterCount = 0;
        for (int i = 0; i < 1000; ++i) {
            long n = (long) (i + 1);
            String str = checkWriter.asWords(n, true);
            int nc = 0;
            for (int j = 0; j < str.length(); ++j) {
                Character c = str.charAt(j);
                if (!Character.isSpaceChar(c)) {
                    ++nc;
                    characters.add(str.charAt(j));
                }
            }
            System.out.println(str + " # chars = " + nc);
            characterCount += nc;
        }

        String and = "and";
        for (int j = 0; j < and.length(); ++j) {
            char c = and.charAt(j);
            characters.add(c);
        }

        System.out.println("total # characters : " + characterCount);
        System.out.println("# unique characters: " + characters.size());
        System.out.println("characters: " + characters);
    }
}
