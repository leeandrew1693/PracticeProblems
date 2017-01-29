package datastructures.stack;

import common.Node;

/**
 * Stack with min retrieval time of O(1)
 */
public class MinStack implements Stack{
    protected Node headNode;
    private int size = 0;

    private GenericStack minStack;

    public MinStack() {
        this.size = 0;
        this.headNode = null;
        minStack = new GenericStack();
    }

    public MinStack(final int value) {
        this.size = 1;
        this.headNode = new Node(value);
        minStack = new GenericStack(value);
    }

    @Override
    public Object pop() {
        if(headNode == null) {
            return null;
        }

        size--;
        final Node currentNode = headNode;
        headNode = headNode.getPreviousNode();

        if((int) currentNode.getData() == (int) minStack.peek()) {
            minStack.pop();
        }

        return currentNode.getData();
    }

    @Override
    public void push(final Object object) throws Exception {
        size++;
        if(!(object instanceof  Integer) || object == null) {
            throw new Exception("Invalid input. Value must be int");
        }

        final int value =  (int) object;
        final Node node = new Node(value);
        node.setPreviousNode(headNode);
        headNode = node;

        if(minStack.size() == 0 || (int) minStack.peek() >= value) {
            minStack.push(value);
        }
    }

    @Override
    public Object peek() {
        return headNode.getData();
    }

    public int min() {
        return (int) minStack.peek();
    }

    public int size() {
        return size;
    }
}
