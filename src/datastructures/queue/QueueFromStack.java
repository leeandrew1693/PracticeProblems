package datastructures.queue;

import datastructures.stack.GenericStack;
import datastructures.stack.common.Stack;

/**
 * Created by andrew on 2/6/17.
 */
public class QueueFromStack implements Queue{
    final Stack pushStack = new GenericStack();
    final Stack popStack = new GenericStack();
    int size = 0;

    public QueueFromStack() {

    }

    @Override
    public void enqueue(final Object node) {
        pushStack.push(node);
        size ++;
    }

    @Override
    public Object dequeue() {
        if(popStack.size() == 0 && pushStack.size() == 0) {
            return null;
        } else if (popStack.size() == 0 && pushStack.size() > 0) {
            transferStacks();
        }

        size--;
        return popStack.pop();
    }

    private void transferStacks() {
        while(pushStack.size() > 0) {
            popStack.push(pushStack.pop());
        }
    }

    @Override
    public int size() {
        return size;
    }
}
