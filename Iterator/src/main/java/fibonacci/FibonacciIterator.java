package fibonacci;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {

    private int previous = 0;
    private int current = 1;



    @Override
    public boolean hasNext() {
        return true;

    }

    @Override
    public Integer next() {
        int nextNumber = current;
        int newValue = previous + current;

        previous = current;
        current = newValue;

        return nextNumber;
    }
}