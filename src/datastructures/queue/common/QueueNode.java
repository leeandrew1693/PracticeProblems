package datastructures.queue.common;

/**
 * Created by andrew on 2/3/17.
 */
public class QueueNode<E> {
    private QueueNode nextNode;
    private E data;

    public QueueNode(final E data) {
        this.data = data;
    }

    public QueueNode(final E data, final QueueNode nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public QueueNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(final QueueNode node) {
        nextNode = node;
    }

    public E getData() {
        return data;
    }

    public void setData(final E data) {
        this.data = data;
    }
}
