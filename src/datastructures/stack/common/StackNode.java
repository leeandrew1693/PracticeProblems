package datastructures.stack.common;

/**
 * Created by andrew on 1/27/17.
 */
public class StackNode<E> {
    private StackNode previousNode;
    private E data;

    public StackNode(final E data) {
        this.data = data;
    }

    public StackNode(final E data, final StackNode previousNode) {
        this.data = data;
        this.previousNode = previousNode;
    }

    public StackNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(final StackNode node) {
        previousNode = node;
    }

    public E getData() {
        return data;
    }

    public void setData(final E data) {
        this.data = data;
    }
}
