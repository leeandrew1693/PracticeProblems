package datastructures.stack;

import datastructures.stack.GenericStack;
import datastructures.stack.MinStack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrew on 1/27/17.
 */
public class MinStackTest {
    private MinStack minStack = new MinStack();

    @Before
    public void setUp() {
    }

    @Test
    public void testStackPop() {
        assertEquals(null, minStack.pop());
    }

    @Test
    public void testStackPush() throws Exception {
       minStack.push(1);
       assertEquals(1, minStack.peek());
       minStack.push(2);
       assertEquals(2, minStack.peek());
       minStack.push(3);
       assertEquals(3, minStack.peek());
    }

    @Test
    public void testSize() throws Exception {
        minStack.push(1);
        assertEquals(1, minStack.size());
        minStack.push(1);
        assertEquals(2, minStack.size());
        minStack.push(1);
        assertEquals(3, minStack.size());
        minStack.pop();
        assertEquals(2, minStack.size());
        minStack.pop();
        assertEquals(1, minStack.size());
    }

    @Test
    public void testMin() throws Exception {
        minStack.push(3);
        assertEquals(3, minStack.min());
        minStack.push(2);
        assertEquals(2, minStack.min());
        minStack.push(1);
        assertEquals(1, minStack.min());
        minStack.pop();
        assertEquals(2, minStack.min());
        minStack.pop();
        assertEquals(3, minStack.min());
    }

}
