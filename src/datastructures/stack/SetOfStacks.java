package datastructures.stack;

import datastructures.stack.common.Stack;
import datastructures.stack.common.StackNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 2/5/17.
 */
public class SetOfStacks implements Stack {
    private static final int MAX_STACK_SIZE = 5;
    Stack stacks = new GenericStack();
    Stack headStack = null;
    int size = 0;

    public SetOfStacks() {
        this.size = 0;
        Stack stack = new GenericStack();
        this.headStack = stack;
    }

    public SetOfStacks(final Object object) throws Exception {
        this.size = 1;
        Stack stack = new GenericStack(new StackNode(object));
        this.headStack = stack;
    }

    public SetOfStacks(final StackNode stackNode) throws Exception {
        this.size = 1;
        Stack stack = new GenericStack(stackNode);
        this.headStack = stack;
    }

    @Override
    public Object pop() {
        if (headStack.size() > 0) {
            size --;
            return headStack.pop();
        } else if (headStack.size() == 0 && stacks.size() > 0) {
            size --;
            headStack = (Stack) stacks.pop();
            return headStack.pop();
        } else {
            return null;
        }
    }

    @Override
    public void push(final Object object) {
        if (headStack.size() >= MAX_STACK_SIZE) {
            stacks.push(headStack);
            headStack = new GenericStack();
        }
        headStack.push(object);
        size ++;
    }

    @Override
    public Object peek() {
        return headStack.peek();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String stackVariables() {
        Stack currentStack = headStack;
        final StringBuilder stringBuilder = new StringBuilder();
        while(currentStack != null) {
            stringBuilder.append(currentStack.stackVariables());
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }
}
