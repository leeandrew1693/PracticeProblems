package recursion;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by andrew on 3/12/17.
 */
public class StackOfBoxesTest {
    @Test
    public void happyCaseTest() {
        StackOfBoxes.Box box1 = new StackOfBoxes.Box(5,5,5);
        StackOfBoxes.Box box2 = new StackOfBoxes.Box(4,4,4);
        StackOfBoxes.Box box3 = new StackOfBoxes.Box(3,3,3);
        StackOfBoxes.Box box4 = new StackOfBoxes.Box(2,2,2);
        StackOfBoxes.Box[] input = new StackOfBoxes.Box[]{box1, box2, box3, box4};
        Assert.assertEquals(14, StackOfBoxes.getMaxHeight(input));
    }

    @Test
    public void happyCaseTestUnordered() {
        StackOfBoxes.Box box1 = new StackOfBoxes.Box(5,5,5);
        StackOfBoxes.Box box2 = new StackOfBoxes.Box(4,4,4);
        StackOfBoxes.Box box3 = new StackOfBoxes.Box(3,3,3);
        StackOfBoxes.Box box4 = new StackOfBoxes.Box(2,2,2);
        StackOfBoxes.Box[] input = new StackOfBoxes.Box[]{box4, box3, box2, box1};
        Assert.assertEquals(14, StackOfBoxes.getMaxHeight(input));
    }

    @Test
    public void extremeCaseTest() {
        StackOfBoxes.Box box1 = new StackOfBoxes.Box(5,5,5);
        StackOfBoxes.Box box2 = new StackOfBoxes.Box(4,4,4);
        StackOfBoxes.Box box3 = new StackOfBoxes.Box(3,3,3);
        StackOfBoxes.Box box4 = new StackOfBoxes.Box(2,99,2);
        StackOfBoxes.Box[] input = new StackOfBoxes.Box[]{box4, box3, box2, box1};
        Assert.assertEquals(99, StackOfBoxes.getMaxHeight(input));
    }
}
