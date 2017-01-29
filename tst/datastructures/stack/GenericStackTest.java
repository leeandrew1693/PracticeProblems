package datastructures.stack;

import datastructures.stack.GenericStack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrew on 1/27/17.
 */
public class GenericStackTest {
    private GenericStack genericStack = new GenericStack();

    @Before
    public void setUp() {
    }

    @Test
    public void testStackPop() {
        genericStack.push("someObject");
        assertEquals("someObject", genericStack.pop());
    }

    @Test
    public void testStackPush() {
        genericStack.push(1);
        assertEquals(1, genericStack.peek());
        genericStack.push(false);
        assertEquals(false, genericStack.peek());
        genericStack.push("test");
        assertEquals("test", genericStack.peek());
    }

    @Test
    public void testSize() {
        genericStack.push(1);
        genericStack.push(1);
        genericStack.push(1);
        assertEquals(genericStack.size(), 3);
    }
}
