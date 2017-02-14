package datastructures.multithreading;

/**
 * Created by andrew on 2/7/17.
 */
public class TestRunnable implements Runnable {
    final private String name;
    final private long sleepTime;
    final private SynchronizedNumber number;

    public TestRunnable(final String name, final SynchronizedNumber number, final long sleepTime) {
        this.name = name;
        this.sleepTime = sleepTime;
        this.number = number;
    }
    @Override
    public void run() {
        number.increment();
        System.out.println(String.format("%s number: %d", name, number.get()));
        number.increment();
        System.out.println(String.format("%s number: %d", name, number.get()));
//        try {
//            System.out.println(String.format("%s starting", name));
//            Thread.sleep(sleepTime);
//            System.out.println(String.format("%s finished", name));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
