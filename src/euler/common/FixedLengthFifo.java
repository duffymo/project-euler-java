package euler.common;

import java.util.ArrayList;
import java.util.List;

/**
 * FixedLengthFifo
 * User: Michael
 * Date: Oct 11, 2008
 * Time: 11:29:38 AM
 */
public class FixedLengthFifo<T> {
    private int maxLength;
    private List<T> fifo;

    public static void main(String[] args) {
        FixedLengthFifo<Integer> fifo = new FixedLengthFifo<Integer>(10);
        for (int i = 0; i < 15; ++i) {
            Integer head = fifo.add(i);
            System.out.println("fifo: " + fifo);
            System.out.println("head: " + head);
        }
    }

    public FixedLengthFifo(int maxLength) {
        this.maxLength = maxLength;
        this.fifo = new ArrayList<T>(maxLength);
    }

    public synchronized T add(T v) {
        T head = null;

        int fifoSize = this.fifo.size();
        if (fifoSize < maxLength) {
            // If the FIFO isn't full, add the value to the end;
            // no value to pop off.
            this.fifo.add(v);
        } else {
            // Pop off the head
            head = this.fifo.get(0);

            // Move everybody down one spot in the line.
            for (int i = 1; i < this.maxLength; ++i) {
                this.fifo.set(i - 1, this.fifo.get(i));
            }

            // Add the new value to the head of the line.
            this.fifo.set((this.maxLength - 1), v);
        }


        return head;
    }

    public T get(int index) {
        return this.fifo.get(index);
    }

    public String toString() {
        return new StringBuilder().append("euler.common.FixedLengthFifo{").append("maxLength=").append(maxLength).append(", fifo=").append(fifo).append('}').toString();
    }
}


