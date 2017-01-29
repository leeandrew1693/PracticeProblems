package datastructures;

import common.Node;

/**
 * Created by andrew on 1/27/17.
 */
public class Stack {
    private Node headNode;

    public Stack(final Object object) {
        this.headNode = new Node(object);
    }

    public Stack(final Node headNode) {
        this.headNode = headNode;
    }

    public Object peek() {
        return headNode.getData();
    }

    public Node pop() {
        final Node currentNode = headNode;
        headNode = headNode.getPreviousNode();
        return currentNode;
    }

    public void push(final Object object) {
        final Node node = new Node(object);
        node.setPreviousNode(headNode);
        headNode = node;
    }

    public void printStack() {
        Node node = headNode;
        while(node != null) {
            System.out.println(node.getData().toString());
            node = node.getPreviousNode();
        }
    }
}
