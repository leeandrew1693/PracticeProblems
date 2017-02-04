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
    public void testStackPop() throws Exception {
        genericStack.push("someObject");
        assertEquals("someObject", genericStack.pop());
    }

    @Test
    public void testStackPush() throws Exception {
        genericStack.push(1);
        assertEquals(1, genericStack.peek());
        genericStack.push(false);
        assertEquals(false, genericStack.peek());
        genericStack.push("test");
        assertEquals("test", genericStack.peek());
    }

    @Test
    public void testSize() throws Exception {
        genericStack.push(1);
        genericStack.push(1);
        genericStack.push(1);
        assertEquals(genericStack.size(), 3);
    }
}
