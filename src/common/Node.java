package common;

/**
 * Created by andrew on 1/27/17.
 */
public class Node<E> {
    private Node previousNode;
    private E data;

    public Node(final E data) {
        this.data = data;
    }

    public Node(final E data, final Node previousNode) {
        this.data = data;
        this.previousNode = previousNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(final Node node) {
        previousNode = node;
    }

    public E getData() {
        return data;
    }

    public void setData(final E data) {
        this.data = data;
    }
}
