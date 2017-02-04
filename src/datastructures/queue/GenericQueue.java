package datastructures.queue;

import datastructures.queue.common.QueueNode;

import java.util.Objects;

/**
 * Created by andrew on 2/3/17.
 */
public class GenericQueue implements Queue{
    private QueueNode head;
    private QueueNode tail;
    private int size;

    public GenericQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public GenericQueue(Object o){
        this.head = new QueueNode(o);
        this.tail = new QueueNode(o);
        this.size = 1;
    }

    @Override
    public void enqueue(final Object o) {
        final QueueNode node = new QueueNode(o);
        if(tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNextNode(node);
            tail = node;
        }

        size++;
    }

    @Override
    public Object dequeue() {
        if(head == null) {
            return null;
        } else {
            final QueueNode returnedNode = head;
            head = head.getNextNode();
            size --;
            return returnedNode.getData();
        }
    }

    @Override
    public int size() {
        return size;
    }
}
