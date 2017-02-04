package datastructures.queue;

import datastructures.queue.common.QueueNode;

/**
 * Created by andrew on 2/3/17.
 */
public interface Queue {
    public void enqueue(final Object node);
    public Object dequeue() throws Exception;
    public int size();
}
