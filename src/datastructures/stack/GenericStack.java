package datastructures.stack;

import common.Node;

/**
 * Created by andrew on 1/27/17.
 */
public class GenericStack implements Stack {
    protected Node headNode;
    private int size = 0;

    public GenericStack() {
        this.headNode = null;
    }

    public GenericStack(final Object object) {
        this.size = 1;
        this.headNode = new Node(object);
    }

    public GenericStack(final Node headNode) {
        this.size = 1;
        this.headNode = headNode;
    }

    @Override
    public Object peek() {
        return headNode.getData();
    }

    @Override
    public Object pop() {
        if(headNode == null) {
            return null;
        }
        size--;
        final Node currentNode = headNode;
        headNode = headNode.getPreviousNode();
        return currentNode.getData();
    }

    @Override
    public void push(final Object object) {
        size++;
        final Node node = new Node(object);
        node.setPreviousNode(headNode);
        headNode = node;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String stackVariables() {
        Node node = headNode;
        final StringBuilder stringBuilder = new StringBuilder();
        while(node != null) {
            stringBuilder.append(node.getData().toString() + '\t');
            node = node.getPreviousNode();
        }
        return stringBuilder.toString();
    }
}
