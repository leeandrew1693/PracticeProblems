package datastructures.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by andrew on 2/5/17.
 */
public class SetOfStacksTest {
    private SetOfStacks setOfStacks = new SetOfStacks();

    @Before
    public void setUp() {
    }

    @Test
    public void testStackPopSimple() throws Exception {
        setOfStacks.push(1);
        Assert.assertEquals(1, setOfStacks.peek());
        setOfStacks.push(false);
        Assert.assertEquals(false, setOfStacks.peek());
        setOfStacks.push("test");
        Assert.assertEquals("test", setOfStacks.peek());
        setOfStacks.push(1);
        Assert.assertEquals(1, setOfStacks.peek());
        setOfStacks.push(false);
        Assert.assertEquals(false, setOfStacks.peek());
        setOfStacks.push("test");
        Assert.assertEquals("test", setOfStacks.peek());

        Assert.assertEquals("test", setOfStacks.pop());
        Assert.assertEquals(false, setOfStacks.pop());
        Assert.assertEquals(1, setOfStacks.pop());
        Assert.assertEquals("test", setOfStacks.pop());
        Assert.assertEquals(false, setOfStacks.pop());
        Assert.assertEquals(1, setOfStacks.pop());
    }
    @Test
    public void testStackPopExtensive() throws Exception {
        final int NUM_ITERATIONS = 100;
        for(int i =0 ;i < NUM_ITERATIONS ; i++) {
            setOfStacks.push(1);
            Assert.assertEquals(1, setOfStacks.peek());
            setOfStacks.push(false);
            Assert.assertEquals(false, setOfStacks.peek());
            setOfStacks.push("test");
            Assert.assertEquals("test", setOfStacks.peek());
        }

        for(int i = 0; i < NUM_ITERATIONS ; i++) {
            Assert.assertEquals("test", setOfStacks.pop());
            Assert.assertEquals(false, setOfStacks.pop());
            Assert.assertEquals(1, setOfStacks.pop());
        }
    }

    @Test
    public void testStackPush() throws Exception {
        setOfStacks.push(1);
        Assert.assertEquals(1, setOfStacks.peek());
        setOfStacks.push(false);
        Assert.assertEquals(false, setOfStacks.peek());
        setOfStacks.push("test");
        Assert.assertEquals("test", setOfStacks.peek());
        setOfStacks.push(1);
        Assert.assertEquals(1, setOfStacks.peek());
        setOfStacks.push(false);
        Assert.assertEquals(false, setOfStacks.peek());
        setOfStacks.push("test");
        Assert.assertEquals("test", setOfStacks.peek());
        setOfStacks.push(1);
        Assert.assertEquals(1, setOfStacks.peek());
        setOfStacks.push(false);
        Assert.assertEquals(false, setOfStacks.peek());
        setOfStacks.push("test");
        Assert.assertEquals("test", setOfStacks.peek());
    }

    @Test
    public void testSize() throws Exception {
        setOfStacks.push(1);
        setOfStacks.push(1);
        setOfStacks.push(1);
        Assert.assertEquals(setOfStacks.size(), 3);
    }
}
