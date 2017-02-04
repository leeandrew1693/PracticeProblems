package datastructures.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by andrew on 2/3/17.
 */
public class QueueTest {
    Queue queue = new GenericQueue();

    @Before
    public void setup() {

    }

    @Test
    public void testEnqueue() throws Exception {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        Assert.assertEquals(4, queue.size());
        Assert.assertEquals(1, (int) queue.dequeue());
        Assert.assertEquals(3, queue.size());
        Assert.assertEquals(2, (int) queue.dequeue());
        Assert.assertEquals(2, queue.size());
        Assert.assertEquals(3, (int) queue.dequeue());
        Assert.assertEquals(1, queue.size());
        Assert.assertEquals(4, (int) queue.dequeue());
        Assert.assertEquals(0, queue.size());
    }
}
