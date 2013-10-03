package euler.upto40;

import euler.common.Fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem25
 * <pre>
 * The Fibonacci sequence is defined by the recurrence relation:
 * <p/>
 *  Fn = Fn1 + Fn2, where F1 = 1 and F2 = 1.
 * <p/>
 * Hence the first 12 terms will be:
 * <p/>
 *   F1 = 1
 *   F2 = 1
 *   F3 = 2
 *   F4 = 3
 *   F5 = 5
 *   F6 = 8
 *   F7 = 13
 *   F8 = 21
 *   F9 = 34
 *   F10 = 55
 *   F11 = 89
 *   F12 = 144
 * <p/>
 * The 12th term, F12, is the first term to contain three digits.
 * <p/>
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 * </pre>
 * <code>
 * n=4782 # digits=1000
 * fib(n)=1070066266382930626590180874906266514792777712532599215596653773394215666839495056916019656015924838503405059802257306589034096253159956936527993291210203280449454861705882275771269321610881214688386599288706486650309517199053675772531300864745069424583041125748377195037988926786418043926352363254735800643960140171931898721893616013295467163604866560488317306010329911295415832032844982923639118580337868196090258243240483135264859428493324231528042870373341509409408046646145929395675677123818625546933470694221086250773553858573429084051960299421522340671032968838308954908080094636886313063408173671779588139046160497201005516248714294689028548953433646463329631800323669127205424811310803655059036917778345975272461940307850618603149197248856826134613348154635040839044922825726721508083242981483092592853980123897562537191062222980047017139120580684135329181336705975226783402246184382509411617209874673270636201114163358902302185836137202780555948697303653534549391008146609785563240559113811
 * wall time=293.11 secs
 * </code>
 * User: MOD
 * Date: Nov 25, 2008
 * Time: 7:29:36 PM
 * @link http://projecteuler.net/index.php?section=problems&id=25
 */
public class Problem25 {
    private static final int INITIAL_CAPACITY = 50;
    private static final int START_VALUE = 4780;
    private static final int MAX_LENGTH = 1000;

    public static void main(String[] args) {
        long begTime = System.currentTimeMillis();

        List<BigInteger> fibs = new ArrayList<BigInteger>(INITIAL_CAPACITY);

        fibs.add(Fibonacci.fib(START_VALUE));
        fibs.add(Fibonacci.fib(START_VALUE + 1));
        int n = START_VALUE + 1;
        BigInteger fn2;
        for (int i = 0; i < INITIAL_CAPACITY; ++i) {
            BigInteger fn = fibs.get(i);
            BigInteger fn1 = fibs.get(i + 1);
            ++n;
            fn2 = fn.add(fn1);
            fibs.add(fn2);
            System.out.println("n=" + n + " # digits=" + fn2.toString().length() + " fib(n)=" + fn2);
            if (fn2.toString().length() >= MAX_LENGTH)
                break;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("wall time=" + (endTime - begTime) / 1000.0 + " secs");
    }
}
