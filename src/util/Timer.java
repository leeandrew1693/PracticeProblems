package util;

import java.util.concurrent.Callable;

/**
 * Created by andrew on 1/29/17.
 */
public class Timer {
    public static <T> T time(Callable<T> code) throws Exception {
        long startTime = System.nanoTime();
        T result = code.call();
        long endTime = System.nanoTime();

        System.out.println("It took " + (endTime - startTime)/1000/1000+ " milliseconds to finish");
        System.out.println("It took " + (endTime - startTime)+ " nanoseconds to finish");
        return result;
    }

    public static void main(String args[] ) {
        int i = 10;
        int j = 10;
        System.out.println(String.format("i: %s    j:%s", i, j));
        System.out.println(String.format("i: %s    j:%s", i--, j++));
        System.out.println(String.format("i: %s    j:%s", i, j));
        System.out.println(String.format("i: %s    j:%s", --i, ++j));
        System.out.println(String.format("i: %s    j:%s", i, j));
    }
}
