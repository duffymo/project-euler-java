package euler.upto20;

import java.math.BigInteger;

/**
 * Problem16
 * <pre>
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 * </pre>
 * <pre>
 * 2^1000 = 10715086071862673209484250490600018105614048117055336074437503883703510511249361224931983788156958581275946729175531468251871452856923140435984577574698574803934567774824230985421074605062371141877954182153046474983581941267398767559165543946077062914571196477686542167660429831652624386837205668069376
 * length = 302
 * sum = 1366
 * </pre>
 * User: MOD
 * Date: Oct 15, 2008
 * Time: 11:05:21 PM
 */
public class Problem16 {
    public static void main(String[] args) {
        BigInteger x = new BigInteger("2");
        BigInteger y = x.pow(1000);
        String f = y.toString();

        System.out.println("2^1000 = " + f);
        System.out.println("length = " + f.length());
        System.out.println("sum = " + Problem20.sumOfDigits(f));
    }
}
