package datastructures.stack.common;

import datastructures.stack.common.StackNode;

/**
 * Created by andrew on 1/28/17.
 */
public interface Stack {
    StackNode headNode = null;

    public Object pop();
    public void push(final Object object) throws Exception;
    public Object peek();
    public int size();
    public String stackVariables();
}
