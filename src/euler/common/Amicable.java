package euler.common;

/**
 * Amicable number pair
 * User: MOD
 * Date: Nov 25, 2008
 * Time: 2:53:13 PM
 */
public class Amicable implements Comparable {
    private long a;
    private long b;

    public Amicable(long a, long b) {
        if ((a <= 0) || (b <= 0))
            throw new IllegalArgumentException("values must be positive");

        this.a = a;
        this.b = b;
    }

    public long getA() {
        return a;
    }

    public long getB() {
        return b;
    }

    public int compareTo(Object o) {
        int value;

        Amicable other = (Amicable) o;

        if (this.getA() < other.getA())
            value = -1;
        else if (this.getA() > other.getA())
            value = 1;
        else
            value = 0;

        return value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Amicable amicable = (Amicable) o;

        return ((a == amicable.a) && (b == amicable.b));

    }

    public int hashCode() {
        int result;

        result = (int) (a ^ (a >>> 32));
        result = 31 * result + (int) (b ^ (b >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("{").append("a=").append(a).append(", b=").append(b).append('}').toString();
    }
}
