package datastructures.stack.common;

import datastructures.stack.common.StackNode;

/**
 * Created by andrew on 1/28/17.
 */
public interface Stack {
    public Object pop();
    public void push(final Object object);
    public Object peek();
    public int size();
    public String stackVariables();
    public boolean isEmpty();
}
