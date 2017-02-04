package datastructures.stack;

import datastructures.stack.common.Stack;
import datastructures.stack.common.StackNode;

/**
 * Stack with min retrieval time of O(1)
 */
public class MinStack extends  GenericStack {
    protected StackNode headNode;
    private int size = 0;

    private GenericStack minStack;

    public MinStack() {
        this.size = 0;
        this.headNode = null;
        minStack = new GenericStack();
    }

    public MinStack(final int value) {
        this.size = 1;
        this.headNode = new StackNode(value);
        minStack = new GenericStack(value);
    }

    @Override
    public Object pop() {
        if(headNode == null) {
            return null;
        }

        size--;
        final StackNode currentNode = headNode;
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
        final StackNode node = new StackNode(value);
        node.setPreviousNode(headNode);
        headNode = node;

        if(minStack.size() == 0 || (int) minStack.peek() >= value) {
            minStack.push(value);
        }
    }

    public int min() {
        return (int) minStack.peek();
    }
}
