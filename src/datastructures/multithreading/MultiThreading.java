package datastructures.multithreading;

/**
 * Created by andrew on 2/7/17.
 */
public class MultiThreading {
    public static void main(final String args[]) {
        SynchronizedNumber synchronizedNumber = new SynchronizedNumber();
        Runnable runnable = new TestRunnable("Thread 1", synchronizedNumber, 1000);
        Runnable runnable1 = new TestRunnable("Thread 2", synchronizedNumber, 2000);
        Runnable runnable2 = new TestRunnable("Thread 3", synchronizedNumber, 3000);
        Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        (new Thread(runnable2)).start();
        (new Thread(runnable1)).start();
        (new Thread(runnable)).start();
        (new Thread(new TestRunnable("Thread 4", synchronizedNumber, 1000))).start();
        (new Thread(new TestRunnable("Thread 5", synchronizedNumber, 1000))).start();
        (new Thread(new TestRunnable("Thread 6", synchronizedNumber, 1000))).start();
        (new Thread(new TestRunnable("Thread 7", synchronizedNumber, 1000))).start();
        (new Thread(new TestRunnable("Thread 8", synchronizedNumber, 1000))).start();
    }
}
