package euler.upto20;

/**
 * Problem9
 * <pre>
 * A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * </pre>
 * User: MOD
 * Date: Oct 13, 2008
 * Time: 7:50:09 PM
 * @link http://projecteuler.net/index.php?section=problems&id=9
 * @link http://mathworld.wolfram.com/PythagoreanTriple.html
 * @link http://www.cut-the-knot.org/pythagoras/PT_matrix.shtml
 * @link http://monad.nfshost.com/wordpress/?p=15
 * @link http://en.wikipedia.org/wiki/Pythagorean_triple#Other_formulae_for_generating_triples
 */
public class Problem9 {
    public static void main(String[] args) {
        int m;
        int n = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        // The Wikipedia solution got me there.
        // a= (m^2-N^2), b=2mn, c = (m^2+N^2)
        // for a+b+c = 1000, m = (500-m*m)/m
        // Answer: m = 20 n = 5 (a,b,c) = (375,200,425); abc = 31875000
        for (m = 1; m <= 22; ++m) {
            int msq = m * m;
            n = (500 - msq) / m;
            int nsq = n * n;
            a = msq - nsq;
            b = 2 * m * n;
            c = msq + nsq;
            // Getting this right was key.
            if ((a > 0) && (b > 0) && (c > 0) && (a * b * c > 0) && (a + b + c == 1000))
                System.out.println("m = " + m + " n = " + n + " (a,b,c) = (" + a + "," + b + "," + c + "); abc = " + a * b * c);
        }
    }
}
