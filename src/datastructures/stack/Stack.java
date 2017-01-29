package datastructures.stack;

import common.Node;

/**
 * Created by andrew on 1/28/17.
 */
public interface Stack {
    Node headNode = null;

    public Object pop();
    public void push(final Object object) throws Exception;
    public Object peek();

    public default void printStack() {
        Node node = headNode;
        while(node != null) {
            System.out.println(node.getData().toString());
            node = node.getPreviousNode();
        }
    }
}
