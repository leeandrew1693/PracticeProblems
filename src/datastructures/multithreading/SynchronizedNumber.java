package datastructures.multithreading;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by andrew on 2/8/17.
 */
public class SynchronizedNumber {
    AtomicInteger number = new AtomicInteger(2);

    Set<String> asdf = new HashSet<>();
    public synchronized void setNumber(int i) {
        number.set(i);
    }

    public synchronized void increment(){
        number.getAndAdd(number.get());
    }

    public synchronized void decrement() {
//        number--;
    }

    public synchronized int get() {
        return number.get();
    }
}
