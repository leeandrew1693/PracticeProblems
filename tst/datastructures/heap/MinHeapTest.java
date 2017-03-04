package datastructures.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by andrew on 2/19/17.
 */
public class MinHeapTest {
    MinHeap minHeap;
    @Before
    public void setUp() {
        minHeap = new MinHeap(20);
    }

    @Test
    public void basicTest() {
        minHeap.insert(9);
        Assert.assertEquals(9, minHeap.peekMin());
        minHeap.insert(8);
        Assert.assertEquals(8, minHeap.peekMin());
        minHeap.insert(7);
        Assert.assertEquals(7, minHeap.peekMin());
        minHeap.insert(6);
        Assert.assertEquals(6, minHeap.peekMin());
        minHeap.insert(5);
        Assert.assertEquals(5, minHeap.peekMin());
        minHeap.extractMin();
        Assert.assertEquals(6, minHeap.peekMin());
        minHeap.extractMin();
        Assert.assertEquals(7, minHeap.peekMin());
        minHeap.extractMin();
        Assert.assertEquals(8, minHeap.peekMin());
        minHeap.extractMin();
        Assert.assertEquals(9, minHeap.peekMin());
    }
}
