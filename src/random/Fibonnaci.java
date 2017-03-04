package random;

import util.Timer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by andrew on 2/19/17.
 */
public class Fibonnaci {
    static Map<Long, Long> cache = new HashMap<>();
    public static void main (final String args[]) throws Exception {
        int num = 190;
//        Callable recursive = () -> getFibonacci(num);
        Callable dynamic = () -> getFibonacciDynamic(num);
        Callable iterative = () -> getFibonacciIterative(num);
        System.out.println(getFibonacciDynamic(num));
//        Timer.time(recursive);
        Timer.time(dynamic);
        Timer.time(iterative);
    }

    public static long getFibonacciDynamic(final long num) {
        if(num == 0) {
            return 0;
        }
        if(num ==1) {
            return 1;
        }

        long nMinusOne;
        long nMinusTwo;
        if(cache.containsKey(num-1)) {
            nMinusOne = cache.get(num-1);
        } else {
            nMinusOne = getFibonacciDynamic(num-1);
            cache.put(num-1, nMinusOne);
        }

        if(cache.containsKey(num-2)){
            nMinusTwo = cache.get(num-2);
        } else {
            nMinusTwo = getFibonacciDynamic(num-2);
            cache.put(num-2, nMinusTwo);
        }

        return nMinusOne + nMinusTwo;
    }

    public static long getFibonacci(final long num) {
        if(num == 0) {
            return 0;
        }
        if(num ==1) {
            return 1;
        }

        return getFibonacci(num-1) + getFibonacci(num-2);
    }

    public static long getFibonacciIterative(final long num) {
        int x = 0, y = 1, z = 1;
        for (int i = 0; i < num; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return x;
    }
}
