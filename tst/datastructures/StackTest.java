package datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrew on 1/27/17.
 */
public class StackTest {
    private Stack stack = new Stack("someObject");

    @Before
    public void setUp() {
    }

    @Test
    public void testStackPop() {
        assertEquals("someObject", stack.pop().getData());
    }

    @Test
    public void testStackPush() {
        stack.push(1);
        assertEquals(1, stack.peek());
        stack.push(false);
        assertEquals(false, stack.peek());
        stack.push("test");
        assertEquals("test", stack.peek());
    }
}
